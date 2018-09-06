package CoreJava.systemsInterfaces;

import java.sql.SQLException;
import java.util.List;

import CoreJava.Models.Instructor;

public interface InstructorDAOI {

	List<Instructor> getAllInstructors() throws SQLException;
	
	Instructor getInstructoByGmail(String email) throws SQLException;
	
}
