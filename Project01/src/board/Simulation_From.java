package board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class Simulation_From extends JFrame {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Simulation_From frame = new Simulation_From();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Simulation_From() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.NORTH);
      
      JLabel lblNewLabel = new JLabel("\uC2DC\uBBAC\uB808\uC774\uC158 Form");
      panel.add(lblNewLabel);
      
      JPanel panel_1 = new JPanel();
      contentPane.add(panel_1, BorderLayout.CENTER);
      
      JList list = new JList();
      panel_1.add(list);
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.SOUTH);
      
      JLabel lblNewLabel_1 = new JLabel("\uC6D4 \uB0A9\uC785\uAE08 :  ");
      panel_2.add(lblNewLabel_1);
      
      JEditorPane editorPane = new JEditorPane();
      panel_2.add(editorPane);
      
      JLabel label = new JLabel("                   ");
      panel_2.add(label);
      
      JButton button = new JButton("\uACC4\uC0B0\uD558\uAE30");
      panel_2.add(button);
      
   }

}