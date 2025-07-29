package Source_code.code;

public record FootballPlayer(String name, String position) implements Player{
    @Override
    public String toString() {
        return name + " (" + position + ")";
    }
}