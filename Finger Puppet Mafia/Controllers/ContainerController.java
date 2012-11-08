package Controllers;

import java.awt.Container;

import Database.Database;
import DesktopViews.*;

public class ContainerController {
	private ContainerView view;
	private Database db;
	private SplitController splitController;
	private MenuController menuController;
	
	
	
	public ContainerController(ContainerView cView, Database mydb){
		view = cView;
		db = mydb;
		
	}
	
	public Container getView(){
		return view.getView();
	}
	
	public void go(){
		splitController = new SplitController(new SplitView(), db);
		menuController = new MenuController(new MenuView(), db);
		view.addCenter(splitController.getView());
		view.addNorth(menuController.getView());
		splitController.go();
		menuController.go();
	}

}
