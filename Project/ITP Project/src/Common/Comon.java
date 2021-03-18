package Common;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Noticeboard.NoticeMain;
import Parent.ParentMain;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Comon extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comon frame = new Comon();
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
	public Comon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btn = new JButton("");
		btn.setForeground(new Color(255, 0, 0));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setIcon(new ImageIcon(Comon.class.getResource("../image/prnt1.png")));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				Comon.this.dispose();
				new ParentMain().setVisible(true);
			
			}
		});
		
		btn.setBounds(118, 316, 253, 210);
		contentPane.add(btn);
		
		JButton btn_1 = new JButton("");
		btn_1.setForeground(new Color(255, 0, 0));
		btn_1.setBackground(Color.LIGHT_GRAY);
		btn_1.setIcon(new ImageIcon(Comon.class.getResource("../image/ntc1.png")));
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				Comon.this.dispose();
				new NoticeMain().setVisible(true);
			
			}
		});
	
		btn_1.setBounds(709, 316, 253, 210);
		contentPane.add(btn_1);
		
		JLabel lblNewLabel_1 = new JLabel("     Parent");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(157, 537, 159, 52);
		contentPane.add(lblNewLabel_1);
	
		
		JLabel lblNotice = new JLabel("NoticeBoard");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNotice.setBounds(767, 537, 152, 52);
		contentPane.add(lblNotice);
		
		
		JLabel lblNewLabel_2 = new JLabel("School Management System");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(297, 83, 491, 106);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setIcon(new ImageIcon(Comon.class.getResource("../image/s1.png")));
		lblNewLabel_3.setBounds(10, 11, 265, 178);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Comon.class.getResource("/image/s1.png")));
		label.setEnabled(false);
		label.setBounds(809, 11, 265, 178);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(106, 306, 868, 276);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Comon.class.getResource("../image/img.png")));
		lblNewLabel.setBounds(0, 0, 1084, 611);
		contentPane.add(lblNewLabel);
		
	}
}
