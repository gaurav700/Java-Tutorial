import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);
}


class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getWeapon() { return weapon; }
    public void setWeapon(String weapon) { this.weapon = weapon; }

    public int getHitPoints() { return hitPoints; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        // order must match toString(): name, hitPoints, strength, weapon
        values.add(this.name);
        values.add(Integer.toString(this.hitPoints));
        values.add(Integer.toString(this.strength));
        values.add(this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            // guard each index to be safe
            if (savedValues.size() > 0) this.name = savedValues.get(0);
            if (savedValues.size() > 1) this.hitPoints = Integer.parseInt(savedValues.get(1));
            if (savedValues.size() > 2) this.strength = Integer.parseInt(savedValues.get(2));
            if (savedValues.size() > 3) this.weapon = savedValues.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hitPoints=" + hitPoints
                + ", strength=" + strength + ", weapon='" + weapon + "'}";
    }
}




class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    // getters only (per spec)
    public String getName() { return name; }
    public int getHitPoints() { return hitPoints; }
    public int getStrength() { return strength; }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        // order must match toString(): name, hitPoints, strength
        values.add(this.name);
        values.add(Integer.toString(this.hitPoints));
        values.add(Integer.toString(this.strength));
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            if (savedValues.size() > 0) this.name = savedValues.get(0);
            if (savedValues.size() > 1) this.hitPoints = Integer.parseInt(savedValues.get(1));
            if (savedValues.size() > 2) this.strength = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{name='" + name + "', hitPoints=" + hitPoints
                + ", strength=" + strength + "}";
    }
}


public class Main {

    public static void main(String[] args) {
        // --- Player demo ---
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim);
        saveObject(tim);

        // mutate and save again
        tim.setWeapon("Axe");
        tim.setHitPoints(8);
        System.out.println(tim);
        saveObject(tim);

        // simulate loading new values (order must match toString()/write())
        List<String> playerLoad = Arrays.asList("Tim", "12", "20", "Bow");
        loadObject(tim, playerLoad);
        System.out.println("After load -> " + tim);

        // --- Monster demo ---
        Monster wolf = new Monster("Werewolf", 20, 40);
        System.out.println(wolf);
        saveObject(wolf);

        List<String> monsterLoad = Arrays.asList("Vampire", "55", "90");
        loadObject(wolf, monsterLoad);
        System.out.println("After load -> " + wolf);
    }

    private static void saveObject(ISaveable objectToSave) {
        for (String s : objectToSave.write()) {
            System.out.println("Saving " + s + " to storage");
        }
    }

    private static void loadObject(ISaveable objectToLoad, List<String> data) {
        objectToLoad.read(data);
    }
}
