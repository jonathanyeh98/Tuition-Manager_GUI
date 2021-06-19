package application.view;
import java.util.Scanner;

public class TuitionManager {

	Scanner stdin;
	StudentList cs213;
	   
	   /**
	    * run is used to take in the user input commands and process them to let the program know which
	    * command to run
	    */
	   public void run()
	   {
		  cs213 = new StudentList();
	      boolean done = false;
	      stdin = new Scanner(System.in);
	      
	      while ( !done )
	      {
	          String command = stdin.nextLine();
	         
	          String studentInfo = command;
	   	      String delims = " ";
	   	      String[] tokens = studentInfo.split(delims);
	   	     
	         // create char command2 to hold command from user input and use in switch case
	   	     
	         char command2 = command.charAt(0);
	         
	         
	         switch (command2)  
	         {   
	            case 'I': if (Integer.parseInt(tokens[3]) <= 0)
	                      {
	            	          System.out.println("Invalid Credit Amount Entered");
	            	          break;
	                      }
	            	      cs213.add(new Instate(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
			              break; 
	            case 'O': if (Integer.parseInt(tokens[3]) <= 0)
                          {
      	                      System.out.println("Invalid Credit Amount Entered");
      	                      break;
                          }
	            	      cs213.add(new Outstate(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Outstate.isTriState(tokens[4])));
	                      break;
	            case 'N': if (Integer.parseInt(tokens[3]) <= 8)
                          {
                              System.out.println("International students must have at least 9 credits!");
                              break;
                          }
	            	      cs213.add(new International(tokens[1], tokens[2], Integer.parseInt(tokens[3]), International.isExchange(tokens[4])));
	                      break;
	            case 'R': remove(tokens[1],tokens[2]);
	                      break;
	            case 'P': print();
	                      break;
	            case 'Q': System.out.println("Program Terminated");
	              System.exit(0);
	            default: //deal with bad command here 
	            		System.out.println("Command" + " " + "'" + command.charAt(0) + "'" + " " + "not supported!");
	         }  
	      }
	   }
	   
	   /**
	    * Checks if the Student is found in the array, and if it is, removes him.
	    * @param fname containing first name of Student.
	    * @param lname containing last name of Student.
	    */
	   public void remove(String fname, String lname)
	   {
		   Instate toBeRemoved = new Instate(fname,lname,0,0);
		   this.cs213.remove(toBeRemoved);
	   }
	   
	   /**
	    * Calls the print method in Team.java and prints the array accordingly.
	    */
	   public void print()
	   {
		   cs213.print();
	   }
}

