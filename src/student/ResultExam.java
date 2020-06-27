package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Lesson;
import menu.Menu;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultExam extends JFrame {

	private JPanel contentPane;
	private JTextField lesson1;
	private JTextField lesson2;
	private JTextField lesson3;
	private JTextField lesson4;
	private JTextField lesson5;
	private JTextField lesson6;
	private JTextField lesson7;
	private JTextField studentResultt;
	private JTextField nameResult;
	private JTextField surnameResult;
	private JTextField result1;
	private JTextField result2;
	private JTextField result3;
	private JTextField result4;
	private JTextField result5;
	private JTextField result6;
	private JTextField result7;
	private static Student student;
	private JButton btnNewButton;
	private JButton btnBack;
	//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultExam frame = new ResultExam(student);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void ResultScreen(Student student) {
		ResultExam.student = student;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultExam frame = new ResultExam(student);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Grade getGradeInfo(Student student) {
		//Student student = new Student();
		//sql cagÄ±rma user bilgileri getirme+
		Grade grade = new Grade();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			Statement stmt =con.createStatement();
			String sql="Select student_id,First_Lesson,Second_Lesson,Third_Lesson,Fourth_Lesson,Fifth_Lesson,Sixth_Lesson,Seventh_Lesson from addinglesson where student_id="+student.getUser_id()+ "";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				
				student.setStudent_ID(rs.getString(1));                                                                                                                   
			
				grade.setLesson1(rs.getString(2));
				grade.setLesson2(rs.getString(3)); 
				grade.setLesson3(rs.getString(4));	
				grade.setLesson4(rs.getString(5));
				grade.setLesson5(rs.getString(6));
				grade.setLesson6(rs.getString(7));
				grade.setLesson7(rs.getString(8));
			
			}
				
				
			else {
				JOptionPane.showMessageDialog(null, "Invalid .."); }
			con.close();
			return grade;
		}catch (Exception e) {System.out.println(e);
			return grade;
		}
	}
	private StudentResult getStudentResultInfo(Student student) {
		//Student student = new Student();
		//sql cagÄ±rma user bilgileri getirme
		StudentResult studentresult1 = new StudentResult();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			Statement stmt =con.createStatement();
			String sql="Select student_id,computer,software,java,operating,virtu,biometric,intership from lesson where student_id="+student.getUser_id()+ "";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				
				//studentresult.setStudent_ID(rs.getInt(1));
				
				studentresult1.setResult1(rs.getInt(2));
				studentresult1.setResult2(rs.getInt(3)); 
				studentresult1.setResult3(rs.getInt(4));
				studentresult1.setResult4(rs.getInt(5));
				studentresult1.setResult5(rs.getInt(6));
				studentresult1.setResult6(rs.getInt(7));
				studentresult1.setResult7(rs.getInt(8));

			}
				
				
			else {
				JOptionPane.showMessageDialog(null, "Invalid .."); }
			con.close();
			return studentresult1;
		}catch (Exception e) {System.out.println(e);
			return studentresult1;
		}
	}

	/**
	 * Create the frame.
	 */
	public ResultExam(Student student) {
		setBackground(SystemColor.info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grade grade =getGradeInfo(student);
		StudentResult studentresult1=getStudentResultInfo(student);
		setBounds(100, 100, 763, 629);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 64, 102, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(SystemColor.textHighlight);
		lblName.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblName.setBounds(44, 117, 102, 30);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("SURNAME");
		lblSurname.setForeground(SystemColor.textHighlight);
		lblSurname.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSurname.setBounds(44, 176, 102, 30);
		contentPane.add(lblSurname);
		
		lesson1 = new JTextField();
		lesson1.setEditable(false);
		lesson1.setBounds(337, 69, 134, 22);
		contentPane.add(lesson1);
		lesson1.setColumns(10);
		lesson1.setText(grade.getLesson1());
		
		lesson2 = new JTextField();
		lesson2.setEditable(false);
		lesson2.setColumns(10);
		lesson2.setBounds(337, 117, 134, 22);
		contentPane.add(lesson2);
		lesson2.setText(grade.getLesson2());
		
		lesson3 = new JTextField();
		lesson3.setEditable(false);
		lesson3.setColumns(10);
		lesson3.setBounds(337, 176, 134, 22);
		contentPane.add(lesson3);
		lesson3.setText(grade.getLesson3());
		
		lesson4 = new JTextField();
		lesson4.setEditable(false);
		lesson4.setColumns(10);
		lesson4.setBounds(337, 231, 134, 22);
		contentPane.add(lesson4);
		lesson4.setText(grade.getLesson4());
		
		lesson5 = new JTextField();
		lesson5.setEditable(false);
		lesson5.setColumns(10);
		lesson5.setBounds(337, 288, 134, 22);
		contentPane.add(lesson5);
		lesson5.setText(grade.getLesson5());
		
		lesson6 = new JTextField();
		lesson6.setEditable(false);
		lesson6.setColumns(10);
		lesson6.setBounds(337, 353, 134, 22);
		contentPane.add(lesson6);
		lesson6.setText(grade.getLesson6());
		
		lesson7 = new JTextField();
		lesson7.setEditable(false);
		lesson7.setColumns(10);
		lesson7.setBounds(337, 417, 134, 22);
		contentPane.add(lesson7);
		lesson7.setText(grade.getLesson7());
		
		JLabel lblLessons = new JLabel("LESSONS");
		lblLessons.setForeground(SystemColor.textHighlight);
		lblLessons.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblLessons.setBounds(353, 21, 102, 30);
		contentPane.add(lblLessons);
		
		JLabel lblResult = new JLabel("RESULT");
		lblResult.setForeground(SystemColor.textHighlight);
		lblResult.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblResult.setBounds(580, 26, 102, 30);
		contentPane.add(lblResult);
		
		studentResultt = new JTextField();
		studentResultt.setEditable(false);
		studentResultt.setBounds(158, 69, 116, 22);
		contentPane.add(studentResultt);
		studentResultt.setColumns(10);
	
		studentResultt.setText(Integer.toString(student.getUser_id()));
		
		nameResult = new JTextField();
		nameResult.setEditable(false);
		nameResult.setColumns(10);
		nameResult.setBounds(158, 122, 116, 22);
		contentPane.add(nameResult);
		nameResult.setText(student.getName());
		
		surnameResult = new JTextField();
		surnameResult.setEditable(false);
		surnameResult.setColumns(10);
		surnameResult.setBounds(158, 181, 116, 22);
		contentPane.add(surnameResult);
		surnameResult.setText(student.getSurname());
		
		
		result1 = new JTextField();
		result1.setEditable(false);
		result1.setColumns(10);
		result1.setBounds(561, 69, 116, 22);
		contentPane.add(result1);
	
		result1.setText(Integer.toString(studentresult1.getResult1()));
		
		result2 = new JTextField();
		result2.setEditable(false);
		result2.setColumns(10);
		result2.setBounds(561, 122, 116, 22);
		contentPane.add(result2);
		result2.setText(Integer.toString(studentresult1.getResult2()));
		
		result3 = new JTextField();
		result3.setEditable(false);
		result3.setColumns(10);
		result3.setBounds(561, 181, 116, 22);
		contentPane.add(result3);
		result3.setText(Integer.toString(studentresult1.getResult3()));
		
		result4 = new JTextField();
		result4.setEditable(false);
		result4.setColumns(10);
		result4.setBounds(561, 231, 116, 22);
		contentPane.add(result4);
		result4.setText(Integer.toString(studentresult1.getResult4()));
		
		result5 = new JTextField();
		result5.setEditable(false);
		result5.setColumns(10);
		result5.setBounds(561, 288, 116, 22);
		contentPane.add(result5);
		result5.setText(Integer.toString(studentresult1.getResult5()));
		
		result6 = new JTextField();
		result6.setEditable(false);
		result6.setColumns(10);
		result6.setBounds(561, 353, 116, 22);
		contentPane.add(result6);
		result6.setText(Integer.toString(studentresult1.getResult6()));
		
		result7 = new JTextField();
		result7.setEditable(false);
		result7.setColumns(10);
		result7.setBounds(561, 417, 116, 22);
		contentPane.add(result7);
		result7.setText(Integer.toString(studentresult1.getResult7()));
		
		btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Student Result System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(541, 487, 121, 63);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu(student);
				menu.menuScreen(student);
				menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(337, 487, 121, 63);
		contentPane.add(btnBack);
	}
	
}
