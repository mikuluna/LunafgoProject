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
 * fgo的注册界面
 * 
 * @author luna
 * @version 1.0
 */
public class FrmRegister extends JFrame {
	/** 账号 */
	private JLabel lblResgistId = new JLabel("账号：");
	/** 账号txt */
	private JTextField txtResgistId = new JTextField();
	/** 密码 */
	private JLabel lblPwd1 = new JLabel("密码：");
	/** 密码txt */
	private JPasswordField txtPwd1 = new JPasswordField();
	/** 重复密码 */
	private JLabel lblPwd2 = new JLabel("重复密码：");
	/** 重复密码txt */
	private JPasswordField txtPwd2 = new JPasswordField();
	/** 昵称 */
	private JLabel lblNickName = new JLabel("昵称(最多六位)：");
	/** 昵称txt */
	private JTextField txtNickName = new JTextField();
	/** 手机号码 */
	private JLabel lblphoNum = new JLabel("手机号码：");
	/** 手机号码txt */
	private JTextField txtPhoNum = new JTextField();
	/** 邮箱 */
	private JLabel lblEmail = new JLabel("邮箱：");
	/** 邮箱txt */
	JTextField txtEmail = new JTextField();
	/** 年龄 */
	private JLabel lblAge = new JLabel("年龄：");
	/** 年龄txt */
	private JTextField txtAge = new JTextField();
	/** 性别 */
	private JLabel lblSex = new JLabel("性别：");
	/** 性别选项 */
	private JRadioButton[] rdSex = new JRadioButton[] { new JRadioButton("男", true), new JRadioButton("女") };
	/** 真实姓名 */
	private JLabel lblName = new JLabel("真实姓名：");
	/** 真实姓名txt */
	private JTextField txtName = new JTextField();
	/** 注册按钮 */
	private JButton btnRegister = new JButton("注册");
	/** 取消按钮 */
	private JButton btnCancel = new JButton("取消");
	/** 上面图标 */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));

	public FrmRegister() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("申请新号码");
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
		// 在基本信息面板上添加性别组件
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

		// 注册取消按钮
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

		/** 取消按钮退出程序 */
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmLogin frmLogin = new FrmLogin();
				setVisible(false);
			}
		});
		/** 注册按钮 */
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRegister_actionPerformed(e);

			}
		});
		/** 账号键盘事件 */
		txtResgistId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtResgistId.setBackground(Color.WHITE);
			}
		});
		/** 密码键盘事件 */
		txtPwd1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPwd1.setBackground(Color.WHITE);
			}
		});
		/** 再次输入密码键盘事件 */
		txtPwd2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPwd2.setBackground(Color.WHITE);
			}
		});
		/** 昵称键盘事件 */
		txtNickName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNickName.setBackground(Color.WHITE);
			}
		});
		/** 真实姓名键盘事件 */
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtName.setBackground(Color.WHITE);
			}
		});
		/** 手机号码键盘事件 */
		txtPhoNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPhoNum.setBackground(Color.WHITE);
			}
		});
		/** 邮箱键盘事件 */
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtEmail.setBackground(Color.WHITE);
			}
		});
		/** 年龄键盘事件 */
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtAge.setBackground(Color.WHITE);
			}
		});

	}

	/** 自定义的按注册时的事件 */
	protected void btnRegister_actionPerformed(ActionEvent e) {
		// 1.拿到界面参数，组装成实体对象
		boolean isSuccess = true;
		// 账号验证
		String strId = txtResgistId.getText();
		if ("".equals(strId)) {
			// 修改id文本框的背景颜色
			txtResgistId.setBackground(Color.YELLOW);
			// 让id文本框获得焦点
			txtResgistId.grabFocus();
			// 设置id文本框内容全选状态//文字全选
			txtResgistId.selectAll();
			isSuccess = false;
		}
		// 账号和数据.txt验证账号是否被注册
		List<User> userList = new ArrayList<User>();
		userList = FileTool.loadUser();
		if (userList != null) {
			for (int i = 0; i < userList.size(); i++) {
				String id = userList.get(i).getId();
				if (id.equals(strId)) {
					// 修改年龄文本框的背景颜色
					txtResgistId.setBackground(Color.YELLOW);
					// 让年龄文本框获得焦点
					txtResgistId.grabFocus();
					// 设置年轻文本框内容全选状态//文字全选
					txtResgistId.selectAll();
					txtResgistId.setText("账号已经被注册");
					isSuccess = false;
					break;
				}
			}
		}
		// 密码验证
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
		// 昵称验证
		String strNickName = txtNickName.getText();
		if ("".equals(strNickName) || strNickName.length() > 6) {
			txtNickName.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// 真实姓名验证
		String strName = txtName.getText();
		if ("".equals(strName) || strName.length() > 6) {
			txtName.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// 手机号码验证
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
		// 邮箱验证
		String strEmail = txtEmail.getText();
		if (strEmail.indexOf("@") == -1 || strEmail.indexOf(".") < strEmail.indexOf("@")) {
			txtEmail.setBackground(Color.YELLOW);
			isSuccess = false;
		}
		// 验证年龄必须是数字
		String strAge = txtAge.getText();
		if ("".equals(strAge)) {
			strAge = "w";
			isSuccess = false;
		}
		for (int i = 0; i < strAge.length(); i++) {
			if (strAge.charAt(i) < '0' || strAge.charAt(i) > '9') {
				// 修改年龄文本框的背景颜色
				txtAge.setBackground(Color.YELLOW);
				isSuccess = false;
				return;
			}
		}
		String strSex = rdSex[0].isSelected() ? "男" : "女";

		if (isSuccess) {
			JOptionPane.showMessageDialog(me, "注册成功！");
			// 将这些属性封装到user对象。再写入文件中
			User user = new User(strId, strPassword1, strName, Integer.parseInt(strAge), strSex, strPhoneNumber,
					strNickName, strEmail, 100);
			List<User> userList1 = new ArrayList<User>();
			userList1.add(user);
			FileTool.saveUser(userList1, true);
			FrmLogin frmLogin = new FrmLogin();
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(me, "注册失败，请自行检查！");
		}

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
		ImageIcon background = new ImageIcon("images/registerbackground.gif");
		JLabel lblBackground = new JLabel(background);
		// 在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 将内容面板设定为透明
		((JPanel) getContentPane()).setOpaque(false);
	}
	

	private FrmRegister me = this;

	public static void main(String[] args) {
		new FrmRegister();
	}

}
