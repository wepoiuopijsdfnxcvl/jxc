package cn.javass.designPattern.constructure.Flyweight;

public class ConcreteChessFlyWeight implements ChessFlyWeight{

	private String color;
	
	public ConcreteChessFlyWeight(String color){
		this.color=color;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(Coordinate c) {
		// TODO Auto-generated method stub
		System.out.println("���ӵ���ɫ��"+color);
		System.out.println("���ӵĺ�����λ�ã�"+c.getX()+"���ӵ�������λ�ã�"+c.getY());
	}

	@Override
	public String toString() {
		return "ConcreteChessFlyWeight [color=" + color + "]";
	}

	

}
