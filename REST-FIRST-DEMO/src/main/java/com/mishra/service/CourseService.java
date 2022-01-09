package com.mishra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mishra.dAO.CourseDao;
import com.mishra.entity.Course;

@Service
public class CourseService {
	@Autowired
	private CourseDao courseDao;

	public Course createNewCourse(Course course) {
		return courseDao.addCourse(course);
	}
	
	public Course UpdateExistingCourse(Course course) {
		return courseDao.addCourse(course);
	}
	
	public Course deleteCourse(String code) {
		return courseDao.deleteCourse(code);
	}
	
	public List<Object> getAllCourses(){
		return courseDao.getCourseList();
	}
	
	public Course getSingleCourseByCode(String code) {
		return courseDao.getCourse(code);
	}
}
