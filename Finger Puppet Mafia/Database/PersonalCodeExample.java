package Database;
import java.util.Date;

/* PersonalCodeExample:
 * The standard class for a code example.
 */
public class PersonalCodeExample {
	long ID;
	long userID;
	String title;
	String description;
	String code;
	Date dateCreated;
	Date dateModified;
	boolean isPublic;
	String language; // Should the language be a string?
	boolean isDeleted; // Perhaps the deleted examples should go to a separate database?
	
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
}
