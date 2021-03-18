package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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

//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRTableModelDataSource;
//import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Searchbooks extends JFrame {

	private JPanel contentPane;
	private JTextField txtTypeBookName;
	private static JTable jtable1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchbooks frame = new Searchbooks();
					frame.setTitle("Search Book");
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
	public Searchbooks() {
		
		Searchbooks.this.setTitle("Search Book");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTypeBookName = new JTextField();
		txtTypeBookName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
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
		        		
		        		String sql2 = "select * from book where name like '"+txtTypeBookName.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
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
		txtTypeBookName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTypeBookName.setText("");
				
			}
		});
		txtTypeBookName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeBookName.setText("Type Book Name To Search");
		txtTypeBookName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtTypeBookName.setBounds(301, 52, 545, 58);
		contentPane.add(txtTypeBookName);
		txtTypeBookName.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(51, 139, 953, 352);
		contentPane.add(scrollPane);
		
		jtable1 = new JTable();
		jtable1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Book Name", "ISBN", "Author Name", "Publisher Name", "No Of Coppies"
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
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Searchbooks.this.dispose();
				new AddBook().setVisible(true);
			}
		});
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Searchbooks.this.dispose();
				new L_Main().setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Searchbooks.class.getResource("/images/back.png")));
		btnNewButton.setBounds(806, 517, 245, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Data");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Searchbooks.class.getResource("/images/update.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Searchbooks.this.dispose();
//				new UpdateBook().setVisible(true);
				
				
				try {
					DefaultTableModel defaautmodelz =(DefaultTableModel) jtable1.getModel();
					int sele = jtable1.getSelectedRow();
					//System.out.print(sele);
					String bookidz = (String)defaautmodelz.getValueAt(sele, 0);
					Searchbooks.this.dispose();
					new UpdateBook(bookidz).setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select Valid Row..!", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_1.setBounds(12, 517, 236, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Searchbooks.class.getResource("/images/search.png")));
		lblNewLabel.setBounds(201, 52, 64, 58);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Delete Book");
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(Searchbooks.class.getResource("/images/delete.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DefaultTableModel defaautmodelz =(DefaultTableModel) jtable1.getModel();
					int sele = jtable1.getSelectedRow();
					String bookidz = (String)defaautmodelz.getValueAt(sele, 0);
							String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
									"databaseName=ITP_Project;integratedSecurity=true;";

							Connection con = null;
							Statement stmt2 = null;
							Statement stmt = null;
							
							ResultSet rs2 = null;
							
							
							// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		
			            		String sql2 = "select * from rental where bookID='"+bookidz+"' and statuz='Pending'";
			            		stmt2 = con.createStatement();
			            		rs2=stmt2.executeQuery(sql2);	
			            		if(rs2.next()) {
			            			JOptionPane.showMessageDialog(null, "Cannot Delete Book Beacause This Book is Rented..!", "Error", JOptionPane.ERROR_MESSAGE);
			            			
			            		}else {
			            			int i = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete this Book?");
			            			if(i == 0) {
			            				String sqlupd = "delete  from book where bookID='"+bookidz+"'";
			    	            		stmt = con.createStatement();
			    	            		stmt.executeUpdate(sqlupd);
			    						
			    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
			    	            		Searchbooks.this.dispose();
			    	            		new Searchbooks().setVisible(true);
			            			}
			            		}
						
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Please Select Valid Row..!", "Error", JOptionPane.ERROR_MESSAGE);
					
				}}
		});
		
		
		button.setToolTipText("Save Data");
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(277, 517, 263, 73);
		contentPane.add(button);
		
		JButton btnPrint_1 = new JButton("Print");
		btnPrint_1.setContentAreaFilled(false);
		btnPrint_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPrint_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try{
					 DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Searcha.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Book Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
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
		                PdfPCell c1= new PdfPCell(new Paragraph(" Book ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph(" Book Name"));
		                PdfPCell c3= new PdfPCell(new Paragraph("ISBN"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Author Name"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Publisher name"));
		                PdfPCell c6= new PdfPCell(new Paragraph("No Of Copies"));
//		                PdfPCell c7= new PdfPCell(new Paragraph("Rate"));
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
						PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
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
		                table.addCell(p2);
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
				      
		                
		                  }catch(Exception e){
		                	  JOptionPane.showMessageDialog(null, "Same name PDF Wrong!!");
				     }
				
				
				
			}
		});
		btnPrint_1.setBounds(573, 517, 195, 73);
		contentPane.add(btnPrint_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Searchbooks.class.getResource("/images/img.png")));
		lblNewLabel_1.setBounds(0, 0, 1232, 617);
		contentPane.add(lblNewLabel_1);
		
		loadDatatotable();
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
        		
        		String sql2 = "select * from book ";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		
        		// default table model
        		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
        		
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
