package DesktopViews;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitView{

	private JSplitPane splitPane;
	
	public SplitView() {
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,null,null);
		splitPane.setDividerLocation(200);
		splitPane.setContinuousLayout(true);
	}
	
	public Container getView(){
		return splitPane;
	}
	
	public void setLeft(Component component) {
		splitPane.setLeftComponent(component);
	}
	
	public void setRight(Component component) {
		splitPane.setRightComponent(component);
	}
}
