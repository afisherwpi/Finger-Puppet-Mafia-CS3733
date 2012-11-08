package Controllers;

import java.awt.Container;

import DesktopViews.DisplayView;

public class DisplayController {
	private DisplayView view;
	
	// constructor will probably need to include the SplitController on top of this in the future.
	public DisplayController(DisplayView dview){
		view = dview;
	}
	
	public void go() {
		
	}

	public Container getView() {
		// TODO Auto-generated method stub
		return view.getView();
	}

}
