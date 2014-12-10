package eveningClasses.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eveningClasses.Course;
import eveningClasses.Student;

public class StudentTest {

	@Test
	public void deleteCourse() {
		List<Course> courses = new ArrayList<>();
		
		Course course1 = new Course(456, 1600, "class", "Monday", "Details","cwk");
		Course course2 = new Course(678, 1700, "class2", "Tuesday", "Details","cwk");
		
		courses.add(course1);
		courses.add(course2);
		
		Student student = new Student(123, "Jeff", "pass", "username", courses);
		
		assertEquals(2, student.getCourseListTemp().size());
		student.deleteCourse(course1);
		assertEquals(1, student.getCourseListTemp().size());
		assertEquals(course2, student.getCourseListTemp().get(0));
	}
	
	

}
