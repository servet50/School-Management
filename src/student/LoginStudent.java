package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.RegisterForm;
import menu.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginStudent extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JPasswordField pass1;
	private JTextField jLabelRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
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
	
	public void loginScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
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
	
	private Student getStudentInfo(int userId) {
		Student student = new Student();
		//sql cagÄ±rma user bilgileri getirme
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");  
			Statement stmt =con.createStatement();
			String sql="Select user_id,name,surname from users where user_id="+userId+ "";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				student.setUser_id(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setSurname(rs.getString(3));
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid .."); }
			con.close();
			return student;
		}catch (Exception e) {System.out.println(e);
			return student;
		}
	}
	
	public LoginStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 414);
		centerFrame();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 17));
		lblNewLabel.setBounds(40, 71, 105, 16);
		contentPane.add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setBounds(265, 67, 139, 22);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 17));
		lblNewLabel_1.setBounds(40, 105, 105, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btn1 = new JButton("Login");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root",""); 
					
					Statement stmt =con.createStatement();
					String sql="Select user_id from dblogin where name='"+text1.getText()+ "' and password='"+String.valueOf(pass1.getPassword())+"'";
					ResultSet rs= stmt.executeQuery(sql);
					if(rs.next()) {
						int userId = rs.getInt(1);
						Student student = getStudentInfo(userId); 
						Menu menu = new Menu(student);
						menu.menuScreen(student);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid .."); }
					con.close();
				}catch (Exception e) {
					System.out.println(e);
					
				}
				
				
			}
		});
		btn1.setBackground(Color.BLUE);
		btn1.setFont(new Font("Stencil", Font.BOLD, 14));
		btn1.setForeground(Color.BLACK);
		btn1.setBounds(274, 192, 153, 55);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Cancel");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text1.setText(null);
				pass1.setText(null);
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Student Result System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		btn2.setBackground(Color.RED);
		btn2.setFont(new Font("Stencil", Font.BOLD, 14));
		btn2.setForeground(Color.BLACK);
		btn2.setBounds(88, 192, 153, 55);
		contentPane.add(btn2);
		
		JLabel lblNewLabel_2 = new JLabel("STUDENT LOGIN");
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(209, 24, 139, 16);
		contentPane.add(lblNewLabel_2);
		
		pass1 = new JPasswordField();
		pass1.setBounds(265, 101, 139, 22);
		contentPane.add(pass1);
		
		jLabelRegister = new JTextField("Click here to create a new account");
		jLabelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegisterForm rgf = new RegisterForm();
				rgf.setVisible(true);
				rgf.pack();
				rgf.setLocationRelativeTo(null);
				rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		jLabelRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabelRegister.setBackground(Color.GRAY);
		jLabelRegister.setForeground(Color.PINK);
		jLabelRegister.setBounds(134, 277, 249, 29);
		contentPane.add(jLabelRegister);
	}
}
