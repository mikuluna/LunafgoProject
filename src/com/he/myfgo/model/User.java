package com.he.myfgo.model;

import com.he.myfgo.model.User;
/**
 * fgo的用户类
 * 
 * @author luna
 * @version 1.0
 */
public class User {
	/** 登录账号 */
	private String id;
	/** 密码 */
	private String password;
	/** 真实姓名 */
	private String name;
	/** 年龄 */
	private int age;
	/** 性别 */
	private String sex;
	/** 手机号码 */
	private String phoNum;
	/** 昵称 */
	private String nickName;

	/** 邮箱 */
	private String email;

	/** 钱 */
	private int money;

	public User() {
	}

	/** 赋值用的构造函数 */
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
	/**登录用的构造函数*/
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	/** 测试用的构造函数 */
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
	 * 重写实体对象的equals方法，方便判断两个对象是相等的 我们规定：两个对象id和密码一一对应，证明两个对象是相等的
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;// 上面if判断为了这句话的执行正确
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
