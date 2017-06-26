package com.he.myfgo.test;

import java.util.ArrayList;
import java.util.List;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;
/**存入User的test*/
public class TestFile {

	public static void main(String[] args) {
//		List<Card> cardList =  new ArrayList<Card>();
//		User user1 = new User("1332","海盗1",14,"男","fdsf");
//		User user2 = new User("13213432","海盗2",14,"男","fdsf");
//		User user3 = new User("132232","海盗3",14,"男","fdsf");
//		List<User> userList = new ArrayList<User>();
//		userList.add(user1);
//		userList.add(user2);
//		userList.add(user3);
//		FileTool.saveUser(userList,false);
		List<User> userList1=new ArrayList<User>();
		userList1= FileTool.loadUser();
		for(User user :userList1){
			System.out.println(user.toString());
		}
	}

}
