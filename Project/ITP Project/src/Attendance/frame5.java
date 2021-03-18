package Attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import Common.DBConnection;
import Payment.page4;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class frame5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame5 window = new frame5();
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
	public frame5() {
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
		
		JLabel lblViewStudentAttendance = new JLabel("View  Student   Attendance   ");
		lblViewStudentAttendance.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblViewStudentAttendance.setBounds(47, 24, 516, 59);
		frame.getContentPane().add(lblViewStudentAttendance);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(47, 244, 180, 43);
		frame.getContentPane().add(lblStudentId);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField.setBounds(335, 241, 280, 50);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_1.setBounds(335, 336, 280, 50);
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_2.setBounds(335, 437, 280, 50);
		frame.getContentPane().add(formattedTextField_2);
		
		JLabel show_validation_here = new JLabel("");
		show_validation_here.setForeground(Color.RED);
		show_validation_here.setFont(new Font("Tahoma", Font.BOLD, 15));
		show_validation_here.setBounds(272, 122, 125, 26);
		frame.getContentPane().add(show_validation_here);
		
		JFormattedTextField testTextField = new JFormattedTextField();
		testTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		testTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				try {
					int i=Integer.parseInt(testTextField.getText());
					show_validation_here.setText("");
					
				} catch (NumberFormatException e) {
					show_validation_here.setText("Invalid number");
				}
			}
		});
		testTextField.setBounds(335, 142, 280, 50);
		frame.getContentPane().add(testTextField);
		
		JButton btnSearch = new JButton("Search");
		Image img = new ImageIcon(this.getClass().getResource("../img/search.png")).getImage();
		btnSearch.setIcon(new ImageIcon(img));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt;
				ResultSet rs;
				
				try {
					con = DBConnection.getDBConnection();
					
					String id = testTextField.getText().toString();
					
					String query = "select studentID,date,status from studentAttendance where studentAttendID=?";
					stmt = con.prepareStatement(query);
					stmt.setString(1, id);
					rs = stmt.executeQuery();
					
					ArrayList list = new ArrayList();
					
					while(rs.next()) {
						list.add(rs.getString("studentID"));
						list.add(rs.getString("date"));
						list.add(rs.getString("status"));
					}
					
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student Not Found!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if (list.get(0)!=null) {
							formattedTextField.setText(list.get(0).toString());
						}else {
							formattedTextField.setText("");
						}
						formattedTextField_1.setText(list.get(1).toString());
						formattedTextField_2.setText(list.get(2).toString());
					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(677, 139, 179, 53);
		frame.getContentPane().add(btnSearch);
		
		JButton btnEdit = new JButton("Edit");
		Image img2 = new ImageIcon(this.getClass().getResource("../img/update.png")).getImage();
		btnEdit.setIcon(new ImageIcon(img2));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt;
				//ResultSet rs;
				
				try {
					con = DBConnection.getDBConnection();
					
					String id = testTextField.getText().toString();
					String stID = formattedTextField.getText().toString();
					String date = formattedTextField_1.getText().toString();
					String status = formattedTextField_2.getText().toString();
					
					String query = "update studentAttendance set studentID=?,date=?,status=? where studentAttendID=?";
					stmt = con.prepareStatement(query);
					stmt.setString(1, stID);
					stmt.setString(2, date);
					stmt.setString(3, status);
					stmt.setString(4, id);
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Update Successfully!!!");
					
					frame.dispose();
					new frame5().main(null);
					
				}catch(Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Student ID not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setBackground(Color.LIGHT_GRAY);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(335, 547, 151, 53);
		frame.getContentPane().add(btnEdit);
		
		JButton btnExit = new JButton("Exit");
		Image img3 = new ImageIcon(this.getClass().getResource("../img/back.png")).getImage();
		btnExit.setIcon(new ImageIcon(img3));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame1 Frame1 = new frame1();
				Frame1.main(null);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(918, 547, 141, 53);
		frame.getContentPane().add(btnExit);
		
		JLabel lblAttendanceId = new JLabel("Attendance ID");
		lblAttendanceId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAttendanceId.setBounds(48, 144, 237, 43);
		frame.getContentPane().add(lblAttendanceId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(47, 332, 180, 43);
		frame.getContentPane().add(lblDate);
		
		JLabel lblAttendanceStatus = new JLabel("Attendance Status");
		lblAttendanceStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAttendanceStatus.setBounds(44, 433, 280, 43);
		frame.getContentPane().add(lblAttendanceStatus);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("../img/att.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(687, 212, 280, 264);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("../img/view.png")).getImage();
		label_1.setIcon(new ImageIcon(img4));
		label_1.setBounds(591, 11, 125, 83);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("../img/bg.png")).getImage();
		label_2.setIcon(new ImageIcon(img5));
		label_2.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label_2);
		
		
	}

}
