package com.he.myfgo.test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestSex extends JFrame {
	private JLabel lblImageMaster1 = new JLabel(new ImageIcon("images/master男.png"));
	private JLabel lblImageMaster2 = new JLabel(new ImageIcon("images/master女.png"));
	/** 性别选项 */
	private JRadioButton[] rdSex = new JRadioButton[] { new JRadioButton("男"), new JRadioButton("女",true) };

	public TestSex() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("修改个人信息界面");
		initComponents();
		setSize(320, 360);
		setCenter();
		setVisible(true);
	}

	private void initComponents() {
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setBackground();

		lblImageMaster1.setBounds(70, 53, 180, 298);
		lblImageMaster2.setBounds(70, 53, 180, 298);
		rdSex[0].setBounds(130, 245, 40, 20);
		rdSex[1].setBounds(180, 245, 40, 20);
		ButtonGroup groupSex = new ButtonGroup();
		for (int i = 0; i < rdSex.length; i++) {
			rdSex[i].setOpaque(false);
			groupSex.add(rdSex[i]);
			contentPane.add(rdSex[i]);
		}
		contentPane.add(lblImageMaster1);
		contentPane.add(lblImageMaster2);
		if (rdSex[0].isSelected()) {			
			lblImageMaster2.setVisible(false);
		} else {			
			lblImageMaster1.setVisible(false);
		}
		rdSex[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblImageMaster2.setVisible(false);
				lblImageMaster1.setVisible(true);
				
			}
		});
		rdSex[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblImageMaster1.setVisible(false);
				lblImageMaster2.setVisible(true);
				
			}
		});

		
		// System.out.println(user.getSex());//验证user.getSex()

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
		new TestSex();

	}

}
