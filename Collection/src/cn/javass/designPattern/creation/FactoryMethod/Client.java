package cn.javass.designPattern.creation.FactoryMethod;

public class Client {

	/**
	 * @param args
	 */
	
	/**
	 * ����ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ������ͨ����������ģʽ���д����������ϵ�����ģʽ�У�
	 * ��һ�����������ַ������󣬲�����ȷ�������󣬵���������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£�
	 * ���ǻ�ѡ�õ����֡�����̬��������ģʽ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SenderFactory factory=new SenderFactory();
		Sender sender=factory.produce("sms");
		sender.send();
	}

}
