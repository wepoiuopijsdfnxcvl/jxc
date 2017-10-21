package cn.javass.c10.awt.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdatePanel extends JPanel {
	private JTextField txt_name;
	private JTextField txt_sex;
	private JTextField txt_age;
	private JTextField txt_address;
	private JFrame updateFrame;
	private String getInfo=null;
	private static List list=null;

	/**
	 * Create the panel.
	 */
	public boolean ListUpdate(List list,String oldStr,String newStr){
		boolean flag=false;
		Object[] objs=list.toArray();
		list.clear();
		for(Object str:objs){
			if(str.equals(oldStr)){
				str=newStr;
				flag=true;
			}
			list.add(str);
		}
		System.out.println("ListUpdate---"+list);
		return flag;
	}
	public void update(){
		//1:收集参数
		String name=txt_name.getText();
		String age=txt_age.getText();
		String sex=txt_sex.getText();
		String address=txt_address.getText();
		
		//2、组织参数
		String setInfo=name+","+age+","+sex+","+address;
		
		//3、添加到组件上
		boolean flag=this.ListUpdate(list, getInfo, setInfo);
		
		//4:根据返回值切换界面
		if(flag){
			back();
		}
		
	}
	public void back(){
		this.updateFrame.getContentPane().removeAll();
		ListPanel listPanel=new ListPanel(list);
		listPanel.setMainFrame(this.updateFrame);
		listPanel.setList(list);
		this.updateFrame.getContentPane().add(listPanel);
		this.updateFrame.getContentPane().validate();
	}
	public UpdatePanel(JFrame updateFrame,List list,String getInfo) {
		this.updateFrame=updateFrame;
		this.list=list;
		this.getInfo=getInfo;
		this.setSize(800, 600);
		this.setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539");
		label.setBounds(131, 26, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(10, 66, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(10, 115, 46, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u9F84");
		label_3.setBounds(159, 66, 46, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setBounds(159, 115, 46, 14);
		add(label_4);
		String[] parameter=getInfo.split(",");
		txt_name = new JTextField();
		txt_name.setBounds(45, 63, 86, 20);
		
		txt_name.setText(parameter[0]);
		add(txt_name);
		
		txt_name.setColumns(10);
	
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(45, 112, 86, 20);
		
		txt_sex.setText(parameter[1]);
		add(txt_sex);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(215, 63, 86, 20);
		
		txt_age.setText(parameter[2]);
		add(txt_age);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(215, 112, 86, 20);
		txt_address.setText(parameter[3]);
		add(txt_address);
		
		JButton button1 = new JButton("\u4FEE\u6539");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		button1.setBounds(75, 236, 89, 23);
		add(button1);
		
		JButton button2 = new JButton("\u8FD4\u56DE");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		button2.setBounds(215, 236, 89, 23);
		add(button2);
	}
}
