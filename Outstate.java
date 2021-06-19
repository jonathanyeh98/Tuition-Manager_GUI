package application.view;

public class Outstate extends Student {
    
	private boolean tristate;
	
	private final int OUTSTATE_COST = 756;
	private final int FULL_TIME_FEE = 1441;
    private final int PART_TIME_FEE = 846;
    private final int TRI_STATE_DISCOUNT = 200;
    private final int MAX_CREDITS = 15;

    /**
     * Constructor of type Outstate Student using the parameters
     * first name, last name, and credits of Student along with
     * identifying whether or not the Student lives in the tristate
     * area.
     * @param fname contains first name of Student.
     * @param lname contains last name of Student.
     * @param credit contains amounts of credits for a specific Student.
     * @param tristate boolean value identifiying whether or not Student is tristate
     */
    public Outstate(String fname,String lname, int credit, boolean tristate)
	{
	    super(fname,lname,credit);
	    this.tristate = tristate;
	    
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
		int totalTuition = credit * OUTSTATE_COST;
		
		if (tristate == true && isFullTime() == true)
			totalTuition -= credit * TRI_STATE_DISCOUNT;
		
		if (isFullTime())
			totalTuition += FULL_TIME_FEE;
		else
			totalTuition += PART_TIME_FEE;
		
		return totalTuition;
	}
	
	/**
	 * @return String of an Outstate Student.
	 */
	public String toString() 
    {
        return ("O " + super.toString() + " " + this.tristate);
    }
	
	/**
	 * Boolean method used to identify whether or not a student
	 * is from the tri-state Student.
	 * @param s String containing boolean value.
	 * @return boolean value of tristate status of Student.
	 */
	public static boolean isTriState(String s)
	{
		if(s.equals("T"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String args[])
	{
		Outstate firstPerson = new Outstate("Bob", "Marley", 16, true);
		Outstate secondPerson = new Outstate("Jonathan","Yahoo", 12, false);
		Outstate thirdPerson = new Outstate("Albert","Cards", 8, true);
		Outstate fourthPerson = new Outstate("Bob", "Cards", 8, false);
	    
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
	    
	    //tests isTriState method
	    System.out.println("isTriState Tests:");
	    System.out.println(isTriState("T"));
	    System.out.println(isTriState("F"));
	}
}