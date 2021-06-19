package application.view;

/**
In this subclass of Student we are utilizing methods to construct a Student of type Instate given a 
specific string input. It identifies the Students parameters, constructing an element of type Instate 
and notifies if the Student is full time, calculates funds and tuition due, and contains a toString() method.
  
@author Daniel Tolentino & Jonathan Yeh
*/

public class Instate extends Student {
    
	private int funds;
	
	private final int INSTATECOST = 433;
	private final int FULLTIME_FEE = 1441;
    private final int PARTTIME_FEE = 846;
    private final int MAX_CREDITS = 15;
    
    /**
     * Constructor of type Instate Student using the parameters
     * first name, last name, and credits of Student along with
     * identifying the amount of funds a Student is given.
     * @param fname contains first name of Student.
     * @param lname contains last name of Student.
     * @param credit contains amounts of credits for a specific Student.
     * @param funds contains the amount of funds given to a Student.
     */
	public Instate(String fname,String lname, int credit, int funds)
	{
	    super(fname,lname,credit);
	    this.funds = funds;
	    
	    if (credit >= MAX_CREDITS)
	    	this.credit = MAX_CREDITS;
	}
	
	/**
     * Boolean method to identify whether or not a given
     * student is full time or part time.
     * @return boolean value identifying Students full time status.
     */
	public boolean isFullTime()
	{
	    if (this.credit >= 12)
	    	return true;
	    else
	    	return false;
	}
	
	/**
	 * Method for finding the amount of tuition due
	 * for a given Student.
	 * @return Integer containing tuition due.
	 */
	public int tuitionDue()
	{
		
		int totalTuition = credit * INSTATECOST;
		
		if (isFullTime())
		{
		    totalTuition -= funds;
		    totalTuition += FULLTIME_FEE;
		}
		else
			totalTuition += PARTTIME_FEE;
		
		return totalTuition;
	}
	
	/**
	 * @return String of an Instate Student.
	 */
	public String toString() 
    {
        return ("I " + super.toString() + " " + this.funds);
    }


	public static void main(String args[])
	{
	    Instate firstPerson = new Instate("Bob", "Marley", 16, 1000);
	    Instate secondPerson = new Instate("Jonathan","Yahoo", 12, 0);
	    Instate thirdPerson = new Instate("Albert","Cards", 8, 1000);
	    Instate fourthPerson = new Instate("Bob", "Cards", 12, 1000);
	    
	    //tests isFullTime method
	    System.out.println("Full Time Tests:");
	    System.out.println(firstPerson.isFullTime());
	    System.out.println(thirdPerson.isFullTime());
	    System.out.println();
	    
	    //tests tuitionDue() method
	    System.out.println("Tuition Tests:");
	    System.out.println("$" + secondPerson.tuitionDue());
	    System.out.println("$" + fourthPerson.tuitionDue());
	    
	    //tests toString() method
	    System.out.println("toString Tests:");
	    System.out.println(firstPerson.toString());
	    System.out.println(secondPerson.toString());
	  
	}
}