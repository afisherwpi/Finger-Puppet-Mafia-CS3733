package Controllers;

import java.awt.Container;

import DesktopViews.MenuView;

public class MenuController {
	private MenuView view;

	public MenuController(MenuView mview){
		view = mview;
	}
	
	public void go(){
		
	}
	public Container getView() {
		// TODO Auto-generated method stub
		return view.getView();
	}

}
