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
 * fgo��ע�����
 * 
 * @author luna
 * @version 1.0
 */
public class FrmRegister extends JFrame {
	/** �˺� */
	private JLabel lblResgistId = new JLabel("�˺ţ�");
	/** �˺�txt */
	private JTextField txtResgistId = new JTextField();
	/** ���� */
	private JLabel lblPwd1 = new JLabel("���룺");
	/** ����txt */
	private JPasswordField txtPwd1 = new JPasswordField();
	/** �ظ����� */
	private JLabel lblPwd2 = new JLabel("�ظ����룺");
	/** �ظ�����txt */
	private JPasswordField txtPwd2 = new JPasswordField();
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
	JTextField txtEmail = new JTextField();
	/** ���� */
	private JLabel lblAge = new JLabel("���䣺");
	/** ����txt */
	private JTextField txtAge = new JTextField();
	/** �Ա� */
	private JLabel lblSex = new JLabel("�Ա�");
	/** �Ա�ѡ�� */
	private JRadioButton[] rdSex = new JRadioButton[] { new JRadioButton("��", true), new JRadioButton("Ů") };
	/** ��ʵ���� */
	private JLabel lblName = new JLabel("��ʵ������");
	/** ��ʵ����txt */
	private JTextField txtName = new JTextField();
	/** ע�ᰴť */
	private JButton btnRegister = new JButton("ע��");
	/** ȡ����ť */
	private JButton btnCancel = new JButton("ȡ��");
	/** ����ͼ�� */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));

	public FrmRegister() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�����º���");
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

		//
		lblResgistId.setBounds(40, 80, 80, 25);
		txtResgistId.setBounds(130, 80, 100, 20);

		lblPwd1.setBounds(40, 105, 80, 25);
		txtPwd1.setBounds(130, 105, 100, 20);

		lblPwd2.setBounds(40, 130, 80, 25);
		txtPwd2.setBounds(130, 130, 100, 20);

		lblNickName.setBounds(20, 165, 100, 25);
		txtNickName.setBounds(130, 165, 100, 20);

		lblphoNum.setBounds(40, 190, 80, 25);
		txtPhoNum.setBounds(130, 190, 100, 20);

		lblEmail.setBounds(40, 215, 80, 25);
		txtEmail.setBounds(130, 215, 100, 20);

		lblAge.setBounds(40, 240, 80, 25);
		txtAge.setBounds(130, 240, 50, 20);

		lblSex.setBounds(40, 265, 80, 25);
		rdSex[0].setBounds(130, 265, 40, 20);
		rdSex[1].setBounds(180, 265, 40, 20);

		lblName.setBounds(40, 285, 80, 25);
		txtName.setBounds(130, 285, 100, 20);

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

		lblPwd1.setHorizontalAlignment(JLabel.RIGHT);
		txtPwd1.setHorizontalAlignment(JTextField.RIGHT);

		lblPwd2.setHorizontalAlignment(JLabel.RIGHT);
		txtPwd2.setHorizontalAlignment(JTextField.RIGHT);

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
		btnRegister.setOpaque(false);
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancel.setBounds(200, 320, 72, 22);
		btnCancel.setIcon(new ImageIcon("images/button.jpg"));
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancel.setOpaque(false);
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		contentPane.add(lblResgistId);
		contentPane.add(txtResgistId);
		contentPane.add(lblPwd1);
		contentPane.add(txtPwd1);
		contentPane.add(lblPwd2);
		contentPane.add(txtPwd2);
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

		/** ȡ����ť�˳����� */
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmLogin frmLogin = new FrmLogin();
				setVisible(false);
			}
		});
		/** ע�ᰴť */
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRegister_actionPerformed(e);

			}
		});
		/** �˺ż����¼� */
		txtResgistId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtResgistId.setBackground(Color.WHITE);
			}
		});
		/** ��������¼� */
		txtPwd1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPwd1.setBackground(Color.WHITE);
			}
		});
		/** �ٴ�������������¼� */
		txtPwd2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPwd2.setBackground(Color.WHITE);
			}
		});
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

	}

	/** �Զ���İ�ע��ʱ���¼� */
	protected void btnRegister_actionPerformed(ActionEvent e) {
		// 1.�õ������������װ��ʵ�����
		boolean isSuccess = true;
		// �˺���֤
		String strId = txtResgistId.getText();
		if ("".equals(strId)) {
			// �޸�id�ı���ı�����ɫ
			txtResgistId.setBackground(Color.YELLOW);
			// ��id�ı����ý���
			txtResgistId.grabFocus();
			// ����id�ı�������ȫѡ״̬//����ȫѡ
			txtResgistId.selectAll();
			isSuccess = false;
		}
		// �˺ź�����.txt��֤�˺��Ƿ�ע��
		List<User> userList = new ArrayList<User>();
		userList = FileTool.loadUser();
		if (userList != null) {
			for (int i = 0; i < userList.size(); i++) {
				String id = userList.get(i).getId();
				if (id.equals(strId)) {
					// �޸������ı���ı�����ɫ
					txtResgistId.setBackground(Color.YELLOW);
					// �������ı����ý���
					txtResgistId.grabFocus();
					// ���������ı�������ȫѡ״̬//����ȫѡ
					txtResgistId.selectAll();
					txtResgistId.setText("�˺��Ѿ���ע��");
					isSuccess = false;
					break;
				}
			}
		}
		// ������֤
		String strPassword1 = new String(txtPwd1.getPassword());
		String strPassword2 = new String(txtPwd2.getPassword());
		if ("".equals(strPassword1)) {
			txtPwd1.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		if ("".equals(strPassword2)) {
			txtPwd2.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		if (!strPassword1.equals(strPassword2)) {
			txtPwd1.setBackground(Color.YELLOW);
			txtPwd2.setBackground(Color.YELLOW);
			isSuccess = false;
		}
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

		if (isSuccess) {
			JOptionPane.showMessageDialog(me, "ע��ɹ���");
			// ����Щ���Է�װ��user������д���ļ���
			User user = new User(strId, strPassword1, strName, Integer.parseInt(strAge), strSex, strPhoneNumber,
					strNickName, strEmail, 100);
			List<User> userList1 = new ArrayList<User>();
			userList1.add(user);
			FileTool.saveUser(userList1, true);
			FrmLogin frmLogin = new FrmLogin();
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(me, "ע��ʧ�ܣ������м�飡");
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
		ImageIcon background = new ImageIcon("images/registerbackground.gif");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// ����������趨Ϊ͸��
		((JPanel) getContentPane()).setOpaque(false);
	}
	

	private FrmRegister me = this;

	public static void main(String[] args) {
		new FrmRegister();
	}

}
