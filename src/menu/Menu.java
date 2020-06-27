package menu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.AddingLesson;
import login.Lesson;
import student.LoginStudent;
import student.ResultExam;
import student.Student;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Student student;
	private JTextField txtExamResult;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Menu frame = new Menu(student);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void menuScreen(Student student) {
		this.student = student;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(student);
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
	//public Menu() {}
	
	
	public Menu(Student student) {
		String name = student.getName();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 519);
		centerFrame();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(143, 297, 1, 1);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("INFORMATION");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblNewLabel.setBounds(129, 50, 163, 16);
		contentPane.add(lblNewLabel);
		
		JTextField inf1 = new JTextField("1. Student information system");
		inf1.setEditable(false);
		inf1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Lesson inf = new Lesson();
				AddingLesson addingLesson = new AddingLesson(student);
				addingLesson.addLessonScreen(student);
				/*inf.setVisible(true);
				inf.pack();
				inf.setLocationRelativeTo(null);
				inf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
				this.dispose();
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		inf1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		inf1.setFont(new Font("Arial Black", Font.BOLD, 13));
		inf1.setForeground(new Color(0, 0, 255));
		inf1.setBounds(66, 98, 286, 25);
		contentPane.add(inf1);
		
		JTextField lblNewLabel_1_1 = new JTextField("2. Schedule Exam");
		lblNewLabel_1_1.setEditable(false);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)  {
				
				try {

				    Desktop.getDesktop().browse(new URL("https://www.toros.edu.tr/duyuru-oku/2230").toURI());
				} catch (Exception e) {
					System.out.println(e);

				}
				
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		lblNewLabel_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(66, 149, 286, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JTextField lblNewLabel_1_1_1 = new JTextField("3. Announcements");
		lblNewLabel_1_1_1.setEditable(false);
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				    Desktop.getDesktop().browse(new URL("https://www.toros.edu.tr/duyuru-listesi").toURI());
				} catch (Exception e1) {
					System.out.println(e1);

				}
				
				
			}
		});
		lblNewLabel_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(66, 199, 286, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTextField lblNewLabel_1_1_1_1 = new JTextField("4. Weekly Schedule");
		lblNewLabel_1_1_1_1.setEditable(false);
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				    Desktop.getDesktop().browse(new URL("https://www.toros.edu.tr/duyuru-oku/2035").toURI());
				} catch (Exception e2) {
					System.out.println(e2);
				}
				
				
				
			}
		});
		lblNewLabel_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(66, 252, 286, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Student Result System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		btnExt.setForeground(SystemColor.textHighlight);
		btnExt.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnExt.setBackground(SystemColor.controlHighlight);
		btnExt.setBounds(115, 372, 163, 41);
		contentPane.add(btnExt);
		
		txtExamResult = new JTextField("5. Results of Exam");
		txtExamResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ResultExam resultexam = new ResultExam(student);
			
				resultexam.ResultScreen(student);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
			
			
			}
		});
		txtExamResult.setForeground(Color.BLUE);
		txtExamResult.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtExamResult.setEditable(false);
		txtExamResult.setBounds(66, 302, 286, 25);
		contentPane.add(txtExamResult);
	}

	
}
