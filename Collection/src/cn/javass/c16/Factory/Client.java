package cn.javass.c16.Factory;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���Ը��죬�������ļ��ж�ȡ1������2��ֵ����̬��������
		Api api=Factory.createApi(1);
		api.method();
	}

}
