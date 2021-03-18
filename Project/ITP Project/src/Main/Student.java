package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;
import Student.StudentProfile;
import UserAccount.PasswordChange;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconProfile = new JLabel("");
		iconProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				StudentProfile sf = new StudentProfile();
				sf.setVisible(true);
			}
		});
		iconProfile.setIcon(new ImageIcon(Student.class.getResource("/image/profile-icon.png")));
		iconProfile.setBounds(154, 215, 128, 112);
		contentPane.add(iconProfile);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setBounds(174, 335, 91, 20);
		contentPane.add(lblMyProfile);
		
		JLabel iconUserAccount = new JLabel("");
		iconUserAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				PasswordChange pwdChg = new PasswordChange();
				pwdChg.setVisible(true);
			}
		});
		iconUserAccount.setIcon(new ImageIcon(Student.class.getResource("/image/login-icon.png")));
		iconUserAccount.setBounds(462, 194, 143, 128);
		contentPane.add(iconUserAccount);
		
		JLabel label_3 = new JLabel("User Account");
		label_3.setBounds(488, 338, 105, 20);
		contentPane.add(label_3);
		
		JLabel iconNotice = new JLabel("");
		iconNotice.setIcon(new ImageIcon(Student.class.getResource("/image/notice-icon.png")));
		iconNotice.setBounds(35, 393, 136, 128);
		contentPane.add(iconNotice);
		
		JLabel label_5 = new JLabel("Noticeboard");
		label_5.setBounds(45, 524, 99, 20);
		contentPane.add(label_5);
		
		JLabel iconParent = new JLabel("");
		iconParent.setIcon(new ImageIcon(Student.class.getResource("/image/parent-icon.png")));
		iconParent.setHorizontalAlignment(SwingConstants.LEFT);
		iconParent.setBounds(318, 393, 128, 128);
		contentPane.add(iconParent);
		
		JLabel label_7 = new JLabel("Parent");
		label_7.setBounds(353, 535, 69, 20);
		contentPane.add(label_7);
		
		JLabel iconResult = new JLabel("");
		iconResult.setIcon(new ImageIcon(Student.class.getResource("/image/result-icon.png")));
		iconResult.setBounds(656, 393, 162, 141);
		contentPane.add(iconResult);
		
		JLabel label_9 = new JLabel("Result");
		label_9.setBounds(700, 535, 56, 20);
		contentPane.add(label_9);
		
		JLabel iconClass = new JLabel("");
		iconClass.setIcon(new ImageIcon(Student.class.getResource("/image/class-icon.png")));
		iconClass.setBounds(916, 380, 162, 141);
		contentPane.add(iconClass);
		
		JLabel label_11 = new JLabel("Class");
		label_11.setBounds(969, 524, 69, 20);
		contentPane.add(label_11);
		
		JLabel iconExam = new JLabel("");
		iconExam.setIcon(new ImageIcon(Student.class.getResource("/image/exam-icon.png")));
		iconExam.setBounds(819, 194, 136, 141);
		contentPane.add(iconExam);
		
		JLabel label_13 = new JLabel("Exam");
		label_13.setBounds(871, 354, 69, 20);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("School Management System");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_14.setBounds(408, 70, 392, 42);
		contentPane.add(label_14);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login login = new Login();
				login.main(null);
			}
		});
		btnLogOut.setBounds(895, 39, 143, 51);
		contentPane.add(btnLogOut);
		
		JLabel iconBG = new JLabel("");
		iconBG.setIcon(new ImageIcon(Student.class.getResource("/image/bg.png")));
		iconBG.setBounds(0, 0, 1078, 594);
		contentPane.add(iconBG);
	}
}
