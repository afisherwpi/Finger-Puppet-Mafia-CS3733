//package GUI;
package Database;

import Database.Database;
import Database.PersonalCodeExample;

import com.db4o.ObjectSet;
import java.applet.Applet;
import java.awt.HeadlessException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;


public class MainWindow extends Applet {
	private JTextField txtHello;
	private String[] ComboList = new String[] {"List of Items"};
	
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
		
		db.delete(testExample); // delete our test example
		
		userOneExamples = db.getExamplesByFieldValue("userID",1); // get all examples belonging to userID 1, should be empty now
		
		listResult(userOneExamples); // list new query results
		
		db.deleteDatabase(); // delete database
	}
	
	public MainWindow() throws HeadlessException {
		test();
		ComboList = append(ComboList, "4");
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ComboList));
		add(comboBox);
		
		JPanel panel = new JPanel();
		add(panel);
		
		txtHello = new JTextField();
		txtHello.setText("Hello?");
		panel.add(txtHello);
		txtHello.setColumns(10);
		// TODO Auto-generated constructor stub
	}

}
