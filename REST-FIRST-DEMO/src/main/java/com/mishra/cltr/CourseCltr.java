package com.mishra.cltr;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mishra.entity.Course;
import com.mishra.service.CourseService;

@RestController
@RequestMapping("Course")
public class CourseCltr {
	@Autowired
	CourseService courseService;

	//Getting list of Courses in Json format
	@GetMapping(value = "/list/json" ,produces = "application/json")
	public List<Object> getCourseListJson(){
		return courseService.getAllCourses();
	}
	
	//Getting Course in XML format
	@GetMapping(value = "/xml/{code}" ,produces = "application/xml")
	public Course getCourseXml(@PathVariable("code") String code) {
		return courseService.getSingleCourseByCode(code);
	}
	
	//Getting COurse in Json format 
					//attribute produces is used for type of result we want
	@GetMapping(value = "/json/{code}", produces = "application/json")
	public Course getCourseJson(@PathVariable("code")String code) {
		return courseService.getSingleCourseByCode(code);
	}
	
	// Getting course in string format
	/*
	 * here {code} --anything written between {} considered as PlaceHolder we can
	 * use this value by @PathVariable
	 */
	@GetMapping(value = "text/{code}")	
	public String getCourse(@PathVariable("code")String code) {
		Course course= courseService.getSingleCourseByCode( code);
		return course.toString();
	}
}
