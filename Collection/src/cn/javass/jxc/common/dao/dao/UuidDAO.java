package cn.javass.jxc.common.dao.dao;

/**
 * ����modelName
 * ������Ӧ���Ǹ���ɢֵ����ֻ�м���ȡֵ���ܣ������String��Ϊ�����������Ա�ɷ�Χֵ�ˡ�
 * 
 * ĳһ����Ķ���ֻ����ô����ȡֵ�������ܸ����ˡ�Enumeration�ṩ�������
 * 
 * ʹ��Enum������ȡֵ�����ɢȡֵ
 * 
 * @author wushensi
 *
 */
public interface UuidDAO {
	public int getNextNum(String modelName);
}
