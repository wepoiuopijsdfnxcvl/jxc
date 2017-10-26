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
public class BookQueryModel extends BookModel{
	private double inPriceLess;
	private double inPriceMore;
	private double SalePriceLess;
	private double SalePriceMore;
	public double getInPriceLess() {
		return inPriceLess;
	}
	public void setInPriceLess(double inPriceLess) {
		this.inPriceLess = inPriceLess;
	}
	public double getInPriceMore() {
		return inPriceMore;
	}
	public void setInPriceMore(double inPriceMore) {
		this.inPriceMore = inPriceMore;
	}
	public double getSalePriceLess() {
		return SalePriceLess;
	}
	public void setSalePriceLess(double salePriceLess) {
		SalePriceLess = salePriceLess;
	}
	public double getSalePriceMore() {
		return SalePriceMore;
	}
	public void setSalePriceMore(double salePriceMore) {
		SalePriceMore = salePriceMore;
	}
}
