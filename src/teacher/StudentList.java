package teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Lesson;
import menu.Menu;
import student.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList frame = new StudentList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private Student getStudentInfo(int userId) {
		Student student = new Student();
		// sql cagÄ±rma user bilgileri getirme
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			Statement stmt = con.createStatement();
			String sql = "Select user_id,name,surname from users where user_id=" + userId + "";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				student.setUser_id(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setSurname(rs.getString(3));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid ..");
			}
			con.close();
			return student;
		} catch (Exception e) {
			System.out.println(e);
			return student;
		}
	}

	/**
	 * Create the frame.
	 */
	private ArrayList<Student> getStudentList() {

		ArrayList<Student> studentlist = new ArrayList<Student>();
		// sql cagÄ±rma user bilgileri getirme
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");// ARRAY LÝST OLUÞTURDUM users Tablosunda bulunan userid name surname getiriyor
			Statement stmt = con.createStatement();
			String sql = "Select user_id,name,surname from users";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setUser_id(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setSurname(rs.getString(3));
				studentlist.add(student);
			}
			con.close();
			return studentlist;
		} catch (Exception e) {
			System.out.println(e);
			return studentlist;
		}
	}

	public StudentList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1328, 661);
		ArrayList<Student> studentlist = getStudentList();

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBounds(168, 54, 820, 316);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 820, 431);
		panel.add(scrollPane);

		String[] columnNames = { "ID", "NAME", "SURNAME" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		table = new JTable(model);
		
		for (Student student : studentlist) {
			model.addRow(new Object[] { student.getUser_id(), student.getName(), student.getSurname() });
		}
		

		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		           System.out.println(studentlist.get(row).getUser_id());
		           try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
						Statement stmt =con.createStatement();
						String sql=("Select student_id,First_Lesson,Second_Lesson,Third_Lesson,Fourth_Lesson,Fifth_Lesson,Sixth_Lesson,Seventh_Lesson from addingLesson where student_id="+studentlist.get(row).getUser_id());
		
						ResultSet rs= stmt.executeQuery(sql);// TIKLADIÐIMIZ ID ÖÐRENCÝNÝN SEÇTÝÐNÝ DERSLERÝ GETÝRÝYOR 
						if(rs.next()) {
							int userId = rs.getInt(1);
							//Student student = new Student();
							Student student = getStudentInfo(userId);//ÖÐRENCÝ BÝLGÝLERÝNÝ DOLDURUYOR 
							Lesson menu = new Lesson(student);
							menu.lessonScreen(student);
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid .."); }
						con.close();
					}catch (Exception e) {
						System.out.println(e);
						
					}
					
					
		        }
		    }
		});

	}
}