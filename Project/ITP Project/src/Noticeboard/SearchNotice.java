package Noticeboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.proteanit.sql.DbUtils;
import java.awt.Color;

public class SearchNotice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUserAccountList;
	private JButton btnBack;
	private JFormattedTextField txtSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchNotice frame = new SearchNotice();
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
	public SearchNotice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 282, 946, 234);
		contentPane.add(scrollPane);

		lblUserAccountList = new JLabel("Search Notice Details ");
		lblUserAccountList.setForeground(Color.BLACK);
		lblUserAccountList.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUserAccountList.setBounds(362, 81, 381, 81);
		contentPane.add(lblUserAccountList);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBack.setIcon(new ImageIcon(SearchNotice.class.getResource("/image/back.png")));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				SearchNotice.this.dispose();
				new NoticeMain().setVisible(true);

			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnBack.setBounds(852, 527, 159, 41);
		contentPane.add(btnBack);

		txtSearch = new JFormattedTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
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

					String sql2 = "select noticeID,staff,student,publishedDate,time,venue,topic from noticeBoard where noticeID like '%"
							+ txtSearch.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		txtSearch.setBounds(65, 236, 374, 35);
		contentPane.add(txtSearch);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(166, 11, 890, 103);

		lblNewLabel_1 = new JLabel("   Search");
		lblNewLabel_1.setIcon(new ImageIcon(SearchNotice.class.getResource("../image/search.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(449, 236, 131, 35);
		contentPane.add(lblNewLabel_1);

		/*lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon(SearchNotice.class.getResource("../image/s1.png")));
		lblNewLabel.setBounds(10, 11, 256, 151);
		contentPane.add(lblNewLabel);

		label = new JLabel("");
		label.setIcon(new ImageIcon(SearchNotice.class.getResource("/image/s1.png")));
		label.setEnabled(false);
		label.setBounds(818, 11, 256, 151);
		contentPane.add(label);*/

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchNotice.class.getResource("../image/img.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// Establish the connection.
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns a
			// set of data and then display it.
			String SQL = "SELECT * FROM noticeBoard;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
