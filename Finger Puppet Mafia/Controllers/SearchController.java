package Controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

import Database.Category;
import Database.CodeExample;
import Database.Database;
import DesktopViews.SearchView;
import DesktopViews.SearchView.MyCategoryTreeNode;
import DesktopViews.SearchView.MyCodeExampleTreeNode;

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
			List<CodeExample> codeExamples = db.getCategoryExamples(c.getName());
			for(CodeExample ce : codeExamples){
				String title = ce.getTitle();
				String description = ce.getDescription(); 
				List<Category> categories = new ArrayList<Category>();
				categories.add(c);
				view.addCodeExample(title, description, categories);
			}
		}
		
		view.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				splitController.addButtonPressed();
				view.getAddButton().setEnabled(false);
			}
		});
		
		view.getAddOtherButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getAddOtherButton().setEnabled(false);
				view.displayCatagoryNaming();
				view.redraw();
			}
		
		});
		
		ActionListener categoryActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (db.addCategory(view.getCategoryBox().getText(), view.getCategoryDescriptionBox().getText(), false)) {
					view.addCategory(view.getCategoryBox().getText(), view.getCategoryDescriptionBox().getText());
					view.hideCatagoryNaming();
					view.hideDuplicateCategoryError();
				} else {
					view.showDuplicateCategoryError();
				}
			}
		};
		view.getCategoryBox().addActionListener(categoryActionListener);
		view.getCategorySaveButton().addActionListener(categoryActionListener);
		
		ActionListener categoryCancelActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.hideCatagoryNaming();
				view.hideDuplicateCategoryError();
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
		                if (selPath.getLastPathComponent() instanceof MyCodeExampleTreeNode) {
		                	splitController.displayCode(((DefaultMutableTreeNode)selPath.getLastPathComponent()).getUserObject().toString());
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

	public void addCodeExample(String title) {
		List<CodeExample> code = db.getExamplesByFieldValue("title", title);
		String description = code.get(0).getDescription(); 
		List<Category> categories = code.get(0).getCategories();
		view.addCodeExample(title, description, categories);
		
	}
}
