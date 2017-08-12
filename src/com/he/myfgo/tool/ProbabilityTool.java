package com.he.myfgo.tool;

import java.util.Random;

/**
 * 根据概率生成cardId
 * 
 * @author luna
 * @version 1.0
 */
public class ProbabilityTool {
	/**
	 * 抽卡普遍概率
	 */
	public static int cardId() {
		int num = 0;
		int randNum = new Random().nextInt(100) + 1;
		if (randNum == 1) {// 5星卡概率是1%
			num = new Random().nextInt(6) + 11;
		} else if (randNum > 1 && randNum <= 11) {// 四星卡概率是10%
			num = new Random().nextInt(4) + 17;
		} else {// 其余都是三星卡
			num = new Random().nextInt(10) + 1;
		}
		return num;
	}

	/**
	 * 保底四星
	 */
	public static int cardSR() {
		int randNum = new Random().nextInt(4) + 17;
		return randNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
