package cn.javass.jxc.in.dao.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		List<InMain> list=(List<InMain>) this.getByAll();
		List<InMain> queryResult=new ArrayList<InMain>();
		boolean flag_mainID,flag_UID,flag_MainUserID,flag_dateMin,flag_dateMax,flag_Min_Max,flag_Date_mainID,flag_Date_UID,flag_Date_MainUserID;
		
		
		for(InMain model:list){
			flag_mainID=model.getId().equals(inQueryMain.getId())&&inQueryMain.getInUserId()==null&&inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()==0;
			flag_UID=model.getInUserId().equals(inQueryMain.getInUserId())&&inQueryMain.getId()==null&&inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()==0;
			flag_MainUserID=model.getId().equals(inQueryMain.getId())&&model.getInUserId().equals(inQueryMain.getInUserId())&&inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()==0;
			flag_Min_Max=inQueryMain.getInDate()!=0&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate()&&inQueryMain.getId()==null&&inQueryMain.getInUserId()==null;
			flag_dateMin=inQueryMain.getInQueryDate()==0&&inQueryMain.getInDate()>model.getInDate();
			flag_dateMax=inQueryMain.getInDate()==0&&inQueryMain.getInQueryDate()<model.getInDate()&&inQueryMain.getInQueryDate()!=0;
			flag_Date_mainID=model.getId().equals(inQueryMain.getId())&&inQueryMain.getInUserId()==null&&inQueryMain.getInDate()!=0&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate()&&inQueryMain.getInUserId()==null;
			flag_Date_UID=inQueryMain.getInDate()!=0&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate()&&inQueryMain.getId()==null&&model.getInUserId().equals(inQueryMain.getInUserId());
			flag_Date_MainUserID=model.getId().equals(inQueryMain.getId())&&model.getInUserId().equals(inQueryMain.getInUserId())&&inQueryMain.getInDate()<=model.getInDate() && model.getInDate()<=inQueryMain.getInQueryDate();
			
			if(flag_mainID){
				queryResult.add(model);

			}else if(flag_UID){
				queryResult.add(model);

			}else if(flag_MainUserID){
				queryResult.add(model);

			}
			if(flag_Min_Max){
				queryResult.add(model);

			}
			if(flag_dateMin){
				queryResult.add(model);

			}
			if(flag_dateMax){
				queryResult.add(model);

			}
			if(flag_Date_mainID){
				queryResult.add(model);

			}
			if(flag_Date_UID){
				queryResult.add(model);

			}
			if(flag_Date_MainUserID){
				queryResult.add(model);
			}
			
		}
		// 2���ѷ���������model����list
		// ���߼�
		// ������
		// �����
		// 3������list
		return queryResult;
	}
	

	public static void main(String[] args) throws ParseException {
		InQueryMain query=new InQueryMain();
		query.setId("4");
		//query.setInUserId("1");
		//SimpleDateFormat sdf =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date dateMin = (Date) sdf.parse("2017-11-1 13:43:00");
		//Date dateMax = (Date) sdf.parse("2017-11-10 13:43:00");
		//query.setInDate(dateMin.getTime());
		//query.setInQueryDate(dateMax.getTime());
		InMainDAO dao=new InMainDAOImpl();
		System.out.println(dao.getByCondition(query));
		
	}

}
