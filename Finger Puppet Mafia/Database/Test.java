package Database;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Date;
import java.util.List;

public class Test {
	
	// listResut: List<?> -> void
	// consumes a list and prints its contents to the console
	public static void listResult(List<?> result){
	    System.out.println(result.size());
	    for (Object o : result) {
	        System.out.println(o);
	    }
	}
	
	public static void main(String [] args){
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testdb"); // open database stored in file "testdb" and create one if it's not there
		
		// create test example
		PersonalCodeExample testExample = new PersonalCodeExample(
				1,
				1,
				"Test Code Example",
				"This example is for testing purposes only.",
				"Team High Fives go!!!",
				new Date(), // Date in milliseconds.  This is 11/3 at 2:50 PM
				new Date(),
				false,
				"Plain Text",
				false
				);
		
		db.store(testExample); // store test example in database
		System.out.println("Stored " + testExample); // print out result to make sure it was properly stored
		
		Query query = db.query(); // construct SODA query - SODA queries are the fastest in db4o
		query.constrain(PersonalCodeExample.class); // tell the query we're looking for a code example
		query.descend("userID").constrain(1); // tell the query we want the code example with user id 1
		ObjectSet<PersonalCodeExample> userOneExamples = query.execute(); // get the results of the query and store them in a list
		
		listResult(userOneExamples); // list the query results
	}
	
}