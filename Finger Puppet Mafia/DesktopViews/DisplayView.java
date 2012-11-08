package DesktopViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayView {
	private JPanel displayPanel;
	private JPanel headerPanel;
	private JLabel titleLabel;
	private JLabel descriptionLabel;  // should this be here? there is not description field for an entry
	private JScrollBar scrollBar;
	private JTextArea lineNumberArea;
	private JTextArea codeArea;
	private JPanel footerPanel;
	private JPanel tagsPanel;
	private JLabel keyWordsLabel;
	private JTextField keyWordsText;
	
	public DisplayView(){
		displayPanel = new JPanel();
		headerPanel = new JPanel();
		titleLabel = new JLabel("Print Statement (with string)");
		descriptionLabel = new JLabel("<html>When you want to add a string to a print statement you use '%s' and then add your string after the comma in the print statement.</html>");
		scrollBar = new JScrollBar();
		lineNumberArea = new JTextArea();
		codeArea = new JTextArea();
		footerPanel = new JPanel();
		tagsPanel = new JPanel();
		keyWordsLabel = new JLabel("Keywords:  ");
		keyWordsText = new JTextField();
		
		displayPanel.setLayout(new BorderLayout(0, 0));
		displayPanel.add(headerPanel, BorderLayout.NORTH);
		displayPanel.add(scrollBar, BorderLayout.EAST);
		displayPanel.add(lineNumberArea, BorderLayout.WEST);
		displayPanel.add(codeArea, BorderLayout.CENTER);
		displayPanel.add(footerPanel, BorderLayout.SOUTH);
		
		headerPanel.setLayout(new BorderLayout(0, 0));
		headerPanel.add(titleLabel, BorderLayout.CENTER);
		headerPanel.add(descriptionLabel, BorderLayout.SOUTH);
		
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		descriptionLabel = new JLabel("<html>When you want to add a string to a print statement you use '%s' and then add your string after the comma in the print statement.</html>");

		lineNumberArea.setEditable(false);
		lineNumberArea.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n41\n42\n43\n44\n45\n46\n47\n48\n49\n50");
		lineNumberArea.setBackground(Color.LIGHT_GRAY);
		
		codeArea.setText("Print('Hello %s\\n',\"Michael\");");

		footerPanel.add(tagsPanel);
		
		tagsPanel.add(keyWordsLabel);
		tagsPanel.add(keyWordsText);
		
		keyWordsText.setEditable(false);
		keyWordsText.setText("C, Print, String");
		keyWordsText.setColumns(10);
	}
	
	public Container getView(){
		return displayPanel;
	}
	


}