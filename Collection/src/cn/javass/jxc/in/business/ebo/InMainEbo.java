package cn.javass.jxc.in.business.ebo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.in.business.ebi.InDetailEbi;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InDetailEbiFactory;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.dao.dao.InMainDAO;
import cn.javass.jxc.in.dao.factory.InMainDAOFactory;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryMain;

public class InMainEbo implements InMainEbi{

	private InMainDAO dao=InMainDAOFactory.getInMainDAO();
	private List<InMain> mainList;
	private List<InDetail> detailList;
	
	public InMainEbo(){
		
	}
	
	public InMainEbo(List<InMain> mainList,List<InDetail> detailList){
		this.mainList=mainList;
		this.detailList=detailList;
	}
	
	@Override
	public boolean create(InMain inMain) {
		// TODO Auto-generated method stub
		return dao.create(inMain);
	}

	@Override
	public boolean update(InMain inMain) {
		// TODO Auto-generated method stub
		return dao.update(inMain);
	}

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		return dao.delete(uuid);
	}

	@Override
	public InMain getByUuid(String uuid) {
		// TODO Auto-generated method stub
		return dao.getByUuid(uuid);
	}

	@Override
	public Collection<InMain> getByAll() {
		// TODO Auto-generated method stub
		return dao.getByAll();
	}

	@Override
	public Collection<InMain> getByCondition(InQueryMain inQueryMain) {
		// TODO Auto-generated method stub
		return dao.getByCondition(inQueryMain);
	}

	@Override
	public boolean create(InMain inMain, List<InDetail> list) {
		// TODO Auto-generated method stub
				// 1������Ѿ��еĶ�������
				List<InMain> inMainList = (List<InMain>) InMainEbiFactory.getInMainEbi().getByAll();//SerialUtil.readFromFile("InMain.txt");
				List<InDetail> inDetailList=(List<InDetail>) InDetailEbiFactory.getInDetailEbi().getByAll();//SerialUtil.readFromFile("InDetail.txt");
				List<InDetail> result=inDetailList;
				boolean flag=false;
				// 2���鿴��uuid�Ƿ��ظ�
				System.out.println(inMainList);
				for (InMain model : inMainList) {
					if (model.getId().equals(inMain.getId())) {
						return false;
					}
				}
				//list�����Ƚϳ־û��ļ��ж�ȡ�ļ����Ƿ����ظ���inDetail id 
				for(InDetail outter:list){
					for(InDetail inner:inDetailList){
						if(inner.getId().equals(outter.getId())){
							flag=true;
						}
					}
					/**
					 * ��id�ظ��򲻳־û����ļ�
					 */
					if(flag){
						continue;
					}else{
						result.add(outter);
					}
				}
				// 2.1���ظ�������false
				// 2.2�����ظ�������ӵ�usermode��list������true
				inMainList.add(inMain);
				// ���л�
				SerialUtil.writeToFile(inMainList, "InMain.txt");
				SerialUtil.writeToFile(result, "InDetail.txt");
				System.out.println("result---"+result);
				return true;	
	}
	
	@Override
	public Map<InMain,List<InDetail>> getByMapAll(){
		Map<InMain,List<InDetail>> map=new HashMap<InMain,List<InDetail>>();
		List<InDetail> list;
		InMainEbi mainEbi=InMainEbiFactory.getInMainEbi();
		InDetailEbi detailEbi=InDetailEbiFactory.getInDetailEbi();
		
		if(this.mainList==null){
			mainList=(List<InMain>) mainEbi.getByAll();
		}
		if(this.detailList==null){
			detailList=(List<InDetail>) detailEbi.getByAll();
		}
		
		for(InMain main:mainList){
			list=new ArrayList<InDetail>();
			for(InDetail detail:detailList){
				if(main.getInUserId().equals(detail.getInId())&&main.getId().equals(detail.getMainId())){
					list.add(detail);
				}
			}
			map.put(main, list);
		}
		return map;
	}
	
	
	@Override
	public boolean UpdateMainDetail(InMain inMain,Map<InMain,InDetail> updateMap){
		
		InMain key=new InMain();
		InDetail value=new InDetail();
		
		Map<InMain,List<InDetail>> map=new HashMap<InMain,List<InDetail>>();
		map=InMainEbiFactory.getInMainEbi().getByMapAll();
		
		for(InMain obj:updateMap.keySet()){
			key=obj;
			value=updateMap.get(obj);
		}
		
		List<InDetail> dataList=new ArrayList<InDetail>();
		
		System.out.println("key---"+key);
		System.out.println("value---"+value);
		
		for(InDetail obj:map.get(key)){
			if(obj.getId().equals(value.getId())){
				dataList.add(value);
			}else{
				dataList.add(obj);
			}
		}
		
		map.put(key, dataList);
		
		List<InMain> list1=new ArrayList<InMain>();
		List<InDetail> list2=new ArrayList<InDetail>();
		for(InMain mainObj:map.keySet()){
			for(InDetail detailObj:map.get(mainObj)){
				list2.add(detailObj);
			}
			list1.add(mainObj);
		}
	
		InMainEbi mainEbi=InMainEbiFactory.getInMainEbi();
		InDetailEbi detailEbi=InDetailEbiFactory.getInDetailEbi();
		
		//���map
		for(InMain main:map.keySet()){
			for(InDetail detail:map.get(main)){
				detailEbi.delete(detail.getId());
			}
			mainEbi.delete(main.getId());
		}
		//���� map
		for(InMain main:map.keySet()){
			for(InDetail detail:map.get(main)){
				detailEbi.create(detail);
			}
			mainEbi.create(main);
		}
		
		//�ȸ���main
		
		
		
		//���ýӿ�
		
		
		//ֻ�޸�mainʱ��
		
		
		
		
		
		
		
		return false;
	}

}
