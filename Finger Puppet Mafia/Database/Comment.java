package Database;
import java.util.Date;

public class Comment {
	private long ID; 
	private long user_ID; 
	private long code_ID;
	private String comment;
	private Date date_posted;

	Comment(
			long ID,
			long user_ID,
			String comment,
			Date date_posted,
			long code_ID){
		this.ID = ID;
		this.user_ID = user_ID;
		this.comment = comment;
		this.code_ID = code_ID;
		this.date_posted = date_posted;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the date_posted
	 */
	public Date getDate_posted() {
		return date_posted;
	}

	/**
	 * @param date_posted the date_posted to set
	 */
	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}
	
}