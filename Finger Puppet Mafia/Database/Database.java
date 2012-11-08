package Database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.db4o.query.Predicate;

public class Database {
	private String dbName;
	private ObjectContainer db;
	EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
	
	public Database(String name){
		this.dbName = name;
		config.common().objectClass(Category.class).cascadeOnUpdate(true);
		// open database stored in file "testdb" and create one if it's not there
		this.db = Db4oEmbedded.openFile(config, name);
	}
	
	public void close() {
		db.close();
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
	public ObjectSet<CodeExample> getExamplesByFieldValue(String field, Object value){
		Query query = db.query(); // construct SODA query - SODA queries are the fastest in db4o
		query.constrain(CodeExample.class); // tell the query we're looking for a code example
		query.descend(field).constrain(value); // tell the query to search the code example's for a (field) equivalent to (value) (example: ...for a Name equivalent to John)
		return query.execute(); // get the results of the query
	}
	
	/**getCategoryNames - Retrieves all category names in the database (not objects)
	 * 
	 * @return a List of all category names in the database
	 */
	public List<String> getCategoryNames() {
		// Get all Category objects from the database
		List<Category> categories = getCategories();
		List<String> names = new ArrayList<String>();
		
		// Go through each Category object and retrieve its String name
		for (int i = 0; i < categories.size(); i++) {
			names.add(categories.get(i).getName());
		}
		
		return names;
	}
	
	
	/**
	 * @param ID the unique ID of the user whose CodeExamples we're looking for
	 * @return a List of CodeExamples created by the user with the specified unique ID
	 * 
	 * @author Trevor Behlman
	 */
	public List<Category> getCategories(){
		return db.query(new Predicate<Category>(){
			public boolean match(Category category){
				return true;
			}
		});
	}
	
	/**addCategory - Adds a new Category object to the database
	 * @param name - Name of the category
	 * @param isPublic - true if the category is public
	 * @return true if the category was added successfully
	 * 
	 * @author John Pham
	 */
	public boolean addCategory(String name, String description, boolean isPublic) {
		Query query = db.query(); // construct SODA query - SODA queries are the fastest in db4o
		query.constrain(Category.class); // tell the query we're looking for a category
		query.descend("title").constrain(name); // tell the query to search the categories for a title equivalent to name
		if (query.execute().size() > 0) { //if the database contains a category already with title name
			System.out.println("The category you are trying to add ("+name+") is already in the database.");
			return false;
		}
		// Construct a Category object
		Category toAdd = new Category(isPublic, name, description, 1);
		// store the Category object
		db.store(toAdd);
		System.out.println("New category added: "+toAdd);
		return true;
	}
	
	/**deleteCategory - Finds and deletes a category by name
	 * 
	 * @param name - The name of the category to be deleted
	 * @return true if the deletion was successful
	 */
	public boolean deleteCategory(String name) {
		
		// Store the String name into a list for passing to getCategories()
		List<String> nameParam = new ArrayList<String>();
		nameParam.add(name);
		// Retrieve Category object by String name
		List<Category> category = getCategories(nameParam);

		// If a match was found, delete it and remove it from each code's categories field
		// otherwise print notification
		if (category.size() > 0) {
			
			for(int i = 0; i < category.get(0).getExamples().size() ; i++){
				category.get(0).getExamples().get(i).removeCategory(category.get(0)); //this just says that for each CodeExample in the Category's "examples" field, remove this Category from that CodeExample's "categories" field
			}
			
			db.delete(category.get(0));
			System.out.println(name+" deleted."); 
			return true;
		} else {
			System.out.println("Category not found.");
			return false;
		}
	}
	
	/**getExampleNames - Retrieves the String names of each example
	 * 						associated with a category name
	 * @param categoryName - The name of the category
	 * @return a List of String names of each example
	 */
	public List<String> getExampleNames(String categoryName) {
		return getExampleNames(getCategoryExamples(categoryName));
	}
	
	/**getExampleNames - Retrieves the String names of a list of CodeExamples
	 * 
	 * @param examples a List of CodeExamples
	 * @return a List of String names of each example
	 */
	public List<String> getExampleNames(List<CodeExample> examples) {
		// Go through each CodeExample object and retrieve its title
		List<String> exampleNames = new ArrayList<String>();		
		for (int i = 0; i < examples.size(); i++) {
			exampleNames.add(examples.get(i).getTitle());
		}
		
		return exampleNames;
	}
	
	/**getCategoryExamples - Returns a Category's list of associated code examples by 
	 * 							category name
	 *
	 * @param categoryName - Name of the category
	 * @return a List of the CodeExample objects associated with the category
	 */
	public List<CodeExample> getCategoryExamples(String categoryName) {
		return getCategoryObject(categoryName).getExamples();
	} 
	
	/**getCategoryObject - Retrieve a Category object by its String name
	 * 
	 * @param categoryName - String name of the object
	 * @return The Category object corresponding to the String name
	 */
	public Category getCategoryObject(String categoryName) {
		// Store the name into a list for passing to getCategories()
		List<String> nameParam = new ArrayList<String>();
		nameParam.add(categoryName);
		// Retrieve each Category object by String name
		List<Category> category = getCategories(nameParam);
		
		// Return the Category object found
		return category.get(0);
	}
	
	/**addCodeExample - Add a new code example to the database
	 * @param title - The title of the new code example
	 * @param description - The text description of the new code example
	 * @param code - code of the new code example
	 * @param language - Language that the code example is written in
	 * @param categories - a List of category names (Strings)
	 * @param isPublic - boolean declaring whether or not the example is public
	 * @return true if the code example was successfully added
	 * 
	 * @author John Pham
	 */
	public boolean addCodeExample(String title, String description, String code, 
										String language, final List<String> categories, boolean isPublic) {
		
		// Converting the string names into actual Category objects
		List<Category> categoryObjs = new ArrayList<Category>();
		for (int i = 0; i < categories.size(); i++) {
			categoryObjs.add(getCategoryObject(categories.get(i)));
		}
		
		// Stop operation if a category does not exist
		if (categoryObjs.size() == 0) {
			System.out.println("No categories found.");
			return false;
		}
		
		// Create the CodeExample object using given information
		Date currentDate = new Date();
		CodeExample example = new CodeExample(1, 1, title, description, code, currentDate, currentDate, 
												isPublic, language, false, categoryObjs);
		
		// Update all associated categories
		for (int i = 0; i < categoryObjs.size(); i++) {
			db.store(categoryObjs.get(i));
		}
		
		System.out.println("New code example added.");
		return true;
	}
	
	/**getCategories - Gets a list of Category objects based on a list of category names
	 * @param categories - A List of category names (Strings)
	 * @return A List of categories with matching category names
	 * 
	 * @author John Pham
	 */
	public List<Category> getCategories(final List<String> categories) {
		return db.query(new Predicate<Category>(){
			public boolean match(Category category){
				return categoryContainedIn(category, categories);
			}
		});
	}
	
	/**categoryContainedIn - Checks if the Category object matches any of the category names
	 * @param category - Category object to be compared with list of names
	 * @param names - A List of category names (Strings)
	 * @return true if a match is found
	 * 
	 * @author John Pham
	 */
	public boolean categoryContainedIn(Category category, List<String> names) {
		for (int i = 0; i < names.size(); i++) {
			if (category.getName().equals(names.get(i))) 
				return true;
		}
		return false;
	}
	
	/*
	public void refreshAllCategories(List<Category> categories) {
		Category candidate = new Category();
		for (int i = 0; i < categories.size(); i++) {
			candidate = categories.get(i);
			db.ext().refresh(candidate, 5);
		}
	}
	*/
	
	public void deleteDatabase(){
		new File(this.dbName).delete();
	}
}
