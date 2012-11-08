package Controllers;

import java.awt.Container;

import DesktopViews.*;

public class ContainerController {
	private ContainerView view;
	private SplitController splitController;
	private MenuController menuController;
	
	
	
	public ContainerController(ContainerView cView){
		view = cView;	
	}
	
	public Container getView(){
		return view.getView();
	}
	
	public void go(){
		splitController = new SplitController(new SplitView());
		menuController = new MenuController(new MenuView());
		view.addCenter(splitController.getView());
		view.addNorth(menuController.getView());
		splitController.go();
		menuController.go();
	}

}
