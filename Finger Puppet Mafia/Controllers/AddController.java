package Controllers;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Database;
import DesktopViews.AddView;

public class AddController {
		private AddView view;
		private SplitController splitController;
		private  Database db;
		
		public AddController(AddView dview, SplitController scon,  Database mydb){
			view = dview;
			splitController = scon;
			db = mydb;
		}
		
		public void go() {
			ActionListener keyWordActionListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int totalComponents = view.getAddPanel().getComponentCount();
					JPanel anotherAddKeyWordsPane = new JPanel();
					final JLabel removeLabel = new JLabel("remove");
					removeLabel.setForeground(Color.blue);
					removeLabel.addMouseListener(new MouseListener() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							view.getAddPanel().remove(removeLabel.getParent());
							view.getAddPanel().revalidate();
						}
						@Override
						public void mouseEntered(MouseEvent arg0) {
							removeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mouseExited(MouseEvent arg0) {
							removeLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent arg0) {
						}
						@Override
						public void mouseReleased(MouseEvent arg0) {
						}
					});
					JLabel tfAnotherAddKeyWords = new JLabel(view.getKeyWordsTextFeild().getText());
					view.getKeyWordsTextFeild().setText("");
					anotherAddKeyWordsPane.setLayout(new GridLayout(0, 2));
					anotherAddKeyWordsPane.add(removeLabel);
					anotherAddKeyWordsPane.add(tfAnotherAddKeyWords);
					view.getAddPanel().add(anotherAddKeyWordsPane, totalComponents - 5);
					view.getAddPanel().revalidate();
				}
			};
			
			view.getKeyWordsTextFeild().addActionListener(keyWordActionListener);
			
			view.getCancelButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					splitController.addCancelButtonPressed();
				}
			});
			
			view.getSaveButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					List<String> dummy = new ArrayList<String>();
					dummy.add("Other");
					db.addCodeExample(view.getAddTitle().getText(), 
										"sakld;jgj;alksdgj;a", 
										view.getAddCode().getText(), 
										view.getAddProgrammingLanguage().getSelectedItem().toString(),
										dummy,
										view.getAddPublic().isSelected());
					splitController.addSaveButtonPressed(view.getAddTitle().getText());
					
				}
			});
			
		}

		public Container getView() {
			return view.getView();
		}

}


