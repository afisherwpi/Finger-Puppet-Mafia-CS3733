package Database;

public class Category {
	/** 
	 * @author Dale
	 */
	
	private long ID;
	private long parent_ID;
	private boolean is_public;
	private String category;
	private long user_ID;
	
	Category(long ID,
			long parent_ID,
			boolean is_public,
			String category,
			long user_ID) {
		this.ID = ID;
		this.parent_ID = parent_ID;
		this.is_public = is_public;
		this.category = category;
		this.user_ID = user_ID;
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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

}