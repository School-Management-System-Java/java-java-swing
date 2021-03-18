package Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Attendance.frame1;
import Main.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMain frame = new StudentMain();
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
	public StudentMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblStudent.setBounds(471, 60, 161, 60);
		contentPane.add(lblStudent);

		JLabel iconAdd = new JLabel("");
		iconAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				RegisterStudent rStudent = new RegisterStudent();
				rStudent.setVisible(true);
			}
		});
		Image addImg = new ImageIcon(this.getClass().getResource("../image/add-student-icon.png")).getImage();
		iconAdd.setIcon(new ImageIcon(addImg));
		iconAdd.setBounds(32, 213, 145, 141);
		contentPane.add(iconAdd);

		JLabel iconUpdate = new JLabel("");
		iconUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				StudentUpdateMain update = new StudentUpdateMain();
				update.setVisible(true);
			}
		});
		Image updateImg = new ImageIcon(this.getClass().getResource("../image/update-icon.png")).getImage();
		iconUpdate.setIcon(new ImageIcon(updateImg));
		iconUpdate.setBounds(432, 213, 151, 128);
		contentPane.add(iconUpdate);

		JLabel iconList = new JLabel("");
		iconList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				StudentList list = new StudentList();
				list.setVisible(true);
			}
		});
		Image listImg = new ImageIcon(this.getClass().getResource("../image/List-icon.png")).getImage();
		iconList.setIcon(new ImageIcon(listImg));
		iconList.setBounds(234, 200, 128, 141);
		contentPane.add(iconList);

		JLabel iconAttend = new JLabel("");
		iconAttend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame1 frame = new frame1();
				frame.main(null);
			}
		});
		Image addendImg = new ImageIcon(this.getClass().getResource("../image/attendance-student-icon.png")).getImage();
		iconAttend.setIcon(new ImageIcon(addendImg));
		iconAttend.setBounds(688, 241, 145, 100);
		contentPane.add(iconAttend);

		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddStudent.setBounds(42, 357, 119, 20);
		contentPane.add(lblAddStudent);

		JLabel lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateStudent.setBounds(432, 357, 151, 20);
		contentPane.add(lblUpdateStudent);

		JLabel lblListStudent = new JLabel("List Student");
		lblListStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListStudent.setBounds(244, 357, 119, 20);
		contentPane.add(lblListStudent);

		JLabel lblStudentAttendance = new JLabel("Student Attendance");
		lblStudentAttendance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentAttendance.setBounds(670, 357, 183, 20);
		contentPane.add(lblStudentAttendance);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setIcon(new ImageIcon(StudentMain.class.getResource("/image/Go-back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(453, 480, 204, 68);
		contentPane.add(btnBack);

		JLabel iconReport = new JLabel("");
		iconReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				StudentReportMain srm = new StudentReportMain();
				srm.setVisible(true);
			}
		});
		iconReport.setIcon(new ImageIcon(StudentMain.class.getResource("/image/reports-icon.png")));
		iconReport.setBounds(897, 206, 128, 135);
		contentPane.add(iconReport);

		JLabel lblReportGenrate = new JLabel("Report Genrate");
		lblReportGenrate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReportGenrate.setBounds(896, 357, 145, 20);
		contentPane.add(lblReportGenrate);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentMain.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
