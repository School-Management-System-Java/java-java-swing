package Staff;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Staff.attendance;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class attendance extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	private  static JTable table;

	static attendance hh;
	private JTextField StaffID;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_2;
	//private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance frame = new attendance();
					frame.setVisible(true);
					
					loadDatatotable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public attendance() {
		attendance.this.setTitle("Attendance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		getContentPane().setLayout(null);
		
		JLabel lblStaffMarkAttendance = new JLabel("Staff Mark Attendance");
		lblStaffMarkAttendance.setBounds(421, 13, 444, 72);
		lblStaffMarkAttendance.setFont(new Font("Tahoma", Font.BOLD, 34));
		getContentPane().add(lblStaffMarkAttendance);
		
		JLabel lblDate = new JLabel(" Date");
		lblDate.setBounds(27, 200, 86, 28);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
		
			
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				
				

				char uu = arg0.getKeyChar();
				String txr = textField.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy >= 2) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Date", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField.setBounds(238, 197, 268, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStaffMemberName = new JLabel("Staff ID");
		lblStaffMemberName.setBounds(27, 92, 182, 28);
		lblStaffMemberName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(lblStaffMemberName);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				textField_1.setText("");
			}
		});
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
		});
				
		
		textField_1.setBounds(238, 89, 268, 40);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
				
		
			
		});
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(238, 156, 268, 28);
		getContentPane().add(comboBox);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "True", "False"}));
		comboBox_1.setBounds(238, 390, 268, 28);
		getContentPane().add(comboBox_1);
		
		
		JButton btnMarkAttendance = new JButton("Mark Attendance");
		btnMarkAttendance.setBounds(238, 525, 268, 40);
		btnMarkAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String staffID1 = textField_1.getText();
				String date1 = textField.getText();
				String staffAttID = textField_3.getText();
				//String half = textField_4.getText();
				String year = textField_2.getText();
				String comboBox1 = comboBox.getSelectedItem().toString();
				String comboBox2 = comboBox_1.getSelectedItem().toString();
				
				//ekama id eka deparak attendance mark karama short live column eka mark wenna one
				
				if(staffID1.equals("") || date1.equals("")  || staffAttID.equals("") || comboBox1.equals("") ||comboBox2.equals("") || year.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Fill All Feilds To Continue","Membership Management System",JOptionPane.ERROR_MESSAGE);
				}
				
				
				else {

	try {
						
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";
						
						

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						
						
						Statement stmt3 = null;
						
						
						
				
						ResultSet rs3 = null;
						
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO staffAttendance (staffAttendID,staffID, date,halfDay,monthz,year)\r\n" + 
		            				"VALUES ('"+staffAttID+"', '"+staffID1+"','"+date1+"','"+comboBox2+"','"+comboBox1+"','"+year+"');";
//		            		stmt = con.createStatement();
//		            		
//		            		
//		            		stmt.executeUpdate(SQL);
		            		//////////////////////////////
		            /*
		            		String SQL2 = "INSERT INTO staffSalary (staffSalID,staffID, month,leaveDays)\r\n" + 
		            				"VALUES ('"+staffAttID+"','"+staffID1+"', '"+comboBox1+"','"+half+"');";
		            		stmt2 = con.createStatement();
		            		
		            		
		            		stmt2.executeUpdate(SQL2);
		            		////////////////////////////////////
		            	
		            */		
		            		
		            		String SQL3 = "select * from staff where staffID='"+staffID1+"'";
		            		stmt3= con.createStatement();
		            		rs3 = stmt3.executeQuery(SQL3);
		            		
		            		if(rs3.next()) {
		            			
		            			stmt = con.createStatement();
			            		
			            		
			            		stmt.executeUpdate(SQL);
			            		
			            		JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
	}else {
		JOptionPane.showMessageDialog(null, "Invalid Member ID", "ok", JOptionPane.ERROR_MESSAGE);

	}
		            		
		            		
		            		textField_1.setText("");
		            		textField.setText("");
		            		textField_3.setText("");
		            		//textField_4.setText("");;
		            		//comboBox2.charAt('A');
		            		textField_1.grabFocus();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Enter Details", "Done", JOptionPane.ERROR_MESSAGE);
					}	
//	JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
			}	
			}
		});
		btnMarkAttendance.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(btnMarkAttendance);
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, 153, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 144, 56, 16);
		getContentPane().add(label_1);
		
		StaffID = new JTextField();
		StaffID.setBounds(774, 92, 268, 40);
		StaffID.setFont(new Font("Tahoma", Font.BOLD, 15));
		StaffID.setText("Enter StaffID");
		StaffID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StaffID.setText("");
			}
		});
		
		
		StaffID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
			try {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					
					
					ResultSet rs = null;
					
					
					// Establish the connection.
		    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        		con = DriverManager.getConnection(connectionUrl);
		        
		        		// Create and execute an SQL statement that returns some data.
		        		
		        		String sql2 = "select * from staffAttendance  where staffID like '"+StaffID.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		        		dtm.setRowCount(0);
		        		while (rs.next()) {
							
		        			Vector vv = new Vector();
		        			
							vv.add(rs.getString(1));
							vv.add(rs.getString(2));
							vv.add(rs.getString(3));
							vv.add(rs.getString(4));
							vv.add(rs.getString(5));
							vv.add(rs.getString(6));
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Invalid Enter Details", "Done", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		StaffID.setColumns(10);
		getContentPane().add(StaffID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(592, 200, 596, 615);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StaffAttendID", "StaffID", "Date", "HalfDay", "Month", "Year"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 324, 268, 40);
		getContentPane().add(textField_3);
		
		JLabel lblHalfday = new JLabel("Half_Day");
		lblHalfday.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHalfday.setBounds(27, 390, 159, 28);
		getContentPane().add(lblHalfday);
		
		JLabel lblStaffattendanceid = new JLabel("StaffAttendanceID");
		lblStaffattendanceid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStaffattendanceid.setBounds(27, 327, 182, 28);
		getContentPane().add(lblStaffattendanceid);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				
				
				
				
	try {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					
					
					ResultSet rs = null;
					
					
					// Establish the connection.
		    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        		con = DriverManager.getConnection(connectionUrl);
		        
		        		// Create and execute an SQL statement that returns some data.
		        		
		        		String sql2 = "select * from staffAttendance  where date like '"+textField_5.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		        		dtm.setRowCount(0);
		        		while (rs.next()) {
							
		        			Vector vv = new Vector();
		        			
							vv.add(rs.getString(1));
							vv.add(rs.getString(2));
							vv.add(rs.getString(3));
							vv.add(rs.getString(4));
							vv.add(rs.getString(5));
							vv.add(rs.getString(6));
							
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
			}
		});
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				textField_5.setText("");
			}
		});
		textField_5.setText("Enter Date");
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(774, 150, 268, 40);
		getContentPane().add(textField_5);
		
		JLabel label_2 = new JLabel("Month");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_2.setBounds(27, 149, 178, 40);
		getContentPane().add(label_2);
		
		JButton btnSalary = new JButton("Staff Home");
		btnSalary.setIcon(new ImageIcon(attendance.class.getResource("/images/back.png")));
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attendance.this.dispose();
				new Main().setVisible(true);
				
				
				
			}
		});
		btnSalary.setBounds(58, 677, 147, 50);
		getContentPane().add(btnSalary);
		
		JButton btnNewButton = new JButton("Edit Attendance");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String staffAttID = (String)table.getValueAt(i, 0);
					
					String staffID = (String)table.getValueAt(i, 1);
					String date = (String)table.getValueAt(i, 2);
					String halfday = (String)table.getValueAt(i, 3);
					String monthz = (String)table.getValueAt(i, 4);
					
					
//					
//					System.out.print(staffAttID);
//					System.out.print(staffID);
//					System.out.print(date);
//					System.out.print(halfday);
//					System.out.print(monthz);
					
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "update staffAttendance set date='"+date+"',halfDay='"+halfday+"',monthz='"+monthz+"' where staffAttendID='"+staffAttID+"'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
					
            		JOptionPane.showMessageDialog(null, "Data Updated", "Done", JOptionPane.INFORMATION_MESSAGE);
            		
            		
            		attendance.this.dispose();
            		new attendance().setVisible(true);
            		loadDatatotable();
					
				} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Invalid Details", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
			}	
				
				
				
			
		});
		btnNewButton.setBounds(238, 590, 268, 36);
		getContentPane().add(btnNewButton);
		
		JButton btnDeleteAttendance = new JButton("Delete Attendance");
		btnDeleteAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String staffID = (String)table.getValueAt(i, 1);
					
					
					
					
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "delete from staffAttendance  where staffID='"+staffID+"'";
            		
            		
            		
            		
            		
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
            	
            	/*	
            		String sqlupd1="ALTER TABLE dbo.staffSalary NOCHECK CONSTRAINT FK_salaryStaffID";
            		String sqlupd3="delete from staff  where staffID='"+staffID+"'";
            		
            		String sqlupd2="ALTER TABLE dbo.staffSalary NOCHECK CONSTRAINT FK_salaryStaffID";
            		
            		
            		
            		String sqlupd4="ALTER TABLE dbo.staffAttendance NOCHECK CONSTRAINT FK_attendanceStaffID";
            		String sqlupd6="delete from staff  where staffID='"+staffID+"'";
            		
            		String sqlup5="ALTER TABLE dbo.staffAttendance NOCHECK CONSTRAINT FK_attendanceStaffID";
            		
            		
            		stmt = con.createStatement();
            		
            		
            		stmt.executeUpdate(sqlupd1);
            		stmt.executeUpdate(sqlupd3);
            		stmt.executeUpdate(sqlupd2);
            		
            		stmt.executeUpdate(sqlupd4);
            		stmt.executeUpdate(sqlupd6);
            		stmt.executeUpdate(sqlup5);
            		
            		*/
            		
            		
            		
            		
					
            		JOptionPane.showMessageDialog(null, "Data Deleted...!", "Done", JOptionPane.OK_OPTION);
            		
            		
            		attendance.this.dispose();
            		new attendance().setVisible(true);
					
				} catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnDeleteAttendance.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDeleteAttendance.setBounds(238, 653, 268, 36);
		getContentPane().add(btnDeleteAttendance);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblYear.setBounds(27, 256, 86, 28);
		getContentPane().add(lblYear);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				
				char uu = arg0.getKeyChar();
				String txr = textField_2.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Year", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(238, 253, 268, 40);
		getContentPane().add(textField_2);
		
		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 textField_1.setText("a6");
				 textField.setText("5");
				 textField_3.setText("er45r");
				//String half = textField_4.getText();
				 textField_2.setText("2019");
				// comboBox.setEnabled('5');
				// comboBox_1.getSelectedItem().toString();
			}
		});
		btnDemo.setBounds(58, 585, 147, 50);
		getContentPane().add(btnDemo);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("attendance1.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Staff Attendance Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(6);
				  //    PdfPCell cell = new PdfPCell(new Paragraph("Teacher name & Stage"));
				    //  cell.setColspan(4);
				   ////   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     // cell.setBackgroundColor(BaseColor.GREEN);
				//      table.addCell(cell);
				     
				   
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f,2f,2f,2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" Staff Attendance ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("StaffID"));
		                PdfPCell c3= new PdfPCell(new Paragraph("Date"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Half Day"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Month"));
		               PdfPCell c6= new PdfPCell(new Paragraph(" Year"));
	              //  PdfPCell c7= new PdfPCell(new Paragraph("Rate"));
//		                PdfPCell c8= new PdfPCell(new Paragraph("Full Salary"));
//		                PdfPCell c9= new PdfPCell(new Paragraph("Type"));
//		                PdfPCell c10= new PdfPCell(new Paragraph("User Name"));
//		                PdfPCell c11= new PdfPCell(new Paragraph("Lib"));
//		                PdfPCell c12= new PdfPCell(new Paragraph("Hostel"));

		                table.addCell(c1);
		                table.addCell(c2);
		                table.addCell(c3);
		                table.addCell(c4);
		                table.addCell(c5);
		                table.addCell(c6);
		           //     table.addCell(c7);
//		                table.addCell(c8);
//		                table.addCell(c9);
//		                table.addCell(c10);
//		                table.addCell(c11);
//		                table.addCell(c12);
		               // table.addCell(c13);
		                
		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
					    PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));
						PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
						PdfPCell p3= new PdfPCell(new Paragraph(dtm.getValueAt(i, 3).toString()));
						PdfPCell p4= new PdfPCell(new Paragraph(dtm.getValueAt(i, 4).toString()));
					    PdfPCell p5= new PdfPCell(new Paragraph(dtm.getValueAt(i, 5).toString()));
				    	//PdfPCell p6= new PdfPCell(new Paragraph(dtm.getValueAt(i, 6).toString()));
//						PdfPCell p7= new PdfPCell(new Paragraph(dtm.getValueAt(i, 7).toString()));
//						PdfPCell p8= new PdfPCell(new Paragraph(dtm.getValueAt(i, 8).toString()));
					//	PdfPCell p9= new PdfPCell(new Paragraph(dtm.getValueAt(i, 9).toString()));
					//	PdfPCell p10= new PdfPCell(new Paragraph(dtm.getValueAt(i, 10).toString()));
					//	PdfPCell p11= new PdfPCell(new Paragraph(dtm.getValueAt(i, 11).toString()));
		               
						
						table.addCell(p0);
						table.addCell(p1);
		                table.addCell(p2);
		                table.addCell(p3);
		              table.addCell(p4);
		               table.addCell(p5);
	                //table.addCell(p6);
//		                table.addCell(p7);
//		                table.addCell(p8);
		         //       table.addCell(p9);
		          //      table.addCell(p10);
		          //      table.addCell(p11);


		                }
		            	
					

							 
//	                    PdfPCell p2= new PdfPCell(new Paragraph(.getModel().getValueAt(i, 1).toString()));
//		                    PdfPCell p3= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 2).toString()));
//	                    PdfPCell p4= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 3).toString()));
//	                    PdfPCell p5= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 4).toString()));
//
//		                    table.addCell(p1);
//		                    table.addCell(p2);
//	                    table.addCell(p3);
//		                    table.addCell(p4);
//		                    table.addCell(p5);
		                
		                    
		                    doc.add(table);
				      
//		                    Image image1 = Image.getInstance("HY04BODHAGURU.jpg");
//						      //doc.add(new Paragraph("image"));
//						      doc.add(image1);
//				      
				      
				      JOptionPane.showMessageDialog(null, "Report Saved!");
				      doc.close();
				      
		                
		                  }catch(Exception e){
				         e.printStackTrace();
				     }
				
				
			}
		});
		btnNewButton_1.setBounds(238, 454, 268, 40);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(attendance.class.getResource("/Staff/bg.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		getContentPane().add(lblNewLabel);
		
		
	}
		
		static void loadDatatotable(){
			try {
				
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
						"databaseName=ITP_Project;integratedSecurity=true;";

				Connection con = null;
				Statement stmt = null;
				
				
				ResultSet rs = null;
				
				
				// Establish the connection.
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        		con = DriverManager.getConnection(connectionUrl);
	        
	        		// Create and execute an SQL statement that returns some data.
	        		
	        		String sql2 = "select * from staffAttendance";
	        		stmt = con.createStatement();
	        		rs=stmt.executeQuery(sql2);	
	        		
	        		
	        		// default table model
	        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
	        		
	        		while (rs.next()) {
						
	        			//vector ekath haduwa aluth row ekak hadanawa
	        			Vector vv = new Vector();
	        			
						vv.add(rs.getString(1));
						vv.add(rs.getString(2));
						vv.add(rs.getString(3));
						vv.add(rs.getString(4));
						vv.add(rs.getString(5));
						vv.add(rs.getString(6));
	        			dtm.addRow(vv);
					}
	        		
	        		
				
			} catch (Exception e2) {
			e2.printStackTrace();
			}
	}
}

