//Created By Michael, Anthony, Stephen, Hannah Montana
package Database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class MainWindowApp extends JFrame {

	private JPanel contentPane;
	private String[] comboList = new String[] {"List of Items"};
	private JPanel leftPane;
	private JPanel rightPane;
	private JSplitPane splitPane;
	private JTree tree;
	private JButton addButton;
	private JTextField searchBar;
	private JScrollBar scrollBar;
	private JPanel headerBar;
	private JPanel bottomBar;
	private JTextArea textPane;
	private JTextArea txtrPrinthellosnmichael;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel tagsPanel;
	private JLabel lblNewLabel_2;
	private JTextField txtCPrintString;
	
	private JPanel addPane;
	private JPanel addInstructionPane;
	private JPanel addTitlePane;
	private JPanel addKeyWordsPane;
	private JPanel addProgrammingLanguagePane;
	private JPanel addCodePane;
	private JPanel addDependenciesPane;
	private JPanel addPublicPane;
	private JPanel addButtonPane;
	
	private JLabel lblAddInstruction;
	private JLabel lblAddTitle;
	private JLabel lblAddKeyWords;
	private String[] possibleProgrammingLanguages = {"Java", "C", "C++/C", "Python", "Ruby", "Pascal", "Other..."};
	private JLabel lblAddProgrammingLanguage;
	private JLabel lblAddCode;
	private JLabel lblAddDependencies;
	private JLabel lblAddPublic;
	
	private JTextField tfAddTitle;
	private JTextField tfAddKeyWords;
	private JComboBox comboAddProgrammingLanguage;
	private JTextArea taAddCode;
	private JTextField tfAddDependencies;
	private JCheckBox cbAddPublic;
	private JButton btnAddCancel;
	private JButton btnAddSave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowApp frame = new MainWindowApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	//GO!
	public MainWindowApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		/////
		rightPane = new JPanel();
		leftPane = new JPanel();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPane,rightPane);
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		contentPane.add(splitPane, BorderLayout.CENTER);
		rightPane.setLayout(new BorderLayout(0, 0));
		
		scrollBar = new JScrollBar();
		rightPane.add(scrollBar, BorderLayout.EAST);
		
		headerBar = new JPanel();
		rightPane.add(headerBar, BorderLayout.NORTH);
		headerBar.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Print Statement (with string)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		headerBar.add(lblNewLabel, BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel("<html>When you want to add a string to a print statement you use '%s' and then add your string after the comma in the print statement.</html>");
		
		headerBar.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		bottomBar = new JPanel();
		rightPane.add(bottomBar, BorderLayout.SOUTH);
		
		tagsPanel = new JPanel();
		bottomBar.add(tagsPanel);
		
		lblNewLabel_2 = new JLabel("Tags: ");
		tagsPanel.add(lblNewLabel_2);
		
		txtCPrintString = new JTextField();
		txtCPrintString.setEditable(false);
		txtCPrintString.setText("C, Print, String");
		tagsPanel.add(txtCPrintString);
		txtCPrintString.setColumns(10);
		
		textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n41\n42\n43\n44\n45\n46\n47\n48\n49\n50");
		textPane.setBackground(Color.LIGHT_GRAY);
		rightPane.add(textPane, BorderLayout.WEST);
		
		txtrPrinthellosnmichael = new JTextArea();
		txtrPrinthellosnmichael.setText("Print('Hello %s\\n',\"Michael\");");
		rightPane.add(txtrPrinthellosnmichael, BorderLayout.CENTER);
		leftPane.setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Team 5's Examples") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Python");
						node_1.add(new DefaultMutableTreeNode("Print Statement"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("C");
						node_1.add(new DefaultMutableTreeNode("Print Statement"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Java");
						node_1.add(new DefaultMutableTreeNode("Make a class"));
					add(node_1);
				}
			}
		));
		tree.setEditable(true);
		leftPane.add(tree, BorderLayout.CENTER);
		
		addButton = new JButton("Add?");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				splitPane.setRightComponent(addPane);
				addButton.setEnabled(false);
			}
		});
		leftPane.add(addButton, BorderLayout.SOUTH);
		
		searchBar = new JTextField();
		searchBar.setText("Search...");
		leftPane.add(searchBar, BorderLayout.NORTH);
		searchBar.setColumns(10);
		splitPane.setContinuousLayout(true);
		
		addPane = new JPanel();
		addInstructionPane = new JPanel();
		addTitlePane = new JPanel();
		addKeyWordsPane = new JPanel();
		addProgrammingLanguagePane = new JPanel();
		addCodePane = new JPanel();
		addDependenciesPane = new JPanel();
		addPublicPane = new JPanel();
		addButtonPane = new JPanel();
		
		addPane.setLayout(new GridLayout(0, 1));
		addInstructionPane.setLayout(new GridLayout(0, 1));
		addTitlePane.setLayout(new GridLayout(0, 2));
		addKeyWordsPane.setLayout(new GridLayout(0, 2));
		addProgrammingLanguagePane.setLayout(new GridLayout(0, 2));
		addCodePane.setLayout(new GridLayout(0, 2));
		addDependenciesPane.setLayout(new GridLayout(0, 2));
		addPublicPane.setLayout(new GridLayout(0, 2));
		addButtonPane.setLayout(new GridLayout(0, 2));
		
		addPane.add(addInstructionPane);
		addPane.add(addTitlePane);
		addPane.add(addKeyWordsPane);
		addPane.add(addProgrammingLanguagePane);
		addPane.add(addCodePane);
		addPane.add(addDependenciesPane);
		addPane.add(addPublicPane);
		addPane.add(addButtonPane);
		
		lblAddInstruction = new JLabel("Fill out the following feilds and click save inorder to add an entry to your Programmers Examples Notebook.");
		lblAddTitle = new JLabel("Title:");
		lblAddKeyWords = new JLabel("Key Words:");
		lblAddProgrammingLanguage = new JLabel("Language:");
		lblAddCode = new JLabel("Code:");
		lblAddDependencies = new JLabel("Dependencies:");
		lblAddPublic = new JLabel("Make Public?");
		
		tfAddTitle = new JTextField();
		tfAddKeyWords = new JTextField();
		comboAddProgrammingLanguage = new JComboBox(possibleProgrammingLanguages);
		taAddCode = new JTextArea();
		tfAddDependencies = new JTextField();
		cbAddPublic = new JCheckBox();
		btnAddCancel = new JButton("Cancel");
		btnAddSave = new JButton("Save");
		
		addInstructionPane.add(lblAddInstruction);
		addTitlePane.add(lblAddTitle);
		addKeyWordsPane.add(lblAddKeyWords);
		addProgrammingLanguagePane.add(lblAddProgrammingLanguage);
		addCodePane.add(lblAddCode);
		addDependenciesPane.add(lblAddDependencies);
		addPublicPane.add(lblAddPublic);
		
		addTitlePane.add(tfAddTitle);
		addKeyWordsPane.add(tfAddKeyWords);
		addProgrammingLanguagePane.add(comboAddProgrammingLanguage);
		addCodePane.add(taAddCode);
		addDependenciesPane.add(tfAddDependencies);
		addPublicPane.add(cbAddPublic);
		addButtonPane.add(btnAddCancel);
		addButtonPane.add(btnAddSave);
		
		ActionListener keyWordActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int totalComponents = addPane.getComponentCount();
				JPanel anotherAddKeyWordsPane = new JPanel();
				final JLabel removeLabel = new JLabel("remove");
				removeLabel.setForeground(Color.blue);
				removeLabel.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						addPane.remove(removeLabel.getParent());
						addPane.revalidate();
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						removeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						removeLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent arg0) {
					}
					@Override
					public void mouseReleased(MouseEvent arg0) {
					}
				});
				JLabel tfAnotherAddKeyWords = new JLabel(tfAddKeyWords.getText());
				tfAddKeyWords.setText("");
				anotherAddKeyWordsPane.setLayout(new GridLayout(0, 2));
				anotherAddKeyWordsPane.add(removeLabel);
				anotherAddKeyWordsPane.add(tfAnotherAddKeyWords);
				addPane.add(anotherAddKeyWordsPane, totalComponents - 5);
				addPane.revalidate();
			}
		};
		
		tfAddKeyWords.addActionListener(keyWordActionListener);
		
		btnAddCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				splitPane.setRightComponent(rightPane);
				addButton.setEnabled(true);
			}
		});
		
		btnAddSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				splitPane.setRightComponent(rightPane);
				addButton.setEnabled(true);
			}
		});
	}

}
