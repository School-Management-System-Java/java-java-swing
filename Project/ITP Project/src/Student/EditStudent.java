package Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Common.DBConnection;
import Common.Temp;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EditStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	public EditStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUpdateStudent.setBounds(409, 63, 266, 47);
		contentPane.add(lblUpdateStudent);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(229, 205, 118, 20);
		contentPane.add(lblStudentId);

		JLabel lblNameWithInitial = new JLabel("Name with initial");
		lblNameWithInitial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameWithInitial.setBounds(552, 205, 172, 20);
		contentPane.add(lblNameWithInitial);

		JLabel lblSID = new JLabel("");
		lblSID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSID.setBounds(396, 205, 115, 20);
		contentPane.add(lblSID);

		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(739, 205, 180, 20);
		contentPane.add(lblName);

		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNo.setBounds(131, 294, 115, 20);
		contentPane.add(lblMobileNo);

		JLabel lblHomePhoneNo = new JLabel("Home Phone No.");
		lblHomePhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHomePhoneNo.setBounds(278, 391, 187, 20);
		contentPane.add(lblHomePhoneNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(655, 294, 69, 20);
		contentPane.add(lblEmail);

		JFormattedTextField txtMobile = new JFormattedTextField();
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMobile.setBounds(278, 280, 201, 49);
		contentPane.add(txtMobile);

		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(739, 280, 201, 49);
		contentPane.add(txtEmail);

		JFormattedTextField txtHome = new JFormattedTextField();
		txtHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHome.setBounds(480, 377, 201, 49);
		contentPane.add(txtHome);

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getDBConnection();

			Temp temp = new Temp();
			String sID = temp.getStudentID();

			String getStDetails = "select nameWithInitial,mobileNo,homePhone,email from student where studentID=?";
			stmt = con.prepareStatement(getStDetails);
			stmt.setString(1, sID);
			rs = stmt.executeQuery();

			ArrayList list = new ArrayList();

			while (rs.next()) {
				list.add(rs.getString("nameWithInitial"));
				list.add(rs.getString("mobileNo"));
				list.add(rs.getString("homePhone"));
				list.add(rs.getString("email"));
			}

			lblSID.setText(sID);
			lblName.setText(list.get(0).toString());
			txtMobile.setText(list.get(1).toString());
			txtHome.setText(list.get(2).toString());
			txtEmail.setText(list.get(3).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					con = DBConnection.getDBConnection();

					Temp temp = new Temp();
					String sID = temp.getStudentID();

					String mobile = txtMobile.getText().toString();
					String homeNo = txtHome.getText().toString();
					String email = txtEmail.getText().toString();

					String updateQuery = "update student set mobileNo=?,homePhone=?,email=? where studentID=?";
					stmt = con.prepareStatement(updateQuery);
					stmt.setString(1, mobile);
					stmt.setString(2, homeNo);
					stmt.setString(3, email);
					stmt.setString(4, sID);
					stmt.execute();

					setVisible(false);
					StudentProfile sp = new StudentProfile();
					sp.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(254, 493, 180, 60);
		contentPane.add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentProfile sp = new StudentProfile();
				sp.setVisible(true);
			}
		});
		btnCancel.setBounds(623, 493, 180, 60);
		contentPane.add(btnCancel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditStudent.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
