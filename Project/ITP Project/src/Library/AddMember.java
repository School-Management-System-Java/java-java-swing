package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.microsoft.sqlserver.jdbc.*;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
public class AddMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	
	
	JFrame hh;

	static AddMember yy;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
					frame.setVisible(true);
					frame.setTitle("Add New Member");
					yy = new AddMember();
					yy.hh = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddMember() {
		
		AddMember.this.setTitle("Add New Member");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details to add a New Member");
		lblEnterTheFollowing.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblEnterTheFollowing.setBounds(233, 13, 637, 38);
		contentPane.add(lblEnterTheFollowing);
		
		JLabel lblNewLabel_2 = new JLabel("Member ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(178, 398, 154, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(434, 392, 463, 49);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("Save Data");
		
		button.setIcon(new ImageIcon(AddMember.class.getResource("/images/diskette.png")));
		button.setToolTipText("Save Data");
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setContentAreaFilled(false);
		button.setBounds(449, 488, 253, 102);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AddMember.this.dispose();
				new L_Main().setVisible(true);
				
			}
		});

		button_1.setIcon(new ImageIcon(AddMember.class.getResource("/images/back.png")));
		button_1.setToolTipText("Save Data");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(762, 488, 253, 102);
		contentPane.add(button_1);
		
		JComboBox membertypes = new JComboBox();
		membertypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		membertypes.setModel(new DefaultComboBoxModel(new String[] {"Staff", "Student"}));
		membertypes.setBounds(434, 117, 463, 49);
		contentPane.add(membertypes);
		
		JLabel lblMemberName = new JLabel("Student/Staff Name");
		lblMemberName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMemberName.setBounds(178, 244, 199, 31);
		contentPane.add(lblMemberName);
		
		JLabel lblZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzztypr = new JLabel("Type");
		lblZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzztypr.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzztypr.setBounds(178, 126, 154, 31);
		contentPane.add(lblZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzztypr);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String stdid = textField_2.getText();
				if(stdid.equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
					
					
				}else {
					String memberz = membertypes.getSelectedItem().toString();
					
					String memidsplit[] = textField.getText().split(",");
					
					String membername = memidsplit[0];
					String tableid = memidsplit[1];
					
					
					Date dd = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					String todaydate=sdf.format(dd);
					if(memberz.equals("Student")) {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						
						Statement stmtsearch = null;
						ResultSet rssearch = null;
						
						
				        	try {
				        		// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            		
				            		
				            		String sqlsearch="select * from member where memberID = '"+stdid+"' ";
				            		stmtsearch = con.createStatement();
				            		rssearch = stmtsearch.executeQuery(sqlsearch);
				            		if(rssearch.next()) {
				            			JOptionPane.showMessageDialog(rootPane, "This Member ID is Already Registered..!", "Error", JOptionPane.ERROR_MESSAGE);
				            		}else {
				            		// Create and execute an SQL statement that returns some data.
//				            		String SQL = "INSERT INTO [dbo].[member]\r\n" + 
//				            				"           ([memberID]\r\n" + 
//				            				"           ,[registeredDate]\r\n" + 
//				            				"           ,[typez])\r\n" + 
//				            				"     VALUES\r\n" + 
//				            				"           ('"+stdid+"', varchar(10),>\r\n" + 
//				            				"           ,<'"+dd+"', date,>\r\n" + 
//				            				"           ,<'"+memberz+"', varchar(233),>)";
				            		String SQL = "insert into member(memberID,registeredDate,typez) values('"+stdid+"','"+todaydate+"','"+memberz+"') ";
				            		stmt = con.createStatement();
				            		stmt.executeUpdate(SQL);
				            
				            		// Iterate through the data in the result set and display it.
//				            		
//				            		String sql2="UPDATE [dbo].[student]\r\n" + 
//				            				"   SET [libMemID] = <'"+stdid+"'>\r\n" + 
//				            				" WHERE [studentID] = <'"+tableid+"'>";
				            		
				            		String sql2= "update student SET libMemID ='"+stdid+"' where studentID='"+tableid+"' ";
				            		
				            		stmt2 = con.createStatement();
				            		stmt2.executeUpdate(sql2);
				            		
				            		JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully..!", "Done", JOptionPane.INFORMATION_MESSAGE);
				            		}
				            		
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception e) {
							e.printStackTrace();
						}
						
						
						
					}else {
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						
						
						Statement stmtsearch2 = null;
						ResultSet rssearch2 = null;
				        	try {
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
				        		String sqlsearch="select * from member where memberID = '"+stdid+"' ";
			            		stmtsearch2 = con.createStatement();
			            		rssearch2 = stmtsearch2.executeQuery(sqlsearch);
			            		if(rssearch2.next()) {
			            			JOptionPane.showMessageDialog(null, "This Member ID is Already Registered..!", "Error", JOptionPane.ERROR_MESSAGE);
			            		}else {
				        		// Establish the connection.
				        		
				            		// Create and execute an SQL statement that returns some data.
//				            		String SQL = "INSERT INTO [dbo].[member]\r\n" + 
//				            				"           ([memberID]\r\n" + 
//				            				"           ,[registeredDate]\r\n" + 
//				            				"           ,[typez])\r\n" + 
//				            				"     VALUES\r\n" + 
//				            				"           ('"+stdid+"', varchar(10),>\r\n" + 
//				            				"           ,<'"+dd+"', date,>\r\n" + 
//				            				"           ,<'"+memberz+"', varchar(233),>)";
				            		String SQL = "insert into member(memberID,registeredDate,typez) values('"+stdid+"','"+todaydate+"','"+memberz+"') ";
				            		stmt = con.createStatement();
				            		stmt.executeUpdate(SQL);
				            
				            		// Iterate through the data in the result set and display it.
				            		
//				            		String sql2="UPDATE [dbo].[staff]\r\n" + 
//				            				"   SET [libMemID] = <'"+stdid+"'>\r\n" + 
//				            				" WHERE [staffID] = <'"+tableid+"'>";
				            		String sql2= "update staff SET libMemID ='"+stdid+"' where staffID='"+tableid+"' ";
				            		stmt2 = con.createStatement();
				            		stmt2.executeUpdate(sql2);
				            		JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully..!", "Done", JOptionPane.INFORMATION_MESSAGE);
				            		AddMember.this.dispose();
				            		new AddMember().setVisible(true);
			            		}
			            		AddMember.this.dispose();
			            		new AddMember().setVisible(true);
				        	}
				        	
						// Handle any errors that may have occurred.
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					
			}}
		});
		
		JButton btnSearchMember = new JButton("Search Member");
		btnSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMember.this.dispose();
				new MemberDetailsSearch().setVisible(true);
			}
		});
		btnSearchMember.setIcon(new ImageIcon(AddMember.class.getResource("/images/search.png")));
		btnSearchMember.setToolTipText("Save Data");
		btnSearchMember.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearchMember.setContentAreaFilled(false);
		btnSearchMember.setBounds(73, 488, 314, 102);
		contentPane.add(btnSearchMember);
		JList list = new JList();
		list.setBounds(314, 340, 1, 1);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setVisible(false);
		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(list_1.getSelectedValue().toString().equals("") || list_1.getSelectedValue().toString() == null) {
						
					}else {
						String val =list_1.getSelectedValue().toString() ;
						if(val.equals("")) {
							
						}else {
							textField.setText(list_1.getSelectedValue().toString());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Selection", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog

				}
				
				// uda thiyana text feild ekata list eken select karana value eka set karanaw
			}
		});
		list_1.setBounds(434, 287, 463, 54);
		contentPane.add(list_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				// Combo box eken ganna value eka assign karaganna eka
				String memberz = membertypes.getSelectedItem().toString();
				
				if(textField.getText().equals("")) {
					list_1.setVisible(false);
				}else {
					
					list_1.setVisible(true);
				if(memberz.equals("Student")) {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

						// Declare the JDBC objects.
						Connection con = null;
						Statement stmt = null;
						ResultSet rs = null;
						
				        	try {
				        		// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            
				            		// Create and execute an SQL statement that returns some data.
				            		String SQL = "SELECT *	FROM [dbo].[student]";
				            		stmt = con.createStatement();
				            		rs = stmt.executeQuery(SQL);
				            
				            		// Iterate through the data in the result set and display it.
				            		Vector cc = new Vector();
				            		
				            		while (rs.next()) {
				            			
				            			
				            			
				            			cc.add(rs.getString(2) +","+ rs.getString(1));
				            			list_1.setListData(cc);// add data to vector and set the vector to list
				            			//System.out.println(rs.getString(3));
				            		}
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception e) {
							e.printStackTrace();
						}
				}else {
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

						// Declare the JDBC objects.
						Connection con = null;
						Statement stmt = null;
						ResultSet rs = null;
						
				        	try {
				        		// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            
				            		// Create and execute an SQL statement that returns some data.
				            		String SQL = "SELECT *	FROM [dbo].[staff]";
				            		stmt = con.createStatement();
				            		rs = stmt.executeQuery(SQL);
				            
				            		// Iterate through the data in the result set and display it.
				            		Vector cc = new Vector();
				            		while (rs.next()) {
				            			
				            			
				            			
				            			cc.add(rs.getString(2)+","+rs.getString(1));
				            			list_1.setListData(cc);
				            			//System.out.println(rs.getString(3));
				            		}
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception e) {
							e.printStackTrace();
						}
				}
				
				
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(434, 238, 463, 49);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddMember.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(-262, -557, 1344, 1379);
		contentPane.add(lblNewLabel);
		
		
	}
}
