package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;

public class RentBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtuname;
	private JTextField txtbookname;
	JFrame hh;

	static RentBook yy;
	private JTextField textFieldduedate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentBook frame = new RentBook();
					frame.setTitle("Rent Book");
					frame.setVisible(true);
					
					
yy = new RentBook();
					
					yy.hh = frame;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentBook() {
		
		RentBook.this.setTitle("Rent Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650
				);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Staff", "Student"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(503, 32, 463, 49);
		contentPane.add(comboBox);
		
		JList list_1 = new JList();
		txtuname = new JTextField();
		txtuname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String memberz = comboBox.getSelectedItem().toString();
				
				if(memberz.equals("Student")) {
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

						// Declare the JDBC objects.
						Connection con = null;
						Statement stmt = null;
						ResultSet rs = null;
						
				        	try {
				        		// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            
				            		// Create and execute an SQL statement that returns some data.
				            		String SQL = "SELECT *	FROM student where fName like '"+txtuname.getText()+"%'  ";
				            		stmt = con.createStatement();
				            		rs = stmt.executeQuery(SQL);
				            
				            		// Iterate through the data in the result set and display it.
				            		Vector cc = new Vector();
				            		while (rs.next()) {
				            			
				            			
				            			
				            			cc.add(rs.getString(2)+","+rs.getString("libMemID"));
				            			list_1.setListData(cc);
				            			//System.out.println(rs.getString(3));
				            		}
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception ee) {
							ee.printStackTrace();
						}
				}else {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

						// Declare the JDBC objects.
						Connection con = null;
						Statement stmt = null;
						ResultSet rs = null;
						
				        	try {
				        		// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            
				            		// Create and execute an SQL statement that returns some data.
				            		String SQL = "SELECT *	FROM staff where name like '"+txtuname.getText()+"%'";
				            		stmt = con.createStatement();
				            		rs = stmt.executeQuery(SQL);
				            
				            		// Iterate through the data in the result set and display it.
				            		Vector cc = new Vector();
				            		while (rs.next()) {
				            			
				            			
				            			
				            			cc.add(rs.getString(2)+","+rs.getString("libMemID"));
				            			list_1.setListData(cc);
				            			//System.out.println(rs.getString(3));
				            		}
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception ee) {
							ee.printStackTrace();
						}
					
				}
				
			}
		});
		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					txtuname.setText(list_1.getSelectedValue().toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Selection", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
				}
			}
		});
		list_1.setBounds(741, 216, 259, 88);
		contentPane.add(list_1);
		
		
		txtuname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtuname.setText("");
			}
		});
		
		
		txtuname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtuname.setHorizontalAlignment(SwingConstants.CENTER);
		txtuname.setText("Enter UserName");
		txtuname.setBounds(741, 111, 259, 61);
		contentPane.add(txtuname);
		txtuname.setColumns(10);
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					txtbookname.setText(list.getSelectedValue().toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Selection", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog

				}
			}
		});
		list.setBounds(184, 216, 259, 88);
		contentPane.add(list);
		
		
		txtbookname = new JTextField();
		txtbookname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				// Declare the JDBC objects.
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				
		        	try {
		        		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

		        		// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "SELECT *	FROM book where name like '"+txtbookname.getText()+"%' ";
		            		stmt = con.createStatement();
		            		rs = stmt.executeQuery(SQL);
		            
		            		// Iterate through the data in the result set and display it.
		            		Vector cc = new Vector();
		            		while (rs.next()) {
		            			
		            			
		            			
		            			cc.add(rs.getString(2)+","+rs.getString(1));
		            			list.setListData(cc);
		            			//System.out.println(rs.getString(3));
		            		}
		        	}
		        
				// Handle any errors that may have occurred.
				catch (Exception ee) {
					ee.printStackTrace();
				}
				
				
			}
		});
		txtbookname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtbookname.setText("");//text filed ekata text ekak set karanawa
			}
		});
		txtbookname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtbookname.setHorizontalAlignment(SwingConstants.CENTER);
		txtbookname.setText("Enter Book Name");
		txtbookname.setColumns(10);
		txtbookname.setBounds(184, 111, 259, 61);
		contentPane.add(txtbookname);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RentBook.class.getResource("/images/search.png")));
		label.setBounds(653, 108, 64, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(RentBook.class.getResource("/images/open-book.png")));
		label_1.setBounds(108, 108, 64, 64);
		contentPane.add(label_1);
		
		
		
		JLabel lblBorrowDate = new JLabel("Borrow Date");
		lblBorrowDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBorrowDate.setBounds(254, 429, 127, 29);
		contentPane.add(lblBorrowDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDueDate.setBounds(828, 424, 127, 38);
		contentPane.add(lblDueDate);
		
		JLabel lblSelectMemberType = new JLabel(" Select Member Type");
		lblSelectMemberType.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSelectMemberType.setBounds(108, 34, 321, 38);
		contentPane.add(lblSelectMemberType);
		
		textFieldduedate = new JTextField();
		textFieldduedate.setEditable(false);
		textFieldduedate.setBounds(741, 355, 259, 61);
		contentPane.add(textFieldduedate);
		textFieldduedate.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
			            	Date d1z = dateChooser.getDate();
				        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
							String borrowdatez =sdf.format(dateChooser.getDate());
							
				        	
				    		
				    		Calendar c = Calendar.getInstance();
				    		try{
				    		   //Setting the date to the given date
				    		   c.setTime(sdf.parse(borrowdatez));
				    		}catch(ParseException ez){
				    			ez.printStackTrace();
				    		 }
				    		   
				    		//Number of Days to add
				    		c.add(Calendar.DAY_OF_MONTH, 14);  
				    		//Date after adding the days to the given date
				    		String newDate = sdf.format(c.getTime());  
				    		//Displaying the new Date after addition of Days
				    		//System.out.println("Date after Addition: "+newDate);
				    		
				    		textFieldduedate.setText(newDate);
			            }
			        	
			        	
			        }
			    });
			getContentPane().add(dateChooser);
		
		
	
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(179, 355, 264, 61);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Save Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(txtbookname.getText().equals("") || txtuname.getText().equals("") ||txtuname.getText().equals("Enter Book Name") ||txtbookname.getText().equals("Enter Book Name") ) {
					JOptionPane.showMessageDialog(null, "Please Compleate Details To Rent a  Book..!", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
				
				Date d1 = dateChooser.getDate();
				//Date d2 = dateChooser_1.getDate();
				if(d1 == null) {
					JOptionPane.showMessageDialog(null, "Please Fill The Borrow Date & Due Date", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				else {
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					String borrowdate=sdf.format(dateChooser.getDate());
					String duedate = textFieldduedate.getText().toString();
					
					
					//String bookname = txtbookname.getText() ;
					
					
					String memberdetails[] = txtuname.getText().split(",");
					String membername = memberdetails[0];
					String memberid = memberdetails[1];
					
					
					String bookdetails[] = txtbookname.getText().split(",");
					String booknamez = bookdetails[0];
					String bookidz = bookdetails[1];
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Statement stmt2 = null;
					Statement stmt3 = null;
					Statement chkstmt = null;
					
					ResultSet rs = null;
					ResultSet rs2 = null;
					ResultSet rs3 = null;
					ResultSet chkrs = null;
					
					// Establish the connection.
	        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            
	            		// Create and execute an SQL statement that returns some data.
	            		
	            		String sql2 = "select * from book where bookID='"+bookidz+"'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);
	            		if(rs2.next()) {
	            			int qty = Integer.parseInt(rs2.getString(6));
	            			if(qty <= 1) {
	            				JOptionPane.showMessageDialog(rootPane, "Out OF quantity..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			}else {
	            				
	            				String chksql = "select * from rental where memberid='"+memberid+"' and statuz='Pending'";
	            				chkstmt = con.createStatement();
	            				chkrs = chkstmt.executeQuery(chksql);
	            				if(chkrs.next()) {
	    	            			JOptionPane.showMessageDialog(rootPane, "This member Already Purchase a book..!", "Error", JOptionPane.ERROR_MESSAGE);

	            				}else {
	            					String SQL = "INSERT INTO rental(bookID, memberID, borrowedDate, dueDate,statuz)\r\n" + 
		    	            				"VALUES ('"+bookidz+"', '"+memberid+"', '"+borrowdate+"', '"+duedate+"','Pending');";
		    	            		stmt = con.createStatement();
		    	            		stmt.executeUpdate(SQL);
		    	            		
		    	            		String sqlzz = "update book SET noOfCopies=noOfCopies-1 where bookID = '"+bookidz+"' ";
		    	            		stmt3 = con.createStatement();
		    	            		JOptionPane.showMessageDialog(null, "Data Saved");
		    	            		stmt3.executeUpdate(sqlzz);
		    	            		
		    	            		
		    	            		RentBook.this.dispose();
		    	    				new RentBook().setVisible(true);
	            					
	            				}

	    	            		
	    	    				 
	            			}
	            			
	            		}else {
	            			JOptionPane.showMessageDialog(rootPane, "Invalid Book Id", "Error", JOptionPane.ERROR_MESSAGE);
	            		}
	            		
	            		
	            		
	            		
					
	            		
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
		
				}
				
				
			}
			}
		});
		btnNewButton.setIcon(new ImageIcon(RentBook.class.getResource("/images/diskette.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(120, 529, 410, 49);
		btnNewButton.setContentAreaFilled(false);
		contentPane.add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RentBook.this.dispose();
				new L_Main().setVisible(true);
			}
		});
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RentBook.this.dispose();
				new L_Main().setVisible(true);
			}
		});
		
		
		btnGoBack.setIcon(new ImageIcon(RentBook.class.getResource("/images/back.png")));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setBounds(572, 527, 410, 52);
		contentPane.add(btnGoBack);
		
		
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(RentBook.class.getResource("/images/img.png")));
		label_2.setBounds(12, -121, 1070, 724);
		contentPane.add(label_2);
	}
}
