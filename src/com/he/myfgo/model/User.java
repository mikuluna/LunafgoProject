package com.he.myfgo.model;

import com.he.myfgo.model.User;
/**
 * fgo���û���
 * 
 * @author luna
 * @version 1.0
 */
public class User {
	/** ��¼�˺� */
	private String id;
	/** ���� */
	private String password;
	/** ��ʵ���� */
	private String name;
	/** ���� */
	private int age;
	/** �Ա� */
	private String sex;
	/** �ֻ����� */
	private String phoNum;
	/** �ǳ� */
	private String nickName;

	/** ���� */
	private String email;

	/** Ǯ */
	private int money;

	public User() {
	}

	/** ��ֵ�õĹ��캯�� */
	public User(String id, String password, String name, int age, String sex, String phoNum, String nickName,
			String email, int money) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phoNum = phoNum;
		this.nickName = nickName;
		this.email = email;
		this.money = money;
	}
	/**��¼�õĹ��캯��*/
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	/** �����õĹ��캯�� */
	public User(String id, String name, int age, String sex, String nickName) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.nickName = nickName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + "," + password + ", " + name + "," + age + "," + sex + "," + phoNum + "," + nickName + "," + email
				+ "," + money;
	}

	/**
	 * ��дʵ������equals�����������ж�������������ȵ� ���ǹ涨����������id������һһ��Ӧ��֤��������������ȵ�
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;// ����if�ж�Ϊ����仰��ִ����ȷ
		if (password.equals(user.getPassword()) && id.equals(user.getId())) {
			return true;
		}
		return super.equals(obj);
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the phoNum
	 */
	public String getPhoNum() {
		return phoNum;
	}

	/**
	 * @param phoNum
	 *            the phoNum to set
	 */
	public void setPhoNum(String phoNum) {
		this.phoNum = phoNum;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
