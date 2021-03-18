package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBurrowDate;
	private JTextField txtDueDate;
	private JTextField txtDatesDue;
	private JTextField txtCostIs;
	private JTextField txtMemberId;
	private JLabel lblNewLabel;
	JFrame hh;

	static ReturnBook yy;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setTitle("Return Book");
					frame.setVisible(true);
					//frame.setUndecorated(true);
					
					yy = new ReturnBook();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReturnBook() {
		
		ReturnBook.this.setTitle("Return Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextField txtpnTypeBookName = new JTextField();
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 30));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				String memberid = list.getSelectedValue().toString();
				
try {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Statement stmt2 = null;
					Statement stmt3 = null;
					Statement stmt4 = null;
					Statement stmt5 = null;
					Statement stmt6 = null;
					
					ResultSet rs = null;
					ResultSet rs2 = null;
					ResultSet rs3 = null;
					ResultSet rs4 = null;
					ResultSet rs5 = null;
					ResultSet rs6 = null;
					ResultSet rs7 = null;
					
					// Establish the connection.
	        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            
	            		// Create and execute an SQL statement that returns some data.
	            		
	            		String sql2 = "select * from rental where bookID='"+txtpnTypeBookName.getText()+"' and memberID='"+memberid+"'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);	
	            		Vector vv = new Vector();
	            		if (rs2.next()) {
	            			
	            	//		System.out.print("if inside");
							
	            		String memberidfromdb = rs2.getString(2);
	            		String memberburrowdate = rs2.getString(3);
	            		String memberduedate = rs2.getString(5);
	            		
//	            		System.out.print("member id--"+memberidfromdb);
//	            		System.out.print("member burrow date--"+memberburrowdate);
//	            		System.out.print("member due date--"+memberduedate);
	            		
	            		txtBurrowDate.setText(memberburrowdate);
	            		txtMemberId.setText(memberidfromdb);
	            		txtDueDate.setText(memberduedate);
	            		
	            		////date difference code////////////////////////
	            		 Date date = new Date();  
	            		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
	            		    String strDate= formatter.format(date);  
	            		    
	            		
	            		    //long diff = dateObj2.getTime() - dateObj1.getTime();
	            		    String burrowdatearr[] = memberburrowdate.split("/");
	            		    String burrowyear = burrowdatearr[0];
	            		    String burrowmonth = burrowdatearr[1];
	            		    String burrowdate = burrowdatearr[2];
	            		    
	            		    
	            		    String todayarra[] = strDate.split("/");
	            		    String todayye = todayarra[0];
	            		    String todaymonth = todayarra[1];
	            		    String todaydate = todayarra[2];
	            		    
	            		    Calendar start = Calendar.getInstance();
	            		    Calendar end = Calendar.getInstance();
	            		    start.set(Integer.parseInt(todayye), Integer.parseInt(todaymonth), Integer.parseInt(todaydate));
	            		    end.set(Integer.parseInt(burrowyear),Integer.parseInt(burrowmonth),Integer.parseInt(burrowdate));
	            		    
	            		    Date startDate = start.getTime();
	            		    Date endDate = end.getTime();
	            		    long startTime = startDate.getTime();
	            		    long endTime = endDate.getTime();
	            		    long diffTime = startTime - endTime;
	            		    long diffDays = diffTime / (1000 * 60 * 60 * 24);
	            		    
	            		    
	            		    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	            		    
	            		    //calculation
	            		    long datesfor = diffDays -14;
	            		    //System.out.print("Date wadi gana"+datesfor);
	            		    
	            		    
	            		    if(datesfor > 0) {
	            		    	txtDatesDue.setText(""+datesfor+" Days Exceeded");
	            		    	JOptionPane.showMessageDialog(rootPane, "You Have Exceeded The Duration...You Have been Fined", "Warning", JOptionPane.WARNING_MESSAGE);
	            		    	long costz = datesfor *20;
	            		    	int co =(int)costz;
	            		    	txtCostIs.setText("Fine Is RS "+costz);
	            		    	
	            		    	
	            		   
	            		    	
	            		    	
	            		    	
	            		    	String sqlupd = "update rental set fine='"+co+"',lateDays='"+datesfor+"',returnDate='"+strDate+"',statuz='Done' where bookID='"+txtpnTypeBookName.getText()+"' and memberID='"+memberidfromdb+"' and statuz='Pending'";
	    	            		stmt4 = con.createStatement();
	    	            		stmt4.executeUpdate(sqlupd);
	    	            		
	    	            		String updbook = "update book set noOfCopies=noOfCopies+1 where bookID='"+txtpnTypeBookName.getText()+"'";
	    	            		stmt5 = con.createStatement();
	    	            		stmt5.executeUpdate(updbook);
	    	            		
	            		    	JOptionPane.showMessageDialog(rootPane, "Return Sucess", "Done", JOptionPane.INFORMATION_MESSAGE);
	            		    	ReturnBook.this.dispose();
	            		    	new ReturnBook().setVisible(true);
	    	            		
	            		    	
	    	            		
	            		    	
	            		    	
	            		    }else {
	            		    	txtDatesDue.setText(""+datesfor+" Days Left To Return");
	            		    	int fines = 0;
	            		    	String latedays ="0";
	            		    	String sqlupd = "update rental set fine='"+fines+"',lateDays='"+latedays+"',returnDate='"+strDate+"',statuz='Done' where bookID='"+txtpnTypeBookName.getText()+"' and memberID='"+memberidfromdb+"' and statuz='Pending'";
	    	            		stmt4 = con.createStatement();
	    	            		stmt4.executeUpdate(sqlupd);
	    	            		
	    	            		String updbook = "update book set noOfCopies=noOfCopies+1 where bookID='"+txtpnTypeBookName.getText()+"'";
	    	            		stmt5 = con.createStatement();
	    	            		stmt5.executeUpdate(updbook);
	            		    	
	            		    	
	            		    	
	            		    	
	            		    	JOptionPane.showMessageDialog(rootPane, "Return Sucess", "Done", JOptionPane.INFORMATION_MESSAGE);
	            		    	ReturnBook.this.dispose();
	            		    	new ReturnBook().setVisible(true);
	            		    	
	            		    }
	            			
						}
	            		
	            		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
				
				
				
			}
		});
		list.setBounds(228, 175, 813, 119);
		contentPane.add(list);
		
		txtpnTypeBookName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Statement stmt2 = null;
					Statement stmt3 = null;
					
					ResultSet rs = null;
					ResultSet rs2 = null;
					ResultSet rs3 = null;
					
					// Establish the connection.
	        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            		con = DriverManager.getConnection(connectionUrl);
	            
	            		// Create and execute an SQL statement that returns some data.
	            		
	            		String sql2 = "select * from rental where bookID like'"+txtpnTypeBookName.getText()+"%' and statuz='Pending'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);	
	            		Vector vv = new Vector();
	            		while (rs2.next()) {
							
	            			vv.add(rs2.getString(2));// column name eka thamai 2 
	            			list.setListData(vv);// member id eka aragena list ekata e member id eka set karanwa
	            			
	            			
	            			
						}
	            		
	            		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
				
			}
		});
		txtpnTypeBookName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtpnTypeBookName.setText("");
			}
		});
		txtpnTypeBookName.setBounds(458, 92, 309, 59);
		txtpnTypeBookName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnTypeBookName.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnTypeBookName.setText("Type Book Id");
		contentPane.add(txtpnTypeBookName);
		
		JLabel label = new JLabel("");
		label.setBounds(367, 89, 64, 73);
		label.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/open-book.png")));
		contentPane.add(label);
		
		
		
		txtBurrowDate = new JTextField();
		txtBurrowDate.setEditable(false);
		txtBurrowDate.setText("Burrow Date");
		txtBurrowDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtBurrowDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBurrowDate.setBounds(228, 404, 309, 59);
		contentPane.add(txtBurrowDate);
		
		txtDueDate = new JTextField();
		txtDueDate.setEditable(false);
		txtDueDate.setText("Due Date");
		txtDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDueDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDueDate.setBounds(640, 404, 394, 59);
		contentPane.add(txtDueDate);
		
		txtDatesDue = new JTextField();
		txtDatesDue.setEditable(false);
		txtDatesDue.setForeground(Color.RED);
		txtDatesDue.setText("0 Dates Exceeded");
		txtDatesDue.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatesDue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDatesDue.setBounds(228, 509, 813, 59);
		contentPane.add(txtDatesDue);
		txtDatesDue.setColumns(10);
		
		txtCostIs = new JTextField();
		txtCostIs.setText("Cost is Rs 00.00 ");
		txtCostIs.setHorizontalAlignment(SwingConstants.CENTER);
		txtCostIs.setForeground(Color.RED);
		txtCostIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCostIs.setEditable(false);
		txtCostIs.setColumns(10);
		txtCostIs.setBounds(228, 581, 813, 59);
		contentPane.add(txtCostIs);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReturnBook.this.dispose();
				new L_Main().setVisible(true);
			}
		});
	
		button_1.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/back.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(1056, 583, 170, 51);
		contentPane.add(button_1);
		
		txtMemberId = new JTextField();
		txtMemberId.setText("Member Id");
		txtMemberId.setHorizontalAlignment(SwingConstants.CENTER);
		txtMemberId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMemberId.setEditable(false);
		txtMemberId.setBounds(228, 313, 813, 59);
		contentPane.add(txtMemberId);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/img.png")));
		lblNewLabel.setBounds(0, 13, 1232, 840);
		contentPane.add(lblNewLabel);
	}
}
