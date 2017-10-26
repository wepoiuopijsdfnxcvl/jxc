package cn.javass.jxc.book.vo;

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
	
	public BookModel(){
		
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

	@Override
	public String toString() {
		return uuid + "," + name + ","
				+ inPrice + "," + salePrice;
	}

	private static final long serialVersionUID = 1L;
	
	
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
	
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	private String uuid,name;
	private double inPrice,salePrice;
}
