package DesktopViews;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class SearchView{
	private JPanel searchPanel;
	private JTextField searchBox;
	private JTree searchTree;
	private JButton addButton;
	
	public SearchView(){
		System.out.println("test2");
		searchPanel = new JPanel();
		searchBox = new JTextField();
		searchTree = new JTree();
		addButton = new JButton("add");
		
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		searchPanel.add(searchTree, BorderLayout.CENTER);
		searchPanel.add(addButton, BorderLayout.SOUTH);
		searchPanel.add(searchBox, BorderLayout.NORTH);
		
		searchBox.setText("Search...");
		
		searchTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Team 5's Examples") {
				private static final long serialVersionUID = 2588281959119301755L;
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("Python");
						node_1.add(new DefaultMutableTreeNode("Print Statement"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("C");
							node_1.add(new DefaultMutableTreeNode("Print Statement"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("Java");
							node_1.add(new DefaultMutableTreeNode("Make a class"));
						add(node_1);
					}
			}
		));
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

}
