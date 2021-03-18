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
import com.lowagie.text.Element;
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

public class Search_Payment extends JFrame {

	private JPanel contentPane;
	private  static JTable table;
	private JTextField txtEnterMemberId;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Payment frame = new Search_Payment();
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
	public Search_Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 272, 843, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"hostelPayID", "hostelMemID", "year", "month", "amount", "status", "paidDate"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true, true
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
		        		
		        		String sql2 = "select * from hostelPayment where hostelMemID like '"+txtEnterMemberId.getText()+"%'";
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
							
							vv.add(rs.getString(7));
							
							
		        			
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
			}
		});
		
		txtEnterMemberId.setText("Enter member ID");
		txtEnterMemberId.setBounds(285, 75, 464, 93);
		contentPane.add(txtEnterMemberId);
		txtEnterMemberId.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					
				

				Search_Payment.this.dispose();
				new memberHome().setVisible(true);
				
				
				
			/*	Search_Payment.this.dispose();
					new memberHome().setVisible(true);
					
				*/
			}
		});
		btnNewButton.addKeyListener(new KeyAdapter() {
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setIcon(new ImageIcon(search_member.class.getResource("/imgz/back.png")));
		btnNewButton.setBounds(112, 657, 148, 49);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setIcon(new ImageIcon(Search_Payment.class.getResource("/imgz/update.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				
				try {

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					// System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();

					String payid = (String) table.getValueAt(i, 0);
					String memid = (String) table.getValueAt(i, 1);
					String year = (String) table.getValueAt(i, 2);
					String month = (String) table.getValueAt(i, 3);
					String amount = (String) table.getValueAt(i, 4);
					String status = (String) table.getValueAt(i, 5);
					String paidDate = (String) table.getValueAt(i, 6);

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String sqlupd = "update hostelPayment set year='"+year+"',month='"+month+"',amount='"+amount+"',status='"+status+"',paidDate='"+paidDate+"' where hostelPayID='" + payid
							+ "'";
					stmt = con.createStatement();
					stmt.executeUpdate(sqlupd);

					JOptionPane.showMessageDialog(null, "Data Updated");
					Search_Payment.this.dispose();
					new Search_Payment().setVisible(true);
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Select Row", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(515, 659, 148, 44);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setIcon(new ImageIcon(Search_Payment.class.getResource("/imgz/dlte.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String payid = (String)table.getValueAt(i, 0);
					//String regdate = (String)table.getValueAt(i, 1);
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "delete from hostelPayment  where hostelPayID='"+payid+"'";

            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
            		
            		JOptionPane.showMessageDialog(null, "Data Deleted");
            		Search_Payment.this.dispose();
            		new search_member().setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Select Row", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_2.setBounds(771, 658, 148, 47);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Payment.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add((Element) new Paragraph("Hostel Payment Deatails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(7);
				
				   
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f,2f,2f,2f,2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" hostal pay ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("hostel member ID"));
		                PdfPCell c3= new PdfPCell(new Paragraph("Year"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Month"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Amount"));
		                PdfPCell c6= new PdfPCell(new Paragraph("Status"));
		                PdfPCell c7= new PdfPCell(new Paragraph("Pay date"));


		                table.addCell(c1);
		                table.addCell(c2);
		                table.addCell(c3);
		                table.addCell(c4);
		                table.addCell(c5);
		                table.addCell(c6);
		                table.addCell(c7);

		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
					PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));
						PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
						PdfPCell p3= new PdfPCell(new Paragraph(dtm.getValueAt(i, 3).toString()));
						PdfPCell p4= new PdfPCell(new Paragraph(dtm.getValueAt(i, 4).toString()));
						PdfPCell p5= new PdfPCell(new Paragraph(dtm.getValueAt(i, 5).toString()));
						PdfPCell p6= new PdfPCell(new Paragraph(dtm.getValueAt(i, 6).toString()));

		               
						
						table.addCell(p0);
						table.addCell(p1);
		                table.addCell(p2);
		                table.addCell(p3);
		                table.addCell(p4);
		                table.addCell(p5);
		                table.addCell(p6);


		                }
		            	          
		                    
		                    doc.add(table);
				      

				      
				      JOptionPane.showMessageDialog(null, "Report Saved!");
				      doc.close();
				      
		                
		                  }catch(Exception e){
				         e.printStackTrace();
				     }
				 }
		
				
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_3.setBounds(308, 657, 148, 45);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Search_Payment.class.getResource("/imgz/bg.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
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
        		
        		String sql2 = "select * from hostelPayment";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		
        	
        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
        		
        		while (rs.next()) {
					
        		
        			Vector vv = new Vector();
        			
					vv.add(rs.getString(1));
					vv.add(rs.getString(2));
					vv.add(rs.getString(3));
					vv.add(rs.getString(4));
					vv.add(rs.getString(5));
					vv.add(rs.getString(6));
        			vv.add(rs.getString(7));
					
        			dtm.addRow(vv);
				}
        		
        		
			
		} catch (Exception e2) {
			
		e2.printStackTrace();
		}
		
		
	}
}
