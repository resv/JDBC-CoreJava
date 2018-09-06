package CoreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CoreJava.Models.Student;
import CoreJava.systemsInterfaces.StudentDAOI;

public class StudentDAO implements StudentDAOI {

	/*
	 * getStudentByGmail – This method takes a String as a parameter and queries the
	 * database for an Student with such an email and returns a Student Object.
	 */		public Student getStudentByGmail(String email) throws ClassNotFoundException, IOException, SQLException {
			Student student = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet result = null;

			try {
				/* Connection */ conn = OracleConnection.getConnection();
				student = new Student();
				String sql = "SELECT * FROM STUDENT WHERE email = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				/* ResultSet */ result = ps.executeQuery();

				if (result.next()) {
					student.setStudent_id(result.getInt(1));
					student.setFull_name(result.getString(2));
					student.setEmail(result.getString(3));
					student.setGpa(result.getInt(4));
					student.setPass(result.getString(5));
					student.setStudent_role(result.getInt(6));
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
			return student;
		}
	
	
		/*This method takes two parameters: the first one is the password from the
		 * database and the second one is the password from the user input. If both
		 * passwords are the same return true otherwise return false.*/
		public Boolean validateUser(String passToValidate, String comparablePas) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
	
			try {
				conn = OracleConnection.getConnection();
			
				String sql = "SELECT * FROM STUDENT WHERE PASS=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, passToValidate);
				result = ps.executeQuery();
	
				if (passToValidate.equals(comparablePas)) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			return false;
		}
	}

