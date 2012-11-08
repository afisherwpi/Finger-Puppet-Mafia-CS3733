package Controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

import Database.Category;
import Database.Database;
import DesktopViews.SearchView;
import DesktopViews.SearchView.MyCategoryTreeNode;

public class SearchController {
	private SearchView view;
	private SplitController splitController;
	private  Database db;
	
	public SearchController(SearchView sview, SplitController scon,  Database mydb){
		view = sview;
		splitController = scon;
		db = mydb;
	}
	
	public void go(){
		List<Category> categoryList = db.getCategories();
		for(Category c : categoryList){
			view.addCategory(c.getName(), c.getDescription());
		}
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
				db.addCategory(view.getCategoryBox().getText(), view.getCategoryDescriptionBox().getText(), false);
				view.addCategory(view.getCategoryBox().getText(), view.getCategoryDescriptionBox().getText());
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
		        	if(e.getClickCount() == 1) {
		        		view.getDisplayDescriptionBox().setText(((MyCategoryTreeNode)selPath.getLastPathComponent()).getCategoryDescription());
		        	}
		        	else if(e.getClickCount() == 2) {
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
