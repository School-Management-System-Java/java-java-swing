package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Common.DBConnection;
import Common.Temp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentUpdateMain extends JFrame {

	private JPanel contentPane;

	private String studentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUpdateMain frame = new StudentUpdateMain();
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
	public StudentUpdateMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(301, 201, 163, 50);
		contentPane.add(lblStudentId);

		JFormattedTextField txtStudentID = new JFormattedTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStudentID.setBounds(506, 202, 280, 50);
		contentPane.add(txtStudentID);

		JLabel lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResult.setBounds(301, 281, 140, 20);
		contentPane.add(lblResult);

		JLabel lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblUpdateStudent.setBounds(416, 46, 276, 54);
		contentPane.add(lblUpdateStudent);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentMain studentMain = new StudentMain();
				studentMain.setVisible(true);
			}
		});
		btnBack.setBounds(484, 497, 192, 53);
		contentPane.add(btnBack);

		txtStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					con = DBConnection.getDBConnection();

					studentID = txtStudentID.getText().toString();

					String sql = "select nameWithInitial from student where studentID=?";
					stmt = con.prepareStatement(sql);
					con.setAutoCommit(false);
					stmt.setString(1, studentID);
					rs = stmt.executeQuery();

					ArrayList list = new ArrayList();

					while (rs.next()) {
						list.add(rs.getString(1));
					}
					if (list.size() == 0) {
						lblResult.setForeground(Color.RED);
						lblResult.setText("Student not found!!!");
					} else {
						Temp temp = new Temp();
						temp.setStudentID(studentID);
						lblResult.setForeground(Color.BLACK);
						lblResult.setText(list.get(0).toString());
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.setVisible(true);
			}
		});
		btnUpdate.setBounds(319, 384, 192, 53);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				PreparedStatement stmt = null;
				// ResultSet rs= null;

				try {
					if (lblResult.getText().equals("Student not found!!!")) {
						JOptionPane.showMessageDialog(null, "Connot delete record!!!");
					} else {
						con = DBConnection.getDBConnection();
						String deleteSql = "delete from student where studentID=?";

						stmt = con.prepareStatement(deleteSql);
						stmt.setString(1, studentID);
						JOptionPane.showMessageDialog(null, "Student Successfully Deleted!!!");
						stmt.execute();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(631, 384, 192, 53);
		contentPane.add(btnDelete);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentUpdateMain.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
