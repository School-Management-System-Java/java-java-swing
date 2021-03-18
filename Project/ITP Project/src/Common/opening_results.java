package Common;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Home;
import Result_management.exam_content;
import Result_management.result_content;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class opening_results extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opening_results frame = new opening_results();
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
	public opening_results() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(opening_results.class.getResource("/Images/result_add.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				exam_content c = new exam_content();
				c.setVisible(true);
			}
		});
		button.setBounds(265, 216, 244, 172);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(opening_results.class.getResource("/Images/exam.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result_content nwpage = new result_content();
				nwpage.setVisible(true);
			}
		});
		button_1.setBounds(571, 216, 244, 172);
		contentPane.add(button_1);
		
		JLabel lblResultManagement = new JLabel("Result Management");
		lblResultManagement.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblResultManagement.setBounds(366, 45, 355, 43);
		contentPane.add(lblResultManagement);
		
		JLabel lblAddResults = new JLabel("Add Results");
		lblAddResults.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddResults.setBounds(338, 399, 104, 25);
		contentPane.add(lblAddResults);
		
		JLabel lblShowResults = new JLabel("Show Results");
		lblShowResults.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShowResults.setBounds(634, 399, 124, 25);
		contentPane.add(lblShowResults);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(504, 495, 115, 29);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(opening_results.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);
	
	}
}
