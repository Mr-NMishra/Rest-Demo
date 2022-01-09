package com.mishra.dAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mishra.entity.Course;

@Repository
public class CourseDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	//adding or updating DTO
	public Course addCourse(Course course) {
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.saveOrUpdate(course);
		transaction.commit();
		session.close();
		return course;
	}
	
	//delete Course
	public Course deleteCourse(String code) {
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Course course=getCourse(code);
		session.delete(course);
		transaction.commit();
		session.close();
		return course;
	}
	
	//getting single course
	public Course getCourse(String code) {
		Session session= sessionFactory.openSession();
		Course course=session.get(Course.class, code);
		session.close();
		return course;
	}
	
	//getting list of all courses
	public List<Object> getCourseList(){
		Session session= sessionFactory.openSession();
		Query<Object> query= session.createQuery("From Course");
		List<Object> courseList= query.getResultList();
		session.close();
		return courseList;
		
	}
}
