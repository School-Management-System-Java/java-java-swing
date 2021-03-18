package Payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class page5 {

	private JFrame frame;
	private String paymentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page5 window = new page5();
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
	public page5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeletePayment = new JLabel("Delete   Payment");
		lblDeletePayment.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblDeletePayment.setBounds(76, 61, 344, 35);
		frame.getContentPane().add(lblDeletePayment);
		
		JLabel label_1 = new JLabel("Payment  ID");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(76, 218, 168, 35);
		frame.getContentPane().add(label_1);
		
		JFormattedTextField txtPaymentID = new JFormattedTextField();
		txtPaymentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPaymentID.setBackground(new Color(255, 255, 255));
		txtPaymentID.setBounds(361, 207, 280, 50);
		frame.getContentPane().add(txtPaymentID);
		
		JButton btnDelete = new JButton("Delete");
		Image image3 = new ImageIcon(this.getClass().getResource("../image/dlte.png")).getImage();
		btnDelete.setIcon(new ImageIcon(image3));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = "delete payment where paymentID=?";
			            		stmt = con.prepareStatement(SQL);
			            		stmt.setString(1, paymentID);
			            		JOptionPane.showMessageDialog(null, "Delete Successfully");
			            		stmt.execute();
			            
			            		// Iterate through the data in the result set and display it.
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e1) {
						e1.printStackTrace();
					}
				
				
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(361, 321, 155, 53);
		frame.getContentPane().add(btnDelete);
		
		JButton button_1 = new JButton("Exit");
		Image image2 = new ImageIcon(this.getClass().getResource("../image/back.png")).getImage();
		button_1.setIcon(new ImageIcon(image2));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setForeground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				page1 Page1 = new page1();
				Page1.main(null);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(921, 547, 142, 53);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image image1 = new ImageIcon(this.getClass().getResource("../image/cash.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image1));
		lblNewLabel.setBounds(731, 207, 265, 197);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		Image image4 = new ImageIcon(this.getClass().getResource("../image/bg.png")).getImage();
		label.setIcon(new ImageIcon(image4));
		label.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label);
	}

}
