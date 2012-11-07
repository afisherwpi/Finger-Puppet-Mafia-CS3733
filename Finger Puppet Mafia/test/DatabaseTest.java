package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.easymock.EasyMock;
import static org.easymock.classextension.EasyMock.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
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
		category = EasyMock.createStrictMock(Category.class);
	}
	
	@After
	public void cleanUp(){
		database.closeDatabase();
	}

	@Test
	public void testCategoryContainedIn() {
		
		expect(category.getName()).andReturn("java").times(1);
		replay(category);
		
		List<String> test_names = new  ArrayList<String>();
		test_names.add("java");
		test_names.add("oracle");
		test_names.add("eclipse");
		test_names.add("XML");
		
		assertTrue("result", database.categoryContainedIn(category, test_names));
		
		verify(category);
		
		database.categoryContainedIn(category, test_names);
	}

}
