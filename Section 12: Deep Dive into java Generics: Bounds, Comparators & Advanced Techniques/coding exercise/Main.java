// Generic Class Challenge (Part 1): Building Reusable Structures
// Generic Class Challenge (Part 2): Finalizing Maps & Overviews

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

interface Mappable {
    void render();

    static double[] stringToLatLon(String location) {
        String[] splits = location.split(",");
        if (splits.length != 2) {
            throw new IllegalArgumentException("Location must be 'lat, lon': " + location);
        }
        double lat = Double.parseDouble(splits[0].trim());
        double lon = Double.parseDouble(splits[1].trim());
        return new double[]{lat, lon};
    }
}

abstract class Point implements Mappable {
    private final double[] location = new double[2];

    public Point(String location) {
        double[] parsed = Mappable.stringToLatLon(location);
        this.location[0] = parsed[0];
        this.location[1] = parsed[1];
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}

abstract class Line implements Mappable {
    private final double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (String l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }
}

class Park extends Point {
    private final String name;

    // <-- order is (name, location) to match how you construct it in main
    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " National Park";
    }
}

class River extends Line {
    private final String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " River";
    }
}

class Layer<T extends Mappable> {
    private final List<T> layerElements;

    public Layer(T[] layerElements) {
        this.layerElements = new ArrayList<>(List.of(layerElements));
    }

    @SafeVarargs
    public final void addElements(T... elements) {
        layerElements.addAll(List.of(elements));
    }

    public void renderLayer() {
        for (T element : layerElements) {
            element.render();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        var nationalUSParks = new Park[]{
            new Park("Yellowstone", "44.4882, -110.5916"),
            new Park("Grand Canyon", "36.1069, -112.1121"),
            new Park("Yosemite", "37.8651, -119.5383")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new River[]{
            new River("Mississipi", "47.2160, -95.2348", "29.1566, -89.2495", "35.1556, -90.0659"),
            new River("Missouri", "45.9239, -111.4983")
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);

        riverLayer.addElements(
            new River("Colorado", "40.1020, -74.9340", "34.5552, -114.4668"),
            new River("Delaware", "42.0006, -75.4889", "39.5637, -75.5682")
        );

        riverLayer.renderLayer();
    }
}
