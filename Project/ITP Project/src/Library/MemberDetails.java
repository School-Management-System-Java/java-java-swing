package Library;

import java.awt.BorderLayout;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetails frame = new MemberDetails();
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
	public MemberDetails() {
		
		MemberDetails.this.setTitle("Member Details ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(105, 417, 647, -328);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"id", "nsmr", "New column"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Create a variable for the connection string.
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
		            		String SQL = "SELECT [studentID]\r\n" + 
		            				"      ,[fName]\r\n" + 
		            				"      ,[lName]\r\n" + 
		            				"      ,[nameWithInitial]\r\n" + 
		            				"      ,[dob]\r\n" + 
		            				"      ,[gender]\r\n" + 
		            				"      ,[mobileNo]\r\n" + 
		            				"      ,[homePhone]\r\n" + 
		            				"      ,[email]\r\n" + 
		            				"      ,[joinedDate]\r\n" + 
		            				"      ,[classID]\r\n" + 
		            				"      ,[parentID]\r\n" + 
		            				"      ,[username]\r\n" + 
		            				"      ,[libMemID]\r\n" + 
		            				"      ,[hostelID]\r\n" + 
		            				"  FROM [dbo].[student]";
		            		stmt = con.createStatement();
		            		rs = stmt.executeQuery(SQL);
		            
		            		// Iterate through the data in the result set and display it.
		            		while (rs.next()) {
		            			System.out.println(rs.getString(4) + " " + rs.getString(6));
		            		}
		        	}
		        
				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
				}

				
				
				
				
			}
		});
		btnNewButton.setBounds(115, 66, 97, 25);
		contentPane.add(btnNewButton);
	}
}
