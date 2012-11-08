package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.db4o.ObjectSet;

import Database.CodeExample;
import Database.Database;
import Database.Category;
import java.util.List;
import java.util.ArrayList;

public class DatabaseTest {
	
	private Database database;
	private Category category;
	
	@Before
	public void setUp(){
		database = new Database("testing_db");
		category = createMock(Category.class);
		
		database.addCategory("java", true);
		database.addCategory("oracle", true);
		database.addCategory("db4o", true);
		database.addCategory("eclipse", true);
		
		List<String> categories = new ArrayList<String>();
		categories.add("java");
		categories.add("oracle");
		
		//populate the database with a few things... for science
		
		database.addCodeExample("tester1", "for testing", "test.test() + this.that()", "Java", categories, true);
		
		categories.remove("java");
		
		database.addCodeExample("tester2", "for testing", "//only comments", "C++", categories, true);
		
		categories.remove("oracle");
		categories.add("db4o");
		categories.add("eclipse");
		
		database.addCodeExample("tester3", "im smart", "some db4o stuff here...", "Java", categories, true);
	}
	
	@After
	public void cleanUp(){
		
		// clean up the database
		database.closeDatabase();
		database.deleteDatabase();
	}

	@Test
	public void testCategoryContainedIn(){
		
		// setup expectations here
		expect(category.getName()).andReturn("db4o").times(3);
		expect(category.getName()).andReturn("java").times(1);
		
		// now make the mock object available
		replay(category);
		
		// prepare the list of test names 
		List<String> test_names = new  ArrayList<String>();
		test_names.add("java");
		test_names.add("oracle");
		test_names.add("eclipse");
		
		// actually run the test
		assertFalse(database.categoryContainedIn(category, test_names));
		assertTrue(database.categoryContainedIn(category, test_names));
		
		// verify that the mock was called correctly
		verify(category);
	}
	
	@Test
	public void testGetExamplesByFieldValue(){
		// put this one through its paces by querying for different fields/values
		// including ones that don't exist in the database
		// the only field we won't test here is categories. that's a different function
		ObjectSet<CodeExample> return_val = database.getExamplesByFieldValue("language", "Java");
		assertEquals("testGetExamplesByFieldValue Result1", 2, return_val.size());
		return_val = database.getExamplesByFieldValue("isPublic", true);
		assertEquals("testGetExamplesByFieldValue Result2", 3, return_val.size());
		return_val = database.getExamplesByFieldValue("title", "tester1");
		assertEquals("testGetExamplesByFieldValue Result3", 1, return_val.size());
		return_val = database.getExamplesByFieldValue("description", "for testing");
		assertEquals("testGetExamplesByFieldValue Result4", 2, return_val.size());
		return_val = database.getExamplesByFieldValue("isPublic", false);
		assertEquals("testGetExamplesByFieldValue Result5", 0, return_val.size());
		return_val = database.getExamplesByFieldValue("isPublic", true);
		assertEquals("testGetExamplesByFieldValue Result6", 3, return_val.size());
	}
	
	@Test
	public void testGetCategories(){
		// First test this on a populated database
		List<Category> existing_cats = new ArrayList<Category>();
		existing_cats = database.getCategories();
		assertEquals("Result", 4, existing_cats.size());
		
		// now initialize a new database that will be empty and test
		Database empty = new Database("empty");
		existing_cats = empty.getCategories();
		assertEquals("Result", 0, existing_cats.size());
		
		// close and delete new database
		empty.closeDatabase();
		empty.deleteDatabase();
	}
	
	@Test
	public void testGetCategoryNames(){
		// this function calls getCategories and then retrieves the names from each category individually
		List<String> names_test = new ArrayList<String>();	
		
		// set up an expected return value
		List<String> names_expected = new ArrayList<String>();
		names_expected.add("java");
		names_expected.add("oracle");
		names_expected.add("db4o");
		names_expected.add("eclipse");
		
		// call the function
		names_test = database.getCategoryNames();
		
		// run the test
		assertEquals("testGetCategoryNames Result",names_expected, names_test);
		
	}
	
	@Ignore // remove this line once this function is fixed
	@Test (expected = RuntimeException.class) // trying to add an existing cat throws an exception
	public void testAddCategory(){
		// this function is supposed to add a category to the DB
		// first things first, call the function to add a new category that isn't already there
		
		database.addCategory("tester_cat", true);
		
		// now check to see if it's there
		
		assertTrue(database.getCategoryNames().contains("tester_cat"));
		
		// now add one that's already there
		
		database.addCategory("java", true);
		
	}
	
	
}
