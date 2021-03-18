package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;
import UserAccount.PasswordChange;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Staff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconStudent = new JLabel("");
		iconStudent.setIcon(new ImageIcon(Staff.class.getResource("/image/Student-icon.png")));
		iconStudent.setBounds(33, 179, 128, 135);
		contentPane.add(iconStudent);
		
		JLabel label_1 = new JLabel("Student");
		label_1.setBounds(70, 330, 69, 20);
		contentPane.add(label_1);
		
		JLabel iconProfile = new JLabel("");
		iconProfile.setIcon(new ImageIcon(Staff.class.getResource("/image/profile-icon.png")));
		iconProfile.setBounds(195, 179, 128, 135);
		contentPane.add(iconProfile);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setBounds(233, 330, 69, 20);
		contentPane.add(lblMyProfile);
		
		JLabel iconUserAccount = new JLabel("");
		iconUserAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				PasswordChange pwdChange = new PasswordChange();
				pwdChange.setVisible(true);
			}
		});
		iconUserAccount.setIcon(new ImageIcon(Staff.class.getResource("/image/login-icon.png")));
		iconUserAccount.setBounds(354, 172, 143, 128);
		contentPane.add(iconUserAccount);
		
		JLabel label_5 = new JLabel("User Account");
		label_5.setBounds(364, 316, 105, 20);
		contentPane.add(label_5);
		
		JLabel iconExam = new JLabel("");
		iconExam.setIcon(new ImageIcon(Staff.class.getResource("/image/exam-icon.png")));
		iconExam.setBounds(915, 195, 136, 141);
		contentPane.add(iconExam);
		
		JLabel label_7 = new JLabel("Exam");
		label_7.setBounds(967, 355, 69, 20);
		contentPane.add(label_7);
		
		JLabel iconNotice = new JLabel("");
		iconNotice.setIcon(new ImageIcon(Staff.class.getResource("/image/notice-icon.png")));
		iconNotice.setBounds(25, 370, 136, 128);
		contentPane.add(iconNotice);
		
		JLabel label_9 = new JLabel("Noticeboard");
		label_9.setBounds(54, 499, 99, 20);
		contentPane.add(label_9);
		
		JLabel iconParent = new JLabel("");
		iconParent.setIcon(new ImageIcon(Staff.class.getResource("/image/parent-icon.png")));
		iconParent.setBounds(195, 380, 128, 128);
		contentPane.add(iconParent);
		
		JLabel label_11 = new JLabel("Parent");
		label_11.setBounds(233, 524, 69, 20);
		contentPane.add(label_11);
		
		JLabel iconSubject = new JLabel("");
		iconSubject.setIcon(new ImageIcon(Staff.class.getResource("/image/subject-icon.png")));
		iconSubject.setBounds(354, 390, 153, 128);
		contentPane.add(iconSubject);
		
		JLabel label_13 = new JLabel("Subject");
		label_13.setBounds(385, 534, 69, 20);
		contentPane.add(label_13);
		
		JLabel iconResult = new JLabel("");
		iconResult.setIcon(new ImageIcon(Staff.class.getResource("/image/result-icon.png")));
		iconResult.setBounds(709, 380, 162, 141);
		contentPane.add(iconResult);
		
		JLabel label_15 = new JLabel("Result");
		label_15.setBounds(769, 551, 56, 20);
		contentPane.add(label_15);
		
		JLabel iconClass = new JLabel("");
		iconClass.setIcon(new ImageIcon(Staff.class.getResource("/image/class-icon.png")));
		iconClass.setBounds(901, 391, 162, 141);
		contentPane.add(iconClass);
		
		JLabel label_18 = new JLabel("Class");
		label_18.setBounds(967, 548, 69, 20);
		contentPane.add(label_18);
		
		JButton button = new JButton("Log Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.main(null);
			}
		});
		button.setBounds(920, 16, 143, 51);
		contentPane.add(button);
		
		JLabel label_19 = new JLabel("School Management System");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_19.setBounds(433, 47, 392, 42);
		contentPane.add(label_19);
	}

}
