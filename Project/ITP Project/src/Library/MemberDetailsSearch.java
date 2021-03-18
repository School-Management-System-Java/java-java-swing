package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class MemberDetailsSearch extends JFrame {

	private JPanel contentPane;
	private static JTable jtable1;
	private JComboBox comboBox;
	private JLabel lblSelectMemberType;
	private JButton btnGoBack;
	private JButton btnDeleteMember;
	/**
	 * @wbp.nonvisual location=328,704
	 */
	private final JButton button = new JButton(" Delete member");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetailsSearch frame = new MemberDetailsSearch();
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
	public MemberDetailsSearch() {
		button.setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MemberDetailsSearch.class.getResource("/imgz/img.png")));
		
		MemberDetailsSearch.this.setTitle("Search Member");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchMemberDetails = new JLabel(" Search Member Details");
		lblSearchMemberDetails.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSearchMemberDetails.setBounds(375, 13, 414, 53);
		contentPane.add(lblSearchMemberDetails);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(42, 175, 953, 291);
		contentPane.add(scrollPane);
		
		jtable1 = new JTable();
		jtable1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jtable1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Member Id", "Member Name", "Date Of Birth", "Contact Number"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jtable1);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String memberz = comboBox.getSelectedItem().toString();
					//System.out.print(memberz);
					if(memberz.equals("Student")) {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						
						
						Statement stmtsearch = null;
						Statement stmtsearch2 = null;
						ResultSet rs = null;
						ResultSet rs2 = null;
						
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            		
	            		String sqlsearch1 = "select * from member where typez='Student'";
	            		stmtsearch2 = con.createStatement();
	            		rs2 = stmtsearch2.executeQuery(sqlsearch1);
	            		while (rs2.next()) {
	            			String memz = rs2.getString("memberID");
	            			String sqlsearch="select * from student where libMemID ='"+memz+"'";
		            		stmtsearch = con.createStatement();
		            		rs = stmtsearch.executeQuery(sqlsearch);
		            		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
		            		dtm.setRowCount(0);
		            		while (rs.next()) {
		            			Vector vv = new Vector();
		            			vv.add(rs.getString("libMemID"));
		    					vv.add(rs.getString("fName") + " "+rs.getString("lName"));
		    					vv.add(rs.getString("dob"));
		    					vv.add(rs.getString("mobileNo"));
		    					dtm.addRow(vv);
								
							}
						}
	            		
	            		
					}else {
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						Statement stmtsearch = null;
						Statement stmtsearch2 = null;
						
						ResultSet rs2 = null;
						
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            		
	            		String sqlsearch1 = "select * from member where typez='Staff' ";
	            		stmtsearch2 = con.createStatement();
	            		rs2 = stmtsearch2.executeQuery(sqlsearch1);
	            		while (rs2.next()) {
	            			String memz = rs2.getString("memberID");
	            		String sqlsearch="select * from staff where libMemID= '"+memz+"'";
	            		stmtsearch = con.createStatement();
	            		rs = stmtsearch.executeQuery(sqlsearch);
	            		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
	            		dtm.setRowCount(0);
	            		while (rs.next()) {
	            			Vector vv = new Vector();
	            			vv.add(rs.getString("libMemID"));
	    					vv.add(rs.getString("name"));
	    					vv.add(rs.getString("dob"));
	    					vv.add(rs.getString("mobileNo"));
	    					dtm.addRow(vv);
							
					}}
				} }catch (Exception e) {
					e.printStackTrace();
				}
					
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Staff", "Student"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(367, 88, 463, 49);
		contentPane.add(comboBox);
		
		lblSelectMemberType = new JLabel("Select Member Type");
		lblSelectMemberType.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSelectMemberType.setBounds(42, 97, 223, 31);
		contentPane.add(lblSelectMemberType);
		
		btnGoBack = new JButton(" Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		
		btnGoBack.setIcon(new ImageIcon(MemberDetailsSearch.class.getResource("/images/back.png")));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberDetailsSearch.this.dispose();
				new AddMember().setVisible(true);
			}
		});
		btnGoBack.setBounds(728, 498, 261, 74);
		contentPane.add(btnGoBack);
		
		btnDeleteMember = new JButton(" Delete member");
		btnDeleteMember.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDeleteMember.setContentAreaFilled(false);
		btnDeleteMember.setIcon(new ImageIcon(MemberDetailsSearch.class.getResource("/images/delete.png")));
		btnDeleteMember.setBackground(Color.LIGHT_GRAY);
		//btnDeleteMember.setIcon(new ImageIcon(MemberDetailsSearch.class.getResource("/imgz/d2.jpg")));
		btnDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				MemberDetailsSearch.this.dispose();
//				new SearchMember().setVisible(true);
				try {
					DefaultTableModel defaautmodelz =(DefaultTableModel) jtable1.getModel();
					int sele = jtable1.getSelectedRow();
					//System.out.print(sele);
					String memberidz = (String)defaautmodelz.getValueAt(sele, 0);
					//System.out.print(memberidz);
				//	String memberidz = textField.getText();
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
		    	            		MemberDetailsSearch.this.dispose();
		    	            		new MemberDetailsSearch().setVisible(true);
	            				}else {
	            					String sqlupd2 = "delete from member where memberID = '"+memberidz+"'";
		    	            		stmt5 = con.createStatement();
		    	            		stmt5.executeUpdate(sqlupd2);
		    	            		
	            					
	            					
	            					String sqlupd = "update staff set libMemID='null' where libMemID='"+memberidz+"' ";
		    	            		stmt4 = con.createStatement();
		    	            		stmt4.executeUpdate(sqlupd);
		    	            		
		    	            		
		    	            		
		    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
		    	            		MemberDetailsSearch.this.dispose();
		    	            		new MemberDetailsSearch().setVisible(true);
	            					
	            				}
	            				
	            			}
	            		}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select Valid Row..!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteMember.setBounds(421, 498, 261, 74);
		contentPane.add(btnDeleteMember);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MemberDetailsSearch.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 1082, 603);
		contentPane.add(lblNewLabel);
	}
}
