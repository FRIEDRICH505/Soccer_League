import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // pass the path to the file as a parameter
        File file = new File("C:\\Users\\FRIEDRICH\\Desktop\\Spring\\Soccer\\src\\results.txt");
        Scanner sc = null;
        String match, team1, team2;
        Integer iscore1, iscore2;

        String[] sides, l1, l2;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //    HashMap scoreboard = new HashMap();
        HashMap<String, Integer> scoreboard = new HashMap<String, Integer>();

        while (sc.hasNextLine()) {
            match = sc.nextLine(); // read one line into match variable
            sides = match.split(",");  // split this line on a comma

            l1 = sides[0].split(" ");
            team1 = l1[0];
            iscore1 = Integer.parseInt(l1[1]);  // skakel om na n integer

            l2 = sides[1].split(" ");
            team2 = l2[0];
            iscore2 = Integer.parseInt(l2[1]);

            // do the teams exist in the scoreboard yet?

            if (!scoreboard.containsKey(team1)) { // if the team does not exist in scoreboard
                scoreboard.put(team1, 0); // insert the team in scoreboard with 0
            }

            if (!scoreboard.containsKey(team2)) { // if the team already exists
                scoreboard.put(team2, 0); // Team's first match - so  league score
            }
            // update the scoreboard
            if (iscore1 > iscore2) {
                scoreboard.put(team1, scoreboard.get(team1) + 3);
            } else if ((iscore2 > iscore1)) {
                scoreboard.put(team2, scoreboard.get(team2) + 3);
            } else { // a draw
                scoreboard.put(team1, scoreboard.get(team1) + 1);
                scoreboard.put(team2, scoreboard.get(team2) + 1);
            }
        }
        System.out.println(scoreboard);
    }
}
