package com.he.myfgo.test;

import java.util.ArrayList;
import java.util.List;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;

/**����card��test*/
public class TestCard {

	public static void main(String[] args) {
		User user1 = new User("1332","����1",14,"��","fdsf");
		User user2 = new User("13dfef32","����2",14,"��","fdsf");
//		List<Card> cardList =  new ArrayList<Card>();
//		cardList.add(new Card(2));
//		cardList.add(new Card(1));
//		cardList.add(new Card(3));
//		cardList.add(new Card(4));
//		cardList.add(new Card(1));
//		cardList.add(new Card(1));
//		cardList.add(new Card(1));
//		FileTool.saveCard(cardList,user1,false);
//		FileTool.saveCard(cardList,user2,true);
		
		List<Card> cardList =  new ArrayList<Card>();
		cardList=FileTool.loadCard(user2);
		for(Card card:cardList){
			System.out.print(card.getId()+",");
		}
	}

}
