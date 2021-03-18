package Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

import Common.ComboBox;
import Common.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class StudentReportMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentReportMain frame = new StudentReportMain();
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
	public StudentReportMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(512, 226, 280, 50);
		contentPane.add(comboBox);
		
		comboBox.addItem(new ComboBox("Recentnly add 10 students", "ten"));
		comboBox.addItem(new ComboBox("Recentnly add 100 students", "hun"));
		comboBox.addItem(new ComboBox("Recentnly add 1000 students", "tho"));
		comboBox.addItem(new ComboBox("All Students", "all"));
		
		JLabel lblGenerateReport = new JLabel("Generate Report");
		lblGenerateReport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGenerateReport.setBounds(331, 233, 166, 32);
		contentPane.add(lblGenerateReport);
		
		JLabel lblGenerateReport_1 = new JLabel("Generate Report");
		lblGenerateReport_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblGenerateReport_1.setBounds(407, 65, 296, 56);
		contentPane.add(lblGenerateReport_1);
		
		JButton btnGererateReport = new JButton("Gererate");
		btnGererateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con;
				PreparedStatement stmt;
				ResultSet rs;

				try {
					String query,msg;
					
					Object item = comboBox.getSelectedItem();
					String select = ((ComboBox)item).getValue();
					
					con = DBConnection.getDBConnection();

					if (select.equals("ten")) {
						query = "select top 10 studentID,nameWithInitial,dob,gender,homePhone,email,joinedDate from student order by studentID desc";
						msg="Recently added 10 records";
					} else if (select.equals("hun")) {
						query = "select top 100 studentID,nameWithInitial,dob,gender,homePhone,email,joinedDate from student order by studentID desc";
						msg="Recently added 100 records";
					} else if (select.equals("tho")) {
						query = "select top 1000 studentID,nameWithInitial,dob,gender,homePhone,email,joinedDate from student order by studentID desc";
						msg="Recently added 1000 records";
					} else {
						query = "select studentID,nameWithInitial,dob,gender,homePhone,email,joinedDate from student";
						msg="All records of Student table";
					}
					
					stmt = con.prepareStatement(query);
					rs = stmt.executeQuery();

					Document doc = new Document();
					PdfWriter.getInstance(doc, new FileOutputStream("Student List.pdf"));
					doc.open();
					Image image = Image.getInstance("download.jpg");
					doc.add(image);
					doc.add(new Paragraph("Student List Datails",
							FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD)));
					doc.add(new Paragraph(msg,FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD)));
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  
					doc.add(new Paragraph(dtf.format(now)));
					doc.add(new Paragraph("------------------------------------------------------------------"));
					PdfPTable table = new PdfPTable(7);

					table.setWidthPercentage(100);
					table.setSpacingBefore(10f);
					table.setSpacingAfter(10f);

					float[] colWidth = { 2f, 2f, 2f, 2f, 2f, 2f, 2f };
					table.setWidths(colWidth);
					PdfPCell c1 = new PdfPCell(new Paragraph("Student ID"));
					PdfPCell c2 = new PdfPCell(new Paragraph("Name with Initial"));
					PdfPCell c3 = new PdfPCell(new Paragraph("Date of Birth"));
					PdfPCell c4 = new PdfPCell(new Paragraph("Gender"));
					PdfPCell c5 = new PdfPCell(new Paragraph("Phone Number"));
					PdfPCell c6 = new PdfPCell(new Paragraph("Eamail Address"));
					PdfPCell c7 = new PdfPCell(new Paragraph("Join Date"));

					table.addCell(c1);
					table.addCell(c2);
					table.addCell(c3);
					table.addCell(c4);
					table.addCell(c5);
					table.addCell(c6);
					table.addCell(c7);

					while (rs.next()) {
						PdfPCell p1,p3,p4,p5,p6;
						
						PdfPCell p0 = new PdfPCell(new Paragraph(rs.getString(1).toString()));
						
						if(rs.getString(2)==null||rs.getString(2).toString()==null) {
							p1 = new PdfPCell(new Paragraph(""));
						}else {
							p1 = new PdfPCell(new Paragraph(rs.getString(2).toString()));
						}
						
						PdfPCell p2 = new PdfPCell(new Paragraph(rs.getString(3).toString()));
						
						if (rs.getString(4).toString().equals("M")) {
							p3 = new PdfPCell(new Paragraph("Male"));
						} else {
							p3 = new PdfPCell(new Paragraph("Female"));
						}
						
						if(rs.getString(5)==null||rs.getString(5).toString()==null) {
							p4 = new PdfPCell(new Paragraph(""));
						}else {
							p4 = new PdfPCell(new Paragraph(rs.getString(5).toString()));
						}
						
						if(rs.getString(6)==null||rs.getString(6).toString()==null) {
							p5 = new PdfPCell(new Paragraph(""));
						}else {
							p5 = new PdfPCell(new Paragraph(rs.getString(6).toString()));
						}
						
						if(rs.getString(7)==null||rs.getString(7).toString()==null) {
							p6 = new PdfPCell(new Paragraph(""));
						}else {
							p6 = new PdfPCell(new Paragraph(rs.getString(7).toString()));
						}

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

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnGererateReport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGererateReport.setBounds(339, 392, 180, 50);
		contentPane.add(btnGererateReport);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentMain sMain = new StudentMain();
				sMain.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(601, 392, 180, 50);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentReportMain.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
		
		
	}
}
