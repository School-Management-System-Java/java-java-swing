package Noticeboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import Main.Home;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class AddNotice extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private static JTable table;
	private JTextField txtTypeNidNo;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	/**
	 * Launch the application.
	 */
	JFrame hh;
	static AddNotice yy;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotice frame = new AddNotice();
					frame.setVisible(true);
					loadDatatotable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNotice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1234, 741);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_5 = new JPanel();
		// panel_5.setBackground(new Color(51, 255, 255));
		panel_5.setBounds(10, 10, 433, 528);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel label = new JLabel("Notice ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 103, 121, 43);
		panel_5.add(label);

		txtTypeNidNo = new JTextField();
		// txtTypeNidNo.setBackground(new Color(0, 255, 255));
		txtTypeNidNo.setBounds(777, 10, 296, 30);
		panel.add(txtTypeNidNo);
		txtTypeNidNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				try {

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;

					ResultSet rs = null;

					// Establish the connection.
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					// Create and execute an SQL statement that returns some data.

					String sql2 = "select * from noticeBoard where noticeID like '" + txtTypeNidNo.getText() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);
					while (rs.next()) {

						Vector vv = new Vector();

						vv.add(rs.getString(1));
						vv.add(rs.getString(2));
						vv.add(rs.getString(3));
						vv.add(rs.getString(4));
						vv.add(rs.getString(5));
						vv.add(rs.getString(6));
						vv.add(rs.getString(7));
						dtm.addRow(vv);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		txtTypeNidNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTypeNidNo.setText("");
			}
		});
		txtTypeNidNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeNidNo.setText("Enter NoticeID To Search...");
		txtTypeNidNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTypeNidNo.setColumns(10);

		JLabel label_1 = new JLabel("Staff");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(10, 163, 87, 35);
		panel_5.add(label_1);

		JLabel label_2 = new JLabel("Student");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(10, 219, 77, 35);
		panel_5.add(label_2);

		JLabel label_3 = new JLabel("PublishedDate");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(10, 275, 137, 35);
		panel_5.add(label_3);

		JLabel label_4 = new JLabel("Time");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(10, 331, 68, 35);
		panel_5.add(label_4);

		JLabel label_5 = new JLabel("Topic");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(10, 443, 77, 35);
		panel_5.add(label_5);

		JLabel label_6 = new JLabel("Venue");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(10, 387, 121, 35);
		panel_5.add(label_6);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDefined(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid noticeId", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(163, 102, 260, 45);
		panel_5.add(textField);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDigit(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid staff value", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(163, 214, 260, 45);
		panel_5.add(textField_2);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDigit(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid student value", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(163, 158, 260, 45);
		panel_5.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDefined(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid date", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(163, 270, 260, 45);
		panel_5.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDefined(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid time", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(163, 326, 260, 45);
		panel_5.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid venue", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(163, 382, 260, 45);
		panel_5.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddNotice.this, "Please enter valid topic", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_10.setColumns(10);
		textField_10.setBounds(163, 438, 260, 45);
		panel_5.add(textField_10);

		JLabel lblStaffMembership = new JLabel("Notice Board Details");
		lblStaffMembership.setBackground(new Color(0, 255, 255));
		lblStaffMembership.setBounds(44, 11, 357, 41);
		panel_5.add(lblStaffMembership);
		lblStaffMembership.setForeground(Color.BLACK);
		lblStaffMembership.setFont(new Font("Tahoma", Font.BOLD, 34));

		JButton btnExit = new JButton(" Back");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AddNotice.this.dispose();
				new NoticeMain().setVisible(true);

			}
		});
		btnExit.setIcon(new ImageIcon(AddNotice.class.getResource("/image/back.png")));
		btnExit.setBounds(928, 549, 147, 50);
		panel.add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnReset = new JButton(" Update");
		btnReset.setIcon(new ImageIcon(AddNotice.class.getResource("../image/update.png")));
		btnReset.setBounds(192, 549, 147, 50);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					int i = table.getSelectedRow();

					String noticeID = (String) table.getValueAt(i, 0);
					String staff = (String) table.getValueAt(i, 1);
					String student = (String) table.getValueAt(i, 2);
					String publishedDate = (String) table.getValueAt(i, 3);
					String time = (String) table.getValueAt(i, 4);
					String venue = (String) table.getValueAt(i, 5);
					String topic = (String) table.getValueAt(i, 6);

					System.out.print(staff);
					System.out.print(student);
					System.out.print(publishedDate);
					System.out.print(time);
					System.out.print(venue);
					System.out.print(topic);

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String sqlupd = "update noticeBoard set staff='" + staff + "',student='" + student
							+ "',publishedDate='" + publishedDate + "'" + ",time='" + time + "',venue='" + venue
							+ "',topic='" + topic + "' where noticeID='" + noticeID + "'";
					stmt = con.createStatement();
					stmt.executeUpdate(sqlupd);

					JOptionPane.showMessageDialog(null, "Updated  successfully");

					AddNotice.this.dispose();
					new AddNotice().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnDelete = new JButton(" Delete");
		btnDelete.setIcon(new ImageIcon(AddNotice.class.getResource("../image/delete.png")));
		btnDelete.setBounds(378, 549, 147, 50);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int i = table.getSelectedRow();

					String noticeID = (String) table.getValueAt(i, 0);

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String sqlupd = "delete from noticeBoard  where noticeID='" + noticeID + "'";

					stmt = con.createStatement();
					stmt.executeUpdate(sqlupd);

					JOptionPane.showMessageDialog(null, "Deleted successfully...!");

					AddNotice.this.dispose();
					new AddNotice().setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("  Save");
		btnNewButton.setIcon(new ImageIcon(AddNotice.class.getResource("/image/save.png")));
		btnNewButton.setBounds(10, 549, 147, 50);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arq4) {

				String noticeID = textField.getText();
				String staff = textField_2.getText();
				String student = textField_6.getText();
				String publishedDate = textField_7.getText();
				String time = textField_8.getText();
				String venue = textField_9.getText();
				String topic = textField_10.getText();

				if (noticeID.equals("") || staff.equals("") || student.equals("") || publishedDate.equals("")
						|| time.equals("") || venue.equals("") || topic.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all feilds ", "", JOptionPane.ERROR_MESSAGE);
				}

				else {

					try {

						String connectionUrl = "jdbc:sqlserver://localhost:1433;"
								+ "databaseName=ITP_Project;integratedSecurity=true;";
						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;

						// Establish the connection.
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con = DriverManager.getConnection(connectionUrl);

						String sql2 = "select * from noticeBoard where noticeID='" + noticeID + "'";
						stmt2 = con.createStatement();
						rs = stmt2.executeQuery(sql2);

						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "This noticeID is already registered..!", "",
									JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(null, "Try again..!", "", JOptionPane.ERROR_MESSAGE);

						}

						else {

							// Create and execute an SQL statement that returns some data.
							String SQL = "INSERT INTO noticeBoard (noticeID, staff, student, publishedDate, time,venue,topic)\r\n"
									+ "VALUES ('" + noticeID + "', '" + staff + "', '" + student + "','" + publishedDate
									+ "', '" + time + "','" + venue + "','" + topic + "');";
							stmt = con.createStatement();

							stmt.executeUpdate(SQL);
							JOptionPane.showMessageDialog(null, " Saved successfully", "Done",
									JOptionPane.INFORMATION_MESSAGE);

							textField.setText("");
							textField_2.setText("");
							textField_6.setText("");
							textField_7.setText("");
							textField_8.setText("");
							textField_9.setText("");
							textField_10.setText("");
							;

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(451, 44, 622, 494);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "NoticeID", "Staff", "Student", "PublishedDate", "Time", "Venue", "Topic" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnDemo = new JButton("Demo");
		btnDemo.setIcon(new ImageIcon(AddNotice.class.getResource("../image/demo.png")));
		btnDemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				textField.setText("N010");
				textField_2.setText("0");
				textField_6.setText("1");
				textField_7.setText("2019-11-10");
				textField_8.setText("11.00 AM");
				textField_9.setText("Main Hall");
				textField_10.setText("Meeting");
				;

			}
		});
		btnDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDemo.setBounds(564, 549, 147, 50);
		panel.add(btnDemo);

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(AddNotice.class.getResource("/image/print.png")));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MessageFormat header = new MessageFormat("Notice Board Details");
				MessageFormat footer = new MessageFormat("Page");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (java.awt.print.PrinterException e) {

					System.err.format("Unable to print", e.getMessage());
				}

			}
		});
		btnPrint.setBounds(745, 549, 147, 50);
		panel.add(btnPrint);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddNotice.class.getResource("../image/img.png")));
		lblNewLabel.setBounds(0, 0, 1083, 611);
		panel.add(lblNewLabel);

	}

	static void loadDatatotable() {
		try {

			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=ITP_Project;integratedSecurity=true;";

			Connection con = null;
			Statement stmt = null;

			ResultSet rs = null;

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.

			String sql2 = "select * from noticeBoard";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql2);

			// default table model
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();

			while (rs.next()) {

				Vector vv = new Vector();

				vv.add(rs.getString(1));
				vv.add(rs.getString(2));
				vv.add(rs.getString(3));
				vv.add(rs.getString(4));
				vv.add(rs.getString(5));
				vv.add(rs.getString(6));
				vv.add(rs.getString(7));
				dtm.addRow(vv);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}
