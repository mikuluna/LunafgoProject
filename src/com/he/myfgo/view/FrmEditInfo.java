package com.he.myfgo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.he.myfgo.model.User;
import com.he.myfgo.tool.FileTool;
/**
 * fgo���޸ĸ�����Ϣҳ��
 * 
 * @author luna
 * @version 1.0
 */
public class FrmEditInfo extends JFrame {
	/** �˺� */
	private JLabel lblResgistId = new JLabel("�˺ţ�");
	/** �˺�txt */
	private JTextField txtResgistId = new JTextField();
	/** �ǳ� */
	private JLabel lblNickName = new JLabel("�ǳ�(�����λ)��");
	/** �ǳ�txt */
	private JTextField txtNickName = new JTextField();
	/** �ֻ����� */
	private JLabel lblphoNum = new JLabel("�ֻ����룺");
	/** �ֻ�����txt */
	private JTextField txtPhoNum = new JTextField();
	/** ���� */
	private JLabel lblEmail = new JLabel("���䣺");
	/** ����txt */
	private JTextField txtEmail = new JTextField();
	/** ���� */
	private JLabel lblAge = new JLabel("���䣺");
	/** ����txt */
	private JTextField txtAge = new JTextField();
	/** �Ա� */
	private JLabel lblSex = new JLabel("�Ա�");
	/** �Ա�ѡ�� */
	private JRadioButton[] rdSex = new JRadioButton[] { new JRadioButton("��"), new JRadioButton("Ů") };
	/** ��ʵ���� */
	private JLabel lblName = new JLabel("��ʵ������");
	/** ��ʵ����txt */
	private JTextField txtName = new JTextField();
	/** ע�ᰴť */
	private JButton btnRegister = new JButton("ȷ��");
	/** ȡ����ť */
	private JButton btnCancel = new JButton("ȡ��");
	/** ����ͼ�� */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	/** �õ��ϸ������id */
	private String loginId = "10000";// �����ȳ�ʼ10000���û�������������֤
	/** user���� */
	private User user = new User();
	private FrmEditInfo me = this;
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

	/**
	 * ��ͨ���캯����������֤��ǰҳ����
	 */
	public FrmEditInfo() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�޸ĸ�����Ϣ����");
		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * ���캯������ Ϊ����new��ʱ��Ͱ�id������ ʵ�ʲ�����
	 */
	public FrmEditInfo(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�޸ĸ�����Ϣ����");
		setLoginId(id);//���ϸ������id����ֵ����ǰ���id
		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
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

	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		user = getUser(loginId);

		lblResgistId.setBounds(40, 100, 80, 25);
		txtResgistId.setBounds(130, 100, 100, 20);
		txtResgistId.setText(user.getId());
		txtResgistId.setEditable(false);

		lblNickName.setBounds(20, 130, 100, 25);
		txtNickName.setBounds(130, 130, 100, 20);
		txtNickName.setText(user.getNickName());

		lblphoNum.setBounds(40, 160, 80, 25);
		txtPhoNum.setBounds(130, 160, 100, 20);
		txtPhoNum.setText(user.getPhoNum());

		lblEmail.setBounds(40, 190, 80, 25);
		txtEmail.setBounds(130, 190, 100, 20);
		txtEmail.setText(user.getEmail());

		lblAge.setBounds(40, 220, 80, 25);
		txtAge.setBounds(130, 220, 50, 20);
		txtAge.setText(user.getAge() + "");

		lblSex.setBounds(40, 250, 80, 25);
		rdSex[0].setBounds(130, 245, 40, 20);
		rdSex[1].setBounds(180, 245, 40, 20);
		// System.out.println(user.getSex());//��֤user.getSex()
		if ("Ů".equals(user.getSex())) {
			rdSex[1].setSelected(true);
		} else {
			rdSex[0].setSelected(true);
		}
		lblName.setBounds(40, 270, 80, 25);
		txtName.setBounds(130, 270, 100, 20);
		txtName.setText(user.getName());

		lblImageIcon.setBounds(80, 5, 150, 67);
		// �ڻ�����Ϣ���������Ա����
		ButtonGroup groupSex = new ButtonGroup();
		for (int i = 0; i < rdSex.length; i++) {
			rdSex[i].setOpaque(false);
			groupSex.add(rdSex[i]);
			contentPane.add(rdSex[i]);
		}
		lblResgistId.setHorizontalAlignment(JLabel.RIGHT);
		txtResgistId.setHorizontalAlignment(JTextField.RIGHT);

		lblNickName.setHorizontalAlignment(JLabel.RIGHT);
		txtNickName.setHorizontalAlignment(JTextField.RIGHT);

		lblphoNum.setHorizontalAlignment(JLabel.RIGHT);
		txtPhoNum.setHorizontalAlignment(JTextField.RIGHT);

		lblEmail.setHorizontalAlignment(JLabel.RIGHT);
		txtEmail.setHorizontalAlignment(JTextField.RIGHT);

		lblAge.setHorizontalAlignment(JLabel.RIGHT);
		txtAge.setHorizontalAlignment(JTextField.RIGHT);

		lblName.setHorizontalAlignment(JLabel.RIGHT);
		txtName.setHorizontalAlignment(JTextField.RIGHT);

		lblSex.setHorizontalAlignment(JLabel.RIGHT);

		// ע��ȡ����ť
		btnRegister.setBounds(100, 320, 72, 22);
		btnRegister.setIcon(new ImageIcon("images/button.jpg"));
		btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegister.setBorder(null);
		btnRegister.setOpaque(false);
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancel.setBounds(200, 320, 72, 22);
		btnCancel.setIcon(new ImageIcon("images/button.jpg"));
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancel.setBorder(null);
		btnCancel.setOpaque(false);
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		contentPane.add(lblResgistId);
		contentPane.add(txtResgistId);
		contentPane.add(lblNickName);
		contentPane.add(txtNickName);
		contentPane.add(lblphoNum);
		contentPane.add(txtPhoNum);
		contentPane.add(lblEmail);
		contentPane.add(txtEmail);
		contentPane.add(lblAge);
		contentPane.add(txtAge);
		contentPane.add(lblSex);
		contentPane.add(lblName);
		contentPane.add(txtName);

		contentPane.add(lblImageIcon);

		contentPane.add(btnRegister);
		contentPane.add(btnCancel);
		
		/** �ǳƼ����¼� */
		txtNickName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNickName.setBackground(Color.WHITE);
			}
		});
		/** ��ʵ���������¼� */
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtName.setBackground(Color.WHITE);
			}
		});
		/** �ֻ���������¼� */
		txtPhoNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPhoNum.setBackground(Color.WHITE);
			}
		});
		/** ��������¼� */
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtEmail.setBackground(Color.WHITE);
			}
		});
		/** ��������¼� */
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtAge.setBackground(Color.WHITE);
			}
		});
		/**��ȷ����ť�¼�*/
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRegister_actionPerformed(e);

			}
		});
		/**��ȡ����ť�¼�
		 * ����masterfaceҳ��
		 */
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmMasterFace fmMasterFace = new FrmMasterFace(user.getId());
				setVisible(false);
				
			}
		});
	}

	/** �Զ��尴ȷ����ť���¼� */
	protected void btnRegister_actionPerformed(ActionEvent e) {
		// �ж��Ϸ���
		boolean isSuccess = true;
		// �ǳ���֤
		String strNickName = txtNickName.getText();
		if ("".equals(strNickName) || strNickName.length() > 6) {
			txtNickName.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// ��ʵ������֤
		String strName = txtName.getText();
		if ("".equals(strName) || strName.length() > 6) {
			txtName.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// �ֻ�������֤
		String strPhoneNumber = txtPhoNum.getText();
		if (strPhoneNumber.length() != 11) {
			txtPhoNum.setBackground(Color.YELLOW);
			isSuccess = false;
		} else {
			for (int i = 0; i < 11; i++) {
				if (strPhoneNumber.charAt(i) < '0' || strPhoneNumber.charAt(i) > '9') {
					txtPhoNum.setBackground(Color.YELLOW);
					isSuccess = false;
				}
			}
		}
		// ������֤
		String strEmail = txtEmail.getText();
		if (strEmail.indexOf("@") == -1 || strEmail.indexOf(".") < strEmail.indexOf("@")) {
			txtEmail.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// ��֤�������������
		String strAge = txtAge.getText();
		if ("".equals(strAge)) {
			strAge = "w";
			isSuccess = false;
		}
		for (int i = 0; i < strAge.length(); i++) {
			if (strAge.charAt(i) < '0' || strAge.charAt(i) > '9') {
				// �޸������ı���ı�����ɫ
				txtAge.setBackground(Color.YELLOW);
				isSuccess = false;
				return;
			}
		}
		String strSex = rdSex[0].isSelected() ? "��" : "Ů";
		//�����Ϣ����Ļ�
		if(isSuccess){
			JOptionPane.showMessageDialog(me, "�޸ĳɹ���");
			//����Щ���ݷ�װ��user���棬�޸�userlist��Ȼ�󱣴����ļ���
			User user = new User(this.user.getId(),this.user.getPassword()
					,strName,Integer.parseInt(strAge),strSex,
					strPhoneNumber,strNickName,strEmail,this.user.getMoney());
			List<User> userList = new ArrayList<User>();
			userList=FileTool.loadUser();
			for(int i =0;i<userList.size();i++){
				User searchUser = (User)userList.get(i);
				if(searchUser.equals(user)){
					userList.remove(i);
					userList.add(i, user);
				}				
			}
			FileTool.saveUser(userList, false);
			FrmMasterFace fmMasterFace = new FrmMasterFace(user.getId());
			setVisible(false);
		}
		else{
			JOptionPane.showMessageDialog(me, "�޸�ʧ�ܣ������м�飡");
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
		ImageIcon background = new ImageIcon("images/editInfobackground.gif");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// ����������趨Ϊ͸��
		((JPanel) getContentPane()).setOpaque(false);
	}

	public static void main(String[] args) {
		new FrmEditInfo();

	}

}
