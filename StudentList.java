package application.view;

public class StudentList {
	
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4;
	private int numStudents;
	Student[] students;
    
	/**
	* Constructor of type StudentList.
	*/
	public StudentList()
	{
		students = new Student[0];
		numStudents = 0;
	}
	
	/**
	* If needed, adds length 4 to the array to add new Students.
	*/
	private void grow()
	{
		
	    Student newArr[] = new Student[students.length + GROW_SIZE];
		   
	    //insert the elements from the old array into the new array 
	    for (int i = 0; i < numStudents; i++) 
	    	newArr[i] = this.students[i];
	       
	    this.students = newArr;
	}
	
	/**
	* Method to add a Student s to the Student array.
	* @param s Student element to be added.
	*/
	public void add(Student s)
	{
	    if(students.length == 0)
        {
            this.grow();
        }
        
	    if(numStudents == students.length)
	    	this.grow();
        
	    int x;
	    x = this.find(s);
	    
	    if(x == 0)
	    {
	    	String studentInfo = s.toString();
	   	    String delims = " ";
	   	    String[] tokens = studentInfo.split(delims);
	   	    
	    	System.out.println(tokens[1] + " " + tokens[2] + " is already enrolled!");
	    }
	    else
	    {
	    	students[numStudents] = s;
	    	
	    	System.out.println("$" + students[numStudents].tuitionDue());
	    	
	    	numStudents++;
	    }
	}
	
	
	/**
	* Method that finds a specified Student within the Student array
	* @param s Student element.
	* @return the integer holding the position of Student within the array, if not found, returns -1
	*/
	public int find(Student s)
	{
		// for loop that traverses through array to find target member m. Returns -1 if not found.
	    for(int i = 0; i < numStudents; i ++) 
	    {
            if (students[i].compareTo(s) == 0)
	    	{
	    	    return i;
	        }
	    }
	    return NOT_FOUND;
	}
	
	/**
	* Deletes the person with the given name and date from the Students array
	* @param s Student element to be removed.
	* @return if found, returns true, if not found, returns false
	*/
	public boolean remove(Student s)
	{
		if (numStudents == 0)
			System.out.println("Cannot remove student from empty list!");
		
		else
		{
		
	        int x; 
		    x = this.find(s);
		  
		    // if find() returns anything other than -1, gives students[x] the value of students[x+1] and so on
		    if (x != NOT_FOUND)
		    {
	            for(int j = x; j < students.length - 1; j++)
			    {
	                students[j] = students[j + 1];
	            }
	            
	            String studentInfo = s.toString();
		   	    String delims = " ";
		   	    String[] tokens = studentInfo.split(delims);
		   	    
			    System.out.println(tokens[1] + " " + tokens[2] + " has been unenrolled!");
			    numStudents--;
			    return true;
		    } 
		    else
		    {
	            System.out.println("Student has not been enrolled!");
			    return false;
		    }    
		}
		
		return false;
	}
	
	/**
	* method used to traverse through array and print out the current students that it holds
	*/
	public void print()
	{
		if (numStudents == 0)
			System.out.println("There are 0 Students Enrolled!");
		
		else
		{
		    for(int i = 0; i < numStudents; i++)
		    {
			    System.out.println(students[i] + " tuition due: $" + students[i].tuitionDue());
		    }
		}
	}
}
