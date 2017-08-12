package com.he.myfgo.tool;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;

/**
 * 文件操作工具类
 * 
 * @author luna
 * @version 1.0
 */
public class FileTool {
	/**
	 * 从文件中加载用户数据 将数据组装成集合并返回
	 * 
	 * @return 如果加载失败就返回null
	 */
	public static List<User> loadUser() {
		List<User> userList = null;
		File userFile = new File("UserInfo.txt");
		if (userFile == null || !userFile.exists()) {
			return userList;
		}
		userList = new ArrayList<User>();
		// 常规的读取文件代码
		try {
			FileReader fReader = new FileReader(userFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// 操作刚读取的这一行
				String[] strUser = line.split(",");
				if (strUser.length == 0) {
					break;
				}
				User user = new User();
				user.setId(strUser[0].trim());
				user.setPassword(strUser[1].trim());
				user.setName(strUser[2].trim());
				user.setAge(Integer.parseInt(strUser[3].trim()));
				user.setSex(strUser[4].trim());
				user.setPhoNum(strUser[5].trim());
				user.setNickName(strUser[6].trim());
				user.setEmail(strUser[7].trim());
				user.setMoney(Integer.parseInt(strUser[8].trim()));
				// 向集合中添加用户对象
				userList.add(user);
			}
			bReader.close();
			fReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 将传入的用户集合保存到文本文件中
	 * 
	 * @param isAppend
	 *            是否以追加的方式保存文件
	 * @return
	 */
	public static boolean saveUser(List<User> userList, boolean isAppend) {
		boolean isSuccess = true;
		if (userList == null || userList.size() == 0)
			return false;
		// 写入到文件中的字符串对象
		StringBuffer strValue = new StringBuffer();
		for (User user : userList) {
			strValue.append(user.toString());
			strValue.append("\n");
		}
		try {
			File userFile = new File("UserInfo.txt");
			if (userFile == null || !userFile.exists()) {
				// 如果文件不存在，创造一个文件
				userFile.createNewFile();
			}
			// 已追加的方式，写入文件
			FileWriter fWriter = new FileWriter(userFile, isAppend);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			// 将字符串写到文件中去
			bWriter.write(strValue.toString());
			bWriter.flush();
			bWriter.close();
			fWriter.close();
			isSuccess = true;

		} catch (IOException e) {
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}

	/**
	 * 从文件中加载卡片数据 将数据组装成集合并返回
	 * 
	 * @return 如果加载失败就返回null
	 */
	public static List<Card> loadCard(User user) {
		List<Card> cardList = null;
		File cardFile = new File("CardInfo.txt");
		if (cardFile == null || !cardFile.exists()) {
			return null;
		}

		cardList = new ArrayList<>();
		// 常规读取文件代码
		try {
			FileReader fReader = new FileReader(cardFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// 操作刚读的这一行
				String[] strCard = line.split(",");
				if (strCard.length == 0) {
					break;
				}
				if (user.getId().equals(strCard[0])) {
					for (int i = 1; i < strCard.length; i++) {
						Card card = new Card(Integer.parseInt(strCard[i].trim()));
						// card.setId(Integer.parseInt(strCard[i].trim()));
						// 向集合中添加用户对象
						cardList.add(card);
					}
				}
			}
			bReader.close();
			fReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cardList;
	}

	/**
	 * 将传入的卡片集合保存到文本文件中
	 * 
	 * @param isAppend
	 *            是否以追加的方式保存文件
	 * @return 是否保存成功
	 */
	public static boolean saveCard(List<Card> cardList, User user, boolean isAppend) {
		boolean isSuccess = true;
		if (cardList == null || cardList.size() == 0) {
			return false;
		}
		// 写入到文件中去的字符串对象
		String[] strAllCard = null;
		StringBuffer strCard = new StringBuffer();
		strCard.append(user.getId() + ",");
		for (int i = 0; i < cardList.size(); i++) {
			Card card = (Card) cardList.get(i);
			if (i == cardList.size() - 1) {
				strCard.append(card.getId());
			} else {
				strCard.append(card.getId());
				strCard.append(",");
			}
		}
		try {
			File cardFile = new File("CardInfo.txt");
			if (cardFile == null || !cardFile.exists()) {
				// 如果文件不存在，创建一个新的文件
				cardFile.createNewFile();
			}
			// 当不以追加的方式来的话
			if (!isAppend) {
				strCard.append("\n");
				FileReader fReader = new FileReader(cardFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String line = null;
				while ((line = bReader.readLine()) != null) {
					// 操作刚读的这一行
					strAllCard = line.split(",");
					if (strAllCard.length == 0) {
						break;
					}
					if (user.getId().equals(strAllCard[0])) {
					} else {
						for (int n = 0; n < strAllCard.length; n++) {
							String str = strAllCard[n];
							if (n == strAllCard.length - 1) {
								strCard.append(str);
							} else {
								strCard.append(str);
								strCard.append(",");
							}
						}
						strCard.append("\n");
					}
				}

				fReader.close();
				bReader.close();
			}

			// 以追加的方式写入文件
			FileWriter fWriter = new FileWriter(cardFile, isAppend);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			// 将字符串写到文件中去
			bWriter.write(strCard.toString());
			bWriter.flush();
			bWriter.close();
			fWriter.close();

			isSuccess = true;

		} catch (IOException e) {
			e.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}

	/**
	 * 当前用户没有card时，删除这个用户id
	 * 
	 * @param
	 * @return 是否成功
	 */
	public static boolean deletCard(User user) {
		boolean isSuccess = true;
		// 写入到文件中去的字符串对象
		String[] strAllCard = null;
		StringBuffer strCard = new StringBuffer();
		try {
			File cardFile = new File("CardInfo.txt");
			if (cardFile == null || !cardFile.exists()) {
				// 如果文件不存在，创建一个新的文件
				cardFile.createNewFile();
			}
			FileReader fReader = new FileReader(cardFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// 操作刚读的这一行
				strAllCard = line.split(",");
				if (!user.getId().equals(strAllCard[0])) {
					for (int n = 0; n < strAllCard.length; n++) {
						String str = strAllCard[n];
						if (n == strAllCard.length - 1) {
							strCard.append(str);
						} else {
							strCard.append(str);
							strCard.append(",");
						}
					}
					strCard.append("\n");
				}
			}
			fReader.close();
			bReader.close();

			// 以追加的方式写入文件
			FileWriter fWriter = new FileWriter(cardFile);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			// 将字符串写到文件中去
			bWriter.write(strCard.toString());
			bWriter.flush();
			bWriter.close();
			fWriter.close();

			isSuccess = true;

		} catch (IOException e) {
			e.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}

}
