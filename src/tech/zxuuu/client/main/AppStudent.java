package tech.zxuuu.client.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import tech.zxuuu.net.Request;
import tech.zxuuu.net.Response;
import tech.zxuuu.util.OtherUtils;
import tech.zxuuu.util.ResponseUtils;

import java.awt.Color;
import java.awt.Toolkit;

public class AppStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppStudent frame = new AppStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppStudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AppStudent.class.getResource("/resources/assets/icon/fav.png")));
		setTitle("学生主页 - VCampus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVcampus = new JLabel("学生主页 - VCampus");
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		lblVcampus.setBounds(99, 24, 306, 43);
		contentPane.add(lblVcampus);
		
		JButton btnTeaching = new JButton(" 教务平台");
		btnTeaching.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnTeaching.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/teaching.png")));
		btnTeaching.setBounds(374, 344, 220, 80);
		contentPane.add(btnTeaching);
		
		JButton btnLibrary = new JButton(" 李文歪图书馆");
		btnLibrary.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnLibrary.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/library.png")));
		btnLibrary.setBounds(130, 247, 220, 80);
		contentPane.add(btnLibrary);
		
		JButton btnShop = new JButton("天不平超市");
		btnShop.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnShop.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/shop.png")));
		btnShop.setBounds(130, 344, 220, 80);
		contentPane.add(btnShop);
		
		JButton btnOpencourse = new JButton("在线课堂");
		btnOpencourse.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/opencourse.png")));
		btnOpencourse.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnOpencourse.setBounds(374, 247, 220, 80);
		contentPane.add(btnOpencourse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/app.png")));
		lblNewLabel.setBounds(25, 12, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("关于我");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
		lblNewLabel_1.setBounds(871, 97, 122, 64);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		panel.setBounds(871, 175, 280, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("...");
		lblName.setBounds(104, 23, 149, 18);
		panel.add(lblName);
		
		JLabel lblCardNumber = new JLabel("...");
		lblCardNumber.setBounds(104, 54, 72, 18);
		panel.add(lblCardNumber);
		
		JLabel lblStudentNumber = new JLabel("...");
		lblStudentNumber.setBounds(104, 85, 149, 18);
		panel.add(lblStudentNumber);
		
		JLabel lblAcademy = new JLabel("...");
		lblAcademy.setBounds(104, 116, 149, 18);
		panel.add(lblAcademy);
		
		JLabel lblBalance = new JLabel("...");
		lblBalance.setBounds(104, 147, 139, 18);
		panel.add(lblBalance);
		
		JLabel lblBookLend = new JLabel("...");
		lblBookLend.setBounds(104, 178, 72, 18);
		panel.add(lblBookLend);
		
		
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(18, 23, 72, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("一卡通号：");
		label_1.setBounds(18, 54, 84, 18);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("学号：");
		label_2.setBounds(18, 85, 72, 18);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("院系：");
		label_3.setBounds(18, 116, 72, 18);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("一卡通余额：");
		label_4.setBounds(18, 147, 104, 18);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("图书馆借书：");
		label_5.setBounds(18, 178, 104, 18);
		panel.add(label_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/test.png")));
		lblNewLabel_2.setBounds(871, 404, 64, 64);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("今天是星期");
		lblNewLabel_3.setBounds(970, 435, 122, 18);
		contentPane.add(lblNewLabel_3);
		
		
		/**
		 * 新增，初始化控件内容
		 */
		lblName.setText(App.session.getStudent().getName());
		lblAcademy.setText(App.session.getStudent().getAcademy() + " - " + OtherUtils.getAcademyByNumber(App.session.getStudent().getAcademy()));
		lblBalance.setText(String.format("%.2f", App.session.getStudent().getBalance()));
		lblStudentNumber.setText(App.session.getStudent().getStudentNumber());
		
		Integer today = OtherUtils.getDay(
				ResponseUtils.getResponseByHash(
						new Request(App.connectionToServer, null, "tech.zxuuu.server.main.UtilsApi.getTrustedUnixTimeStamp", null).send())
				.getReturn(Long.class));
		
		
		
		System.out.println("today="+today);
		
	}
}
