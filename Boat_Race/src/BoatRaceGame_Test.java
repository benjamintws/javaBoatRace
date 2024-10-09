
public class BoatRaceGame_Test {
	 public static void main(String[] args) {

	        // Welcome to the Game
	        System.out.println("╔═══════════════════════════════════════════════════════════╗");
	        System.out.println("║              Welcome to the Boat Racing Game!             ║");
	        System.out.println("╚═══════════════════════════════════════════════════════════╝");
	        System.out.println("Instructions: ");
	        System.out.println("This game requires 2 people to play it.\n");

	        // Prompt for players' name
	        Race.getPlayer1().enterName(1);
	        Race.getPlayer2().enterName(2);

	        System.out.println("\nAt the beginning, each player will be allocated with a boat.");
	        System.out.println(
	                "- During the game, both players will take turns to throw the dice to decide the number of steps to be moved forward.");
	        System.out.println(
	                "- The river can be visualized as a track with 100 tiles, filled with random number of Traps (T) and Currents (C) depending on the difficulty level.");

	        System.out.println();

	        // prompt for difficulty level and initialize river objects
	        String difficultyLevel = Race.promptDifficultyLevel();
	        Race.getRiver().setDifficultyLevel(difficultyLevel);

	        System.out.println("\nThe river for your Boat Race is as printed below:");
	        Race.getRiver().printRiverBoard();
	        System.out.println();
	        System.out.println("The track of this river should be read row by row, from left to right.");
	        System.out.println("  - The starting position is at 0.");
	        System.out.println("  - When the boat hits a trap, it needs to move backward x number of steps.");
	        System.out.println("  - When the boat hits a current, it needs to move forward x number of steps.");
	        System.out.println("  - The game ends when one of the boat reaches the end of the river.");
	        System.out.println();

	        System.out.println("╔══════════════════════════════════════════╗");
	        System.out.println("║                  START!                  ║");
	        System.out.println("╚══════════════════════════════════════════╝");

	        Race.startGame();

	        System.out.println("\n╔══════════════════════════════════════════╗");
	        System.out.println("║                GAME END!                 ║");
	        System.out.println("╚══════════════════════════════════════════╝");

	        System.out.printf("\n# The WINNER of this game is.........  %s!!! Congratulations! #\n", Race.getWinner().getName());
	        Race.getWinner().setScore(Race.getNumOfTurns());

	        Race.getFileHandler().updateList(Race.getWinner(), Integer.parseInt(difficultyLevel));

	        System.out.printf("# %s won the game in %d moves #\n", Race.getWinner().getName(), Race.getNumOfTurns());

	        Race.getFileHandler().printPlayers(Integer.parseInt(difficultyLevel));
	    }

}
