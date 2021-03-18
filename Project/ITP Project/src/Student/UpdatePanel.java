package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.toedter.calendar.JDateChooser;

import Common.DBConnection;
import Common.Temp;

public class UpdatePanel extends JPanel {

	private ButtonGroup genderGroup;
	private String fName, lName, name, gender, dob, mobile, homePhone, email, joinedDate;
	private String studentID;

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(348, 146, 104, 50);
		add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(348, 218, 115, 50);
		add(lblLastName);

		JLabel lblNameWithInitial = new JLabel("Name with Initial");
		lblNameWithInitial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameWithInitial.setBounds(348, 299, 158, 50);
		add(lblNameWithInitial);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(348, 371, 137, 50);
		add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(348, 447, 89, 50);
		add(lblGender);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNo.setBounds(348, 522, 104, 50);
		add(lblMobileNo);

		JLabel lblHomePhoneNo = new JLabel("Home Phone No.");
		lblHomePhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHomePhoneNo.setBounds(348, 598, 158, 50);
		add(lblHomePhoneNo);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailAddress.setBounds(348, 674, 137, 50);
		add(lblEmailAddress);

		JLabel lblJoinedDate = new JLabel("Joined Date");
		lblJoinedDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoinedDate.setBounds(348, 751, 137, 50);
		add(lblJoinedDate);

		JFormattedTextField txtFName = new JFormattedTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFName.setBounds(537, 143, 280, 50);
		add(txtFName);

		JLabel lblRegisterStudent = new JLabel("Register Student");
		lblRegisterStudent.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblRegisterStudent.setBounds(423, 47, 307, 41);
		add(lblRegisterStudent);

		JFormattedTextField txtLName = new JFormattedTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLName.setBounds(537, 219, 280, 50);
		add(txtLName);

		JFormattedTextField txtName = new JFormattedTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(537, 295, 280, 50);
		add(txtName);

		JFormattedTextField txtMobileNo = new JFormattedTextField();
		txtMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMobileNo.setBounds(537, 523, 280, 50);
		add(txtMobileNo);

		JFormattedTextField txtHomePhone = new JFormattedTextField();
		txtHomePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHomePhone.setBounds(537, 599, 280, 50);
		add(txtHomePhone);

		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(537, 675, 280, 50);
		add(txtEmail);

		JDateChooser dateBirth = new JDateChooser();
		dateBirth.setDateFormatString("yyyy-MM-dd");
		dateBirth.setBounds(537, 371, 280, 50);
		add(dateBirth);

		JDateChooser dateJoined = new JDateChooser();
		dateJoined.setDateFormatString("yyyy-MM-dd");
		dateJoined.setBounds(537, 751, 280, 50);
		add(dateJoined);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnMale.setBounds(538, 447, 77, 50);
		add(rdbtnMale);
		rdbtnMale.setActionCommand("M");

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFemale.setBounds(631, 447, 125, 50);
		add(rdbtnFemale);
		rdbtnFemale.setActionCommand("F");

		genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getDBConnection();

			Temp temp = new Temp();
			studentID = temp.getStudentID();

			String sql = "select fName,lName,nameWithInitial,dob,gender,mobileNo,homePhone,email,joinedDate from student where studentID=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentID);
			rs = stmt.executeQuery();

			ArrayList list = new ArrayList();

			while (rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
			}

			Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(list.get(3).toString());
			Date joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(list.get(8).toString());

			txtFName.setText(list.get(0).toString());
			txtLName.setText(list.get(1).toString());
			txtName.setText(list.get(2).toString());
			dateBirth.setDate(birthDate);
			String gender = list.get(4).toString();
			if (gender.equals("M")) {
				genderGroup.setSelected(rdbtnMale.getModel(), true);
			} else {
				genderGroup.setSelected(rdbtnFemale.getModel(), true);
			}
			txtMobileNo.setText(list.get(5).toString());
			txtHomePhone.setText(list.get(6).toString());
			txtEmail.setText(list.get(7).toString());
			dateJoined.setDate(joinDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				CallableStatement cstmt = null;

				try {
					// Establish the connection.
					con = DBConnection.getDBConnection();

					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

					fName = txtFName.getText().toString();
					lName = txtLName.getText().toString();
					name = txtName.getText().toString();
					dob = df.format(dateBirth.getDate());
					gender = genderGroup.getSelection().getActionCommand();
					mobile = txtMobileNo.getText().toString();
					homePhone = txtHomePhone.getText().toString();
					email = txtEmail.getText().toString();
					joinedDate = df.format(dateJoined.getDate());
					// Execute a stored procedure that returns some data.

					JOptionPane.showMessageDialog(null, "Successfully Updated!!!");

					cstmt = con.prepareCall("{call dbo.udpUpdateStudent(?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, studentID);
					cstmt.setString(2, fName);
					cstmt.setString(3, lName);
					cstmt.setString(4, name);
					cstmt.setString(5, dob);
					cstmt.setString(6, gender);
					cstmt.setString(7, mobile);
					cstmt.setString(8, homePhone);
					cstmt.setString(9, email);
					cstmt.setString(10, joinedDate);
					cstmt.executeQuery();

					// Iterate through the data in the result set and display it.
				}

				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdateStudent.setBounds(379, 868, 179, 53);
		add(btnUpdateStudent);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentMain studentMain = new StudentMain();
				studentMain.setVisible(true);
			}
		});
		btnCancel.setBounds(672, 868, 115, 53);
		add(btnCancel);

		JLabel bgImg = new JLabel("");
		bgImg.setIcon(new ImageIcon(StudentPanel.class.getResource("/image/bg.png")));
		bgImg.setBounds(0, 0, 1101, 948);
		add(bgImg);

	}

}
