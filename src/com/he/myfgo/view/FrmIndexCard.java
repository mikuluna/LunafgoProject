package com.he.myfgo.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;

/**
 * fgo查看贩卖卡片界面
 * 
 * @author luna
 * @version 1.0
 */
public class FrmIndexCard extends JFrame {
	/** 拿到上个界面的id */
	private String loginId = "test";// 这里先初始10000号用户，这样方便验证
	/** user数据 */
	private User user = new User();
	/** 朕 */
	private FrmIndexCard me = this;
	/** 滑动滚轮 */
	private JScrollPane scrollPane = new JScrollPane();// 没有加成功
	/** 用户卡片集合 */
	private List<Card> cardList = new ArrayList<Card>();

	/** 卡片按钮集合 */
	private JButton[] btnCard = null;
	/** 返回上一级按钮 */
	private JButton btnBack = new JButton("返回上一级");
	/** 排序按钮 */
	private JButton btnSort = new JButton("排序");

	private JButton btnSellAll = new JButton("一键贩卖");

	private int n = 0;

	public FrmIndexCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("查看/贩卖卡片");
		initComponents();
		setSize(580, 600);
		setCenter();
		// setUndecorated(true);
		setVisible(true);
	}

	/**
	 * 构造函数重载 为了在new的时候就把id传进来 实际操作用
	 */
	public FrmIndexCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("查看/贩卖卡片");
		setLoginId(id);
		initComponents();
		setSize(580, 600);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);

		cardList = FileTool.loadCard(user);
		setCardImage(contentPane, cardList);
		// 返回按钮
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmMasterFace frmMasterFace = new FrmMasterFace(user.getId());
				setVisible(false);
			}
		});		
		btnSellAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int money = 0;
				for(int i=0;i<cardList.size();i++){
					money=money+cardList.get(i).getMoney();
				}				
				int result = JOptionPane.showConfirmDialog(null,
						new String("贩卖获得" +money+ "点"), "贩卖卡片",
						JOptionPane.YES_NO_OPTION);
				if(result==0){
					user.setMoney(user.getMoney() +money);
					cardList.removeAll(cardList);
					FileTool.deletCard(user);
					// 将user的价格存入里面
					List<User> userList = new ArrayList<User>();
					userList = FileTool.loadUser();
					for (int i = 0; i < userList.size(); i++) {
						User searchUser = (User) userList.get(i);
						if (searchUser.equals(user)) {
							userList.remove(i);
							userList.add(i, user);
						}
					}
					FileTool.saveUser(userList, false);
					setCardImage(contentPane, cardList);
				}				
				
			}
		});

	}

	private void deleImage(JPanel pane) {
		for (n = 0; n < cardList.size(); n++) {
			int choice = n;
			btnCard[n].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// int result=JOptionPane.showConfirmDialog(null,"贩卖获得20点");
					int result = JOptionPane.showConfirmDialog(null,
							new String("贩卖获得" + (cardList.get(choice).getMoney()) + "点"), "贩卖卡片",
							JOptionPane.YES_NO_OPTION);

					// 再写入文件
					if (result == 0) {
						user.setMoney(user.getMoney() + cardList.get(choice).getMoney());
						cardList.remove(choice);
						// 将删除的卡片存入txt文件当中
						if (cardList.isEmpty()) {
							FileTool.deletCard(user);
						} else {
							FileTool.saveCard(cardList, user, false);
						}
						// 将user的价格存入里面
						List<User> userList = new ArrayList<User>();
						userList = FileTool.loadUser();
						for (int i = 0; i < userList.size(); i++) {
							User searchUser = (User) userList.get(i);
							if (searchUser.equals(user)) {
								userList.remove(i);
								userList.add(i, user);
							}
						}
						FileTool.saveUser(userList, false);
						setCardImage(pane, cardList);
					}
				}
			});
		}
	}

	/**
	 * 在左边容器中显示右边数组中的对象内容 容器要求是无布局
	 * 
	 * @param pane
	 * @param userList
	 * 
	 */
	private void setCardImage(JPanel pane, List<Card> cardList) {
		if (btnCard != null && btnCard.length != 0) {
			for (int i = 0; i < btnCard.length; i++) {
				btnCard[i].setVisible(false);
				btnCard[i] = null;
			}
		}
		// 根据图片集合显示对应的图片
		btnCard = new JButton[cardList.size()];
		int i = 0;
		for (i = 0; i < cardList.size(); i++) {
			btnCard[i] = new JButton(new ImageIcon(cardList.get(i).getImageId()));
			if (i == 0) {
				btnCard[i].setBounds(40, 40, 50, 85);

			} else if (i % 5 != 0) {
				btnCard[i].setBounds(btnCard[i - 1].getX() + btnCard[i - 1].getWidth() + 50, btnCard[i - 1].getY(),
						btnCard[i - 1].getWidth(), btnCard[i - 1].getHeight());
			} else {
				btnCard[i].setBounds(btnCard[i - 5].getX(), btnCard[i - 5].getY() + btnCard[i - 1].getWidth() + 50,
						btnCard[i - 5].getWidth(), btnCard[i - 5].getHeight());
			}
			pane.add(btnCard[i]);
		}
		if (cardList.size() - 1 >= 0) {
			btnSort.setBounds(200, btnCard[cardList.size() - 1].getY() + btnCard[cardList.size() - 1].getHeight() + 20,
					120, 40);
			btnBack.setBounds(390, btnCard[cardList.size() - 1].getY() + btnCard[cardList.size() - 1].getHeight() + 20,
					120, 40);
			btnSellAll.setBounds(20,
					btnCard[cardList.size() - 1].getY() + btnCard[cardList.size() - 1].getHeight() + 20, 120, 40);
		} else {
			btnSort.setBounds(200, 30, 120, 40);
			btnBack.setBounds(390, 30, 120, 40);
			btnSellAll.setBounds(20, 30, 120, 40);
		}
		btnBack.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setOpaque(false);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnSort.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnSort.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSort.setOpaque(false);
		btnSort.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnSellAll.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnSellAll.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSellAll.setOpaque(false);
		btnSellAll.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pane.add(btnBack);
		pane.add(btnSort);
		pane.add(btnSellAll);

		update(getGraphics());
		deleImage(pane);
		// 排序按钮
		btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(cardList);
				setCardImage(pane, cardList);
			}

		});

		

	}

	/** 界面居中 */
	public void setCenter() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// 获得当前屏幕的分辨率
		Dimension screenSize = toolkit.getScreenSize();
		// 当前面板的宽和高
		Dimension currSize = getSize();
		setLocation((int) ((screenSize.getWidth() - currSize.getWidth()) / 2),
				(int) ((screenSize.getHeight() - currSize.getWidth()) / 2));
	}

	/** 设置背景图片 */
	private void setBackground() {
		ImageIcon background = new ImageIcon("images/indexcarbackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// 在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 将内容面板设定为透明
		((JPanel) getContentPane()).setOpaque(false);
	}

	/**
	 * 根据id返回这个user
	 */
	private User getUser(String id) {
		User user1 = new User();
		List<User> userList = new ArrayList<User>();
		userList = FileTool.loadUser();
		for (User searchUser : userList) {
			if (id.equals(searchUser.getId())) {
				user1 = searchUser;
				break;
			}
		}
		return user1;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public static void main(String[] args) {
		new FrmIndexCard();

	}

}
