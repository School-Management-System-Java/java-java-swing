package Exam;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EditExam extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditExam frame = new EditExam();
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
	public EditExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ExamID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(460, 85, 81, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.addActionListener(new ActionListener() {
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
		        
		        		
					
					String sql2 ="select * from exam where examID = '"+textField.getText()+"'";
	        		stmt = con.createStatement();
	        		rs=stmt.executeQuery(sql2);	
	        		if(rs.next()) {
	        			textField_2.setText(rs.getString("year"));
	        			textField_3.setText(rs.getString("term"));
	        			textField_1.setText(rs.getString("grade"));
	        			textField_4.setText(rs.getString("startDate"));
	        			textField_5.setText(rs.getString("endDate"));
	        			
	        		}
	        		
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(723, 82, 116, 41);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Year");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(460, 166, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Grade");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(460, 250, 56, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Term");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(460, 361, 56, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Date");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(460, 485, 56, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("From");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(588, 485, 56, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("To");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(588, 579, 56, 16);
		contentPane.add(label_6);
		
		JButton button = new JButton("Confirm");
		button.setIcon(new ImageIcon(EditExam.class.getResource("/Images/diskette.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			
				
					
					
					
					String examId = textField.getText();
					String year = textField_2.getText();
					String term = textField_3.getText();
					String grade = textField_1.getText();
					String from = textField_4.getText();
					String to = textField_5.getText();
					
					if(examId.equals("") || year.equals("") || term.equals("") || grade.equals("") || from.equals("") || to.equals("") ) {
						
						JOptionPane.showMessageDialog(null, "Please Fill the Feilds To Continue", "Error", JOptionPane.ERROR_MESSAGE);
						
					}else {
					try {
						
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "update exam set year='"+year+"',term='"+term+"',grade='"+grade+"',startDate='"+from+"',endDate='"+to+"' where examID='"+examId+"'";
            		stmt = con.createStatement();
           		stmt.executeUpdate(sqlupd);
					
           		JOptionPane.showMessageDialog(null, "Data Updated..!", "Done", JOptionPane.OK_OPTION);
        		EditExam.this.dispose();
        		new EditExam().setVisible(true);
					
				} catch (Exception e) {
				e.printStackTrace();
				}
				
			}
			}
		});
		button.setBounds(104, 753, 135, 58);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditExam.this.dispose();
				new ExamMain().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(EditExam.class.getResource("/Images/back.png")));
		button_1.setBounds(1026, 753, 124, 58);
		contentPane.add(button_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(null);
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
	            		String sqlupd3 = "DELETE FROM exam where examID = '"+examId+"'";
	            		//String sqlupd2 = "ALTER TABLE dbo.examHall CHECK CONSTRAINT FK_hallExamID";
	            		stmt = con.createStatement();
	            		
	            		
	            		
	            		//stmt.executeUpdate(sqlupd);
	            		stmt.executeUpdate(sqlupd3);
	            		//stmt.executeUpdate(sqlupd2);
	            		
	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.OK_OPTION);
	            		EditExam.this.dispose();
	            		new EditExam().setVisible(true);
						
					} catch (Exception e) {
	            		JOptionPane.showMessageDialog(null, "Error", "Cannot Delete Data", JOptionPane.ERROR_MESSAGE);

					}
				
			}
			}
		});
		btnDelete.setBounds(566, 753, 129, 58);
		contentPane.add(btnDelete);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(723, 244, 116, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(723, 162, 116, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setBounds(723, 358, 116, 41);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setBounds(723, 482, 116, 41);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setBounds(723, 576, 116, 41);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEditExam = new JLabel("Edit Exam");
		lblEditExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditExam.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblEditExam.setBounds(27, 41, 309, 94);
		contentPane.add(lblEditExam);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EditExam.class.getResource("/Images/img.png")));
		lblNewLabel.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel);
	}
}
