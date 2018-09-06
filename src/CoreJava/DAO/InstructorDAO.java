package CoreJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Instructor;
import CoreJava.systemsInterfaces.InstructorDAOI;

public class InstructorDAO implements InstructorDAOI {

	/*
	 * getAllInstructors – This method takes no parameter and returns every
	 * Instructor in the database.
	 */
	public List<Instructor> getAllInstructors() throws SQLException {
		List<Instructor> arr = new ArrayList<>();
		Instructor instructor = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT * FROM INSTRUCTOR";
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()) {
				instructor = new Instructor();
				instructor.setInstructor_id(result.getInt(1));
				instructor.setFull_name(result.getString(2));
				instructor.setEmail(result.getString(3));
				instructor.setSpeciality(result.getString(4));
				instructor.setAdmin_role(result.getInt(5));
				arr.add(instructor);
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
		return arr;
	}

	/*
	 * getInstructoByGmail– This method takes a String as a parameter and queries
	 * the database for an Instructor with such an email and returns an Instructor
	 * Object.
	 */
	public Instructor getInstructoByGmail(String email) throws SQLException {
		Connection conn = null;
		Instructor instructor = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			conn = OracleConnection.getConnection();
			instructor = new Instructor();
			String sql = "SELECT * FROM INSTRUCTOR WHERE EMAIL=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			result = ps.executeQuery();

			while (result.next()) {
				instructor.setInstructor_id(result.getInt(1));
				instructor.setFull_name(result.getString(2));
				instructor.setEmail(result.getString(3));
				instructor.setSpeciality(result.getString(4));
				instructor.setAdmin_role(result.getInt(5));
				instructor.setPass(result.getString(6));
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
		return instructor;
	}

	/*
	 * validateUser – This method takes two arguments: an instructor object with all
	 * its information and a String which represent the password entered by the user
	 * trying to login as an instructor. This returns “Wrong Credentials”, “Admin”
	 * or “Instructor”.
	 */
	public String validateUser(Instructor ins, String comparablePas) throws SQLException {
//		Instructor instructor = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		String answer = "";

		try {
			conn = OracleConnection.getConnection();
//			instructor = new Instructor();
			String sql = "SELECT * FROM INSTRUCTOR WHERE PASS=?";
			ps = conn.prepareStatement(sql);
			String insPass = ins.getPass();
			ps.setString(1, insPass);
			result = ps.executeQuery();
			
			if (result.next()) {
			if (insPass.equals(comparablePas) && ins.getAdmin_role() == 1) {
				answer = "Admin";
			} else if (insPass.equals(comparablePas) && ins.getAdmin_role() == 0) {
				answer = "Instructor";
			} else if (!insPass.equals(comparablePas)) {
				answer = "Wrong Credentials";
			}
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
		return answer;
	}
}
