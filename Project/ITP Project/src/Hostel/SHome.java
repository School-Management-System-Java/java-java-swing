package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class SHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SHome frame = new SHome();
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
	public SHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SHome.this.dispose();
				new AddSubject().setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(SHome.class.getResource("/imgz/followers.png")));
		label.setBounds(231, 74, 128, 156);
		contentPane.add(label);
		
		JLabel lblSubjectName = new JLabel("Add Subject");
		lblSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSubjectName.setBounds(231, 228, 148, 43);
		contentPane.add(lblSubjectName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				SHome.this.dispose();
				new SearchSubject().setVisible(true);
				
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(SHome.class.getResource("/imgz/search (3).png")));
		lblNewLabel.setBounds(632, 82, 128, 148);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearchSubject = new JLabel("Search Subject");
		lblSearchSubject.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSearchSubject.setBounds(610, 232, 180, 34);
		contentPane.add(lblSearchSubject);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(SHome.class.getResource("/imgz/back (1).png")));
		label_1.setBounds(659, 359, 157, 148);
		contentPane.add(label_1);
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGoBack.setBounds(706, 520, 110, 43);
		contentPane.add(lblGoBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SHome.this.dispose();
				new AddStafToSubject().setVisible(true);
				
				
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(SHome.class.getResource("/imgz/followers.png")));
		lblNewLabel_2.setBounds(231, 380, 167, 137);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAddTeachers = new JLabel("Add Staff To Subject");
		lblAddTeachers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddTeachers.setBounds(209, 526, 213, 34);
		contentPane.add(lblAddTeachers);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SHome.class.getResource("/imgz/bg.png")));
		lblNewLabel_1.setBounds(0, 0, 1232, 903);
		contentPane.add(lblNewLabel_1);
	}
}
