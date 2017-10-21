package cn.javass.designPattern.creation.FactoryMethod;

public class SenderFactory {
	
	public Sender produce(String type){
		if(type.equals("email")){
			return new emailSenderImpl();
		}else if(type.equals("sms")){
			return new smsSenderImpl();
		}else{
			System.out.println("�½�����ʧ��");
			return null;
		}
		
	}
}
