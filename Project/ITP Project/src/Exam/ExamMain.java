package Exam;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import Main.Home;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ExamMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private static JTable table;
	private static JTable table_1;
	JFrame jf;
	
	static ExamMain em;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamMain frame = new ExamMain();
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
	public ExamMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ExamMain.this.dispose();
				new AddExams().setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/download (3).png")));
		label_2.setBounds(54, 168, 100, 100);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ExamMain.this.dispose();
				new EditExam().setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/download (2).png")));
		label_3.setBounds(292, 168, 100, 100);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ExamMain.this.dispose();
				new AddExamHalls().setVisible(true);
				
			}
		});
		label_4.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/download (4).png")));
		label_4.setBounds(63, 485, 100, 100);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ExamMain.this.dispose();
				new EditExamHall().setVisible(true);
				

			}
		});
		label_5.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/download.png")));
		label_5.setBounds(302, 485, 100, 100);
		contentPane.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(457, 0, 27, 798);
		contentPane.add(separator);
		
		JLabel label_6 = new JLabel("View Exam Dates");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(511, 35, 147, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Year");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(474, 108, 56, 16);
		contentPane.add(label_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019", "2020", "2021"}));
		comboBox.setBounds(587, 105, 92, 22);
		contentPane.add(comboBox);
		
		
		JLabel label_8 = new JLabel("Term");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_8.setBounds(474, 186, 56, 16);
		contentPane.add(label_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		comboBox_1.setBounds(587, 183, 92, 22);
		contentPane.add(comboBox_1);
		
		JLabel label_9 = new JLabel("Grade");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(474, 276, 56, 16);
		contentPane.add(label_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}));
		comboBox_2.setBounds(587, 273, 92, 22);
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("Search");
		button.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/search (1).png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
		        		
		        		String selection = (String) comboBox.getSelectedItem().toString();
		        		String selection1 = (String) comboBox_1.getSelectedItem().toString();
		        		String selection2 = (String) comboBox_2.getSelectedItem().toString();
		        		if(selection.equals("") && selection1.equals("") && selection2.equals("")) {
		        			JOptionPane.showMessageDialog(null,"Please Fill At Least One Feild To Continue", "Error", JOptionPane.ERROR_MESSAGE);
		        		}else {
		        		if(selection1.equals("") && selection2.equals("")) {
		        		String sql2 ="select * from exam where year ='"+selection+"'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
						}
		        		
		        		else if(selection.equals("") && selection2.equals("")) {
		        			String sql2 ="select * from exam where term ='"+selection1+"'";
			        		stmt = con.createStatement();
			        		rs=stmt.executeQuery(sql2);	
			        		
			        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
		        		}	else if(selection.equals("") && selection1.equals("")) {
		        			String sql2 ="select * from exam where grade ='"+selection2+"'";
			        		stmt = con.createStatement();
			        		rs=stmt.executeQuery(sql2);	
			        		
			        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
		        		}
		        		else if(selection2.equals("")) {
		        			String sql2 ="select * from exam where term ='"+selection1+"'and year ='"+selection+"'";
			        		stmt = con.createStatement();
			        		rs=stmt.executeQuery(sql2);	
			        		
			        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
		        		}
		        		else if(selection1.equals("")) {
			        		String sql2 ="select * from exam where year ='"+selection+"'and grade ='"+selection2+"'";
			        		stmt = con.createStatement();
			        		rs=stmt.executeQuery(sql2);	
			        		
			        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
							}
		        		
		        		else if(selection.equals("")) {
		        			String sql2 ="select * from exam where grade ='"+selection2+"'and term ='"+selection1+"'";
			        		stmt = con.createStatement();
			        		rs=stmt.executeQuery(sql2);	
			        		
			        		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
		        		}
		        		
		        		else{
		        			String sql2 ="select * from exam where grade ='"+selection2+"'and term ='"+selection1+"'and year ='"+selection+"'";
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
		        		}
		        		}	
		        		
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
			}
		});
		button.setBounds(511, 348, 126, 41);
		contentPane.add(button);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(507, 460, 713, 16);
		contentPane.add(separator_1);
		
		JLabel label_10 = new JLabel("View Exam Hall");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_10.setBounds(532, 489, 147, 16);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("ExamID");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_11.setBounds(474, 631, 75, 16);
		contentPane.add(label_11);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(588, 628, 91, 22);
		contentPane.add(textField_2);
		
		JButton button_1 = new JButton("Search");
		button_1.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/search (1).png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

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
		        		
		        		String exID = textField_2.getText();
		        		
		        		if(exID.equals("")) {
		        			JOptionPane.showMessageDialog(null,"Please Fill the Feild To Continue", "Error", JOptionPane.ERROR_MESSAGE);
		        		}
		        		else {
		        		String sql6 = "select e.examID, e.sectionID, e.hallNo, eh.staffID from examHall e, examHallArrang eh where e.examID=eh.examID and e.sectionID = eh.sectionID and e.examID ='"+exID+"'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql6);	
		        		
		        		DefaultTableModel dtm1 =(DefaultTableModel) table_1.getModel();
		        		dtm1.setRowCount(0);
		        		while (rs.next()) {
							
		        			Vector vv = new Vector();
		        			
							vv.add(rs.getString(1));
							vv.add(rs.getString(2));
							vv.add(rs.getString(3));
							vv.add(rs.getString(4));
							
		        			
		        			dtm1.addRow(vv);
						}
		        		}
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
			}
		});
			
		button_1.setBounds(511, 704, 126, 41);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Add Exam");
		lblNewLabel_1.setBounds(63, 292, 100, 41);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edit exams");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(302, 292, 86, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Add Exam Hall");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(54, 619, 120, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edit Exam Hall");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(292, 610, 120, 37);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(714, 27, 506, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ExamID", "Year", "Grade", "Term", "startDate", "endDate"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(714, 519, 506, 261);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ExamId", "SectionID", "HallNO", "StaffID"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/back.png")));
		btnNewButton.setBounds(182, 757, 120, 41);
		contentPane.add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Dinusha.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Exam Timetable Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
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
		                PdfPCell c1= new PdfPCell(new Paragraph(" Exam ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("Year"));
		                PdfPCell c3= new PdfPCell(new Paragraph("Grade"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Term"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Start Date"));
		                PdfPCell c6= new PdfPCell(new Paragraph("End Date"));
		                

		                table.addCell(c1);
		                table.addCell(c2);
		                table.addCell(c3);
		                table.addCell(c4);
		                table.addCell(c5);
		                table.addCell(c6);
		                
		                
		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
					PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));
						PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
						PdfPCell p3= new PdfPCell(new Paragraph(dtm.getValueAt(i, 3).toString()));
						PdfPCell p4= new PdfPCell(new Paragraph(dtm.getValueAt(i, 4).toString()));
						PdfPCell p5= new PdfPCell(new Paragraph(dtm.getValueAt(i, 5).toString()));
						
						
		               
						
						table.addCell(p0);
						table.addCell(p1);
		                table.addCell(p2);
		                table.addCell(p3);
		                table.addCell(p4);
		                table.addCell(p5);
		                
		                


		                }
		            	
					

							 
		                
		                    
		                    doc.add(table);
				      				      
				      
				      JOptionPane.showMessageDialog(null, "Report Saved!");
				      doc.close();
				      
		                
		                  }catch(Exception e){
				         e.printStackTrace();
				     }
				 
			}
		});
		btnPrint.setBounds(511, 402, 126, 41);
		contentPane.add(btnPrint);
		
		JLabel lblExamManager = new JLabel("Exam Manager");
		lblExamManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamManager.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblExamManager.setBounds(79, 27, 309, 94);
		contentPane.add(lblExamManager);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon(ExamMain.class.getResource("/Images/img.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
	}
}
