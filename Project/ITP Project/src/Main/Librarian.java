package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian frame = new Librarian();
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
	public Librarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconLibrary = new JLabel("");
		iconLibrary.setIcon(new ImageIcon(Librarian.class.getResource("/image/library-icon.png")));
		iconLibrary.setBounds(472, 209, 136, 135);
		contentPane.add(iconLibrary);
		
		JLabel label_1 = new JLabel("Library");
		label_1.setBounds(506, 353, 69, 20);
		contentPane.add(label_1);
		
		JLabel iconPayment = new JLabel("");
		iconPayment.setIcon(new ImageIcon(Librarian.class.getResource("/image/payment-icon.png")));
		iconPayment.setBounds(634, 209, 162, 128);
		contentPane.add(iconPayment);
		
		JLabel label_3 = new JLabel("Payment");
		label_3.setBounds(651, 353, 69, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("School Management System");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(339, 84, 392, 42);
		contentPane.add(label_4);
		
		JButton button = new JButton("Log Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.main(null);
			}
		});
		button.setBounds(826, 53, 143, 51);
		contentPane.add(button);
	}

}
