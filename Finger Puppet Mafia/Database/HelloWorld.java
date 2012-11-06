package Database;

import java.applet.Applet;
import java.awt.HeadlessException;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class HelloWorld extends Applet {
	private JTextField txtHello;
	private String[] ComboList = new String[] {"List of Items"};
	
	static <T> T[] append(T[] arr, T element) {
	    final int N = arr.length;
	    arr = Arrays.copyOf(arr, N + 1);
	    arr[N] = element;
	    return arr;
	}
	
	
	public HelloWorld() throws HeadlessException {
		
		ComboList = append(ComboList, "4");
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ComboList));
		add(comboBox);
		
		JPanel panel = new JPanel();
		add(panel);
		
		txtHello = new JTextField();
		txtHello.setText("Hello?");
		panel.add(txtHello);
		txtHello.setColumns(10);
		// TODO Auto-generated constructor stub
	}

}
