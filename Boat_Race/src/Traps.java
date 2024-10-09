
public class Traps extends Externals{
	//constructors
	public Traps() {
		super();
	}
	
	//toString
	public String toString(){
        return String.format("%strap ( - %d )\n", super.toString(), super.getMagnitude());
    }

}
