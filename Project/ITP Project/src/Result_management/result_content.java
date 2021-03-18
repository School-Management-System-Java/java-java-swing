package Result_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.microsoft.sqlserver.jdbc.*;

import Common.TempClass;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class result_content extends JFrame {

	private JPanel contentPane;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result_content frame = new result_content();
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
	public result_content() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnback.setIcon(new ImageIcon(result_content.class.getResource("/Images/back.png")));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				exam_content page = new exam_content();
				page.setVisible(true);

			}
		});
		btnback.setBounds(145, 539, 121, 50);
		contentPane.add(btnback);

		JFormattedTextField search = new JFormattedTextField();
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBorder(null);
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

					String sql2 = "select studentID,examID,subjectID,marks from result where subjectID like '%"
							+ search.getText().toString() + "%'";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql2);

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		search.setBounds(264, 63, 130, 25);
		contentPane.add(search);

		JFormattedTextField marks = new JFormattedTextField();
		marks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marks.setBorder(null);
		marks.setBounds(211, 323, 174, 25);
		contentPane.add(marks);

		JLabel label = new JLabel("StudentID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(99, 232, 102, 20);
		contentPane.add(label);

		JLabel label_1 = new JLabel("ExamID");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(99, 263, 102, 20);
		contentPane.add(label_1);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject.setBounds(99, 292, 102, 20);
		contentPane.add(lblSubject);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(211, 232, 174, 25);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(211, 263, 174, 25);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(211, 292, 174, 25);
		contentPane.add(comboBox_2);

		JLabel label_3 = new JLabel("Marks");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(99, 323, 102, 20);
		contentPane.add(label_3);

		Object[] columns = { "StudentID", "ExamID", "Subject", "Marks" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane();

		/*
		 * table.setModel(new DefaultTableModel( new Object[][] { }, new String[] {
		 * "StudentID", "ExamID", "Subject", "Marks" } ));
		 */
		scrollPane.setBounds(425, 134, 485, 380);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		Object[] row = new Object[4];

		JButton btnsave = new JButton("SAVE");
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsave.setIcon(new ImageIcon(result_content.class.getResource("/Images/save.png")));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comboBox = null;
				// String sID = comboBox.getSelectedItem().toString();
				// comboBox_1 = null;
				// String examID = comboBox_1.getSelectedItem().toString();
				// comboBox_2 = null;
				// String subjID = comboBox_2.getSelectedItem().toString();
				String Marks = marks.getText();
				Pattern pattern = Pattern.compile("^(100|[1-9]?[0-9])$");
				Matcher m = pattern.matcher(Marks);
				
				if (Marks.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter marks of the student", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else if ((!m.matches())) {
					JOptionPane.showMessageDialog(null, "Please enter valid marks", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else {
					
					try {

						Connection con = null;
						PreparedStatement stmt = null;
						Statement mt = null;
						ResultSet rs = null,rset;
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con = DriverManager.getConnection(connectionUrl);
						
						String query = "select subjectID from subject where name='"+comboBox_2.getSelectedItem().toString()+"'";
						mt = con.createStatement();
						rset = mt.executeQuery(query);
						
						ArrayList id = new ArrayList();
						while(rset.next()) {
							id.add(rset.getString("subjectID"));
						}
						
						String ids = id.get(0).toString();

						// Establish the connection.

						// Create and execute an SQL statement that returns some data.

						String sql2 = "insert into result (studentID,examID,subjectID,marks) values(?,?,?,?)";
						stmt = con.prepareStatement(sql2);
						stmt.setString(1, comboBox.getSelectedItem().toString());
						stmt.setString(2, comboBox_1.getSelectedItem().toString());
						stmt.setString(3, ids);
						stmt.setString(4, marks.getText().toString());
						stmt.execute();

						// table.setModel(DbUtils.resultSetToTableModel(rs));

						row[0] = comboBox.getSelectedItem().toString();
						row[1] = comboBox_1.getSelectedItem().toString();
						row[2] = comboBox_2.getSelectedItem().toString();
						row[3] = marks.getText();
						model.addRow(row);
						
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data already exists! you can update...", "Error",
								JOptionPane.ERROR_MESSAGE);
					}				
				}
			}
		});
		btnsave.setBounds(362, 539, 121, 50);
		contentPane.add(btnsave);

		JButton btnupdate = new JButton("UPDATE");
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnupdate.setIcon(new ImageIcon(result_content.class.getResource("/Images/update.png")));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * // Declare the JDBC objects. Connection con = null; CallableStatement cstmt =
				 * null; ResultSet rs = null;
				 * 
				 try { // Establish the connection. SQLServerDataSource ds = new
				 SQLServerDataSource(); ds.setIntegratedSecurity(true);
				 ds.setServerName("localhost"); ds.setPortNumber(1433);
				 ds.setDatabaseName("ITP_Project1"); con = ds.getConnection();
				 * 
				 * // Execute a stored procedure that returns some data. // cstmt =
				 * con.prepareCall("{call dbo.udpresultDetails(?,?,?,?)}"); String sql =
				 * "update result1 set examID=? subjectID=? marks=? where studentID=?";
				 * PreparedStatement pst = con.prepareStatement(sql); pst.setString(1,
				 * comboBox.getSelectedItem().toString()); pst.setString(2,
				 * subid.getText().toString()); pst.setString(3, marks.getText().toString());
				 * pst.setString(4, sid.getText().toString());
				 * 
				 * pst.executeQuery(); // rs = cstmt.executeQuery();
				 * 
				 * // Iterate through the data in the result set and display it.
				 * 
				 * }
				 * 
				 * // Handle any errors that may have occurred. catch (Exception e) { //
				 * e.printStackTrace(); }
				 */
				String Marks = marks.getText();
				Pattern pattern = Pattern.compile("^(100|[1-9]?[0-9])$");
				Matcher m = pattern.matcher(Marks);
				
				 if ((!m.matches())) {
						JOptionPane.showMessageDialog(null, "Please enter valid marks to update", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else {
				try {

					Connection con = null;
					PreparedStatement stmt = null;
					Statement mt = null;
					ResultSet rs = null;

					// Establish the connection.
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ITP_Project;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String query = "select subjectID from subject where name='"+comboBox_2.getSelectedItem().toString()+"'";
					mt = con.createStatement();
					rs = mt.executeQuery(query);
					
/*					ArrayList id = new ArrayList();
					while(rs.next()) {
						id.add(rs.getString("subjectID"));
					}
*/					
//					String ids = id.get(0).toString();

					
					// Create and execute an SQL statement that returns some data.

					String sql2 = "update result set studentID=?,examID=?,subjectID=?,marks=? where studentID=?";
					stmt = con.prepareStatement(sql2);
					stmt.setString(1, comboBox.getSelectedItem().toString());
					stmt.setString(2, comboBox_1.getSelectedItem().toString());
					stmt.setString(3, comboBox_2.getSelectedItem().toString());
					stmt.setString(4, marks.getText().toString());
					stmt.setString(5, comboBox.getSelectedItem().toString());
					stmt.execute();

					// table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				

				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(comboBox.getSelectedItem().toString(), i, 0);
					model.setValueAt(comboBox_1.getSelectedItem().toString(), i, 1);
					model.setValueAt(comboBox_2.getSelectedItem().toString(), i, 2);
					model.setValueAt(marks.getText(), i, 3);
				} else {
					JOptionPane.showMessageDialog(null, "Please choose row to Update", "Update Error",
							JOptionPane.ERROR_MESSAGE);
				}
					}
			}
		});
		btnupdate.setBounds(579, 539, 121, 50);
		contentPane.add(btnupdate);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = table.getSelectedRow();
				comboBox.setSelectedItem(model.getValueAt(i, 0).toString());
				comboBox_1.setSelectedItem(model.getValueAt(i, 1).toString());
				comboBox_2.setSelectedItem(model.getValueAt(i, 2).toString());
				marks.setText(model.getValueAt(i, 3).toString());
			}
		});

		JLabel label_4 = new JLabel("Search");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(188, 67, 69, 19);
		contentPane.add(label_4);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MessageFormat header = new MessageFormat("Results of The Students");
				MessageFormat footer = new MessageFormat("Page");
				try
				{
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
				}catch(java.awt.print.PrinterException e) {
					System.err.format("Unable to Print", e.getMessage());
				}

			}
		});
		btnPrint.setBounds(40, 42, 113, 25);
		contentPane.add(btnPrint);
				
		TempClass tempClas = new TempClass();
						
						JButton btnShowSubjects = new JButton("SUBJECTS");
						btnShowSubjects.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								subjects sb = new subjects();
								sb.setVisible(true);
								
							}
						});
						btnShowSubjects.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnShowSubjects.setBounds(792, 539, 121, 50);
						contentPane.add(btnShowSubjects);
						
								JLabel lblSubjects = new JLabel("");
								lblSubjects.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblSubjects.setIcon(new ImageIcon(result_content.class.getResource("/Images/bg.png")));
								lblSubjects.setBounds(0, 0, 1084, 611);
								contentPane.add(lblSubjects);

		Connection conn = null;
		Statement mt = null;
		ResultSet rset = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			conn = DriverManager.getConnection(url);

			String sql = "select * from result";
			mt = conn.createStatement();
			rset = mt.executeQuery(sql);

			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			while (rset.next()) {

				Vector vv = new Vector();

				vv.add(rset.getString(1));
				vv.add(rset.getString(2));
				vv.add(rset.getString(3));
				vv.add(rset.getString(4));
				
				dtm.addRow(vv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		//PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();

			//String stdqry = "select s.studentID from result r,student s,subject sb,exam e where s.studentID = r.studentID and e.examID = r.examID and sb.subjectID = r.subjectID";
			String stdqry = "select studentID from student";
			rs = stmt.executeQuery(stdqry);
			//pstmt.setString(1,label.getText().toString());
			//rs = pstmt.executeQuery();
			while (rs.next()) {
				comboBox.addItem((rs.getString("studentID")));
			}
			
			
			//String exqry = "select e.examID from result r,student s,subject sb,exam e where s.studentID = r.studentID and e.examID = r.examID and sb.subjectID = r.subjectID";
			String exqry = "select examID from exam";

			rs = stmt.executeQuery(exqry);
			//pstmt.setString(1,label.getText().toString());
			//rs = pstmt.executeQuery();
			while (rs.next()) {
				comboBox_1.addItem((rs.getString("examID")));
			}
			
			String subqry = "select name from subject";
			rs = stmt.executeQuery(subqry);
			//pstmt.setString(1,label.getText().toString());
			//rs = pstmt.executeQuery();
			while (rs.next()) {
				comboBox_2.addItem((rs.getString("name")));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

/*		Connection con1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project1;integratedSecurity=true;";
			con1 = DriverManager.getConnection(url);
			stmt1 = con1.createStatement();

			// String query1 = "select studentID,examID,subjectID from result";
			String query2 = "select name from subject";

			// rs = stmt.executeQuery(query1);
			rs1 = stmt1.executeQuery(query2);
			while (rs1.next()) {
				// System.out.println(rset.getString(1));
				// String s = rset.getString("staffID");
				// comboBox_1.addItem((rs.getString("examID")));
				comboBox_2.addItem((rs1.getString("name")));
				// comboBox.addItem((rs.getString("studentID")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}
}
