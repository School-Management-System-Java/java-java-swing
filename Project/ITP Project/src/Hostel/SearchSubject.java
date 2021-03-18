package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchSubject extends JFrame {

	private JPanel contentPane;
	private  static JTable table;
	private JTextField txtEnterMemberId;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSubject frame = new SearchSubject();
					frame.setVisible(true);
					loadDatat();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchSubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 231, 802, 470);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"subjectID", "name"
			}
				) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			
			}
			
			
		});
		scrollPane.setViewportView(table);
		
		txtEnterMemberId = new JTextField();
		txtEnterMemberId.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEnterMemberId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtEnterMemberId.setText("");
			}
		});
		txtEnterMemberId.addKeyListener(new KeyAdapter() {
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
		        		
		        		String sql2 = "select * from subject where subjectID like '"+txtEnterMemberId.getText()+"%'";
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
				loadDatat();
				}
				
			}
		});
		
		txtEnterMemberId.setText("Enter Subject ID");
		txtEnterMemberId.setBounds(261, 63, 372, 118);
		contentPane.add(txtEnterMemberId);
		txtEnterMemberId.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				SearchSubject.this.dispose();
				new SHome().setVisible(true);
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					
				SearchSubject.this.dispose();
					new SHome().setVisible(true);
					
				
			}
		});
		btnNewButton.addKeyListener(new KeyAdapter() {
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setIcon(new ImageIcon(search_member.class.getResource("/imgz/back.png")));
		btnNewButton.setBounds(25, 762, 193, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setIcon(new ImageIcon(SearchSubject.class.getResource("/imgz/update.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					

					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String subjectID = (String)table.getValueAt(i, 0);
					String name = (String)table.getValueAt(i, 1);
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "update subject set name='"+name+"' where subjectID='"+subjectID+"'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
					
            	
            		JOptionPane.showMessageDialog(null, "Data Updated");
            		SearchSubject.this.dispose();
            		new SearchSubject().setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Select Row", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
					
					
					
					
				
				
			
			}
				
				
			
		});
		btnNewButton_1.setBounds(463, 766, 210, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setIcon(new ImageIcon(SearchSubject.class.getResource("/imgz/dlte.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

								
try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
								
					
					String subjectID = (String) table.getValueAt(i, 0);
				String name = (String) table.getValueAt(i, 1);
					
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            	   
            		Statement stmt2 = null;
					Statement stmt3 = null;
					Statement stmt4 = null;
					Statement stmt5 = null;
					
					ResultSet rs2 = null;
					ResultSet rs3 = null;
					ResultSet rs4 = null;
					ResultSet rs5 = null;   
	            		
	            		String sql2 = "select * from staff_subject where subjectID='"+subjectID+"'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);	
	            		
	            		
	            		if(rs2.next()) {
	            			JOptionPane.showMessageDialog(null, "Cannot Delete Member Beacause This Staff_Subject Recods..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			
	            		}else {
	            			int j = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete this Member?");
	            			if(j == 0) {
	            				
	            				
	            				
	            					
	            				String sqlupd2 = "delete from subject where subjectID='"+subjectID+"'";
		    	            		stmt3 = con.createStatement();
		    	            		stmt3.executeUpdate(sqlupd2);
	            					
	            					String sqlupd = "update staff_subject set subjectID='null' where subjectID='"+subjectID+"' ";
		    	            		stmt2 = con.createStatement();
		    	            		stmt2.executeUpdate(sqlupd);
		    	            		
		    	            		
		    	            		
		    	            		
		    	            	
		    	            		
		    	            		
		    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
		    	            		SearchSubject.this.dispose();
		    	            		new SearchSubject().setVisible(true);
	            			 		
					
            		
	            				}
	            			}
	            		


				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Select Row", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.setBounds(716, 766, 171, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("print");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				

				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Subject.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      doc.add(image);
				      doc.add(new Paragraph("Subject Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(2);
				   
				   				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" subjectID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("name"));


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
				      
		                
		                  }catch(Exception e){
				         e.printStackTrace();
				     }
				 
		
				
				
				
			}
		});
		btnNewButton_3.setBounds(271, 766, 159, 54);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SearchSubject.class.getResource("/imgz/bg.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
	}
	
	
	static void loadDatat(){
		try {
			
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
					"databaseName=ITP_Project;integratedSecurity=true;";

			Connection con = null;
			Statement stmt = null;
			
			
			ResultSet rs = null;
			
			
			// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		con = DriverManager.getConnection(connectionUrl);
        
        
        		
        		String sql2 = "select * from subject";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		
        		// default table model
        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
        		
        		while (rs.next()) {
					
        			
        			Vector vv = new Vector();
        			
					vv.add(rs.getString(1));
					vv.add(rs.getString(2));
					
        			
        			dtm.addRow(vv);
				}
        		
        		
			
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		
		
	}
}