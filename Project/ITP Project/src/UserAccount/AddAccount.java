package UserAccount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Common.AES;
import Common.ComboBox;
import Common.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class AddAccount extends JFrame {

	private JPanel contentPane;

	String userName, password, type, id, name;
	Connection con;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount frame = new AddAccount();
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
	public AddAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddAccount = new JLabel("Add Account");
		lblAddAccount.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblAddAccount.setBounds(446, 16, 280, 51);
		contentPane.add(lblAddAccount);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(265, 114, 105, 20);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(265, 193, 102, 20);
		contentPane.add(lblPassword);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setBounds(265, 274, 69, 20);
		contentPane.add(lblType);

		JLabel checkUN = new JLabel("");
		checkUN.setBounds(543, 149, 315, 20);
		contentPane.add(checkUN);

		JLabel checkPwd = new JLabel("");
		checkPwd.setBounds(543, 230, 315, 20);
		contentPane.add(checkPwd);

		JLabel checkType = new JLabel("");
		checkType.setBounds(543, 309, 315, 20);
		contentPane.add(checkType);

		JLabel checkId = new JLabel("");
		checkId.setBounds(543, 390, 280, 20);
		contentPane.add(checkId);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pwd = txtPassword.getText().toString();

				if (checkPwd.getText().toString().equals("length should be 8-15 range characters")) {
					if (pwd.length() >= 8 && pwd.length() <= 15) {
						checkPwd.setText("");
					}
				}
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(543, 179, 280, 50);
		contentPane.add(txtPassword);

		JFormattedTextField txtUserName = new JFormattedTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					con = DBConnection.getDBConnection();

					String un = txtUserName.getText().toString();

					String sql = "select username from userAccount where username=?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, un);
					rs = stmt.executeQuery();

					ArrayList list = new ArrayList();

					while (rs.next()) {
						list.add(rs.getString(1));
					}

					if (checkUN.getText().toString().equals("length should be 6-12 range characters")) {
						if (un.length() >= 6 && un.length() <= 12)
							checkUN.setText("");
					} else if (!list.isEmpty()) {
						checkUN.setForeground(Color.RED);
						checkUN.setText("Username already used");
					} else {
						checkUN.setText("");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		txtUserName.setBounds(543, 99, 280, 50);
		contentPane.add(txtUserName);

		JFormattedTextField txtName = new JFormattedTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(543, 419, 280, 50);
		contentPane.add(txtName);
		txtName.setEditable(false);

		JLabel lblHisherName = new JLabel("His/Her Name");
		lblHisherName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHisherName.setBounds(265, 433, 147, 20);
		contentPane.add(lblHisherName);

		JFormattedTextField txtID = new JFormattedTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtID.setBounds(543, 339, 280, 50);
		contentPane.add(txtID);
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PreparedStatement stmt, stmt1, mt, mt1;
				ResultSet rs, rs1, rset, rset1;

				try {
					con = DBConnection.getDBConnection();

					id = txtID.getText().toString();

					String sql = "select nameWithInitial from student where studentID=?";
					stmt = con.prepareStatement(sql);
					con.setAutoCommit(false);
					stmt.setString(1, id);
					rs = stmt.executeQuery();

					ArrayList list = new ArrayList();

					while (rs.next()) {
						list.add(rs.getString(1));
					}

					String sql1 = "select name from staff where staffID=?";
					stmt1 = con.prepareStatement(sql1);
					con.setAutoCommit(false);
					stmt1.setString(1, id);
					rs1 = stmt1.executeQuery();

					ArrayList list1 = new ArrayList();

					while (rs1.next()) {
						list1.add(rs1.getString(1));
					}

					if ((list.size() == 0) && (list1.size() == 0)) {
						txtName.setText("Student or Staff not found!!!");
						lblHisherName.setText("His/Her Name");
					} else if (list.size() != 0) {
						String query = "select username from student where studentID=?";
						mt = con.prepareStatement(query);
						mt.setString(1, id);
						rset = mt.executeQuery();

						ArrayList un1 = new ArrayList();

						while (rset.next()) {
							un1.add(rset.getString("username"));
						}

						if (un1.get(0) != null) {
							checkId.setForeground(Color.RED);
							checkId.setText("Already ID has username!!!");
						} else {
							checkId.setText("");
						}

						txtName.setText(list.get(0).toString());
						lblHisherName.setText("Student Name");
					} else if (list1.size() != 0) {
						String query = "select username from staff where staffID=?";
						mt1 = con.prepareStatement(query);
						mt1.setString(1, id);
						rset1 = mt1.executeQuery();

						ArrayList un2 = new ArrayList();

						while (rset1.next()) {
							un2.add(rset1.getString("username"));
						}

						if (un2.get(0) != null) {
							checkId.setForeground(Color.RED);
							checkId.setText("Already ID has username!!!");
						} else {
							checkId.setText("");
						}

						txtName.setText(list1.get(0).toString());
						lblHisherName.setText("Staff Name");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JComboBox comboType = new JComboBox();
		comboType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboType.setBounds(544, 259, 280, 50);
		contentPane.add(comboType);

		comboType.addItem(new ComboBox("Student", "S"));
		comboType.addItem(new ComboBox("Academic Staff", "T"));
		comboType.addItem(new ComboBox("Librarian", "L"));

		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CallableStatement stmt = null;

				try {
					con = DBConnection.getDBConnection();

					userName = txtUserName.getText().toString();
					password = txtPassword.getText().toString();
					Object item = comboType.getSelectedItem();
					type = ((ComboBox) item).getValue();
					id = txtID.getText().toString();

					if (userName.equals("") || password.equals("") || id.equals("")) {
						JOptionPane.showMessageDialog(null, "All fields are required!!!");
					} else if (userName.length() < 6 || userName.length() > 12) {
						checkUN.setForeground(Color.RED);
						checkUN.setText("length should be 6-12 range characters");
						checkPwd.setText("");
					} else if (password.length() < 8 || password.length() > 15) {
						checkPwd.setForeground(Color.RED);
						checkPwd.setText("length should be 8-15 range characters");
						checkUN.setText("");
					} else if (checkId.getText().toString().equals("Already ID has username!!!")) {
						JOptionPane.showMessageDialog(null, "Cannot insert");
					} else {
						AES aes = new AES();

						String encryptPassword = aes.encrypt(password);

						stmt = con.prepareCall("{call dbo.udpInsertUserAccount(?,?,?,?)}");
						stmt.setString(1, userName);
						stmt.setString(2, encryptPassword);
						stmt.setString(3, type);
						stmt.setString(4, id);
						stmt.execute();

						JOptionPane.showMessageDialog(null, "New User Added!!!");

						setVisible(false);
						new AddAccount().setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAddAccount.setBounds(245, 502, 180, 60);
		contentPane.add(btnAddAccount);

		JLabel lblStudentIdStaff = new JLabel("Student/Staff Id");
		lblStudentIdStaff.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentIdStaff.setBounds(265, 353, 147, 20);
		contentPane.add(lblStudentIdStaff);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setIcon(new ImageIcon(AddAccount.class.getResource("/image/Go-back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				UserAccountMain accountMain = new UserAccountMain();
				accountMain.setVisible(true);
			}
		});
		btnBack.setBounds(661, 502, 180, 60);
		contentPane.add(btnBack);

		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserName.setText("Ahkam9408");
				txtPassword.setText("Ahkam9408");
				txtID.setText("10004");
			}
		});
		btnDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDemo.setBounds(451, 502, 180, 60);
		contentPane.add(btnDemo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddAccount.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);

	}
}
