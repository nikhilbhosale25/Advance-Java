package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.CourseType;
import pojos.Student;

public class StudentLoginTester {

	public static void main(String[] args) {
		
		try (SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			
			System.out.println("Enter email,password");
			System.out.println(dao.StudentLogin(sc.next(),sc.next()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
