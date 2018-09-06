package CoreJava.systemsInterfaces;

import java.io.IOException;
import java.sql.SQLException;

import CoreJava.Models.Student;

public interface StudentDAOI {

	Student getStudentByGmail(String email) throws SQLException, ClassNotFoundException, IOException;
	
}
