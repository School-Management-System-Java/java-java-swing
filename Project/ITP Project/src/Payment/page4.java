package Payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import Common.DBConnection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class page4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page4 window = new page4();
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
	public page4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.getContentPane().setForeground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentPaymentManagement = new JLabel("View   Payment   Details");
		lblStudentPaymentManagement.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblStudentPaymentManagement.setBounds(58, 27, 419, 35);
		frame.getContentPane().add(lblStudentPaymentManagement);
		
		JLabel lblStudentId = new JLabel("Student   ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(58, 203, 151, 26);
		frame.getContentPane().add(lblStudentId);
		
		JFormattedTextField regNo = new JFormattedTextField();
		regNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regNo.setBounds(272, 201, 280, 50);
		frame.getContentPane().add(regNo);
		
		JLabel lblPaymentId = new JLabel("Payment  ID");
		lblPaymentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPaymentId.setBounds(58, 119, 186, 26);
		frame.getContentPane().add(lblPaymentId);
		
		JLabel lblFeeType = new JLabel("Fee Type");
		lblFeeType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFeeType.setBounds(58, 289, 151, 26);
		frame.getContentPane().add(lblFeeType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmount.setBounds(58, 376, 151, 26);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblPaidDate = new JLabel("Paid Date");
		lblPaidDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPaidDate.setBounds(58, 463, 151, 26);
		frame.getContentPane().add(lblPaidDate);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField.setBounds(272, 108, 280, 50);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_1.setBounds(272, 278, 280, 50);
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_2.setBounds(272, 360, 280, 50);
		frame.getContentPane().add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_3.setBounds(272, 447, 280, 50);
		frame.getContentPane().add(formattedTextField_3);
		
		JLabel lblNewLabel = new JLabel("");
		Image image4 = new ImageIcon(this.getClass().getResource("../image/cash.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image4));
		lblNewLabel.setBounds(581, 201, 307, 210);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		Image image5 = new ImageIcon(this.getClass().getResource("../image/view.png")).getImage();
		label.setIcon(new ImageIcon(image5));
		label.setBounds(498, 21, 92, 55);
		frame.getContentPane().add(label);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con;
				PreparedStatement stmt;
				//ResultSet rs;
				
				try {
					con = DBConnection.getDBConnection();
					
					String id = formattedTextField.getText().toString();
					String stID = regNo.getText().toString();
					String type = formattedTextField_1.getText().toString();
					String amount = formattedTextField_2.getText().toString();
					String date = formattedTextField_3.getText().toString();
					
					String query = "update payment set studentID=?,type=?,amount=?,paidDate=? where paymentID=?";
					stmt = con.prepareStatement(query);
					stmt.setString(1, stID);
					stmt.setString(2, type);
					stmt.setString(3, amount);
					stmt.setString(4, date);
					stmt.setString(5, id);
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Update Successfully!!!");
					
					frame.dispose();
					new page4().main(null);
					
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Student ID not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Image image2 = new ImageIcon(this.getClass().getResource("../image/update.png")).getImage();
		btnEdit.setIcon(new ImageIcon(image2));
		btnEdit.setBackground(Color.LIGHT_GRAY);
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(581, 452, 209, 53);
		frame.getContentPane().add(btnEdit);
		
		JButton button = new JButton("Exit");
		Image image3 = new ImageIcon(this.getClass().getResource("../image/back.png")).getImage();
		button.setIcon(new ImageIcon(image3));
		button.setBackground(Color.LIGHT_GRAY);
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				page1 Page1 = new page1();
				Page1.main(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(948, 512, 126, 77);
		frame.getContentPane().add(button);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con;
				PreparedStatement stmt;
				ResultSet rs;
				
				try {
					con = DBConnection.getDBConnection();
					
					String id = formattedTextField.getText().toString();
					String stID = regNo.getText().toString();
					String type = formattedTextField_1.getText().toString();
					String amount = formattedTextField_2.getText().toString();
					String date = formattedTextField_3.getText().toString();
					
					String query = "select studentID,type,amount,paidDate from payment where paymentID=?";
					stmt = con.prepareStatement(query);
					stmt.setString(1, id);
					rs = stmt.executeQuery();
					
					ArrayList list = new ArrayList();
					
					while(rs.next()) {
						list.add(rs.getString("studentID"));
						list.add(rs.getString("type"));
						list.add(rs.getString("amount"));
						list.add(rs.getString("paidDate"));
					}
					
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student Not Found!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if (list.get(0)!=null) {
							regNo.setText(list.get(0).toString());
						}else {
							regNo.setText("");
						}
						formattedTextField_1.setText(list.get(1).toString());
						formattedTextField_2.setText(list.get(2).toString());
						formattedTextField_3.setText(list.get(3).toString());
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image image1 = new ImageIcon(this.getClass().getResource("../image/search.png")).getImage();
		btnSearch.setIcon(new ImageIcon(image1));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setBounds(581, 108, 209, 53);
		frame.getContentPane().add(btnSearch);
		
		JLabel label_1 = new JLabel("");
		Image image6 = new ImageIcon(this.getClass().getResource("../image/bg.png")).getImage();
		label_1.setIcon(new ImageIcon(image6));
		label_1.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label_1);
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(class.getResource("../images/IMG-20180829-WA0000.jpg")));
		label.setBounds(0, 0, 742, 442);
		frame.getContentPane().add(label);*/
		
		
	}
}
