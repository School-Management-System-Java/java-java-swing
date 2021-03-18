package Attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class frame6 {

	private JFrame frame;
	private String studentAttendID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame6 window = new frame6();
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
	public frame6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.getContentPane().setForeground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeleteStudentAttendance = new JLabel("Delete   Student   Attendance   ");
		lblDeleteStudentAttendance.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblDeleteStudentAttendance.setBounds(93, 62, 551, 39);
		frame.getContentPane().add(lblDeleteStudentAttendance);
		
		JLabel lblNewLabel = new JLabel("Attendance   ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(99, 241, 186, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JFormattedTextField txtAttendanceID = new JFormattedTextField();
		txtAttendanceID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAttendanceID.setBounds(323, 241, 280, 50);
		frame.getContentPane().add(txtAttendanceID);
		
		JButton btnNewButton = new JButton("Delete");
		Image img = new ImageIcon(this.getClass().getResource("../img/dlte.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
						"databaseName=ITP_Project;integratedSecurity=true;";

					// Declare the JDBC objects.
					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
			        	try {
			        		// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            		
			            		studentAttendID = txtAttendanceID.getText().toString();
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = "delete studentAttendance where studentAttendID=?";
			            		stmt = con.prepareStatement(SQL);
			            		stmt.setString(1, studentAttendID);
			            		JOptionPane.showMessageDialog(null, "Delete Successfully");
			            		stmt.execute();
			            
			            		// Iterate through the data in the result set and display it.
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e1) {
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(323, 396, 198, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Exit");
		Image img1 = new ImageIcon(this.getClass().getResource("../img/back.png")).getImage();
		button.setIcon(new ImageIcon(img1));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame1 Frame1 = new frame1();
				Frame1.main(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(906, 532, 168, 53);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("../img/att.png")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(726, 200, 266, 260);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("../img/delete1.png")).getImage();
		label_1.setIcon(new ImageIcon(img4));
		label_1.setBounds(665, 49, 93, 73);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("../img/bg.png")).getImage();
		label_2.setIcon(new ImageIcon(img5));
		label_2.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label_2);
		
		
	}

}
