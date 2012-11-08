package Database;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
	
	public static void main(String [] args){
		Database db = new Database("testdb");
		
		// List of categories
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1010, false, "TestCategory", 1));
		
		// create test example
		CodeExample testExample = new CodeExample(
				1,
				1,
				"Test Code Example",
				"This example is for testing purposes only.",
				"Team High Fives go!!!",
				new Date(), // a new Date object will always contain the latest time information
				new Date(),
				false,
				"Plain Text",
				false,
				categories
				);
		
		db.store(testExample); // store test example in database
		System.out.println("Stored " + testExample); // print out result to make sure it was properly stored
		
		ObjectSet<CodeExample> userOneExamples = db.getExamplesByFieldValue("userID",1); // get all examples belonging to userID 1
		
		listResult(userOneExamples); // list the examples from the query
		
		//db.delete(testExample); // delete our test example
		
		userOneExamples = db.getExamplesByFieldValue("userID",1); // get all examples belonging to userID 1, should be empty now
		
		listResult(userOneExamples); // list new query results
		
		//db.deleteDatabase(); // delete database
	}
	
	// listResut: List<?> -> void
	// consumes a list and prints its contents to the console.
	public static void listResult(List<?> result){
	    System.out.println(result.size());
	    for (Object o : result) {
	        System.out.println(o);
	    }
	}
}