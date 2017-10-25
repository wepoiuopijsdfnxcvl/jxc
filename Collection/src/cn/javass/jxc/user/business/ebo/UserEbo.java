package cn.javass.jxc.user.business.ebo;

import java.util.Collection;

import cn.javass.jxc.user.business.ebi.UserEbi;
import cn.javass.jxc.user.dao.dao.UserDAO;
import cn.javass.jxc.user.dao.factory.UserDAOFactory;
import cn.javass.jxc.user.vo.UserModel;
import cn.javass.jxc.user.vo.UserQueryModel;
/**
 * ���� ebo���ü�һ�㣬ֱ�ӵ���dao�Ĳ������൱��ת�����������������Ĺ�������������������
 * @author wushensi
 *
 */
public class UserEbo implements UserEbi {

	@Override
	public boolean create(UserModel user) {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.create(user);
	}

	@Override
	public boolean update(UserModel user) {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.update(user);
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.delete(uuid);
	}

	@Override
	public UserModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.getByUuid(uuid);
	}

	@Override
	public Collection<UserModel> getByAll() {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.getByAll();
	}

	@Override
	public Collection<UserModel> getByCondition(UserQueryModel user) {
		// TODO Auto-generated method stub
		UserDAO userDAO=UserDAOFactory.getUserDAO();
		return userDAO.getByCondition(user);
	}

}
