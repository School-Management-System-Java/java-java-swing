package UserAccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Common.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserAccountList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblUserAccountList;
	private JFormattedTextField txtSearch;
	private JButton btnBack;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccountList frame = new UserAccountList();
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
	public UserAccountList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 201, 930, 305);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// Establish the connection.
			con = DBConnection.getDBConnection();
			// Create and execute an SQL statement that returns a
			// set of data and then display it.
			String SQL = "SELECT * FROM userAccount";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			// table.setModel(DbUtils.resultSetToTableModel(rs));

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		table = new JTable();
		scrollPane.setViewportView(table);
		// table.setModel(DbUtils.resultSetToTableModel(rs));

		lblUserAccountList = new JLabel("User Account List");
		lblUserAccountList.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUserAccountList.setBounds(383, 35, 308, 37);
		contentPane.add(lblUserAccountList);

		txtSearch = new JFormattedTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;

				try {

					// Establish the connection.
					con = DBConnection.getDBConnection();
					// Create and execute an SQL statement that returns a
					// set of data and then display it.
					String SQL = "SELECT * FROM userAccount where username like '%" + txtSearch.getText().toString()
							+ "%';";
					stmt = con.createStatement();
					rs = stmt.executeQuery(SQL);

					// table.setModel(DbUtils.resultSetToTableModel(rs));

				}

				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		txtSearch.setBounds(231, 132, 438, 53);
		contentPane.add(txtSearch);

		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(668, 132, 181, 53);
		contentPane.add(btnNewButton);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setIcon(new ImageIcon(UserAccountList.class.getResource("/image/Go-back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				UserAccountMain accountMain = new UserAccountMain();
				accountMain.setVisible(true);
			}
		});
		btnBack.setBounds(469, 525, 181, 53);
		contentPane.add(btnBack);

		JLabel label = new JLabel("");
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();
		label.setIcon(new ImageIcon(UserAccountList.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1228, 656);
		contentPane.add(label);

	}

}
