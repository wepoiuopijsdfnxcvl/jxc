package cn.javass.jxc.in.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.in.dao.dao.InDetailDAO;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryDetail;



/**
 * �����л�/�����л��ķ�ʽ�������� ���к�/�����л����൱�ڿ��԰Ѷ���ŵ��ļ��У��Ѷ�����ļ��ж����� ����create
 * 
 * @author wushensi
 * 
 */

public class InDetailDAOImpl implements InDetailDAO {

	private final static String FILE_NAME = "InDetail.txt";
	private List <InDetail> inDetailList;
	
	public InDetailDAOImpl(List <InDetail> inDetailList){
		this.inDetailList=inDetailList;
	}
	
	public InDetailDAOImpl(){
		
	}

	@Override
	public boolean create(InDetail inDetail) {
		// TODO Auto-generated method stub
		// 1������Ѿ��еĶ�������
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(inDetail);
		// 2���鿴��uuid�Ƿ��ظ�
		for (InDetail model : list) {
			if (model.getId().equals(inDetail.getId())) {
				return false;
			}
		}
		// 2.1���ظ�������false
		// 2.2�����ظ�������ӵ�usermode��list������true
		list.add(inDetail);

		// ���л�
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(InDetail inDetail) {
		// TODO Auto-generated method stub
		// �޸�һ��uuid����������ڣ�����false
		// 1����ȡlist������list �ж�uuid�Ƿ����
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
			if (model.getId().equals(inDetail.getId())) {
				// �޸�
				model.setBookId(inDetail.getBookId());
				model.setInId(inDetail.getInId());
				model.setSumMoney(inDetail.getSumMoney());
				model.setSumNum(inDetail.getSumNum());
				// ���л����ļ�
				SerialUtil.writeToFile(list, FILE_NAME);
				// ����true
				return true;
			}
		}
		// 1.1 �������ڣ��Ż�false
		// 1.2 �ҵ���Ӧ��list usermode���󲢰�usermodel���� �����л����ļ�
		return false;
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		// 1 �Ȱ�ԭ����ȫ����ȡ����
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
			if (model.getId().equals(uuid)) {
				// ɾ��listԪ��
				list.remove(model);
				// ���л����ļ�
				SerialUtil.writeToFile(list, FILE_NAME);
				return true;
			}
		}
		// 2 �鿴��uuid�Ƿ����
		// 2.1 �����ڣ�������userɾ����������true
		// 2.2 �������ڣ��򷵻�false
		return false;
	}

	@Override
	public InDetail getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1����ѯ���е�list���ж�uuid�Ƿ����
		List<InDetail> list = SerialUtil.readFromFile(FILE_NAME);
		for (InDetail model : list) {
			if (model.getId().equals(uuid)) {
				return model;
			}
		}
		// 1.1�����򷵻�object
		// 1.2������ �Ż�null
		return null;
	}

	@Override
	public Collection<InDetail> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<InDetail> getByCondition(InQueryDetail inQueryDetail) {
		// TODO Auto-generated method stub
				// 1��ѭ�����ж���
				List<InDetail> list=null;
				if(inDetailList!=null){
					list=inDetailList;
				}else{
					list=(List<InDetail>) this.getByAll();
				}
				List<InDetail> queryResult=new ArrayList<InDetail>();
				boolean flag_detailID,flag_BookID,flag_UserID,flag_detailSumNum,flag_detailSumMoney;
				
				boolean flag_detail_book,flag_detail_user,flag_book_user;
				
				boolean flag_detail_sum,flag_detail_moeny,flag_book_sum,flag_book_money,flag_user_num,flag_user_money,flag_sum_money;
				
				boolean flag_detail_book_sum,flag_detail_user_sum,flag_book_user_sum,flag_detail_book_money,flag_detail_user_money,flag_book_user_money;
				
				boolean flag_only_detailID,flag_only_BookID,flag_only_UserID,flag_only_detailSumNum,flag_only_detailSumMoney;
				
				boolean flag_detail,flag_user,flag_book,flag_money,flag_sum;
				
				boolean flag_null_detail,flag_null_book,flag_null_user,flag_null_sum,flag_null_money;
				
				flag_null_detail=inQueryDetail.getId()==null;
				flag_null_book=inQueryDetail.getBookId()==null;
				flag_null_user=inQueryDetail.getInId()==null;
				flag_null_sum=inQueryDetail.getSumNum()==0d&&inQueryDetail.getSumQueryNum()==0d;
				flag_null_money=inQueryDetail.getSumMoney()==0d&&inQueryDetail.getSumQueryMoney()==0d;
				
				flag_only_detailID=flag_null_book&&flag_null_user&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_BookID=flag_null_detail&&flag_null_user&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_UserID=flag_null_book&&flag_null_detail&&inQueryDetail.getSumMoney()==0d&&flag_null_sum;
				flag_only_detailSumNum=flag_null_book&&flag_null_detail&&flag_null_user&&flag_null_money;
				flag_only_detailSumMoney=flag_null_book&&flag_null_detail&&flag_null_user&&flag_null_sum;
				
				
				for(InDetail model:list){
					
					flag_detail=model.getId().equals(inQueryDetail.getId());
					flag_book=model.getBookId().equals(inQueryDetail.getBookId());
					flag_user=model.getInId().equals(inQueryDetail.getInId());
					flag_sum=model.getSumNum()>=inQueryDetail.getSumNum()&&model.getSumNum()<=inQueryDetail.getSumQueryNum();
					flag_money=model.getSumMoney()>=inQueryDetail.getSumMoney()&&model.getSumMoney()<=inQueryDetail.getSumQueryMoney();
					
					
					
					flag_detailID=flag_detail&&flag_only_detailID;
					flag_BookID=flag_book&&flag_only_BookID;
					flag_UserID=flag_user&&flag_only_UserID;
					flag_detailSumNum=flag_sum&&flag_only_detailSumNum;
					flag_detailSumMoney=flag_money&&flag_only_detailSumMoney;
					
					flag_detail_book=flag_detail&&flag_book&&flag_null_sum&&flag_null_money&&flag_null_user;
					flag_detail_user=flag_detail&&flag_user&&flag_null_sum&&flag_null_money&&flag_null_book;
					flag_book_user=flag_book&&flag_user&&flag_null_sum&&flag_null_money&&flag_null_detail;
					
					flag_detail_sum=flag_detail&&flag_sum&&flag_null_book&&flag_null_money&&flag_null_user;
					flag_detail_moeny=flag_detail&&flag_money&&flag_null_book&&flag_null_sum&&flag_null_user;
					
					flag_book_sum=flag_book&&flag_sum&&flag_null_detail&&flag_null_user&&flag_null_money;
					flag_book_money=flag_book&&flag_money&&flag_null_detail&&flag_null_user&&flag_null_sum;
					
					flag_user_num=flag_user&&flag_sum&&flag_null_detail&&flag_null_book&&flag_null_money;
					flag_user_money=flag_user&&flag_money&&flag_null_detail&&flag_null_book&&flag_null_sum;
					
					flag_sum_money=flag_sum&&flag_money&&flag_null_detail&&flag_null_book&&flag_null_user;;
					
					flag_detail_book_sum=flag_detail&&flag_book&&flag_sum;
					flag_detail_user_sum=flag_detail&&flag_user&&flag_sum;
					flag_book_user_sum=flag_book&&flag_user&&flag_sum;
					 
					flag_detail_book_money=flag_detail&&flag_book&&flag_money;
					flag_detail_user_money=flag_detail&&flag_user&&flag_money;
					flag_book_user_money=flag_detail&&flag_user&&flag_money;
					
					
					if(flag_detailID){
						queryResult.add(model);
						System.out.println("1");
					}
					
					if(flag_BookID){
						queryResult.add(model);
						System.out.println("2");
					}
					if(flag_UserID){
						queryResult.add(model);
						System.out.println("3");
					}
					if(flag_detailSumNum){
						queryResult.add(model);
						System.out.println("4");
					}
					if(flag_detailSumMoney){
						queryResult.add(model);
						System.out.println("5");
					}
					if(flag_detail_book){
						queryResult.add(model);
						System.out.println("6");
					}
					if(flag_detail_user){
						queryResult.add(model);
						System.out.println("7");
					}
					if(flag_book_user){
						queryResult.add(model);
						System.out.println("8");
					}
					if(flag_detail_sum){
						queryResult.add(model);
						System.out.println("9");
					}
					if(flag_detail_moeny){
						queryResult.add(model);
						System.out.println("10");
					}
					if(flag_book_sum){
						queryResult.add(model);
						System.out.println("11");
					}
					if(flag_book_money){
						queryResult.add(model);
						System.out.println("12");
					}
					if(flag_user_num){
						queryResult.add(model);
						System.out.println("13");
					}
					if(flag_user_money){
						queryResult.add(model);
						System.out.println("14");
					}
					if(flag_sum_money){
						queryResult.add(model);
						System.out.println("15");
					}
					if(flag_detail_book_sum){
						queryResult.add(model);
						System.out.println("16");
					}
					if(flag_detail_user_sum){
						queryResult.add(model);
						System.out.println("17");
					}
					if(flag_book_user_sum){
						queryResult.add(model);
						System.out.println("18");
					}
					if(flag_detail_book_money){
						queryResult.add(model);
						System.out.println("19");
					}
					if(flag_detail_user_money){
						queryResult.add(model);
						System.out.println("20");
					}
					if(flag_book_user_money){
						queryResult.add(model);
						System.out.println("21");
					}
					
				}
				// 2���ѷ���������model����list
				// ���߼�
				// ������
				// �����
				// 3������list
				return queryResult;
}

	public static void main(String[] args) {
		/*InDetail inDetail=new InDetail();
		inDetail.setId("1");
		inDetail.setBookId("1");
		inDetail.setInId("1");
		inDetail.setSumNum(15);
		inDetail.setSumMoney(153.5d);
		InDetailDAO dao=new InDetailDAOImpl();*/
		//System.out.println(dao.create(inDetail));
		//dao.delete("2");
		InDetailDAO dao=new InDetailDAOImpl();
		InQueryDetail query=new InQueryDetail();
		//query.setId("8");
		//query.setBookId("2");
		query.setInId("1");
		//query.setSumNum(1);
		//query.setSumQueryNum(1);
		//query.setSumMoney(70);
		//query.setSumQueryMoney(300);
		System.out.println(dao.getByCondition(query));
		System.out.println(dao.getByAll());
	}

}
