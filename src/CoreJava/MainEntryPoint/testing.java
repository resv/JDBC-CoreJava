package CoreJava.MainEntryPoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Attending;

public class testing {

	public static void main(String[] args) throws SQLException {
		vgetStudentCourse(3);

	}

	private static List<Attending> vgetStudentCourse(int i) throws SQLException {
		List<Attending> attendingCourse = new ArrayList<Attending>();
		Attending attending = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT c.COURSE_NAME, s.FULL_NAME , s.EMAIL\r\n" + "FROM COURSE c\r\n"
					+ "JOIN ATTENDING a ON a.COURSE_ID=c.COURSE_ID\r\n"
					+ "JOIN STUDENT s ON s.STUDENT_ID=a.STUDENT_ID\r\n" + "WHERE s.STUDENT_ID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			result = ps.executeQuery();
			while (result.next()) {
				attending = new Attending();
				attending.setCourse_name(result.getString(1));
				attending.setFull_name(result.getString(2));
				attending.setEmail(result.getString(3));
				attendingCourse.add(attending);
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
		System.out.println(attendingCourse);
		return attendingCourse;
	}
	
	
}
