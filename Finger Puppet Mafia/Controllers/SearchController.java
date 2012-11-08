package Controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DesktopViews.SearchView;

public class SearchController {
	private SearchView view;
	private SplitController splitController;
	
	public SearchController(SearchView sview, SplitController scon){
		view = sview;
		splitController = scon;
	}
	
	public void go(){
		view.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				splitController.addButtonPressed();
				view.getAddButton().setEnabled(false);
			}
		});
	}
	
	public Container getView(){
		return view.getView();
	}
	
	public void disableAddButton(){
		view.getAddButton().setEnabled(false);
	}
	
	public void enableAddButton(){
		view.getAddButton().setEnabled(true);
	}
}
