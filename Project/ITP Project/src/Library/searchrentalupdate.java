package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class searchrentalupdate extends JFrame {

	private JPanel contentPane;
	private static JTable jtable1;
	private JButton btnNewButton;
	private JButton btnGoBack;
	private JButton btnDelete;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchrentalupdate frame = new searchrentalupdate();
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
	public searchrentalupdate() {
		
		searchrentalupdate.this.setTitle("Update Rental  Details");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane =  new JPanel();
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(22, 143, 1021, 344);
		contentPane.add(scrollPane);
		
		jtable1 = new JTable();
		jtable1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Member Id", "Borrowed Date", "Due Date","Statuz"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jtable1);
		
		btnNewButton = new JButton("Update");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setIcon(new ImageIcon(searchrentalupdate.class.getResource("/images/update.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DefaultTableModel defaautmodelz =(DefaultTableModel) jtable1.getModel();
					int sele = jtable1.getSelectedRow();
					//System.out.print(sele);
					String bookidz = (String)defaautmodelz.getValueAt(sele, 0);
					String memberid = (String)defaautmodelz.getValueAt(sele, 1);
					String burrowdate = (String)defaautmodelz.getValueAt(sele, 2);
					String rentdate = (String)defaautmodelz.getValueAt(sele, 3);
					String statuz = (String)defaautmodelz.getValueAt(sele, 4);
					
					if(statuz.equals("Done")) {
						JOptionPane.showMessageDialog(null, "You Cannot Updated a Compleated rental..!", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						searchrentalupdate.this.dispose();
						new updaterentalz(bookidz,memberid,burrowdate,rentdate).setVisible(true);
						
					}
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select Valid Row..!", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton.setBounds(76, 530, 240, 48);
		contentPane.add(btnNewButton);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchrentalupdate.this.dispose();
				new searchrental().setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setIcon(new ImageIcon(searchrentalupdate.class.getResource("/images/back.png")));
		btnGoBack.setBounds(729, 535, 240, 48);
		contentPane.add(btnGoBack);
		
		btnDelete = new JButton("Delete");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setIcon(new ImageIcon(searchrentalupdate.class.getResource("/images/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					DefaultTableModel defaautmodelz =(DefaultTableModel) jtable1.getModel();
					int sele = jtable1.getSelectedRow();
					//System.out.print(sele);
					String bookidz = (String)defaautmodelz.getValueAt(sele, 0);
					String memberid = (String)defaautmodelz.getValueAt(sele, 1);
					String statuz = (String)defaautmodelz.getValueAt(sele, 4);
					if(statuz.equals("pending")) {
						JOptionPane.showMessageDialog(null, "You Cannot delete a pending item..!", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";
						Connection con = null;
						Statement stmt2 = null;
						Statement stmt = null;
						
						ResultSet rs2 = null;
						
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            		
		            		int i = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete this rental details?");
	            			if(i == 0) {
	            				String sqlupd = "delete  from rental where bookID='"+bookidz+"' and memberID='"+memberid+"' and statuz='Done'";
	    	            		stmt = con.createStatement();
	    	            		stmt.executeUpdate(sqlupd);
	    						
	    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
	    	            		searchrentalupdate.this.dispose();
	    	            		new searchrentalupdate().setVisible(true);
	            			}
					}
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Select Valid Row..!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDelete.setBounds(414, 530, 240, 48);
		contentPane.add(btnDelete);
		
		JLabel lblUpdateRentalDetails = new JLabel("Update Rental Details");
		lblUpdateRentalDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUpdateRentalDetails.setBounds(465, 56, 245, 48);
		contentPane.add(lblUpdateRentalDetails);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(searchrentalupdate.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 1093, 603);
		contentPane.add(lblNewLabel);
		loadDatatotable();
		
	}
	static void loadDatatotable(){
		try {
			
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
					"databaseName=ITP_Project;integratedSecurity=true;";

			Connection con = null;
			Statement stmt = null;
			
			
			ResultSet rs = null;
			
			
			// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		con = DriverManager.getConnection(connectionUrl);
        
        		// Create and execute an SQL statement that returns some data.
        		
        		String sql2 = "select * from rental ";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		
        		// default table model
        		DefaultTableModel dtm =(DefaultTableModel) jtable1.getModel();
        		
        		while (rs.next()) {
					
        			//vector ekath haduwa aluth row ekak hadanawa
        			Vector vv = new Vector();
        			
					vv.add(rs.getString("bookID"));
					vv.add(rs.getString("memberID"));
					vv.add(rs.getString("borrowedDate"));
					vv.add(rs.getString("dueDate"));
					vv.add(rs.getString("statuz"));
					
        			
        			dtm.addRow(vv);
				}
        		
        		
			
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		}
}
