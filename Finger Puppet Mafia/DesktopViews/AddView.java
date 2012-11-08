package DesktopViews;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddView {
	private JPanel addPanel;
	private JPanel addInstructionPanel;
	private JPanel addTitlePanel;
	private JPanel addKeyWordsPanel;
	private JPanel addProgrammingLanguagePanel;
	private JPanel addCodePanel;
	private JPanel addDependenciesPanel;
	private JPanel addPublicPanel;
	private JPanel addButtonPanel;
	
	private JLabel lblAddInstruction;
	private JLabel lblAddTitle;
	private JLabel lblAddKeyWords;
	private String[] possibleProgrammingLanguages = {"Java", "C", "C++/C", "Python", "Ruby", "Pascal", "Other..."};
	private JLabel lblAddProgrammingLanguage;
	private JLabel lblAddCode;
	private JLabel lblAddDependencies;
	private JLabel lblAddPublic;
	
	private JTextField tfAddTitle;
	private JTextField tfAddKeyWords;
	private JComboBox comboAddProgrammingLanguage;
	private JTextArea taAddCode;
	private JTextField tfAddDependencies;
	private JCheckBox cbAddPublic;
	private JButton btnAddCancel;
	private JButton btnAddSave;
	
	public AddView(){
		addPanel = new JPanel();
		addInstructionPanel = new JPanel();
		addTitlePanel = new JPanel();
		addKeyWordsPanel = new JPanel();
		addProgrammingLanguagePanel = new JPanel();
		addCodePanel = new JPanel();
		addDependenciesPanel = new JPanel();
		addPublicPanel = new JPanel();
		addButtonPanel = new JPanel();
		
		addPanel.setLayout(new GridLayout(0, 1));
		addInstructionPanel.setLayout(new GridLayout(0, 1));
		addTitlePanel.setLayout(new GridLayout(0, 2));
		addKeyWordsPanel.setLayout(new GridLayout(0, 2));
		addProgrammingLanguagePanel.setLayout(new GridLayout(0, 2));
		addCodePanel.setLayout(new GridLayout(0, 2));
		addDependenciesPanel.setLayout(new GridLayout(0, 2));
		addPublicPanel.setLayout(new GridLayout(0, 2));
		addButtonPanel.setLayout(new GridLayout(0, 2));
		
		addPanel.add(addInstructionPanel);
		addPanel.add(addTitlePanel);
		addPanel.add(addKeyWordsPanel);
		addPanel.add(addProgrammingLanguagePanel);
		addPanel.add(addCodePanel);
		addPanel.add(addDependenciesPanel);
		addPanel.add(addPublicPanel);
		addPanel.add(addButtonPanel);
		
		lblAddInstruction = new JLabel("Fill out the following fields and click save in order to add an entry to your Programmers Examples Notebook.");
		lblAddTitle = new JLabel("Title:");
		lblAddKeyWords = new JLabel("Key Words:");
		lblAddProgrammingLanguage = new JLabel("Language:");
		lblAddCode = new JLabel("Code:");
		lblAddDependencies = new JLabel("Dependencies:");
		lblAddPublic = new JLabel("Make Public?");
		
		tfAddTitle = new JTextField();
		tfAddKeyWords = new JTextField();
		comboAddProgrammingLanguage = new JComboBox(possibleProgrammingLanguages);
		taAddCode = new JTextArea();
		tfAddDependencies = new JTextField();
		cbAddPublic = new JCheckBox();
		btnAddCancel = new JButton("Cancel");
		btnAddSave = new JButton("Save");
		
		addInstructionPanel.add(lblAddInstruction);
		addTitlePanel.add(lblAddTitle);
		addKeyWordsPanel.add(lblAddKeyWords);
		addProgrammingLanguagePanel.add(lblAddProgrammingLanguage);
		addCodePanel.add(lblAddCode);
		addDependenciesPanel.add(lblAddDependencies);
		addPublicPanel.add(lblAddPublic);
		
		addTitlePanel.add(tfAddTitle);
		addKeyWordsPanel.add(tfAddKeyWords);
		addProgrammingLanguagePanel.add(comboAddProgrammingLanguage);
		addCodePanel.add(taAddCode);
		addDependenciesPanel.add(tfAddDependencies);
		addPublicPanel.add(cbAddPublic);
		addButtonPanel.add(btnAddCancel);
		addButtonPanel.add(btnAddSave);
	}
	
	public Container getView(){
		return addPanel;
	}
	
	public JPanel getAddPanel() {
		return addPanel;
	}
	
	public JTextField getAddTitle(){
		return tfAddTitle;
	}
	
	public JTextArea getAddCode(){
		return taAddCode;
	}
	
	public JComboBox getAddProgrammingLanguage(){
		return comboAddProgrammingLanguage;
	}
	
	public JCheckBox getAddPublic(){
		return cbAddPublic;
	}
	
	public JButton getCancelButton(){
		return btnAddCancel;
	}
	
	public JButton getSaveButton(){
		return btnAddSave;
	}
	
	public JTextField getKeyWordsTextFeild(){
		return tfAddKeyWords;
	}

}
