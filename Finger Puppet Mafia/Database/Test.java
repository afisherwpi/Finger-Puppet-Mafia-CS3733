package Database;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Test {
	
	public static void main(String [] args){
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testdb");
		
		Pilot johnDoe = new Pilot("John Doe");
		db.store(johnDoe);
		System.out.println("Stored " + johnDoe);
	}
	
}