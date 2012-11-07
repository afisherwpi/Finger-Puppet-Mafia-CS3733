package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import Database.*;

public class DatabaseTest {
	
	private Database database;
	private Category category;
	
	@Before
	public void setUp(){
		database = new Database("testing_db");
		category = EasyMock.createMock(Category.class);
	}

	@Test
	public void testCategoryContainedIn() {
		
	}

}
