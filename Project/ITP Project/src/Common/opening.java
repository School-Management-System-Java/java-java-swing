package Common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import Class_management.add_class;
import Class_management.classes;
import Class_management.staff_update_delete;
import Main.Home;
import Result_management.exam_content;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class opening {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opening window = new opening();
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
	public opening() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(opening.class.getResource("/Images/assign.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				classes c = new classes();
				c.setVisible(true);
			}
		});
		btnNewButton.setBounds(419, 213, 244, 172);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblSchoolManagementSystem = new JLabel("Class Management");
		lblSchoolManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblSchoolManagementSystem.setBounds(383, 58, 355, 43);
		frame.getContentPane().add(lblSchoolManagementSystem);
		
		JLabel lblClassManagement = new JLabel("Assign Class");
		lblClassManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClassManagement.setBounds(491, 400, 133, 25);
		frame.getContentPane().add(lblClassManagement);
		
		JLabel lblResultManagement = new JLabel("Add Class");
		lblResultManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultManagement.setBounds(191, 400, 104, 25);
		frame.getContentPane().add(lblResultManagement);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(opening.class.getResource("/Images/classroom.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame.dispose();
				add_class ac = new add_class();
				ac.setVisible(true);
			}
		});
		button_1.setBounds(113, 213, 244, 172);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(opening.class.getResource("/Images/school.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//frame.dispose();
				staff_update_delete sud = new staff_update_delete();
				sud.setVisible(true);
				
			}
		});
		button_2.setBounds(725, 213, 244, 172);
		frame.getContentPane().add(button_2);
		
		JLabel lblShowAllClasses = new JLabel("Show Available Classes");
		lblShowAllClasses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShowAllClasses.setBounds(745, 400, 230, 25);
		frame.getContentPane().add(lblShowAllClasses);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home home=new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(465, 479, 115, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(opening.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		frame.getContentPane().add(label);
		
		
	}
}
