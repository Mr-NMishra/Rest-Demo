package com.mishra.cltr;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mishra.entity.Course;
import com.mishra.service.CourseService;

@RestController
				/* this  @RestController is used to tell our front controller that
				 * every handler present inside this are Response body don't 
				 * consider as view*/
//@Controller
						// here we are doing Class level mapping
@RequestMapping("Course")
public class CourseCltr {
	@Autowired
	CourseService courseService;

	/*
	 * now if /course url is called then this method is called if all the method
	 * have same requestmapping then it will create ambiguity
	 */
	//@RequestMapping(method = RequestMethod.GET) // here we are telling to use get method
	@GetMapping
	/*
	 * this tag is used to tell that it just a response body not a view to our front
	 * controller as every string or object is considerd as view
	 */
	//@ResponseBody
	public void m1() {
		Course course = new Course();
		course.setCode("S103");
		course.setTitle("Core");
		course.setSubject("BackEnd-Programming");
		course.setFees(6000);
		courseService.createNewCourse(course);
	}

}
