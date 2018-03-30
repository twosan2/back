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
   
   // S : JTable변수
   private int num;
   private String borderTitle;
   private String userName;
   private Date date;
   private int count;
   private int a = count+1;
   
   // F : JTable변수
   
   private String[] header = new String[] { "번호", "제목", "이름", "날자", "조회수" };
   private JButton profile = new JButton("프로필");
   private JLabel user = new JLabel(userName + "님", JLabel.CENTER);
   private JButton simulation = new JButton("시뮬레이션");
   private JButton userInformation = new JButton("정보수정");
   private JButton logout = new JButton("로그아웃");
   private JLabel title = new JLabel("< 게시판 >");
   private Font font = new Font("", Font.PLAIN, 30);
   private JTable table;

   public Main_Form() {
      this.display();
      this.event();
      this.menu();
      this.setTitle("GUI테스트");
      this.setSize(1000, 600);
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.setVisible(true);
   }
   
   private void display() {
      this.setContentPane(mainPanel);
      mainPanel.setLayout(null);
      // 위치와 사이즈설정
      profile.setBounds(28, 18, 130, 128);
      user.setBounds(28, 160, 106, 50);
      userInformation.setBounds(40, 220, 106, 50);
      logout.setBounds(40, 310, 106, 50);
      simulation.setBounds(40, 400, 106, 50);
      title.setBounds(190, 18, 770, 40);
      // 폰트
      title.setFont(font);
      // 색상설정
      mainPanel.setBackground(Color.WHITE);
      profile.setBackground(Color.pink);
      // 보여주기
      mainPanel.add(profile);
      mainPanel.add(user);
      mainPanel.add(simulation);
      mainPanel.add(userInformation);
      mainPanel.add(logout);
      mainPanel.add(title);
      // S : 테이블
      //확인을 위해 넣어놨습니다.
      Object[][] data = {
            {1,"제목1","짱아","2018-03-29",1}
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
      // 스크롤설정
      pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      mainPanel.add(pane);
      pane.setBounds(190, 68, 770, 469);
      // 테이블 정렬
      DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      TableColumnModel columnModel = table.getColumnModel();
      for (int i = 0; i < columnModel.getColumnCount(); i++) {
         columnModel.getColumn(i).setCellRenderer(renderer);
      }
      // 테이블 header width값 설정
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table.getColumnModel().getColumn(0).setPreferredWidth(34);
      table.getColumnModel().getColumn(1).setPreferredWidth(400);
      table.getColumnModel().getColumn(2).setPreferredWidth(100);
      table.getColumnModel().getColumn(3).setPreferredWidth(130);
      table.getColumnModel().getColumn(4).setPreferredWidth(88);
      // 테이블 이동불가
      table.getTableHeader().setReorderingAllowed(false);
      // 테이블 크기 조절 불가
      table.getTableHeader().setResizingAllowed(false);
      
      //테이블 0번째 줄에 추가
      DefaultTableModel m = (DefaultTableModel)table.getModel();
      m.insertRow(0, (new Object[]{2,"제목2","짱아","2018-03-29",a}));
//      이러한 변수들로 가져와서 뿌려주면 될것같습니다.
//      m.insertRow(0, new Object[]{num, borderTitle, userName, date, count});
        //테이블갱신
//        table.updateUI();
        
      
      // F : 테이블
   }

   private void event() {
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 창 종료
      simulation.addActionListener(e -> {
         // 시뮬레이션 폼 호출
         Simulation_Form callSF = new Simulation_Form();
      });
      // 마우스클릭 이벤트
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            int rowCount = table.getSelectedRowCount();
//            int colCount = table.getColumnCount();
//            for(int i = 0; i < colCount; i++) {
                //System.out.println(table.getValueAt(row, col));
            	//게시물을 클릭했을 때 게시물 번호를 Board_main에 전달하고 Board_main폼이 뜬다
                Board_main bm = new Board_main(1);
//            }
            //값가져오기
//            System.out.println(table.getValueAt(row, col));
         }
      });
      //로그아웃
      logout.addActionListener(event -> {
         this.setVisible(false);
      });
   }
   private void menu() {}
}

// public class Main_Form {
// public static void main(String[] args) {
// //창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
// Main_Form window = new Main_Form();
// }
// }