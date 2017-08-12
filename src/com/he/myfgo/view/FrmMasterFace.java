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
 * fgo的master主页面
 * 
 * @author luna
 * @version 1.0
 */
public class FrmMasterFace extends JFrame implements Runnable{
	/**时间*/
	private JLabel lblTime = new JLabel("时间：");
	/**欢迎信息*/
//	private JLabel lblId = new JLabel("欢迎"+getLoginUser().getNickName()+"的到来");
	private JLabel lblId = new JLabel();
	/**账户余额信息*/
//	private JLabel lblMoney = new JLabel("当前余额："+getLoginUser().getMoney()+"点");
	private JLabel lblMoney = new JLabel();
	/**左侧图片*/
//	private JLabel lblImageMaster = new JLabel(new ImageIcon("images/master男.png"));
	private JLabel lblImageMaster = null;
	/**修改个人信息按钮*/
	private JButton btnEditInfo = new JButton("修改个人信息");
	/**开始抽卡*/
	private JButton btnBegin = new JButton("开始抽卡");
	/**查看卡片按钮*/
	private JButton btnSearch = new JButton("查看/出售卡片");
	/** 取消按钮 */
	private JButton btnCancel = new JButton();
	/** 上面图标 */
	private JLabel lblImageIcon = new JLabel(new ImageIcon("images/icon.jpg"));
	
	/**拿到上个界面的id*/
//	private String loginId;
	private String loginId="10000";
	/**user数据*/
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
		setTitle("Master主页面");
		initComponents();
		setSize(500, 360);
		setCenter();

		setUndecorated(true);
		setVisible(true);
		Thread thread=new Thread(this);
		thread.start();
	}
	/**构造函数重载
	 * 为了在new的时候就把id传进来
	 */
	public FrmMasterFace(String id){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Master主页面");
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
	 * 根据id返回这个user
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
		lblId.setText("欢迎  "+user.getNickName()+" 的到来");
		lblMoney.setBounds(280, 130, 180, 30);
		lblMoney.setText("当前余额点：  "+user.getMoney()+"点");
		
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
		//必须实现接口的run方法 - 开启线程时，run方法会自动调用
		//书写run方法的套路：死循环
		while(true){
			//每隔1秒钟，更新JLabel对象的文本
			Date now = new Date();
			lblTime.setText(now.toLocaleString());
			try {
				Thread.sleep(1000);//休眠1000毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		ImageIcon background = new ImageIcon("images/fmMasterFacebackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// 在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 将内容面板设定为透明
		((JPanel) getContentPane()).setOpaque(false);
	}
	public static void main(String[] args) {
		new FrmMasterFace();
	}

}
