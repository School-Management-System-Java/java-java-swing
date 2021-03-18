package Library;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField publishername;
	private JTextField isbnz;
	private JTextField authornamez;
	private JTextField booknamez;
	JFrame hh;

	static AddBook yy;
	private JTextField copiez;
	private JTextField bokkidz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
					frame.setVisible(true);
					frame.setTitle("Add New Book");
					yy = new AddBook();
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
	public AddBook() {
		
		AddBook.this.setTitle("Add New Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookk = new JLabel("Book Name\r\n");
		lblBookk.setBounds(79, 128, 126, 34);
		lblBookk.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblBookk);
		
		JLabel lblNewLabel = new JLabel("ISBN\r\n");
		lblNewLabel.setBounds(79, 228, 120, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Author Name");
		lblNewLabel_1.setBounds(79, 328, 161, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPublisherName = new JLabel("Publisher Name");
		lblPublisherName.setBounds(79, 426, 196, 58);
		lblPublisherName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblPublisherName);
		
		JLabel lblPublisherYear = new JLabel("No Of Copies");
		lblPublisherYear.setBounds(79, 526, 168, 48);
		lblPublisherYear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblPublisherYear);
		
		publishername = new JTextField();
		publishername.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER || key==KeyEvent.VK_BACK_SPACE) {
			        Toolkit.getDefaultToolkit().beep(); 
			       // System.out.println("ENTER pressed");
			        }else {
			        	   char c=e.getKeyChar();
							if(!(Character.isLetter(c))) {
								
								e.consume();//not typing
								JOptionPane.showMessageDialog(null, "Please Enter Valid Name", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
								
								
							}
			        }
			}
		});
		
		publishername.setHorizontalAlignment(SwingConstants.CENTER);
		publishername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//publisheryear.grabFocus();
			}
		});
		publishername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		publishername.setBounds(316, 429, 373, 58);
		contentPane.add(publishername);
		publishername.setColumns(10);
		
		isbnz = new JTextField();
		isbnz.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER || key==KeyEvent.VK_BACK_SPACE) {
			        Toolkit.getDefaultToolkit().beep(); 
			       // System.out.println("ENTER pressed");
			        }else {
			        	char c=e.getKeyChar();
						if(!(Character.isDigit(c))) {
							
							e.consume();//not typing
							JOptionPane.showMessageDialog(null, "Please Enter Valid Name", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
							
							// Enter ekata Hadanna One
						}
			        }
			}
		});
		isbnz.setHorizontalAlignment(SwingConstants.CENTER);
		isbnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//authornamez.grabFocus();
			}
		});
		isbnz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		isbnz.setBounds(316, 219, 373, 58);
		isbnz.setColumns(10);
		contentPane.add(isbnz);
		
		authornamez = new JTextField();
		authornamez.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
			
				
				int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER || key==KeyEvent.VK_BACK_SPACE) {
			        Toolkit.getDefaultToolkit().beep(); 
			       // System.out.println("ENTER pressed");
			        }else {
			        	   char c=e.getKeyChar();
							if(!(Character.isLetter(c))) {
								
								e.consume();//not typing
								JOptionPane.showMessageDialog(null, "Please Enter Valid Name", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
								
								
							}
			        }
			}
		});
		authornamez.setHorizontalAlignment(SwingConstants.CENTER);
		authornamez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//	publishername.grabFocus();
			}
		});
		authornamez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		authornamez.setBounds(316, 319, 373, 58);
		authornamez.setColumns(10);
		contentPane.add(authornamez);
		
		booknamez = new JTextField();
		booknamez.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		booknamez.setHorizontalAlignment(SwingConstants.CENTER);
		booknamez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isbnz.grabFocus();//denata inna eken yanna ona filed eka
			}
		});
		booknamez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		booknamez.setBounds(316, 119, 373, 58);
		booknamez.setColumns(10);
		contentPane.add(booknamez);
		
		JButton jbtnone = new JButton("Save Data");
		jbtnone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				// assign Values to variable
				String bookid= "B" +bokkidz.getText();
				String bookname=booknamez.getText();//textfild eke type karana value eka gannawa
				String isbn=isbnz.getText();
				String authername=authornamez.getText();
				String pubname=publishername.getText();
				
				String noofcopies=copiez.getText();
				
				
				
				
				
				//eken eka his da killa balanna 
				if(bookid.equals("")||bookname.equals("") || isbn.equals("") || authername.equals("") || pubname.equals("") || noofcopies.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill All Feilds To Continue", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					
					try {
						
						int noofcop = Integer.parseInt(noofcopies);
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		String sql2 = "select * from book where bookID='"+bookid+"'";
		            		stmt2 = con.createStatement();
		            		rs = stmt2.executeQuery(sql2);
		            		if(rs.next()) {
		            			JOptionPane.showMessageDialog(null, "This Book ID is Already Registered..!", "Error", JOptionPane.ERROR_MESSAGE);
		            		}else {
		            		
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO book (bookID, name, ISBN, autherName, publisherName,noOfCopies)\r\n" + 
		            				"VALUES ('"+bookid+"', '"+bookname+"', '"+isbn+"', '"+authername+"', '"+pubname+"','"+noofcop+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
		            		JOptionPane.showMessageDialog(null, "Data Saved");
							
		            	
		            		
		            		bokkidz.setText("");
		            		booknamez.setText("");
		    				isbnz.setText("");
		    				authornamez.setText("");
		    				publishername.setText("");
		    				
		    				copiez.setText("");
		            		}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
					
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		jbtnone.setToolTipText("Save Data");
		jbtnone.setIcon(new ImageIcon(AddBook.class.getResource("/images/diskette.png")));
		jbtnone.setBounds(770, 265, 253, 86);
		jbtnone.setContentAreaFilled(false);// button eke wate nathi wenawa
		jbtnone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // button ekata cusor ekak set wenawa
		contentPane.add(jbtnone);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddBook.this.dispose();
				new L_Main().setVisible(true);
			}
		});
		
		btnGoBack.setIcon(new ImageIcon(AddBook.class.getResource("/images/back.png")));
		btnGoBack.setToolTipText("Save Data");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setBounds(770, 488, 253, 86);
		btnGoBack.setContentAreaFilled(false);// button eke wate nathi wenawa
		btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // button ekata cusor ekak set wenawa
		contentPane.add(btnGoBack);
		
		JLabel lblLibryManagementSystem = new JLabel(" Libray Management System");
		lblLibryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibryManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLibryManagementSystem.setBounds(715, 10, 355, 86);
		contentPane.add(lblLibryManagementSystem);
		
		JLabel lblNewLabel_3 = new JLabel("B");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(304, 26, 56, 58);
		contentPane.add(lblNewLabel_3);
		
		copiez = new JTextField();
		copiez.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER || key==KeyEvent.VK_BACK_SPACE) {
			        Toolkit.getDefaultToolkit().beep(); 
			       // System.out.println("ENTER pressed");
			        }else {
			        	   char c=e.getKeyChar();
							if(!(Character.isDigit(c))) {
								
								e.consume();//not typing
								JOptionPane.showMessageDialog(null, "Please Enter Integer Number", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
								
								
							}
			        }
			}
		});
		copiez.setHorizontalAlignment(SwingConstants.CENTER);
		copiez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		copiez.setColumns(10);
		copiez.setBounds(316, 524, 373, 58);
		contentPane.add(copiez);
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBook.this.dispose();
				new Searchbooks().setVisible(true);
				
			}
		});
		btnSearchBook.setIcon(new ImageIcon(AddBook.class.getResource("/images/search.png")));
		btnSearchBook.setToolTipText("Save Data");
		btnSearchBook.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearchBook.setContentAreaFilled(false);
		btnSearchBook.setBounds(770, 374, 253, 86);
		contentPane.add(btnSearchBook);
		
		JLabel lblBookId = new JLabel("Book ID\r\n");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBookId.setBounds(79, 35, 126, 34);
		contentPane.add(lblBookId);
		
		bokkidz = new JTextField();
		bokkidz.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER || key==KeyEvent.VK_BACK_SPACE) {
			        Toolkit.getDefaultToolkit().beep(); 
			       // System.out.println("ENTER pressed");
			        }else {
			        	   char c=e.getKeyChar();
							if(!(Character.isDigit(c))) {
								
								e.consume();//not typing
								JOptionPane.showMessageDialog(null, "Please Enter Valid ID", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
								
								
							}
			        }
				
				
			}
		});
		
		JButton btnDemo = new JButton("Demo");
		btnDemo.setBackground(new Color(240, 240, 240));
		btnDemo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDemo.setIcon(new ImageIcon(AddBook.class.getResource("/images/demo.png")));
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bokkidz.grabFocus();
				booknamez.setText("Sample Book");
				isbnz.setText("4554654");
				authornamez.setText("Sample Auther");
				publishername.setText("Sample Publisher");
				copiez.setText("1");
			}
		});
		btnDemo.setBounds(770, 179, 253, 66);
		contentPane.add(btnDemo);
		bokkidz.setHorizontalAlignment(SwingConstants.CENTER);
		bokkidz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bokkidz.setColumns(10);
		bokkidz.setBounds(372, 26, 317, 58);
		contentPane.add(bokkidz);
		
		JLabel lblAddBook = new JLabel("--Add Book--");
		lblAddBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBook.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAddBook.setBounds(660, 80, 432, 86);
		contentPane.add(lblAddBook);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AddBook.class.getResource("/images/img.png")));
		lblNewLabel_2.setBounds(0, 0, 1220, 875);
		contentPane.add(lblNewLabel_2);
		
	}
}
