package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.INITIALIZE;

import menu.Menu;
import student.LoginStudent;
import student.ResultExam;
import student.Student;
import teacher.StudentList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lesson extends JFrame {

	private JPanel contentPane;
	private JTextField studentTxt;
	private JTextField nameTxt;
	private JTextField surnameTxt;
	private JTextField total3;
	private JTextField averageTxt;
	private JTextField rat3;
	private JTextField computerTxt;
	private JTextField softwareTxt;
	private JTextField javaTxt;
	private JTextField operatingTxt;
	private JTextField virtuTxt;
	private JTextField biometricTxt;
	private JTextField intershipTxt;
	private JTextField computer1Txt;
	private JTextField software1Txt;
	private JTextField java1Txt;
	private JTextField operating1Txt;
	private JTextField virtu1Txt;
	private JTextField biometric1Txt;
	private JTextField intership1Txt;
	private JTable table;
	ResultSet rs=null;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField computer2Txt;
	private JTextField software2Txt;
	private JTextField java2Txt;
	private JTextField operating2Txt;
	private JTextField virtu2Txt;
	private JTextField biometric2Txt;
	private JTextField intership2Txt;
	public static Student student;
	private JTextField lesson1;
	private JTextField lesson2;
	private JTextField lesson3;
	private JTextField lesson4;
	private JTextField lesson5;
	private JTextField lesson6;
	private JTextField lesson7;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson frame = new Lesson(student);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void lessonScreen(Student student) {
		Lesson.student = student;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson frame = new Lesson(student);
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
	
	private Student getStudentInfo(Student student) {
		//Student student = new Student();
		//sql cagÄ±rma user bilgileri getirme
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			Statement stmt =con.createStatement();
			String sql="Select student_id,First_Lesson,Second_Lesson,Third_Lesson,Fourth_Lesson,Fifth_Lesson,Sixth_Lesson,Seventh_Lesson from addinglesson where student_id="+student.getUser_id()+ "";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				
				student.setStudent_ID(rs.getString(1));                                                                                                                   
				
		
				student.setFirst_Lesson(rs.getString(2)); //Bu kod AddingLessonda seçtiðimiz dersleri textFieldlere getiriyor.. 
				student.setSecond_Lesson(rs.getString(3));
				student.setThird_Lesson(rs.getString(4));	
				student.setFourth_Lesson(rs.getString(5));
				student.setFifth_Lesson(rs.getString(6));
				student.setSixth_Lesson(rs.getString(7));
				student.setSeventh_Lesson(rs.getString(8));
			}
				
				
			else {
				JOptionPane.showMessageDialog(null, "Invalid .."); }
			con.close();
			return student;
		}catch (Exception e) {System.out.println(e);
			return student;
		}
	}
	/**
	 * Create the frame.
	 */
	public Lesson(Student st) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 785);
		Student student = getStudentInfo(st);
		centerFrame();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption, 12));
		panel.setBounds(22, 13, 393, 412);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 43, 120, 16);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblName.setBounds(31, 100, 120, 16);
		panel.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSurname.setBounds(31, 159, 120, 16);
		panel.add(lblSurname);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTotal.setBounds(31, 218, 120, 16);
		panel.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblAverage.setBounds(31, 269, 120, 16);
		panel.add(lblAverage);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblRating.setBounds(31, 319, 120, 16);
		panel.add(lblRating);
		
		studentTxt = new JTextField();
		studentTxt.setEditable(false);
		studentTxt.setBounds(203, 41, 116, 22);
		panel.add(studentTxt);
		studentTxt.setColumns(10);
		studentTxt.setText(Integer.toString(student.getUser_id()));
		
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setColumns(10);
		nameTxt.setBounds(203, 98, 116, 22);
		panel.add(nameTxt);
		nameTxt.setText(student.getName());
		
		surnameTxt = new JTextField();
		surnameTxt.setEditable(false);
		surnameTxt.setColumns(10);
		surnameTxt.setBounds(203, 157, 116, 22);
		panel.add(surnameTxt);
		surnameTxt.setText(student.getSurname());
		
		total3 = new JTextField();
		total3.setEditable(false);
		total3.setColumns(10);
		total3.setBounds(203, 216, 116, 22);
		panel.add(total3);
		
		averageTxt = new JTextField();
		averageTxt.setEditable(false);
		averageTxt.setColumns(10);
		averageTxt.setBounds(203, 267, 116, 22);
		panel.add(averageTxt);
		
		rat3 = new JTextField();
		rat3.setEditable(false);
		rat3.setColumns(10);
		rat3.setBounds(203, 317, 116, 22);
		panel.add(rat3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.inactiveCaption, 12));
		panel_1.setBounds(536, 13, 771, 449);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(new Integer(3), null, null, new Integer(1)));
		spinner.setBounds(273, 69, 49, 22);
		panel_1.add(spinner);
		
		JEditorPane dtrpnCredi = new JEditorPane();
		dtrpnCredi.setEditable(false);
		dtrpnCredi.setForeground(Color.BLACK);
		dtrpnCredi.setFont(new Font("Arial Black", Font.BOLD, 13));
		dtrpnCredi.setBackground(SystemColor.activeCaption);
		dtrpnCredi.setText("Credit");
		dtrpnCredi.setBounds(263, 28, 77, 22);
		panel_1.add(dtrpnCredi);
		
		JEditorPane dtrpnMidterm = new JEditorPane();
		dtrpnMidterm.setEditable(false);
		dtrpnMidterm.setText("Midterm");
		dtrpnMidterm.setForeground(Color.BLACK);
		dtrpnMidterm.setFont(new Font("Arial Black", Font.BOLD, 13));
		dtrpnMidterm.setBackground(SystemColor.activeCaption);
		dtrpnMidterm.setBounds(387, 28, 77, 22);
		panel_1.add(dtrpnMidterm);
		
		JEditorPane dtrpnFinal = new JEditorPane();
		dtrpnFinal.setEditable(false);
		dtrpnFinal.setText("Final");
		dtrpnFinal.setForeground(Color.BLACK);
		dtrpnFinal.setFont(new Font("Arial Black", Font.BOLD, 13));
		dtrpnFinal.setBackground(SystemColor.activeCaption);
		dtrpnFinal.setBounds(512, 28, 77, 22);
		panel_1.add(dtrpnFinal);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(new Integer(4), null, null, new Integer(1)));
		spinner_1.setBounds(273, 119, 49, 22);
		panel_1.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.setModel(new SpinnerNumberModel(new Integer(4), null, null, new Integer(1)));
		spinner_2.setBounds(273, 171, 49, 22);
		panel_1.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		spinner_3.setModel(new SpinnerNumberModel(new Integer(2), null, null, new Integer(1)));
		spinner_3.setBounds(273, 221, 49, 22);
		panel_1.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setEnabled(false);
		spinner_4.setModel(new SpinnerNumberModel(new Integer(2), null, null, new Integer(1)));
		spinner_4.setBounds(273, 273, 49, 22);
		panel_1.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setEnabled(false);
		spinner_5.setModel(new SpinnerNumberModel(new Integer(3), null, null, new Integer(1)));
		spinner_5.setBounds(273, 328, 49, 22);
		panel_1.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setEnabled(false);
		spinner_6.setModel(new SpinnerNumberModel(new Integer(5), null, null, new Integer(1)));
		spinner_6.setBounds(273, 378, 49, 22);
		panel_1.add(spinner_6);
		
		computerTxt = new JTextField();
		computerTxt.setBounds(387, 69, 77, 22);
		panel_1.add(computerTxt);
		computerTxt.setColumns(10);
		
		softwareTxt = new JTextField();
		softwareTxt.setColumns(10);
		softwareTxt.setBounds(387, 119, 77, 22);
		panel_1.add(softwareTxt);
		
		javaTxt = new JTextField();
		javaTxt.setColumns(10);
		javaTxt.setBounds(387, 171, 77, 22);
		panel_1.add(javaTxt);
		
		operatingTxt = new JTextField();
		operatingTxt.setColumns(10);
		operatingTxt.setBounds(387, 221, 77, 22);
		panel_1.add(operatingTxt);
		
		virtuTxt = new JTextField();
		virtuTxt.setColumns(10);
		virtuTxt.setBounds(387, 273, 77, 22);
		panel_1.add(virtuTxt);
		
		biometricTxt = new JTextField();
		biometricTxt.setColumns(10);
		biometricTxt.setBounds(387, 328, 77, 22);
		panel_1.add(biometricTxt);
		
		intershipTxt = new JTextField();
		intershipTxt.setColumns(10);
		intershipTxt.setBounds(387, 378, 77, 22);
		panel_1.add(intershipTxt);
		
		computer1Txt = new JTextField();
		computer1Txt.setColumns(10);
		computer1Txt.setBounds(512, 69, 77, 22);
		panel_1.add(computer1Txt);
		
		software1Txt = new JTextField();
		software1Txt.setColumns(10);
		software1Txt.setBounds(512, 119, 77, 22);
		panel_1.add(software1Txt);
		
		java1Txt = new JTextField();
		java1Txt.setColumns(10);
		java1Txt.setBounds(512, 171, 77, 22);
		panel_1.add(java1Txt);
		
		operating1Txt = new JTextField();
		operating1Txt.setColumns(10);
		operating1Txt.setBounds(512, 221, 77, 22);
		panel_1.add(operating1Txt);
		
		virtu1Txt = new JTextField();
		virtu1Txt.setColumns(10);
		virtu1Txt.setBounds(512, 273, 77, 22);
		panel_1.add(virtu1Txt);
		
		biometric1Txt = new JTextField();
		biometric1Txt.setColumns(10);
		biometric1Txt.setBounds(512, 328, 77, 22);
		panel_1.add(biometric1Txt);
		
		intership1Txt = new JTextField();
		intership1Txt.setColumns(10);
		intership1Txt.setBounds(512, 378, 77, 22);
		panel_1.add(intership1Txt);
		
		computer2Txt = new JTextField();
		computer2Txt.setEditable(false);
		computer2Txt.setBounds(641, 69, 70, 22);
		panel_1.add(computer2Txt);
		computer2Txt.setColumns(10);
		
		JEditorPane dtrpnResult = new JEditorPane();
		dtrpnResult.setText("Result");
		dtrpnResult.setForeground(Color.BLACK);
		dtrpnResult.setFont(new Font("Arial Black", Font.BOLD, 13));
		dtrpnResult.setEditable(false);
		dtrpnResult.setBackground(SystemColor.activeCaption);
		dtrpnResult.setBounds(631, 28, 77, 22);
		panel_1.add(dtrpnResult);
		
		software2Txt = new JTextField();
		software2Txt.setEditable(false);
		software2Txt.setColumns(10);
		software2Txt.setBounds(641, 119, 70, 22);
		panel_1.add(software2Txt);
		
		java2Txt = new JTextField();
		java2Txt.setEditable(false);
		java2Txt.setColumns(10);
		java2Txt.setBounds(641, 171, 70, 22);
		panel_1.add(java2Txt);
		
		operating2Txt = new JTextField();
		operating2Txt.setEditable(false);
		operating2Txt.setColumns(10);
		operating2Txt.setBounds(641, 221, 70, 22);
		panel_1.add(operating2Txt);
		
		virtu2Txt = new JTextField();
		virtu2Txt.setEditable(false);
		virtu2Txt.setColumns(10);
		virtu2Txt.setBounds(641, 273, 70, 22);
		panel_1.add(virtu2Txt);
		
		biometric2Txt = new JTextField();
		biometric2Txt.setEditable(false);
		biometric2Txt.setColumns(10);
		biometric2Txt.setBounds(641, 328, 70, 22);
		panel_1.add(biometric2Txt);
		
		intership2Txt = new JTextField();
		intership2Txt.setEditable(false);
		intership2Txt.setColumns(10);
		intership2Txt.setBounds(638, 378, 70, 22);
		panel_1.add(intership2Txt);
		
		lesson1 = new JTextField();
		lesson1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson1.setEditable(false);
		lesson1.setBounds(29, 69, 206, 22);
		panel_1.add(lesson1);
		lesson1.setColumns(10);
		lesson1.setText(student.getFirst_Lesson());
		
		
		lesson2 = new JTextField();
		lesson2.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson2.setEditable(false);
		lesson2.setColumns(10);
		lesson2.setBounds(29, 119, 206, 22);
		panel_1.add(lesson2);
		lesson2.setText(student.getSecond_Lesson());
		
		lesson3 = new JTextField();
		lesson3.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson3.setEditable(false);
		lesson3.setColumns(10);
		lesson3.setBounds(29, 171, 206, 22);
		panel_1.add(lesson3);
		lesson3.setText(student.getThird_Lesson());
		
		lesson4 = new JTextField();
		lesson4.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson4.setEditable(false);
		lesson4.setColumns(10);
		lesson4.setBounds(29, 221, 206, 22);
		panel_1.add(lesson4);
		lesson4.setText(student.getFourth_Lesson());
		
		lesson5 = new JTextField();
		lesson5.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson5.setEditable(false);
		lesson5.setColumns(10);
		lesson5.setBounds(29, 273, 206, 22);
		panel_1.add(lesson5);
		lesson5.setText(student.getFifth_Lesson());
		
		lesson6 = new JTextField();
		lesson6.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson6.setEditable(false);
		lesson6.setColumns(10);
		lesson6.setBounds(29, 328, 206, 22);
		panel_1.add(lesson6);
		lesson6.setText(student.getSixth_Lesson());
		
		
		lesson7 = new JTextField();
		lesson7.setFont(new Font("Arial Black", Font.BOLD, 13));
		lesson7.setEditable(false);
		lesson7.setColumns(10);
		lesson7.setBounds(29, 378, 206, 22);
		panel_1.add(lesson7);
		lesson7.setText(student.getSeventh_Lesson());
		
			/*	table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Computer Networks", "Software Development", "JAVA", "Operating Systems", "Virtualization", "Biometric Systems", "Intership"
			}
		));*/
		
		
		JButton studentresult = new JButton("Student Result");
		Object[][] data = {
				
			    
			};
	
		String[] columnNames = {"Student ID","Computer Networks","Software Development","Java Programming","Operating Systems","Virtualization Technologies","Biometric System","Intership"};
		DefaultTableModel model = new DefaultTableModel(data,columnNames); //AÞAÐDAKÝ TABLOYA GEÇECEK DERSLER 
		table = new JTable(model); 

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(52, 494, 1224, 186);
		contentPane.add(scrollPane);
		
		
		//scrollPane.setColumnHeaderView(table);
		
		
		studentresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement ps=conn.prepareStatement("insert into lesson(student_id,computer,software,java,operating,virtu,biometric,intership) values (?,?,?,?,?,?,?,?);");
					ps.setString(1, studentTxt.getText());
					ps.setString(2, computerTxt.getText());
					ps.setString(3, softwareTxt.getText()); //GÝRDÝÐÝMÝZ SONUCLARI DATABASE EKLÝYOR 
					ps.setString(4, javaTxt.getText());
					ps.setString(5, operatingTxt.getText());
					ps.setString(6, virtuTxt.getText());
					ps.setString(7, biometricTxt.getText());
					ps.setString(8, intershipTxt.getText());
					
					int x = ps.executeUpdate();
					
					
					/*Object col[] = {"student_iid","computer","software","java","operating","virtu","biometric","intership"};
					model.setColumnIdentifiers(col);
					table.setModel(model);*/
					
				
					
					if(x > 0) {
						System.out.println("Record done successfully");
						
					}else {
						System.out.println("Invalid record");
					}
				}catch (Exception e1) {
					System.out.println(e1);
					
				}
				double[] R = new double[28];
				R[0] = Double.parseDouble(computerTxt.getText());
				R[1] = Double.parseDouble(softwareTxt.getText());
				R[2] = Double.parseDouble(javaTxt.getText());
				R[3] = Double.parseDouble(virtuTxt.getText());
				R[4] = Double.parseDouble(operatingTxt.getText());
				R[5] = Double.parseDouble(intershipTxt.getText());
				R[6] = Double.parseDouble(biometricTxt.getText());
				R[7] = Double.parseDouble(computer1Txt.getText());
				R[8] = Double.parseDouble(software1Txt.getText());
				R[9] = Double.parseDouble(java1Txt.getText());
				R[10] = Double.parseDouble(virtu1Txt.getText());
				R[11] = Double.parseDouble(operating1Txt.getText());
				R[12] = Double.parseDouble(intership1Txt.getText());
				R[13] = Double.parseDouble(biometric1Txt.getText());
				
				
				
				
				R[14] = (R[0] + R[1] + R[2]+ R[3] + R[4]+ R[5] + R[6]+ R[7] + R[8] + R[9]+ R[10] + R[11]+ R[12] + R[13]) / 14 ;
				R[15] = (R[0] + R[1] + R[2]+ R[3] + R[4]+ R[5] + R[6] +  R[7] + R[8] + R[9]+ R[10] + R[11]+ R[12] + R[13]);
				
				R[16] =( R[0]* 0.4 + R[7]  *0.6);
				R[17] =( R[1]* 0.4 + R[8]  *0.6); // BURDAKÝ KODLAR ÝSE VÝZE ÝLE FÝNAL ORTALAMASINI HESAPLAYIP RESULT kýsmýnda gösteriyor
				R[18] =( R[2]* 0.4 + R[9]  *0.6);
				R[19] =( R[3]* 0.4 + R[10]  *0.6);
				R[20] =( R[4]* 0.4 + R[11]  *0.6);
				R[21] =( R[5]* 0.4 + R[12]  *0.6);
				R[22] =( R[6]* 0.4 + R[13]  *0.6);
				
				
				
				String Average = String.format("%.0f", R[14]); // NOT ORTALAMASINI EKRANA YAZDIRIYOR R14(585) 
				averageTxt.setText(Average);
				
				
				String TotalScore = String.format("%.0f", R[15]); 
				total3.setText(TotalScore);
				
				String computerNetworks = String.format("%.0f", R[16]);
				computer2Txt.setText(computerNetworks);
				
				String softwareDevelopment = String.format("%.0f", R[17]);
				software2Txt.setText(softwareDevelopment);
				
				String javaProgramming = String.format("%.0f", R[18]);
				java2Txt.setText(javaProgramming);
				
				String virtualizationTech = String.format("%.0f", R[19]);
				virtu2Txt.setText(virtualizationTech);
				
				String operatingSystem = String.format("%.0f", R[20]);
				operating2Txt.setText(operatingSystem);
				
				String intership = String.format("%.0f", R[21]);
				intership2Txt.setText(intership);
				
				String biometricSystem = String.format("%.0f", R[22]);
				biometric2Txt.setText(biometricSystem);
				
				if(R[8]>=700) {
					rat3.setText("1st");
				}
				else if(R[8]>=600) {
					rat3.setText("2i"); // NOT TOPLAMININ HANGÝ DEÐERLER ARASINDA OLDUÐUNU GÖSTERÝYOR
				}
				else if(R[8]>=500) {
					rat3.setText("2ii");
				}
				else if(R[8]>=400) {
					rat3.setText("3rd");
				}
				else if(R[8]>=300) {
					rat3.setText("CoHE");
				}
				else if(R[8]<200) {
					rat3.setText("Fail");
				}
				
				
				
			
				 DefaultTableModel model =(DefaultTableModel) table.getModel();
				 model.addRow(new Object[] {
						 studentTxt.getText(),
						 computer2Txt.getText(), //RESULT SONUCLARI ALTTAKÝ TABLOYA YAZDIRIYOR
				
						 software2Txt.getText(),
						 java2Txt.getText(),
						 operating2Txt.getText(),
						 virtu2Txt.getText(),
						 
						 biometric2Txt.getText(),
						 intership2Txt.getText(),
					
						
						 
						 
				 });
				 if(table.getSelectedRow()==-1) {
					 if(table.getRowCount()==0) {
						 JOptionPane.showMessageDialog(null, "message","sgfewg",
								 JOptionPane.OK_OPTION);
					 }
				 }
			}
		});
		
		 
		studentresult.setBackground(SystemColor.controlHighlight);
		studentresult.setForeground(SystemColor.textHighlight);
		studentresult.setFont(new Font("Arial Black", Font.BOLD, 14));
		studentresult.setBounds(12, 684, 163, 41);
		contentPane.add(studentresult);
		
		JButton btnPrnt = new JButton("PRINT");
		btnPrnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				if(table.getSelectedRow()==-1) {
					 if(table.getRowCount()==0) {
						 JOptionPane.showMessageDialog(null, "Data Entry Update confirmed",
							"Data Entry System",	
							JOptionPane.OK_OPTION);
						 
					 }
				
				}
				
			}
		});
		btnPrnt.setForeground(SystemColor.textHighlight);
		btnPrnt.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnPrnt.setBackground(SystemColor.controlHighlight);
		btnPrnt.setBounds(252, 684, 163, 41);
		contentPane.add(btnPrnt);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				studentTxt.setText(null);
				
				nameTxt.setText(null);
				surnameTxt.setText(null);
				
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				if(table.getSelectedRow()==-1) {
					 if(table.getRowCount()==0) {
						 JOptionPane.showMessageDialog(null, "No data to delete",
							"Data Entry Form",	 JOptionPane.OK_OPTION);
						 
					 }else {
						 JOptionPane.showMessageDialog(null, "Select a row to delete",
								 "Data Entry Form", JOptionPane.OK_OPTION);
					 }
				}
					 else {
						 model.removeRow(table.getSelectedRow());

					 
				}
			}
				
				

		});
		btnDelete.setForeground(SystemColor.textHighlight);
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnDelete.setBackground(SystemColor.controlHighlight);
		btnDelete.setBounds(483, 684, 163, 41);
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextField temp=null;
				for(Component c:panel_1.getComponents()) {
					if(c.getClass().toString().contains("Javax.swing.JTextField")) {
						JTextField temp1 = (JTextField)c;
						temp1.setText(null);
						
						
						
					}
					
				}
				panel_1.setToolTipText(null);
				
			
			}
		});
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnReset.setBackground(SystemColor.controlHighlight);
		btnReset.setBounds(708, 684, 163, 41);
		contentPane.add(btnReset);
		
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
		btnExt.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnExt.setBackground(SystemColor.controlHighlight);
		btnExt.setBounds(1091, 684, 163, 41);
		contentPane.add(btnExt);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			//	StudentList menu = new StudentList(student);
				//menu.menuScreen(student);
				//menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.setBounds(892, 684, 163, 41);
		contentPane.add(btnBack);
	}
}
