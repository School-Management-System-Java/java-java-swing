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

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class memberHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberHome frame = new memberHome();
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
	public memberHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				memberHome.this.dispose();//close the current frame
				new AddnewMember().setVisible(true);//show new frame
			}
		});
		label.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/followers.png")));
		label.setBounds(270, 180, 128, 167);
		contentPane.add(label);
		
		JLabel lblAddMember = new JLabel("Add Member");
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddMember.setBounds(229, 341, 191, 32);
		contentPane.add(lblAddMember);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
					
					memberHome.this.dispose();
					new search_member().setVisible(true);
					
				
				
			}
		});
		label_1.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/search (3).png")));
		label_1.setBounds(655, 180, 128, 167);
		contentPane.add(label_1);
		
		JLabel lblSearchMember = new JLabel("Search Member");
		lblSearchMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMember.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSearchMember.setBounds(622, 341, 191, 32);
		contentPane.add(lblSearchMember);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/back (1).png")));
		label_2.setBounds(765, 449, 145, 167);
		contentPane.add(label_2);
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGoBack.setBounds(739, 629, 191, 32);
		contentPane.add(lblGoBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				memberHome.this.dispose();
				new Payment().setVisible(true);
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/add-contact.png")));
		lblNewLabel_1.setBounds(117, 482, 159, 115);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ADD Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(106, 629, 155, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				memberHome.this.dispose();
				new Search_Payment().setVisible(true);
				
				
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/search (3).png")));
		lblNewLabel_3.setBounds(444, 470, 199, 128);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Search Payment Deatails");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(398, 633, 261, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(memberHome.class.getResource("/imgz/bg.png")));
		lblNewLabel_2.setBounds(0, 0, 1232, 853);
		contentPane.add(lblNewLabel_2);
	}
}
