package login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import menu.Menu;
import student.Student;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

public class AddingLesson extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTextField studentId;
	private JTextField nameTxt;
	private JComboBox<?> comboComputer;
	private JComboBox comboSoftware;
	private JComboBox comboJava;
	private JComboBox comboOperating;
	private JComboBox comboVirtu;
	private JComboBox comboBiometric;
	private JComboBox comboIntership;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField surnameTxt;
	private JLabel lblNewLabel_3;
	private JButton btnDelete;
	private Student student;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddingLesson frame = new AddingLesson();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addLessonScreen(Student student) {
		this.student = student;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingLesson frame = new AddingLesson(student);
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

	public AddingLesson(Student student) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 612);
		centerFrame();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(499, 25, 723, 353);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { 
				"Student ID", "First Lesson", "Second Lesson", "Third Lesson", "Fourth Lesson", "Fifth Lesson", "Sixth Lesson", "Seventh Lesson"
			}
		));
		scrollPane.setColumnHeaderView(table1);
		
		studentId = new JTextField();
		studentId.setEditable(false);
		studentId.setBounds(145, 54, 116, 22);
		contentPane.add(studentId);
		studentId.setColumns(10);
		studentId.setText(Integer.toString(student.getUser_id()));
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setBounds(145, 103, 116, 22);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		nameTxt.setText(student.getName());
		
		JButton addingLesson = new JButton("Adding Lesson");
		addingLesson.setForeground(SystemColor.textHighlight);
		addingLesson.setFont(new Font("Arial Black", Font.BOLD, 15));
		addingLesson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement ps=conn.prepareStatement("insert into addinglesson(student_id,First_Lesson,Second_Lesson,Third_Lesson,Fourth_Lesson,Fifth_Lesson,Sixth_Lesson,Seventh_Lesson) values (?,?,?,?,?,?,?,?);");
					
					ps.setString(1, studentId.getText());
					ps.setString(2, comboComputer.getSelectedItem().toString());
					ps.setString(3, comboSoftware.getSelectedItem().toString()); // BURDA COMBOBOX ta seçtiðimiz dersleri database veri aktarýyor..
					ps.setString(4, comboJava.getSelectedItem().toString());
					ps.setString(5, comboOperating.getSelectedItem().toString());
					ps.setString(6, comboVirtu.getSelectedItem().toString());
					ps.setString(7, comboBiometric.getSelectedItem().toString());
					ps.setString(8, comboIntership.getSelectedItem().toString());
			
					
					int x = ps.executeUpdate();
				
					
					if(x > 0) {
						System.out.println("Record done successfully");
						
					}else {
						System.out.println("Invalid record");
					}
				}catch (Exception e1) {
					System.out.println(e1);
					
				}
				DefaultTableModel model = (DefaultTableModel)table1.getModel(); // SECTÝÐÝMÝZ DERSLERÝ TABLOYA YAZDIRIYOR YANDAKÝ TABLOYA
				model.addRow(new Object[] {studentId.getText(),
						comboComputer.getSelectedItem(),comboSoftware.getSelectedItem(),comboJava.getSelectedItem(),
						comboOperating.getSelectedItem(),comboVirtu.getSelectedItem(),comboBiometric.getSelectedItem(),comboIntership.getSelectedItem()});
			
				
			}
		});
		addingLesson.setBounds(96, 445, 227, 38);
		contentPane.add(addingLesson);
		
		comboComputer = new JComboBox();
		comboComputer.setEditable(true);
		comboComputer.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboComputer.setBounds(306, 36, 165, 22);
		contentPane.add(comboComputer);
		
		comboSoftware = new JComboBox();
		comboSoftware.setEditable(true);
		comboSoftware.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboSoftware.setBounds(306, 86, 165, 22);
		contentPane.add(comboSoftware);
		
		comboJava = new JComboBox();
		comboJava.setEditable(true);
		comboJava.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboJava.setBounds(306, 134, 165, 22);
		contentPane.add(comboJava);
		
		comboOperating = new JComboBox();
		comboOperating.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboOperating.setEditable(true);
		comboOperating.setBounds(306, 182, 165, 22);
		contentPane.add(comboOperating);
		
		comboVirtu = new JComboBox();
		comboVirtu.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboVirtu.setEditable(true);
		comboVirtu.setBounds(306, 239, 165, 22);
		contentPane.add(comboVirtu);
		
		comboBiometric = new JComboBox();
		comboBiometric.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboBiometric.setEditable(true);
		comboBiometric.setBounds(306, 302, 165, 22);
		contentPane.add(comboBiometric);
		
		comboIntership = new JComboBox();
		comboIntership.setModel(new DefaultComboBoxModel(new String[] {"Computer Networks", "Software Development", "Java Programming", "Operating System", "Virtualization Technologies", "Biometric System", "Intership", "CSS and Bootstrap Web Design"}));
		comboIntership.setEditable(true);
		comboIntership.setBounds(306, 354, 165, 22);
		contentPane.add(comboIntership);
		
		JLabel lblNewLabel = new JLabel("Please select a course");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 25, 219, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 60, 111, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_2.setBounds(22, 106, 111, 16);
		contentPane.add(lblNewLabel_2);
		
		surnameTxt = new JTextField();
		surnameTxt.setEditable(false);
		surnameTxt.setColumns(10);
		surnameTxt.setBounds(145, 153, 116, 22);
		contentPane.add(surnameTxt);
		surnameTxt.setText(student.getSurname());
		
		lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setBounds(22, 156, 111, 16);
		contentPane.add(lblNewLabel_3);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			studentId.setText(null);
			nameTxt.setText(null);
			surnameTxt.setText(null);
			DefaultTableModel model =(DefaultTableModel) table1.getModel();
			if(table1.getSelectedRow()==-1) {
				 if(table1.getRowCount()==0) {
					 JOptionPane.showMessageDialog(null, "No data to delete",
						"Data Entry Form",	 JOptionPane.OK_OPTION);
					 
				 }else {
					 JOptionPane.showMessageDialog(null, "Select a row to delete",
							 "Data Entry Form", JOptionPane.OK_OPTION);
				 }
			}
				 else {
					 model.removeRow(table1.getSelectedRow());

				 
			}
		}
		});
		btnDelete.setForeground(SystemColor.textHighlight);
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnDelete.setBounds(499, 445, 202, 38);
		contentPane.add(btnDelete);
		
		JButton btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Student Result System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		btnExt.setForeground(SystemColor.textHighlight);
		btnExt.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnExt.setBounds(1057, 445, 165, 38);
		contentPane.add(btnExt);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu(student);
				menu.menuScreen(student);
				menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				this.dispose();
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnBack.setBounds(790, 445, 185, 38);
		contentPane.add(btnBack);
	}
}
