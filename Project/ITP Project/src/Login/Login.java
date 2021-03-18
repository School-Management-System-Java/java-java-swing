package Login;

import java.awt.EventQueue;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import Common.AES;
import Common.DBConnection;
import Common.Temp;
import Main.Home;
import Main.Librarian;
import Main.Staff;
import Main.Student;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JPasswordField password;
	String un,pwd,encryptPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JFormattedTextField username = new JFormattedTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 22));
		username.setBounds(690, 219, 280, 53);
		frame.getContentPane().add(username);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		password.setBounds(690, 343, 280, 53);
		frame.getContentPane().add(password);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Image img1 = new ImageIcon(this.getClass().getResource("../image/Ok-icon.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection con = null;
				PreparedStatement cstmt = null;
				ResultSet rs = null;

				try {
					AES aes = new AES();
					
					con = DBConnection.getDBConnection();
					
					un = username.getText().toString();
					pwd = password.getText().toString();
					encryptPassword = aes.encrypt(pwd);
					
					
					String sql = "select username,type from userAccount where username=? and password=?";
					cstmt = con.prepareStatement(sql);
					cstmt.setString(1, un);
					cstmt.setString(2, encryptPassword);
					rs = cstmt.executeQuery();
					
					ArrayList list = new ArrayList();
					
					while(rs.next()) {
						list.add(rs.getString("username"));
						list.add(rs.getString("type"));
					}
					
					if (list.size() == 0) {
						JOptionPane.showMessageDialog(null, "You are not successfully Login!!!","Login Error",JOptionPane.ERROR_MESSAGE);
					} else {
						Temp temp = new Temp();
						temp.setUsername(list.get(0).toString());
						
						JOptionPane.showMessageDialog(null, "You are successfully Login!!!");
						frame.dispose();
						if (list.get(1).equals("A")) {
							Home home = new Home();
							home.setVisible(true);
						}else if (list.get(1).equals("L")) {
							Librarian librarian = new Librarian();
							librarian.setVisible(true);
						}else if (list.get(1).equals("S")) {
							Student student = new Student();
							student.setVisible(true);
						}else if (list.get(1).equals("N") || list.get(1).equals("T")) {
							Staff staff = new Staff();
							staff.setVisible(true);
						}
					}
					
				}

				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		btnLogin.setBounds(506, 442, 162, 53);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("../image/delete-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(img2));
		btnReset.setBounds(768, 442, 162, 53);
		frame.getContentPane().add(btnReset);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblLogin.setBounds(639, 49, 105, 53);
		frame.getContentPane().add(lblLogin);
		

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(461, 235, 115, 20);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(461, 357, 99, 20);
		frame.getContentPane().add(lblPassword);

		JLabel label_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("../image/user-login-icon.png")).getImage();
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(177, 188, 162, 208);
		frame.getContentPane().add(label_1);
		
		JLabel lblForgetPwd = new JLabel("ForgetPassword!!!");
		lblForgetPwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblForgetPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Please meet the adminstrator");
			}
		});
		lblForgetPwd.setBounds(808, 498, 142, 20);
		frame.getContentPane().add(lblForgetPwd);
		
		JLabel label = new JLabel("");
		Image bg = new ImageIcon(this.getClass().getResource("../image/bg.png")).getImage();
		label.setIcon(new ImageIcon(bg));
		label.setBounds(0, 0, 1078, 594);
		frame.getContentPane().add(label);
		
	}
}
