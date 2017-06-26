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
 * fgo�鿴������Ƭ����
 * 
 * @author luna
 * @version 1.0
 */
public class FrmIndexCard extends JFrame {
	/** �õ��ϸ������id */
	private String loginId = "test";// �����ȳ�ʼ10000���û�������������֤
	/** user���� */
	private User user = new User();
	/** �� */
	private FrmIndexCard me = this;
	/** �������� */
	private JScrollPane scrollPane = new JScrollPane();// û�мӳɹ�
	/** �û���Ƭ���� */
	private List<Card> cardList = new ArrayList<Card>();

	/** ��Ƭ��ť���� */
	private JButton[] btnCard = null;
	/** ������һ����ť */
	private JButton btnBack = new JButton("������һ��");
	/** ����ť */
	private JButton btnSort = new JButton("����");

	private JButton btnSellAll = new JButton("һ������");

	private int n = 0;

	public FrmIndexCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�鿴/������Ƭ");
		initComponents();
		setSize(580, 600);
		setCenter();
		// setUndecorated(true);
		setVisible(true);
	}

	/**
	 * ���캯������ Ϊ����new��ʱ��Ͱ�id������ ʵ�ʲ�����
	 */
	public FrmIndexCard(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�鿴/������Ƭ");
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
		// ���ذ�ť
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
						new String("�������" +money+ "��"), "������Ƭ",
						JOptionPane.YES_NO_OPTION);
				if(result==0){
					user.setMoney(user.getMoney() +money);
					cardList.removeAll(cardList);
					FileTool.deletCard(user);
					// ��user�ļ۸��������
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
					// int result=JOptionPane.showConfirmDialog(null,"�������20��");
					int result = JOptionPane.showConfirmDialog(null,
							new String("�������" + (cardList.get(choice).getMoney()) + "��"), "������Ƭ",
							JOptionPane.YES_NO_OPTION);

					// ��д���ļ�
					if (result == 0) {
						user.setMoney(user.getMoney() + cardList.get(choice).getMoney());
						cardList.remove(choice);
						// ��ɾ���Ŀ�Ƭ����txt�ļ�����
						if (cardList.isEmpty()) {
							FileTool.deletCard(user);
						} else {
							FileTool.saveCard(cardList, user, false);
						}
						// ��user�ļ۸��������
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
	 * �������������ʾ�ұ������еĶ������� ����Ҫ�����޲���
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
		// ����ͼƬ������ʾ��Ӧ��ͼƬ
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
		// ����ť
		btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(cardList);
				setCardImage(pane, cardList);
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
		ImageIcon background = new ImageIcon("images/indexcarbackground.jpg");
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
		new FrmIndexCard();

	}

}