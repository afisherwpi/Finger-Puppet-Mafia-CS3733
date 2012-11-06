package Database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;

public class Database {
	private String dbName;
	private ObjectContainer db;
	
	Database(String name){
		this.dbName = name;
		// open database stored in file "testdb" and create one if it's not there
		this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), name);
	}
	
	// store: Object -> void
	// consumes any object and stores it into the database.
	public void store(Object o){
		db.store(o);
	}
	
	// delete: Object -> void
	// consumes any object and deletes it from the database.
	public void delete(Object o){
		db.delete(o);
	}
	
	// getExamplesByUserID: long -> ObjectSet<PersonalCodeExample>
	// consumes a user ID and produces a list of code examples which belong
	// to that user ID.
	public ObjectSet<PersonalCodeExample> getExamplesByFieldValue(String field, Object value){
		Query query = db.query(); // construct SODA query - SODA queries are the fastest in db4o
		query.constrain(PersonalCodeExample.class); // tell the query we're looking for a code example
		query.descend(field).constrain(value); // tell the query to search the code example's for a (field) equivalent to (value) (example: ...for a Name equivalent to John)
		return query.execute(); // get the results of the query
	}
	
	public void deleteDatabase(){
		new File(this.dbName).delete();
	}
}
