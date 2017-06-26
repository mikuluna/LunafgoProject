package com.he.myfgo.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * fgo忘记密码页面（功能待开发）
 * 
 * @author luna
 *
 */
public class FrmFogetPassword extends JFrame{
	private FrmFogetPassword me = this;
	public FrmFogetPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("fgo忘记密码");
		setBackground();
		initComponents();
		setSize(320, 200);
		setCenter();
		setUndecorated(true);
		setVisible(true);
	}
	private void initComponents() {
		
		
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
	
	public static void main(String[] args) {
		new FrmFogetPassword();

	}


}
