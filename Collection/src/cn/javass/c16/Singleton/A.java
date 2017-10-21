package cn.javass.c16.Singleton;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class A {
	// 5 ���������Լ�����ʵ��

	// ��ΪgetInstance�����Ǿ�̬�ģ����þ�̬����ֻ�ܵ��þ�̬����
	private static A a = null;

	// �ջ��ⲿ�ܹ�new A()��Ȩ��
	private A() {

	}

	// 2 �������ⲿ�����ṩ�Լ���ʵ��

	// 3 �ⲿ�޷�new ͨ���෽������ ��static�ؼ���
	public static A getInstance() {
		// 4 ��취ͨ���ڲ����Ƶ��ù��췽������
		// 7 �ڵ�һ�ε���ʱ��ʼ��
		if (a == null) {
			// 8: ������ʼ��
			a = new A();
		}

		return a;
	}

	// 1 ���������������ݵ�����
	private Map<String, A> map = new HashMap<String, A>();

	public A getInstance2() {
		// 2 ���������������Ҫʹ�õ�����
		A a = map.get("one");
		// 3 ����Ҳ��� ���½�һ�����ݣ���ȡһ�����ݣ������浽������
		if (a == null) {
			a = new A();
			map.put("one", a);
		}
		// 4 ����ҵ��ͷ���
		return a;
	}

	// 1: ���������������ݵ�����
	private static Map<Integer, A> map1 = new HashMap<Integer, A>();
	// ������¼��ǰ����ʹ����һ��ʵ������ʼΪ1
	private static int num = 1;
	// ������¼��Ҫ���Ƶ� ʵ������Ϊ3��
	private static int count = 3;

	// 1 ���������������ݵ�����
	public static A getInstance3() {
		// 2 ���������������Ҫʹ�õ�����
		A a = map1.get(num);
		// 3 ����Ҳ��� ���½�һ�����ݣ���ȡһ�����ݣ������浽������
		if (a == null) {
			a = new A();
			map1.put(num, a);
		}
		// ÿ����һ�Σ��Ͱ�num��1
		num++;
		// ��num�������Ƶ���������ô��num����Ϊ1����ʼѭ���ظ�ʹ��
		if (num > count) {
			num = 1;
		}
		// 4 ����ҵ��ͷ���
		return a;
	}

	public static void main(String[] args) {
		A a1 = A.getInstance3();
		A a2 = A.getInstance3();
		A a3 = A.getInstance3();
		A a4 = A.getInstance3();
		A a5 = A.getInstance3();
		A a6 = A.getInstance3();
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		System.out.println(a6);
		//Calendar calendar=Calendar.getInstance();
	}

}
