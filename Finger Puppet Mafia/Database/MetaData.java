package Database;

public class MetaData {

	private long ID;
	private Object type;
	private Object metaData;
	
	MetaData(long ID,
			Object type,
			Object metaData) {
		this.ID = ID;
		this.type = type;
		this.metaData = metaData;
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
	 * @return the type
	 */
	public Object getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Object type) {
		this.type = type;
	}

	/**
	 * @return the metaData
	 */
	public Object getMetaData() {
		return metaData;
	}

	/**
	 * @param metaData the metaData to set
	 */
	public void setMetaData(Object metaData) {
		this.metaData = metaData;
	}
	
}
