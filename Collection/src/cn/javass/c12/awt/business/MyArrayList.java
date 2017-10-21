package cn.javass.c12.awt.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javass.c12.awt.dao.FileOpe;

/**
 * �����װ�༯�ϣ�������������������൱��һ���ڴ�DB
 */
public class MyArrayList extends ArrayList {
	private final static String FILE_NAME = "E:/JAVAWEB/UP/Java˽��Java�������и���Ŀ����/Java˽�ӡ�Java�м�/3/gui_database.conf";
	private static List list = null;
	
	public static List getList() {
		list=FileOpe.readList(FILE_NAME);
		return list;
	}
	
	public boolean add(Object obj) {
		boolean flag = super.add(obj);
		if (flag) {
			System.out.println("writeList---"+this);
			FileOpe.writeList(this, this.FILE_NAME);
		}
		return flag;
	}
}
