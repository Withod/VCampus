package tech.zxuuu.client.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

import tech.zxuuu.client.main.App;
import tech.zxuuu.entity.Manager;
import tech.zxuuu.entity.Student;
import tech.zxuuu.entity.Teacher;
import tech.zxuuu.entity.UserType;
import tech.zxuuu.net.Session;
import tech.zxuuu.util.SwingUtils;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

/**
 * 登陆界面GUI
 * 
 * @author z0gSh1u
 */
public class AuthGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AuthGUI frame = new AuthGUI();
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
	public AuthGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AuthGUI.class.getResource("/resources/assets/icon/fav.png")));
		setTitle("统一登录认证 - VCampus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pBody = new JPanel();
		contentPane.add(pBody, BorderLayout.CENTER);
		pBody.setLayout(null);
		
		JLabel lblUsername = new JLabel("用户名：");
		lblUsername.setBounds(531, 195, 60, 18);
		pBody.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("宋体", Font.PLAIN, 20));
		txtUsername.setBounds(605, 190, 190, 24);
		pBody.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("密码：");
		lblPassword.setBounds(531, 257, 45, 18);
		pBody.add(lblPassword);
		
		JLabel lblType = new JLabel("用户类型：");
		lblType.setBounds(531, 324, 75, 18);
		pBody.add(lblType);
		
		JRadioButton rdoStudent = new JRadioButton("学生");
		JRadioButton rdoTeacher = new JRadioButton("教师");
		JRadioButton rdoManager = new JRadioButton("管理员");
		rdoStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdoStudent.isSelected()) {
					rdoTeacher.setSelected(false);
					rdoManager.setSelected(false);
				}
			}
		});
		rdoTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdoTeacher.isSelected()) {
					rdoStudent.setSelected(false);
					rdoManager.setSelected(false);
				}
			}
		});
		rdoManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdoManager.isSelected()) {
					rdoTeacher.setSelected(false);
					rdoStudent.setSelected(false);
				}
			}
		});
		rdoStudent.setBounds(605, 320, 59, 27);
		pBody.add(rdoStudent);
		rdoTeacher.setBounds(670, 320, 59, 27);
		pBody.add(rdoTeacher);
		rdoManager.setBounds(735, 320, 73, 27);
		pBody.add(rdoManager);
		rdoStudent.setSelected(true);
		
		JButton btnLogin = new JButton("登陆");
		btnLogin.setIcon(new ImageIcon(AuthGUI.class.getResource("/resources/assets/icon/right-circle.png")));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 输入合法检查
				if (SwingUtils.isTxtEmpty(txtPassword) || SwingUtils.isTxtEmpty(txtUsername)) {
					SwingUtils.showError(null, "有字段为空！", "错误");
					return;
				}
				UserType type = null;
				if (rdoStudent.isSelected()) {
					type = UserType.STUDENT;
					Student res = AuthHelper.verifyStudent(txtUsername.getText(), txtPassword.getText());
					if (res != null) {
						SwingUtils.showMessage(null, "学生登陆成功！", "信息");
						// 填充App.session
						App.hasLogon = true;
						App.session = new Session(res);
						setVisible(false);
						// 要求界面路由
						App.requireRouting();
					} else {
						SwingUtils.showError(null, "密码错误，登陆失败！", "错误");
					}
				// -------------
				} else if (rdoTeacher.isSelected()) {
					type = UserType.TEACHER;
					Teacher res = AuthHelper.verifyTeacher(txtUsername.getText(), txtPassword.getText());
					if (res != null) {
						SwingUtils.showMessage(null, "欢迎您，"+res.getName()+" 教师！", "信息");
						App.hasLogon = true;
						App.session = new Session(res);
						setVisible(false);
						App.requireRouting();
					} else {
						SwingUtils.showError(null, "密码错误，登陆失败！", "错误");
					}
				// -------------
				} else if (rdoManager.isSelected()) {
					type = UserType.MANAGER;
					Manager res = AuthHelper.verifyManager(txtUsername.getText(), txtPassword.getText());
					if (res != null) {
						SwingUtils.showMessage(null, res.getManagerType().toString()+" 管理员登陆成功！", "信息");
						App.hasLogon = true;
						App.session = new Session(res);
						setVisible(false);
						App.requireRouting();
					} else {
						SwingUtils.showError(null, "密码错误，登陆失败！", "错误");
					}
				}
			}
		});
		
		btnLogin.setBounds(587, 371, 167, 85);
		pBody.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(605, 254, 190, 24);
		pBody.add(txtPassword);
		
		JLabel leftPicture = new JLabel("");
		leftPicture.setHorizontalAlignment(SwingConstants.CENTER);
		leftPicture.setBounds(0, 0, 516, 511);
		leftPicture.setIcon(new ImageIcon(AuthGUI.class.getResource("/resources/assets/picture/seu-1.jpg")));
		pBody.add(leftPicture);
		
		JLabel label = new JLabel("统一登录认证");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		label.setBounds(557, 45, 233, 82);
		pBody.add(label);

	}
}
