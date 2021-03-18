package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class AddnewMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JFrame hh;

	static AddnewMember yy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddnewMember frame = new AddnewMember();
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
	public AddnewMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hostel MemberID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(91, 158, 190, 75);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char uu = arg0.getKeyChar();
				String txr = textField.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Hostel Member ID ", "Error", JOptionPane.ERROR_MESSAGE);
			}}
		});
		textField.setBounds(307, 169, 280, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Registered Date");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStudentId.setBounds(91, 246, 192, 75);
		contentPane.add(lblStudentId);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(307, 267, 280, 50);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Add Member");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textField.getText();
				
				//System.out.println(name);
				String dateChooser1=dateChooser.getDateFormatString();
				
				
			
				
				if(name.equals("")||dateChooser.getDate() == null) {
						
						
					
					JOptionPane.showMessageDialog(AddnewMember.this, "error", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
					
					
				}
				
				
				
				
				
				
				
				

else {
					
	
	try {
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		String da1 ="";
		if(dateChooser.getDate() == null) {
			da1="";
		}else {
			da1 = sd.format(dateChooser.getDate());
		}
						
						
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO hostel (hostelMemID, registeredDate)\r\n" + 
		            				"VALUES ('"+name+"', '"+da1+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					//Thread.sleep(500);
					
					textField.setText("");
					//dateChooser.("");;
	        		
	        		textField.grabFocus();

					
				}
				

				
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddnewMember.class.getResource("/imgz/diskette.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(307, 389, 384, 53);
		contentPane.add(btnNewButton); 
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			  
				AddnewMember.this.dispose();
				new memberHome().setVisible(true);
				
			}
		});
		btnBack.setIcon(new ImageIcon(AddnewMember.class.getResource("/imgz/back.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(307, 485, 384, 53);
		contentPane.add(btnBack);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddnewMember.class.getResource("/imgz/bg.png")));
		label.setBounds(0, 0, 1232, 853);
		contentPane.add(label);
	}
}
