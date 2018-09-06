package CoreJava.systemsInterfaces;

import java.sql.SQLException;
import java.util.List;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

public interface AttendingDAOI {

	int registerStudentToCourse(Student student, Course course) throws SQLException;
	
	List<Attending> getStudentCourse(int student_id) throws SQLException;
	
}
