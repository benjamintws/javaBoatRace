
public class Currents extends Externals{
	//constructors
	public Currents() {
		super();
	}
	
	//toString
    public String toString(){
        return String.format("%scurrent ( + %d )\n", super.toString(), super.getMagnitude());
    }

}
