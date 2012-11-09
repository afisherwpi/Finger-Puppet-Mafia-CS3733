package Controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Database.CodeExample;
import Database.Database;
import DesktopViews.DisplayView;

public class DisplayController{
	private DisplayView view;
	private  Database db;
	
	// constructor will probably need to include the SplitController on top of this in the future.
	public DisplayController(DisplayView dview,  Database mydb){
		view = dview;
		db = mydb;
	}
	
	public void go() {
		view.getBtnSaveChanges().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSaveChangesPressed();
				view.getBtnSaveChanges().setEnabled(false);
			}
		});
		view.getCodeArea().addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!view.getBtnSaveChanges().isEnabled()){
					view.getBtnSaveChanges().setEnabled(true);
				}
				
			}
			
		});
		
	}

	public Container getView() {
		// TODO Auto-generated method stub
		return view.getView();
	}

	public void btnSaveChangesPressed(){
		CodeExample ce = db.getExamplesByFieldValue("title", view.getTitleLabel().getText()).get(0);
		ce.setCode(view.getCodeArea().getText());
		db.store(ce);
	}
	
	public void displayCode(String title) {
		CodeExample code = db.getExamplesByFieldValue("title", title).get(0);
		view.getTitleLabel().setText(code.getTitle());
		view.getCodeArea().setText(code.getCode());
		view.getDescriptionLabel().setText(code.getDescription());
		view.getKeyWordsText().setText("");
		
		
	}

}
