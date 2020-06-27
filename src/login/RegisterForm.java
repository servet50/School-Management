package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Checkbox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JTextField user1;
	private JTextField name1;
	private JTextField surname1;
	private JTextField phone1;
	private JTextField faculty1;
	private JTextField depart1;
	private JPasswordField pass2;
	private JTextField date1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
	
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 708);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 38, 92, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 74, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surname");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(12, 118, 68, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(12, 171, 80, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Birth date");
		lblNewLabel_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(12, 222, 92, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(12, 271, 56, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setBounds(12, 315, 56, 16);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Phone number");
		lblNewLabel_1_6.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(12, 325, 80, 16);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Faculty");
		lblNewLabel_1_7.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(12, 382, 68, 16);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("Department");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 438, 108, 16);
		contentPane.add(lblNewLabel_2);
		
		user1 = new JTextField();
		user1.setBounds(194, 38, 116, 22);
		contentPane.add(user1);
		user1.setColumns(10);
		
		name1 = new JTextField();
		name1.setColumns(10);
		name1.setBounds(194, 72, 116, 22);
		contentPane.add(name1);
		
		surname1 = new JTextField();
		surname1.setColumns(10);
		surname1.setBounds(194, 116, 116, 22);
		contentPane.add(surname1);
		
		phone1 = new JTextField();
		phone1.setColumns(10);
		phone1.setBounds(194, 323, 116, 22);
		contentPane.add(phone1);
		
		faculty1 = new JTextField();
		faculty1.setColumns(10);
		faculty1.setBounds(194, 380, 116, 22);
		contentPane.add(faculty1);
		
		depart1 = new JTextField();
		depart1.setColumns(10);
		depart1.setBounds(194, 436, 116, 22);
		contentPane.add(depart1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(194, 179, 116, 22);
		contentPane.add(pass2);
		
		Checkbox box1 = new Checkbox("Man");
		box1.setBounds(195, 271, 56, 24);
		contentPane.add(box1);
		
		Checkbox box2 = new Checkbox("Women");
		box2.setBounds(257, 271, 56, 24);
		contentPane.add(box2);
		
		date1 = new JTextField();
		date1.setBounds(194, 220, 116, 22);
		contentPane.add(date1);
		date1.setColumns(10);
		
		JButton record1 = new JButton("Record");
		record1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement ps=conn.prepareStatement("insert into users(user_id,name,surname,password,date,phone_number,faculty,department) values (?,?,?,?,?,?,?,?);");
					ps.setString(1, user1.getText());
					ps.setString(2, name1.getText());
					ps.setString(3, surname1.getText());
					ps.setString(4, pass2.getText());
					ps.setString(5, date1.getText());   // GÝRDÝÐÝMÝZ BÝLGÝLERÝ DATABASE YÜKLÜYOR
					ps.setString(6, phone1.getText());
					ps.setString(7, faculty1.getText());
					ps.setString(8, depart1.getText());
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("Record done successfully");
						createUser(name1.getText(), pass2.getText(),user1.getText());
					}else {
						System.out.println("Invalid record");
					}
				}catch (Exception e1) {
					System.out.println(e1);
					
				}
			}
		});
		record1.setBackground(Color.BLUE);
		record1.setBounds(213, 555, 97, 25);
		contentPane.add(record1);
		
		JButton cancel1 = new JButton("Cancel");
		cancel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Student Result System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		cancel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user1.setText(null);
				name1.setText(null);
				surname1.setText(null);
				pass2.setText(null);
				phone1.setText(null);
				depart1.setText(null);
				faculty1.setText(null);
				date1.setText(null);
				
				
			
			}
		});
		cancel1.setBackground(Color.RED);
		cancel1.setBounds(76, 555, 97, 25);
		contentPane.add(cancel1);
	}
	
	private void createUser(String userName, String password, String user_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			PreparedStatement ps=conn.prepareStatement("insert into dblogin(name,password,user_id) values (?,?,?);");
			
			ps.setString(1, userName);
			
			ps.setString(2, password); 
			ps.setString(3, user_id);  // BU KODLAR ÝSE ID NAME SURNAME bilgileriniii dblogin database ekliyor
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Record done successfully");
			}else {
				System.out.println("Invalid record");
			}
		}catch (Exception e1) {
			System.out.println(e1);
			
		}
		
	}
}
