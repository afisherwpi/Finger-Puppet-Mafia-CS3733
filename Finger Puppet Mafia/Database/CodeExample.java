package Database;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/** CodeExample: The standard class for a code example
 * @author Trevor
 */
public class CodeExample {
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
		private List<Category> categories; // All categories that CodeExample is under
		
		CodeExample(
				long ID,
				long user_ID,
				String title,
				String description,
				String code,
				Date dateCreated,
				Date dateModified,
				boolean isPublic,
				String language,
				boolean isDeleted,
				List<Category> categories){
			this.ID = ID;
			this.userID = user_ID;
			this.title = title;
			this.description = description;
			this.code = code;
			this.dateCreated = dateCreated;
			this.dateModified = dateModified;
			this.isPublic = isPublic;
			this.language = language;
			this.isDeleted = isDeleted;
			this.categories = categories;
			this.linkWithCategories(categories);
		}
		
		private void linkWithCategories(List<Category> categories) {
			for (int i = 0; i < categories.size(); i++) {
				categories.get(i).addExampleToCat(this);
			}
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
			return userID;
		}

		/**
		 * @param user_ID the user_ID to set
		 */
		public void setUser_ID(long user_ID) {
			this.userID = user_ID;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * @return the dateCreated
		 */
		public Date getDateCreated() {
			return dateCreated;
		}

		/**
		 * @param dateCreated the dateCreated to set
		 */
		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

		/**
		 * @return the dateModified
		 */
		public Date getDateModified() {
			return dateModified;
		}

		/**
		 * @param dateModified the dateModified to set
		 */
		public void setDateModified(Date dateModified) {
			this.dateModified = dateModified;
		}

		/**
		 * @return the isPublic
		 */
		public boolean isPublic() {
			return isPublic;
		}

		public void makePublic() {
			this.isPublic = true;
		}
		
		public void makePrivate() {
			this.isPublic = false;
		}
		
		/**
		 * @return the language
		 */
		public String getLanguage() {
			return language;
		}

		/**
		 * @param language the language to set
		 */
		public void setLanguage(String language) {
			this.language = language;
		}

		/**
		 * @return the isDeleted
		 */
		public boolean isDeleted() {
			return isDeleted;
		}
 
		/**
		 * @param isDeleted the isDeleted to set
		 */
		public void setDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		
		/**
		 * Adds the specified category to the list of categories, then
		 * adds itself to the category's list of examples.
		 *
		 * @param category the category to add this example to
		 */
		public void addCategory(Category category){
			this.categories.add(category);
			category.addExample(this);
		}
		
		/**
		 * Removes a category from this codeExample's categories list
		 * @param category the category to remove
		 * @return whether it was successful or not
		 */
		public boolean removeCategory(Category category) {
			return categories.remove(category);
		}
}
