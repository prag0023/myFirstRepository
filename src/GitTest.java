import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GitTest {

    public static void main (String [] args) throws FileNotFoundException {
        LinkedList<String>killRing = new LinkedList<String>();
        LinkedList<String> graveyard = new LinkedList<String>();
        Scanner players = new Scanner(new File("/Users/nirendra/Documents/Second Semester/Construction/Java/gitTest/src/git.txt"));
        while (players.hasNext()){
            killRing.add(players.next());
        }
        Collections.shuffle(killRing);
        Scanner scan = new Scanner(System.in);

        while (killRing.size() > 1) {
            System.out.println("Choose an option:");
            System.out.println("1. Kill player\t\t\t2. Show player\t\t\t3. Show dead ones\n");
            System.out.print("Choice: ");

            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the player to kill: ");
                    String playerName = scan.next();
                    if(killRing.contains(playerName)){
                        killRing.remove(playerName);
                        graveyard.add(playerName);
                        System.out.println("The player is killed........!!!!");
                    }else{
                        System.out.println("Player does not exist!!");
                    }
                    break;

                case 2:
                    System.out.println("Remaining Players: " + killRing);
                    break;

                case 3:
                    if (graveyard.isEmpty())
                        System.out.println("Dead player list is empty");
                    else
                        System.out.println("Dead Players: " + graveyard);
                    break;
            }
        }
        System.out.println("Game is over!!! And the Winner is " + killRing.get(0));
    }

}

