package DesktopViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Database.Category;

public class SearchView{
	private JPanel searchPanel;
	private JPanel topPanel;
	private JTextField searchBox;
	private JPanel categoryPanel;
	private JLabel categoryNamingLabel;
	private JTextField categoryBox;
	private JLabel categoryDescriptionLabel;
	private JPanel categoryPanel2;
	private JTextArea categoryDescriptionBox;
	private JPanel categoryButtonPanel;
	private JButton categoryCancelButton;
	private JButton categorySaveButton;
	private JTree searchTree;
	private MyCategoryTreeNode mainTreeNode;
	private JPanel bottomPanel;
	private JLabel displayDescriptionLabel;
	private JTextArea displayDescriptionBox;
	private JButton addButton;
	private JButton addCategoryButton;
	private JPanel buttonPanel;
	private JLabel errorLabel;
	
	public class MyCategoryTreeNode extends DefaultMutableTreeNode{
		private static final long serialVersionUID = 7164254714041050808L;
		private String categoryDescription;
		
		public MyCategoryTreeNode(Object userObject, String description){
			super(userObject);
			categoryDescription = userObject.toString() + ":\n" + description;
		}
		
		public String getCategoryDescription(){
			return categoryDescription;
		}
		
		public void display(){
			
		}
	}
	
	public class MyCodeExampleTreeNode extends MyCategoryTreeNode{
		private static final long serialVersionUID = 5279792990114451979L;

		public MyCodeExampleTreeNode(Object userObject, String description) {
			super(userObject, description);
		}

		@Override
		public void display(){
			
		}
	}
	
	public SearchView(){
		searchPanel = new JPanel();
		topPanel = new JPanel();
		searchBox = new JTextField();
		categoryPanel = new JPanel();
		categoryNamingLabel = new JLabel("Enter category name here:");
		categoryBox = new JTextField();
		categoryDescriptionLabel = new JLabel("Category description here:");
		categoryPanel2 = new JPanel();
		categoryDescriptionBox = new JTextArea();
		categoryButtonPanel = new JPanel();
		categoryCancelButton = new JButton("Cancel");
		categorySaveButton = new JButton(" Save ");
		searchTree = new JTree();
		mainTreeNode = new MyCategoryTreeNode("Team High 5s Examples", "Your Examples!");
		bottomPanel = new JPanel();
		displayDescriptionLabel = new JLabel("Description:");
		displayDescriptionBox = new JTextArea();
		addButton = new JButton("Make New Example");
		addCategoryButton = new JButton("Add New Category");
		buttonPanel = new JPanel();
		errorLabel = new JLabel("Category already exits!");

		
		searchPanel.setLayout(new BorderLayout(0, 0));	
		searchPanel.add(topPanel, BorderLayout.NORTH);
		searchPanel.add(searchTree, BorderLayout.CENTER);
		searchPanel.add(bottomPanel, BorderLayout.SOUTH);
		searchPanel.setMinimumSize(new Dimension(0,0));
		
		topPanel.setLayout(new BorderLayout(0, 0));
		topPanel.add(searchBox, BorderLayout.NORTH);
		
		searchBox.setText("Search...");
		
		categoryPanel.setLayout(new BorderLayout(0, 0));
		categoryPanel.add(categoryNamingLabel, BorderLayout.NORTH);
		categoryPanel.add(categoryBox, BorderLayout.CENTER);
		categoryPanel.add(categoryDescriptionLabel, BorderLayout.SOUTH);
		
		categoryPanel2.setLayout(new BorderLayout(0,0));
		categoryPanel2.add(categoryDescriptionBox, BorderLayout.NORTH);
		categoryPanel2.add(categoryButtonPanel, BorderLayout.SOUTH);
		
		categoryButtonPanel.setLayout(new BorderLayout(0,0));
		categoryButtonPanel.add(categoryCancelButton, BorderLayout.WEST);
		categoryButtonPanel.add(categorySaveButton, BorderLayout.EAST);
		
		categoryDescriptionBox.setLineWrap(true);
		categoryDescriptionBox.setWrapStyleWord(true);
		
		searchTree.setModel(new DefaultTreeModel(mainTreeNode));
		
		bottomPanel.setLayout(new BorderLayout(0, 0));
		bottomPanel.add(displayDescriptionLabel, BorderLayout.NORTH);
		bottomPanel.add(displayDescriptionBox, BorderLayout.CENTER);
		bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		buttonPanel.setLayout(new BorderLayout(0, 0));
		buttonPanel.add(addCategoryButton, BorderLayout.CENTER);
		buttonPanel.add(addButton, BorderLayout.SOUTH);
		buttonPanel.setMinimumSize(new Dimension(0,0));
		
		displayDescriptionBox.setLineWrap(true);
		categoryDescriptionBox.setWrapStyleWord(true);
		displayDescriptionBox.setEditable(false);
		
		errorLabel.setForeground(Color.red);
		
	}
	
	public JButton getAddButton(){
		return addButton;
	}
	
	public JButton getAddOtherButton(){
		return addCategoryButton;
	}
	
	public JTree getSeachTree(){
		return searchTree;
	}
	
	public JTextField getSeachBox(){
		return searchBox;
	}

	public Container getView() {
		return searchPanel;
	}
	
	public MyCategoryTreeNode getMainTreeNode(){
		return mainTreeNode;
	}
	
	public JTextField getCategoryBox(){
		return categoryBox;
	}
	
	public JTextArea getCategoryDescriptionBox(){
		return categoryDescriptionBox;
	}
	
	public JButton getCategoryCancelButton(){
		return categoryCancelButton;
	}
	
	public JButton getCategorySaveButton(){
		return categorySaveButton;
	}
	
	public JTextArea getDisplayDescriptionBox(){
		return displayDescriptionBox;
		
	}
	
	public void displayCatagoryNaming(){
		topPanel.add(categoryPanel, BorderLayout.CENTER);
		topPanel.add(categoryPanel2, BorderLayout.SOUTH);
	}
	
	public void hideCatagoryNaming(){
		if(topPanel.getComponentCount() > 1){
			topPanel.remove(categoryPanel);
			topPanel.remove(categoryPanel2);
			categoryBox.setText("");
			categoryDescriptionBox.setText("");
			topPanel.revalidate();
			this.addCategoryButton.setEnabled(true);
		}
	}
	
	public void redraw(){
		searchTree.revalidate();
	}
	
	public void addCategory(String name, String description){
		((DefaultTreeModel)searchTree.getModel()).insertNodeInto(new MyCategoryTreeNode(name, description), mainTreeNode, mainTreeNode.getChildCount());
	}

	public void addCodeExample(String title, String description, List<Category> categories) {
		for(Category c: categories){
			int numCategories = mainTreeNode.getChildCount();
			for (int i = 0; i < numCategories; i++){
				DefaultMutableTreeNode holder = ((DefaultMutableTreeNode)mainTreeNode.getChildAt(i));
				if(holder.getUserObject().toString().equals(c.getName())){
					((DefaultTreeModel)searchTree.getModel()).insertNodeInto(new MyCodeExampleTreeNode(title, description), holder, 0);
				}
			}
		}		
	}
	
	public void showDuplicateCategoryError() {
		categoryPanel2.add(errorLabel, BorderLayout.CENTER);	
		categoryPanel2.revalidate();
	}
	
	public void hideDuplicateCategoryError(){
		categoryPanel2.remove(errorLabel);
		categoryPanel2.revalidate();
	}

}
