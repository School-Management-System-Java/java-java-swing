package Class_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.sqlserver.jdbc.*;

import Common.opening;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class add_class extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_class frame = new add_class();
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
	public add_class() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClassName.setBounds(345, 231, 113, 20);
		contentPane.add(lblClassName);

		JFormattedTextField clsname = new JFormattedTextField();
		clsname.setBorder(null);
		clsname.setBounds(463, 228, 180, 25);
		contentPane.add(clsname);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String Class = clsname.getText();
				Pattern pattern = Pattern.compile("^[6-9]{1}+[A-Z]{1}$");
				Pattern pattern1 = Pattern.compile("^[10-11]{2}+[A-Z]{1}$");
				Matcher m = pattern.matcher(Class);
				Matcher m1 = pattern1.matcher(Class);

				if (Class.equals("")) {
					JOptionPane.showMessageDialog(null, "Class Name should not be blank.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if ((m.matches()) || (m1.matches()) || Class.equals("12Maths") || Class.equals("13Maths")
						|| Class.equals("12Bio") || Class.equals("13Bio") || Class.equals("12Commerce")
						|| Class.equals("13Commerce") || Class.equals("12ETech") || Class.equals("13ETech")
						|| Class.equals("12BTech") || Class.equals("13BTech") || Class.equals("12Arts")
						|| Class.equals("13Arts")) {
					JOptionPane.showMessageDialog(null, "Class Added Successfully!");
					
					Connection con = null;
					CallableStatement cstmt = null;
					ResultSet rs = null;
					PreparedStatement stmt = null;

					try {
						// Establish the connection.
						SQLServerDataSource ds = new SQLServerDataSource();
						ds.setIntegratedSecurity(true);
						ds.setServerName("localhost");
						ds.setPortNumber(1433);
						ds.setDatabaseName("ITP_Project");
						con = ds.getConnection();

						String query = "select top 1 classID from class order by classID desc";
						stmt = con.prepareStatement(query);
						rs = stmt.executeQuery();
						
						ArrayList<String> cid = new ArrayList<String>();
						if(rs.next()) {
							cid.add(rs.getString(1));
						}
						
						String id;
						
						if(cid.size()==0) {
							id="C01";
						}else {
							String ID = cid.get(0).toString();
							int no = Integer.parseInt(ID.substring(1));
							int newID = no+1;
							if(newID<10) {
								id = "C0"+newID;
							}else {
								id = "C"+newID;
							}
						}
						
						String className = clsname.getText().toString();

						// Execute a stored procedure that returns some data.
						cstmt = con.prepareCall("{call dbo.udpaddClass(?,?)}");
						cstmt.setString(1, id);
						cstmt.setString(2, className);
						cstmt.execute();
						// cstmt.executeUpdate();

						// Iterate through the data in the result set and display it.

					} catch (Exception e) {
						e.printStackTrace();
						// JOptionPane.showMessageDialog(null, "Not inserted");
					}

					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Please enter class name with valid format!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		btnAdd.setBounds(657, 320, 113, 50);
		contentPane.add(btnAdd);

		JButton btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opening window = new opening();
				window.frame.setVisible(true);
			}
		});
		btnback.setIcon(new ImageIcon(add_class.class.getResource("/Images/back.png")));
		btnback.setBounds(218, 320, 118, 50);
		contentPane.add(btnback);

		JLabel lblFormats = new JLabel("Some Valid Formats");
		lblFormats.setBounds(956, 187, 118, 14);
		contentPane.add(lblFormats);

		JLabel lblNewLabel = new JLabel("12Comb.Maths");
		lblNewLabel.setBounds(853, 253, 87, 14);
		contentPane.add(lblNewLabel);

		JLabel lblbio = new JLabel("13Bio");
		lblbio.setBounds(853, 281, 70, 14);
		contentPane.add(lblbio);

		JLabel lblcommerce = new JLabel("12Commerce");
		lblcommerce.setBounds(853, 309, 79, 14);
		contentPane.add(lblcommerce);

		JLabel lblFormats_1 = new JLabel("12Bio-Tech");
		lblFormats_1.setBounds(853, 337, 70, 14);
		contentPane.add(lblFormats_1);

		JLabel lblengtech = new JLabel("13Eng-Tech");
		lblengtech.setBounds(853, 365, 79, 14);
		contentPane.add(lblengtech);

		JLabel lblarts = new JLabel("13Arts");
		lblarts.setBounds(853, 393, 79, 14);
		contentPane.add(lblarts);

		JLabel lblmaths = new JLabel("-       12Maths");
		lblmaths.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaths.setBounds(947, 253, 85, 14);
		contentPane.add(lblmaths);

		JLabel lblbio_1 = new JLabel("-       13Bio");
		lblbio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblbio_1.setBounds(947, 281, 85, 14);
		contentPane.add(lblbio_1);

		JLabel lblcommerce_1 = new JLabel("-       12Commerce");
		lblcommerce_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcommerce_1.setBounds(947, 309, 112, 14);
		contentPane.add(lblcommerce_1);

		JLabel lblbtech = new JLabel("-       12BTech");
		lblbtech.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblbtech.setBounds(947, 337, 96, 14);
		contentPane.add(lblbtech);

		JLabel lbletech = new JLabel("-       13ETech");
		lbletech.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbletech.setBounds(947, 365, 85, 14);
		contentPane.add(lbletech);

		JLabel lblarts_1 = new JLabel("-       13Arts");
		lblarts_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblarts_1.setBounds(947, 393, 85, 14);
		contentPane.add(lblarts_1);

		JLabel lblUnderAl = new JLabel("Under A/L");
		lblUnderAl.setBounds(853, 225, 79, 14);
		contentPane.add(lblUnderAl);

		JLabel lbld = new JLabel("-       8D");
		lbld.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbld.setBounds(947, 225, 79, 14);
		contentPane.add(lbld);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(add_class.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);
	}
}
