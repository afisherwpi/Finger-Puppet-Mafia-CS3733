package DesktopViews;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
	private MyCategoryTreeNode makeNewCatagoryNode;
	private JPanel bottomPanel;
	private JLabel displayDescriptionLabel;
	private JTextArea displayDescriptionBox;
	private JButton addButton;
	
	public class MyCategoryTreeNode extends DefaultMutableTreeNode{
		private static final long serialVersionUID = 7164254714041050808L;
		private String categoryDescription;
		
		MyCategoryTreeNode(Object userObject, String description){
			super(userObject);
			categoryDescription = userObject.toString() + ":\n" + description;
		}
		
		public String getCategoryDescription(){
			return categoryDescription;
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
		makeNewCatagoryNode = new MyCategoryTreeNode("Make new category", "Double click to make a new example");
		bottomPanel = new JPanel();
		displayDescriptionLabel = new JLabel("Description:");
		displayDescriptionBox = new JTextArea();
		addButton = new JButton("add");

		
		searchPanel.setLayout(new BorderLayout(0, 0));	
		searchPanel.add(topPanel, BorderLayout.NORTH);
		searchPanel.add(searchTree, BorderLayout.CENTER);
		searchPanel.add(bottomPanel, BorderLayout.SOUTH);
		searchPanel.setMinimumSize(new Dimension(100,100));
		
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
		mainTreeNode.add(makeNewCatagoryNode);
		
		searchTree.setModel(new DefaultTreeModel(mainTreeNode));
		
		bottomPanel.setLayout(new BorderLayout(0, 0));
		bottomPanel.add(displayDescriptionLabel, BorderLayout.NORTH);
		bottomPanel.add(displayDescriptionBox, BorderLayout.CENTER);
		bottomPanel.add(addButton, BorderLayout.SOUTH);
		
		displayDescriptionBox.setLineWrap(true);
		categoryDescriptionBox.setWrapStyleWord(true);
		displayDescriptionBox.setEditable(false);
		
	}
	
	public JButton getAddButton(){
		return addButton;
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
	
	public MyCategoryTreeNode getMakeNewCatagoryNode(){
		return makeNewCatagoryNode;
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
		}
	}
	
	public void addCategory(String name, String description){
		((DefaultTreeModel)searchTree.getModel()).insertNodeInto(new MyCategoryTreeNode(name, description), mainTreeNode, mainTreeNode.getChildCount() - 1);
	}

}
