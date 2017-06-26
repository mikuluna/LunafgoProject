package com.he.myfgo.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.he.myfgo.model.Card;

public class TestOneCardInfo extends JFrame{
	private int cardId = 11;//Ĭ��Ϊ1
	/**���ͼƬ*/
	private JLabel lblImage = null;
	//���ݲ�ͬ�Ŀ�Ƭ�ȼ���ʾ��ͬ�����
	/**R�������*/
	private JPanel jpnInfoR = new JPanel();
	/**R���Ĳ���*/
	private JLabel lblInfoR = new JLabel(new ImageIcon("images/Rcard.jpg"));
	/**SR�������*/
	private JPanel jpnInfoSR = new JPanel();
	/**SR���Ĳ���*/
	private JLabel lblInfoSR = new JLabel(new ImageIcon("images/SRcard.jpg"));
	/**SSR�������*/
	private JPanel jpnInfoSSR = new JPanel();
	/**SSR���Ĳ���*/
	private JLabel lblInfoSSR = new JLabel(new ImageIcon("images/SSRcard.jpg"));
	/**�����ϸ�ҳ��*/
	private JButton btnBack = new JButton("�����ϸ�ҳ��");
	public TestOneCardInfo() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("������ҳ��");
		initComponents();
		setSize(400, 300);
		setCenter();
		setVisible(true);
	}
	public TestOneCardInfo(int cardId) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("������ҳ��");
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
		ImageIcon background = new ImageIcon("images/gettencardbackground.jpg");
		JLabel lblBackground = new JLabel(background);
		// ��LayeredPane����ӱ���ͼƬ������z���趨Ϊ��С
		this.getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// ����������趨Ϊ͸��
		((JPanel) getContentPane()).setOpaque(false);
	}
	
	public static void main(String[] args) {
		new TestOneCardInfo();

	}

}
