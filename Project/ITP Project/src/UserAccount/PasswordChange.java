package UserAccount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Common.AES;
import Common.DBConnection;
import Common.Temp;
import Main.Student;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PasswordChange extends JFrame {

	private String password;

	private JPanel contentPane;
	private JPasswordField pwdCur;
	private JPasswordField pwdNew;
	private JPasswordField pwdCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
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
	public PasswordChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentPassword.setBounds(263, 179, 183, 20);
		contentPane.add(lblCurrentPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(263, 271, 167, 20);
		contentPane.add(lblNewPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(263, 364, 183, 20);
		contentPane.add(lblConfirmPassword);

		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblChangePassword.setBounds(383, 72, 319, 51);
		contentPane.add(lblChangePassword);

		JLabel lblErtxtcurpwd = new JLabel("");
		lblErtxtcurpwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErtxtcurpwd.setBounds(558, 213, 280, 31);
		contentPane.add(lblErtxtcurpwd);

		JLabel lblErtxtnewpwd = new JLabel("");
		lblErtxtnewpwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErtxtnewpwd.setBounds(558, 308, 280, 26);
		contentPane.add(lblErtxtnewpwd);

		JLabel lblErtxtconpwd = new JLabel("");
		lblErtxtconpwd.setBounds(558, 400, 280, 31);
		contentPane.add(lblErtxtconpwd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;

				String erCon = lblErtxtconpwd.getText().toString();
				String erCur = lblErtxtcurpwd.getText().toString();
				String erNew = lblErtxtnewpwd.getText().toString();

				try {
					if (erCon.equals("Passwords does not match") || erCur.equals("Current password not valid")) {
						JOptionPane.showMessageDialog(null, "Connot Update Account!!! fix the errors", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						con = DBConnection.getDBConnection();

						AES aes = new AES();
						Temp temp = new Temp();

						password = pwdNew.getText().toString();
						String encryptPwd = aes.encrypt(password);

						stmt = con.prepareCall("{call dbo.udpUpdateUserAccount(?,?)}");
						stmt.setString(1, temp.getUsername());
						stmt.setString(2, encryptPwd);
						stmt.execute();

						JOptionPane.showMessageDialog(null, "Record Update Successfully!!!");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(343, 504, 160, 53);
		contentPane.add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student st = new Student();
				st.setVisible(true);
			}
		});
		btnCancel.setBounds(605, 504, 183, 53);
		contentPane.add(btnCancel);

		pwdCur = new JPasswordField();
		pwdCur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdCur.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					con = DBConnection.getDBConnection();

					String curPassword = pwdCur.getText().toString();
					Temp temp = new Temp();
					AES aes = new AES();
					String encryptPwd = aes.encrypt(curPassword);

					// Create and execute an SQL statement that returns some data.

					String getPwdQuery = "select password from userAccount where username=?";
					stmt = con.prepareStatement(getPwdQuery);
					stmt.setString(1, temp.getUsername());
					rs = stmt.executeQuery();

					ArrayList list = new ArrayList();
					while (rs.next()) {
						list.add(rs.getString("password"));
					}

					if (!encryptPwd.equals(list.get(0))) {
						lblErtxtcurpwd.setForeground(Color.RED);
						lblErtxtcurpwd.setText("Current password not valid");
					} else {
						lblErtxtcurpwd.setText("");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		pwdCur.setBounds(558, 165, 280, 50);
		contentPane.add(pwdCur);

		pwdNew = new JPasswordField();
		pwdNew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newPassword = pwdNew.getText().toString();
				int pwdLen = newPassword.length();
				lblErtxtnewpwd.setForeground(Color.RED);

				if (pwdLen > 15 || pwdLen < 8) {
					lblErtxtnewpwd.setText("Password range 8-15");
				} else {
					lblErtxtnewpwd.setText("");
				}
			}
		});
		pwdNew.setBounds(558, 257, 280, 50);
		contentPane.add(pwdNew);

		pwdCon = new JPasswordField();
		pwdCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdCon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newPassword = pwdNew.getText().toString();
				String conPassword = pwdCon.getText().toString();

				if (!newPassword.equals(conPassword)) {
					lblErtxtconpwd.setForeground(Color.RED);
					lblErtxtconpwd.setText("Passwords does not match");
				} else {
					lblErtxtconpwd.setText("");
				}
			}
		});
		pwdCon.setBounds(558, 350, 280, 50);
		contentPane.add(pwdCon);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PasswordChange.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
