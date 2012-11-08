package Controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

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
		
		ActionListener categoryActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.addCategory(view.getCategoryBox().getText());
				view.hideCatagoryNaming();
			}
		};
		view.getCategoryBox().addActionListener(categoryActionListener);
		view.getCategorySaveButton().addActionListener(categoryActionListener);
		
		ActionListener categoryCancelActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.hideCatagoryNaming();
			}
		};
		view.getCategoryCancelButton().addActionListener(categoryCancelActionListener);

		MouseListener treeListener = new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        int selRow = view.getSeachTree().getRowForLocation(e.getX(), e.getY());
		        TreePath selPath = view.getSeachTree().getPathForLocation(e.getX(), e.getY());
		        if(selRow != -1) {
		            if(e.getClickCount() == 2) {
		                if(((DefaultMutableTreeNode)selPath.getLastPathComponent()) == view.getMakeNewCatagoryNode()){
		                	view.displayCatagoryNaming();
		                }
		            }
		        }
		    }
		};
		
		view.getSeachTree().addMouseListener(treeListener);
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
