package Class_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import Common.TempClass;
import Common.opening;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class classes extends JFrame {

	JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classes frame = new classes();
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
	public classes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(414, 234, 56, 19);
		contentPane.add(lblClass);
		
		JComboBox namecombo = new JComboBox();
		namecombo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namecombo.setModel(new DefaultComboBoxModel(new String[] {"Choose Class"}));
		namecombo.setBounds(474, 231, 180, 25);
		contentPane.add(namecombo);
		
		JButton btnselect = new JButton("SELECT");
		btnselect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String combo = namecombo.getSelectedItem().toString();
				if (combo.equals("Choose Class")) {
					JOptionPane.showMessageDialog(null, "Please choose class!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (combo.equals("6A") || combo.equals("6B") || combo.equals("6C") || combo.equals("6D")
							|| combo.equals("6E") || combo.equals("7A") || combo.equals("7B") || combo.equals("7C")
							|| combo.equals("7D") || combo.equals("7E") || combo.equals("8A") || combo.equals("8B")
							|| combo.equals("8C") || combo.equals("8D") || combo.equals("8E") || combo.equals("9A")
							|| combo.equals("9B") || combo.equals("9C") || combo.equals("9D") || combo.equals("9E")) {
						TempClass tempClass7 = new TempClass();
						tempClass7.setName(combo);
						olprimary page = new olprimary();
						page.setVisible(true);
					} else if (combo.equals("10A") || combo.equals("10B") || combo.equals("10C") || combo.equals("10D")
							|| combo.equals("10E") || combo.equals("11A") || combo.equals("11B") || combo.equals("11C")
							|| combo.equals("11D") || combo.equals("11E")) {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						olclasses page1 = new olclasses();
						page1.setVisible(true);
					}else if (combo.equals("12Bio") || combo.equals("13Bio")) {
						TempClass tempClass1 = new TempClass();
						tempClass1.setName(combo);
						bio_class page2 = new bio_class();
						page2.setVisible(true);
					} else if (combo.equals("12Commerce") || combo.equals("13Commerce")) {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						commerce_class page3 = new commerce_class();
						page3.setVisible(true);
					}else if (combo.equals("12ETech") || combo.equals("13ETech")) {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						e_tech_class page4 = new e_tech_class();
						page4.setVisible(true);
					} else if (combo.equals("12BTceh") || combo.equals("13BTech")) {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						b_tech_class page5 = new b_tech_class();
						page5.setVisible(true);
					} else if (combo.equals("12Arts") || combo.equals("13Arts")) {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						arts page6 = new arts();
						page6.setVisible(true);
					}  else {
						TempClass tempClass = new TempClass();
						tempClass.setName(combo);
						alclasses page7 = new alclasses();
						page7.setVisible(true);
					}

				}

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
					
					// cstmt.executeUpdate();

					// Iterate through the data in the result set and display it.

				} catch (Exception e) {
					 e.printStackTrace();
					// JOptionPane.showMessageDialog(null, "Not inserted");
				}

				// JOptionPane.showMessageDialog(null, "Insert Success");
				
			}
		});
		btnselect.setBounds(670, 325, 121, 50);
		contentPane.add(btnselect);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setIcon(new ImageIcon(classes.class.getResource("/Images/back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				opening window = new opening();
				window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(280, 325, 121, 50);
		contentPane.add(btnBack);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(classes.class.getResource("/Images/bg.png")));
		label_1.setBounds(0, 0, 1084, 611);
		contentPane.add(label_1);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();

			String query1 = "select name from class";
			// String query2 = "select name from subject";

			rs = stmt.executeQuery(query1);
			// rs = stmt.executeQuery(query2);
			while (rs.next()) {
				// System.out.println(rset.getString(1));
				// String s = rset.getString("staffID");
				namecombo.addItem((rs.getString("name")));
				// comboBox_2.addItem((rs.getString("subjectID")));
	//			comboBox.addItem((rs.getString("studentID")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
