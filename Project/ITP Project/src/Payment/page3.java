package Payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

public class page3 {

	private JFrame frame;
	String paymentID,studentID,type,amount,paidDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page3 window = new page3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public page3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBorder(new LineBorder(new Color(102, 204, 204), 12));
		panel.setBounds(0, 11, 739, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel jtxtPaymentID = new JLabel("Payment  ID");
		jtxtPaymentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtPaymentID.setBounds(24, 153, 122, 35);
		panel.add(jtxtPaymentID);
		
		JLabel lblNewLabel_1 = new JLabel("Annual  Fees  Payment");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(181, 38, 481, 42);
		panel.add(lblNewLabel_1);
		
		JLabel jtxtRegNo = new JLabel("Student ID");
		jtxtRegNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtRegNo.setBounds(24, 219, 134, 35);
		panel.add(jtxtRegNo);
		
		JLabel jtxtName = new JLabel("Name");
		jtxtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtName.setBounds(24, 289, 134, 35);
		panel.add(jtxtName);
		
		JLabel jtxtClass = new JLabel("Class");
		jtxtClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtClass.setBounds(384, 219, 71, 35);
		panel.add(jtxtClass);
		
		JLabel jtxtYear = new JLabel("Year");
		jtxtYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtYear.setBounds(384, 160, 77, 35);
		panel.add(jtxtYear);
		
		JLabel jtxtPaidDate = new JLabel("Paid Date");
		jtxtPaidDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtPaidDate.setBounds(384, 289, 105, 35);
		panel.add(jtxtPaidDate);
		
		JLabel jtxtTotalAmount = new JLabel("Amount");
		jtxtTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtTotalAmount.setBounds(491, 526, 134, 35);
		panel.add(jtxtTotalAmount);
		
		JLabel lblAddress = new JLabel("Amount");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(24, 418, 134, 35);
		panel.add(lblAddress);
		
		JLabel jtxtPaymentType = new JLabel("Payment Type");
		jtxtPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtPaymentType.setBounds(384, 353, 144, 35);
		panel.add(jtxtPaymentType);
		
		JFormattedTextField txtPaymentID = new JFormattedTextField();
		txtPaymentID.setForeground(Color.LIGHT_GRAY);
		txtPaymentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPaymentID.setBounds(168, 153, 206, 50);
		panel.add(txtPaymentID);
		
		JFormattedTextField txtStudentID = new JFormattedTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStudentID.setBounds(168, 217, 206, 53);
		panel.add(txtStudentID);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_2.setBounds(168, 280, 206, 53);
		panel.add(formattedTextField_2);
		
		JFormattedTextField txtAmount = new JFormattedTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAmount.setBounds(168, 409, 206, 53);
		panel.add(txtAmount);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_4.setBounds(540, 144, 163, 53);
		panel.add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_5.setBounds(540, 210, 163, 53);
		panel.add(formattedTextField_5);
		
		JFormattedTextField txtPaidDate = new JFormattedTextField();
		txtPaidDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPaidDate.setBounds(540, 280, 163, 53);
		panel.add(txtPaidDate);
		
		JFormattedTextField txtType = new JFormattedTextField();
		txtType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtType.setBounds(539, 344, 164, 53);
		panel.add(txtType);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo.setBounds(24, 344, 134, 53);
		panel.add(lblPhoneNo);
		
		JLabel show_validation_here = new JLabel("");
		show_validation_here.setForeground(Color.RED);
		show_validation_here.setFont(new Font("Tahoma", Font.PLAIN, 13));
		show_validation_here.setBounds(222, 418, 144, 22);
		panel.add(show_validation_here);
		
		JFormattedTextField test_Text = new JFormattedTextField();
		test_Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		test_Text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				try {
					int i=Integer.parseInt(test_Text.getText());
					show_validation_here.setText("");
					
				} catch (NumberFormatException e) {
					show_validation_here.setText("Invalid number");
				}
			}
		});
		test_Text.setBounds(168, 344, 206, 53);
		panel.add(test_Text);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(102, 204, 204), 12));
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(749, 11, 325, 597);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea jtxtTranscript = new JTextArea();
		jtxtTranscript.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtTranscript.setBounds(22, 24, 282, 550);
		panel_1.add(jtxtTranscript);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBounds(0, 519, 739, 89);
		frame.getContentPane().add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(102, 204, 204), 12));
		panel_2.setBackground(new Color(102, 204, 255));
		panel_2.setLayout(null);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.setForeground(Color.BLACK);
		btnTranscript.setBackground(Color.LIGHT_GRAY);
		btnTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtTranscript.setText("");
				jtxtTranscript.append("Annual Exam Fees Payment\n"
				+"================================\n"
				+"Payment ID:\t"+jtxtPaymentID.getText().toString()
				+"\nReg No:\t"+jtxtRegNo.getText().toString()
				+"\nName:\t"+jtxtName.getText().toString()
				+"\nYear:\t"+jtxtYear.getText().toString()
				+"\nClass:\t"+jtxtClass.getText().toString()
				+"\nPaid Date:\t"+jtxtPaidDate.getText().toString()
				+"\nPayment Type:\t"+jtxtPaymentType.getText().toString()
				+"\n=============================="
				+"\nTotal Amount:\t"+jtxtTotalAmount.getText().toString()+"\n");
				
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
						"databaseName=ITP_Project;integratedSecurity=true;";

					// Declare the JDBC objects.
					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
			        	try {
			        		// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            		
			            		paymentID = txtPaymentID.getText().toString();
			            		studentID = txtStudentID.getText().toString();
			            		type = txtType.getText().toString();
			            		amount = txtAmount.getText().toString();
			            		paidDate = txtPaidDate.getText().toString();
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = "insert into payment values(?,?,?,?,?)";
			            		stmt = con.prepareStatement(SQL);
			            		stmt.setString(1, paymentID);
			            		stmt.setString(2, studentID);
			            		stmt.setString(3, type);
			            		stmt.setString(4, amount);
			            		stmt.setString(5, paidDate);
			            		JOptionPane.showMessageDialog(null, "Insert Successfully");
			            		stmt.executeQuery();
			            
			            		// Iterate through the data in the result set and display it.
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e1) {
						e1.printStackTrace();
					}
				
				
				
			}
		});
		btnTranscript.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTranscript.setBounds(32, 24, 144, 42);
		panel_2.add(btnTranscript);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setBackground(Color.LIGHT_GRAY);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header = new MessageFormat("Printing in progress");
				MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				
				try
				{
					jtxtTranscript.print();
				
				}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("No Printer Found", ev.getMessage());
				}
				
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPrint.setBounds(212, 24, 149, 42);
		panel_2.add(btnPrint);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFormattedTextField temp=null;
				for(Component c:panel.getComponents()){
					if(c.getClass().toString().contains("javax.swing.JFormattedTextField")) {
						temp=(JFormattedTextField)c;
						temp.setText(null);
					}
				}
				jtxtTranscript.setText(null); 
				txtAmount.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(387, 24, 149, 42);
		panel_2.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Annual Exam Fees Management",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}*/
				frame.dispose();
				page1 Page1 = new page1();
				Page1.main(null);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(573, 24, 129, 42);
		panel_2.add(btnExit);
	}
}
