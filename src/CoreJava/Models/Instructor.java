package CoreJava.Models;

public class Instructor {

	//VARIABLES
	private int instructor_id;
	private String full_name;
	private String email;
	private String speciality;
	private int admin_role;
	private String pass;
	
	//DEFAULT CONSTRUCTOR
	public Instructor() {
	}
	
	//CONSTRUCTOR WITH FIELDS
	public Instructor(int instructor_id, String full_name, String email, String speciality, int admin_role,
			String pass) {
		super();
		this.instructor_id = instructor_id;
		this.full_name = full_name;
		this.email = email;
		this.speciality = speciality;
		this.admin_role = admin_role;
		this.pass = pass;
	}
	//GETTERS AND SETTERS
	public int getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(int admin_role) {
		this.admin_role = admin_role;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
