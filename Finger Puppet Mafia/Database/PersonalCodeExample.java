package Database;
import java.util.Date;

/* PersonalCodeExample:
 * The standard class for a code example.
 */
public class PersonalCodeExample {
	private long ID; // unique identifier of code example
	private long userID; // unique identifier of the user this example belongs to
	private String title;
	private String description;
	private String code;
	private Date dateCreated;
	private Date dateModified;
	private boolean isPublic;
	private String language; // Should the language be a string?
	private boolean isDeleted; // Perhaps the deleted examples should go to a separate database?
	
	PersonalCodeExample(
			long ID,
			long userID,
			String title,
			String description,
			String code,
			Date dateCreated,
			Date dateModified,
			boolean isPublic,
			String language,
			boolean isDeleted){
		this.ID = ID;
		this.userID = userID;
		this.title = title;
		this.description = description;
		this.code = code;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.isPublic = isPublic;
		this.language = language;
		this.isDeleted = isDeleted;
	}
	
	public long getID(){
		return this.ID;
	}
	
	public long getUserID(){
		return this.userID;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public Date getDateCreated(){
		return this.dateCreated;
	}
	
	public Date getDateModified(){
		return this.dateModified;
	}
	
	public boolean getIsPublic(){
		return this.isPublic;
	}
	
	public String getLanguage(){
		return this.language;
	}
	
	public boolean getIsDeleted(){
		return this.isDeleted;
	}
}
