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
 * fgo�ĳ鿨��ҳ��
 * 
 * @author luna
 * @version 1.0
 */
class FrmGetCardMain extends JFrame {
	/** ����ͼ�� */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	/** ��ӭ��Ϣ */
	private JLabel lblId = new JLabel();
	/** �˻������Ϣ */
	private JLabel lblMoney = new JLabel();
	/** ���� */
	private JButton btnGetOneCard = new JButton("���飨����10�㣩");
	/** 10���� */
	private JButton btnGetTenCards = new JButton("10���飨����90�㣩");
	/** ������ҳ�� */
	private JButton btnBackMasterFace = new JButton("������ҳ��");
	/** �õ��ϸ������id */
	private String loginId = "10000";// �����ȳ�ʼ10000���û�������������֤
	/** user���� */
	private User user = new User();
	private FrmGetCardMain me = this;

	/**
	 * ��ͨ���캯����������֤��ǰҳ����
	 */
	public FrmGetCardMain() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�鿨��ҳ��");

		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * ���캯������ Ϊ����new��ʱ��Ͱ�id������ ʵ�ʲ�����
	 */
	public FrmGetCardMain(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�鿨��ҳ��");
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
		lblId.setText("��ӭ  " + user.getNickName() + " �ĵ���");
		lblMoney.setBounds(95, 110, 180, 30);
		lblMoney.setText("��ǰ���㣺  " + user.getMoney() + "��");
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
					JOptionPane.showMessageDialog(me, "����10�㣬���ֵ��");
				} else if (cardList != null && cardList.size() > 24) {
					JOptionPane.showMessageDialog(me, "��Ƭ����Ϊ25�ţ��뵽�鿴/������Ƭ�������ۿ�Ƭ");
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
					JOptionPane.showMessageDialog(me, "����90�㣬���ֵ��");
				} else if (cardList != null && cardList.size() > 15) {
					if (cardList.size() > 15) {
						JOptionPane.showMessageDialog(me, "��Ƭ����Ϊ25�ţ��뵽�鿴/������Ƭ�������ۿ�Ƭ");
					}
				} else {
					FrmGetTenCard frmGetTenCard = new FrmGetTenCard(user.getId());
					setVisible(false);
				}

			}
		});

	}

	/** ������� */
	public void setCenter() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// ��õ�ǰ��Ļ�ķֱ���
		Dimension screenSize = toolkit.getScreenSize();
		// ��ǰ���Ŀ�͸�
		Dimension currSize = getSize();
		setLocation((int) ((screenSize.getWidth() - currSize.getWidth()) / 2),
				(int) ((screenSize.getHeight() - currSize.getWidth()) / 2));
	}

	/** ���ñ���ͼƬ */
	private void setBackground() {
		ImageIcon background = new ImageIcon("images/getcardmainbankgound.gif");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// ����������趨Ϊ͸��
		((JPanel) getContentPane()).setOpaque(false);
	}

	/**
	 * ����id�������user
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
