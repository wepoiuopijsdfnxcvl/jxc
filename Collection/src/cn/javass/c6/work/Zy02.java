/*
 * 2��дһ�����������ܣ�����һ��һά�� int ���飬����Ϊ 3���������������� a,b,c ��ֵ��
����,Ȼ�����ǰ���С�����˳�������ʹ��ð������
*/
package cn.javass.c6.work;

public class Zy02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list=new int [15];
		initList(list);
		iterator(list);
		sortList(list);
		iterator(list);
	}
	
	//��ʼ������
	public static void initList(int list[]){
		for(int i=0;i<list.length;i++){
			list[i]=(int)(Math.random()*10);
		}
	}
	//ð������
	public static void sortList(int list[]){
		int temp;
		for(int i=0;i<list.length;i++){
			for(int j=i;j<list.length;j++){
				if(list[i]>list[j]){
					temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
	}
	//�������
	public static void iterator(int list[]){
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}

}
