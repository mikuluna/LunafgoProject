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
 * fgo的修改个人信息页面
 * 
 * @author luna
 * @version 1.0
 */
public class FrmEditInfo extends JFrame {
	/** 账号 */
	private JLabel lblResgistId = new JLabel("账号：");
	/** 账号txt */
	private JTextField txtResgistId = new JTextField();
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
	private JTextField txtEmail = new JTextField();
	/** 年龄 */
	private JLabel lblAge = new JLabel("年龄：");
	/** 年龄txt */
	private JTextField txtAge = new JTextField();
	/** 性别 */
	private JLabel lblSex = new JLabel("性别：");
	/** 性别选项 */
	private JRadioButton[] rdSex = new JRadioButton[] { new JRadioButton("男"), new JRadioButton("女") };
	/** 真实姓名 */
	private JLabel lblName = new JLabel("真实姓名：");
	/** 真实姓名txt */
	private JTextField txtName = new JTextField();
	/** 注册按钮 */
	private JButton btnRegister = new JButton("确定");
	/** 取消按钮 */
	private JButton btnCancel = new JButton("取消");
	/** 上面图标 */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	/** 拿到上个界面的id */
	private String loginId = "10000";// 这里先初始10000号用户，这样方便验证
	/** user数据 */
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
	 * 普通构造函数，用于验证当前页面用
	 */
	public FrmEditInfo() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("修改个人信息界面");
		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	/**
	 * 构造函数重载 为了在new的时候就把id传进来 实际操作用
	 */
	public FrmEditInfo(String id) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("修改个人信息界面");
		setLoginId(id);//将上个界面的id给赋值给当前类的id
		initComponents();
		setSize(320, 360);
		setCenter();
		setUndecorated(true);
		setVisible(true);
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
		// System.out.println(user.getSex());//验证user.getSex()
		if ("女".equals(user.getSex())) {
			rdSex[1].setSelected(true);
		} else {
			rdSex[0].setSelected(true);
		}
		lblName.setBounds(40, 270, 80, 25);
		txtName.setBounds(130, 270, 100, 20);
		txtName.setText(user.getName());

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
		/**点确定按钮事件*/
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRegister_actionPerformed(e);

			}
		});
		/**点取消按钮事件
		 * 跳回masterface页面
		 */
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmMasterFace fmMasterFace = new FrmMasterFace(user.getId());
				setVisible(false);
				
			}
		});
	}

	/** 自定义按确定按钮的事件 */
	protected void btnRegister_actionPerformed(ActionEvent e) {
		// 判定合法性
		boolean isSuccess = true;
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
		//如果信息无误的话
		if(isSuccess){
			JOptionPane.showMessageDialog(me, "修改成功！");
			//把这些数据封装到user里面，修改userlist，然后保存在文件中
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
			JOptionPane.showMessageDialog(me, "修改失败，请自行检查！");
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
		ImageIcon background = new ImageIcon("images/editInfobackground.gif");
		JLabel lblBackground = new JLabel(background);
		// 在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 将内容面板设定为透明
		((JPanel) getContentPane()).setOpaque(false);
	}

	public static void main(String[] args) {
		new FrmEditInfo();

	}

}
