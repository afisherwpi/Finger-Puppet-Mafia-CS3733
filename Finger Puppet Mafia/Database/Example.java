package Database;

import java.util.ArrayList;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		Database db = new Database("exampledb.db4o");
		
		// Add some categories
		db.addCategory("category1", false);
		db.addCategory("category2", false);
		db.addCategory("category3", false);
		db.addCategory("deleteme", false);

		// Get stored categories
		List<String> categories = db.getCategoryNames();
		listResult(categories);
		
		System.out.println("--------------");
		
		// Delete a category
		db.deleteCategory("deleteme");
		categories = db.getCategoryNames();
		listResult(categories);
		
		// Construct a list of categories
		List<String> codeCategories = new ArrayList<String>();
		codeCategories.add("category1");
		codeCategories.add("category2");
		
		// Add a code example
		db.addCodeExample("myexample","mydescription", 
							"while (true)", "Java",
							codeCategories, false);
		
		System.out.println("--------------");
		
		// Get examples under a category name
		// Note: This only returns code titles at the moment
		List<String> examples = db.getExampleNames("category1");
		listResult(examples);
		
		// Get a CodeExample object from the database
		List<CodeExample> examplelist = db.getExamplesByFieldValue("title", "myexample");
		CodeExample codeexample = examplelist.get(0);
		
		// Get the title
		String title = codeexample.getTitle();
		System.out.println("Title: "+title);
		// Get the actual code
		String code = codeexample.getCode();
		System.out.println("Code: "+code);
		// Get the description
		String description = codeexample.getDescription();
		System.out.println("Description: "+description);
		// Get the language
		String language = codeexample.getLanguage();
		System.out.println("Language: "+language);
		
		// Make sure to close the database when you're done
		db.close();
	}
	
	private static void listResult(List<?> result){
	    for (Object o : result) {
	        System.out.println(o);
	    }
	}
}
