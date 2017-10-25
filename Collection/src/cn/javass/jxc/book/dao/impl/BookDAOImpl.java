package cn.javass.jxc.book.dao.impl;

import java.util.Collection;
import java.util.List;

import cn.javass.framework.io.SerialUtil;
import cn.javass.jxc.book.dao.dao.BookDAO;
import cn.javass.jxc.book.vo.BookModel;
import cn.javass.jxc.book.vo.BookQueryModel;
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.factory.UuidDAOFactory;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.user.UuidEnum;


/**
 * �����л�/�����л��ķ�ʽ�������� ���к�/�����л����൱�ڿ��԰Ѷ���ŵ��ļ��У��Ѷ�����ļ��ж����� ����create
 * 
 * @author wushensi
 * 
 */

public class BookDAOImpl implements BookDAO {

	private final static String FILE_NAME = "Book.txt";

	@Override
	public boolean create(BookModel book) {
		// TODO Auto-generated method stub
		// 1������Ѿ��еĶ�������
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		System.out.println(book);
		System.out.println("book uuid---------"+book.getUuid());
		// 2���鿴��uuid�Ƿ��ظ�
		for (BookModel model : list) {
			if (model.getUuid().equals(book.getUuid())) {
				
				return false;
			}
		}

		// 2.1���ظ�������false
		// 2.2�����ظ�������ӵ�usermode��list������true
		list.add(book);

		// ���л�
		SerialUtil.writeToFile(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean update(BookModel book) {
		// TODO Auto-generated method stub
		// �޸�һ��uuid����������ڣ�����false
		// 1����ȡlist������list �ж�uuid�Ƿ����
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
			if (model.getUuid().equals(book.getUuid())) {
				// �޸�
				model.setName(book.getName());
				model.setInPrice(book.getInPrice());
				model.setSalePrice(book.getSalePrice());
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
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
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
	public BookModel getByUuid(String uuid) {
		// TODO Auto-generated method stub
		// 1����ѯ���е�list���ж�uuid�Ƿ����
		List<BookModel> list = SerialUtil.readFromFile(FILE_NAME);
		for (BookModel model : list) {
			if (model.getUuid().equals(uuid)) {
				return model;
			}
		}
		// 1.1�����򷵻�object
		// 1.2������ �Ż�null
		return null;
	}

	@Override
	public Collection<BookModel> getByAll() {
		// TODO Auto-generated method stub
		return SerialUtil.readFromFile(FILE_NAME);
	}

	@Override
	public Collection<BookModel> getByCondition(BookQueryModel book) {
		// TODO Auto-generated method stub
		// 1��ѭ�����ж���
		
		// 2���ѷ���������model����list
		
			// ���߼�
			
			// ������
			// �����
		// 3������list
		return null;
	}

	public static void main(String[] args) {
		BookDAO dao = new BookDAOImpl();
		// UserModel user=new UserModel();
		BookModel book=new BookModel();
		UuidModel uuid=new UuidModel();
		//ʹ����ɢֵenumö�٣���һ���� ֻ�޶������ض�������ʵ��������ʵ��uuid�Զ�����
		uuid.setModelName(UuidEnum.BOOK_UUID.toString());
		UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
		book.setUuid(uuidDao.getNextNum(uuid.getModelName()));
		book.setName("Thinking in java");
		book.setInPrice(110.01);
		book.setSalePrice(213.2);
		//System.out.println(dao.create(book));
		System.out.println(dao.getByAll());
		
		//System.out.println("------"+userdao.getByCondition(query));
		
	
	}

}
