
package Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();
		
		JLabel lblStudent = new JLabel("Staff");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblStudent.setBounds(516, 84, 161, 60);
		contentPane.add(lblStudent);
		
		JLabel iconAdd = new JLabel("");
		iconAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				staffne rStudent =new staffne();
				rStudent.setVisible(true);
			}
		});
		Image addImg = new ImageIcon(this.getClass().getResource("../image/add-student-icon.png")).getImage();
		iconAdd.setIcon(new ImageIcon(addImg));
		iconAdd.setBounds(255, 213, 145, 141);
		contentPane.add(iconAdd);
		
		JLabel iconUpdate = new JLabel("");
		iconUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				attendance update = new attendance();
				update.setVisible(true);
			}
		});
		Image updateImg = new ImageIcon(this.getClass().getResource("../image/update-icon.png")).getImage();
		iconUpdate.setIcon(new ImageIcon(updateImg));
		iconUpdate.setBounds(810, 213, 151, 128);
		contentPane.add(iconUpdate);

		JLabel iconList = new JLabel("");
		iconList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Salary list = new Salary();
				list.setVisible(true);
			}
		});
		Image listImg = new ImageIcon(this.getClass().getResource("../image/List-icon.png")).getImage();
		iconList.setIcon(new ImageIcon(listImg));
		iconList.setBounds(516, 213, 128, 141);
		contentPane.add(iconList);
		Image addendImg = new ImageIcon(this.getClass().getResource("../image/attendance-student-icon.png")).getImage();
		
		JLabel lblAddStudent = new JLabel("Staff Member");
		lblAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddStudent.setBounds(265, 357, 119, 20);
		contentPane.add(lblAddStudent);
		
		JLabel lblUpdateStudent = new JLabel("Staff Attendane");
		lblUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateStudent.setBounds(810, 357, 151, 20);
		contentPane.add(lblUpdateStudent);
		
		JLabel lblListStudent = new JLabel("Staff Salary");
		lblListStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListStudent.setBounds(526, 357, 119, 20);
		contentPane.add(lblListStudent);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setIcon(new ImageIcon(Main.class.getResource("/image/Go-back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(453, 480, 204, 68);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}



