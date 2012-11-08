package Controllers;

import java.awt.Component;
import java.awt.Container;

import DesktopViews.AddView;
import DesktopViews.DisplayView;
import DesktopViews.SearchView;
import DesktopViews.SplitView;

public class SplitController {
	private SplitView view;
	private SearchController searchController;
	private DisplayController displayController;
	private AddController addController;

	public SplitController(SplitView sview){
		view = sview;
	}
	
	public void go(){
		System.out.println("test");
		searchController = new SearchController(new SearchView(), this);
		displayController = new DisplayController(new DisplayView());
		
		view.setRight(displayController.getView());
		System.out.println("test3");
		view.setLeft(searchController.getView());
		//view.setRight(displayController.getView());
		
		searchController.go();
		displayController.go();
	}
	
	public Container getView() {
		return view.getView();
	}

	public void addButtonPressed() {
		addController = new AddController(new AddView(), this);
		addController.go();
		view.setRight(addController.getView());
		searchController.disableAddButton();
	}
	
	public void addCancelButtonPressed() {
		view.setRight(displayController.getView());
		searchController.enableAddButton();
	}
	
	public void addSaveButtonPressed() {
		view.setRight(displayController.getView());
		searchController.enableAddButton();
	}

}
