package com.he.myfgo.view;

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
import com.he.myfgo.test.TestOneCardInfo;
import com.he.myfgo.tool.FileTool;
import com.he.myfgo.tool.ProbabilityTool;

/**
 * 单抽界面
 * @author luna
 * @version 1.0
 */
public class FrmGetOneCard extends JFrame {
	/** 抽卡图片 */
	private JButton btnImage = null;
	/** 返回上一级按钮 */
	private JButton btnBack = new JButton("返回上一级");
	/** 拿到上个界面的id */
	private String loginId = "10000";// 这里先初始10000号用户，这样方便验证
	/** user数据 */
	private User user = new User();
	/** 根据概率生成的cardId */
	private int i = ProbabilityTool.cardId();

	private FrmGetOneCard me = this;
	private Card card;

	public FrmGetOneCard() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("单抽主页面");
		initComponents();
		setSize(200, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * 构造函数重载 为了在new的时候就把id传进来 实际操作用
	 */
	public FrmGetOneCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("抽卡主页面");
		setLoginId(id);
		initComponents();
		setSize(200, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);

		btnImage = new JButton(new ImageIcon("images/" + i + ".jpg"));
		
		btnImage.setBounds(50, 60, 100, 170);
		
		btnBack.setBounds(38, 260, 120, 40);
		btnBack.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setOpaque(false);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		contentPane.add(btnImage);
		contentPane.add(btnBack);

		// 将抽入的卡片存入txt文件当中
		List<Card> cardList = null;
		cardList = FileTool.loadCard(user);
		if (cardList == null) {
			cardList = new ArrayList<Card>();
			cardList.add(new Card(i));
			FileTool.saveCard(cardList, user, true);
		} else {
			cardList = FileTool.loadCard(user);
			cardList.add(new Card(i));
			FileTool.saveCard(cardList, user, false);
		}
		// 将user的价格存入里面
		user.setMoney(user.getMoney() - 10);
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
		
		
		btnImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmCardInfo frmCardInfo = new FrmCardInfo(i);
				
			}
		});
		
		
		btnBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmGetCardMain frmGetCardMain = new FrmGetCardMain(user.getId());
				setVisible(false);
				
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
		ImageIcon background = new ImageIcon("images/getonecardbackground.jpg");
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
		new FrmGetOneCard();

	}

}
