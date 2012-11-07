//package GUI;
package Database;

import Database.Database;
import Database.PersonalCodeExample;

import com.db4o.ObjectSet;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JTree;


public class MainWindow extends Applet {
	private JTextField txtHello;
	private String[] ComboList = new String[] {"List of Items"};
	JPanel LeftPane;
	JPanel RightPane;
	private JTree tree;
	private JButton btnNewButton;
	private JTextField txtSearch;
	

	
	
	
	static <T> T[] append(T[] arr, T element) {
	    final int N = arr.length;
	    arr = Arrays.copyOf(arr, N + 1);
	    arr[N] = element;
	    return arr;
	}
	public static void listResult(List<?> result){
	    System.out.println(result.size());
	    for (Object o : result) {
	        System.out.println(o);
	    }
	}
	public void test() {
		Database db = new Database("testdb");
		
		// create test example
		PersonalCodeExample testExample = new PersonalCodeExample(
				1,
				1,
				"Test Code Example",
				"This example is for testing purposes only.",
				"Team High Fives go!!!",
				new Date(), // a new Date object will always contain the latest time information
				new Date(),
				false,
				"Plain Text",
				false
				);
		
		db.store(testExample); // store test example in database
		System.out.println("Stored " + testExample); // print out result to make sure it was properly stored
		
		ObjectSet<PersonalCodeExample> userOneExamples = db.getExamplesByFieldValue("userID",1); // get all examples belonging to userID 1
		
		listResult(userOneExamples); // list the examples from the query
		
		//db.delete(testExample); // delete our test example
		
		userOneExamples = db.getExamplesByFieldValue("userID",1); // get all examples belonging to userID 1, should be empty now
		
		listResult(userOneExamples); // list new query results
		
		//db.deleteDatabase(); // delete database
	}
	
	public MainWindow() throws HeadlessException {
		setLayout(new BorderLayout(0, 0));
		
		RightPane = new JPanel();
		LeftPane = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,LeftPane,RightPane);
		add(splitPane, BorderLayout.CENTER);
		RightPane.setLayout(new BorderLayout(0, 0));
		LeftPane.setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		tree.setEditable(true);
		LeftPane.add(tree, BorderLayout.CENTER);
		
		btnNewButton = new JButton("Add?");
		LeftPane.add(btnNewButton, BorderLayout.SOUTH);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search...");
		LeftPane.add(txtSearch, BorderLayout.NORTH);
		txtSearch.setColumns(10);
		splitPane.setContinuousLayout(true);
		

		


	}

}
