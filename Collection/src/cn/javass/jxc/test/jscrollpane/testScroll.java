package cn.javass.jxc.test.jscrollpane;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
 
public class testScroll extends JFrame{
    private JPanel contentPane; 
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public testScroll(){
         contentPane=new JPanel();
         this.setSize(800, 600);
         contentPane.setSize(400, 300);
         contentPane.setLayout(new BorderLayout(400,300));
         this.setContentPane(contentPane);
         scrollPane=new JScrollPane();
         contentPane.add(scrollPane,BorderLayout.CENTER);
         textArea=new JTextArea();
         //scrollPane.add(textArea); 
         scrollPane.setSize(300, 100);
         scrollPane.setViewportView(textArea);
         this.setTitle("�������ʹ��");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setBounds(100, 100, 250, 200);
         this.setVisible(true);
     }
    public static void main(String []args){
    	testScroll example=new testScroll(); 
    }
}
