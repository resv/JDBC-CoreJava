package CoreJava.MainEntryPoint;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.InstructorDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.DAO.TeachingDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;
import CoreJava.Models.Student;
import CoreJava.Models.Teaching;



public class MainEntryClass
{
	
//////////////////////////////////////// TESTING /////////////////////////////////////////////////////////////////
	
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//
//		// TESTING QUERY FROM STUDENTS (ID) WORKS!
//		System.out.println("testing console");
//
//		// TESTING CONNECTION
//		Connection conn = OracleConnection.getConnection();
//		String sql = "SELECT * FROM STUDENT";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ResultSet results = ps.executeQuery();
//
//		/*
//		 * 1 is the first column, change number for next column, this is because we
//		 * queried for *.GETTING RESULTS SETS ARE PERTAINING TO VIEWS, if views have
//		 * more than one column then changing the 1 to another number will get that
//		 * respective column if we change * to a specific column name we will get that
//		 * returned, and the value 1 becomes views
//		 */
////		ps.setInt(1, id);
//
//		while (results.next()) {
//			System.out.println(results.getString(1));
//		}
//
//		/*
//		 * UNCOMMENT METHODS BELOW TO TEST EACH METHOD, METHOD WILL RETURN MEMORY
//		 * ADDRESS, YOU MUST RUN DEBUGGER AND CONFIRM THAT THE VALUES ARE CORRECT IN
//		 * EACH OBJECT/LIST BEING RETURNED
//		 */
//
////		vgetStudentByGmail("b@gmail.com"); // tested and works with other student emails
////		vvalidateUser("111", "111"); //false also works by changing the 2nd parameter to not match
////		vgetAllInstructors(); //returns list array with all instructor objects
////		vgetInstructoByGmail("lance@gmail.com"); //returns instructor object based on email in param
////		vgetValidateUser(ins , "555"); NOT SURE HOW TO TEST THIS BECAUSE I DON'T know how to fit instructor object in param
////		vgetAllCourses();
////		vgetCourseByInstructor(3);
//
////		vgetStudentCourse(3);// returns attending constructor which was joined from attending,student, and course in sql
//
////		vgetInstructorsCourses();
////		vregisterStudentToCourse(Student student, Course course); // can't test in debugger because I cannot manually insert object
////		vassignInstructorToCourse(3, 3); returns key, assignes instrucID and courseID to teaching. can't test
//	}
//
//	/*
//	 * getStudentCourse – This method takes as a parameter a int student_id and
//	 * would query the database for all the courses a student is register base on
//	 * the Id
//	 */
////TESTING FOR ATTENDING CONSTRUCTOR, QUERY FROM SQL JOINED ATTENDING/COURSE/STUDENT	
//	private static List<Attending> vgetStudentCourse(int i) throws SQLException {
//		List<Attending> attendingCourse = new ArrayList<Attending>();
//		Attending attending = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT c.COURSE_NAME, s.FULL_NAME , s.EMAIL\r\n" + "FROM COURSE c\r\n"
//					+ "JOIN ATTENDING a ON a.COURSE_ID=c.COURSE_ID\r\n"
//					+ "JOIN STUDENT s ON s.STUDENT_ID=a.STUDENT_ID\r\n" + "WHERE s.STUDENT_ID =?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, i);
//			result = ps.executeQuery();
//			while (result.next()) {
//				attending = new Attending();
//				attending.setCourse_name(result.getString(1));
//				attending.setFull_name(result.getString(2));
//				attending.setEmail(result.getString(3));
//				attendingCourse.add(attending);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println(attendingCourse);
//		return attendingCourse;
//	}
//
//	// TESTING QUERY FOR STUDENT BY EMAIL, DEBUGGED AND WORKS!
//	public static Student vgetStudentByGmail(String email) throws ClassNotFoundException, IOException, SQLException {
//
//		Student student = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			/* Connection */ conn = OracleConnection.getConnection();
//			student = new Student();
//			String sql = "SELECT * FROM STUDENT WHERE email = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			/* ResultSet */ result = ps.executeQuery();
//
//			if (result.next()) {
//				student.setStudent_id(result.getInt(1));
//				student.setFull_name(result.getString(2));
//				student.setEmail(result.getString(3));
//				student.setGpa(result.getInt(4));
//				student.setPass(result.getString(5));
//				student.setStudent_role(result.getInt(6));
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println(student);
//		return student;
//	}
//
////TESTING IF PASSWORD RETURNS BOOL! DEBUGGED AND WORKS!!!!
//	public static Boolean vvalidateUser(String passToValidate, String comparablePas) throws SQLException {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT * FROM STUDENT WHERE PASS=?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, passToValidate);
//			result = ps.executeQuery();
//
//			if (passToValidate.equals(comparablePas)) {
//				System.out.println(passToValidate + " matches!!! " + comparablePas);
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println("false!!");
//		return false;
//	}
//
////TESTING IF GET ALL INSTRUCTORS! DEBUGGED AND WORKS!!!
//	private static List<Instructor> vgetAllInstructors() throws SQLException {
//		List<Instructor> arr = new ArrayList<>();
//		Instructor instructor = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT * FROM INSTRUCTOR";
//			ps = conn.prepareStatement(sql);
//			result = ps.executeQuery();
//			while (result.next()) {
//				instructor = new Instructor();
//				instructor.setInstructor_id(result.getInt(1));
//				instructor.setFull_name(result.getString(2));
//				instructor.setEmail(result.getString(3));
//				instructor.setSpeciality(result.getString(4));
//				instructor.setAdmin_role(result.getInt(5));
//				arr.add(instructor);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println("this is suppose to return all instructors");
//		System.out.println(arr);
//		return arr;
//	}
//
////TESTING IF EMAIL PARAM RETURNS INSTRUCTOR OBJECT AND WORKS!!!
//	private static Instructor vgetInstructoByGmail(String email) throws SQLException {
//		Connection conn = null;
//		Instructor instructor = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			instructor = new Instructor();
//			String sql = "SELECT * FROM INSTRUCTOR WHERE EMAIL=?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			result = ps.executeQuery();
//
//			if (result.next()) {
//				instructor.setInstructor_id(result.getInt(1));
//				instructor.setFull_name(result.getString(2));
//				instructor.setEmail(result.getString(3));
//				instructor.setSpeciality(result.getString(4));
//				instructor.setAdmin_role(result.getInt(5));
//				instructor.setPass(result.getString(6));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println("This is suppose to print out instructor object");
//		return instructor;
//	}
//
////TESTING, GRABS OBJECT INSTRUCTOR AND PASS THEN RETURNS admin/instructor/wrong CANNOT TEST ATM	
//	String vvalidateUser(Instructor ins, String comparablePas) throws SQLException {
//		Connection conn = null;
//		Instructor instructor = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		String answer = "";
//
//		try {
//			conn = OracleConnection.getConnection();
//			instructor = new Instructor();
//			String sql = "SELECT * FROM INSTRUCTOR WHERE PASS=?";
//			ps = conn.prepareStatement(sql);
//			String insPass = ins.getPass();
//			ps.setString(1, insPass);
//			result = ps.executeQuery();
//
//			if (insPass.equals(comparablePas) && ins.getAdmin_role() == 1) {
//				answer = "Admin";
//			} else if (insPass.equals(comparablePas) && ins.getAdmin_role() == 0) {
//				answer = "Instructor";
//			} else if (!insPass.equals(comparablePas)) {
//				answer = "Wrong Credentials";
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return answer;
//	}
//
////TESTING QUERY TO GET ALL COURSES! DEBUGGED AND WORKS!!!
//	private static List<Course> vgetAllCourses() throws SQLException {
//		List<Course> courses = new ArrayList<Course>();
//		Course course = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT * FROM COURSE";
//			ps = conn.prepareStatement(sql);
//			result = ps.executeQuery();
//
//			while (result.next()) {
//				course = new Course();
//				course.setCourse_id(result.getInt(1));
//				course.setCourse_name(result.getString(2));
//				course.setMinimum_gpa(result.getDouble(3));
//				courses.add(course);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//
//		}
//		System.out.println(courses);//
//		return courses;
//	}
//
////TESTING QUERY COURSE BY INSTRUCTOR ID! DEBUGGED AND WORKS!!
//	private static List<Course> vgetCourseByInstructor(int i) throws SQLException {
//		List<Course> courses = new ArrayList<Course>();
//		Course course = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT c.COURSE_NAME " + "FROM COURSE c " + "JOIN TEACHING t ON c.COURSE_ID=t.COURSE_ID "
//					+ "JOIN INSTRUCTOR i ON i.INSTRUCTOR_ID=t.INSTRUCTOR_ID " + "WHERE i.INSTRUCTOR_ID =?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, i);
//			result = ps.executeQuery();
//
//			while (result.next()) {
//				course = new Course();
//				course.setCourse_name(result.getString(1));
//				courses.add(course);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println(courses);
//		return courses;
//	}
//
//// TESTING QUERY FOR TEACHING CONSTRUCTOR! DEBUGGED AND WORKS!
//	private static List<Teaching> vgetInstructorsCourses() throws SQLException {
//
//		List<Teaching> teachingList = new ArrayList<Teaching>();
//		Teaching teaching = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "SELECT c.COURSE_NAME, c.MINIMUN_GPA, i.FULL_NAME , i.EMAIL\r\n" + "FROM COURSE c\r\n"
//					+ "JOIN TEACHING t ON c.COURSE_ID=t.COURSE_ID\r\n"
//					+ "JOIN INSTRUCTOR i ON i.INSTRUCTOR_ID=t.INSTRUCTOR_ID";
//			ps = conn.prepareStatement(sql);
//			result = ps.executeQuery();
//
//			while (result.next()) {
//				teaching = new Teaching();
//				teaching.setCourse_name(result.getString(1));
//				teaching.setMinimum_gpa(result.getDouble(2));
//				teaching.setFull_name(result.getString(3));
//				teaching.setEmail(result.getString(4));
//				teachingList.add(teaching);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		System.out.println("returned teachingList, check debugger");
//		return teachingList;
//	}
//
////TESTING FOR STUDENT REGISTRATION FOR A COURSE CAN'T TEST due to object insertion
//	private static int vregisterStudentToCourse(Student student, Course course) throws SQLException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//		int key = 0;
//		try {
//			if (student.getGpa() < course.getMinimum_gpa()) {
//				throw new StudentRegistrationException(
//						"Did not meet the minimum GPA requirements, Registration DENIED");
//			} else {
//				conn = OracleConnection.getConnection();
//				String sql = "INSERT INTO ATTENDING(COURSE_ID,STUDENT_ID) VALUES(?,?)";
//				ps = conn.prepareStatement(sql);
//				ps.setInt(1, student.getStudent_id());
//				ps.setInt(2, course.getCourse_id());
//
//				ps.executeUpdate();
//
//				result = ps.getGeneratedKeys();
//				if (result.next()) {
//					key = result.getInt(1);
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return key;
//	}
////TESTING TO INSERT INSTRUCTOR AND A COURSE INTO ATTENDING // CAN'T TEST due to object insertion
//	private static int vassignInstructorToCourse(int i, int j) throws SQLException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet result = null;
//		int key = 0;
//
//		try {
//			conn = OracleConnection.getConnection();
//			String sql = "INSERT INTO TEACHING(COURSE_ID,INSTRUCTOR_ID) VALUES(?,?)";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, i);
//			ps.setInt(2, j);
//
//			ps.executeUpdate();
//
//			result = ps.getGeneratedKeys();
//			if (result.next()) {
//				key = result.getInt(1);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (result != null) {
//				result.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return key;
//	}
//
//}// main end

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    //Seesion ONE
//    public static void main(String[] args) throws ClassNotFoundException, IOException {
//       
//    }
//    ================================================================================================================================
//    =====================================================     Seperator      =======================================================
//    ================================================================================================================================
    public void allIntructors() throws ClassNotFoundException, IOException, SQLException {
        InstructorDAO insDAO = new InstructorDAO();
        
        List<Instructor> allIns = insDAO.getAllInstructors();
        System.out.printf("\nInstructors:\n======================================================================\n");
        System.out.printf("%-3s INTRUCTOR NAME \t INSTRUCTOR EMAIL \t INSTRUCTOR SPECIALITY\n","ID");
        
        for(Instructor insAGN : allIns) {
            System.out.printf("%-3s %-20s %-23s %s\n",insAGN.getInstructor_id(),  insAGN.getFull_name(), insAGN.getEmail(), insAGN.getSpeciality());
        }
        
    }
    
    public void allCourse() throws ClassNotFoundException, IOException, SQLException {
        CourseDAO coDAO = new CourseDAO();
        
        List<Course> allCo = coDAO.getAllCourses();
        System.out.printf("\nCourses:\n===============================================\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        
        for(Course coAGN : allCo) {
            System.out.printf("%-3s %-20s %s\n",coAGN.getCourse_id(),  coAGN.getCourse_name(), coAGN.getMinimum_gpa());
        }
        
    }
    
    public void allCoursesWithInstructor() throws SQLException {
        TeachingDAO teaDAO = new TeachingDAO();
        List<Teaching> teaList = teaDAO.getInstructorsCourses();
        System.out.printf("COURSE NAME \t COURSE MINIMUN GPA \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n\n");
        for(Teaching teaAGN : teaList) {
            System.out.printf("%-16s %-23s %-23s %s\n", teaAGN.getCourse_name(), teaAGN.getMinimum_gpa(), 
                    teaAGN.getFull_name(), teaAGN.getEmail());
        }
    }
    
    public void StudentCourses(List<Attending> attList) {
        int counter = 1;
        System.out.printf("\nMy Classes:\n");
        System.out.printf("%-3s COURSE NAME \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n", "#");
        for(Attending att : attList) {
            System.out.printf("%-3s %-20s %-23s %s\n", counter, att.getCourse_name(), att.getFull_name(), att.getEmail());
            counter++;
            
        }
    }
    
    public void allCourses(List<Course> coList) {
        int counter = 1;
        System.out.printf("\nAll Courses:\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        for(Course co : coList) {
            System.out.printf("%-3s %-20s %s\n", counter, co.getCourse_name(), co.getMinimum_gpa());
            counter++;
        }
    }
    
    @SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws ClassNotFoundException, IOException, StudentRegistrationException, SQLException {
        boolean quit = false;
        Scanner reader = new Scanner(System.in);
        MainEntryClass mainObj = new MainEntryClass();
        int InsOrStu = -1;
        Instructor ins = null;  InstructorDAO insDAO = null;   String insROLE = "";
        
        
        Student stu = null;     StudentDAO stuDAO = null;
        
        Course co = null;       CourseDAO coDAO = null;
        
        Attending att = null;   AttendingDAO attDAO = null;
        
        Teaching tea = null;    TeachingDAO teaDAO = null;
        
        String email = "";
        String password = "";
        while(!quit) {
            System.out.println("Are you a(n)\n1. Instructor \n2. Student \n3. quit \nPlease, enter 1, 2 or 3 \n");
            InsOrStu = reader.nextInt();
            if(InsOrStu == 1) {
                boolean logout = false;
                while(!logout) {
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    insDAO = new InstructorDAO();
                    ins = insDAO.getInstructoByGmail(email);
                    
                    insROLE = insDAO.validateUser(ins, password);
                    
                    
                    if("Admin".equals(insROLE)) {
                        teaDAO = new TeachingDAO();
                        mainObj.allCoursesWithInstructor();
                        String out = "-1";
                        while(!out.equals("2")) {
                            System.out.printf("\n\n");
                            System.out.println("1. Assign Instructor to Course");
                            System.out.println("2. Logout");
                            out = reader.next();  
                            
                            if(out.equals("1")) {
                                int instructor_id = -1;
                                int course_id = -1;
                                mainObj.allIntructors();
                                System.out.println("\nWhat Instructor?\n");
                                instructor_id = reader.nextInt();
                                mainObj.allCourse();
                                System.out.println("\nWhich Course?\n");
                                course_id = reader.nextInt();
                                int assignId =  teaDAO.assignInstructorToCourse(course_id, instructor_id);
                                if(assignId != -1) {
                                    System.out.println("\n -->Instructor Assigned<--\nNew Record Id: "+ assignId+"\n");
                                }
                                mainObj.allCoursesWithInstructor();
                            }
                        }
                        System.out.printf("\n\n");
                        logout = true;
                    }else if("Instructor".equals(insROLE)) {
                        coDAO = new CourseDAO();
                        List<Course> coList = coDAO.getCourseByInstructor(ins.getInstructor_id());
                        System.out.printf("COURSE NAME \t COURSE MINIMUN GPA\n");
                        for(Course insCO : coList) {
                            System.out.printf("%s \t\t %s\n", insCO.getCourse_name(), insCO.getMinimum_gpa());
                        }
                        String out = "-1";
                        while(!out.equals("1")) {
                            System.out.println("1. Logout");
                            out = reader.next();  
                        }
                        ins = null;
                        logout = true;
                    }else if("Wrong Credentials".equals(insROLE)) {
                        System.out.println(insROLE);
                        continue;
                    }
                
                }
                
            }else if(InsOrStu == 2) {
                stuDAO = new StudentDAO();
                attDAO = new AttendingDAO();
                boolean logout = false;
                while(!logout) {
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    
                    List<Attending> attList = null;
                    stu = stuDAO.getStudentByGmail(email);
                    
                    if(stu != null && stu.getStudent_role() == -1 && stuDAO.validateUser(stu.getPass(), password)) {
                        
                        String classesTo = "";
                        while(!classesTo.equals("2")) {
                            attList = attDAO.getStudentCourse(stu.getStudent_id());
                            mainObj.StudentCourses(attList);
                            System.out.printf("\n1. Register to Class");
                            System.out.printf("\n2. Logout\n");
                            classesTo = reader.next();
                            if(classesTo.equals("1")) {
                                coDAO = new CourseDAO();
                                attDAO = new AttendingDAO();
                                List<Course> coList = coDAO.getAllCourses();
                                mainObj.allCourses(coList);
                                System.out.println("\nWhich Course?\n");
                                int course_idForStudent = reader.nextInt();
                                attDAO.registerStudentToCourse(stu, coList.get(course_idForStudent - 1));
                                classesTo = "";
                            }
                        }
                        logout = true;
                    }else {
                        System.out.printf("\nWrong Credentials\n");
                        continue;
                    }
                }
                
            }else if(InsOrStu == 3) {
                quit = true;
            }
        }
        
    }
}
