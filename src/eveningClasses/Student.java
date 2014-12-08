package eveningClasses;
import java.util.*;
public class Student {
	private int id;
	private String name;
	private List<Course> courseList= new ArrayList<Course>();
	private List<Course> courseListTemp= new ArrayList<Course>();
	private String pass;
	private String uname;
	
	
	
	public Student(int id, String name, String pass, String uname, List<Course> course) {
		super();
		this.id = id;
		this.name = name;
		
		this.pass = pass;
		this.uname = uname;
		Iterator<Course> i = course.iterator();
		while(i.hasNext())
		{
			Course c = i.next();
			this.courseList.add(c);
			this.courseListTemp.add(c);
		}
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnrolled(Course checkItem)
	{
		boolean b = Arrays.asList(courseListTemp).contains(checkItem);	
		return b;
	}
	public void setEnrolled(Course addItem)
	{
	   courseListTemp.add(addItem);	
	}
	public void confirm()
	{
		Iterator<Course> i = courseList.iterator();
		while(i.hasNext())
		{
			Course c = i.next();
			i.remove();
			
		}
		i = courseListTemp.iterator();
		while(i.hasNext())
		{
			Course c = i.next();
			this.courseList.add(c);
			
		}
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public List<Course> getCourseListTemp() {
		return courseListTemp;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public void deleteCourse(Course course)
	{
		System.out.println("Changed the temp");
		Iterator<Course> it = courseListTemp.iterator();
        while (it.hasNext()) {
            Course user = it.next();
            if (course.getId()==(user.getId())) {
                it.remove();
            }
        }
        
	}
	
	

}
