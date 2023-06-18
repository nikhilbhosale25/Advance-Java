package dao;

import java.util.List;

import pojos.CourseType;
import pojos.Student;

public interface StudentDao {

	String RgeisterStudent(Student std);
	
	String StudentLogin(String email,String Pass);
	
	List<Student> DisplayByCourse(CourseType course);
	
	String ChangeCourse(int id,CourseType course);
}
