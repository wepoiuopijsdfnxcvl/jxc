package cn.javass.jxc.user.dao.dao;

import java.util.Collection;

import cn.javass.jxc.user.vo.BookModel;
import cn.javass.jxc.user.vo.BookQueryModel;

public interface UserDAO {
	/**
	 * ���һ��<br>
	 * ���uuid�ظ�������false <br>
	 * 1������Ѿ��еĶ�������
	 * 2���鿴��uuid�Ƿ��ظ�
	 * 2.1���ظ�������false
	 * 2.2�����ظ�������ӵ�usermode��list������true
	 * @param user
	 * @return
	 */
	public boolean create(BookModel user);

	/**
	 * �޸�һ��uuid����������ڣ�����false
	 * 1����ȡlist������list �ж�uuid�Ƿ����
	 * 1.1 �������ڣ��Ż�false
	 * 1.2 �ҵ���Ӧ��list usermode���󲢰�usermodel���� �����л����ļ�
	 * @param user
	 * @return
	 */
	public boolean update(BookModel user);

	/**
	 * ɾ��һ�� ��������ڣ�����false
	 * 1 �Ȱ�ԭ����ȫ����ȡ����
	 * 2 �鿴��uuid�Ƿ����
	 * 2.1 �����ڣ�������userɾ����������true
	 * 2.2 �������ڣ��򷵻�false
	 * @param user
	 * @return
	 */
	public boolean delete(String uuid);

	/**
	 * ������������һ��
	 * 1����ѯ���е�list���ж�uuid�Ƿ����
	 * 1.1�����򷵻�object
	 * 1.2������ �Ż�null
	 * 
	 * @param uuid
	 * @return
	 */
	public BookModel getByUuid(String uuid);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Collection<BookModel> getByAll();

	/**
	 * ���������ҷ��ϵĶ��󼯺�
	 * 
	 * @param user
	 * @return
	 */
	public Collection<BookModel> getByCondition(BookQueryModel user);
}
