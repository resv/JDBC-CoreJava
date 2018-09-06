package CoreJava.systemsInterfaces;

import java.sql.SQLException;
import java.util.List;

import CoreJava.Models.Course;

public interface CourseDAOI {

	List<Course> getAllCourses() throws SQLException;
	
	List<Course> getCourseByInstructor(int instructor_id) throws SQLException;
	
}
