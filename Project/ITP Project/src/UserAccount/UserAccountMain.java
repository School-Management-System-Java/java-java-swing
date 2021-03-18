package UserAccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserAccountMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccountMain frame = new UserAccountMain();
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
	public UserAccountMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image bgImg = new ImageIcon(this.getClass().getResource("../image/bgImg.jpg")).getImage();

		JLabel lblUserAccount = new JLabel("User Account");
		lblUserAccount.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblUserAccount.setBounds(452, 42, 221, 82);
		contentPane.add(lblUserAccount);

		JLabel iconAdd = new JLabel("");
		iconAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				AddAccount addAccount = new AddAccount();
				addAccount.setVisible(true);
			}
		});
		iconAdd.setIcon(new ImageIcon(UserAccountMain.class.getResource("/image/add-account-icon.png")));
		iconAdd.setBounds(132, 210, 146, 159);
		contentPane.add(iconAdd);

		JLabel iconUpdate = new JLabel("");
		iconUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				UserAccountUpdateMain userAccountUpdate = new UserAccountUpdateMain();
				userAccountUpdate.setVisible(true);
			}
		});
		iconUpdate.setIcon(new ImageIcon(UserAccountMain.class.getResource("/image/update-icon.png")));
		iconUpdate.setBounds(495, 236, 128, 128);
		contentPane.add(iconUpdate);

		JLabel iconList = new JLabel("");
		iconList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				UserAccountList accountList = new UserAccountList();
				accountList.setVisible(true);
			}
		});
		iconList.setIcon(new ImageIcon(UserAccountMain.class.getResource("/image/List-icon.png")));
		iconList.setBounds(823, 236, 120, 118);
		contentPane.add(iconList);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setIcon(new ImageIcon(UserAccountMain.class.getResource("/image/Go-back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(464, 457, 186, 68);
		contentPane.add(btnBack);

		JLabel lblAddAccount = new JLabel("Add Account");
		lblAddAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddAccount.setBounds(144, 378, 128, 20);
		contentPane.add(lblAddAccount);

		JLabel lblUpdateAccount = new JLabel("Update Account");
		lblUpdateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateAccount.setBounds(492, 378, 151, 20);
		contentPane.add(lblUpdateAccount);

		JLabel lblListAccount = new JLabel("List Account");
		lblListAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListAccount.setBounds(833, 378, 122, 20);
		contentPane.add(lblListAccount);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UserAccountMain.class.getResource("/image/bg.png")));
		label.setBounds(0, 0, 1078, 594);
		contentPane.add(label);
	}
}
