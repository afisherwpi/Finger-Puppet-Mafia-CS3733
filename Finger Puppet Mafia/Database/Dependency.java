package Database;

public class Dependency {
	private long ID;
	private long code_ID1;
	private long code_ID2;
	
	Dependency(long ID,
				long code_ID1,
				long code_ID2) {
		this.ID = ID;
		this.code_ID1 = code_ID1;
		this.code_ID2 = code_ID2;
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
	 * @return the code_ID1
	 */
	public long getCode_ID1() {
		return code_ID1;
	}

	/**
	 * @param code_ID1 the code_ID1 to set
	 */
	public void setCode_ID1(long code_ID1) {
		this.code_ID1 = code_ID1;
	}

	/**
	 * @return the code_ID2
	 */
	public long getCode_ID2() {
		return code_ID2;
	}

	/**
	 * @param code_ID2 the code_ID2 to set
	 */
	public void setCode_ID2(long code_ID2) {
		this.code_ID2 = code_ID2;
	}

}
