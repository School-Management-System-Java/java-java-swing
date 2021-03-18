package Parent;

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

public class ParentMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParentMain frame = new ParentMain();
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
	public ParentMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Parent System");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(417, 76, 271, 86);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(ParentMain.class.getResource("../image/insertPS.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ParentMain.this.dispose();
				new AddParent().setVisible(true);

			}
		});
		btnNewButton.setBounds(119, 364, 150, 137);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ParentMain.class.getResource("../image/searchS.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ParentMain.this.dispose();
				new SearchParent().setVisible(true);

			}
		});
		btnNewButton_1.setBounds(473, 364, 150, 137);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Insert");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(161, 512, 91, 47);
		contentPane.add(lblNewLabel_2);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSearch.setBounds(508, 512, 91, 47);
		contentPane.add(lblSearch);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ParentMain.class.getResource("../image/homeS.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ParentMain.this.dispose();
				new Home().setVisible(true);

			}
		});
		btnNewButton_2.setBounds(816, 364, 150, 137);
		contentPane.add(btnNewButton_2);

		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHome.setBounds(867, 512, 91, 47);
		contentPane.add(lblHome);

		/*JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(ParentMain.class.getResource("../image/s1.png")));
		label.setBounds(818, 11, 256, 151);
		contentPane.add(label);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setIcon(new ImageIcon(ParentMain.class.getResource("../image/s1.png")));
		lblNewLabel_3.setBounds(10, 11, 256, 151);
		contentPane.add(lblNewLabel_3);*/

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(ParentMain.class.getResource("../image/img.png")));
		lblNewLabel1.setBounds(0, 0, 1084, 611);
		contentPane.add(lblNewLabel1);

	}
}
