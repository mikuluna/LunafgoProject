package com.he.myfgo.model;
/**
 * fgo�Ŀ�Ƭ��
 * 
 * @author luna
 * @version 1.0
 * */
public class Card implements Comparable<Card>{
	/** ��Ƭid */
	private int id;
	/** ��Ƭ·�� */
	private String imageId;
	/** ��Ƭ��� */
	private int money;
	
	public Card(int id,String imageId) {
		super();
		this.id = id;
		this.imageId = imageId;
	}
	public Card(int id) {
		this.id = id;
		setAll(id);
		
	}
	public Card(){}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		
		this.money = money;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * @param imageId
	 *            the imageId to set
	 */
	public void setImageId(String imageId) {
		
		this.imageId = imageId;
	}
	/**
	 * ����id��imageid��money
	 * */
	public void setAll(int id){
		switch(id){
		case 1:
			imageId="min/min1.jpg";
			money=2;
			break;
		case 2:
			imageId="min/min2.jpg";
			money=2;
			break;
		case 3:
			imageId="min/min3.jpg";
			money=2;
			break;
		case 4:
			imageId="min/min4.jpg";
			money=2;
			break;
		case 5:
			imageId="min/min5.jpg";
			money=2;
			break;
		case 6:
			imageId="min/min6.jpg";
			money=2;
			break;
		case 7:
			imageId="min/min7.jpg";
			money=2;
			break;		
		case 8:
			imageId="min/min8.jpg";
			money=2;
			break;
		case 9:
			imageId="min/min9.jpg";
			money=2;
			break;		
		case 10:
			imageId="min/min10.jpg";
			money=2;
			break;		
		case 11:
			imageId="min/min11.jpg";
			money=100;
			break;		
		case 12:
			imageId="min/min12.jpg";
			money=100;
			break;		
		case 13:
			imageId="min/min13.jpg";
			money=100;
			break;		
		case 14:
			imageId="min/min14.jpg";
			money=100;
			break;		
		case 15:
			imageId="min/min15.jpg";
			money=100;
			break;		
		case 16:
			imageId="min/min16.jpg";
			money=100;
			break;		
		case 17:
			imageId="min/min17.jpg";
			money=20;
			break;		
		case 18:
			imageId="min/min18.jpg";
			money=20;
			break;		
		case 19:
			imageId="min/min19.jpg";
			money=20;
			break;		
		case 20:
			imageId="min/min20.jpg";
			money=20;
			break;		
		
		}
	}
	/**
	 * ��дcompareTo������������
	 * */
	@Override
	 public int compareTo(Card o) {  
	        int i = this.getMoney() - o.getMoney();//�Ȱ��ռ۸�����
	        if(i==0){
	        	i = this.getId()-o.getId();//����۸���ȾͰ���id˳������
	        }
	        return i; 
	    }  
	        
}
