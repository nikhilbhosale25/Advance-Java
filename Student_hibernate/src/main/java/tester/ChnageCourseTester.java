package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.CourseType;

public class ChnageCourseTester {

	public static void main(String[] args) {
		
		try (SessionFactory sf=getFactory();
				Scanner sc=new Scanner (System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println("Enter id to change course with new course name: ");
			System.out.println(dao.ChangeCourse(sc.nextInt(),CourseType.valueOf(sc.next().toUpperCase())));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
