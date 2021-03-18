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
import Common.Temp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class UserAccountUpdateMain extends JFrame {

	private JPanel contentPane;
	private String userName, password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccountUpdateMain frame = new UserAccountUpdateMain();
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
	public UserAccountUpdateMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(310, 181, 173, 50);
		contentPane.add(lblUserName);

		JLabel lblResult = new JLabel("");
		lblResult.setBounds(509, 233, 280, 20);
		contentPane.add(lblResult);

		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMessage.setBounds(364, 345, 390, 38);
		contentPane.add(lblMessage);

		JFormattedTextField txtUserName = new JFormattedTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUserName.setBounds(509, 182, 280, 50);
		contentPane.add(txtUserName);
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					con = DBConnection.getDBConnection();

					userName = txtUserName.getText().toString();

					String sql = "select username from userAccount where username=?";
					stmt = con.prepareStatement(sql);
					con.setAutoCommit(false);
					stmt.setString(1, userName);
					rs = stmt.executeQuery();

					ArrayList list = new ArrayList();

					while (rs.next()) {
						list.add(rs.getString(1));
					}
					if (list.size() == 0) {
						lblResult.setForeground(Color.RED);
						lblResult.setText("User Name not found!!!");
						lblMessage.setText("");
					} else {
						Temp temp = new Temp();
						temp.setUserAccount(userName);
						lblResult.setForeground(Color.BLACK);
						lblResult.setText("User Name found!!!");
						lblMessage.setText("**Can delete user account without password**");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(310, 279, 122, 50);
		contentPane.add(lblPassword);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(509, 279, 280, 50);
		contentPane.add(txtPassword);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				CallableStatement stmt = null;

				try {
					if (lblResult.getText().equals("User Name not found!!!")) {
						JOptionPane.showMessageDialog(null, "Connot Update or Delete record!!!");
					} else {
						con = DBConnection.getDBConnection();

						password = txtPassword.getText().toString();
						AES aes = new AES();
						String encyptPwd = aes.encrypt(password);

						stmt = con.prepareCall("{call dbo.udpUpdateUserAccount(?,?)}");
						stmt.setString(1, userName);
						stmt.setString(2, encyptPwd);
						stmt.execute();

						JOptionPane.showMessageDialog(null, "Record Update Successfully!!!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(310, 412, 180, 53);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				CallableStatement stmt = null;

				try {
					if (lblResult.getText().equals("User Name not found!!!")) {
						JOptionPane.showMessageDialog(null, "Connot Update or Delete record!!!");
					} else {
						con = DBConnection.getDBConnection();

						stmt = con.prepareCall("{call dbo.udpDeleteUserAccount(?)}");
						stmt.setString(1, txtUserName.getText().toString());
						stmt.execute();

						JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(624, 412, 164, 53);
		contentPane.add(btnDelete);

		JLabel lblUpdateAccount = new JLabel("Update Account");
		lblUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUpdateAccount.setBounds(431, 50, 296, 38);
		contentPane.add(lblUpdateAccount);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserAccountMain accountMain = new UserAccountMain();
				accountMain.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(UserAccountUpdateMain.class.getResource("/image/Go-back-icon.png")));
		btnBack.setBounds(475, 507, 173, 50);
		contentPane.add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UserAccountUpdateMain.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
