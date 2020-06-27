package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.LoginStudent;
import teacher.TeacherManager;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//+
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 487);
		centerFrame();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(289, 62, 141, 36);
		contentPane.add(lblNewLabel);
		
		JButton studentButton = new JButton("LOGIN STUDENT");
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginStudent loginStudent = new LoginStudent();
				loginStudent.loginScreen();
				/*inf.setBounds(100, 100, 744, 461);
				inf.setVisible(true);
				inf.pack();
				inf.setLocationRelativeTo(null);
				inf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();*/
			}

			private void dispose() {
				
			}
		});
		studentButton.setForeground(Color.BLUE);
		studentButton.setBackground(SystemColor.activeCaption);
		studentButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		studentButton.setBounds(93, 177, 202, 110);
		contentPane.add(studentButton);
		
		JButton teacherButton = new JButton("LOGIN TEACHER");
		teacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherManager manager = new TeacherManager();
				manager.setVisible(true);
				manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.dispose();
				
			}
		});
		teacherButton.setForeground(new Color(255, 0, 0));
		teacherButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		teacherButton.setBackground(SystemColor.activeCaption);
		teacherButton.setBounds(406, 177, 202, 110);
		contentPane.add(teacherButton);
	}

}
