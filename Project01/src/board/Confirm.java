package board;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;

class WindowConfirm extends JFrame{
	JPanel mainPanel = new JPanel();

	//main�� �ϴ� �������� �����ڿ��� ����
	public WindowConfirm() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("�Խ��� ���� Ȯ��");
		this.setSize(1000, 600);
		//this.setLocation(100, 100);
		//��ġ�� �ü���� �����ϵ��� �Ѵ�
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 10, 28, 21);
		mainPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("��ȣ");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(254, 10, 28, 21);
		mainPanel.add(label);
		
		JLabel label_1 = new JLabel("��¥");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(495, 10, 28, 21);
		mainPanel.add(label_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(47, 11, 145, 26);
		mainPanel.add(textField);
		//textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(294, 11, 145, 26);
		mainPanel.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(535, 11, 167, 26);
		mainPanel.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 41, 481, 320);
		mainPanel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(505, 41, 197, 320);
		mainPanel.add(textArea_1);
		
		JScrollPane scroll = new JScrollPane(textArea_1);
		scroll.setBounds(505, 41, 197, 320);
		mainPanel.add(scroll);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(12, 371, 690, 130);
		mainPanel.add(textArea_2);
		
		JScrollPane scroll_1 = new JScrollPane(textArea_2);
		scroll_1.setBounds(12, 371, 690, 130);
		mainPanel.add(scroll_1);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(720,30,240,500);
		mainPanel.add(textArea_3);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.setBounds(500, 511, 97, 45);
		mainPanel.add(btnNewButton);
		
		JButton button = new JButton("����");
		button.setBounds(605, 511, 97, 45);
		mainPanel.add(button);
	}

	private void event() {
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//JFrame �⺻ �̺�Ʈ ����
	}

	private void menu() {
		
	}
}

public class Confirm {
	public static void main(String[] args) {
		/*
//��Ų ��ġ
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		WindowConfirm window = new WindowConfirm();
		
	}
}











