package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.CourseType;
import pojos.Student;
public class DisplaybycourseTester {

	public static void main(String[] args) {
		List<Student> studs=null;
		try (SessionFactory sf=getFactory();
				Scanner sc=new Scanner (System.in)){
			
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println("Enter Corse");
			
			studs=dao.DisplayByCourse(CourseType.valueOf(sc.next().toUpperCase()));
			
			for(Student s: studs)
			{
				System.out.println(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
