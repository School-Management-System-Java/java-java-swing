package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class AddSubject extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubject frame = new AddSubject();
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
	public AddSubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSubjectName.setBounds(185, 251, 169, 52);
		contentPane.add(lblSubjectName);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char uu = arg0.getKeyChar();
				String txr = textField.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Subject ID", "Error", JOptionPane.ERROR_MESSAGE);
				
				}}
		});
		textField.setBounds(408, 177, 250, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSubjectGrade = new JLabel("Subject ID");
		lblSubjectGrade.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSubjectGrade.setBounds(185, 170, 190, 52);
		contentPane.add(lblSubjectGrade);
		
		JButton btnNewButton = new JButton("Add Subject");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String lblSubjectName  = textField.getText();
				
				String subID  = textField_1.getText();
				//String lblSubjectGrade= text
				
				
				if(lblSubjectName.equals("")|| subID.equals("") ) {
					
					JOptionPane.showMessageDialog(AddSubject.this, "error", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
				}
							
else {
					
					try {
						
						
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO subject (subjectID, name)\r\n" + 
		            				"VALUES ('"+lblSubjectName+"', '"+subID+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					textField.setText("");
            		textField_1.setText("");;
            		
            		textField.grabFocus();
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setIcon(new ImageIcon(AddSubject.class.getResource("/imgz/diskette.png")));
		btnNewButton.setBounds(421, 380, 281, 53);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddSubject.this.dispose();
				new SHome().setVisible(true);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddSubject.class.getResource("/imgz/back.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(421, 484, 281, 53);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
	    textField_1.setBounds(408, 260, 250,50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddSubject.class.getResource("/imgz/bg.png")));
		lblNewLabel.setBounds(0, 0, 1250, 853);
		contentPane.add(lblNewLabel);
	}
}
