package eveningClasses;
import java.util.*;
public class Data {
	public List<Student> students = new ArrayList<Student>();
	public List<Course> courses = new ArrayList<Course>();
	
	public Data()
	{
		courses.add(new Course(1, 1600, "Software Engineering", "Monday"));
		courses.add(new Course(2, 1600, "Maths", "Monday"));
		courses.add(new Course(3, 1800, "Systems Engineering", "Tuesday"));
		courses.add(new Course(4, 1600, "Engineering", "Wednesday"));
		courses.add(new Course(5, 2000, "Mechanical Engineering", "Friday"));
		
		List<Course> course1 = new ArrayList<Course>();
		course1.add(courses.get(1));
		course1.add(courses.get(3));
		
		Student student1 = new Student(1,"Jeff", "12345", "Jeff",course1);
		students.add(student1);
		
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
		
	}
    
	public void addCourse(Course course)
	{
		courses.add(course);
		
	}

}
