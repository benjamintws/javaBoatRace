import java.util.Scanner;
import java.util.Random;

public class Player {
		//attributes
	    private String name;
	    private int score = 0;
	    private int location = 0;
	    private Scanner input = new Scanner(System.in);

	    //constructors
	    public Player() {
	        name = "";
	    }

	    public Player(String name) {
	        this.name = name;
	    }

	    //setters/getters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getScore() {
	        return score;
	    }

	    public void setScore(int score) {
	        this.score = score;
	    }

	    public int getLocation() {
	        return location;
	    }

	    public void setLocation(int location) {
	        this.location = location;
	    }

	    public void enterName(int num) {
	        System.out.printf("Please enter Player %d's name: ", num);
	        name = input.nextLine();
	        while (name.equals("") || name.length() > 12) {
	            if (name.equals("")) {
	                System.out.println("[ERROR] Please enter an appropriate name.");
	            } else if (name.length() > 12) {
	                System.out.println("[ERROR] Name cannot be more than 12 letters.");
	            }
	            System.out.printf("Please enter Player %d's name: ", num);
	            name = input.nextLine();
	        }
	    }

	    public int rollDice() {
	        Random randomNum = new Random();
	        System.out.printf("> %s, click [ENTER] to roll the dice", name);
	        input.nextLine();
	        int dice = (1 + randomNum.nextInt(6));
	        System.out.println("You rolled the number " + dice);
	        return dice;
	    }

	    //toString
	    public String toString() {
	        return String.format("You are now at location %d\n", location);
	    }

}
