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
 * �ļ�����������
 * 
 * @author luna
 * @version 1.0
 */
public class FileTool {
	/**
	 * ���ļ��м����û����� ��������װ�ɼ��ϲ�����
	 * 
	 * @return �������ʧ�ܾͷ���null
	 */
	public static List<User> loadUser() {
		List<User> userList = null;
		File userFile = new File("UserInfo.txt");
		if (userFile == null || !userFile.exists()) {
			return userList;
		}
		userList = new ArrayList<User>();
		// ����Ķ�ȡ�ļ�����
		try {
			FileReader fReader = new FileReader(userFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// �����ն�ȡ����һ��
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
				// �򼯺�������û�����
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
	 * ��������û����ϱ��浽�ı��ļ���
	 * 
	 * @param isAppend
	 *            �Ƿ���׷�ӵķ�ʽ�����ļ�
	 * @return
	 */
	public static boolean saveUser(List<User> userList, boolean isAppend) {
		boolean isSuccess = true;
		if (userList == null || userList.size() == 0)
			return false;
		// д�뵽�ļ��е��ַ�������
		StringBuffer strValue = new StringBuffer();
		for (User user : userList) {
			strValue.append(user.toString());
			strValue.append("\n");
		}
		try {
			File userFile = new File("UserInfo.txt");
			if (userFile == null || !userFile.exists()) {
				// ����ļ������ڣ�����һ���ļ�
				userFile.createNewFile();
			}
			// ��׷�ӵķ�ʽ��д���ļ�
			FileWriter fWriter = new FileWriter(userFile, isAppend);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			// ���ַ���д���ļ���ȥ
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
	 * ���ļ��м��ؿ�Ƭ���� ��������װ�ɼ��ϲ�����
	 * 
	 * @return �������ʧ�ܾͷ���null
	 */
	public static List<Card> loadCard(User user) {
		List<Card> cardList = null;
		File cardFile = new File("CardInfo.txt");
		if (cardFile == null || !cardFile.exists()) {
			return null;
		}

		cardList = new ArrayList<>();
		// �����ȡ�ļ�����
		try {
			FileReader fReader = new FileReader(cardFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// �����ն�����һ��
				String[] strCard = line.split(",");
				if (strCard.length == 0) {
					break;
				}
				if (user.getId().equals(strCard[0])) {
					for (int i = 1; i < strCard.length; i++) {
						Card card = new Card(Integer.parseInt(strCard[i].trim()));
						// card.setId(Integer.parseInt(strCard[i].trim()));
						// �򼯺�������û�����
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
	 * ������Ŀ�Ƭ���ϱ��浽�ı��ļ���
	 * 
	 * @param isAppend
	 *            �Ƿ���׷�ӵķ�ʽ�����ļ�
	 * @return �Ƿ񱣴�ɹ�
	 */
	public static boolean saveCard(List<Card> cardList, User user, boolean isAppend) {
		boolean isSuccess = true;
		if (cardList == null || cardList.size() == 0) {
			return false;
		}
		// д�뵽�ļ���ȥ���ַ�������
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
				// ����ļ������ڣ�����һ���µ��ļ�
				cardFile.createNewFile();
			}
			// ������׷�ӵķ�ʽ���Ļ�
			if (!isAppend) {
				strCard.append("\n");
				FileReader fReader = new FileReader(cardFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String line = null;
				while ((line = bReader.readLine()) != null) {
					// �����ն�����һ��
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

			// ��׷�ӵķ�ʽд���ļ�
			FileWriter fWriter = new FileWriter(cardFile, isAppend);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			// ���ַ���д���ļ���ȥ
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
	 * ��ǰ�û�û��cardʱ��ɾ������û�id
	 * 
	 * @param
	 * @return �Ƿ�ɹ�
	 */
	public static boolean deletCard(User user) {
		boolean isSuccess = true;
		// д�뵽�ļ���ȥ���ַ�������
		String[] strAllCard = null;
		StringBuffer strCard = new StringBuffer();
		try {
			File cardFile = new File("CardInfo.txt");
			if (cardFile == null || !cardFile.exists()) {
				// ����ļ������ڣ�����һ���µ��ļ�
				cardFile.createNewFile();
			}
			FileReader fReader = new FileReader(cardFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				// �����ն�����һ��
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

			// ��׷�ӵķ�ʽд���ļ�
			FileWriter fWriter = new FileWriter(cardFile);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			// ���ַ���д���ļ���ȥ
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
