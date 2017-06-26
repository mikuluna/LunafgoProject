package com.he.myfgo.test;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;
import com.he.myfgo.tool.ProbabilityTool;

/**
 * fgo的单抽主页面
 * 
 * @author 曹诗晴
 *
 */
public class TestGetTenCard extends JFrame{
	/** 抽卡图片10张 */
	private JButton [] btnImages = new JButton[10] ;
	/** 返回上一级按钮 */
	private JButton btnBack = new JButton("返回上一级");
	/** 拿到上个界面的id */
	private String loginId = "test";// 这里先初始10000号用户，这样方便验证
	/** user数据 */
	private User user = new User();
	/** 根据概率生成的cardId */
	private int i = ProbabilityTool.cardId();

	private TestGetTenCard me = this;
	private Card card;
	/**
	 * 不带
	 * */
	public TestGetTenCard() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("单抽主页面");
		initComponents();
		setSize(560, 300);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * 构造函数重载 为了在new的时候就把id传进来 实际操作用
	 */
	public TestGetTenCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("抽卡主页面");
		setLoginId(id);
		initComponents();
		setSize(560, 300);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}
	/**
	 * 主体界面
	 * */
	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);
		
		btnBack.setBounds(410, 245, 120, 40);
		btnBack.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setOpaque(false);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
		
		
		List<Card> cardListadd = new ArrayList<Card>();
		for(int n=0;n<10;n++){
			i = ProbabilityTool.cardId();
			Card card = new Card(i);
			cardListadd.add(card);
		}		
		
		for (int i = 0; i < cardListadd.size(); i++) {
			btnImages[i] = new JButton(new ImageIcon(cardListadd.get(i).getImageId()));
			if (i == 0) {
				btnImages[i].setBounds(40, 40, 50, 85);

			} else if (i % 5 != 0) {
				btnImages[i].setBounds(btnImages[i - 1].getX() + btnImages[i - 1].getWidth() + 50, btnImages[i - 1].getY(),
						btnImages[i - 1].getWidth(), btnImages[i - 1].getHeight());
			} else {
				btnImages[i].setBounds(btnImages[i - 5].getX(), btnImages[i - 5].getY() + btnImages[i - 1].getWidth() + 50,
						btnImages[i - 5].getWidth(), btnImages[i - 5].getHeight());
			}
			
			contentPane.add(btnImages[i]);
			btnImages[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			
		}
		
		
		
		btnBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
					
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
		ImageIcon background = new ImageIcon("images/gettencardbackground.jpg");
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
		new TestGetTenCard();

	}

}
