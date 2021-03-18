package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class L_Main extends JFrame {

	private JPanel contentPane;
	JFrame hh;

	static L_Main yy;
	
	static JLabel zz;
	static JLabel jlabel11;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L_Main frame = new L_Main();
					frame.setTitle("Home Page");
					yy = new L_Main();
					
					yy.hh = frame;
										
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
	public L_Main() {
		

		L_Main.this.setTitle("Library Home Page");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				L_Main.this.dispose();
				new AddMember().setVisible(true);
			}
		});
		label.setBounds(102, 115, 144, 183);
		label.setIcon(new ImageIcon(L_Main.class.getResource("/images/followers.png")));
		label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(label);
		
		JLabel lblAddMember = new JLabel("Add Member");
		lblAddMember.setBounds(77, 292, 180, 57);
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAddMember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(lblAddMember);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				L_Main.this.dispose();
				new AddBook().setVisible(true);
			}
		});

		label_1.setBounds(497, 130, 144, 183);
		label_1.setIcon(new ImageIcon(L_Main.class.getResource("/images/add-contact.png")));
		label_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(label_1);
		
		JLabel lblAddMember_1 = new JLabel("Add Books");
		lblAddMember_1.setBounds(480, 292, 180, 57);
		lblAddMember_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAddMember_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(lblAddMember_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				L_Main.this.dispose();
				new RentBook().setVisible(true);
				
			}
		});
		label_2.setBounds(871, 115, 144, 183);
		label_2.setIcon(new ImageIcon(L_Main.class.getResource("/images/study.png")));
		label_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(label_2);
		
		JLabel lblReturnBook_1 = new JLabel("Return Book");
		lblReturnBook_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBook_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReturnBook_1.setBounds(77, 522, 180, 57);
		contentPane.add(lblReturnBook_1);
		
		JLabel lblReturnBook = new JLabel("Rent Book");
		lblReturnBook.setBounds(849, 292, 180, 57);
		lblReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReturnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(lblReturnBook);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		label_3.setBounds(871, 362, 144, 183);
		label_3.setIcon(new ImageIcon(L_Main.class.getResource("/images/back (1).png")));
		label_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		contentPane.add(label_3);
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.setBounds(871, 522, 180, 57);
		lblGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(lblGoBack);
		
		JLabel label_5 = 
				new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				L_Main.this.dispose();
			    new	searchrental().setVisible(true);
				
			}
		});
		label_5.setBounds(497, 372, 144, 183);
		label_5.setIcon(new ImageIcon(L_Main.class.getResource("/images/searching.png")));
		label_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(label_5);
		
		JLabel lblSearch = new JLabel("Search Rentals");
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblSearch.setBounds(480, 522, 180, 57);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(lblSearch);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				L_Main.this.dispose();
				new ReturnBook().setVisible(true);
			}
		});
		label_4.setIcon(new ImageIcon(L_Main.class.getResource("/images/study.png")));
		label_4.setBounds(102, 359, 144, 183);
		contentPane.add(label_4);
		
		jlabel11= new JLabel("Welcome To Libray System");
		jlabel11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jlabel11.setBounds(372, 33, 614, 41);
		contentPane.add(jlabel11);
		zz = jlabel11;
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(L_Main.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, -99, 1082, 702);
		contentPane.add(lblNewLabel);
		
		
	}
	public static void MakeTxt() {


	}
}
