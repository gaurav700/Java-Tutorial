package Source_code;
import Source_code.code.SportsTeam;
import Source_code.code.FootballPlayer;
import Source_code.code.BaseballPlayer;

public class Main {

    public static void main(String[] args) {
        SportsTeam footballTeam1 = new SportsTeam("Dallas Cowboys1");
        SportsTeam footballTeam2 = new SportsTeam("Dallas Cowboys2");

        var tex1 = new FootballPlayer("Tex walker1", "centre half forward");
        footballTeam1.addTeamMember(tex1);
        footballTeam1.listTeamMembers();
        var tex2 = new FootballPlayer("Tex walker2", "centre half forward");
        footballTeam2.addTeamMember(tex2);
        footballTeam2.listTeamMembers();


        SportsTeam baseballTeam1 = new SportsTeam("New York Yankees1");
        SportsTeam baseballTeam2 = new SportsTeam("New York Yankees2");

        var mike1 = new BaseballPlayer("Mike Harper1", "Pitcher");
        baseballTeam1.addTeamMember(mike1);
        baseballTeam1.listTeamMembers();
        var mike2 = new BaseballPlayer("Mike Harper2", "Pitcher");
        baseballTeam2.addTeamMember(mike2);
        baseballTeam2.listTeamMembers();

        scoreResult(footballTeam1, footballTeam2, 4, 7);
        scoreResult(baseballTeam1, baseballTeam2, 2, 0);

    }

    public static void scoreResult(SportsTeam team1, SportsTeam team2, int t1_score, int t2_score) {
        String result = team1.setScore(t1_score, t2_score);
        System.out.printf("%s %s %s%n", team1, result, team2);
    
        // Also update team2's score to keep records balanced
        team2.setScore(t2_score, t1_score);
    }
    
}
