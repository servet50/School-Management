package student;

public class Student {
	
	private int user_id;
	private String name;
	private String surname;
	private String date;
	private String phone_number;
	private String faculty;
	private String department;
	private String First_Lesson;
	private String Second_Lesson;
	private String Third_Lesson;
	private String Fourth_Lesson;
	private String Fifth_Lesson;
	private String Sixth_Lesson;
	private String Seventh_Lesson;
	
	
	
	public Student(int student_id ,String first_Lesson, String second_Lesson, String third_Lesson, String fourth_Lesson, String fifth_Lesson,
			String sixth_Lesson, String seventh_Lesson) {
		super();
		this.First_Lesson = first_Lesson;
		this.Second_Lesson = second_Lesson;
		this.Third_Lesson = third_Lesson;
		this.Fourth_Lesson = fourth_Lesson;
		this.Fifth_Lesson = fifth_Lesson;
		this.Sixth_Lesson = sixth_Lesson;
		this.Seventh_Lesson = seventh_Lesson;
	}
	public String getFirst_Lesson() {
		return First_Lesson;
	}
	public void setFirst_Lesson(String first_Lesson) {
		First_Lesson = first_Lesson;
	}
	public String getSecond_Lesson() {
		return Second_Lesson;
	}
	public void setSecond_Lesson(String second_Lesson) {
		Second_Lesson = second_Lesson;
	}
	public String getThird_Lesson() {
		return Third_Lesson;
	}
	public void setThird_Lesson(String third_Lesson) {
		Third_Lesson = third_Lesson;
	}
	public String getFourth_Lesson() {
		return Fourth_Lesson;
	}
	public void setFourth_Lesson(String fourth_Lesson) {
		Fourth_Lesson = fourth_Lesson;
	}
	public String getFifth_Lesson() {
		return Fifth_Lesson;
	}
	public void setFifth_Lesson(String fifth_Lesson) {
		Fifth_Lesson = fifth_Lesson;
	}
	public String getSixth_Lesson() {
		return Sixth_Lesson;
	}
	public void setSixth_Lesson(String sixth_Lesson) {
		Sixth_Lesson = sixth_Lesson;
	}
	public String getSeventh_Lesson() {
		return Seventh_Lesson;
	}
	public void setSeventh_Lesson(String seventh_Lesson) {
		Seventh_Lesson = seventh_Lesson;
	}
	public Student() {}
	public Student(int user_id, String name, String surname) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.surname = surname;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setStudent_ID(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
