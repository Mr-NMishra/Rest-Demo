package com.mishra.cltr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseCltr {

	@RequestMapping("course")
	public void Test() {
		System.out.println("---------");
	}
}
