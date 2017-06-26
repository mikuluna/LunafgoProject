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
import com.he.myfgo.tool.FileTool;
import com.he.myfgo.tool.ProbabilityTool;

/**
 * fgoʮ��ҳ��
 * 
 * @author luna
 * @version 1.0
 */
public class FrmGetTenCard extends JFrame {
	/** �鿨ͼƬ10�� */
	private JButton[] btnImages = new JButton[10];
	/** ������һ����ť */
	private JButton btnBack = new JButton("������һ��");
	/** �õ��ϸ������id */
	private String loginId = "10000";// �����ȳ�ʼ10000���û�������������֤
	/** user���� */
	private User user = new User();
	/** ���ݸ������ɵ�cardId */
	private int i = ProbabilityTool.cardId();
	private FrmGetTenCard me = this;
	private Card card;

	public FrmGetTenCard() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ʮ����ҳ��");
		initComponents();
		setSize(560, 300);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * ���캯������ Ϊ����new��ʱ��Ͱ�id������ ʵ�ʲ�����
	 */
	public FrmGetTenCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ʮ����ҳ��");
		setLoginId(id);
		initComponents();
		setSize(560, 300);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

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
		for (int n = 0; n < 10; n++) {
			if(n == 0 && user.getId().equals("test")){//test�û������Ǳ���
				i = ProbabilityTool.cardSR();
			}
			else{
			i = ProbabilityTool.cardId();
			}
			Card card = new Card(i);
			cardListadd.add(card);
		}

		for (int i = 0; i < cardListadd.size(); i++) {
			btnImages[i] = new JButton(new ImageIcon(cardListadd.get(i).getImageId()));
			if (i == 0) {
				btnImages[i].setBounds(40, 40, 50, 85);

			} else if (i % 5 != 0) {
				btnImages[i].setBounds(btnImages[i - 1].getX() + btnImages[i - 1].getWidth() + 50,
						btnImages[i - 1].getY(), btnImages[i - 1].getWidth(), btnImages[i - 1].getHeight());
			} else {
				btnImages[i].setBounds(btnImages[i - 5].getX(),
						btnImages[i - 5].getY() + btnImages[i - 1].getWidth() + 50, btnImages[i - 5].getWidth(),
						btnImages[i - 5].getHeight());
			}
			contentPane.add(btnImages[i]);

		}
		// �����ͼƬʱ����ʾ��ϸ����
		for (int n = 0; n < cardListadd.size(); n++) {
			int choice = n;
			// ��ʾ��ϸ����
			btnImages[n].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new FrmCardInfo(cardListadd.get(choice).getId());
				}
			});
		}
		List<Card> cardList = null;
		cardList = FileTool.loadCard(user);
		if (cardList == null) {
			cardList = new ArrayList<Card>();
			cardList.addAll(cardListadd);
			FileTool.saveCard(cardList, user, true);
		} else {
			cardList = FileTool.loadCard(user);
			cardList.addAll(cardListadd);
			FileTool.saveCard(cardList, user, false);
		}
		// ��user�ļ۸��������
		user.setMoney(user.getMoney() - 90);
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
		// ��ǰ���Ŀ��͸�
		Dimension currSize = getSize();
		setLocation((int) ((screenSize.getWidth() - currSize.getWidth()) / 2),
				(int) ((screenSize.getHeight() - currSize.getWidth()) / 2));
	}

	/** ���ñ���ͼƬ */
	private void setBackground() {
		ImageIcon background = new ImageIcon("images/gettencardbackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane�����ӱ���ͼƬ������z���趨Ϊ��С
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
		new FrmGetTenCard();

	}

}