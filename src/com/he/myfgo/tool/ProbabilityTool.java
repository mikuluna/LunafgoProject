package com.he.myfgo.tool;

import java.util.Random;

/**
 * ���ݸ�������cardId
 * 
 * @author luna
 * @version 1.0
 */
public class ProbabilityTool {
	/**
	 * �鿨�ձ����
	 */
	public static int cardId() {
		int num = 0;
		int randNum = new Random().nextInt(100) + 1;
		if (randNum == 1) {// 5�ǿ�������1%
			num = new Random().nextInt(6) + 11;
		} else if (randNum > 1 && randNum <= 11) {// ���ǿ�������10%
			num = new Random().nextInt(4) + 17;
		} else {// ���඼�����ǿ�
			num = new Random().nextInt(10) + 1;
		}
		return num;
	}

	/**
	 * ��������
	 */
	public static int cardSR() {
		int randNum = new Random().nextInt(4) + 17;
		return randNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
