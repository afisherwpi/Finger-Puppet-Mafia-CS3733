import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.Box;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;


@SuppressWarnings("unused")
public class testJFRAME extends JFrame {

	JToggleButton NewToggleButton;
	
	private JPanel contentPane;
	private JTextField txtSearchField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testJFRAME frame = new testJFRAME();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testJFRAME() {
		setMinimumSize(new Dimension(400, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Panel CentSec = new Panel();
		contentPane.add(CentSec, BorderLayout.CENTER);
		CentSec.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		CentSec.add(scrollBar, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		CentSec.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_1, BorderLayout.NORTH);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(5);
		slider.setMinimum(1);
		panel_5.add(slider, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		panel_6.add(btnNewButton_1);
		
		JTextArea txtrWidth = new JTextArea();
		txtrWidth.setText(">>> width = 20\n>>> height = 5*9\n>>> width * height\n900");
		txtrWidth.setLineWrap(true);
		CentSec.add(txtrWidth, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		CentSec.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel Title = new JPanel();
		CentSec.add(Title, BorderLayout.NORTH);
		Title.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Title: ");
		Title.add(lblNewLabel_1, BorderLayout.WEST);
		
		textField = new JTextField();
		Title.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel LeftSec = new JPanel();
		contentPane.add(LeftSec, BorderLayout.WEST);
		LeftSec.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		LeftSec.add(list, BorderLayout.CENTER);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Print", "SSH", "Alert Message", "Append int to string"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Java", "Python", "HTML"}));
		LeftSec.add(comboBox, BorderLayout.SOUTH);
		
		JPanel BotSec = new JPanel();
		contentPane.add(BotSec, BorderLayout.SOUTH);
		BotSec.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrThisIsWhere = new JTextArea();
		txtrThisIsWhere.setEditable(false);
		BotSec.add(txtrThisIsWhere, BorderLayout.CENTER);
		txtrThisIsWhere.setText("Status: Online and Synced as of 09/13/2012 2:35PM");
		
		JPanel TopSec = new JPanel();
		contentPane.add(TopSec, BorderLayout.NORTH);
		TopSec.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		TopSec.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		NewToggleButton = new JToggleButton("Local (Offline)");
		NewToggleButton.setToolTipText("Click here to toggle between Local and Public\n");
		NewToggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		NewToggleButton.addItemListener(new ToggleListener());
		
		panel_4.add(NewToggleButton);
		
		JLabel lblNewLabel = new JLabel("John Doe");
		TopSec.add(lblNewLabel, BorderLayout.WEST);
		
		txtSearchField = new JTextField();
		txtSearchField.setText("Search Field");
		TopSec.add(txtSearchField, BorderLayout.EAST);
		txtSearchField.setColumns(10);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class ToggleListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(NewToggleButton.isSelected()){
				NewToggleButton.setText("Public (Online)");
			}
			else{
				NewToggleButton.setText("Local (Offline)");
			}

		}
	}
}
