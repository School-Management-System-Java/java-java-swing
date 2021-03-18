package Noticeboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Common.Comon;
import Main.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NoticeMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeMain frame = new NoticeMain();
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
	public NoticeMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Notice Board System");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(355, 81, 370, 81);
		contentPane.add(lblNewLabel_1);

		JButton button = new JButton("");
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(NoticeMain.class.getResource("../image/insertNS.png")));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				NoticeMain.this.dispose();
				new AddNotice().setVisible(true);

			}
		});
		button.setBounds(119, 364, 150, 137);
		contentPane.add(button);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(NoticeMain.class.getResource("../image/searchS.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				NoticeMain.this.dispose();
				new SearchNotice().setVisible(true);

			}
		});
		btnNewButton.setBounds(473, 364, 150, 137);
		contentPane.add(btnNewButton);

		JButton button_1 = new JButton("");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		button_1.setIcon(new ImageIcon(NoticeMain.class.getResource("../image/homeS.png")));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				NoticeMain.this.dispose();
				new Home().setVisible(true);

			}
		});
		button_1.setBounds(816, 364, 150, 137);
		contentPane.add(button_1);

		JLabel lblInsert = new JLabel("Insert");
		lblInsert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInsert.setBounds(161, 512, 91, 47);
		contentPane.add(lblInsert);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSearch.setBounds(508, 512, 91, 47);
		contentPane.add(lblSearch);

		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHome.setBounds(861, 512, 91, 47);
		contentPane.add(lblHome);

		/*JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setIcon(new ImageIcon(NoticeMain.class.getResource("../image/s1.png")));
		lblNewLabel_2.setBounds(10, 11, 256, 151);
		contentPane.add(lblNewLabel_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NoticeMain.class.getResource("/image/s1.png")));
		label.setEnabled(false);
		label.setBounds(818, 11, 256, 151);
		contentPane.add(label);*/

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(NoticeMain.class.getResource("../image/img.png")));
		lblNewLabel1.setBounds(0, 0, 1084, 611);
		contentPane.add(lblNewLabel1);

	}
}
