package Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Common.DBConnection;
import Common.Temp;
import Main.Student;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProfile frame = new StudentProfile();
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
	public StudentProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblName.setBounds(440, 71, 319, 42);
		contentPane.add(lblName);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFullName.setBounds(75, 265, 127, 20);
		contentPane.add(lblFullName);

		JLabel lblNewLabel = new JLabel("Date of birth");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(75, 334, 127, 20);
		contentPane.add(lblNewLabel);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(75, 399, 69, 20);
		contentPane.add(lblGender);

		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNo.setBounds(568, 196, 134, 20);
		contentPane.add(lblMobileNo);

		JLabel lblHomephone = new JLabel("Home Phone No");
		lblHomephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHomephone.setBounds(568, 265, 160, 20);
		contentPane.add(lblHomephone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(568, 334, 69, 20);
		contentPane.add(lblEmail);

		JLabel lblJoinedDate = new JLabel("Joined Date");
		lblJoinedDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoinedDate.setBounds(568, 399, 134, 20);
		contentPane.add(lblJoinedDate);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(75, 196, 127, 20);
		contentPane.add(lblStudentId);

		JLabel lblStID = new JLabel("");
		lblStID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStID.setBounds(233, 196, 145, 20);
		contentPane.add(lblStID);

		JLabel lblNameFull = new JLabel("");
		lblNameFull.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameFull.setBounds(233, 265, 145, 20);
		contentPane.add(lblNameFull);

		JLabel lblDOB = new JLabel("");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOB.setBounds(233, 334, 182, 20);
		contentPane.add(lblDOB);

		JLabel lblGen = new JLabel("");
		lblGen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGen.setBounds(233, 399, 145, 20);
		contentPane.add(lblGen);

		JLabel lblMobile = new JLabel("");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobile.setBounds(780, 196, 153, 20);
		contentPane.add(lblMobile);

		JLabel lblHome = new JLabel("");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHome.setBounds(780, 265, 153, 20);
		contentPane.add(lblHome);

		JLabel lblEmai = new JLabel("");
		lblEmai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmai.setBounds(780, 334, 153, 20);
		contentPane.add(lblEmai);

		JLabel lblJoinDate = new JLabel("");
		lblJoinDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoinDate.setBounds(780, 399, 153, 20);
		contentPane.add(lblJoinDate);

		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(75, 466, 69, 20);
		contentPane.add(lblClass);

		JLabel lblParentName = new JLabel("Parent Name");
		lblParentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParentName.setBounds(568, 466, 134, 20);
		contentPane.add(lblParentName);

		JLabel lblClassname = new JLabel("");
		lblClassname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClassname.setBounds(233, 466, 167, 20);
		contentPane.add(lblClassname);

		JLabel lblParent = new JLabel("");
		lblParent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParent.setBounds(780, 466, 198, 20);
		contentPane.add(lblParent);

		Connection con = null;
		PreparedStatement stmt = null, pstmt = null;
		ResultSet rs = null, rset = null;

		try {
			con = DBConnection.getDBConnection();

			Temp temp = new Temp();

			String getSID = "select studentID from student where username=?";
			stmt = con.prepareStatement(getSID);
			stmt.setString(1, temp.getUsername());
			rs = stmt.executeQuery();

			ArrayList id = new ArrayList();

			while (rs.next()) {
				id.add(rs.getString("studentID"));
			}

			String stID = id.get(0).toString();
			temp.setStudentID(stID);

			String getStDetails = "select fName,lName,nameWithInitial,dob,gender,mobileNo,homePhone,email,joinedDate,classID,parentID from student where studentID=?";
			pstmt = con.prepareStatement(getStDetails);
			pstmt.setString(1, stID);
			rset = pstmt.executeQuery();

			ArrayList list = new ArrayList();

			while (rset.next()) {
				list.add(rset.getString("fName"));
				list.add(rset.getString("lName"));
				list.add(rset.getString("nameWithInitial"));
				list.add(rset.getString("dob"));
				list.add(rset.getString("gender"));
				list.add(rset.getString("mobileNo"));
				list.add(rset.getString("homePhone"));
				list.add(rset.getString("email"));
				list.add(rset.getString("joinedDate"));
				list.add(rset.getString("classID"));
				list.add(rset.getString("parentID"));
			}

			lblStID.setText(stID);
			lblNameFull.setText(list.get(0) + " " + list.get(1));
			lblName.setText(list.get(2).toString());
			lblDOB.setText(list.get(3).toString());

			if (list.get(4).equals("M"))
				lblGen.setText("Male");
			else if (list.get(4).equals("F"))
				lblGen.setText("Female");

			lblMobile.setText(list.get(5).toString());
			lblHome.setText(list.get(6).toString());
			lblEmai.setText(list.get(7).toString());
			lblJoinDate.setText(list.get(8).toString());
			lblClassname.setText(list.get(9).toString());
			lblParent.setText(list.get(10).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EditStudent es = new EditStudent();
				es.setVisible(true);
			}
		});
		btnEdit.setBounds(236, 528, 167, 50);
		contentPane.add(btnEdit);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Student st = new Student();
				st.setVisible(true);
			}
		});
		btnBack.setBounds(552, 528, 160, 50);
		contentPane.add(btnBack);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1102, 594);
		contentPane.add(label);
	}
}
