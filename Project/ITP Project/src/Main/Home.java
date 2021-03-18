package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom.Parent;

import Attendance.frame1;
import Common.opening;
import Common.opening_results;
import Exam.ExamMain;
import Hostel.SHome;
import Hostel.memberHome;
import Library.L_Main;
import Login.Login;
import Noticeboard.AddNotice;
import Noticeboard.NoticeMain;
import Parent.AddParent;
import Parent.ParentMain;
import Payment.page1;
import Result_management.exam_content;
import Staff.Main;
import Student.StudentMain;
import UserAccount.UserAccountMain;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel iconClass = new JLabel("");
		iconClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				opening op = new opening();
				op.main(null);
			}
		});
		Image classImg = new ImageIcon(this.getClass().getResource("../Image/class-icon.png")).getImage();
		iconClass.setIcon(new ImageIcon(classImg));
		iconClass.setBounds(915, 390, 136, 141);
		contentPane.add(iconClass);

		JLabel iconPayment = new JLabel("");
		iconPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				page1 payment = new page1();
				payment.main(null);
			}
		});
		Image paymentImg = new ImageIcon(this.getClass().getResource("../Image/payment-icon.png")).getImage();
		iconPayment.setIcon(new ImageIcon(paymentImg));
		iconPayment.setBounds(728, 172, 162, 128);
		contentPane.add(iconPayment);

		JLabel iconParent = new JLabel("");
		Image parentImg = new ImageIcon(this.getClass().getResource("../Image/parent-icon.png")).getImage();
		iconParent.setIcon(new ImageIcon(parentImg));
		iconParent.setBounds(220, 403, 128, 128);
		contentPane.add(iconParent);
		iconParent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ParentMain parent = new ParentMain();
				parent.setVisible(true);
			}
		});

		JLabel iconNotice = new JLabel("");
		Image noticeImg = new ImageIcon(this.getClass().getResource("../Image/notice-icon.png")).getImage();
		iconNotice.setIcon(new ImageIcon(noticeImg));
		iconNotice.setBounds(33, 390, 136, 128);
		contentPane.add(iconNotice);
		iconNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				NoticeMain notice = new NoticeMain();
				notice.setVisible(true);
			}
		});

		JLabel iconHostel = new JLabel("");
		Image hostelImg = new ImageIcon(this.getClass().getResource("../Image/hostel-icon.png")).getImage();
		iconHostel.setIcon(new ImageIcon(hostelImg));
		iconHostel.setBounds(556, 390, 136, 128);
		contentPane.add(iconHostel);
		iconHostel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				memberHome hostel = new memberHome();
				hostel.setVisible(true);
			}
		});

		JLabel iconSubject = new JLabel("");
		Image subjectImg = new ImageIcon(this.getClass().getResource("../Image/subject-icon.png")).getImage();
		iconSubject.setIcon(new ImageIcon(subjectImg));
		iconSubject.setBounds(388, 403, 143, 128);
		contentPane.add(iconSubject);
		iconSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				SHome subjectHome = new SHome();
				subjectHome.main(null);
			}
		});

		JLabel iconExam = new JLabel("");
		iconExam.setBounds(915, 172, 136, 141);
		contentPane.add(iconExam);
		Image examImg = new ImageIcon(this.getClass().getResource("../image/exam-icon.png")).getImage();
		iconExam.setIcon(new ImageIcon(examImg));
		iconExam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ExamMain examMain = new ExamMain();
				examMain.setVisible(true);
			}
		});

		JLabel iconResult = new JLabel("");
		iconResult.setBounds(738, 390, 133, 141);
		contentPane.add(iconResult);
		Image resultImg = new ImageIcon(this.getClass().getResource("../Image/result-icon.png")).getImage();
		iconResult.setIcon(new ImageIcon(resultImg));
		iconResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				opening_results op = new opening_results();
				op.setVisible(true);
			}
		});

		JLabel iconUserAccount = new JLabel("");
		iconUserAccount.setIcon(new ImageIcon(this.getClass().getResource("../image/login-icon.png")));
		iconUserAccount.setBounds(385, 172, 143, 128);
		contentPane.add(iconUserAccount);
		iconUserAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				UserAccountMain accountMain = new UserAccountMain();
				accountMain.setVisible(true);
			}
		});

		JLabel lblHome = new JLabel("School Management System");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblHome.setBounds(366, 47, 492, 42);
		contentPane.add(lblHome);

		JLabel iconStudent = new JLabel("");
		Image studentImg = new ImageIcon(this.getClass().getResource("../Image/student-icon.png")).getImage();
		iconStudent.setIcon(new ImageIcon(studentImg));
		iconStudent.setBounds(33, 179, 128, 135);
		contentPane.add(iconStudent);
		iconStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				StudentMain studentMain = new StudentMain();
				studentMain.setVisible(true);
			}
		});

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudent.setBounds(63, 330, 69, 20);
		contentPane.add(lblStudent);

		JLabel lblUserAccount = new JLabel("User Account");
		lblUserAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserAccount.setBounds(395, 330, 133, 20);
		contentPane.add(lblUserAccount);

		JLabel iconStaff = new JLabel("");
		iconStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Main staffMain = new Main();
				staffMain.setVisible(true);
			}
		});
		iconStaff.setBounds(210, 172, 128, 135);
		contentPane.add(iconStaff);
		Image staffImg = new ImageIcon(this.getClass().getResource("../Image/staff-icon.png")).getImage();
		iconStaff.setIcon(new ImageIcon(staffImg));

		JLabel iconLibrary = new JLabel("");
		iconLibrary.setBounds(543, 172, 136, 135);
		contentPane.add(iconLibrary);
		Image libraryImg = new ImageIcon(this.getClass().getResource("../Image/library-icon.png")).getImage();
		iconLibrary.setIcon(new ImageIcon(libraryImg));
		iconLibrary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				L_Main libraryMain = new L_Main();
				libraryMain.setVisible(true);
			}
		});

		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaff.setBounds(254, 330, 69, 20);
		contentPane.add(lblStaff);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibrary.setBounds(576, 330, 69, 20);
		contentPane.add(lblLibrary);

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment.setBounds(745, 330, 90, 20);
		contentPane.add(lblPayment);

		JLabel lblNoticeboard = new JLabel("Noticeboard");
		lblNoticeboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoticeboard.setBounds(43, 548, 126, 20);
		contentPane.add(lblNoticeboard);

		JLabel lblParent = new JLabel("Parent");
		lblParent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParent.setBounds(254, 548, 69, 20);
		contentPane.add(lblParent);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject.setBounds(416, 547, 69, 20);
		contentPane.add(lblSubject);

		JLabel lblHostel = new JLabel("Hostel");
		lblHostel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHostel.setBounds(597, 548, 69, 20);
		contentPane.add(lblHostel);

		JLabel lblExam = new JLabel("Exam");
		lblExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExam.setBounds(967, 330, 69, 20);
		contentPane.add(lblExam);

		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResult.setBounds(769, 548, 56, 20);
		contentPane.add(lblResult);

		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(967, 548, 69, 20);
		contentPane.add(lblClass);

		JLabel iconLogo = new JLabel("");
		iconLogo.setIcon(new ImageIcon(Home.class.getResource("/image/arafa_logo.jpg")));
		iconLogo.setBounds(43, 16, 143, 116);
		contentPane.add(iconLogo);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.main(null);
			}
		});
		btnLogOut.setBounds(920, 16, 143, 51);
		contentPane.add(btnLogOut);

		JLabel iconBG = new JLabel("");
		iconBG.setIcon(new ImageIcon(Home.class.getResource("/image/bg.png")));
		iconBG.setBounds(0, 0, 1078, 594);
		contentPane.add(iconBG);
	}
}
