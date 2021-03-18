package Student;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import Common.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentPanel extends JPanel {

	private JDateChooser dateJoined, dateBirth;
	private ButtonGroup genderGroup;
	private String fName, lName, name, gender, dob, mobile, homePhone, email, joinedDate;
	private final String numaricExp = "/^[0-9]+$/";

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
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

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(414, 462, 23, 20);
		add(label);

		JLabel chkFName = new JLabel("");
		chkFName.setBounds(537, 193, 280, 20);
		add(chkFName);

		JLabel chkLName = new JLabel("");
		chkLName.setBounds(537, 269, 280, 20);
		add(chkLName);

		JLabel chkName = new JLabel("");
		chkName.setBounds(537, 344, 280, 20);
		add(chkName);

		JLabel chkMobile = new JLabel("");
		chkMobile.setBounds(537, 573, 280, 20);
		add(chkMobile);

		JLabel chkHome = new JLabel("");
		chkHome.setBounds(537, 649, 280, 20);
		add(chkHome);

		JLabel chkEmail = new JLabel("");
		chkEmail.setBounds(537, 723, 280, 20);
		add(chkEmail);

		JLabel chkDob = new JLabel("");
		chkDob.setBounds(537, 419, 280, 20);
		add(chkDob);

		JLabel chkJoin = new JLabel("");
		chkJoin.setBounds(537, 801, 280, 20);
		add(chkJoin);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(447, 235, 23, 20);
		add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(499, 316, 23, 20);
		add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(466, 388, 23, 20);
		add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(499, 615, 23, 20);
		add(label_4);

		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(462, 768, 23, 20);
		add(label_5);

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

		dateBirth = new JDateChooser();
		dateBirth.setBounds(537, 371, 280, 50);
		add(dateBirth);

		dateJoined = new JDateChooser();
		dateJoined.setBounds(537, 751, 280, 50);
		add(dateJoined);

		JFormattedTextField txtMobileNo = new JFormattedTextField();
		txtMobileNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String no = txtMobileNo.getText().toString();

				if (no.equals("")) {
					chkMobile.setText("");
				} else if (no.length() != 10) {
					chkMobile.setForeground(Color.RED);
					chkMobile.setText("Enter 10 numbers");
				} else {
					chkMobile.setText("");
				}
			}
		});
		txtMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMobileNo.setBounds(537, 523, 280, 50);
		add(txtMobileNo);

		JFormattedTextField txtHomePhone = new JFormattedTextField();
		txtHomePhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String no = txtHomePhone.getText().toString();

				if (no.length() != 10) {
					chkHome.setForeground(Color.RED);
					chkHome.setText("Enter 10 numbers");
				} else
					chkHome.setText("");
			}
		});
		txtHomePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHomePhone.setBounds(537, 599, 280, 50);
		add(txtHomePhone);

		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(537, 675, 280, 50);
		add(txtEmail);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

				fName = txtFName.getText().toString();
				lName = txtLName.getText().toString();
				name = txtName.getText().toString();
				gender = genderGroup.getSelection().getActionCommand();
				mobile = txtMobileNo.getText().toString();
				homePhone = txtHomePhone.getText().toString();
				email = txtEmail.getText().toString();

				if (lName.equals("") || homePhone.equals("") || name.equals("") || dateBirth.getDate() == null
						|| dateJoined.getDate() == null || genderGroup.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "* fields are required!!!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (chkMobile.equals("Enter 10 numbers") || chkHome.equals("Enter 10 numbers")) {
					JOptionPane.showMessageDialog(null, "Please correct the error", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Connection con = null;
					CallableStatement cstmt = null;

					dob = df.format(dateBirth.getDate());
					joinedDate = df.format(dateJoined.getDate());

					try {
						// Establish the connection.
						con = DBConnection.getDBConnection();

						cstmt = con.prepareCall("{call dbo.udpInsertStudent(?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1, fName);
						cstmt.setString(2, lName);
						cstmt.setString(3, name);
						cstmt.setString(4, dob);
						cstmt.setString(5, gender);
						cstmt.setString(6, mobile);
						cstmt.setString(7, homePhone);
						cstmt.setString(8, email);
						cstmt.setString(9, joinedDate);
						cstmt.execute();

						JOptionPane.showMessageDialog(null, "Successfully Inserted!!!");

						setVisible(false);
						RegisterStudent rs = new RegisterStudent();
						rs.setVisible(true);

					}

					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAddStudent.setBounds(348, 852, 150, 60);
		add(btnAddStudent);

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
		// rdbtnMale.setSelected(true);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentMain studentMain = new StudentMain();
				studentMain.setVisible(true);
			}
		});
		btnCancel.setBounds(677, 852, 150, 60);
		add(btnCancel);

		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date birth = null, join = null;

				try {
					birth = new SimpleDateFormat("yyyy-MM-dd").parse("1999-01-29");
					join = new SimpleDateFormat("yyyy-MM-dd").parse("2004-01-04");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				txtFName.setText("Mohamed Alhar");
				txtLName.setText("Ahmad Ahkam");
				txtName.setText("M.A.A. Ahkam");
				dateBirth.setDate(birth);
				genderGroup.setSelected(rdbtnMale.getModel(), true);
				txtMobileNo.setText("0766747147");
				txtHomePhone.setText("0777667212");
				txtEmail.setText("maaahkam@gmail.com");
				dateJoined.setDate(join);
			}
		});
		btnDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDemo.setBounds(513, 852, 150, 60);
		add(btnDemo);

		JLabel bgImg = new JLabel("");
		bgImg.setIcon(new ImageIcon(StudentPanel.class.getResource("/image/bg.png")));
		bgImg.setBounds(0, 0, 1100, 948);
		add(bgImg);
	}
}
