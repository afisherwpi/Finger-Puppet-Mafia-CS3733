package Database;

import java.util.List;
import java.util.ArrayList;

public class Category {
	/**
	 * @author Dale
	 */
	
	private long ID;
	private long parent_ID;
	private boolean is_public;
	private String title;
	private long user_ID;
	private List<CodeExample> examples; // all examples under Category
	
	Category(boolean is_public,
			String name,
			long user_ID) {
		this.is_public = is_public;
		this.title = name;
		this.user_ID = user_ID;
		this.examples = new ArrayList<CodeExample>();
	}

	/**
	 * @return the ID
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param ID the ID to set
	 */
	public void setID(long ID) {
		this.ID = ID;
	}

	/**
	 * @return the parent_ID
	 */
	public long getParent_ID() {
		return parent_ID;
	}

	/**
	 * @param parent_ID the parent_ID to set
	 */
	public void setParent_ID(long parent_ID) {
		this.parent_ID = parent_ID;
	}

	/**
	 * @return the is_public
	 */
	public boolean isIs_public() {
		return is_public;
	}

	/**
	 * @param is_public the is_public to set
	 */
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return title;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.title = name;
	}

	/**
	 * @return the user_ID
	 */
	public long getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID the user_ID to set
	 */
	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}
	
	
	/**
	 * @param example the example to be added to this category
	 */
	public void addExample(CodeExample example){
		this.examples.add(example);
	}
}