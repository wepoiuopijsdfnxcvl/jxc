package cn.javass.jxc.user.vo;

import java.io.Serializable;

import cn.javass.jxc.user.UserTypeEnum;

/**
 * ����ֵ����ģʽ
 * ÿһ�������Ӧһ��Model�࣬������������������Ϊ������͵��ֶ�
 * 1��private Filed��Ӧ����get��set
 * 
 * 2��������дequals��hashcode����ʾ���ֶ���
 * 
 * 3��ʵ�ֿ����л����ڱ������
 * 
 * 4�� ����һ��Ĭ�Ϲ��췽�� public �޲�
 * 
 * @author wushensi
 *
 */
public class BookModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return uuid + ", " + name + ", " + UserTypeEnum.getUserType(type);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String uuid,name,pwd;
	private int type;
}
