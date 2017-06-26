package com.he.myfgo.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;

/**
 * fgo��master��ҳ��
 * 
 * @author luna
 * @version 1.0
 */
public class FrmMasterFace extends JFrame implements Runnable{
	/**ʱ��*/
	private JLabel lblTime = new JLabel("ʱ�䣺");
	/**��ӭ��Ϣ*/
//	private JLabel lblId = new JLabel("��ӭ"+getLoginUser().getNickName()+"�ĵ���");
	private JLabel lblId = new JLabel();
	/**�˻������Ϣ*/
//	private JLabel lblMoney = new JLabel("��ǰ��"+getLoginUser().getMoney()+"��");
	private JLabel lblMoney = new JLabel();
	/**���ͼƬ*/
//	private JLabel lblImageMaster = new JLabel(new ImageIcon("images/master��.png"));
	private JLabel lblImageMaster = null;
	/**�޸ĸ�����Ϣ��ť*/
	private JButton btnEditInfo = new JButton("�޸ĸ�����Ϣ");
	/**��ʼ�鿨*/
	private JButton btnBegin = new JButton("��ʼ�鿨");
	/**�鿴��Ƭ��ť*/
	private JButton btnSearch = new JButton("�鿴/���ۿ�Ƭ");
	/** ȡ����ť */
	private JButton btnCancel = new JButton();
	/** ����ͼ�� */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	
	/**�õ��ϸ������id*/
//	private String loginId;
	private String loginId="10000";
	/**user����*/
	private User user = new User();
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public FrmMasterFace(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Master��ҳ��");
		initComponents();
		setSize(500, 360);
		setCenter();

		setUndecorated(true);
		setVisible(true);
		Thread thread=new Thread(this);
		thread.start();
	}
	/**���캯������
	 * Ϊ����new��ʱ��Ͱ�id������
	 */
	public FrmMasterFace(String id){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Master��ҳ��");
		setLoginId(id);
		initComponents();
		setSize(500, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
		Thread thread=new Thread(this);
		thread.start();
	}
	/**
	 * ����id�������user
	 */
	private User getUser(String id){
		User user1=new User();
		List<User> userList = new ArrayList<User>();
		userList=FileTool.loadUser();
		for(User searchUser:userList){
			if(id.equals(searchUser.getId())){
				user1=searchUser;
				break;
			}
		}
		return user1;
	}
	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);
		
		lblId.setBounds(280, 100, 180, 30);
		lblId.setText("��ӭ  "+user.getNickName()+" �ĵ���");
		lblMoney.setBounds(280, 130, 180, 30);
		lblMoney.setText("��ǰ���㣺  "+user.getMoney()+"��");
		
		lblImageMaster=new JLabel(new ImageIcon("images/master"+user.getSex()+".png"));
		lblImageMaster.setBounds(70, 53, 180, 298);
		
		
		btnEditInfo.setBounds(300, 170, 120, 40);
		btnEditInfo.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnEditInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditInfo.setOpaque(false);
		btnEditInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnBegin.setBounds(300, 230, 120, 40);
		btnBegin.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnBegin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBegin.setOpaque(false);
		btnBegin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnSearch.setBounds(300, 290, 120, 40);
		btnSearch.setIcon(new ImageIcon("images/masterButton.jpg"));
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setOpaque(false);
		btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblImageIcon.setBounds(280, 30, 150, 67);
		
		
		btnCancel.setBounds(470, 0, 30, 30);
		btnCancel.setIcon(new ImageIcon("images/exit.jpg"));
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancel.setBorder(null);
		btnCancel.setOpaque(false);
		
		
		contentPane.add(lblId);
		contentPane.add(lblMoney);
		contentPane.add(lblImageMaster);
		contentPane.add(btnEditInfo);
		contentPane.add(btnBegin);
		contentPane.add(btnSearch);
		contentPane.add(lblImageIcon);
		contentPane.add(btnCancel);
		
		
		lblTime.setBounds(20, 20, 200, 25);
		contentPane.add(lblTime);
		
		
		
		
		btnEditInfo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmEditInfo fmEditInfo = new FrmEditInfo(user.getId());
				setVisible(false);
			}
		});
		
		btnBegin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmGetCardMain frmGetCardMain = new FrmGetCardMain(user.getId());
				setVisible(false);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmIndexCard frmIndexCard = new FrmIndexCard(user.getId());
				setVisible(false);
			}
		});
		
		
		btnCancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		
		
	}
	@Override
	public void run() {
		//����ʵ�ֽӿڵ�run���� - �����߳�ʱ��run�������Զ�����
		//��дrun��������·����ѭ��
		while(true){
			//ÿ��1���ӣ�����JLabel������ı�
			Date now = new Date();
			lblTime.setText(now.toLocaleString());
			try {
				Thread.sleep(1000);//����1000����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
		ImageIcon background = new ImageIcon("images/fmMasterFacebackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// ����������趨Ϊ͸��
		((JPanel) getContentPane()).setOpaque(false);
	}
	public static void main(String[] args) {
		new FrmMasterFace();
	}

}
