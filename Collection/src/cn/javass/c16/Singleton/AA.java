package cn.javass.c16.Singleton;

//���ػ��ƽǶ�

//�̰߳�ȫ�Ƕ�


public class AA {
	//1 �ջ�new AA����Ȩ��
	private AA(){
		
	}
	// static ����������������ֻ�ᴴ��һ����ַ�ռ�
	private static AA aa=new AA();
	//2 �������ⲿ�����ṩ�Լ���ʵ��
	public AA getInstance(){
		
		return aa;
	}
}
