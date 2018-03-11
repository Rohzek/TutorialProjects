package rohzek.projects;

import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * Handles calculation logic
 * Is text/parse based
 * 
 * BUGS: Pressing "+/-" is actually showing up in the history as "+/-"
 *       Calculation is still correct, however.
 * 
 * @author Rohzek
 *
 */
public class Logic 
{
	// Strings to hold the output, the last used operator, the line of history to be added, and the last calculated total
	static String display = "", lastOperation = "", finalHistory = "", lastTotal = "";
	
	// Controls what happens when pressing a button for the first time
	static boolean first = true, noTotal = true;
	
	// The final calculation for this operation
	static double total = 0;
	
	// A formatter for the output
	static DecimalFormat fm = new DecimalFormat();
	
	/**
	 * Takes our input from the button presses
	 * @param operator The text from the pressed button
	 * @param result The result display window
	 * @param history The history display window
	 */
	public static void process(String operator, JTextField result, JTextPane history)
	{
		switch(operator)
		{
			case ".":
				addDisplay(operator);
				result.setText(display);
				break;
				
			case "+/-":
				addDisplay(operator);
				result.setText(display);
				break;
				
			case "/":
				calculate(operator, result, history);
				break;
				
			case "*":
				calculate(operator, result, history);
				break;
				
			case "-":
				calculate(operator, result, history);
				break;
				
			case "+":
				calculate(operator, result, history);
				break;
				
			case "=":
				calculate(operator, result, history);
				break;
				
			case "AC":
				allClear(result);
				break;
				
			case "HC":
				history.setText("");
				break;
				
			default:
				addDisplay(operator);
				result.setText(display);
				break;
		}
	}
	
	/**
	 * Runs calculations when an operator is pressed (*,/,+,-)
	 * @param The operation The symbol used
	 * @param result The result display window
	 * @param history The history display window
	 */
	static void calculate(String operation, JTextField result, JTextPane history)
	{
		if(noTotal)
		{
			total = Float.parseFloat(display);
			noTotal = false;
		}
		else
		{
			if(lastOperation.equals("/"))
			{
				total = total /= Double.parseDouble(display);
			}
			else if(lastOperation.equals("*"))
			{
				total = total *= Double.parseDouble(display);
			}
			else if(lastOperation.equals("-"))
			{
				total = total -= Double.parseDouble(display);
			}
			else if(lastOperation.equals("+"))
			{
				total = total += Double.parseDouble(display);
			}
		}
		
		if(operation.equals("/") || operation.equals("*") || operation.equals("-") || operation.equals("+"))
		{
			resetDisplay(result);
		}
		
		lastOperation = operation;
		
		if(operation.equals("="))
		{
			display = fm.format(total);
			finalHistory += "=" + display + '\n';
			
			if(!lastTotal.equals(""))
			{
				history.setText(lastTotal + finalHistory + history.getText());
			}
			else
			{
				history.setText(finalHistory + history.getText());
			}
			
			lastTotal = display;
			finalHistory = "";
			result.setText(display);
		}
		else
		{
			finalHistory += operation;
		}
	}
	
	/**
	 * Adds numbers and symbols to the display (+/-,.,0-9)
	 * @param The symbol or number pressed
	 * @param result The result display window
	 * @param history The history display window
	 */
	static void addDisplay(String addition)
	{
		if(addition.contains(".") && display.contains(".")){}
		else if(addition.equals("+/-"))
		{
			if(display.contains("-"))
			{
				display = display.substring(1);
			}
			else
			{
				display = "-" + display;
			}
		}
		else
		{
			if(!first)
			{
				display += addition;
			}
			else
			{
				display = addition;
				first = false;
			}
		}
		
		finalHistory += addition;
	}
	
	/**
	 * Resets the display to read "0" in-between operations
	 * @param result The result display window
	 */
	static void resetDisplay(JTextField result)
	{
		first = true;
		display = "0";
		result.setText(display);
	}
	
	/**
	 * Resets the display back to an unused, clear state
	 * @param result The result display window
	 */
	static void allClear(JTextField result)
	{
		resetDisplay(result);
		
		noTotal = true;
		first = true;
		lastTotal = "";
	}
}
