package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SearchMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMember frame = new SearchMember();
					frame.setTitle("Search Member");
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
	public SearchMember() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchMember.class.getResource("/imgz/back1.jpg")));
		
		SearchMember.this.setTitle("Search Member");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Staff", "Student"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(395, 102, 463, 49);
		contentPane.add(comboBox);
		
		JLabel lblSelectMemberType = new JLabel("Select Member Type");
		lblSelectMemberType.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSelectMemberType.setBounds(139, 111, 211, 31);
		contentPane.add(lblSelectMemberType);
		
		JLabel lblSearchMemberDetails = new JLabel("Search member Details");
		lblSearchMemberDetails.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSearchMemberDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMemberDetails.setBounds(395, 13, 446, 49);
		contentPane.add(lblSearchMemberDetails);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMemberId.setBounds(139, 204, 154, 31);
		contentPane.add(lblMemberId);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					String memberz = comboBox.getSelectedItem().toString();
					String membid = textField.getText();
					
					if(membid.equals("")) {
            			JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Member ID", "Error", JOptionPane.ERROR_MESSAGE);

					}else {
					if(memberz.equals("Student")) {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						
						Statement stmtsearch = null;
						ResultSet rssearch = null;
						
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            		
	            		
	            		String sqlsearch="select * from student where libMemID = '"+membid+"' ";
	            		stmtsearch = con.createStatement();
	            		rs = stmtsearch.executeQuery(sqlsearch);
	            		if(rs.next()) {
	            			textField_1.setText(rs.getString("fName") + " "+rs.getString("lName"));
	            			textField_2.setText(rs.getString("dob"));
	            			textField_3.setText(rs.getString("mobileNo"));
	            			
	            			
	            		}else {
	            			JOptionPane.showMessageDialog(rootPane, "Invalid Member ID..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			textField_1.setText("");
	            			textField_2.setText("");
	            			textField_3.setText("");
	            		}
						
					}else {
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						
						Statement stmtsearch = null;
						ResultSet rssearch = null;
						
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            		
	            		
	            		String sqlsearch="select * from staff where libMemID = '"+membid+"' ";
	            		stmtsearch = con.createStatement();
	            		rs = stmtsearch.executeQuery(sqlsearch);
	            		if(rs.next()) {
	            			textField_1.setText(rs.getString("name"));
	            			textField_2.setText(rs.getString("dob"));
	            			textField_3.setText(rs.getString("mobileNo"));
	            			
	            			
	            		}else {
	            			JOptionPane.showMessageDialog(rootPane, "Invalid Member ID..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			textField_1.setText("");
	            			textField_2.setText("");
	            			textField_3.setText("");
	            		}
						
					}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(395, 188, 463, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblName.setBounds(139, 286, 154, 31);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(395, 270, 463, 47);
		contentPane.add(textField_1);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDateOfBirth.setBounds(139, 373, 154, 31);
		contentPane.add(lblDateOfBirth);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(395, 357, 463, 47);
		contentPane.add(textField_2);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblContactNumber.setBounds(139, 443, 154, 31);
		contentPane.add(lblContactNumber);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(395, 427, 463, 47);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Delete Member");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(SearchMember.class.getResource("/images/delete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField.getText().equals("")) {
            			JOptionPane.showMessageDialog(null, "Please Enter Valid Member..!", "Error", JOptionPane.ERROR_MESSAGE);

					}else {
						
						String memberidz = textField.getText();
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt2 = null;
						Statement stmt3 = null;
						Statement stmt4 = null;
						Statement stmt5 = null;
						Statement stmt = null;
						
						ResultSet rs2 = null;
						ResultSet rs3 = null;
						ResultSet rs4 = null;
						ResultSet rs5 = null;
						
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		
		            		String sql2 = "select * from rental where memberID='"+memberidz+"' and statuz='Pending'";
		            		stmt2 = con.createStatement();
		            		rs2=stmt2.executeQuery(sql2);	
		            		if(rs2.next()) {
		            			JOptionPane.showMessageDialog(null, "Cannot Delete Member Beacause This Member Has Pending Books..!", "Error", JOptionPane.ERROR_MESSAGE);
		            			
		            		}else {
		            			int i = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete this Member?");
		            			if(i == 0) {
		            				
		            				String memberz = comboBox.getSelectedItem().toString();
		            				if(memberz.equals("Student")) {
		            					
		            					String sqlupd2 = "delete from member where memberID = '"+memberidz+"'";
			    	            		stmt3 = con.createStatement();
			    	            		stmt3.executeUpdate(sqlupd2);
		            					
		            					String sqlupd = "update student set libMemID='null' where libMemID='"+memberidz+"' ";
			    	            		stmt2 = con.createStatement();
			    	            		stmt2.executeUpdate(sqlupd);
			    	            		
			    	            	
			    	            		
			    	            		
			    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
			    	            		SearchMember.this.dispose();
			    	            		new SearchMember().setVisible(true);
		            				}else {
		            					String sqlupd2 = "delete from member where memberID = '"+memberidz+"'";
			    	            		stmt5 = con.createStatement();
			    	            		stmt5.executeUpdate(sqlupd2);
			    	            		
		            					
		            					
		            					String sqlupd = "update staff set libMemID='null' where libMemID='"+memberidz+"' ";
			    	            		stmt4 = con.createStatement();
			    	            		stmt4.executeUpdate(sqlupd);
			    	            		
			    	            		
			    	            		
			    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
			    	            		SearchMember.this.dispose();
			    	            		new SearchMember().setVisible(true);
		            					
		            				}
		            				
		            			}
		            		}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(349, 518, 261, 72);
		contentPane.add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setIcon(new ImageIcon(SearchMember.class.getResource("/images/back.png")));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchMember.this.dispose();
				new MemberDetailsSearch().setVisible(true);
				
			}
		});
		btnGoBack.setBounds(686, 518, 225, 72);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchMember.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 1082, 603);
		contentPane.add(lblNewLabel);
	}
}
