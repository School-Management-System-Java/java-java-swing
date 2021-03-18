package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Payment extends JFrame {

	/**
	 * Create the frame.
	 */
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel HostelPay = new JLabel("Hostel PayID");
		HostelPay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		HostelPay.setBounds(213, 54, 148, 33);
		contentPane.add(HostelPay);
		
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
					JOptionPane.showMessageDialog(null, "Please Type Valid Pay ID", "Error", JOptionPane.ERROR_MESSAGE);
				
				}}
		});
		textField.setBounds(421, 49, 280, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel MemID = new JLabel("Hostel MemberID");
		MemID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		MemID.setBounds(213, 129, 180, 33);
		contentPane.add(MemID);
		
		JLabel Year = new JLabel("Year");
		Year.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Year.setBounds(213, 183, 156, 50);
		contentPane.add(Year);
		
		JLabel Month = new JLabel("Month");
		Month.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Month.setBounds(213, 246, 86, 45);
		contentPane.add(Month);
		
		JLabel Amount = new JLabel("Amount");
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Amount.setBounds(213, 324, 133, 45);
		contentPane.add(Amount);
		
		JLabel Status = new JLabel("Status");
		Status.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Status.setBounds(213, 409, 101, 45);
		contentPane.add(Status);
		
		JLabel PayedDate = new JLabel("Paid Date");
		PayedDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PayedDate.setBounds(213, 515, 120, 38);
		contentPane.add(PayedDate);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char uu = arg0.getKeyChar();
				String txr = textField_1.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Hostal ID", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_1.setBounds(421, 112, 280, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				/*int i=arg0.getID();
				if(!integer.isKey(i)) {
					arg0.consume();
					
				}
				*/

				char uu = arg0.getKeyChar();
				String txr = textField_2.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 3) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Year", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				
			}
		});
		textField_2.setBounds(421, 178, 280, 50);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				char uu = arg0.getKeyChar();
				String txr = textField_3.getText();
				int yy = txr.length();
				//System.out.println(yy);
				if(yy > 1) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Please Type Valid Month", "Error", JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		textField_3.setBounds(421, 241, 280, 50);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		textField_4.setBounds(421, 319, 280, 50);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "P", "N"}));
		comboBox.setBounds(421, 409, 280, 50);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(421, 500, 280, 50);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("ADD Pay Details");
		btnNewButton.addMouseListener(new MouseAdapter() {
		
			
			
			
						
		});
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String HostelPay  = textField.getText();
				//System.out.println(HostelPay);
				

				String MemID  = textField_1.getText();
				//System.out.println(MemID);
				
				String Year  = textField_2.getText();
				//System.out.println(Year);
				
				String Month  = textField_3.getText();
				//System.out.println(Month);
				 
			   
				
				
				
				String Amount  = textField_4.getText();
				
				
				String status  = comboBox.getSelectedItem().toString();
				
				
				
				
				if(HostelPay.equals("") || MemID.equals("")||Year.equals("")||Month.equals("")||Amount.equals("") || dateChooser.getDate() == null||status.equals(""))  {
					
					JOptionPane.showMessageDialog(null, "error", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
					
					
					textField.setText("");
            		textField_1.setText("");;
            		textField_2.setText("");;
            		textField_3.setText("");;
            		textField_4.setText("");;
            		textField.grabFocus();
				
				}
				
				
				
				
				
				
else  {
					
					try {
						
						SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
						String da1 ="";
						if(dateChooser.getDate() == null) {
							da1="";
						}else {
							da1 = sd.format(dateChooser.getDate());
						}
						
						
						
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						Statement stmt3 = null;
						
						ResultSet rs3 = null;
						
						
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            		
		            		
		            		String sql2="select * from hostelPayment where hostelMemID='"+MemID+"'";
		            		stmt2=con.createStatement();
		            		rs=stmt2.executeQuery(sql2);
		            		if(rs.next()) {
		            			JOptionPane.showMessageDialog(null, "This ID is Alredy Registerd..!", "Error", JOptionPane.ERROR_MESSAGE);
		            			
		            		}else {
		            			
		            			
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO hostelPayment (hostelPayID , hostelMemID ,year,month,amount ,status,paidDate )\r\n" + 
		            				"VALUES ('"+HostelPay  +"','"+MemID+"' , '"+Year+"', '"+Month+"', '"+Amount+"','"+status+"','"+da1+"');";
		            		
		            		String SQL3 = "select * from hostel where hostelMemID='"+MemID+"'";
		            		stmt3= con.createStatement();
		            		rs3 = stmt3.executeQuery(SQL3);
		            		
		            		if(rs3.next()) {
		            			stmt = con.createStatement();
			            		
			            		
			            		
			            		
			            		
			            		stmt.executeUpdate(SQL);
		            			
			            		JOptionPane.showMessageDialog(null, "Data Saved");
		            			
		            		}else {
		            			JOptionPane.showMessageDialog(null, "This ID is Invalid..!", "Error", JOptionPane.ERROR_MESSAGE);
		            		}
		            		
		            		//JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.OK_OPTION);
		            		}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setIcon(new ImageIcon(Payment.class.getResource("/imgz/diskette.png")));
		btnNewButton.setBounds(366, 636, 272, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Payment.this.dispose();
				new memberHome().setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setIcon(new ImageIcon(Payment.class.getResource("/imgz/back.png")));
		btnNewButton_1.setBounds(362, 707, 276, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("S111");
				textField_1.setText("M100");
				textField_2.setText("2018");
				textField_3.setText("4");
				textField_4.setText("5000");
				comboBox.setToolTipText("N");
				
				
				
			}
		});
		btnDemo.setBounds(859, 740, 97, 25);
		contentPane.add(btnDemo);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setIcon(new ImageIcon(Payment.class.getResource("/imgz/bg.png")));
		lblNewLabel_3.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel_3);
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
