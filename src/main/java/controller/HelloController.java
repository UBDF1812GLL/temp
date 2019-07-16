package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public void hello() {
		System.out.println("haha spring mvc");
	}
	
	@RequestMapping("/aaabbb")
	public void testasfafd() {
		System.out.println("hello uek");
	}
	
	@RequestMapping("/hi")
	public void add(HttpServletRequest req,HttpServletResponse resp) {
		String value = req.getParameter("uek");
		System.out.println(value);
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "{name:'zs'}";
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
