package rohzek.projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Calculator extends JFrame 
{
	// Content holder
	private JPanel contentPane;
	
	// Text panels
	private final JTextField result = new JTextField();
	private final JTextPane history = new JTextPane();
	
	// Buttons
	private JButton zeroButton = new JButton("0");
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton decimalButton = new JButton(".");
	private JButton signButton = new JButton("+/-");
	private JButton divideButton = new JButton("/");
	private JButton multiplyButton = new JButton("*");
	private JButton subtractButton = new JButton("-");
	private JButton addButton = new JButton("+");
	private JButton equalsButton = new JButton("=");
	private JButton clearButton = new JButton("AC");
	private JButton historyClearButton = new JButton("HC");
	
	/**
	 * Constructor to initialize and show GUI
	 */
	public Calculator() 
	{
		initialize();
		setVisible(true);
	}
	
	/**
	 * Runs the functions to initialize various parts
	 * of the GUI
	 */
	private void initialize() 
	{
		setupFrame();
		setupText();
		setupButtons();
	}
	
	/**
	 * Sets up the outer frame with a title
	 * and a listener to override the closing action
	 * Also sets the content pane, layout, and frame size
	 */
	private void setupFrame()
	{
		setTitle("Calculator");
		
		// We catch the close window operation, and override it here
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                // Write to file here
            	Utility.save(history.getText());
                e.getWindow().dispose();
            }
        });
		
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // Centers window
	}
	
	/**
	 * Initializes the history and result text panels
	 */
	private void setupText()
	{
		// Default Text
		result.setText("0");
		history.setText("");
		
		// Text Alignment
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Editable Flag
		result.setEditable(false);
		history.setEditable(false);
		
		// Location
		result.setBounds(10, 11, 246, 33);
		history.setBounds(266, 11, 158, 206);
		
		// Text Columns
		result.setColumns(10);
		
		// Display
		contentPane.add(result);
		contentPane.add(history);
	}
	
	/**
	 * Initializes the buttons
	 */
	private void setupButtons()
	{
		// Location
		zeroButton.setBounds(10, 194, 54, 23);
		oneButton.setBounds(10, 160, 54, 23);
		twoButton.setBounds(74, 160, 54, 23);
		threeButton.setBounds(138, 160, 54, 23);
		fourButton.setBounds(10, 126, 54, 23);
		fiveButton.setBounds(74, 126, 54, 23);
		sixButton.setBounds(138, 126, 54, 23);
		sevenButton.setBounds(10, 89, 54, 23);
		eightButton.setBounds(74, 89, 54, 23);
		nineButton.setBounds(138, 89, 54, 23);
		decimalButton.setBounds(74, 194, 54, 23);
		signButton.setBounds(138, 194, 54, 23);
		divideButton.setBounds(202, 55, 54, 23);
		multiplyButton.setBounds(202, 92, 54, 23);
		subtractButton.setBounds(202, 126, 54, 23);
		addButton.setBounds(202, 160, 54, 23);
		equalsButton.setBounds(202, 194, 54, 23);
		clearButton.setBounds(10, 55, 54, 23);
		historyClearButton.setBounds(74, 55, 54, 23);
		
		// Tool tips
		zeroButton.setToolTipText("Zero");
		oneButton.setToolTipText("One");
		twoButton.setToolTipText("Two");
		threeButton.setToolTipText("Three");
		fourButton.setToolTipText("Four");
		fiveButton.setToolTipText("Five");
		sixButton.setToolTipText("Six");
		sevenButton.setToolTipText("Seven");
		eightButton.setToolTipText("Eight");
		nineButton.setToolTipText("Nine");
		decimalButton.setToolTipText("Decimal");
		signButton.setToolTipText("Change Sign");
		divideButton.setToolTipText("Divide");
		multiplyButton.setToolTipText("Multiply");
		subtractButton.setToolTipText("Subtract");
		addButton.setToolTipText("Add");
		equalsButton.setToolTipText("Calculate");
		clearButton.setToolTipText("Clear Current Operation");
		historyClearButton.setToolTipText("Clear History");
		
		// Button Listeners
		zeroButton.addActionListener(new CalculatorListener());
		oneButton.addActionListener(new CalculatorListener());
		twoButton.addActionListener(new CalculatorListener());
		threeButton.addActionListener(new CalculatorListener());
		fourButton.addActionListener(new CalculatorListener());
		fiveButton.addActionListener(new CalculatorListener());
		sixButton.addActionListener(new CalculatorListener());
		sevenButton.addActionListener(new CalculatorListener());
		eightButton.addActionListener(new CalculatorListener());
		nineButton.addActionListener(new CalculatorListener());
		decimalButton.addActionListener(new CalculatorListener());
		signButton.addActionListener(new CalculatorListener());
		divideButton.addActionListener(new CalculatorListener());
		multiplyButton.addActionListener(new CalculatorListener());
		subtractButton.addActionListener(new CalculatorListener());
		addButton.addActionListener(new CalculatorListener());
		equalsButton.addActionListener(new CalculatorListener());
		clearButton.addActionListener(new CalculatorListener());
		historyClearButton.addActionListener(new CalculatorListener());
		
		// Display buttons
		contentPane.add(zeroButton);
		contentPane.add(oneButton);
		contentPane.add(twoButton);
		contentPane.add(threeButton);
		contentPane.add(fourButton);
		contentPane.add(fiveButton);
		contentPane.add(sixButton);
		contentPane.add(sevenButton);
		contentPane.add(eightButton);
		contentPane.add(nineButton);
		contentPane.add(decimalButton);
		contentPane.add(signButton);
		contentPane.add(divideButton);
		contentPane.add(multiplyButton);
		contentPane.add(subtractButton);
		contentPane.add(addButton);
		contentPane.add(equalsButton);
		contentPane.add(clearButton);
		contentPane.add(historyClearButton);
	}
	
	/*
	 * Public getters and setters for the result and history text panels
	 */
	public String getHistory() 
	{
		return history.getText();
	}
	
	public String getResult() 
	{
		return result.getText();
	}
	
	public void setHistory(String text)
	{
		history.setText(text);
	}
	
	public void setResult(String text) 
	{
		result.setText(text);
	}
	
	/**
	 * Inner class for the buttons interaction
	 * @author Rohzek
	 */
	class CalculatorListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent a) 
		{
			JButton button = (JButton)a.getSource();
			String name = button.getText();
			
			Logic.process(name, result, history);
		}
	}
}
