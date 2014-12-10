package eveningClasses;
import java.util.*;
public class Data {
	public List<Student> students = new ArrayList<Student>();
	public List<Course> courses = new ArrayList<Course>();
	
	public Data()
	{
		courses.add(new Course(1, 1600, "Software Engineering", "Monday","Nam vitae purus mi. Quisque eu orci bibendum, porta nisi a, condimentum justo. Vestibulum leo enim, sollicitudin nec orci vel, sodales aliquam quam. Aliquam erat volutpat.","no course work"));
		courses.add(new Course(2, 1600, "Maths", "Monday", "Nam vitae purus mi. Quisque eu orci bibendum, porta nisi a, condimentum justo. Vestibulum leo enim, sollicitudin nec orci vel, sodales aliquam quam. Aliquam erat volutpat.", "Dec 15 - Report Submission"));
		courses.add(new Course(3, 1800, "Systems Engineering", "Tuesday","Nam vitae purus mi. Quisque eu orci bibendum, porta nisi a, condimentum justo. Vestibulum leo enim, sollicitudin nec orci vel, sodales aliquam quam. Aliquam erat volutpat.","Dec 11- Programming test"));
		courses.add(new Course(4, 1600, "Engineering", "Wednesday","Nam vitae purus mi. Quisque eu orci bibendum, porta nisi a, condimentum justo. Vestibulum leo enim, sollicitudin nec orci vel, sodales aliquam quam. Aliquam erat volutpat.","no course work"));
		courses.add(new Course(5, 2000, "Mechanical Engineering", "Friday","Nam vitae purus mi. Quisque eu orci bibendum, porta nisi a, condimentum justo. Vestibulum leo enim, sollicitudin nec orci vel, sodales aliquam quam. Aliquam erat volutpat.","Dec 13- Testing and implementation"));
		
		List<Course> course1 = new ArrayList<Course>();
		course1.add(courses.get(1));
		course1.add(courses.get(3));
		
		List<Course> course2 = new ArrayList<Course>();
		course2.add(courses.get(2));
		course2.add(courses.get(0));
		
		Student student1 = new Student(1,"Jeff", "12345", "Jeff",course1);
		Student student2 = new Student(2,"Joey", "12345", "Joey",course2);
		courses.get(1).addStudent(student1);
		courses.get(2).addStudent(student2);
		courses.get(3).addStudent(student1);
		courses.get(4).addStudent(student2);
		students.add(student1);
		students.add(student2);
		
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
