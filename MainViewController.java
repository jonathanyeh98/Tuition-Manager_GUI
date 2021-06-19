package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainViewController {

	@FXML
	private TextField FirstName;
	@FXML
	private TextField LastName;
	@FXML
	private TextField Credits;
	@FXML
	private Button Add;
	@FXML
	private Button Remove;
	@FXML
	private Button Print;
	@FXML
	private CheckBox Funding;
	@FXML
	private CheckBox TriState;
	@FXML
	private CheckBox Exchange;
	@FXML
	private RadioButton Instate;
	@FXML
	private RadioButton Outstate;
	@FXML
	private RadioButton International;
	@FXML
	private ToggleGroup StudentType;
	@FXML
	private TextArea Output;
	@FXML
	private TextField Funds;

	private StudentList Students = new StudentList();
	
	/**
	 * Method called when pressing different student types to
	 * disable impossible selections
	 */
	public void disableOptions()
	{
		if(Instate.isArmed())
		{
			Funding.setDisable(false);
			TriState.setDisable(true);
			Exchange.setDisable(true);
		}
		
		if(Outstate.isArmed())
		{
			Funding.setDisable(true);
			TriState.setDisable(false);
			Exchange.setDisable(true);
		}
		
		if(International.isArmed())
		{
			Funding.setDisable(true);
			TriState.setDisable(true);
			Exchange.setDisable(false);
		}
	}
	
	
	/**
	 * Method that handles exceptions and errors when add is clicked.
	 * Also determines the output to text area if certain conditions are met.
	 */
	public void AddIsPressed()
	{	
		String fname = FirstName.getText();
		String lname = LastName.getText();
		String credits = Credits.getText();
		
		char c;
		
		boolean triState;
		boolean exchange;
		
		if(FirstName.getText().isEmpty())
		{
			Output.appendText("Must fill in all text fields!");
			Output.appendText("\n");
			return;
		}
		
		if(LastName.getText().isEmpty())
		{
			Output.appendText("Must fill in all text fields!");
			Output.appendText("\n");
			return;
		}
		
		try
		{
			Integer.parseInt(Credits.getText());
		}
		
		catch (NumberFormatException ex)
		{
			Output.appendText("Must put number for credits!");
			Output.appendText("\n");
		}
		
		for(int x = 0; x < fname.length(); x++)
		{
			c = fname.charAt(x);
			if(Character.isDigit(c))
			{
				Output.appendText("Must use characters as name!");
				Output.appendText("\n");
				return;
			}
		}
		
		for(int x = 0; x < lname.length(); x++)
		{
			c = lname.charAt(x);
			if(Character.isDigit(c))
			{
				Output.appendText("Must use characters as name!");
				Output.appendText("\n");
				return;
			}
		}
		
		if(Integer.parseInt(Credits.getText()) <= 0)
		{
			Output.appendText("Must have credits higher than 0!");
			Output.appendText("\n");
			return;
		}
		
		if(!(Instate.isSelected()) && !(Outstate.isSelected()) && !(International.isSelected()))
		{
		    Output.appendText("Must identify type of student!");
		    Output.appendText("\n");
		    return;
		}
		
		//Adds Instate Student
		if(StudentType.getSelectedToggle().equals(Instate))
		{
			if(Funding.isSelected() == false)
			{	
				Student toBeAdded = new Instate(fname,lname,Integer.parseInt(credits),0);
				
				if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
				    Output.appendText("\n");
			}
			else
			{	
				
				if(Funds.getText().isEmpty())
				{
					Output.appendText("Must fill in funding if checkbox is checked!");
					Output.appendText("\n");
					return;
				}
				
				try
				{
					Integer.parseInt(Funds.getText());
				}
				
				catch (NumberFormatException ex)
				{
					Output.appendText("Must put number for funds!");
					Output.appendText("\n");
				}
				
				
				if(Integer.parseInt(Funds.getText()) <= 0)
				{
					Output.appendText("Must have funds that are not negative or 0!");
					Output.appendText("\n");
					return;
				}
						
				Student toBeAdded = new Instate(fname,lname,Integer.parseInt(credits),Integer.parseInt(Funds.getText()));
				
				if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
				    Output.appendText("\n");
			}
		}
		
		//Adds Outstate Student
		if(StudentType.getSelectedToggle().equals(Outstate))
        {
			
        	if(TriState.isSelected() == true)
        	{
        		triState = true;
        		Student toBeAdded = new Outstate(fname,lname,Integer.parseInt(credits),triState);
        		
        		if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
        		    Output.appendText("\n");
        	}
        	else
        	{
        		triState = false;
        		Student toBeAdded = new Outstate(fname,lname,Integer.parseInt(credits),triState);
        		
        		if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
        		    Output.appendText("\n");
			}
        }   	
		
		//Adds International Student
		if(StudentType.getSelectedToggle().equals(International))
		{
			
			if(Exchange.isSelected() == true)
			{	
				
				if(Integer.parseInt(credits) < 9)
				{
					Output.appendText("International students cannot have less than 9 credits!");
				    Output.appendText("\n");
				    return;
				}
				
				exchange = true;
				Student toBeAdded = new International(fname,lname,Integer.parseInt(credits),exchange);
				
				if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
				    Output.appendText("\n");
			}
			else
			{
				if(Integer.parseInt(credits) < 9)
				{
					Output.appendText("International students cannot have less than 9 credits!");
				    Output.appendText("\n");
				    return;
				}
				
				exchange = false;
				Student toBeAdded = new International(fname,lname,Integer.parseInt(credits),exchange);
				
				if(Students.find(toBeAdded) == -1)
				{
				    Students.add(toBeAdded);
				    Output.appendText("$" + Integer.toString(toBeAdded.tuitionDue()));
				    Output.appendText("");
				}
				else
					Output.appendText(fname + " " + lname + " is already enrolled!");
				    Output.appendText("\n");
			}

		}
		
		FirstName.clear();
		LastName.clear();
		Credits.clear();
		Funds.clear();
		
	}
	
	/**
	 * Method to remove student from StudentList
	 */
	public void removeIsPressed()
	{
		String fname = FirstName.getText();
		String lname = LastName.getText();
		
		if(FirstName.getText().isEmpty())
		{
			Output.appendText("Must fill in all text fields!");
			Output.appendText("\n");
			return;
		}
		
		if(LastName.getText().isEmpty())
		{
			Output.appendText("Must fill in all text fields!");
			Output.appendText("\n");
			return;
		}
		
		if(Credits.getText().isEmpty())
		{
			Output.appendText("Must fill in all text fields!");
			Output.appendText("\n");
			return;
		}
		
		Student toBeRemoved = new Instate(fname,lname,0,0);
		
		if(Students.students.length == 0)
		{
			Output.appendText("Cannot remove student from empty list!");
		    Output.appendText("\n");
		}
		else
		{
		    if(Students.remove(toBeRemoved) == true)
		    {
				Students.remove(toBeRemoved);
			    Output.appendText(fname + " " + lname + " has been unenrolled!");
			    Output.appendText("\n");
		    }
		    else
		    {
			    Output.appendText("Student has not been enrolled!");
			    Output.appendText("\n");
		    }
		}
		
		FirstName.clear();
		LastName.clear();
		Credits.clear();
	}
	
	/**
	 * Method to print existing members of Student List
	 */
	public void printIsPressed()
	{
		// if first person is null or list length is 0
		if(Students.students.length == 0 || Students.students[0] == null)
		{
			Output.appendText("There are 0 students enrolled!");
		    Output.appendText("\n");
		}
		else
		{
			for(int i = 0; i < Students.students.length; i++)
			{
				Output.appendText(Students.students[i].toString() + " tuition due: $" + Students.students[i].tuitionDue());
				Output.appendText("\n");
			}
		}
	}
	
}
