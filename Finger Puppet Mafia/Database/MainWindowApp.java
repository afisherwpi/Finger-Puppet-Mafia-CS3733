//Created By Michael
package Database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private String[] ComboList = new String[] {"List of Items"};
	JPanel LeftPane;
	JPanel RightPane;
	private JTree tree;
	private JButton AddButton;
	private JTextField SearchBar;
	private JScrollBar scrollBar;
	private JPanel HeaderBar;
	private JPanel BottomBar;
	private JTextArea textPane;
	private JTextArea txtrPrinthellosnmichael;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel TagsPanel;
	private JLabel lblNewLabel_2;
	private JTextField txtCPrintString;
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
		RightPane = new JPanel();
		LeftPane = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,LeftPane,RightPane);
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		contentPane.add(splitPane, BorderLayout.CENTER);
		RightPane.setLayout(new BorderLayout(0, 0));
		
		scrollBar = new JScrollBar();
		RightPane.add(scrollBar, BorderLayout.EAST);
		
		HeaderBar = new JPanel();
		RightPane.add(HeaderBar, BorderLayout.NORTH);
		HeaderBar.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Print Statement (with string)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		HeaderBar.add(lblNewLabel, BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel("<html>When you want to add a string to a print statement you use '%s' and then add your string after the comma in the print statement.</html>");
		
		HeaderBar.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		BottomBar = new JPanel();
		RightPane.add(BottomBar, BorderLayout.SOUTH);
		
		TagsPanel = new JPanel();
		BottomBar.add(TagsPanel);
		
		lblNewLabel_2 = new JLabel("Tags: ");
		TagsPanel.add(lblNewLabel_2);
		
		txtCPrintString = new JTextField();
		txtCPrintString.setEditable(false);
		txtCPrintString.setText("C, Print, String");
		TagsPanel.add(txtCPrintString);
		txtCPrintString.setColumns(10);
		
		textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n41\n42\n43\n44\n45\n46\n47\n48\n49\n50");
		textPane.setBackground(Color.LIGHT_GRAY);
		RightPane.add(textPane, BorderLayout.WEST);
		
		txtrPrinthellosnmichael = new JTextArea();
		txtrPrinthellosnmichael.setText("Print('Hello %s\\n',\"Michael\");");
		RightPane.add(txtrPrinthellosnmichael, BorderLayout.CENTER);
		LeftPane.setLayout(new BorderLayout(0, 0));
		
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
		LeftPane.add(tree, BorderLayout.CENTER);
		
		AddButton = new JButton("Add?");
		LeftPane.add(AddButton, BorderLayout.SOUTH);
		
		SearchBar = new JTextField();
		SearchBar.setText("Search...");
		LeftPane.add(SearchBar, BorderLayout.NORTH);
		SearchBar.setColumns(10);
		splitPane.setContinuousLayout(true);
		

		
		

	}

}

