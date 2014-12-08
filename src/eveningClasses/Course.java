package eveningClasses;
import java.util.*;
public class Course {
 
	private int id;
	private int time;
	private String courseName;
	private String day;
	private int numberOfStudents;
	private List<Student> studentList = new ArrayList<Student>();
	
	public Course(int id, int time, String courseName, String day) {
		super();
		this.id = id;
		this.time = time;
		this.courseName = courseName;
		this.day = day;
		this.studentList = null;
		this.numberOfStudents = 0;
		
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
		if(numberOfStudents==50)
			return true;
		else
			return false;
	}
	
	public void addStudent(Student student)
	{
		studentList.add(student);
		numberOfStudents++;
	}
	
	public void deleteStudent(Student student)
	{
		Iterator<Student> it = studentList.iterator();
        while (it.hasNext()) {
            Student user = it.next();
            if (student.getId()==(user.getId())) {
                it.remove();
            }
        }
        numberOfStudents--;
	}
	
	

}
