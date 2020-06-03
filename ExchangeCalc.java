package swingsample.combobox;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class ExchangeCalc extends JFrame implements ActionListener{
	private static float USD = 1225.60F;
	private static float JPY = 11.3792F;
	private static float EUR = 1363.66F;
	private static float CNY = 171.89F;
	
	JComboBox<String> combo;
	String[] money = {"�޷�", "��", "����", "����"};
	JPanel panel1, panel2;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	
	public ExchangeCalc() {
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		txt = new JTextField(10);
		combo = new JComboBox<>(money);
		setTitle("ȯ������");
		btn = new JButton("��ȯ");
		
		lbl = new JLabel("��ȯ ���");
		
		//getContentPane().setLayout(new FlowLayout());
		panel1.add(new JLabel("��ȭ"));
		panel1.add(txt);
		panel1.add(combo);
		panel1.add(btn);
		
		panel2.add(lbl);
		
		getContentPane().add(panel1, "North");  //�ڸ���ġ(BorderLayout)
		getContentPane().add(panel2, "Center");   //�ڸ���ġ(BorderLayout)
		
		
		setBounds(300, 300, 350, 200);  //x��ǥ, y��ǥ, width, height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btn.addActionListener(this);
	}

	public static void main(String[] args) {
		new ExchangeCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		calculate();
	}
	
	public void calculate() {
		float won = Float.parseFloat(txt.getText());  //�Էµ� ���ڸ� �Ǽ��� ��ȯ
		String result = null;
		String money = combo.getSelectedItem().toString();  //����
		
		if(money.equals("�޷�")) {
			result = String.format("%.2f", won/USD);
		}else if(money.equals("��")) {
			result = String.format("%.2f",won/JPY);
		}else if(money.equals("����")) {
			result = String.format("%.2f",won/EUR);
		}else if(money.equals("����")) {
			result = String.format("%.2f",won/CNY);
		}
		lbl.setText(result);
		
		
		
	}

}
