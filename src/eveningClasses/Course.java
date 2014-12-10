package eveningClasses;
public class Course {
 
	private int id;
	private int time;
	private String courseName;
	private String day;
	private String coursework;
	private String coursedetails;
	private int numberOfStudents;
	
	
	public Course(int id, int time, String courseName, String day, String coursedetails, String coursework) {
		super();
		this.id = id;
		this.time = time;
		this.courseName = courseName;
		this.day = day;
		
		this.numberOfStudents = 0;
		this.coursework=coursework;
		this.coursedetails=coursedetails;
		
	}

	public Course courseDetails()
	{
		return this;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getCourseName() {
		return courseName;
	}
	public String getCourseDetails() {
		return coursedetails;
	}
	public String getCourseWork() {
		return coursework;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public boolean isFull()
	{
		if(numberOfStudents==1)
			return true;
		else
			return false;
	}
	
	public void addStudent(Student student)
	{
		numberOfStudents++;
	}
	
	public void deleteStudent(Student student)
	{
		
        numberOfStudents--;
	}
	
	

}
