package cn.javass.c12.awt.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class testObjectInputStream {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testObjectInputStream test=new testObjectInputStream();
		String fileName="E:/JAVAWEB/UP/Java˽��Java�������и���Ŀ����/Java˽�ӡ�Java�м�/3/gui_database.conf";
		//String fileName="D:/��������/0922/test.txt";
		test.readObject(fileName);
	}
	
	public void readObject(String fileName) throws Exception{
		FileInputStream fis=new FileInputStream(fileName);
		ObjectInputStream bis=new ObjectInputStream(fis);
		List list=new ArrayList();
		list=(List)bis.readObject();
		//System.out.println("object---"+bis.readObject());
		System.out.println("list---"+list);
		bis.close();
		//return null;
	}

}
