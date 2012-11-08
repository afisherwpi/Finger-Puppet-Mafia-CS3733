package Controllers;

import java.awt.Container;

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

}
