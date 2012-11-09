package Controllers;

import java.awt.Container;

import Database.CodeExample;
import Database.Database;
import DesktopViews.DisplayView;

public class DisplayController {
	private DisplayView view;
	private  Database db;
	
	// constructor will probably need to include the SplitController on top of this in the future.
	public DisplayController(DisplayView dview,  Database mydb){
		view = dview;
		db = mydb;
	}
	
	public void go() {
		
	}

	public Container getView() {
		// TODO Auto-generated method stub
		return view.getView();
	}

	public void displayCode(String title) {
		CodeExample code = db.getExamplesByFieldValue("title", title).get(0);
		view.getTitleLabel().setText(code.getTitle());
		view.getCodeArea().setText(code.getCode());
		view.getDescriptionLabel().setText(code.getDescription());
		view.getKeyWordsText().setText("");
		
	}

}
