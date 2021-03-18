package Class_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.microsoft.sqlserver.jdbc.*;

import Common.TempClass;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class olclasses extends JFrame {

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
					olclasses frame = new olclasses();
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
	public olclasses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(305, 140, 174, 25);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(305, 175, 174, 25);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(305, 210, 174, 25);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_3.setBounds(305, 245, 174, 25);
		contentPane.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_4.setBounds(305, 280, 174, 25);
		contentPane.add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_5.setBounds(305, 315, 174, 25);
		contentPane.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_6.setBounds(305, 350, 174, 25);
		contentPane.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_7.setBounds(305, 385, 174, 25);
		contentPane.add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_8.setBounds(305, 420, 174, 25);
		contentPane.add(comboBox_8);

		JFormattedTextField sb1 = new JFormattedTextField();
		sb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb1.setEditable(false);
		sb1.setBounds(164, 140, 125, 25);
		contentPane.add(sb1);

		JFormattedTextField sb2 = new JFormattedTextField();
		sb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb2.setEditable(false);
		sb2.setBounds(164, 175, 125, 25);
		contentPane.add(sb2);

		JFormattedTextField sb3 = new JFormattedTextField();
		sb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb3.setEditable(false);
		sb3.setBounds(164, 210, 125, 25);
		contentPane.add(sb3);

		JFormattedTextField sb4 = new JFormattedTextField();
		sb4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb4.setEditable(false);
		sb4.setBounds(164, 245, 125, 25);
		contentPane.add(sb4);

		JFormattedTextField sb5 = new JFormattedTextField();
		sb5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb5.setEditable(false);
		sb5.setBounds(164, 280, 125, 25);
		contentPane.add(sb5);

		JFormattedTextField sb6 = new JFormattedTextField();
		sb6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb6.setEditable(false);
		sb6.setBounds(164, 315, 125, 25);
		contentPane.add(sb6);

		JFormattedTextField sb7 = new JFormattedTextField();
		sb7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb7.setEditable(false);
		sb7.setBounds(164, 350, 125, 25);
		contentPane.add(sb7);

		JFormattedTextField sb8 = new JFormattedTextField();
		sb8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb8.setEditable(false);
		sb8.setBounds(164, 385, 125, 25);
		contentPane.add(sb8);

		JFormattedTextField sb9 = new JFormattedTextField();
		sb9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sb9.setEditable(false);
		sb9.setBounds(164, 420, 125, 25);
		contentPane.add(sb9);

		scrollPane.setBounds(507, 141, 410, 346);
		contentPane.add(scrollPane);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Class", "Subject", "Staff" }));
		scrollPane.setViewportView(table);

		Object[] columns = { "Class", "Subject", "Staff" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				comboBox.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_1.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_2.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_3.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_4.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_5.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_6.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_7.setSelectedItem(model.getValueAt(i, 2).toString());
				comboBox_8.setSelectedItem(model.getValueAt(i, 2).toString());

			}
		});
		JButton btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnback.setIcon(new ImageIcon(olclasses.class.getResource("/Images/back.png")));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				classes c1 = new classes();
				c1.setVisible(true);
			}
		});
		btnback.setBounds(161, 511, 121, 50);
		contentPane.add(btnback);

		Object[] row = new Object[9];

		JButton btnsave = new JButton("SAVE");
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsave.setIcon(new ImageIcon(olclasses.class.getResource("/Images/save.png")));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				PreparedStatement stmt1,stmt2,stmt3,stmt,stmt4,stmt5,stmt6,stmt7,stmt8,stmt9,stmt10,stmt11,stmt12,stmt13,stmt14,stmt15,stmt16,stmt17,stmt18,stmt19;
				ResultSet rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11,rs12,rs13,rs14,rs15;
				
				TempClass tempClass = new TempClass();
				
				try {

					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://localhost:1433;"
							+ "databaseName=ITP_Project;integratedSecurity=true;";
					conn = DriverManager.getConnection(url);
					
					//add 1st raw
					String subQuery = "select subjectID from subject where name='" + sb1.getText().toString() + "'";
					String staffQuery = "select staffID from staff where name='" + comboBox.getSelectedItem().toString()+"'";
					String classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt1 = conn.prepareStatement(subQuery);
					stmt2 = conn.prepareStatement(staffQuery);
					stmt3 = conn.prepareStatement(classQuery);

					rs1 = stmt1.executeQuery();
					rs2 = stmt2.executeQuery();
					rs3 = stmt3.executeQuery();
					
					ArrayList list = new ArrayList();
			
					while(rs1.next()) {
						list.add(rs1.getString(1));
					}
					
					while(rs2.next()) {
						list.add(rs2.getString(1));
					}
					
					while(rs3.next()) {
						list.add(rs3.getString(1));
					}
					
					String insert = "insert into class_staff_subject values('"+list.get(2)+"','"+list.get(1)+"','"+list.get(0)+"')";
					
					stmt = conn.prepareStatement(insert);
					stmt.execute();
					//end 1strow
					
					//add 2nd raw
					 String subQuery2 = "select subjectID from subject where name='" + sb2.getText().toString() + "'";
					 String staffQuery2 = "select staffID from staff where name='" + comboBox_1.getSelectedItem().toString()+"'";
					 String  classQuery2 = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt4 = conn.prepareStatement(subQuery2);
					stmt5 = conn.prepareStatement(staffQuery2);
					stmt6 = conn.prepareStatement(classQuery2);

					rs4 = stmt4.executeQuery();
					rs5 = stmt5.executeQuery();
					rs6 = stmt6.executeQuery();
					
					ArrayList list1 = new ArrayList();
			
					while(rs4.next()) {
						list1.add(rs4.getString(1));
					}
					
					while(rs5.next()) {
						list1.add(rs5.getString(1));
					}
					
					while(rs6.next()) {
						list1.add(rs6.getString(1));
					}
					
					String insert2 = "insert into class_staff_subject values('"+list1.get(2)+"','"+list1.get(1)+"','"+list1.get(0)+"')";
					
					stmt16 = conn.prepareStatement(insert2);
					stmt16.execute();
					//end 2nd row
					
					 subQuery = "select subjectID from subject where name='" + sb3.getText().toString() + "'";
					 staffQuery = "select staffID from staff where name='" + comboBox_2.getSelectedItem().toString()+"'";
					 classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt7 = conn.prepareStatement(subQuery);
					stmt8 = conn.prepareStatement(staffQuery);
					stmt9 = conn.prepareStatement(classQuery);

					rs7 = stmt7.executeQuery();
					rs8 = stmt8.executeQuery();
					rs9 = stmt9.executeQuery();
					
					ArrayList list2 = new ArrayList();
			
					while(rs7.next()) {
						list2.add(rs7.getString(1));
					}
					
					while(rs8.next()) {
						list2.add(rs8.getString(1));
					}
					
					while(rs9.next()) {
						list2.add(rs9.getString(1));
					}
					
					String insert3 = "insert into class_staff_subject values('"+list2.get(2)+"','"+list2.get(1)+"','"+list2.get(0)+"')";
					
					stmt17 = conn.prepareStatement(insert3);
					stmt17.execute();
					
					 subQuery = "select subjectID from subject where name='" + sb4.getText().toString() + "'";
					 staffQuery = "select staffID from staff where name='" + comboBox_3.getSelectedItem().toString()+"'";
					 classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt10 = conn.prepareStatement(subQuery);
					stmt11 = conn.prepareStatement(staffQuery);
					stmt12 = conn.prepareStatement(classQuery);

					rs10 = stmt10.executeQuery();
					rs11 = stmt11.executeQuery();
					rs12 = stmt12.executeQuery();
					
					ArrayList list3 = new ArrayList();
			
					while(rs10.next()) {
						list3.add(rs10.getString(1));
					}
					
					while(rs11.next()) {
						list3.add(rs11.getString(1));
					}
					
					while(rs12.next()) {
						list3.add(rs12.getString(1));
					}
					
					String insert4 = "insert into class_staff_subject values('"+list3.get(2)+"','"+list3.get(1)+"','"+list3.get(0)+"')";
					
					stmt18 = conn.prepareStatement(insert4);
					stmt18.execute();
					
					 subQuery = "select subjectID from subject where name='" + sb5.getText().toString() + "'";
					 staffQuery = "select staffID from staff where name='" + comboBox_4.getSelectedItem().toString()+"'";
					 classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt13 = conn.prepareStatement(subQuery);
					stmt14 = conn.prepareStatement(staffQuery);
					stmt15 = conn.prepareStatement(classQuery);

					rs13 = stmt13.executeQuery();
					rs14 = stmt14.executeQuery();
					rs15 = stmt15.executeQuery();
					
					ArrayList list4 = new ArrayList();
			
					while(rs13.next()) {
						list4.add(rs13.getString(1));
					}
					
					while(rs14.next()) {
						list4.add(rs14.getString(1));
					}
					
					while(rs15.next()) {
						list4.add(rs15.getString(1));
					}
					
					String insert5 = "insert into class_staff_subject values('"+list4.get(2)+"','"+list4.get(1)+"','"+list4.get(0)+"')";
					
					stmt19 = conn.prepareStatement(insert5);
					stmt19.execute();
				
					String subQuery6 = "select subjectID from subject where name='" + sb6.getText().toString() + "'";
					String staffQuery6 = "select staffID from staff where name='" + comboBox_5.getSelectedItem().toString()+"'";
					String classQuery6 = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt1 = conn.prepareStatement(subQuery6);
					stmt2 = conn.prepareStatement(staffQuery6);
					stmt3 = conn.prepareStatement(classQuery6);

					rs1 = stmt1.executeQuery();
					rs2 = stmt2.executeQuery();
					rs3 = stmt3.executeQuery();
					
					ArrayList list6 = new ArrayList();
			
					while(rs1.next()) {
						list6.add(rs1.getString(1));
					}
					
					while(rs2.next()) {
						list6.add(rs2.getString(1));
					}
					
					while(rs3.next()) {
						list6.add(rs3.getString(1));
					}
					
					String insert6 = "insert into class_staff_subject values('"+list6.get(2)+"','"+list6.get(1)+"','"+list6.get(0)+"')";
					
					stmt = conn.prepareStatement(insert6);
					stmt.execute();
					//end 1strow
					
					//add 2nd raw
					 String subQuery7 = "select subjectID from subject where name='" + sb7.getText().toString() + "'";
					 String staffQuery7 = "select staffID from staff where name='" + comboBox_6.getSelectedItem().toString()+"'";
					 String  classQuery7 = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt4 = conn.prepareStatement(subQuery7);
					stmt5 = conn.prepareStatement(staffQuery7);
					stmt6 = conn.prepareStatement(classQuery7);

					rs4 = stmt4.executeQuery();
					rs5 = stmt5.executeQuery();
					rs6 = stmt6.executeQuery();
					
					ArrayList list7 = new ArrayList();
			
					while(rs4.next()) {
						list7.add(rs4.getString(1));
					}
					
					while(rs5.next()) {
						list7.add(rs5.getString(1));
					}
					
					while(rs6.next()) {
						list7.add(rs6.getString(1));
					}
					
					String insert7 = "insert into class_staff_subject values('"+list7.get(2)+"','"+list7.get(1)+"','"+list7.get(0)+"')";
					
					stmt16 = conn.prepareStatement(insert7);
					stmt16.execute();
					//end 2nd row
					
					 subQuery = "select subjectID from subject where name='" + sb8.getText().toString() + "'";
					 staffQuery = "select staffID from staff where name='" + comboBox_7.getSelectedItem().toString()+"'";
					 classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt7 = conn.prepareStatement(subQuery);
					stmt8 = conn.prepareStatement(staffQuery);
					stmt9 = conn.prepareStatement(classQuery);

					rs7 = stmt7.executeQuery();
					rs8 = stmt8.executeQuery();
					rs9 = stmt9.executeQuery();
					
					ArrayList list8 = new ArrayList();
			
					while(rs7.next()) {
						list8.add(rs7.getString(1));
					}
					
					while(rs8.next()) {
						list8.add(rs8.getString(1));
					}
					
					while(rs9.next()) {
						list8.add(rs9.getString(1));
					}
					
					String insert8 = "insert into class_staff_subject values('"+list8.get(2)+"','"+list8.get(1)+"','"+list8.get(0)+"')";
					
					stmt17 = conn.prepareStatement(insert8);
					stmt17.execute();
					
					 subQuery = "select subjectID from subject where name='" + sb9.getText().toString() + "'";
					 staffQuery = "select staffID from staff where name='" + comboBox_8.getSelectedItem().toString()+"'";
					 classQuery = "select classID from class where name='"+tempClass.getName()+"'";
					
					stmt10 = conn.prepareStatement(subQuery);
					stmt11 = conn.prepareStatement(staffQuery);
					stmt12 = conn.prepareStatement(classQuery);

					rs10 = stmt10.executeQuery();
					rs11 = stmt11.executeQuery();
					rs12 = stmt12.executeQuery();
					
					ArrayList list9 = new ArrayList();
			
					while(rs10.next()) {
						list9.add(rs10.getString(1));
					}
					
					while(rs11.next()) {
						list9.add(rs11.getString(1));
					}
					
					while(rs12.next()) {
						list9.add(rs12.getString(1));
					}
					
					String insert9 = "insert into class_staff_subject values('"+list9.get(2)+"','"+list9.get(1)+"','"+list9.get(0)+"')";
					
					stmt18 = conn.prepareStatement(insert9);
					stmt18.execute();
					
					row[0] = tempClass.getName();
					row[1] = sb1.getText().toString();
					row[2] = comboBox.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb2.getText().toString();
					row[2] = comboBox_1.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb3.getText().toString();
					row[2] = comboBox_2.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb4.getText().toString();
					row[2] = comboBox_3.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb5.getText().toString();
					row[2] = comboBox_4.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb6.getText().toString();
					row[2] = comboBox_5.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb7.getText().toString();
					row[2] = comboBox_6.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb8.getText().toString();
					row[2] = comboBox_7.getSelectedItem().toString();
					model.addRow(row);

					row[0] = tempClass.getName();
					row[1] = sb9.getText().toString();
					row[2] = comboBox_8.getSelectedItem().toString();
					model.addRow(row);


				// Declare the JDBC objects.
/*				Connection con = null;
				CallableStatement cstmt = null;
				ResultSet rs = null;

				try {
					// Establish the connection.
					SQLServerDataSource ds = new SQLServerDataSource();
					ds.setIntegratedSecurity(true);
					ds.setServerName("localhost");
					ds.setPortNumber(1433);
					ds.setDatabaseName("ITP_Project1");
					con = ds.getConnection();

					// Execute a stored procedure that returns some data.
					cstmt = con.prepareCall("{call dbo.udpClssDetail(?,?,?)}");
					// String classID = clid.getText().toString();
					String stfID = comboBox.getSelectedItem().toString();
					String stfID1 = comboBox_1.getSelectedItem().toString();
					// cstmt.setString(1, classID);
					cstmt.setString(2, stfID);
					cstmt.setString(3, stfID1);

					rs = cstmt.executeQuery();

					// Iterate through the data in the result set and display it.
				}
*/
				// Handle any errors that may have occurred.
				}catch (Exception e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(null, "Data already exists! you can update...", "Error",
								JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnsave.setBounds(365, 511, 121, 50);
		contentPane.add(btnsave);

		JButton btnupdate = new JButton("CHANGE  TABLE  STRUCTURE");
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnupdate.setIcon(new ImageIcon(olclasses.class.getResource("/Images/update.png")));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staff_update_delete page1 = new staff_update_delete();
				page1.setVisible(true);

/*				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(comboBox.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_1.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_2.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_3.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_4.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_5.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_6.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_7.getSelectedItem().toString(), i, 2);
					model.setValueAt(comboBox_8.getSelectedItem().toString(), i, 2);
				} else {
					JOptionPane.showMessageDialog(null, "Please choose row to Update", "Update Error",
							JOptionPane.ERROR_MESSAGE);
				}
*/
			}

		});
		btnupdate.setBounds(582, 511, 260, 50);
		contentPane.add(btnupdate);
		
		JButton button = new JButton("DETAILS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class_details cd = new class_details();
				cd.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(934, 437, 121, 50);
		contentPane.add(button);
		
				JLabel label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(olclasses.class.getResource("/Images/bg.png")));
				label_1.setBounds(0, 0, 1084, 611);
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=ITP_Project;integratedSecurity=true;";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();

			String query2 = "select name from subject where subjectID='SB01'";

			rs = stmt.executeQuery(query2);
			while (rs.next()) {
				sb1.setText(rs.getString("name"));

			}

			String query3 = "select name from subject where subjectID='SB02'";

			rs = stmt.executeQuery(query3);
			while (rs.next()) {
				sb2.setText(rs.getString("name"));
			}

			String query4 = "select name from subject where subjectID='SB03'";

			rs = stmt.executeQuery(query4);
			while (rs.next()) {
				sb3.setText(rs.getString("name"));
			}

			String query5 = "select name from subject where subjectID='SB04'";

			rs = stmt.executeQuery(query5);
			while (rs.next()) {
				sb4.setText(rs.getString("name"));
			}

			String query6 = "select name from subject where subjectID='SB05'";

			rs = stmt.executeQuery(query6);
			while (rs.next()) {
				sb5.setText(rs.getString("name"));
			}

			String query7 = "select name from subject where subjectID='SB06'";

			rs = stmt.executeQuery(query7);
			while (rs.next()) {
				sb6.setText(rs.getString("name"));
			}

			String query8 = "select name from subject where subjectID='SB07'";

			rs = stmt.executeQuery(query8);
			while (rs.next()) {
				sb7.setText(rs.getString("name"));
			}

			String query9 = "select name from subject where subjectID='SB08'";

			rs = stmt.executeQuery(query9);
			while (rs.next()) {
				sb8.setText(rs.getString("name"));
			}

			String query10 = "select name from subject where subjectID='SB09'";

			rs = stmt.executeQuery(query10);
			while (rs.next()) {
				sb9.setText(rs.getString("name"));
			}
			
			///////////////////
			String subject1 = sb1.getText().toString();
			String qry1= "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry1);
			pstmt.setString(1, subject1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				comboBox.addItem((rs.getString("name")));
			}

			String subject = sb2.getText().toString();
			String qry2 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry2);
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_1.addItem((rs.getString("name")));
			}

			String subject3 = sb3.getText().toString();
			String qry3 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry3);
			pstmt.setString(1, subject3);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_2.addItem((rs.getString("name")));
			}
			
			String subject4 = sb4.getText().toString();
			String qry4 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry4);
			pstmt.setString(1, subject4);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_3.addItem((rs.getString("name")));
			}
			
			String subject5 = sb5.getText().toString();
			String qry5 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry5);
			pstmt.setString(1, subject5);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_4.addItem((rs.getString("name")));
			}	

			String subject6 = sb6.getText().toString();
			String qry6 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry6);
			pstmt.setString(1, subject6);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_5.addItem((rs.getString("name")));
			}

			String subject7 = sb7.getText().toString();
			String qry7 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry7);
			pstmt.setString(1, subject7);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_6.addItem((rs.getString("name")));
			}
			
			String subject8 = sb8.getText().toString();
			String qry8 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry8);
			pstmt.setString(1, subject8);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_7.addItem((rs.getString("name")));
			}
			
			String subject9 = sb9.getText().toString();
			String qry9 = "select s.name from staff s,subject sb,staff_subject ss where s.staffID=ss.staffID and sb.subjectID=ss.subjectID and sb.name=?";
			pstmt = con.prepareStatement(qry9);
			pstmt.setString(1, subject9);
			rs = pstmt.executeQuery();
			//int n=1;
			while (rs.next()) {
				comboBox_8.addItem((rs.getString("name")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
