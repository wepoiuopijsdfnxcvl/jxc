/*1�����һ�������ʻ��࣬���л������ʺţ����� ���ԣ��Լ���ȡ��ȷ��������Դ�
����в���*/
package cn.javass.c6.work;

import java.util.Scanner;

public class Zy01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.initAccount(account);
		System.out.println(account);
		//account.withdraw(account);
		//account.deposit(account);
	}

}
class Account{
	private String accountId;
	private String name;
	private double balance;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(Account account){
		Scanner scan=new Scanner(System.in);
		System.out.println("������ȡ����/t");
		double cash=scan.nextDouble();
		account.setBalance(account.getBalance()-cash);
		System.out.println("����ȡ��"+cash+" ���˻����ʣ��"+account.getBalance());
		System.out.println(account);
	}
	
	public void deposit(Account account){
		Scanner scan=new Scanner(System.in);
		System.out.println("����������/t");
		double cash=scan.nextDouble();
		account.setBalance(account.getBalance()+cash);
		System.out.println("���δ��"+cash+" ���˻����ʣ��"+account.getBalance());
		System.out.println(account);
	}
	
	public void initAccount(Account account){
		account.setAccountId("1");
		account.setName("user");
		account.setBalance(123.321);
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name
				+ ", balance=" + balance + "]";
	}
}
