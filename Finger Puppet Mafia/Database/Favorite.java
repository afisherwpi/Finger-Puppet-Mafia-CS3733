package Database;

public class Favorite {
	
	private long ID;
	private long code_ID;
	private long user_ID;
	
	Favorite(long iD, 
			long code_ID, 
			long user_ID) {
		this.ID = iD;
		this.code_ID = code_ID;
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
	 * @return the code_ID
	 */
	public long getCode_ID() {
		return code_ID;
	}

	/**
	 * @param code_ID the code_ID to set
	 */
	public void setCode_ID(long code_ID) {
		this.code_ID = code_ID;
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
