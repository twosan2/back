package board;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.PasswordView;

class WindowCreate extends JFrame{
	JPanel mainPanel = new JPanel();

	//main�� �ϴ� �������� �����ڿ��� ����
	public WindowCreate() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("�Խ��� �����ε�/����");
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
		lblNewLabel.setBounds(12, 10, 36, 27);
		mainPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 47, 36, 27);
		mainPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("�̹���");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(12, 84, 52, 27);
		mainPanel.add(label);
		
		JLabel label_1 = new JLabel("����");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(12, 121, 36, 27);
		mainPanel.add(label_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(60, 13, 600, 24);
		mainPanel.add(textField);
		//textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		//textField_2.setColumns(10);
		textField_2.setBounds(60, 87, 600, 24);
		mainPanel.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(60, 50, 600, 24);
		mainPanel.add(textField_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 121, 850, 371);
		mainPanel.add(textArea);
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(60, 121, 850, 371);
		mainPanel.add(scroll);
		
		JButton btnNewButton = new JButton("Ȯ��");
		btnNewButton.setBounds(352, 502, 109, 38);
		mainPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("���");
		btnNewButton_1.setBounds(573, 502, 109, 38);
		mainPanel.add(btnNewButton_1);
	
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

public class Create {
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
		WindowCreate window = new WindowCreate();
		
	}
}





