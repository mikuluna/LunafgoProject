package com.he.myfgo.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.he.myfgo.model.Card;
/**
 * fgo卡片详细页面（功能开发）
 * 每张卡片可以看详情
 * @author luna
 * @version 1.0
 */
public class FrmCardInfo extends JFrame{
	private int cardId = 1;//默认为1
	/**左侧图片*/
	private JLabel lblImage = null;
	//根据不同的卡片等级显示不同的面板
	/**R卡的面板*/
	private JPanel jpnInfoR = new JPanel();
	/**R卡的参数*/
	private JLabel lblInfoR = new JLabel(new ImageIcon("images/Rcard.jpg"));
	/**SR卡的面板*/
	private JPanel jpnInfoSR = new JPanel();
	/**SR卡的参数*/
	private JLabel lblInfoSR = new JLabel(new ImageIcon("images/SRcard.jpg"));
	/**SSR卡的面板*/
	private JPanel jpnInfoSSR = new JPanel();
	/**SSR卡的参数*/
	private JLabel lblInfoSSR = new JLabel(new ImageIcon("images/SSRcard.jpg"));
	/**返回上个页面*/
	private JButton btnBack = new JButton("返回上个页面");
	public FrmCardInfo() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("单抽主页面");
		initComponents();
		setSize(400, 300);
		setCenter();
		setVisible(true);
	}
	public FrmCardInfo(int cardId) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("单抽主页面");
		this.cardId=cardId;
		initComponents();
		setSize(400, 300);
		setCenter();
		setVisible(true);
	}
	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();
		lblImage=new JLabel(new ImageIcon("images/"+cardId+".jpg"));
		lblImage.setBounds(60, 60, 100, 170);
		Card card =  new Card(cardId);
		contentPane.add(lblImage);
		
		
		jpnInfoR.setBounds(180, 55, 180, 170);
		jpnInfoR.setOpaque(false);
		jpnInfoR.add(lblInfoR);
		jpnInfoSR.setBounds(180, 55, 180, 170);
		jpnInfoSR.setOpaque(false);
		jpnInfoSR.add(lblInfoSR);
		jpnInfoSSR.setBounds(180, 55, 180, 170);
		jpnInfoSSR.setOpaque(false);
		jpnInfoSSR.add(lblInfoSSR);
		
		contentPane.add(jpnInfoR);
		contentPane.add(jpnInfoSR);
		contentPane.add(jpnInfoSSR);
		
		if(card.getMoney()==2){
			jpnInfoR.setVisible(true);
			jpnInfoSR.setVisible(false);
			jpnInfoSSR.setVisible(false);
		}
		else if(card.getMoney()==20){
			jpnInfoR.setVisible(false);
			jpnInfoSR.setVisible(true);
			jpnInfoSSR.setVisible(false);
		}
		else{
			jpnInfoR.setVisible(false);
			jpnInfoSR.setVisible(false);
			jpnInfoSSR.setVisible(true);
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
		ImageIcon background = new ImageIcon("images/gettencardbackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// 在LayeredPane上添加背景图片，并将z轴设定为最小
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 将内容面板设定为透明
		((JPanel) getContentPane()).setOpaque(false);
	}
	public static void main(String[] args) {
		new FrmCardInfo();

	}

}
