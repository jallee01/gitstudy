package swingsample.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.*;

public class ComboBoxTest extends JFrame implements ActionListener {
	JComboBox<String> combo;
	String[] money = {"달러", "엔", "유로", "위안"};
	JLabel lbl;
	
	public ComboBoxTest() {
		combo = new JComboBox<>(money);
		lbl = new JLabel("화폐 선택");
		
		getContentPane().add(combo, "North");
		getContentPane().add(lbl, "Center");
		
		
		setLocation(300, 300);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		combo.addActionListener(this);
	}
	

	public static void main(String[] args) {
		new ComboBoxTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String result = combo.getSelectedItem().toString();  // =get
		lbl.setText(result + "을(를) 선택하셨습니다.");                // =set
	}

}
