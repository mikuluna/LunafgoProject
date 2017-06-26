package com.he.myfgo.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * fgo��������ҳ�棨���ܴ�������
 * 
 * @author luna
 *
 */
public class FrmFogetPassword extends JFrame{
	private FrmFogetPassword me = this;
	public FrmFogetPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("fgo��������");
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
	
	public static void main(String[] args) {
		new FrmFogetPassword();

	}


}
