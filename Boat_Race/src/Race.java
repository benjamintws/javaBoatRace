import java.util.Scanner;

public class Race {
	//attributes
	 private static Player player1 = new Player();
	    private static Player player2 = new Player();
	    private static Player winner = new Player();
	    private static River river = new River();
	    private static Externals[] riverBoard = river.getRiverBoard();
	    private static FileHandler file_handler = new FileHandler();
	    private static int numOfTurns = 0;

	    //getters
	    public static Player getPlayer1() {
	        return player1;
	    }

	    public static Player getPlayer2() {
	        return player2;    
	    }

	    public static Player getWinner() {
	        return winner;
	    }

	    public static River getRiver() {
	        return river;
	    }

	    public static FileHandler getFileHandler() {
	        return file_handler;
	    }

	    public static int getNumOfTurns(){
	        return numOfTurns;
	    }

	    public static String promptDifficultyLevel() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("Difficulty Level: ");
	        System.out.println("1. Easy");
	        System.out.println("2. Normal");
	        System.out.println("3. Hard");
	        System.out.print("Please select the difficulty level you would like to try by entering the number: ");
	        // check if user input is valid
	        String difficultyLevel = input.nextLine();
	        while (!(difficultyLevel.equals("1") || difficultyLevel.equals("2") || difficultyLevel.equals("3"))) {
	            System.out.println("[ERROR] Invalid input detected.\n");
	            System.out.print("Please select the difficulty level you would like to try by entering the number: ");
	            difficultyLevel = input.nextLine();
	        }

	        return difficultyLevel;
	    }

	    public static void startGame(){
	        int dice;

	        out: while (player1.getLocation() != 100 && player2.getLocation() != 100) {

	            // Update numOfTurns every round
	            numOfTurns += 1;

	            System.out.printf("~~~~~~~~~~~~~~~[ Round: %3d ]~~~~~~~~~~~~~~~", numOfTurns);

	            System.out.println();
	            dice = player1.rollDice();
	            player1.setLocation(player1.getLocation() + dice);

	            if ((player1.getLocation() < 100)) {
	                System.out.println(player1);
	                while (!(riverBoard[player1.getLocation()] instanceof Initialisation)) {
	                    encounterItem(riverBoard[player1.getLocation()], player1);
	                    if ((player1.getLocation() >= 100)) {
	                        winner = player1;
	                        break out;
	                    } else if (player1.getLocation() < 0) {
	                        player1.setLocation(0);
	                        System.out.println("! Restart from 0");
	                    }
	                    System.out.println(player1);
	                }
	            } else {
	                winner = player1;
	                break;
	            }

	            // divider
	            System.out.println();

	            dice = player2.rollDice();
	            player2.setLocation(player2.getLocation() + dice);

	            if ((player2.getLocation() < 100)) {
	                System.out.println(player2);
	                while (!(riverBoard[player2.getLocation()] instanceof Initialisation)) {
	                    encounterItem(riverBoard[player2.getLocation()], player2);
	                    if ((player2.getLocation() >= 100)) {
	                        winner = player2;
	                        break out;
	                    } else if (player2.getLocation() < 0) {
	                        player2.setLocation(0);
	                        System.out.println("! Restart from 0");
	                    }
	                    System.out.println(player2);
	                }
	            } else {
	                winner = player2;
	                break;
	            }

	        }
	    }

	    private static void encounterItem(Externals variable, Player player) {
	        if (variable instanceof Currents) {
	            ((Currents) variable).generateMagnitude();
	            System.out.print(variable);
	            player.setLocation(player.getLocation() + variable.getMagnitude());

	        } else if (variable instanceof Traps) {
	            ((Traps) variable).generateMagnitude();
	            System.out.print(variable);
	            player.setLocation(player.getLocation() - variable.getMagnitude());

	        }
	    }

}
