package Source_code.code;


public record BaseballPlayer(String name, String position) implements Player{
    @Override
    public String toString() {
        return name + " (" + position + ")";
    }
}
