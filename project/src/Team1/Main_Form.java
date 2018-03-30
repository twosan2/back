package Team1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

class Main_Form extends JFrame {
   
   private LoginPage login = new LoginPage();
   
   private JPanel mainPanel = new JPanel();
   
   // S : JTable����
   private int num;
   private String borderTitle;
   private String userName;
   private Date date;
   private int count;
   private int a = count+1;
   
   // F : JTable����
   
   private String[] header = new String[] { "��ȣ", "����", "�̸�", "����", "��ȸ��" };
   private JButton profile = new JButton("������");
   private JLabel user = new JLabel(userName + "��", JLabel.CENTER);
   private JButton simulation = new JButton("�ùķ��̼�");
   private JButton userInformation = new JButton("��������");
   private JButton logout = new JButton("�α׾ƿ�");
   private JLabel title = new JLabel("< �Խ��� >");
   private Font font = new Font("", Font.PLAIN, 30);
   private JTable table;

   public Main_Form() {
      this.display();
      this.event();
      this.menu();
      this.setTitle("GUI�׽�Ʈ");
      this.setSize(1000, 600);
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.setVisible(true);
   }
   
   private void display() {
      this.setContentPane(mainPanel);
      mainPanel.setLayout(null);
      // ��ġ�� �������
      profile.setBounds(28, 18, 130, 128);
      user.setBounds(28, 160, 106, 50);
      userInformation.setBounds(40, 220, 106, 50);
      logout.setBounds(40, 310, 106, 50);
      simulation.setBounds(40, 400, 106, 50);
      title.setBounds(190, 18, 770, 40);
      // ��Ʈ
      title.setFont(font);
      // ������
      mainPanel.setBackground(Color.WHITE);
      profile.setBackground(Color.pink);
      // �����ֱ�
      mainPanel.add(profile);
      mainPanel.add(user);
      mainPanel.add(simulation);
      mainPanel.add(userInformation);
      mainPanel.add(logout);
      mainPanel.add(title);
      // S : ���̺�
      //Ȯ���� ���� �־�����ϴ�.
      Object[][] data = {
            {1,"����1","¯��","2018-03-29",1}
      };
      
      DefaultTableModel model = new DefaultTableModel(data, header) {
         @Override
         public boolean isCellEditable(int row, int col) {
            return false;
         }
      };
      table = new JTable(model);
      JScrollPane pane = new JScrollPane(table);
      pane.getViewport().setBackground(Color.WHITE);
      // ��ũ�Ѽ���
      pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      mainPanel.add(pane);
      pane.setBounds(190, 68, 770, 469);
      // ���̺� ����
      DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      TableColumnModel columnModel = table.getColumnModel();
      for (int i = 0; i < columnModel.getColumnCount(); i++) {
         columnModel.getColumn(i).setCellRenderer(renderer);
      }
      // ���̺� header width�� ����
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table.getColumnModel().getColumn(0).setPreferredWidth(34);
      table.getColumnModel().getColumn(1).setPreferredWidth(400);
      table.getColumnModel().getColumn(2).setPreferredWidth(100);
      table.getColumnModel().getColumn(3).setPreferredWidth(130);
      table.getColumnModel().getColumn(4).setPreferredWidth(88);
      // ���̺� �̵��Ұ�
      table.getTableHeader().setReorderingAllowed(false);
      // ���̺� ũ�� ���� �Ұ�
      table.getTableHeader().setResizingAllowed(false);
      
      //���̺� 0��° �ٿ� �߰�
      DefaultTableModel m = (DefaultTableModel)table.getModel();
      m.insertRow(0, (new Object[]{2,"����2","¯��","2018-03-29",a}));
//      �̷��� ������� �����ͼ� �ѷ��ָ� �ɰͰ����ϴ�.
//      m.insertRow(0, new Object[]{num, borderTitle, userName, date, count});
        //���̺���
//        table.updateUI();
        
      
      // F : ���̺�
   }

   private void event() {
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// â ����
      simulation.addActionListener(e -> {
         // �ùķ��̼� �� ȣ��
         Simulation_Form callSF = new Simulation_Form();
      });
      // ���콺Ŭ�� �̺�Ʈ
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            int rowCount = table.getSelectedRowCount();
//            int colCount = table.getColumnCount();
//            for(int i = 0; i < colCount; i++) {
                //System.out.println(table.getValueAt(row, col));
            	//�Խù��� Ŭ������ �� �Խù� ��ȣ�� Board_main�� �����ϰ� Board_main���� ���
                Board_main bm = new Board_main(1);
//            }
            //����������
//            System.out.println(table.getValueAt(row, col));
         }
      });
      //�α׾ƿ�
      logout.addActionListener(event -> {
         this.setVisible(false);
      });
   }
   private void menu() {}
}

// public class Main_Form {
// public static void main(String[] args) {
// //â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
// Main_Form window = new Main_Form();
// }
// }