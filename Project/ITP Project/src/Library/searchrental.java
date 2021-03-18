package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchrental extends JFrame {

	private JPanel contentPane;
	private static JTable jtable1;
	private JButton btnGoBack;
	private JTextField txtTypeBookId;
	private JLabel label;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchrental frame = new searchrental();
					frame.setTitle("Search Rentals");
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
	public searchrental() {
		
		searchrental.this.setTitle("Search Rental");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblRentalDetails = new JLabel(" Rental Details");
		lblRentalDetails.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRentalDetails.setBounds(413, 0, 184, 83);
		contentPane.add(lblRentalDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(12, 164, 1048, 352);
		contentPane.add(scrollPane);
		
		jtable1 = new JTable();
		jtable1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Member Id", "Borrow Date", "Return Date", "Due Dates", "Late Days","Fine","Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
		});
		scrollPane.setViewportView(jtable1);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setIcon(new ImageIcon(searchrental.class.getResource("/images/back.png")));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchrental.this.dispose();
				new L_Main().setVisible(true);
			}
		});
		btnGoBack.setBounds(814, 541, 246, 53);
		contentPane.add(btnGoBack);
		
		txtTypeBookId = new JTextField();
		txtTypeBookId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtTypeBookId.setText("");
			}
		});
		txtTypeBookId.addKeyListener(new KeyAdapter() {
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
		        		
		        		String sql2 = "select * from rental where bookID like'"+txtTypeBookId.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		
		        		// default table model
		        		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
		        		dtm.setRowCount(0);
		        		while (rs.next()) {
							
		        			//vector ekath haduwa aluth row ekak hadanawa
		        			Vector vv = new Vector();
		        			
							vv.add(rs.getString(1));
							vv.add(rs.getString(2));
							vv.add(rs.getString(3));
							vv.add(rs.getString(4));
							vv.add(rs.getString(5));
							vv.add(rs.getString(6));
							vv.add(rs.getString(7));
							vv.add(rs.getString(8));
		        			
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
//				char c=arg0.getKeyChar();
//				if(!(Character.isDigit(c))) {
//					
//					arg0.consume();//not typing
//					JOptionPane.showMessageDialog(null, "Please Enter Valid ID", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
//					
//					
//				}
			}
		});
		txtTypeBookId.setText("Type Book Id To Search");
		txtTypeBookId.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeBookId.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtTypeBookId.setColumns(10);
		txtTypeBookId.setBounds(268, 83, 545, 58);
		contentPane.add(txtTypeBookId);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(searchrental.class.getResource("/images/open-book.png")));
		label.setBounds(170, 83, 64, 58);
		contentPane.add(label);
		
		btnNewButton = new JButton("Update Pending Books");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(searchrental.class.getResource("/images/update.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchrental.this.dispose();
				new searchrentalupdate().setVisible(true);
			}
		});
		btnNewButton.setBounds(135, 541, 342, 53);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					 DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("fffs.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Book Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(8);
				  //    PdfPCell cell = new PdfPCell(new Paragraph("Teacher name & Stage"));
				    //  cell.setColspan(4);
				   ////   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     // cell.setBackgroundColor(BaseColor.GREEN);
				//      table.addCell(cell);
				     
				   
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f,2f,2f,2f,2f,2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" Book ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph(" Member ID"));
		                PdfPCell c3= new PdfPCell(new Paragraph("Borrow Date"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Return Date"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Due Dates"));
		                PdfPCell c6= new PdfPCell(new Paragraph("Late Days"));
		                PdfPCell c7= new PdfPCell(new Paragraph("Fine"));
		                PdfPCell c8= new PdfPCell(new Paragraph("Status"));
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
		                table.addCell(c7);
		                table.addCell(c8);
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
						PdfPCell p6= new PdfPCell(new Paragraph(dtm.getValueAt(i, 6).toString()));
						PdfPCell p7= new PdfPCell(new Paragraph(dtm.getValueAt(i, 7).toString()));
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
		                table.addCell(p6);
		                table.addCell(p7);
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
		                	 
		                	//  e.printStackTrace();
		                	  JOptionPane.showMessageDialog(null, "Same name PDF Wrong!!");
				     }
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(554, 546, 175, 53);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(searchrental.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 1070, 603);
		contentPane.add(lblNewLabel);
		
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
        		
        		String sql2 = "select * from rental";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		
        		// default table model
        		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
        		dtm.setRowCount(0);
        		while (rs.next()) {
					
        			//vector ekath haduwa aluth row ekak hadanawa
        			Vector vv = new Vector();
        			
					vv.add(rs.getString(1));
					vv.add(rs.getString(2));
					vv.add(rs.getString(3));
					vv.add(rs.getString(4));
					vv.add(rs.getString(5));
					vv.add(rs.getString(6));
					vv.add(rs.getString(7));
					vv.add(rs.getString(8));
        			
        			dtm.addRow(vv);
				}
        		
        		
			
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		
		
	}
}
