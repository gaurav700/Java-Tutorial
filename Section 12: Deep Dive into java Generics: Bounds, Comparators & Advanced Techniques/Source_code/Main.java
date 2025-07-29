package Source_code;
import Source_code.code.SportsTeam;
import Source_code.code.FootballPlayer;
import Source_code.code.BaseballPlayer;

public class Main {

    public static void main(String[] args) {
        SportsTeam footballTeam = new SportsTeam("Dallas Cowboys");
        SportsTeam baseballTeam = new SportsTeam("New York Yankees");

        var tex = new FootballPlayer("Tex walker", "centre half forward");
        footballTeam.addTeamMember(tex);
        footballTeam.listTeamMembers();

        var mike = new BaseballPlayer("Mike Harper", "Pitcher");
        baseballTeam.addTeamMember(mike);
        baseballTeam.listTeamMembers();

    }

    public static void scoreResult(SportsTeam team1, SportsTeam team2, int t1_score, int t2_score) {
        String result = team1.setScore(t1_score, t2_score);
        System.out.printf("%s %s %s%n", team1, result, team2);
    
        // Also update team2's score to keep records balanced
        team2.setScore(t2_score, t1_score);
    }
    
}
