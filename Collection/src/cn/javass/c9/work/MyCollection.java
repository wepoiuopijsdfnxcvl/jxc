/*1������һ���࣬��������һ������ col,�����Ǽ������� Collection��ʵ�����з���������
�� col ����������ݡ��޸����ݡ���ѯ���ݡ�ɾ�����ݡ�Ҳ���ǰ���� col ����һ�����ݴ�
��������������ʵ�����ݵ���ɾ�Ĳ�ķ�����*/
package cn.javass.c9.work;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollection {
	private Object[] objs=new Object[0];
	public boolean add(Object object){
		for(Object obj:objs){
			if(object.equals(obj)){
				return false;
			}
			Object[] tempObjs=new Object[objs.length+1];
			System.arraycopy(objs, 0, tempObjs, 0, objs.length);
			tempObjs[objs.length]=object;
			objs=tempObjs;
		}
		return true;
	}
	
	public void edit(String id){
		MyCollection mycollection=new MyCollection();
	}
	
	public Object query(){
		return null;
	}
	
	public Collection getAll(){
		Collection col=null;
		for(int i=0;i<objs.length;i++){
			col.add(objs[i]);
		}
		return col;
	}
	
	public MyCollection remove(Object object){
		MyCollection mycollection=new MyCollection();
		for(int i=0;i<objs.length;i++){
			if(object.equals(objs[i])){
				continue;
			}{
				mycollection.add(objs[i]);
			}
		}
		return mycollection;
	}
	/*
	0 1 2 3 4 5
	0 1 2 3*/
	
}
