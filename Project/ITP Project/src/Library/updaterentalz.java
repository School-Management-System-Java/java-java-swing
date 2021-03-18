package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class updaterentalz extends JFrame {

	private JPanel contentPane;
	private JTextField txtTypeDateLike_1;
	private JTextField txtTypeDateLike;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updaterentalz frame = new updaterentalz();
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
	public updaterentalz() {
		
		updaterentalz.this.setTitle("Update Pending Books");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Book ID\r\n");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(41, 106, 126, 34);
		contentPane.add(label);
		
		JLabel lblMemberId = new JLabel("Member ID");
		lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMemberId.setBounds(35, 189, 126, 34);
		contentPane.add(lblMemberId);
		
		JLabel lblRentDate = new JLabel("Rent Date");
		lblRentDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRentDate.setBounds(35, 261, 120, 34);
		contentPane.add(lblRentDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDueDate.setBounds(35, 336, 161, 34);
		contentPane.add(lblDueDate);
		
		txtTypeDateLike_1 = new JTextField();
		txtTypeDateLike_1.setText("Type Date Like yyyy/MM/dd");
		txtTypeDateLike_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeDateLike_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTypeDateLike_1.setColumns(10);
		txtTypeDateLike_1.setBounds(278, 335, 323, 43);
		contentPane.add(txtTypeDateLike_1);
		
		txtTypeDateLike = new JTextField();
		txtTypeDateLike.setText("Type Date Like yyyy/MM/dd");
		txtTypeDateLike.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeDateLike.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTypeDateLike.setColumns(10);
		txtTypeDateLike.setBounds(278, 260, 323, 42);
		contentPane.add(txtTypeDateLike);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(278, 188, 323, 42);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(278, 97, 317, 58);
		contentPane.add(textField_3);
		
		JButton btnUpdate = new JButton(" Update ");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdate.setIcon(new ImageIcon(updaterentalz.class.getResource("/images/update.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String burroweddate = txtTypeDateLike.getText();;
				String duedate = txtTypeDateLike_1.getText();
				String bookidz = textField_3.getText();
				String memberz = textField_2.getText();
				
try {
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=ITP_Project;integratedSecurity=true;";

	Connection con = null;
	Statement stmt = null;
	Statement stmt2 = null;
	Statement stmt3 = null;
	Statement chkstmt = null;
	
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet chkrs = null;
	
	// Establish the connection.
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(connectionUrl);
		
		String sqlzz = "update rental SET borrowedDate='"+burroweddate+"', dueDate='"+duedate+"' where bookID = '"+bookidz+"' and memberID='"+memberz+"' and statuz='Pending' ";
		stmt3 = con.createStatement();
		JOptionPane.showMessageDialog(null, "Data Updated");
		stmt3.executeUpdate(sqlzz);
		updaterentalz.this.dispose();
		new searchrentalupdate().setVisible(true);
		
		
} catch (Exception e) {
e.printStackTrace();
}
				
			}
		});
		btnUpdate.setBounds(686, 189, 174, 34);
		contentPane.add(btnUpdate);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setIcon(new ImageIcon(updaterentalz.class.getResource("/images/back.png")));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updaterentalz.this.dispose();
				new searchrentalupdate().setVisible(true);
				
				
			}
		});
		btnGoBack.setBounds(686, 271, 174, 31);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(updaterentalz.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 941, 548);
		contentPane.add(lblNewLabel);
	}

	public updaterentalz(String bookidz, String memberid, String burrowdate, String rentdate) {
		this();
		try {

			textField_3.setText(bookidz);
			textField_2.setText(memberid);
			txtTypeDateLike.setText(burrowdate);
			txtTypeDateLike_1.setText(rentdate);
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
