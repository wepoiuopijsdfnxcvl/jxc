package cn.javass.designPattern.creation.prototype;

public class Client {

	/**
	 * @param args
	 */
	
	//ԭ��ģʽ��Ȼ�Ǵ����͵�ģʽ�������빤��ģʽû�й�ϵ�������ּ��ɿ�������ģʽ��˼����ǽ�һ��������Ϊԭ�ͣ�������и��ơ���¡������һ����ԭ������
	//�Ƶ��¶��󡣱�С���ͨ������ĸ��ƣ����н��⡣��Java�У����ƶ�����ͨ��clone()ʵ�ֵģ��ȴ���һ��ԭ���ࣺ
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		UserModel um=new UserModel();
		Prototype p=new Prototype();
		Prototype p1=new Prototype();
		um.setAge(27);
		um.setUuid("1");
		um.setUname("user");
		p.setObj(um);
		p.setStr("helloworld");
		
		p1=(Prototype) p.deepClone();
		System.out.println(p1.getStr()+"------"+p1.getObj());
		
		
		
	}

}
