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
	String[] money = {"달러", "엔", "유로", "위안"};
	JPanel panel1, panel2;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	
	public ExchangeCalc() {
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		txt = new JTextField(10);
		combo = new JComboBox<>(money);
		setTitle("환율계산기");
		btn = new JButton("변환");
		
		lbl = new JLabel("변환 결과");
		
		//getContentPane().setLayout(new FlowLayout());
		panel1.add(new JLabel("원화"));
		panel1.add(txt);
		panel1.add(combo);
		panel1.add(btn);
		
		panel2.add(lbl);
		
		getContentPane().add(panel1, "North");  //자리배치(BorderLayout)
		getContentPane().add(panel2, "Center");   //자리배치(BorderLayout)
		
		
		setBounds(300, 300, 350, 200);  //x좌표, y좌표, width, height
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
		float won = Float.parseFloat(txt.getText());  //입력된 문자를 실수로 변환
		String result = null;
		String money = combo.getSelectedItem().toString();  //문자
		
		if(money.equals("달러")) {
			result = String.format("%.2f", won/USD);
		}else if(money.equals("엔")) {
			result = String.format("%.2f",won/JPY);
		}else if(money.equals("유로")) {
			result = String.format("%.2f",won/EUR);
		}else if(money.equals("위안")) {
			result = String.format("%.2f",won/CNY);
		}
		lbl.setText(result);
		
		
		
	}

}
