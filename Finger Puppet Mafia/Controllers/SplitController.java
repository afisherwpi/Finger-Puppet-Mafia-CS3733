package Controllers;

import java.awt.Container;

import Database.Database;
import DesktopViews.AddView;
import DesktopViews.DisplayView;
import DesktopViews.SearchView;
import DesktopViews.SplitView;

public class SplitController {
	private SplitView view;
	private Database db;
	private SearchController searchController;
	private DisplayController displayController;
	private AddController addController;

	public SplitController(SplitView sview, Database mydb){
		view = sview;
		db = mydb;
	}
	
	public void go(){
		searchController = new SearchController(new SearchView(), this, db);
		displayController = new DisplayController(new DisplayView(), db);
		
		view.setRight(displayController.getView());
		view.setLeft(searchController.getView());
		
		searchController.go();
		displayController.go();
	}
	
	public Container getView() {
		return view.getView();
	}

	public void addButtonPressed() {
		addController = new AddController(new AddView(), this, db);
		addController.go();
		view.setRight(addController.getView());
		searchController.disableAddButton();
	}
	
	public void addCancelButtonPressed() {
		view.setRight(displayController.getView());
		searchController.enableAddButton();
	}
	
	public void addSaveButtonPressed(String title) {
		view.setRight(displayController.getView());
		searchController.addCodeExample(title);
		searchController.enableAddButton();
	}

}
