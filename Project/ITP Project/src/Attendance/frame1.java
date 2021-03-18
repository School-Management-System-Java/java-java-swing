package Attendance;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Student.StudentMain;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT   ATTENDANCE    MANAGEMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(164, 34, 750, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("MARK   ATTENDANCE");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame3 Frame3 = new frame3();
				Frame3.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(170, 143, 331, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW  ATTENDANCE");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame5 Frame5 = new frame5();
				Frame5.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(170, 293, 331, 86);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE   ATTENDANCE");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame6 Frame6 = new frame6();
				Frame6.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(164, 452, 331, 81);
		frame.getContentPane().add(btnNewButton_2);
		
		/*JButton btnNewButton_3 = new JButton("RESULTS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame7 Frame7 = new frame7();
				Frame7.main(null);
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		btnNewButton_3.setBounds(596, 495, 267, 81);
		frame.getContentPane().add(btnNewButton_3);*/
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("../img/att.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(658, 129, 341, 355);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("../img/mark.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img4));
		lblNewLabel_2.setBounds(44, 158, 87, 66);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("../img/view.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img5));
		lblNewLabel_3.setBounds(55, 302, 76, 64);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("../img/delete1.png")).getImage();
		label.setIcon(new ImageIcon(img6));
		label.setBounds(44, 464, 95, 64);
		frame.getContentPane().add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				StudentMain  sm = new StudentMain();
				sm.setVisible(true);
			}
		});
		btnBack.setBounds(581, 504, 180, 50);
		frame.getContentPane().add(btnBack);
		
		JLabel label_1 = new JLabel("");
		Image img8 = new ImageIcon(this.getClass().getResource("../img/bg.png")).getImage();
		label_1.setIcon(new ImageIcon(img8));
		label_1.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label_1);
	}
}
