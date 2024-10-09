import java.util.Random;

public class Externals {
	//attributes
    private int magnitude;
    private int position;
    
    //constructors
    public Externals(){
        Random randomNum = new Random();
        // for array access
        setPosition(1 + randomNum.nextInt(99));
    }

    //setters/getters
    public int getMagnitude(){
        return magnitude;
    }

    public void setMagnitude(int magnitude){
        this.magnitude = magnitude;
    }

    public void generateMagnitude(){
        Random randomNum = new Random();
        magnitude =  1 + randomNum.nextInt(4);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    //@Override
    public String toString(){
        return String.format("! You've encountered a ");
    }

}
