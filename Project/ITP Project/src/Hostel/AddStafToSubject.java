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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;

public class AddStafToSubject extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStafToSubject frame = new AddStafToSubject();
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
	public AddStafToSubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Staff_ID = new JLabel("Staff ID");
		Staff_ID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Staff_ID.setBounds(87, 240, 130, 33);
		contentPane.add(Staff_ID);

		JLabel Subject_ID = new JLabel("SubjectID");
		Subject_ID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Subject_ID.setBounds(80, 318, 108, 47);
		contentPane.add(Subject_ID);

		textField_1 = new JTextField();
		textField_1.setBounds(253, 232, 280, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(253, 318, 280, 50);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.addMouseListener(new MouseAdapter() {

		});

		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Staff_ID = textField_1.getText();
				// System.out.println(Staff_ID);

				String Subject_ID = textField_2.getText();
				// System.out.println(Subject_ID);

				if (Staff_ID.equals("") || Subject_ID.equals("")) {
					JOptionPane.showMessageDialog(AddStafToSubject.this, "error", "Invalid Entry",
							JOptionPane.ERROR_MESSAGE);
				}

				else {

					try {

						String connectionUrl = "jdbc:sqlserver://localhost:1433;"
								+ "databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null,stmt1;
						Statement stmt2 = null;
						ResultSet rs = null,rs1,rs2;

						// Establish the connection.
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con = DriverManager.getConnection(connectionUrl);
						
						String query = "select staffID from staff where staffID='"+Staff_ID+"'";
						stmt = con.createStatement();
						rs1 = stmt.executeQuery(query);
						
						ArrayList list = new ArrayList();
						while(rs1.next()) {
							list.add(rs1.getString("staffID"));
						}
						
						String query1 = "select subjectID from subject where subjectID='"+Subject_ID+"'";
						stmt1 = con.createStatement();
						rs2 = stmt.executeQuery(query1);
						
						ArrayList list1 = new ArrayList();
						while(rs2.next()) {
							list1.add(rs2.getString("subjectID"));
						}
						
						if(list.isEmpty()) {
							JOptionPane.showMessageDialog(AddStafToSubject.this, "Staff ID not valid", "Error",
									JOptionPane.ERROR_MESSAGE);
						}else if(list1.isEmpty()) {
							JOptionPane.showMessageDialog(AddStafToSubject.this, "Subject ID not valid", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							stmt=null;
							// Create and execute an SQL statement that returns some data.
							String SQL = "INSERT INTO staff_subject (staffID, subjectID)\r\n" + "VALUES ('" + Staff_ID
									+ "', '" + Subject_ID + "');";
							stmt = con.createStatement();

							stmt.executeUpdate(SQL);
							JOptionPane.showMessageDialog(null, "Data Saved");
						}

					} catch (Exception e1) {
						e1.printStackTrace();
						

						textField_1.setText("");
						textField_2.setText("");;
	            		
	            		textField.grabFocus();
						
					}
					textField_1.setText("");
					textField_2.setText("");;
            		
            		textField.grabFocus();

				}

			}
		});
		btnAddStaff.setIcon(new ImageIcon(AddStafToSubject.class.getResource("/imgz/diskette.png")));
		btnAddStaff.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAddStaff.setBounds(146, 460, 267, 68);
		contentPane.add(btnAddStaff);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				AddStafToSubject.this.dispose();
				new SHome().setVisible(true);

			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStafToSubject.class.getResource("/imgz/back.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(146, 666, 267, 68);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Staff ID");
		textField.addKeyListener(new KeyAdapter() {
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
		        		
		        		String sql2 = "select * from staff_subject where staffID like '"+textField.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		        		dtm.setRowCount(0);
		        		while (rs.next()) {
							
		        			Vector vv = new Vector();
		        			
						vv.add(rs.getString(1));
					    vv.add(rs.getString(2));
							
		        			
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} 
                 catch (Exception e2) {
				e2.printStackTrace();
				}
			}
		});
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textField.setText("");
			}
		});
		textField.setBounds(686, 190, 422, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(AddStafToSubject.class.getResource("/imgz/dlte.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
										DefaultTableModel dtm = (DefaultTableModel) table.getModel();
										// System.out.print(jtable1.getSelectedRow());
										int i = table.getSelectedRow();
					
										String staffID = (String) table.getValueAt(i, 0);
										String SubID = (String) table.getValueAt(i, 1);
					
										String connectionUrl = "jdbc:sqlserver://localhost:1433;"
												+ "databaseName=ITP_Project;integratedSecurity=true;";
					
										Connection con = null;
										Statement stmt = null;
										Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
										con = DriverManager.getConnection(connectionUrl);
					
										String sqlupd = "delete from staff_subject where subjectID='"+SubID+"'";
										stmt = con.createStatement();
										stmt.execute(sqlupd);
					
										JOptionPane.showMessageDialog(null, "Data Updated");
										AddStafToSubject.this.dispose();
										new AddStafToSubject().setVisible(true);
										
										
										
									} catch (Exception e) {
										JOptionPane.showMessageDialog(null, "Select Row", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
									}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDelete.setBounds(146, 555, 267, 68);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(583, 244, 637, 442);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StffID", "SubjectID"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Staff To Subject.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add((Element) new Paragraph("Staff To Subject Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(2);
				
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" Staff ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("Subject ID"));

		                table.addCell(c1);
		                table.addCell(c2);

		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
					PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));

						
						table.addCell(p0);
						table.addCell(p1);


		                }
		            	
					

		                    
		                    doc.add(table);
				      

				      
				      JOptionPane.showMessageDialog(null, "Report Saved!");
				      doc.close();
				      
		                
		                  }catch(Exception e1){
				         e1.printStackTrace();
				     }
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(146, 754, 267, 68);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setIcon(new ImageIcon(AddStafToSubject.class.getResource("/imgz/bg.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
	}
}
