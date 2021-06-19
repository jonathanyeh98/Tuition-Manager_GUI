package application.view;

public abstract class Student implements Comparable {
    private String fname;
    private String lname;
    protected int credit;

    /**
     * Constructor of type Student that instantiates the values of 
     * the created Student. Giving it a first name, last name 
     * and identifies the amount of credits being pursued on a 
     * given semester.
     * @param fname first name of student
     * @param lname last name of student
     * @param credit number of credits being taken
     */
    public Student(String fname, String lname, int credit) 
    {
    	this.fname = fname;
    	this.lname = lname;
    	this.credit = credit;
    } 

    /**
     * Function used to compare two individual first and last name.
     * Returns 0 if equal, -1 if first name and last name are <
     * objects and 1 if first name and last name are > objects.
     * @param obj holds the object to be compared
     */
    public int compareTo(Object obj)
    {
    	Student secondStudent = (Student) obj;
    	
    	String firstFirstName = this.fname.toLowerCase();
    	String secondFirstName = secondStudent.fname.toLowerCase();
    	String firstLastName = this.lname.toLowerCase();
    	String secondLastName = secondStudent.lname.toLowerCase();
    	
        if (!firstFirstName.equals(secondFirstName))
        {
        	if (firstFirstName.compareTo(secondFirstName) > 0)
        	    return 1;
        	else
                return -1;
        }
        else
        {
        	if (firstLastName.equals(secondLastName))
        	    return 0;
        	else if (firstLastName.compareTo(secondLastName) < 0)
        	    return -1;
        	else
        	    return 1;
        }
    }

    @Override
    public String toString() 
    {
        return (this.fname + " " + this.lname + " " + Integer.toString(credit));
    }

    /**
     * Constructor for tuition due, used different subclasses.
     * @return the amount of tuition due for a specific Student.
     */
    public abstract int tuitionDue();
    
}