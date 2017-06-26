package com.he.myfgo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;

/**
 * fgo��¼��
 * 
 * @author luna
 * @version 1.0
 */
public class FrmLogin extends JFrame{
	/**fgo�˺�*/
	private JLabel lblLoginId = null;
	/**fgo����*/
	private JLabel lblPassword = null;
	/**fgo����txt*/
	private JTextField txtLoginId = null;
	/**fgo����txt*/
	private JPasswordField txtPassword = null;
	/**��¼��ť*/
	private JButton btnLogin = null;
	/**ȡ����ť*/
	private JButton btnCancel = null;
	/**�������*/
	private JLabel lblRegNewId = null;
	/**��������*/
	private JLabel lblForgetPwd = null;
	/**ͼ��*/
	private JLabel lblImageIcon = null;
	
	
	public FrmLogin() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("fgo��¼");
		setBackground();
		initComponents();
		setSize(320, 200);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	public void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();	//�������������
		contentPane.setLayout(null);//�����������Ĳ��ַ�ʽΪ�޲���
		//���ÿؼ��ı߽磺x��y����͸�
		lblLoginId = new JLabel("fgo�˺ţ�");
		lblLoginId.setBounds(30, 90, 80, 20);
		lblPassword = new JLabel("fgo���룺");
		lblPassword.setBounds(30, 125, 80, 20);
		txtLoginId = new JTextField();
		txtLoginId.setBounds(90, 90, 120, 20);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 125, 120, 20);
		lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
		
		
		//��ο��Լ�һ��
		lblRegNewId = new JLabel("<html><u>�����˺�</u></html>");
		lblRegNewId.setBounds(225, 90, 80, 20);
		lblRegNewId.setToolTipText("��������º���");
		//����������ɫ
		lblRegNewId.setForeground(Color.BLUE);
		lblRegNewId.setCursor(new Cursor(Cursor.HAND_CURSOR));//cursor�����
		
		lblForgetPwd = new JLabel("<html><u>��������</u></html>");
		lblForgetPwd.setBounds(225, 120, 80, 20);
		//����������ɫ
		lblForgetPwd.setForeground(Color.BLUE);
		lblForgetPwd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//��ť�ı���ͼƬ����
		ImageIcon iconButton = new ImageIcon("images/button.jpg");
		
		btnLogin = new JButton("��¼");
		btnLogin.setBounds(145, 165, 72, 22);		
		btnLogin.setIcon(iconButton);
		//����������ʾ��λ��Ϊ����
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		//����ͼƬ������ť���ڵ�����  
		btnLogin.setContentAreaFilled(false);
		//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��  
		btnLogin.setOpaque(false);
		//�������
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnCancel = new JButton("ȡ��");
		btnCancel.setBounds(225, 165, 72, 22);
		btnCancel.setIcon(iconButton);
		//����������ʾ��λ��Ϊ����
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		//����ͼƬ������ť���ڵ�����  
		btnCancel.setContentAreaFilled(false);
		//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��  
		btnCancel.setOpaque(false);
		//�������
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblImageIcon.setBounds(80, 5, 150, 67);
		
		contentPane.add(lblLoginId);
		contentPane.add(lblPassword);
		contentPane.add(txtLoginId);	
		contentPane.add(txtPassword);
		contentPane.add(lblRegNewId);
		contentPane.add(lblForgetPwd);
		contentPane.add(btnLogin);
		contentPane.add(btnCancel);
		contentPane.add(lblImageIcon);
		
		/**�������˺ţ����������˺�frmRegister*/
		lblRegNewId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmRegister frmRegister = new FrmRegister();
				setVisible(false);
			}		
		}); 		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin_actionPerformed(e);			
			}
		});
		/**ȡ����ť�˳�����*/
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);				
			}
		});					
	}
	
	/**���¼ʱ��action*/
	protected void btnLogin_actionPerformed(ActionEvent e) {
		boolean isSuccess = false;
		//1.�õ�����ȥ��UserList�Ա�
		String strId = txtLoginId.getText();
		String strPassword= new String(txtPassword.getPassword());
		User userlogin = new User(strId,strPassword);
		List<User> userList = new ArrayList<User>();
		userList = FileTool.loadUser();
		for(User user:userList){
			if(user.equals(userlogin)){
				isSuccess = true;
				userlogin=user;
				break;
			}
		}	
		if (isSuccess) {
			JOptionPane.showMessageDialog(me, "��¼�ɹ���");
			// userloginΪ��¼�Ķ��󣬽��������¸�����ȥ
			FrmMasterFace fmMasterFace=new FrmMasterFace(userlogin.getId());
			//��¼�ɹ����ر�����
			me.setVisible(false);									
		}
		else{
			JOptionPane.showMessageDialog(me, "�˺Ż��������");
		}
		
	}

	/**���ȡ��ʱ����¼�*/
	protected void btnCancel_actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	/**
	 * ����ͼƬ
	 */
	public void setBackground(){
		ImageIcon background = new ImageIcon("images/background.jpg");
		JLabel lblBackground = new JLabel(background);
		//��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(
				lblBackground, 
				new Integer(Integer.MIN_VALUE)
		);
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		//����������趨Ϊ͸��
		//((JPanel)getContentPane()).setOpaque(false);
		JPanel contentPane = (JPanel)getContentPane();
		contentPane.setOpaque(false);
	}
	/**�������*/
	public void setCenter(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//��õ�ǰ��Ļ�ķֱ���
		Dimension screenSize = toolkit.getScreenSize();
		//��ǰ���Ŀ�͸�
		Dimension currSize = getSize();
		setLocation((int)((screenSize.getWidth() - currSize.getWidth()) / 2), (int)((screenSize.getHeight() - currSize.getWidth())/2));
	}
	private FrmLogin me = this;
	public static void main(String[] args) {
		new FrmLogin();

	}

}
