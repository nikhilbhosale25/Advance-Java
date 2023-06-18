package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.CourseType;
import pojos.Student;
public class InsertStudent {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			
			System.out.println("Enter  firstName, lastName, email, password, course, dob");
			
			Student s=new Student(sc.next(),sc.next(),sc.next(),sc.next(),CourseType.valueOf(sc.next().toUpperCase()),LocalDate.parse(sc.next()));
			
			System.out.println(dao.RgeisterStudent(s));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
