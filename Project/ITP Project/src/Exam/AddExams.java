package Exam;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.SwingConstants;



public class AddExams extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JFrame hh;

	static AddExams yy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExams frame = new AddExams();
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
	public AddExams() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ExamID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(374, 98, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(374, 190, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Grade");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(374, 284, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Term");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(374, 384, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(374, 467, 56, 16);
		contentPane.add(lblDate);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFrom.setBounds(590, 467, 56, 16);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTo.setBounds(590, 559, 56, 16);
		contentPane.add(lblTo);
		
		JCheckBox chckbxTermsAndCondition = new JCheckBox("Terms and Conditions");
		chckbxTermsAndCondition.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTermsAndCondition.setBounds(481, 640, 210, 25);
		contentPane.add(chckbxTermsAndCondition);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(AddExams.class.getResource("/Images/back.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddExams.this.dispose();
				new ExamMain().setVisible(true);
			}
		});
		btnCancel.setBounds(930, 695, 116, 59);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(650, 95, 176, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019", "2020", "2021"}));
		comboBox.setBounds(650, 187, 176, 39);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}));
		comboBox_1.setBounds(650, 281, 176, 39);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		comboBox_2.setBounds(650, 381, 176, 39);
		contentPane.add(comboBox_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(658, 467, 178, 39);
		contentPane.add(dateChooser);
		
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy/MM/dd");
		dateChooser_1.setBounds(658, 553, 178, 39);
		contentPane.add(dateChooser_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setIcon(new ImageIcon(AddExams.class.getResource("/Images/diskette.png")));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String examId = textField.getText(); 
				String x = (String) comboBox.getSelectedItem();
				
				String y = (String) comboBox_1.getSelectedItem();
				String z = (String) comboBox_2.getSelectedItem();
				
				boolean chk = chckbxTermsAndCondition.isSelected();
				
				/*SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
				
				String d11 = sdf1.format(dateChooser.getDate());
				String d22 = sdf1.format(dateChooser_1.getDate());*/
				
				
				if(x.equals("") || examId.equals("") || dateChooser.getDate() == null|| dateChooser_1.getDate() == null   ) {
					
					JOptionPane.showMessageDialog(null, "Please Fill All Feilds To Continue", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(chk == false){
					JOptionPane.showMessageDialog(null, "Please Agree To Terms And Conditions", "Error", JOptionPane.ERROR_MESSAGE);

				}else {
					
					try {
						int year = Integer.parseInt(x);
						int Grade = Integer.parseInt(y);
						int term = Integer.parseInt(z);
						
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
						
						String d1 = sdf.format(dateChooser.getDate());
						String d2 = sdf.format(dateChooser_1.getDate());
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            		
		            		String sql1 = "select * from exam where examID ='"+examId+"'";
		            		
		            		stmt2 = con.createStatement();
		            		
		            		rs = stmt2.executeQuery(sql1);
		            		
		            		if(rs.next()) {
		            			JOptionPane.showMessageDialog(null, "ExamID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
		            		}
		            		else{
		            
		            	
		            		String SQL = "INSERT INTO exam (examID, year, grade, term, startDate, endDate)\r\n" + 
		            				"VALUES ('"+examId+"', '"+year+"', '"+Grade+"', '"+term+"', '"+d1+"','"+d2+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
		            		
		            		JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.OK_OPTION);
							
		            		textField.setText("");
		            		comboBox.setSelectedItem("");
		            		comboBox_1.setSelectedItem("");
		            		comboBox_2.setSelectedItem("");
		            		chckbxTermsAndCondition.setSelected(false);
		            		dateChooser.setDate(null);
		            		dateChooser_1.setDate(null);
		            		
		            		}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					
					
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		btnConfirm.setBounds(156, 695, 135, 59);
		contentPane.add(btnConfirm);
		
		JLabel lblAddExams = new JLabel("Add Exams");
		lblAddExams.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExams.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblAddExams.setBounds(15, 62, 309, 94);
		contentPane.add(lblAddExams);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(AddExams.class.getResource("/Images/img.png")));
		lblNewLabel_4.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel_4);
	}
}
