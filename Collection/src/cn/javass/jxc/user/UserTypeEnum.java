package cn.javass.jxc.user;

/**
 * 1 ����������һ���������Լ������Ժͷ���
 * 2 ���Ķ���ֻ���������е��﷨��Ԫ����֮ǰ���壬��Ϊpublic static final������
 * 3 values����Ҫע��
 * @author wushensi
 *
 */
public enum UserTypeEnum {
	ADMIN(1,"��������Ա"),BOOK(2,"ͼ�����Ա"),IN(3,"��������Ա"),OUT(4,"��������Ա"),STOCK(5,"������Ա"),USER(6,"��ͨ�û�"),;
	
	private final int type;
	private final String name;
	private UserTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	
	public static String getUserType(int type){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getType()==type){
				return userType.getName();
			}
		}
		return "�������������";
	}
	
	public static int getUserName(String name){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getName().equals(name)){
				return userType.getType();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		//System.out.println(UserTypeEnum.getUserType(8));
		System.out.println(UserTypeEnum.getUserName("��������Ա"));
	}
	
}
