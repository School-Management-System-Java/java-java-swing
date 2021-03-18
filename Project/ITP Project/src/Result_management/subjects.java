package Result_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.util.Vector;

import com.microsoft.sqlserver.jdbc.*;

import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class subjects extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subjects frame = new subjects();
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
	public subjects() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(361, 115, 409, 453);
		contentPane.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"subjectID", "name"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result_content rs = new result_content();
				rs.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(subjects.class.getResource("/Images/back.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(87, 550, 121, 50);
		contentPane.add(btnBack);
		
		JFormattedTextField srch = new JFormattedTextField();
		srch.addKeyListener(new KeyAdapter() {
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

					String sql2 = "select subjectID,name from subject where subjectID like '%"
							+ srch.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		srch.setBorder(null);
		srch.setBounds(205, 45, 130, 25);
		contentPane.add(srch);
		
		JLabel label_1 = new JLabel("Search");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(127, 48, 72, 20);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(subjects.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);
		
		Connection conn = null;
		Statement mt = null;
		ResultSet rset = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from subject";
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
		
	}
}
