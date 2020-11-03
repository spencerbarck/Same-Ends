import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SameEndsMain {

	//Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. 
	/* For example, 
		sameEnds("abXab") is "ab".
		sameEnds("abXYab") is "ab"
		sameEnds("xx") is "x"
		sameEnds("xxx") is "x"	*/
	
	private JFrame mainFrame;
	private JPanel enterStringPanel;
	private JLabel enterStringLabel;
	private JTextField enterStringText;
	private JButton startButton;
	private JPanel outputPanel; 
	private JTextField outputText;
	private JButton restartButton;		
	
	public static void main(String[] args) {
		new SameEndsMain();
	}
	
	public SameEndsMain() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Same Ends");
		mainFrame.setSize(250,250);	
		mainFrame.setBackground(Color.yellow);
		
		enterStringPanel = new JPanel();
		enterStringPanel.setLayout(new BoxLayout(enterStringPanel, BoxLayout.PAGE_AXIS));
		enterStringPanel.setBackground(Color.GRAY);
		enterStringPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		enterStringPanel.setBorder(BorderFactory.createTitledBorder("Find Same Ends"));
		
		enterStringLabel = new JLabel("Enter a string: ");
		enterStringLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		enterStringPanel.add(enterStringLabel);
		
		enterStringText = new JTextField(2000);
		enterStringText.setMaximumSize(new Dimension(300, 30));
		enterStringText.setAlignmentX(Component.CENTER_ALIGNMENT);
		enterStringPanel.add(enterStringText);
		
		
		startButton = new JButton("Find Same Ends");
		//dupeCountButton.setMaximumSize(new Dimension(1, 1));
		startButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	outputText.setText( findSameEnds(enterStringText.getText()));
	        	mainFrame.setVisible(true);
	        }
		});
		enterStringPanel.add(startButton);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.PAGE_AXIS));
		outputPanel.setBackground(Color.GRAY);
		outputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputPanel.setBorder(BorderFactory.createTitledBorder("Longest Same End"));
		
		outputText = new JTextField("no string",2000);
		outputText.setMaximumSize(new Dimension(300, 30));
		outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputPanel.add(outputText);
		
		enterStringPanel.add(outputPanel);
		mainFrame.add(enterStringPanel);
		mainFrame.setVisible(true);
		
		//System.out.println("Enter your String: ");
		//Scanner inputString = new Scanner(System.in);
		//System.out.println(findSameEnds(inputString.nextLine()));
	}
	
	private String findSameEnds(String input) {
		
		String reverseInput = "";
		for (int i = input.length()-1; i>-1; i--) {
			reverseInput = reverseInput + input.charAt(i);
		}
		
		boolean noMatch = false;
		String sameEnds = "";
		
		int i=0;
		int middleIndex = input.length() / 2;
		while ((i<middleIndex) & (noMatch == false) ) {
			if(reverseInput.charAt(i)==input.charAt(i)) {
				sameEnds = sameEnds+input.charAt(i);
			} else {
				noMatch = true;
			}
			i++;
		}
		
		if (sameEnds=="") {
			return "no matches";
		}else {
			return sameEnds;
		}
	}
}
