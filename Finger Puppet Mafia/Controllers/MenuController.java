package Controllers;

import java.awt.Container;

import Database.Database;
import DesktopViews.MenuView;

public class MenuController {
	private MenuView view;
	private  Database db;

	public MenuController(MenuView mview,  Database mydb){
		view = mview;
		db = mydb;
	}
	
	public void go(){
		
	}
	public Container getView() {
		// TODO Auto-generated method stub
		return view.getView();
	}

}
