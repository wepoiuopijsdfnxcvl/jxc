package cn.javass.designPattern.creation.AbstractFactory;

public class Client {

	/**
	 * @param args
	 * 
	 * ��ʵ���ģʽ�ĺô����ǣ����������������һ�����ܣ�����ʱ��Ϣ����ֻ����һ��ʵ���࣬ʵ��Sender�ӿ�
	 * ��ͬʱ��һ�������࣬ʵ��Provider�ӿڣ���OK�ˣ�����ȥ�Ķ��ֳɵĴ��롣����������չ�ԽϺã�
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provider provider=new imSenderFactory();//���󹤳���emailSenderFactoryָ������Ĺ���ʵ��
		Sender sender=provider.produce();//��������ʹ�ù�������produce
		sender.send();
	}

}
