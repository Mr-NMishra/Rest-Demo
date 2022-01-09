package com.mishra.cltr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
				//here we are doing Class level mapping
@RequestMapping("Course")
public class CourseCltr {

				//now if /course url is called then this method is called
				//if all the method have same requestmapping then it will create ambiguity
	@RequestMapping
	public void m1() {
		System.out.println("----m1");
	}
	
			//where url Course/add is called then this method handler works
	@RequestMapping(value = "add")
	public void m2() {
		System.out.println("----m2");
	}
	@RequestMapping(value = "delete")
	public void m3() {
		System.out.println("----m3");
	}
	

}
