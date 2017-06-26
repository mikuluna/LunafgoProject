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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.he.myfgo.model.Card;
import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;
/**
 * fgo的抽卡主页面
 * 
 * @author luna
 * @version 1.0
 */
class FrmGetCardMain extends JFrame {
	/** 上面图标 */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	/** 欢迎信息 */
	private JLabel lblId = new JLabel();
	/** 账户余额信息 */
	private JLabel lblMoney = new JLabel();
	/** 单抽 */
	private JButton btnGetOneCard = new JButton("单抽（消耗10点）");
	/** 10连抽 */
	private JButton btnGetTenCards = new JButton("10连抽（消耗90点）");
	/** 返回主页面 */
	private JButton btnBackMasterFace = new JButton("返回主页面");
	/** 拿到上个界面的id */
	private String loginId = "10000";// 这里先初始10000号用户，这样方便验证
	/** user数据 */
	private User user = new User();
	private FrmGetCardMain me = this;

	/**
	 * 普通构造函数，用于验证当前页面用
	 */
	public FrmGetCardMain() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("抽卡主页面");

		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * 构造函数重载 为了在new的时候就把id传进来 实际操作用
	 */
	public FrmGetCardMain(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("抽卡主页面");
		setLoginId(id);
		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);

		lblId.setBounds(95, 85, 180, 30);
		lblId.setText("欢迎  " + user.getNickName() + " 的到来");
		lblMoney.setBounds(95, 110, 180, 30);
		lblMoney.setText("当前余额点：  " + user.getMoney() + "点");
		lblImageIcon.setBounds(90, 5, 150, 67);

		btnGetOneCard.setBounds(80, 150, 160, 40);
		btnGetOneCard.setIcon(new ImageIcon("images/getCardMainButton.jpg"));
		btnGetOneCard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGetOneCard.setOpaque(false);
		btnGetOneCard.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnGetTenCards.setBounds(80, 200, 160, 40);
		btnGetTenCards.setIcon(new ImageIcon("images/getCardMainButton.jpg"));
		btnGetTenCards.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGetTenCards.setOpaque(false);
		btnGetTenCards.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnBackMasterFace.setBounds(80, 250, 160, 40);
		btnBackMasterFace.setIcon(new ImageIcon("images/getCardMainButton.jpg"));
		btnBackMasterFace.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBackMasterFace.setOpaque(false);
		btnBackMasterFace.setCursor(new Cursor(Cursor.HAND_CURSOR));

		contentPane.add(lblId);
		contentPane.add(lblMoney);
		contentPane.add(lblImageIcon);
		contentPane.add(btnGetOneCard);
		contentPane.add(btnGetTenCards);
		contentPane.add(btnBackMasterFace);

		btnBackMasterFace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmMasterFace frmMasterFace = new FrmMasterFace(user.getId());
				setVisible(false);
			}
		});

		btnGetOneCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Card> cardList = new ArrayList<Card>();
				cardList = FileTool.loadCard(user);
				if (user.getMoney() < 10) {
					JOptionPane.showMessageDialog(me, "不足10点，请充值！");
				} else if (cardList != null && cardList.size() > 24) {
					JOptionPane.showMessageDialog(me, "卡片上线为25张，请到查看/贩卖卡片窗口销售卡片");
				} else {
					FrmGetOneCard fmGetOneCard = new FrmGetOneCard(user.getId());
					setVisible(false);
				}

			}
		});
		btnGetTenCards.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Card> cardList = new ArrayList<Card>();
				cardList = FileTool.loadCard(user);
				if (user.getMoney() < 90) {
					JOptionPane.showMessageDialog(me, "不足90点，请充值！");
				} else if (cardList != null && cardList.size() > 15) {
					if (cardList.size() > 15) {
						JOptionPane.showMessageDialog(me, "卡片上线为25张，请到查看/贩卖卡片窗口销售卡片");
					}
				} else {
					FrmGetTenCard frmGetTenCard = new FrmGetTenCard(user.getId());
					setVisible(false);
				}

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
		ImageIcon background = new ImageIcon("images/getcardmainbankgound.gif");
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
		new FrmGetCardMain();

	}

}
