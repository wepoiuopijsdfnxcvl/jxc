package cn.javass.jxc.in.vo;

import java.io.Serializable;

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
 * �����Ĺ������� uuid,sumNum,sumMoeny
 * �����������������ϵ inId,bookId
 * @author wushensi
 *
 */
public class InQueryDetail extends InDetail{
	private int sumQueryNum;
	private long sumQueryMoney;
	public int getSumQueryNum() {
		return sumQueryNum;
	}
	public void setSumQueryNum(int sumQueryNum) {
		this.sumQueryNum = sumQueryNum;
	}
	public long getSumQueryMoney() {
		return sumQueryMoney;
	}
	public void setSumQueryMoney(long sumQueryMoney) {
		this.sumQueryMoney = sumQueryMoney;
	}
	
}
