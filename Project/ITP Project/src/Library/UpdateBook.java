package Library;

import java.awt.BorderLayout;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBook frame = new UpdateBook();
					frame.setTitle("Update Book details");
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
	public UpdateBook() {
		
		UpdateBook.this.setTitle("Update Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Book Name\r\n");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(27, 141, 126, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ISBN\r\n");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(27, 213, 120, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Author Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(27, 288, 161, 34);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Publisher Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(27, 362, 196, 58);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
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
							
							// Enter ekata Hadanna One
						}
			        }
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(270, 370, 323, 48);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			
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
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(270, 212, 323, 42);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			
			
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
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(270, 287, 323, 43);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(270, 140, 323, 42);
		contentPane.add(textField_4);
		
		JButton btnUpdatedata = new JButton("Update Book");
		btnUpdatedata.setIcon(new ImageIcon(UpdateBook.class.getResource("/images/update.png")));
		btnUpdatedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
try {
					
					
					//System.out.print(jtable1.getSelectedRow());
				
					
					
					String bookid = "B"+textField_6.getText();
					String bookname = textField_4.getText();
					String isbn = textField_2.getText();
					String auname = textField_3.getText();
					String pubname = textField.getText();
					String quantity = textField_5.getText();
					
					if(bookname.equals("") || isbn.equals("") || auname.equals("") || pubname.equals("") || quantity.equals("") || bookid.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill All Feilds To Update","Error",JOptionPane.ERROR_MESSAGE);
					}else {
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
//            		System.out.print("Book ID--"+bookid);
//            		System.out.print("Book qty--"+quantity);

            		            		String sqlupd = "update book set name='"+bookname+"',ISBN='"+isbn+"',autherName='"+auname+"',publisherName='"+pubname+"',noOfCopies='"+Integer.parseInt(quantity)+"' where bookID='"+textField_6.getText().toString()+"'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
					
            		JOptionPane.showMessageDialog(null, "Data Updated");
            		UpdateBook.this.dispose();
            		new Searchbooks().setVisible(true);
					}
				} catch (Exception e) {
				e.printStackTrace();
				}
				
			}
		});
		btnUpdatedata.setToolTipText("Save Data");
		btnUpdatedata.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdatedata.setContentAreaFilled(false);
		btnUpdatedata.setBounds(725, 246, 263, 76);
		contentPane.add(btnUpdatedata);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateBook.this.dispose();
				new Searchbooks().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(UpdateBook.class.getResource("/images/back.png")));
		button_1.setToolTipText("Save Data");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(725, 382, 263, 76);
		contentPane.add(button_1);
		
		JLabel label_5 = new JLabel(" Libray Management System");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_5.setBounds(638, 32, 432, 86);
		contentPane.add(label_5);
		
		JLabel label_7 = new JLabel("B");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_7.setBounds(224, 48, 56, 58);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Book ID\r\n");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_8.setBounds(33, 58, 126, 34);
		contentPane.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c=arg0.getKeyChar();
				System.out.println(c);
				
				if(!(Character.isDigit(c))) {
					
					arg0.consume();//not typing
					JOptionPane.showMessageDialog(null, "Please Enter Valid ID", "Error", JOptionPane.ERROR_MESSAGE);//get message dioglog
					
					
				}
			}
		});
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String bookidz = "B"+textField_6.getText();
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt2 = null;
					
					
					ResultSet rs2 = null;
					
					
					// Establish the connection.
	        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            
	            		// Create and execute an SQL statement that returns some data.
	            		
	            		String sql2 = "select * from book where bookID='"+bookidz+"'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);	
	            		if(rs2.next()) {
	            			
	            			textField_4.setText(rs2.getString("name"));
	            			textField_2.setText(rs2.getString("ISBN"));
	            			textField_3.setText(rs2.getString("autherName"));
	            			textField.setText(rs2.getString("publisherName"));
	            			            			textField_5.setText(rs2.getString("noOfCopies"));
	            		}else {
	            			JOptionPane.showMessageDialog(null, "Invalid Book ID..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			textField_4.setText("");
	            			textField_2.setText("");
	            			textField_3.setText("");
	            			textField.setText("");
	            			            			textField_5.setText("");
	            			            			
	            		}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(276, 50, 317, 58);
		contentPane.add(textField_6);
		
		JLabel lblupdatebook = new JLabel("--Update Book--");
		lblupdatebook.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdatebook.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblupdatebook.setBounds(626, 99, 432, 86);
		contentPane.add(lblupdatebook);
		
		JLabel label_4 = new JLabel("No Of Copies");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBounds(27, 460, 168, 48);
		contentPane.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
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
		
		
		
		
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(270, 463, 323, 48);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateBook.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 0, 1082, 603);
		contentPane.add(lblNewLabel);
	}

	public UpdateBook(String bookid) {
		this();
		try {
			
			String bookidz = bookid;
			textField_6.setText(bookidz);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
					"databaseName=ITP_Project;integratedSecurity=true;";

			Connection con = null;
			Statement stmt2 = null;
			
			
			ResultSet rs2 = null;
			
			
			// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		con = DriverManager.getConnection(connectionUrl);
        
        		// Create and execute an SQL statement that returns some data.
        		
        		String sql2 = "select * from book where bookID='"+bookidz+"'";
        		stmt2 = con.createStatement();
        		rs2=stmt2.executeQuery(sql2);	
        		if(rs2.next()) {
        			
        			textField_4.setText(rs2.getString("name"));
        			textField_2.setText(rs2.getString("ISBN"));
        			textField_3.setText(rs2.getString("autherName"));
        			textField.setText(rs2.getString("publisherName"));
        			            			textField_5.setText(rs2.getString("noOfCopies"));
        		}else {
        			JOptionPane.showMessageDialog(null, "Invalid Book ID..!", "Error", JOptionPane.ERROR_MESSAGE);
        			textField_4.setText("");
        			textField_2.setText("");
        			textField_3.setText("");
        			textField.setText("");
        			            			textField_5.setText("");
        			            			
        		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
