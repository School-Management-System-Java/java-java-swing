package Attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class frame3 {

	private JFrame frame;
	String studentAttendID,studentID,date,status; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 window = new frame3();
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
	public frame3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Attendance   Marking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(28, 22, 397, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel txtAttendanceID = new JLabel("Attendance  ID");
		txtAttendanceID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAttendanceID.setBounds(28, 133, 280, 50);
		frame.getContentPane().add(txtAttendanceID);
		
		JLabel txtStudentID = new JLabel("Student ID");
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStudentID.setBounds(28, 217, 163, 31);
		frame.getContentPane().add(txtStudentID);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(28, 289, 138, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel txtStatus = new JLabel("Attendance  Status");
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStatus.setBounds(28, 439, 261, 52);
		frame.getContentPane().add(txtStatus);
		
		JLabel txtDate = new JLabel("Date");
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDate.setBounds(28, 525, 180, 50);
		frame.getContentPane().add(txtDate);
		
		JFormattedTextField id = new JFormattedTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id.setBounds(305, 135, 280, 50);
		frame.getContentPane().add(id);
		
		JFormattedTextField sid = new JFormattedTextField();
		sid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sid.setBounds(305, 209, 280, 50);
		frame.getContentPane().add(sid);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_2.setBounds(305, 281, 280, 50);
		frame.getContentPane().add(formattedTextField_2);
		
		JFormattedTextField st = new JFormattedTextField();
		st.setFont(new Font("Tahoma", Font.PLAIN, 20));
		st.setBounds(305, 441, 280, 50);
		frame.getContentPane().add(st);
		
		JFormattedTextField dt = new JFormattedTextField();
		dt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dt.setBounds(305, 527, 280, 50);
		frame.getContentPane().add(dt);
		
		JButton btnBack = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("../img/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame1 Frame1 = new frame1();
				Frame1.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(926, 538, 131, 53);
		frame.getContentPane().add(btnBack);
		
		JButton btnSubmit = new JButton("Submit");
		Image img1 = new ImageIcon(this.getClass().getResource("../img/save.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img1));
		btnSubmit.addActionListener(new ActionListener() {
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
	            		
	            		studentAttendID = id.getText().toString();
	            		studentID = sid.getText().toString();
	            		date = dt.getText().toString();
	            		status = st.getText().toString();
	            
	            		// Create and execute an SQL statement that returns some data.
	            		String SQL = "insert into studentAttendance values(?,?,?,?)";
	            		stmt = con.prepareStatement(SQL);
	            		stmt.setString(1, studentAttendID);
	            		stmt.setString(2, studentID);
	            		stmt.setString(3, date);
	            		stmt.setString(4, status);
	            		JOptionPane.showMessageDialog(null, "Insert Successfully");
	            		stmt.execute();
	            
	            		// Iterate through the data in the result set and display it.
	        	}
	        
			// Handle any errors that may have occurred.
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
			}
		});
		
		
	
		
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(644, 539, 209, 53);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(28, 370, 138, 30);
		frame.getContentPane().add(lblClass);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField.setBounds(305, 362, 280, 50);
		frame.getContentPane().add(formattedTextField);
		
		JLabel label = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("../img/att.png")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(712, 133, 289, 336);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("../img/mark.png")).getImage();
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(435, 23, 105, 72);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("../img/bg.png")).getImage();
		label_2.setIcon(new ImageIcon(img4));
		label_2.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label_2);
		
		
	}
}
