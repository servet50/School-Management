package teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import login.Lesson;
import menu.Menu;
import student.LoginStudent;
import student.Student;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TeacherManager extends JFrame {

	private JPanel contentPane;
	private JTextField teacherTxt;
	private JPasswordField teacherPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherManager frame = new TeacherManager();
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
	public TeacherManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 491);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(39, 139, 150, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(SystemColor.textHighlight);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPassword.setBounds(39, 207, 150, 35);
		contentPane.add(lblPassword);
		
		JLabel lblLognTeacher = new JLabel("LOGIN TEACHER");
		lblLognTeacher.setForeground(Color.RED);
		lblLognTeacher.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblLognTeacher.setBounds(221, 27, 229, 35);
		contentPane.add(lblLognTeacher);
		
		teacherTxt = new JTextField();
		teacherTxt.setBounds(221, 147, 184, 22);
		contentPane.add(teacherTxt);
		teacherTxt.setColumns(10);
		
		teacherPass = new JPasswordField();
		teacherPass.setBounds(221, 207, 184, 22);
		contentPane.add(teacherPass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					Statement stmt =con.createStatement();
					String sql="Select teacher_id from teacherlogin where username='"+teacherTxt.getText()+ "' and password='"+String.valueOf(teacherPass.getPassword())+"'";
					ResultSet rs= stmt.executeQuery(sql);
					if(rs.next()) {
						Student student = new Student();
						StudentList lesson = new StudentList();
						//lesson.lessonScreen(student);
					lesson.setVisible(true);
						//lesson.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						this.dispose();
					
					}



					
					else {
						JOptionPane.showMessageDialog(null, "Invalid .."); }
					con.close();
				}catch (Exception ex) {
					System.out.println(ex);
					
				}
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
			

			private Student getStudentInfo(int userId) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(308, 315, 100, 43);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnCancel.setBounds(121, 315, 109, 43);
		contentPane.add(btnCancel);
	}
}
