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
 * fgo登录窗
 * 
 * @author luna
 * @version 1.0
 */
public class FrmLogin extends JFrame{
	/**fgo账号*/
	private JLabel lblLoginId = null;
	/**fgo密码*/
	private JLabel lblPassword = null;
	/**fgo号码txt*/
	private JTextField txtLoginId = null;
	/**fgo密码txt*/
	private JPasswordField txtPassword = null;
	/**登录按钮*/
	private JButton btnLogin = null;
	/**取消按钮*/
	private JButton btnCancel = null;
	/**申请号码*/
	private JLabel lblRegNewId = null;
	/**忘记密码*/
	private JLabel lblForgetPwd = null;
	/**图标*/
	private JLabel lblImageIcon = null;
	
	
	public FrmLogin() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("fgo登录");
		setBackground();
		initComponents();
		setSize(320, 200);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}

	public void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();	//获得内容面板对象
		contentPane.setLayout(null);//设置内容面板的布局方式为无布局
		//设置控件的边界：x、y，宽和高
		lblLoginId = new JLabel("fgo账号：");
		lblLoginId.setBounds(30, 90, 80, 20);
		lblPassword = new JLabel("fgo密码：");
		lblPassword.setBounds(30, 125, 80, 20);
		txtLoginId = new JTextField();
		txtLoginId.setBounds(90, 90, 120, 20);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 125, 120, 20);
		lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
		
		
		//这段可以记一下
		lblRegNewId = new JLabel("<html><u>申请账号</u></html>");
		lblRegNewId.setBounds(225, 90, 80, 20);
		lblRegNewId.setToolTipText("点击申请新号码");
		//设置文字颜色
		lblRegNewId.setForeground(Color.BLUE);
		lblRegNewId.setCursor(new Cursor(Cursor.HAND_CURSOR));//cursor鼠标光标
		
		lblForgetPwd = new JLabel("<html><u>忘记密码</u></html>");
		lblForgetPwd.setBounds(225, 120, 80, 20);
		//设置文字颜色
		lblForgetPwd.setForeground(Color.BLUE);
		lblForgetPwd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//按钮的背景图片对象
		ImageIcon iconButton = new ImageIcon("images/button.jpg");
		
		btnLogin = new JButton("登录");
		btnLogin.setBounds(145, 165, 72, 22);		
		btnLogin.setIcon(iconButton);
		//设置文字显示的位置为居中
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		//设置图片填满按钮所在的区域  
		btnLogin.setContentAreaFilled(false);
		//设置控件是否透明，true为不透明，false为透明  
		btnLogin.setOpaque(false);
		//设置鼠标
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(225, 165, 72, 22);
		btnCancel.setIcon(iconButton);
		//设置文字显示的位置为居中
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		//设置图片填满按钮所在的区域  
		btnCancel.setContentAreaFilled(false);
		//设置控件是否透明，true为不透明，false为透明  
		btnCancel.setOpaque(false);
		//设置鼠标
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
		
		/**点申请账号，跳出申请账号frmRegister*/
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
		/**取消按钮退出程序*/
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);				
			}
		});					
	}
	
	/**点登录时的action*/
	protected void btnLogin_actionPerformed(ActionEvent e) {
		boolean isSuccess = false;
		//1.拿到数据去和UserList对比
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
			JOptionPane.showMessageDialog(me, "登录成功！");
			// userlogin为登录的对象，将它传到下个界面去
			FrmMasterFace fmMasterFace=new FrmMasterFace(userlogin.getId());
			//登录成功隐藏本窗体
			me.setVisible(false);									
		}
		else{
			JOptionPane.showMessageDialog(me, "账号或密码错误！");
		}
		
	}

	/**点击取消时候的事件*/
	protected void btnCancel_actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	/**
	 * 背景图片
	 */
	public void setBackground(){
		ImageIcon background = new ImageIcon("images/background.jpg");
		JLabel lblBackground = new JLabel(background);
		//在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(
				lblBackground, 
				new Integer(Integer.MIN_VALUE)
		);
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		//将内容面板设定为透明
		//((JPanel)getContentPane()).setOpaque(false);
		JPanel contentPane = (JPanel)getContentPane();
		contentPane.setOpaque(false);
	}
	/**界面居中*/
	public void setCenter(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//获得当前屏幕的分辨率
		Dimension screenSize = toolkit.getScreenSize();
		//当前面板的宽和高
		Dimension currSize = getSize();
		setLocation((int)((screenSize.getWidth() - currSize.getWidth()) / 2), (int)((screenSize.getHeight() - currSize.getWidth())/2));
	}
	private FrmLogin me = this;
	public static void main(String[] args) {
		new FrmLogin();

	}

}
