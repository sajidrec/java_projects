package cricketcalculator;

import java.util.Scanner;

public class Menu {

    static void Decision() {
        int overs;
        Scanner sc = new Scanner(System.in);

        Team teamA, teamB;
        teamA = new Team();
        teamB = new Team();

        System.out.println("Enter home team name -> ");
        teamA.setName(sc.nextLine().toUpperCase());
        System.out.println("Enter guest team name -> ");
        teamB.setName(sc.nextLine().toUpperCase());

        System.out.println("Enter match length in overs ->");
        overs = sc.nextInt();

        System.out.println("Which team will bat first ->");
        System.out.println("1. " + teamA.getName() + " or 2. " + teamB.getName());
        int d = sc.nextInt();
        while (d != 1 && d != 2) {
            System.out.println("Enter a valid input 1 or 2");
            d = sc.nextInt();
        }

        if (d == 1) {
            teamA.setBattingStatus(true);
        } else {
            teamB.setBattingStatus(true);
        }

        short innings = 0;
        int curOver = 0, curBall = 0;

        while (innings < 2) {
            System.out.println("Choose what happend");
            System.out.println("0. Dot ball");
            System.out.println("1. 1 run added to the score");
            System.out.println("2. 2 run added to the score");
            System.out.println("3. 3 run added to the score");
            System.out.println("4. 4 run added to the score");
            System.out.println("5. 6 run added to the score");
            System.out.println("6. wicket");
            System.out.println("7. wideball");
            System.out.println("8. noball");
            System.out.println("9. Extra run (without counting ball)");
            System.out.println("10. Extra run (counting ball)");

            if (teamA.getBattingStatus()) {
                curBall += calculation(teamA);
                if (curBall % 6 == 0) {
                    curOver++;
                    curBall = 0;
                }
                System.out.println("=====================================");
                System.out.println(teamA.getName() + " " + teamA.getScore() + "/" + teamA.getWicket() + " Overs : " + curOver + "." + curBall);
                System.out.println("=====================================");
                // deciison
                if (teamA.getWicket() == 10 || curOver == overs
                        || (innings == 1 && teamA.getScore() > teamB.getScore())) {
                    curOver = curBall = 0;
                    innings++;
                    teamA.setBattingStatus(false);
                    teamB.setBattingStatus(true);
                    System.out.println("");
                    System.out.println("End of " + innings + " innings.");
                    System.out.println("");
                }
            } else {
                curBall += calculation(teamB);
                
                if (curBall % 6 == 0 && curBall != 0) {
                    curOver++;
                    curBall = 0;
                }
                System.out.println("=====================================");
                System.out.println(teamB.getName() + " " + teamB.getScore() + "/" + teamB.getWicket() + " Overs : " + curOver + "." + curBall);
                System.out.println("=====================================");
                // decision
                if (teamB.getWicket() == 10 || curOver == overs
                        || (innings == 1 && teamB.getScore() > teamA.getScore())) {
                    curOver = curBall = 0;
                    innings++;
                    teamB.setBattingStatus(false);
                    teamA.setBattingStatus(true);
                    System.out.println("");
                    System.out.println("End of " + innings + " innings.");
                    System.out.println("");
                }
            }

        }

        System.out.println("Match is over.");
        System.out.println("");
        System.out.println("=====================================");
        if (teamA.getScore() > teamB.getScore()) {
            System.out.println(teamA.getName() + " wins the game.");
        } else if (teamA.getScore() < teamB.getScore()) {
            System.out.println(teamB.getName() + " wins the game.");
        } else {
            System.out.println("It's a draw !!");
        }
        System.out.println("=====================================");

    }

    private static int calculation(Team t) {

        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();

        if (d == 0) {
            t.addScore(0);
        } else if (d == 1) {
            t.addScore(1);
        } else if (d == 2) {
            t.addScore(2);
        } else if (d == 3) {
            t.addScore(3);
        } else if (d == 4) {
            t.addScore(4);
        } else if (d == 5) {
            t.addScore(6);
        } else if (d == 6) {
            t.fallOfWicket();
        } else if (d == 7) {
            t.addScore(1);
        } else if (d == 8) {
            t.addScore(1);
        } else if (d == 9 || d == 10) {
            System.out.println("How much extra run?");
            Scanner s = new Scanner(System.in);
            int runs = s.nextInt();
            t.addScore(runs);
        } else {
            System.out.println("Invalid input.");
        }

        if ((d >= 0 && d <= 6) || d==10) {
            return 1;
        }

        return 0;
    }
}
