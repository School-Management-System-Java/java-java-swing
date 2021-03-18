package Parent;

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
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import Main.Home;
import Noticeboard.AddNotice;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class AddParent extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private static JTable table;
	private JTextField txtPidNo;
	private JTextField Pid;
	private JTextField nme;
	private JTextField adrs;
	private JTextField eml;
	private JTextField occu;
	private JTextField gndr;
	private JTextField db;
	/**
	 * Launch the application.
	 */
	JFrame hh;
	static AddParent yy;
	private JTextField phne;
	private JTextField phne1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddParent frame = new AddParent();
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
	public AddParent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1234, 741);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_5 = new JPanel();
		// panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 10, 394, 525);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel label = new JLabel("Parent ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 66, 90, 22);
		panel_5.add(label);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(10, 108, 58, 30);
		panel_5.add(label_1);

		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(10, 158, 90, 23);
		panel_5.add(label_2);

		JLabel label_3 = new JLabel("Email");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(10, 200, 90, 30);
		panel_5.add(label_3);

		JLabel label_4 = new JLabel("Occupation");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(10, 251, 100, 30);
		panel_5.add(label_4);

		JLabel label_5 = new JLabel("DataOfBirth");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(10, 343, 115, 30);
		panel_5.add(label_5);

		JLabel label_6 = new JLabel("Gender");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(10, 300, 90, 25);
		panel_5.add(label_6);

		JLabel lblPhoneno = new JLabel("Mobile");
		lblPhoneno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneno.setBounds(10, 389, 100, 30);
		panel_5.add(lblPhoneno);

		Pid = new JTextField();

		Pid.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDefined(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid parentID", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Pid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Pid.setColumns(10);
		Pid.setBounds(129, 60, 260, 35);
		panel_5.add(Pid);

		nme = new JTextField();
		nme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nme.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid name", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		nme.setColumns(10);
		nme.setBounds(129, 106, 260, 35);
		panel_5.add(nme);

		adrs = new JTextField();
		adrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adrs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid address", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		adrs.setColumns(10);
		adrs.setBounds(129, 152, 260, 35);
		panel_5.add(adrs);

		eml = new JTextField();
		eml.setFont(new Font("Tahoma", Font.PLAIN, 20));

		/*
		 * Emailvalidator emailValidator = new Emailvalidator();
		 * if(!emailValidator.validate(emailField.getText().trim())) {
		 * System.out.print("Invalid Email ID");
		 * 
		 * } public class EmailValidator {
		 * 
		 * private Pattern pattern; private Matcher matcher;
		 * 
		 * private static final String EMAIL_PATTERN =
		 * "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
		 * "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 * 
		 * public EmailValidator() { pattern = Pattern.compile(EMAIL_PATTERN); }
		 * 
		 * public boolean validate(final String hex) {
		 * 
		 * matcher = pattern.matcher(hex); return matcher.matches();
		 * 
		 * } }
		 * 
		 */
		eml.setColumns(10);
		eml.setBounds(129, 198, 260, 35);
		panel_5.add(eml);

		occu = new JTextField();
		occu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		occu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid occupation", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		occu.setColumns(10);
		occu.setBounds(129, 249, 260, 35);
		panel_5.add(occu);

		gndr = new JTextField();
		gndr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gndr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isLetter(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid gender", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		gndr.setColumns(10);
		gndr.setBounds(129, 295, 260, 35);
		panel_5.add(gndr);

		db = new JTextField();
		db.setFont(new Font("Tahoma", Font.PLAIN, 20));
		db.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (!Character.isDefined(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid date of birth", "ok",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		db.setColumns(10);
		db.setBounds(129, 341, 260, 35);
		panel_5.add(db);

		phne = new JTextField();
		phne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phne.addKeyListener(new KeyAdapter() {
			private KeyEvent evt;

			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();

				if (!Character.isDigit(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid phone number", "ok",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		phne.setColumns(10);
		phne.setBounds(129, 387, 260, 35);
		panel_5.add(phne);

		phne1 = new JTextField();
		phne1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phne1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();

				if (!Character.isDigit(c)) {
					arg0.consume();
					JOptionPane.showMessageDialog(AddParent.this, "Please enter valid phone number", "ok",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		phne1.setBounds(129, 433, 260, 35);
		panel_5.add(phne1);
		phne1.setColumns(10);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(10, 481, 100, 30);
		panel_5.add(lblStudentId);

		JFormattedTextField sid = new JFormattedTextField();
		sid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sid.setBounds(129, 479, 260, 35);
		panel_5.add(sid);

		JLabel lblHome = new JLabel("Telephone");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHome.setBounds(10, 435, 100, 30);
		panel_5.add(lblHome);

		JLabel lblStaffMembership = new JLabel("Parent Details");
		lblStaffMembership.setBounds(71, 0, 252, 30);
		panel_5.add(lblStaffMembership);
		lblStaffMembership.setForeground(Color.BLACK);
		lblStaffMembership.setFont(new Font("Tahoma", Font.BOLD, 34));

		JButton btnExit = new JButton(" Back");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AddParent.this.dispose();
				new ParentMain().setVisible(true);

			}
		});
		btnExit.setIcon(new ImageIcon(AddParent.class.getResource("/image/back.png")));
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
		btnReset.setIcon(new ImageIcon(AddParent.class.getResource("../image/update.png")));
		btnReset.setBounds(192, 549, 147, 50);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					int i = table.getSelectedRow();

					String parentID = (String) table.getValueAt(i, 0);

					String name = (String) table.getValueAt(i, 1);
					String address = (String) table.getValueAt(i, 2);
					String email = (String) table.getValueAt(i, 3);
					String occupation = (String) table.getValueAt(i, 4);
					String dob = (String) table.getValueAt(i, 5);
					String gender = (String) table.getValueAt(i, 6);
					String phoneNo1 = (String) table.getValueAt(i, 7);
					String phoneNo2 = (String) table.getValueAt(i, 8);

					System.out.print(name);
					System.out.print(address);
					System.out.print(email);
					System.out.print(occupation);
					System.out.print(dob);
					System.out.print(gender);
					System.out.print(phoneNo1);
					System.out.print(phoneNo2);

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String sqlupd = "update parent set name='" + name + "',address='" + address + "',email='" + email
							+ "'" + ",occupation='" + occupation + "',dob='" + dob + "',gender='" + gender
							+ "',phoneNo1='" + phoneNo1 + "',phoneNo2='" + phoneNo2 + "' where parentID='" + parentID
							+ "'";
					stmt = con.createStatement();
					stmt.executeUpdate(sqlupd);

					JOptionPane.showMessageDialog(null, "Updated successfully ");

					AddParent.this.dispose();
					new AddParent().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnDelete = new JButton(" Delete");
		btnDelete.setIcon(new ImageIcon(AddParent.class.getResource("../image/delete.png")));
		btnDelete.setBounds(378, 549, 147, 50);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					int i = table.getSelectedRow();

					String parentID = (String) table.getValueAt(i, 0);

					String connectionUrl = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String sqlupd = "delete from parent  where parentID='" + parentID + "'";

					stmt = con.createStatement();
					stmt.executeUpdate(sqlupd);

					JOptionPane.showMessageDialog(null, "Deleted successfully");

					AddParent.this.dispose();
					new AddParent().setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("  Save");
		btnNewButton.setIcon(new ImageIcon(AddParent.class.getResource("/image/save.png")));
		btnNewButton.setBounds(10, 549, 147, 50);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arq4) {

				String parentID = Pid.getText();
				String name = nme.getText();
				String address = adrs.getText();
				String email = eml.getText();
				String occupation = occu.getText();
				String gender = gndr.getText();
				String dob = db.getText();
				String phoneNo1 = phne.getText();
				String phoneNo2 = phne1.getText();
				String studentID = sid.getText();

				if (parentID.equals("") || name.equals("") || address.equals("") || email.equals("")
						|| occupation.equals("") || gender.equals("") || dob.equals("") || phoneNo1.equals("")
						|| phoneNo2.equals("") || studentID.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all feilds ", "", JOptionPane.ERROR_MESSAGE);
				} else if (phoneNo1.length() != 10 || phoneNo2.length() != 10) {
					JOptionPane.showMessageDialog(null, "Phone Number field should be 10 digits", "",
							JOptionPane.ERROR_MESSAGE);
				} else {

					try {

						String connectionUrl = "jdbc:sqlserver://localhost:1433;"
								+ "databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null;
						Statement stmt = null;
						Statement stmt2 = null;
						Statement stmt3 = null;

						ResultSet rs = null;
						ResultSet rs1 = null;

						// Establish the connection.
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con = DriverManager.getConnection(connectionUrl);

						String sql2 = "select * from parent where parentID='" + parentID + "'";
						String sql3 = "select parentID from student where studentID='" + studentID + "'";
						stmt2 = con.createStatement();
						stmt3 = con.createStatement();
						rs = stmt2.executeQuery(sql2);
						rs1 = stmt3.executeQuery(sql3);

						ArrayList list = new ArrayList();

						while (rs1.next()) {
							list.add(rs1.getString("parentID"));
						}

						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "This parentID is already registered..!", "Error",
									JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(null, "Try again..!", "", JOptionPane.ERROR_MESSAGE);
						} else if (list.get(0) != null) {
							JOptionPane.showMessageDialog(null, "This studentID is already registered..!", "Error",
									JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(null, "Try again..!", "", JOptionPane.ERROR_MESSAGE);
						} else {

							PreparedStatement mt1 = null, mt2 = null;

							// Create and execute an SQL statement that returns some data.
							String SQL = "INSERT INTO parent (parentID, name, address, email, occupation,gender,dob,phoneNo1,phoneNo2)\r\n"
									+ "VALUES ('" + parentID + "', '" + name + "', '" + address + "','" + email + "', '"
									+ occupation + "','" + gender + "','" + dob + "','" + phoneNo1 + "','" + phoneNo2
									+ "');";

							String SQL1 = "UPDATE student SET parentID='" + parentID + "' where studentID='" + studentID
									+ "'";
							mt1 = con.prepareStatement(SQL);
							mt2 = con.prepareStatement(SQL1);

							JOptionPane.showMessageDialog(null, "Inserted successfully", "Done",
									JOptionPane.INFORMATION_MESSAGE);

							Pid.setText("");
							nme.setText("");
							adrs.setText("");
							eml.setText("");
							occu.setText("");
							gndr.setText("");
							db.setText("");
							phne.setText("");
							phne1.setText("");
							sid.setText("");

							mt1.execute();
							mt2.execute();

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(414, 41, 661, 494);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ParentID", "Name", "Address", "Email",
				"Occupation", "Gender", "DateOfBirth", "PhoneNo_1", "PhoneNo_2" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		txtPidNo = new JTextField();
		// txtPidNo.setBackground(new Color(0, 255, 255));
		txtPidNo.setBounds(779, 10, 296, 30);
		panel.add(txtPidNo);
		txtPidNo.addKeyListener(new KeyAdapter() {
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

					String sql2 = "select * from parent where parentID like '" + txtPidNo.getText() + "%'";
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
						vv.add(rs.getString(8));
						vv.add(rs.getString(9));
						dtm.addRow(vv);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		txtPidNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtPidNo.setText("");
			}
		});
		txtPidNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPidNo.setText("Enter ParentID To Search...");
		txtPidNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPidNo.setColumns(10);

		JButton btnDemo = new JButton("Demo");
		btnDemo.setIcon(new ImageIcon(AddParent.class.getResource("../image/demo.png")));
		btnDemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Pid.setText("P0010");
				nme.setText("Azzam");
				adrs.setText("Matara");
				eml.setText("azzam@gmail.com");
				occu.setText("doctor");
				gndr.setText("M");
				db.setText("1998-06-07");
				phne.setText("0764650852");
				phne1.setText("0769727615");
				sid.setText("10001");

			}
		});
		btnDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDemo.setBounds(564, 549, 147, 50);
		panel.add(btnDemo);

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(AddParent.class.getResource("/image/print.png")));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MessageFormat header = new MessageFormat("Parent Details");
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
		lblNewLabel.setIcon(new ImageIcon(AddParent.class.getResource("../image/img.png")));
		lblNewLabel.setBounds(0, 0, 1234, 613);
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

			String sql2 = "select * from parent";
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
				vv.add(rs.getString(8));
				vv.add(rs.getString(9));

				dtm.addRow(vv);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}
