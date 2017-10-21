package cn.javass.c15.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
/**
 * 
 * @author wushensi
 *
 */
public class valueTransfer {
	@java.lang.SuppressWarnings(value={"uncheck"})
	public static Object getModelObjectByMap(Map map,Class clz){
		Object object=null;
		try {
			//1���ֽ��ಢ��������������
			object=clz.newInstance();
			Field[] fields=clz.getDeclaredFields();
			String methodName="";
			for(Field field:fields){
				//2��ͨ���������ƣ���ѯmap�еĶ�Ӧkey ���õ�value
				Object obj=map.get(field.getName());
				methodName="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
				Class[] parameter=new Class[1];
				parameter[0]=field.getType();
				//3���ֽ�õ���ķ������Ʋ���̬����setter����
				Method method=clz.getDeclaredMethod(methodName, parameter);
				method.invoke(object, obj);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		//4�����ظ��º��object
		return object;
	}
}
