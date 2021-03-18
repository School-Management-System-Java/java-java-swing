package Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Salary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField txtTypeMemberId;
	private JTextField txtYourSalaryIs;
	private JTextField textField_1;
	private JTextField textField_3;
	static int apunathidaws;
	static int finalsalleryeka;
	static String selectdmon;
	static String memberzidz;
	private static JTable  table;
	private JTextField txtEnterStaffid;
	private JTextField textField_4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary frame = new Salary();
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
	public Salary() {
		
		Salary.this.setTitle("Salary Management");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1429, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff Salary");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(552, 38, 442, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblMemberName = new JLabel("Member Name");
		lblMemberName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMemberName.setBounds(452, 121, 178, 86);
		contentPane.add(lblMemberName);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(643, 142, 189, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPerRateDay = new JLabel("Per Rate Day");
		lblPerRateDay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPerRateDay.setBounds(26, 435, 178, 86);
		contentPane.add(lblPerRateDay);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(216, 465, 404, 33);
		contentPane.add(textField_2);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSearch.setBounds(38, 127, 178, 65);
		contentPane.add(lblSearch);
		
		txtTypeMemberId = new JTextField();
		txtTypeMemberId.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeMemberId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtTypeMemberId.setForeground(new Color(0, 0, 255));
		txtTypeMemberId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTypeMemberId.setText("");
			}
		});
		txtTypeMemberId.setText("Type Staff ID");
		txtTypeMemberId.setColumns(10);
		txtTypeMemberId.setBounds(216, 140, 189, 40);
		contentPane.add(txtTypeMemberId);
		
		JLabel lblCaculateSalary = new JLabel("Caculate Salary");
		lblCaculateSalary.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCaculateSalary.setBounds(26, 534, 178, 86);
		contentPane.add(lblCaculateSalary);
		
		txtYourSalaryIs = new JTextField();
		txtYourSalaryIs.setEditable(false);
		txtYourSalaryIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtYourSalaryIs.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourSalaryIs.setText("Your Salary Is");
		txtYourSalaryIs.setForeground(Color.ORANGE);
		txtYourSalaryIs.setColumns(10);
		txtYourSalaryIs.setBounds(217, 555, 403, 40);
		contentPane.add(txtYourSalaryIs);
		
		JButton btnNewButton = new JButton("Save Salary");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
	String StaffSal=textField_3.getText();
	String year=textField_4.getText();
				
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
						"databaseName=ITP_Project;integratedSecurity=true;";

				Connection con = null; 
				Statement stmt = null;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		con = DriverManager.getConnection(connectionUrl);
        
        		Statement stmt2 = null;
				ResultSet rs = null;
				
				Statement stmt4 = null;
				ResultSet rs4 = null;
				
				Statement stmt3 = null;
				ResultSet rs3 = null;
        		
        		String sql2="select * from staffSalary where staffSalID='"+StaffSal+"'";
        		stmt2=con.createStatement();
        		rs=stmt2.executeQuery(sql2);
        		
        		
        		String sql3="select * from staffSalary where staffID='"+memberzidz+"'";
        		stmt3=con.createStatement();
        		rs3=stmt3.executeQuery(sql3);
        		
        		String sql4="select * from staffSalary where month='"+Integer.parseInt(selectdmon)+"'";
        		stmt4=con.createStatement();
        		rs4=stmt4.executeQuery(sql4);
        		
        		if(rs.next()) {
        			JOptionPane.showMessageDialog(null,"This staffSalID is already Registered..!","Error",JOptionPane.ERROR_MESSAGE);
        		}
        		
        		else if(   (rs3.next() && rs4.next() )  ) {
        			JOptionPane.showMessageDialog(null,"This staffID and Months already Registered..!","Error",JOptionPane.ERROR_MESSAGE);
        		}
        		
        		
        		
        		
        		else {
				
				
				// Create and execute an SQL statement that returns some data.
        		String SQLzz = "INSERT INTO staffSalary (staffSalID, staffID, year,month, leaveDays,finalSalary)\r\n" + 
        				"VALUES ( '"+StaffSal+"', '"+memberzidz+"','"+year+"', '"+Integer.parseInt(selectdmon)+"', '"+apunathidaws+"','"+finalsalleryeka+"');";
        		stmt = con.createStatement();
        		
        		
        		stmt.executeUpdate(SQLzz);
        		
        		JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.INFORMATION_MESSAGE);	
        		
        		textField_4.setText("");
        		txtTypeMemberId.setText("");
        		textField_3.setText("");
        		
			}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Type Valid Date", "Error", JOptionPane.ERROR_MESSAGE);
				textField_4.grabFocus();
			}
    		
    		
			
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(384, 645, 246, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblContactNumber.setBounds(465, 205, 178, 86);
		contentPane.add(lblContactNumber);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(671, 235, 161, 33);
		contentPane.add(textField_1);
		
		JLabel lblPerRateDay_1 = new JLabel("Month");
		lblPerRateDay_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPerRateDay_1.setBounds(25, 336, 178, 86);
		contentPane.add(lblPerRateDay_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				String selected_month = comboBox.getSelectedItem().toString();
				
				selectdmon = selected_month;
				String memberid = txtTypeMemberId.getText();
				memberzidz = memberid;
				
				String year = textField_4.getText();
				
				
				if(memberid.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Valid Member ID","Membership Management System",JOptionPane.ERROR_MESSAGE);
					
				}else {
					try {
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						Statement stmt3 = null;
						Statement stmt4 = null;
						
						
						
						ResultSet rs = null;
						ResultSet rs2 = null;
						ResultSet rs3 = null;
						ResultSet rs4 = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL1 = "select count(monthz) as x from staffAttendance where monthz='"+selected_month+"' and staffID='"+memberid+"'  and year='"+year+"' and halfDay='False' ";
		            		String SQL2 = "select count(monthz) as x from staffAttendance where monthz='"+selected_month+"' and staffID='"+memberid+"'  and year='"+year+"' and halfDay='True' ";
		            		String SQL3 = "select * from staff where staffID='"+memberid+"'";
		            		stmt3= con.createStatement();
		            		rs3 = stmt3.executeQuery(SQL3);
		            		
		            		String SQL4 = "select * from staffAttendance where year='"+year+"'";
		            		stmt4= con.createStatement();
		            		rs4 = stmt4.executeQuery(SQL4);
		            		
		            		if(rs3.next()  &&  rs4.next()) {
		            			stmt = con.createStatement();
			            		stmt2 = con.createStatement();
			            		
			            		
			            		rs = stmt.executeQuery(SQL1);
			            		double apudaws=0;
			            		double apnathi=0;
			            		if(rs.next()) {
			            			
			            			String count = rs.getString("x");
			            			apudaws = Double.parseDouble(count);
			            			//System.out.print("apu count is"+count);
			            		}
			            		rs2 = stmt2.executeQuery(SQL2);
			            		if(rs2.next()) {
			            			String count = rs2.getString("x");
			            			apnathi = Double.parseDouble(count);
			            			//System.out.print("apu nathi count is"+count);
			            		}
			            		String salaryperday = rs3.getString("perDayRate");
			            		
			            		
			            		double apudawsganesalary = Double.parseDouble(salaryperday) * apudaws;
			            		
			            		double salaryperhalfday = Double.parseDouble(salaryperday)/2;
			            		
			            		
			            		double apunatidawsganata = salaryperhalfday * apnathi;
			            		double finsalary = apudawsganesalary + apunatidawsganata;
			            		finalsalleryeka =(int)finsalary;
			            		textField.setText(rs3.getString("name"));
			            		textField_1.setText(rs3.getString("mobileNo"));
			            		textField_2.setText("RS "+rs3.getString("perDayRate"));
			            		txtYourSalaryIs.setText("Your Salary Is "+ finsalary);
			            		apunathidaws = (int)apnathi;
			            		
			            	

							
								
					
				            
				            	
			            		
			            		
			            		
			            		
		            		}else {
		    					JOptionPane.showMessageDialog(null, "Invalid Member ID", "ok", JOptionPane.ERROR_MESSAGE);

		            		}

		            		
		            		
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(215, 362, 405, 40);
		contentPane.add(comboBox);
		
		JLabel StaffSalID = new JLabel("StaffSalID");
		StaffSalID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		StaffSalID.setBounds(25, 205, 178, 86);
		contentPane.add(StaffSalID);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(216, 226, 189, 33);
		contentPane.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(671, 315, 706, 525);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StaffSalID", "StaffID", "Year", "Month", "Leave Days", "FinalSal"
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
		
		txtEnterStaffid = new JTextField();
		txtEnterStaffid.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEnterStaffid.setForeground(new Color(0, 0, 205));
		txtEnterStaffid.setText("Enter StaffID");
		txtEnterStaffid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtEnterStaffid.setText("");
			}
		});
		txtEnterStaffid.addActionListener(new ActionListener() {
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
            		
            		String sqlupd = "delete from staffSalarys  where staffID='"+staffID+"'";
            		
            		
            		
            		
            		
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
            		
            		
            		Salary.this.dispose();
            		new Salary().setVisible(true);
					
				} catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
				
				
			}
				
				
				
				
				
				
				
				
				
			
		});
		txtEnterStaffid.addKeyListener(new KeyAdapter() {
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
		        		
		        		String sql2 = "select * from staffSalary  where staffID like '"+txtEnterStaffid.getText()+"%'";
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
		txtEnterStaffid.setColumns(10);
		txtEnterStaffid.setBounds(990, 240, 331, 46);
		contentPane.add(txtEnterStaffid);
		
		JButton btnDeleteSalaryDetails = new JButton("Delete Salary Details");
		btnDeleteSalaryDetails.addActionListener(new ActionListener() {
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
            		
            		String sqlupd = "delete from staffSalary  where staffID='"+staffID+"'";
            		
            		
            		
            		
            		
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
            		
            		
            		Salary.this.dispose();
            		new Salary().setVisible(true);
					
				} catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
				
				
			}	
				
				
				
				
				
				
				
				
				
				
				
			
		});
		btnDeleteSalaryDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDeleteSalaryDetails.setBounds(384, 785, 246, 37);
		contentPane.add(btnDeleteSalaryDetails);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblYear.setBounds(25, 272, 178, 86);
		contentPane.add(lblYear);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				char uu = arg0.getKeyChar();
				String txr = textField_4.getText();
				int yy = txr.length();
				System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Year", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(216, 293, 189, 33);
		contentPane.add(textField_4);
		
		JButton btnUpdateSalary = new JButton("Update Salary");
		btnUpdateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String staffSalID = (String)table.getValueAt(i, 0);
					
					String staffID = (String)table.getValueAt(i, 1);
					String year = (String)table.getValueAt(i, 2);
					String month = (String)table.getValueAt(i, 3);
					String leaveDays = (String)table.getValueAt(i, 4);
					String finalSal = (String)table.getValueAt(i, 5);
					
					
				
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "update staffSalary set year='"+year+"',month='"+month+"',leaveDays='"+leaveDays+"',finalSalary='"+finalSal+"' where staffSalID='"+staffSalID+"'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
					
            		JOptionPane.showMessageDialog(null, "Data Updated", "Done", JOptionPane.INFORMATION_MESSAGE);
            		
            		
            		Salary.this.dispose();
            		new Salary().setVisible(true);
            		loadDatatotable();
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
		btnUpdateSalary.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdateSalary.setBounds(384, 711, 246, 37);
		contentPane.add(btnUpdateSalary);
		
		JButton btnNewButton_1 = new JButton("Demo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtTypeMemberId.setText("a6");
				
				textField_3.setText("gjdh6");
				textField_4.setText("2019");
				
				
				
			}
		});
		btnNewButton_1.setBounds(119, 652, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Salary.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Staff Salary Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(5);
				  //    PdfPCell cell = new PdfPCell(new Paragraph("Teacher name & Stage"));
				    //  cell.setColspan(4);
				   ////   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     // cell.setBackgroundColor(BaseColor.GREEN);
				//      table.addCell(cell);
				     
				   
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f,2f,2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" StaffSal ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("StaffID"));
		               // PdfPCell c3= new PdfPCell(new Paragraph("Year"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Month"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Leave Days"));
		                PdfPCell c6= new PdfPCell(new Paragraph("Final Sal"));
//		                PdfPCell c7= new PdfPCell(new Paragraph("Rate"));
//		                PdfPCell c8= new PdfPCell(new Paragraph("Full Salary"));
//		                PdfPCell c9= new PdfPCell(new Paragraph("Type"));
//		                PdfPCell c10= new PdfPCell(new Paragraph("User Name"));
//		                PdfPCell c11= new PdfPCell(new Paragraph("Lib"));
//		                PdfPCell c12= new PdfPCell(new Paragraph("Hostel"));

		                table.addCell(c1);
		                table.addCell(c2);
		              //  table.addCell(c3);
		                table.addCell(c4);
		                table.addCell(c5);
		                table.addCell(c6);
//		                table.addCell(c7);
//		                table.addCell(c8);
//		                table.addCell(c9);
//		                table.addCell(c10);
//		                table.addCell(c11);
//		                table.addCell(c12);
		               // table.addCell(c13);
		                
		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
		                PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));
						//PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
						PdfPCell p3= new PdfPCell(new Paragraph(dtm.getValueAt(i, 3).toString()));
						PdfPCell p4= new PdfPCell(new Paragraph(dtm.getValueAt(i, 4).toString()));
						PdfPCell p5= new PdfPCell(new Paragraph(dtm.getValueAt(i, 5).toString()));
//						PdfPCell p6= new PdfPCell(new Paragraph(dtm.getValueAt(i, 6).toString()));
//						PdfPCell p7= new PdfPCell(new Paragraph(dtm.getValueAt(i, 7).toString()));
//						PdfPCell p8= new PdfPCell(new Paragraph(dtm.getValueAt(i, 8).toString()));
					//	PdfPCell p9= new PdfPCell(new Paragraph(dtm.getValueAt(i, 9).toString()));
					//	PdfPCell p10= new PdfPCell(new Paragraph(dtm.getValueAt(i, 10).toString()));
					//	PdfPCell p11= new PdfPCell(new Paragraph(dtm.getValueAt(i, 11).toString()));
		               
						
						table.addCell(p0);
						table.addCell(p1);
		              //  table.addCell(p2);
		                table.addCell(p3);
		                table.addCell(p4);
		                table.addCell(p5);
//		                table.addCell(p6);
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
				      
		                
		                  }catch(Exception e1){
				         e1.printStackTrace();
				     }
				
				
			}
		});
		btnNewButton_2.setBounds(227, 611, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Staff Main");
		btnNewButton_3.setIcon(new ImageIcon(Salary.class.getResource("/images/back.jpg")));
		btnNewButton_3.setBounds(108, 780, 139, 48);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Salary.class.getResource("/Staff/bg.png")));
		lblNewLabel_1.setBounds(0, 0, 1529, 853);
		contentPane.add(lblNewLabel_1);
		
		
		
			
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
        		
        		String sql2 = "select * from staffSalary";
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
