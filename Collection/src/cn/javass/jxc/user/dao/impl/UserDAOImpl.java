package cn.javass.jxc.user.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.user.dao.dao.UserDAO;
import cn.javass.jxc.user.vo.UserModel;
import cn.javass.jxc.user.vo.UserQueryModel;

/**
 * �����л�/�����л��ķ�ʽ�������� ���к�/�����л����൱�ڿ��԰Ѷ���ŵ��ļ��У��Ѷ�����ļ��ж����� ����create
 * 
 * @author wushensi
 * 
 */

public class UserDAOImpl implements UserDAO {

	private final static String FILE_NAME = "User.txt";

	@Override
	public boolean create(UserModel user) {
		// TODO Auto-generated method stub
		// 1������Ѿ��еĶ�������
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);

		// 2���鿴��uuid�Ƿ��ظ�
		for (UserModel model : list) {
			if (model.getUuid().equals(user.getUuid())) {
				return false;
			}
		}

		// 2.1���ظ�������false
		// 2.2�����ظ�������ӵ�usermode��list������true
		list.add(user);

		// ���л�
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(UserModel user) {
		// TODO Auto-generated method stub
		// �޸�һ��uuid����������ڣ�����false
		// 1����ȡlist������list �ж�uuid�Ƿ����
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(user.getUuid())) {
				// �޸�
				model.setName(user.getName());
				model.setPwd(user.getPwd());
				model.setType(user.getType());
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
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(uuid)) {
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
	public UserModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1����ѯ���е�list���ж�uuid�Ƿ����
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (UserModel model : list) {
			if (model.getUuid().equals(uuid)) {
				return model;
			}
		}
		// 1.1�����򷵻�object
		// 1.2������ �Ż�null
		return null;
	}

	@Override
	public Collection<UserModel> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<UserModel> getByCondition(UserQueryModel user) {
		// TODO Auto-generated method stub
		// 1��ѭ�����ж���
		List<UserModel> list = SerialUtil.readFromFile(FILE_NAME);
		List<UserModel> queryResult = new ArrayList<UserModel>();
		// 2���ѷ���������model����list
		System.out.println("------"+list);
		for (UserModel model : list) {
			// ���߼�
			if(user.getType()>0){
				if (user.getType() == model.getType()) {
					queryResult.add(model);
				}
			}else if(model.getUuid().equals(user.getUuid())){
				queryResult.add(model);
			}else if(model.getName().indexOf(user.getName())>=0) {
				if(user.getName().equals("")){
					continue;
				}
				queryResult.add(model);
			}
			
			// ������
			// �����
		}
		// 3������list
		return queryResult;
	}

	public static void main(String[] args) {
		UserDAO userdao = new UserDAOImpl();
		// UserModel user=new UserModel();
		UserQueryModel query = new UserQueryModel();
		query.setUuid("");
		query.setName("");
		query.setType(4);
		System.out.println("------"+userdao.getByCondition(query));
		
	
	}

}
