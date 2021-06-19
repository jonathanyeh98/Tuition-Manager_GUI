package application.view;

public class International extends Student {
    
	private boolean exchange;
	
    private final int INTERNATIONAL_COST = 945;
	private final int FULL_TIME_FEE = 1441;
    private final int PART_TIME_FEE = 846;
    private final int INTERNATIONAL_STUDENT_FEE = 350;
    private final int MAX_CREDITS = 15;
	
    /**
     * Constructor for a Student of type International. Utilizing the parameters
     * first name, last name, number of credits and identifies whether or not
     * Student is and exchange student.
     * @param fname contains first name of Student.
     * @param lname contains last name of Student.
     * @param credit contains amount of credits Student is taking.
     * @param exchange contains boolean value of exchange student
     */
    public International(String fname,String lname, int credit, boolean exchange)
	{
	    super(fname,lname,credit);
	    this.exchange = exchange;
	    
	    if (credit >= MAX_CREDITS)
	    	this.credit = MAX_CREDITS;
	}
	
    /**
     * 
     * @return returns boolean value indicating full time status
     */
	public boolean isFullTime()
	{
	    if (this.credit >= 12)
	        return true;
	    else
	        return false;
	}
	
	/**
	 * Calculates the tuition due for a particular Student.
	 * @return tuition due for a particular student
	 */
	public int tuitionDue()
	{
		int totalTuition;
		
		if (this.exchange == true)
			totalTuition = INTERNATIONAL_STUDENT_FEE + FULL_TIME_FEE;
		
		else
		{
		
		totalTuition = credit * INTERNATIONAL_COST + INTERNATIONAL_STUDENT_FEE;
		
		if (isFullTime())
			totalTuition += FULL_TIME_FEE;
		else
			totalTuition += PART_TIME_FEE;
		}
		
		return totalTuition;
	}
	
	/**
	 * @return string of an International Student.
	 */
	public String toString() 
    {
        return ("N " + super.toString() + " " + this.exchange);
    }
	
	/**
	 * Boolean method to identify if given Student is an exchange student or not
	 * based on user input.
	 * @param s String containing user input T or F
	 * @return boolean value identifying if the Student is exchange student
	 */
	public static boolean isExchange(String s)
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
	    International firstPerson = new International("Bob", "Marley", 16, true);
	    International secondPerson = new International("Jonathan","Yahoo", 12, false);
	    International thirdPerson = new International("Albert","Cards", 10, true);
	    International fourthPerson = new International("Bob", "Cards", 10, false);
	    
	    //tests isFullTime method
	    System.out.println("Full Time Tests:");
	    System.out.println(firstPerson.isFullTime());
	    System.out.println(thirdPerson.isFullTime());
	    
	    //tests tuitionDue() method
	    System.out.println("Tuition Tests:");
	    System.out.println("$" + thirdPerson.tuitionDue());
	    System.out.println("$" + fourthPerson.tuitionDue());

	    //tests toString() method
	    System.out.println("toString Tests:");
	    System.out.println(firstPerson.toString());
	    System.out.println(secondPerson.toString());
	    
	    //tests isExchange() method
	    System.out.println("isExchange Tests:");
	    System.out.println(isExchange("T"));
	    System.out.println(isExchange("F"));
	    
	}

}