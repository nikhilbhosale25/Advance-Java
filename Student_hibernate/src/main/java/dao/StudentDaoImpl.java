package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.CourseType;
import pojos.Student;

public class StudentDaoImpl implements StudentDao{

	public String RgeisterStudent(Student std) {
		// TODO Auto-generated method stub
		
		String msg="Student Not Added..Failed!!!!!!!!";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			session.save(std);
			
			tx.commit();
			msg="Stdent Added Sucessfully"+ std.getId();
			
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	public String StudentLogin(String email,String Pass)
	{
		String msg="Student Login failed";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			String jpql="select e from Student e where e.email=:em and e.password=:pass";
			
			Student Std=session.createQuery(jpql,Student.class)
			.setParameter("em", email)
			.setParameter("pass", Pass)
			.getSingleResult();
			
			tx.commit();
			msg="Student Login successfull  "+Std.getId();
			
			
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	public List<Student> DisplayByCourse(CourseType course)
	{
		List<Student> Students=null;
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			String jpql="select e from Student e where e.course=:course";
			
			Students=session.createQuery(jpql,Student.class)
			.setParameter("course", course)
			.getResultList();
			
			
			tx.commit();
			
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return Students;
		
	}
	
	public String ChangeCourse(int id,CourseType course)
	{
		String msg="Updation Failed!!!";
		Session session=getFactory().getCurrentSession();
		Student std=null;
		Transaction tx=session.beginTransaction();
		
		try {
			
			std=session.get(Student.class, id);
			std.setCourse(course);
			tx.commit();
			msg="Coruse of "+std.getFirstName()+" Successfully Chnanged to "+std.getCourse();
		}catch (RuntimeException e) {
			
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
		
	}
	
}
