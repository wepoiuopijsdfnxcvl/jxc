package cn.javass.designPattern.creation.Builder;

public class Client {

	/**
	 * @param args
	 */
	
	//����㿴����������ģʽ���ܶ๦�ܼ��ɵ�һ������������Դ�����Ƚϸ��ӵĶ����������빤��ģʽ��������ǣ�
	//����ģʽ��ע���Ǵ���������Ʒ����������ģʽ���ע�������϶��󣬶�����֡���ˣ���ѡ�񹤳�ģʽ���ǽ�����ģʽ����ʵ�����������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder builder=new Builder();
		builder.produceEmailSender(5);
		System.out.println("list length --->"+builder.getList().size()+"----"+builder.getList());
	}

}
