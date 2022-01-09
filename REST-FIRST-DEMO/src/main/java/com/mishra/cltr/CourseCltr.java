package com.mishra.cltr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("Course")
public class CourseCltr {

	@RequestMapping
	public void m1() {
		System.out.println("----m1");
	}
	@RequestMapping(value = "add")
	public void m2() {
		System.out.println("----m2");
	}
	@RequestMapping(value = "delete")
	public void m3() {
		System.out.println("----m3");
	}
	

}
