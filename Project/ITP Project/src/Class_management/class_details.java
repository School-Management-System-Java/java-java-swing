package Class_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.util.Vector;

import com.microsoft.sqlserver.jdbc.*;

import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class class_details extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					class_details frame = new class_details();
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
	public class_details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes c = new classes();
				c.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(class_details.class.getResource("/Images/back.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 550, 121, 50);
		contentPane.add(button);
		scrollPane.setBounds(80, 101, 256, 444);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"staffID", "subjectID"
			}
		));
		scrollPane.setViewportView(table);
		scrollPane_1.setBounds(389, 101, 298, 444);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"staffID", "name"
			}
		));
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setBounds(740, 101, 256, 444);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"subjectID", "name"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_1 = new JLabel("Search");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(101, 48, 72, 20);
		contentPane.add(label_1);
		
		JFormattedTextField srchss = new JFormattedTextField();
		srchss.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {

					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "select staffID,subjectID from staff_subject where subjectID like '%"
							+ srchss.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		srchss.setBorder(null);
		srchss.setBounds(179, 45, 130, 25);
		contentPane.add(srchss);
		
		JLabel label_2 = new JLabel("Search");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(426, 51, 72, 20);
		contentPane.add(label_2);
		
		JFormattedTextField srchstf = new JFormattedTextField();
		srchstf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {

					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "select staffID,name from staff where staffID like '%"
							+ srchstf.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table_1.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		srchstf.setBorder(null);
		srchstf.setBounds(504, 48, 130, 25);
		contentPane.add(srchstf);
		
		JLabel label_3 = new JLabel("Search");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(764, 51, 72, 20);
		contentPane.add(label_3);
		
		JFormattedTextField srchsub = new JFormattedTextField();
		srchsub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {

					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "select subjectID,name from subject where subjectID like '%"
							+ srchsub.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table_2.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		srchsub.setBorder(null);
		srchsub.setBounds(842, 48, 130, 25);
		contentPane.add(srchsub);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(class_details.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);
		
		Connection conn = null;
		Statement mt = null;
		ResultSet rset = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from staff_subject";
			mt = conn.createStatement();
			rset = mt.executeQuery(sql);

			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			while (rset.next()) {

				Vector vv = new Vector();

				vv.add(rset.getString(1));
				vv.add(rset.getString(2));

				dtm.addRow(vv);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from staff";
			mt = conn.createStatement();
			rset = mt.executeQuery(sql);

			DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
			dtm.setRowCount(0);
			while (rset.next()) {

				Vector vv = new Vector();

				vv.add(rset.getString(1));
				vv.add(rset.getString(2));

				dtm.addRow(vv);

			}

		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from subject";
			mt = conn.createStatement();
			rset = mt.executeQuery(sql);

			DefaultTableModel dtm = (DefaultTableModel) table_2.getModel();
			dtm.setRowCount(0);
			while (rset.next()) {

				Vector vv = new Vector();

				vv.add(rset.getString(1));
				vv.add(rset.getString(2));

				dtm.addRow(vv);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
