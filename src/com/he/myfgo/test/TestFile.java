package com.he.myfgo.test;

import java.util.ArrayList;
import java.util.List;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;
/**����User��test*/
public class TestFile {

	public static void main(String[] args) {
//		List<Card> cardList =  new ArrayList<Card>();
//		User user1 = new User("1332","����1",14,"��","fdsf");
//		User user2 = new User("13213432","����2",14,"��","fdsf");
//		User user3 = new User("132232","����3",14,"��","fdsf");
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
