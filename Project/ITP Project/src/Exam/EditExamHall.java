package Exam;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EditExamHall extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditExamHall frame = new EditExamHall();
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
	public EditExamHall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Statement stmt2 = null;
					
					ResultSet rs = null;
					ResultSet rss = null;
					// Establish the connection.
		    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        		con = DriverManager.getConnection(connectionUrl);
		        
		        		
					
					String sql2 ="select * from examHall where examID = '"+textField.getText()+"'";
					String sql3 ="select * from examHallArrang where examID = '"+textField.getText()+"'";
	        		stmt = con.createStatement();
	        		stmt2 = con.createStatement();
	        		rs=stmt.executeQuery(sql2);
	        		rss=stmt2.executeQuery(sql3);
	        		
	        		if(rs.next() && rss.next()) {
	        			textField_1.setText(rss.getString("staffID"));
	        			textField_2.setText(rs.getString("hallNo"));
	        			textField_3.setText(rs.getString("sectionID"));
	        			
	        			
	        			
	        		}
	        		
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
			
		textField.setColumns(10);
		textField.setBounds(681, 66, 164, 47);
		contentPane.add(textField);
		
		JLabel label = new JLabel("ExamID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(431, 69, 86, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("StaffID");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(431, 178, 86, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(681, 175, 164, 47);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(681, 289, 164, 47);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("Hall number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_2.setBounds(431, 292, 116, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("SectionID");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_3.setBounds(431, 418, 116, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(681, 406, 164, 47);
		contentPane.add(textField_3);
		
		JButton button = new JButton("Confirm");
		button.setIcon(new ImageIcon(EditExamHall.class.getResource("/Images/diskette.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
					
					
					
					String examId = textField.getText();
					String hallno = textField_2.getText();
					String secId = textField_3.getText();
					

					if(examId.equals("") || hallno.equals("") || secId.equals("") ) {
						
						JOptionPane.showMessageDialog(null, "Please Fill the Feilds To Continue", "Error", JOptionPane.ERROR_MESSAGE);
						
					}else {
					
					try {
						
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		//String sqlupd2 = "ALTER TABLE dbo.examHallArrang NOCHECK CONSTRAINT FK_hallArrangExamID";
            		String sqlupd = "update examHall set hallNo='"+hallno+"',sectionID='"+secId+"' where examID='"+examId+"'";
            		String sqlupd1 = "update examHallArrang set sectionID='"+secId+"' where examID='"+examId+"'";
            		//String sqlupd3 = "ALTER TABLE dbo.examHallArrang CHECK CONSTRAINT FK_hallArrangExamID";
            		stmt = con.createStatement();
            		
            		//stmt.executeUpdate(sqlupd2);	
           		stmt.executeUpdate(sqlupd);
           		stmt.executeUpdate(sqlupd1);
           		//stmt.executeUpdate(sqlupd3);
           		
           		JOptionPane.showMessageDialog(null, "Data Updated..!", "Done", JOptionPane.OK_OPTION);
        		EditExamHall.this.dispose();
        		new EditExamHall().setVisible(true);
					
				} catch (Exception e) {
				e.printStackTrace();
				}
				
			}
			}
		});
		button.setBounds(116, 739, 127, 59);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditExamHall.this.dispose();
				new ExamMain().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(EditExamHall.class.getResource("/Images/back.png")));
		button_1.setBounds(1015, 739, 116, 59);
		contentPane.add(button_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
						
						
						
						
						String examId = textField.getText();
						
						

						if(examId.equals("") ) {
							
							JOptionPane.showMessageDialog(null, "Please Fill the ExamID Feild To Continue", "Error", JOptionPane.ERROR_MESSAGE);
							
						}else {
						try {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            		
	            		
	            		
	            		//String sqlupd = "ALTER TABLE dbo.examHall NOCHECK CONSTRAINT FK_hallExamID";
	            		//String sqlupd5 = "ALTER TABLE dbo.examHallArrang NOCHECK CONSTRAINT FK_hallArrangExamID";
	            		String sqlupd3 = "DELETE FROM examHall where examID = '"+examId+"'";
	            		String sqlupd4 = "DELETE FROM examHallArrang where examID = '"+examId+"'";
	            		//String sqlupd6 = "ALTER TABLE dbo.examHallArrang CHECK CONSTRAINT FK_hallArrangExamID";
	            		//String sqlupd2 = "ALTER TABLE dbo.examHall CHECK CONSTRAINT FK_hallExamID";
	            		stmt = con.createStatement();
	            		
	            		
	            		
	            		//stmt.executeUpdate(sqlupd);
	            		//stmt.executeUpdate(sqlupd5);
	            		stmt.executeUpdate(sqlupd3);
	            		stmt.executeUpdate(sqlupd4);
	            		//stmt.executeUpdate(sqlupd6);
	            		//stmt.executeUpdate(sqlupd2);
	            		
	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.OK_OPTION);
	            		EditExamHall.this.dispose();
	            		new EditExamHall().setVisible(true);
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Cannot Delete This Data..!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			}
			}
		});
		btnDelete.setBounds(582, 739, 109, 59);
		contentPane.add(btnDelete);
		
		JLabel lblEditExamHalls = new JLabel("Edit Exam Halls");
		lblEditExamHalls.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditExamHalls.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblEditExamHalls.setBounds(31, 40, 309, 94);
		contentPane.add(lblEditExamHalls);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EditExamHall.class.getResource("/Images/img.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
	}
}
