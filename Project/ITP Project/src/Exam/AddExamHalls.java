package Exam;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class AddExamHalls extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JFrame hh;

	static AddExamHalls yy;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExamHalls frame = new AddExamHalls();
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
	public AddExamHalls() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ExamID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(428, 30, 84, 16);
		contentPane.add(label);
		
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_1.setText(list.getSelectedValue().toString());
			}
			
			
		});
		list.setBounds(788, 270, 126, 141);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			 
				
				
				try {
					textField.setText(list_1.getSelectedValue().toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select Valid Value", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		list_1.setBounds(788, 29, 125, 200);
		contentPane.add(list_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
try {
	
	
	String txttype = textField.getText();
	
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=ITP_Project;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(connectionUrl);

		// Create and execute an SQL statement that returns some data.
		String SQL = "SELECT *	FROM exam  where examID like'"+txttype+"%'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(SQL);

		// Iterate through the data in the result set and display it.
		Vector cc = new Vector();
		while (rs.next()) {
			
			
			
			cc.add(rs.getString(1));
			list_1.setListData(cc);// add data to vector and set the vector to list
			//System.out.println(rs.getString(3));
		}
		
} catch (Exception e) {
	e.printStackTrace();;
}
				
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(605, 27, 126, 55);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("StaffID");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(428, 271, 84, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					
					
					String txttype1 = textField_1.getText();
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

						// Declare the JDBC objects.
						Connection con = null;
						java.sql.Statement stmt = null;
						ResultSet rs = null;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con = DriverManager.getConnection(connectionUrl);

						// Create and execute an SQL statement that returns some data.
						String SQL2 = "SELECT *	FROM staff  where staffID like'"+txttype1+"%'";
						stmt = con.createStatement();
						rs = stmt.executeQuery(SQL2);

						// Iterate through the data in the result set and display it.
						Vector cc = new Vector();
						while (rs.next()) {
							
							
							
							cc.add(rs.getString(1));
							list.setListData(cc);// add data to vector and set the vector to list
							//System.out.println(rs.getString(3));
						}
						
				} catch (Exception e) {
					e.printStackTrace();;
				}
								
								
							}
						});
		textField_1.setColumns(10);
		textField_1.setBounds(605, 268, 126, 57);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Hall number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(428, 415, 116, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_ENTER || key == KeyEvent.VK_BACK_SPACE) {
					Toolkit.getDefaultToolkit().beep();
				}else {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c))) {
					arg0.consume();
					JOptionPane.showMessageDialog(null,"Cannot enter characters..!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(605, 412, 126, 55);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("SectionID");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(428, 517, 101, 16);
		contentPane.add(label_3);
		
		JCheckBox checkBox = new JCheckBox("Terms and Conditions");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBox.setBounds(532, 678, 220, 25);
		contentPane.add(checkBox);
		
		JButton button = new JButton("Confirm");
		button.setIcon(new ImageIcon(AddExamHalls.class.getResource("/Images/diskette.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String examId = textField.getText(); 
				String staffId = textField_1.getText(); 
				
				String hallNo = textField_2.getText(); 
				String secID = textField_4.getText(); 
				
				
				boolean chk = checkBox.isSelected();
				
				
				
				
				if(examId.equals("") || staffId.equals("") || hallNo.equals("") || secID.equals("")  ) {
					
					JOptionPane.showMessageDialog(null, "Please Fill All Feilds To Continue", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(chk == false){
					JOptionPane.showMessageDialog(null, "Please Agree To Terms And Conditions", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					
					try {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						java.sql.Statement stmt = null;
						java.sql.Statement stmt4 = null;
						java.sql.Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            		
		            		String sql1 = "select * from examHall where examID ='"+examId+"'";
		            		
		            		stmt2 = con.createStatement();
		            		
		            		rs = stmt2.executeQuery(sql1);
		            		
		            		if(rs.next()) {
		            			JOptionPane.showMessageDialog(null, "ExamID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
		            		}
		            		
		            		else{
		            
		            	
		            		String SQL = "INSERT INTO examHall (examID, sectionID, hallNo)\r\n" + 
		            				"VALUES ('"+examId+"', '"+secID+"', '"+hallNo+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
		            		
		            		String SQL1 = "INSERT INTO examHallArrang (examID, sectionID, staffID)\r\n" + 
		            				"VALUES ('"+examId+"', '"+secID+"', '"+staffId+"');";
		            		
		            		stmt4 = con.createStatement();
		            		
		            		
		            		stmt4.executeUpdate(SQL1);
		            		
		            		JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.OK_OPTION);
							
		            		textField.setText(""); 
		    				textField_1.setText(""); 
		    				
		    				textField_2.setText(""); 
		    				textField_4.setText("");
		    				
		    				 
		    				
		    				checkBox.setSelected(false);
		    				
							
		            		}
					} catch (Exception e) {
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null,"Do not exceed the character limit!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					
					
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		button.setBounds(132, 723, 116, 55);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddExamHalls.this.dispose();
				new ExamMain().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(AddExamHalls.class.getResource("/Images/back.png")));
		button_1.setBounds(1028, 723, 116, 55);
		contentPane.add(button_1);
			
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_4.setBounds(605, 514, 126, 55);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
					
					JButton btnDemo = new JButton("Demo");
					btnDemo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							textField.setText("E020");
							textField_1.setText("S001");
							textField_2.setText("7");
							textField_4.setText("7A");
						}
					});
					btnDemo.setBounds(571, 723, 116, 55);
					contentPane.add(btnDemo);
					
					JLabel lblAddExamHall = new JLabel("Add Exam Hall");
					lblAddExamHall.setHorizontalAlignment(SwingConstants.CENTER);
					lblAddExamHall.setBounds(15, 29, 309, 94);
					lblAddExamHall.setFont(new Font("Tahoma", Font.BOLD, 27));
					contentPane.add(lblAddExamHall);
				
					
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setIcon(new ImageIcon(AddExamHalls.class.getResource("/Images/img.png")));
					lblNewLabel.setBounds(0, -1, 1232, 853);
					contentPane.add(lblNewLabel);
	}
}
