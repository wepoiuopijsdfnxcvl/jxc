package cn.javass.c5.work;

public class Zy08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = args[0].toCharArray();
		countCharacter(c);
	}

	public static void countCharacter(char[] c) {
		int numCount = 0, lowerCaseCount = 0, upperCaseCount = 0, otherCount = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 97 && c[i] <= 122) {
				lowerCaseCount++;
			} else if (c[i] >= 65 && c[i] <= 106) {
				upperCaseCount++;
			} else if (c[i] >= 48 && c[i] <= 57) {
				numCount++;
			} else {
				otherCount++;
			}
		}
		System.out.println("��д��ĸͳ�Ƹ�����" + upperCaseCount);
		System.out.println("Сд��ĸͳ�Ƹ�����" + lowerCaseCount);
		System.out.println("��ֵͳ�Ƹ�����" + numCount);
		System.out.println("�����ַ�ͳ�Ƹ�����" + otherCount);
	}

}
