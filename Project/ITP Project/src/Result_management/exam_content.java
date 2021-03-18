package Result_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import Common.TempClass;
import Common.opening;
import Common.opening_results;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class exam_content extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exam_content frame = new exam_content();
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
	public exam_content() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(404, 185, 54, 19);
		contentPane.add(lblClass);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose Class", "6A", "6B", "6C", "6D", "6E", "7A", "7B", "7C", "7D", "7E", "8A", "8B", "8C", "8D", "8E", "9A", "9B", "9C", "9D", "9E", "10A", "10B", "10C", "10D", "10E", "11A", "11B", "11C", "11D", "11E", "12Combined Mathematics", "12Biological Science", "12Commerce", "12Bio-tech", "12Engineering-tech", "12Arts", "13Combined Mathematics", "13Biological Science", "13Commerce", "13Bio-tech", "13Engineering-tech", "13Arts"}));
		comboBox_1.setBounds(467, 182, 217, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose Term", "2019 - 2nd Term", "2019 - 1st Term", "2018 - 3rd Term"}));
		comboBox.setBounds(467, 250, 217, 25);
		contentPane.add(comboBox);
		
		JButton btnselect = new JButton("SELECT");
		btnselect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String combo1 = comboBox_1.getSelectedItem().toString();
					String combo = comboBox.getSelectedItem().toString();

					if (combo1.equals("Choose Class")) {
						JOptionPane.showMessageDialog(null, "Please choose class!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else if(combo.equals("Choose Term")) {
						JOptionPane.showMessageDialog(null, "Please choose Term!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else {
						TempClass tempCla = new TempClass();
						tempCla.setName(combo1);
						result_content nwpage = new result_content();
						nwpage.setVisible(true);
					}
			}
		});
		btnselect.setBounds(700, 355, 121, 50);
		contentPane.add(btnselect);
		
		JLabel label_1 = new JLabel("Term");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(403, 253, 60, 19);
		contentPane.add(label_1);
		
		JButton btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnback.setIcon(new ImageIcon(exam_content.class.getResource("/Images/back.png")));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				opening_results or = new opening_results();
				or.setVisible(true);
			}
		});
		btnback.setBounds(274, 355, 121, 50);
		contentPane.add(btnback);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(exam_content.class.getResource("/Images/bg.png")));
		label.setBounds(0, 0, 1084, 611);
		contentPane.add(label);
	}

}
