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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class staff_update_delete extends JFrame {

	private JPanel contentPane;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staff_update_delete frame = new staff_update_delete();
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
	public staff_update_delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(569, 126, 446, 349);
		contentPane.add(scrollPane);
		
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "classID", "subjectID", "staffID" }));
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("Search");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(217, 76, 72, 20);
		contentPane.add(label);

		JFormattedTextField search = new JFormattedTextField();
		search.addKeyListener(new KeyAdapter() {
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

					String sql2 = "select classID,subjectID,staffID from class_staff_subject where subjectID like '%"
							+ search.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		search.setBorder(null);
		search.setBounds(295, 73, 130, 25);
		contentPane.add(search);

		JComboBox clscombo = new JComboBox();
		clscombo.setBounds(40, 211, 146, 25);
		contentPane.add(clscombo);

		JComboBox subcombo = new JComboBox();
		subcombo.setBounds(200, 211, 146, 25);
		contentPane.add(subcombo);

		JComboBox stfcombo = new JComboBox();
		stfcombo.setBounds(360, 211, 146, 25);
		contentPane.add(stfcombo);

		Object[] columns = { "classID", "subjectID", "staffID" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);

		JButton btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnback.setIcon(new ImageIcon(staff_update_delete.class.getResource("/Images/back.png")));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			//	currentFrame.dispose();
			//	myPreviousFrame.setVisible(true);				
				classes page2 = new classes();
				page2.setVisible(true);
			}
		});
		btnback.setBounds(156, 512, 121, 50);
		contentPane.add(btnback);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				clscombo.setSelectedItem(model.getValueAt(i, 0).toString());
				subcombo.setSelectedItem(model.getValueAt(i, 1).toString());
				stfcombo.setSelectedItem(model.getValueAt(i, 2).toString());
			}
		});
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnupdate.setIcon(new ImageIcon(staff_update_delete.class.getResource("/Images/update.png")));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "update class_staff_subject set classID=?,staffID=?,subjectID=? where subjectID=?";
					stmt = con.prepareStatement(sql2);
					stmt.setString(1, clscombo.getSelectedItem().toString());
					stmt.setString(2, stfcombo.getSelectedItem().toString());
					stmt.setString(3, subcombo.getSelectedItem().toString());
					stmt.setString(4, subcombo.getSelectedItem().toString());
					stmt.execute();

					// table.setModel(DbUtils.resultSetToTableModel(rs));

				

				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(clscombo.getSelectedItem().toString(), i, 0);
					model.setValueAt(subcombo.getSelectedItem().toString(), i, 1);
					model.setValueAt(stfcombo.getSelectedItem().toString(), i, 2);
				} else {
					JOptionPane.showMessageDialog(null, "Please choose row to Update", "Update Error",
							JOptionPane.ERROR_MESSAGE);
				}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnupdate.setBounds(592, 512, 121, 50);
		contentPane.add(btnupdate);

		JButton btndelete = new JButton("DELETE");
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btndelete.setIcon(new ImageIcon(staff_update_delete.class.getResource("/Images/dlte.png")));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				CallableStatement cstmt = null;
				ResultSet rs = null;
				
				try {

					con = null;
					PreparedStatement stmt = null;
					rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "delete from class_staff_subject where classID=? and staffID=? and subjectID=?";
					stmt = con.prepareStatement(sql2);
					stmt.setString(1, clscombo.getSelectedItem().toString());
					stmt.setString(2, subcombo.getSelectedItem().toString());
					stmt.setString(3, stfcombo.getSelectedItem().toString());
					stmt.execute();

					// table.setModel(DbUtils.resultSetToTableModel(rs));

				

				int i = table.getSelectedRow();
				if (i >= 0) {
					int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?", "Delete",
							JOptionPane.YES_NO_OPTION);
					if (opt == 0) {
						model.removeRow(i);
						JOptionPane.showMessageDialog(null, "Deleted Successfully!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please choose row to delete", "Delete Error",
							JOptionPane.ERROR_MESSAGE);
				}
		
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btndelete.setBounds(868, 512, 121, 50);
		contentPane.add(btndelete);
		
		JLabel lblClassid = new JLabel("classID");
		lblClassid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClassid.setBounds(80, 180, 86, 20);
		contentPane.add(lblClassid);
				
				JLabel lblSubjectid = new JLabel("subjectID");
				lblSubjectid.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblSubjectid.setBounds(229, 180, 96, 20);
				contentPane.add(lblSubjectid);
				
				JLabel lblStaffid = new JLabel("staffID");
				lblStaffid.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblStaffid.setBounds(396, 180, 86, 20);
				contentPane.add(lblStaffid);
				
						JLabel label_1 = new JLabel("");
						label_1.setIcon(new ImageIcon(staff_update_delete.class.getResource("/Images/bg.png")));
						label_1.setBounds(0, 0, 1078, 594);
						contentPane.add(label_1);

		Connection conn = null;
		Statement mt = null;
		ResultSet rset = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from class_staff_subject";
			mt = conn.createStatement();
			rset = mt.executeQuery(sql);

			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			while (rset.next()) {

				Vector vv = new Vector();

				vv.add(rset.getString(1));
				vv.add(rset.getString(3));
				vv.add(rset.getString(2));

				dtm.addRow(vv);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();

			String q2 = "select classID from class_staff_subject";

			rs = stmt.executeQuery(q2);
			while (rs.next()) {
				clscombo.addItem((rs.getString("classID")));
			}
			
			String q3 = "select subjectID from class_staff_subject";

			rs = stmt.executeQuery(q3);
			while (rs.next()) {
				subcombo.addItem((rs.getString("subjectID")));
			}
			
			String q4 = "select staffID from class_staff_subject";

			rs = stmt.executeQuery(q4);
			while (rs.next()) {
				stfcombo.addItem((rs.getString("staffID")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
