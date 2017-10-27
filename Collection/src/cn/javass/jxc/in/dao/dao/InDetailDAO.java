package cn.javass.jxc.in.dao.dao;

import java.util.Collection;

import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InQueryDetail;



public interface InDetailDAO {
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
	public boolean create(InDetail inDetail);

	/**
	 * �޸�һ��uuid����������ڣ�����false
	 * 1����ȡlist������list �ж�uuid�Ƿ����
	 * 1.1 �������ڣ��Ż�false
	 * 1.2 �ҵ���Ӧ��list usermode���󲢰�usermodel���� �����л����ļ�
	 * @param user
	 * @return
	 */
	public boolean update(InDetail inDetail);

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
	public InDetail getByUuid(String uuid);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Collection<InDetail> getByAll();

	/**
	 * ���������ҷ��ϵĶ��󼯺�
	 * 
	 * @param user
	 * @return
	 */
	public Collection<InDetail> getByCondition(InQueryDetail inQueryDetail);
}
