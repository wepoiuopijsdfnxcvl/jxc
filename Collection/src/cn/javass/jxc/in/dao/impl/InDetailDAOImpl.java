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
		List<InDetail> list=SerialUtil.readFromFile(FILE_NAME);
		List<InDetail> queryResult=new ArrayList<InDetail>();
		for(InDetail model:list){
			
		}
		// 2���ѷ���������model����list
		
			// ���߼�
			
			// ������
			// �����
		// 3������list
		return queryResult;
	}

	public static void main(String[] args) {
		InDetail inDetail=new InDetail();
		inDetail.setId("1");
		inDetail.setBookId("1");
		inDetail.setInId("1");
		inDetail.setSumNum(15);
		inDetail.setSumMoney(153.5d);
		InDetailDAO dao=new InDetailDAOImpl();
		//System.out.println(dao.create(inDetail));
		//dao.delete("2");
		System.out.println(dao.update(inDetail));
		System.out.println(dao.getByAll());
		
	
	}

}
