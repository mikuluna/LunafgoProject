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
 * �������
 * @author luna
 * @version 1.0
 */
public class FrmGetOneCard extends JFrame {
	/** �鿨ͼƬ */
	private JButton btnImage = null;
	/** ������һ����ť */
	private JButton btnBack = new JButton("������һ��");
	/** �õ��ϸ������id */
	private String loginId = "10000";// �����ȳ�ʼ10000���û�������������֤
	/** user���� */
	private User user = new User();
	/** ���ݸ������ɵ�cardId */
	private int i = ProbabilityTool.cardId();

	private FrmGetOneCard me = this;
	private Card card;

	public FrmGetOneCard() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("������ҳ��");
		initComponents();
		setSize(200, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * ���캯������ Ϊ����new��ʱ��Ͱ�id������ ʵ�ʲ�����
	 */
	public FrmGetOneCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�鿨��ҳ��");
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

		// ������Ŀ�Ƭ����txt�ļ�����
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
		// ��user�ļ۸��������
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
		ImageIcon background = new ImageIcon("images/getonecardbackground.jpg");
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
		new FrmGetOneCard();

	}

}
