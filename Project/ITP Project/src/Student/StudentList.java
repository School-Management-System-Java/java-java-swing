package Student;

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

import Common.DBConnection;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUserAccountList;
	private JButton btnBack;
	private JFormattedTextField txtSearch;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList frame = new StudentList();
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
	public StudentList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 241, 968, 246);
		contentPane.add(scrollPane);

		lblUserAccountList = new JLabel("Student List");
		lblUserAccountList.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUserAccountList.setBounds(434, 40, 222, 35);
		contentPane.add(lblUserAccountList);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentMain studentMain = new StudentMain();
				studentMain.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(StudentList.class.getResource("/image/Go-back-icon.png")));
		btnBack.setBounds(467, 503, 186, 50);
		contentPane.add(btnBack);

		txtSearch = new JFormattedTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {

					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;

					// Establish the connection.
					con = DBConnection.getDBConnection();

					// Create and execute an SQL statement that returns some data.

					String sql2 = "select studentID,fName,lName,nameWithInitial,dob,gender,mobileNo,homePhone,email,joinedDate from student where nameWithInitial like '%"
							+ txtSearch.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		txtSearch.setBounds(295, 182, 374, 50);
		contentPane.add(txtSearch);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(667, 181, 137, 50);
		contentPane.add(btnSearch);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue(new
		// String("Student ID"));

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = DBConnection.getDBConnection();
			String SQL = "SELECT * FROM student;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentList.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
