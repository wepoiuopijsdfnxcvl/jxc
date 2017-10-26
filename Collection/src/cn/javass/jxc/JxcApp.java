package cn.javass.jxc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import cn.javass.jxc.book.panels.BookListPanel;



/**
 * �ڳ�ʼ��jListʱ��������
 * 1����������
 * 2��type��ʾ��ʵֵ����Ҫת��(ʹ��ö������̬ת���û�����typeֵ)
 * @author wushensi
 *
 */
public class JxcApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JxcApp window = new JxcApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JxcApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BookListPanel(frame));
		//frame.getContentPane().add(new ListPanel(frame));
	}

}
