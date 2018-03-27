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

	//main에 하던 설정들을 생성자에서 진행
	public WindowConfirm() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("게시판 내용 확인");
		this.setSize(1000, 600);
		//this.setLocation(100, 100);
		//위치를 운영체제가 결정하도록 한다
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("제목");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 10, 28, 21);
		mainPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("번호");
		label.setFont(new Font("굴림", Font.PLAIN, 14));
		label.setBounds(254, 10, 28, 21);
		mainPanel.add(label);
		
		JLabel label_1 = new JLabel("날짜");
		label_1.setFont(new Font("굴림", Font.PLAIN, 14));
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
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setBounds(500, 511, 97, 45);
		mainPanel.add(btnNewButton);
		
		JButton button = new JButton("삭제");
		button.setBounds(605, 511, 97, 45);
		mainPanel.add(button);
	}

	private void event() {
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//JFrame 기본 이벤트 방지
	}

	private void menu() {
		
	}
}

public class Confirm {
	public static void main(String[] args) {
		/*
//스킨 설치
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		WindowConfirm window = new WindowConfirm();
		
	}
}











