package CoreJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Course;
import CoreJava.systemsInterfaces.CourseDAOI;

public class CourseDAO implements CourseDAOI{

	/*getAllCourses – This method takes no parameter and 
	returns every Course in the database.*/
	public List<Course> getAllCourses() throws SQLException {
		List<Course> courses = new ArrayList<Course>();
		Course course = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT * FROM COURSE";
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();

			while (result.next()) {
				course = new Course();
				course.setCourse_id(result.getInt(1));
				course.setCourse_name(result.getString(2));
				course.setMinimum_gpa(result.getDouble(3));
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				result.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return courses;
	}	
	
	
	/*getCourseByInstructor – This method takes an int as a parameter and 
	queries the database for all the courses one instructor is assigned to.*/
	public List<Course> getCourseByInstructor(int i) throws SQLException {
		List<Course> courses = new ArrayList<Course>();
		Course course = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT c.COURSE_NAME " +
						  "FROM COURSE c " +
						  "JOIN TEACHING t ON c.COURSE_ID=t.COURSE_ID " +
						  "JOIN INSTRUCTOR i ON i.INSTRUCTOR_ID=t.INSTRUCTOR_ID " +
						  "WHERE i.INSTRUCTOR_ID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			result = ps.executeQuery();
			
			while (result.next()) {
				course = new Course();
				course.setCourse_name(result.getString(1));
				courses.add(course);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				result.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return courses;
	}	
	
}
