package cn.javass.jxc.common.vo;

import java.io.Serializable;

/**
 * ��������������Ϊ������uuid��������û��uuid����ֶ�
 * ��¼�Ľ�ʦ��һ��ֱ�ӷ��صģ�����Ѿ���3��UserModel���൱�ڼ�¼4
 * @author wushensi
 * 
 *
 */
public class UuidModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelName;
	private int currentNum;
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UuidModel other = (UuidModel) obj;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}
	
	
}
