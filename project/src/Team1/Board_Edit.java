package Team1;

import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Board_Edit extends JDialog {
   // DS ���� ���� ��ġ ������
   JPanel mainPanel = new JPanel();
   //����
   JLabel lblNewLabel = new JLabel("����");
   JTextField textField = new JTextField();
   //���
   JLabel lblNewLabel_1 = new JLabel("���");
   JTextField textField_1 = new JTextField();
   //�׳ɺ����ִ� �ؽ�Ʈ
   JLabel label = new JLabel("�̹���");
   JTextField textField_2 = new JTextField("ĸ�����̹����� ����Ǿ����ϴ�.");
   //����
   JLabel label_1 = new JLabel("����");
   JTextArea textArea = new JTextArea();
   JScrollPane scroll = new JScrollPane();
   JButton btnNewButton = new JButton("Ȯ��");
   JButton btnNewButton_1 = new JButton("���");
   //�����ͺ��̽��� ����Ǵ� �̹���
   private File file;
   
   // main�� �ϴ� �������� �����ڿ��� ����
   public Board_Edit(File file) {
      this.file = file;
      this.display();// ȭ�� ���� ���� ó��
      this.event();// �̺�Ʈ ���� ó��
      this.menu();// �޴� ���� ó��

      this.setTitle("�Խ��� �����ε�/����");
      this.setSize(1000, 600);
      // this.setLocation(100, 100);
      // ��ġ�� �ü���� �����ϵ��� �Ѵ�
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.setVisible(true);
   }
   private void display() {
      this.setContentPane(mainPanel);
//      Simulation_Result result = new Simulation_Result();
//      textField_1.setText(result.getFile());
      
      //�̹������ �Է� �����߽��ϴ�.
      textField_2.setEditable(false);
      
      mainPanel.setLayout(null);

      lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
      lblNewLabel.setBounds(12, 10, 36, 27);
      mainPanel.add(lblNewLabel);

      lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
      lblNewLabel_1.setBounds(12, 47, 36, 27);
      mainPanel.add(lblNewLabel_1);

      label.setFont(new Font("����", Font.PLAIN, 14));
      label.setBounds(12, 84, 52, 27);
      mainPanel.add(label);

      label_1.setFont(new Font("����", Font.PLAIN, 14));
      label_1.setBounds(12, 121, 36, 27);
      mainPanel.add(label_1);

      textField.setBounds(60, 13, 600, 24);
      mainPanel.add(textField);
      // DS setColumns �� ������

      // DS setColumns �� ������
      textField_1.setBounds(60, 50, 600, 24);
      mainPanel.add(textField_2);
      
      textField_2.setBounds(60, 87, 600, 24);
      mainPanel.add(textField_1);


      scroll.setBounds(60, 121, 850, 371);
      mainPanel.add(scroll);

      scroll.setViewportView(textArea);

      btnNewButton.setBounds(352, 502, 109, 38);
      mainPanel.add(btnNewButton);

      btnNewButton_1.setBounds(573, 502, 109, 38);
      mainPanel.add(btnNewButton_1);

   }

   private void event() {
      // setDefaultCloseOperation(EXIT_ON_CLOSE);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      // setDefaultCloseOperation(HIDE_ON_CLOSE);
      // setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//JFrame �⺻ �̺�Ʈ ����

      // DS Ȯ���� Ŭ�� ���� �� �ؽ�Ʈ�ʵ�,���� �ִ� ������ ���� ������ BoardControl Ŭ������ setAll �żҵ�� ������
      btnNewButton.addActionListener(e -> {
         BoardControl bc = new BoardControl();
         bc.allSet(textField.getText(), textField_1.getText(),file, textArea.getText());
         // DS DB���� �����͸� �ҷ� map�� ����
         try {
            bc.mapInput();
         } catch (Exception e1) {
            System.out.println("BoardConrol�� ������ ���� �� ����");
         }
         // DS ���� �� map�� DB�� ����
         try {
            bc.mapOutput();
         } catch (Exception e1) {
            System.out.println("BoardConrol�� ������ ���� �� ����");
         }
         // DS Ȯ���� Ŭ���ϸ� �ش� ���� ����
         dispose();
      });

      btnNewButton_1.addActionListener(e -> {
         dispose();
      });
   }

   private void menu() {

   }
}

// public class Create {
// public static void main(String[] args) {
// /*
//// ��Ų ��ġ
// try {
// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
// } catch (Exception e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// */
// //â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
// Board_Edit window = new Board_Edit();
//
// }
// }