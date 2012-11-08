package DesktopViews;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ContainerView extends JFrame {
	private static final long serialVersionUID = -8748831272362720217L;
	private JPanel containerPanel;
	public ContainerView(){
		containerPanel = new JPanel();
		containerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		containerPanel.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setContentPane(containerPanel);
	}
	
	public Container getView() {
		return containerPanel;
	}
	
	public void addCenter(Component component) {
		containerPanel.add(component, BorderLayout.CENTER);
	}
	
	public void addNorth(Component component){
		containerPanel.add(component, BorderLayout.NORTH);
	}
	
	public void addSouth(Component component){
		containerPanel.add(component, BorderLayout.SOUTH);
	}
	
	public void addEast(Component component){
		containerPanel.add(component, BorderLayout.EAST);
	}
	
	public void addWest(Component component){
		containerPanel.add(component, BorderLayout.WEST);
	}
	

}
