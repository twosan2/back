package Team1;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class LogIn extends JFrame{
   
   private JPanel mainPanel = new JPanel();
   private JTextField id_textFiled = new JTextField();
   private JPasswordField pw_Filed = new JPasswordField();
   private JLabel id_label = new JLabel("ID");
   private JLabel pw_label = new JLabel("PW");
   private JLabel title_label = new JLabel("1\uC5B5 \uB9CC\uB4E4\uAE30 \uD504\uB85C\uC81D\uD2B8");
   private JButton Login_button = new JButton("LOGIN");
   private JButton join_button = new JButton("ȸ������");

   //private JButton find_button = new JButton("���̵� / ��й�ȣ ã��");
   
   
   //main�� �ϴ� �������� �����ڿ��� ����
   public LogIn() {
      this.display();//ȭ�� ���� ���� ó��
      this.event();//�̺�Ʈ ���� ó��
      this.menu();//�޴� ���� ó��
      this.setTitle("1�� ����� ������Ʈ");
//      this.setLocationByPlatform(true);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
   }
   private void display() {
      //mainPanel�� �⺻ �гη� ����
         this.setContentPane(mainPanel);
         setBounds(100, 100, 354, 425);
         mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(mainPanel);
         mainPanel.setLayout(null);
         
         //Ÿ��Ʋ ��
         title_label.setFont(new Font("���ʷҹ���",Font.BOLD , 30));
         title_label.setHorizontalAlignment(SwingConstants.CENTER);
         title_label.setBounds(12, 22, 316, 85);
         mainPanel.add(title_label);
         
         //���̵� ��
         id_label.setFont(new Font("���ʷҹ���", Font.BOLD, 29));
         id_label.setHorizontalAlignment(SwingConstants.RIGHT);
         id_label.setBounds(0, 137, 78, 53);
         mainPanel.add(id_label);
         
         //�н����� ��
         pw_label.setFont(new Font("���ʷҹ���", Font.BOLD, 29));
         pw_label.setHorizontalAlignment(SwingConstants.RIGHT);
         pw_label.setBounds(2, 190, 78, 53);
         mainPanel.add(pw_label);
         
         //TextFiled
         id_textFiled.setFont(new Font("Verdana", Font.BOLD, 20));
         id_textFiled.setBounds(90, 146, 174, 37);
         mainPanel.add(id_textFiled);
         
         pw_Filed.setBounds(90, 200, 174, 37);
         mainPanel.add(pw_Filed);
         
         //��ư ���
         Login_button.setBounds(115, 255, 126, 31);
         mainPanel.add(Login_button);
         join_button.setBounds(125, 296, 103, 23);;
         mainPanel.add(join_button);
         

      
      
   }

   private void event() {
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
      Login_button.addActionListener(e->{
    	 Main_Form join = new Main_Form();
    	  /*
    	 Map<String,String> member = new HashMap<>();
    	 member.put("master", "1234");
    	 char[] pwf = pw_Filed.getPassword();
    	 String change = new String(pwf,0,pwf.length);
    	 
    	 if(member.containsKey(id_textFiled.getText()) && member.get(id_textFiled.getText()).equals(change)) {
    		 JOptionPane.showInternalMessageDialog(mainPanel, "�α����� �Ϸ�Ǿ����ϴ�.","�α���",JOptionPane.INFORMATION_MESSAGE);
    		 Main_Form callmain = new Main_Form();
    	 }
    	 else {
    		 JOptionPane.showInternalMessageDialog(mainPanel, "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.","�α���",JOptionPane.INFORMATION_MESSAGE);
    	 }
    	 */
      });
      join_button.addActionListener(e->{
         JoinPage join = new JoinPage();
      });
     
      
      
   }

   private void menu() {
      
   }
}

public class LoginPage {
   public static void main(String[] args) {
      LogIn window = new LogIn();
   }
}