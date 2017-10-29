package cn.javass.jxc.in.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryMain;



/**
 * �����л�/�����л��ķ�ʽ�������� ���к�/�����л����൱�ڿ��԰Ѷ���ŵ��ļ��У��Ѷ�����ļ��ж����� ����create
 * 
 * @author wushensi
 * 
 */

public class InMainDAOImpl implements InMainDAO {

	private final static String FILE_NAME = "InMain.txt";

	@Override
	public boolean create(InMain inMain) {
		// TODO Auto-generated method stub
		// 1������Ѿ��еĶ�������
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(inMain);
		// 2���鿴��uuid�Ƿ��ظ�
		for (InMain model : list) {
			if (model.getId().equals(inMain.getId())) {
				return false;
			}
		}
		// 2.1���ظ�������false
		// 2.2�����ظ�������ӵ�usermode��list������true
		list.add(inMain);

		// ���л�
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(InMain inMain) {
		// TODO Auto-generated method stub
		// �޸�һ��uuid����������ڣ�����false
		// 1����ȡlist������list �ж�uuid�Ƿ����
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
			if (model.getId().equals(inMain.getId())) {
				// �޸�
				model.setInDate(inMain.getInDate());
				model.setInUserId(inMain.getInUserId());
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
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
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
	public InMain getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1����ѯ���е�list���ж�uuid�Ƿ����
		List<InMain> list = SerialUtil.readFromFile(FILE_NAME);
		for (InMain model : list) {
			if (model.getId().equals(uuid)) {
				return model;
			}
		}
		// 1.1�����򷵻�object
		// 1.2������ �Ż�null
		return null;
	}

	@Override
	public Collection<InMain> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<InMain> getByCondition(InQueryMain inQueryMain) {
		// TODO Auto-generated method stub
		// 1��ѭ�����ж���
		List<InMain> list=SerialUtil.readFromFile(FILE_NAME);
		List<InMain> queryResult=new ArrayList<InMain>();
		for(InMain model:list){
			if(model.getId().equals(inQueryMain.getId())||model.getInUserId().equals(inQueryMain.getInUserId())){
				queryResult.add(model);
				System.out.println("1");
			}
			if(inQueryMain.getInDate()!=0&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate()){
				queryResult.add(model);
				System.out.println("2");
			}
			if(inQueryMain.getInDate()>model.getInDate()&&inQueryMain.getInQueryDate()==0){
				queryResult.add(model);
				System.out.println("3");
			}
			if(inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()<model.getInDate()){
				queryResult.add(model);
				System.out.println("4");
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
//		InMain inMain=new InMain();
//		inMain.setId("2");
//		inMain.setInDate(90000000);
//		inMain.setInUserId("3");
		InQueryMain query=new InQueryMain();
		query.setId("1");
		//query.setInUserId("5");
		Date date=new Date();
		//query.setInDate(0);
		//query.setInQueryDate(date.getTime());
		System.out.println(date.getTime());
		InMainDAO dao=new InMainDAOImpl();
		//System.out.println(dao.update(inMain));
		System.out.println(dao.getByCondition(query));
	}

}
