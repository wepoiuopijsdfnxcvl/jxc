package cn.javass.c16;

import cn.javass.c16.dao.dao.DepDAO;
import cn.javass.c16.dao.factory.F1Factory;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepDAO dao= F1Factory.getDepDAO();//ֻ֪�ӿڣ���֪ʵ���࣬�ҹ�������
		dao.create("001", "zhangsan");
	}

}
