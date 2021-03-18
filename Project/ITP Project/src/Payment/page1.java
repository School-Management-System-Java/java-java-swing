package Payment;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Main.Home;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class page1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page1 window = new page1();
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
	public page1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT  MANAGEMENT  SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(252, 49, 597, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAnnualSchoolFees = new JButton("ANNUAL  FEES  PAYMENT");
		btnAnnualSchoolFees.setBackground(Color.LIGHT_GRAY);
		btnAnnualSchoolFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				page3 Page3 = new page3();
				Page3.main(null);
			}
		});
		btnAnnualSchoolFees.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnnualSchoolFees.setBounds(409, 201, 366, 75);
		frame.getContentPane().add(btnAnnualSchoolFees);
		
		JButton btnNewButton_1 = new JButton("VIEW  PAYMENT  DETAILS");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				page4 Page4 = new page4();
				Page4.main(null);
			}
		});		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(409, 315, 366, 80);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnDeletePayment = new JButton("DELETE  PAYMENT");
		btnDeletePayment.setBackground(Color.LIGHT_GRAY);
		btnDeletePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				page5 Page5 = new page5();
				Page5.main(null);
			}
		});		
		btnDeletePayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeletePayment.setBounds(409, 422, 366, 75);
		frame.getContentPane().add(btnDeletePayment);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("../image/cash.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(image));
		lblNewLabel_1.setBounds(79, 201, 320, 322);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image image1 = new ImageIcon(this.getClass().getResource("../image/cash1.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(image1));
		lblNewLabel_2.setBounds(828, 329, 97, 66);
		frame.getContentPane().add(lblNewLabel_2);
		Image image2 = new ImageIcon(this.getClass().getResource("../image/view.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(image2));
		
		JLabel label_1 = new JLabel("");
		Image image3 = new ImageIcon(this.getClass().getResource("../image/delete1.png")).getImage();
		label_1.setIcon(new ImageIcon(image3));
		label_1.setBounds(828, 431, 75, 66);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		Image image4 = new ImageIcon(this.getClass().getResource("../image/Cash2.png")).getImage();
		label.setIcon(new ImageIcon(image4));
		label.setBounds(828, 210, 75, 66);
		frame.getContentPane().add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(409, 513, 366, 75);
		frame.getContentPane().add(btnBack);
		
		JLabel label_2 = new JLabel("");
		Image image5 = new ImageIcon(this.getClass().getResource("../image/bg.png")).getImage();
		label_2.setIcon(new ImageIcon(image5));
		label_2.setBounds(0, 0, 1078, 594);
		frame.getContentPane().add(label_2);
	}

}
