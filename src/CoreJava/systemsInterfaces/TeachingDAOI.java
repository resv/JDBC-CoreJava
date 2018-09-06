package CoreJava.systemsInterfaces;

import java.sql.SQLException;
import java.util.List;

import CoreJava.Models.Teaching;

public interface TeachingDAOI {

//	int registerStudentToCourse(int course_id, int instructor_id);
	
	List<Teaching> getInstructorsCourses() throws SQLException;
	
	
}
