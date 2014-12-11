package eveningClasses.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eveningClasses.Course;
import eveningClasses.Student;

public class StudentTest {
	Course course1;
	Course course2;
	Course course3;
	Student student;
	List<Course> courses;
	
	@Before
	public void setUp() {
		course1 = new Course(456, 1600, "class", "Monday", "Details","cwk");
		course2 = new Course(678, 1700, "class2", "Tuesday", "Details","cwk");
		course3 = new Course(999, 1700, "class3", "Tuesday", "Details","cwk");
		
		courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		student = new Student(123, "Jeff", "pass", "username", courses);
	}
	
	@Test
	public void deleteCourse() {
		assertEquals(2, student.getCourseListTemp().size());
		
		student.deleteCourse(course1);
		assertEquals(1, student.getCourseListTemp().size());
		assertEquals(course2, student.getCourseListTemp().get(0));
	}
	
	@Test
	public void deleteSecondCourse() {
		assertEquals(2, student.getCourseListTemp().size());
		
		student.deleteCourse(course2);
		assertEquals(1, student.getCourseListTemp().size());
		assertEquals(course1, student.getCourseListTemp().get(0));		
	}
	
	/**
	 * Deleting a course the student is not enrolled in should be a noop
	 */
	@Test
	public void deleteNonIncludedCourse() {
		assertEquals(2, student.getCourseListTemp().size());
		
		student.deleteCourse(course3);
		assertEquals(2, student.getCourseListTemp().size());		
	}
	
	@Test
	public void testIsEnrolled() {
		assertTrue(student.isEnrolled(course1));
		assertTrue(student.isEnrolled(course2));	
		assertFalse(student.isEnrolled(course3));	
	}
	
	@Test
	public void testSetEnrolled() {	
		assertFalse(student.getCourseListTemp().contains(course3));	
		student.setEnrolled(course3);
		assertTrue(student.getCourseListTemp().contains(course3));
	}	
	
	@Test
	public void testConfirmAddClass() {	
		student.setEnrolled(course3);
		assertFalse(student.isEnrolled(course3));
		
		assertTrue(student.isEnrolled(course1));
		assertTrue(student.isEnrolled(course2));
		
		student.confirm();
		
		// new course is enrolled
		assertTrue(student.isEnrolled(course3));
		
		// old course still correct
		assertTrue(student.isEnrolled(course1));
		assertTrue(student.isEnrolled(course2));
		
	}

	@Test
	public void testConfirmDropClass() {	
		student.deleteCourse(course2);
		
		assertTrue(student.isEnrolled(course1));
		assertTrue(student.isEnrolled(course2));
		
		student.confirm();
		
		// new course is enrolled
		assertFalse(student.isEnrolled(course2));
		
		// other course still correct
		assertTrue(student.isEnrolled(course1));
		
	}
	
}
