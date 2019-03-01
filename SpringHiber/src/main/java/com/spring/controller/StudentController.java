package com.spring.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Address;
import com.spring.model.Credentials;
import com.spring.model.Student;
import com.spring.service.IStudentService;

@Controller
public class StudentController {
	@Autowired
	@Qualifier("studService")
	private IStudentService studservice;
	
	public void setServices(IStudentService services){
		this.studservice = services;
	}
	@RequestMapping("/index")
	public String setupForm(Map<String, Object>map){
		Student student = new Student();
		map.put("student",student);
		map.put("studentList",studservice.getAllStudents());
		return "student";
	}
	@RequestMapping("/indexAfterEdit")
	public String setupFormAfteredit(Map<String, Object>map,@RequestParam("id") int id){
		Student s=studservice.getStudent(id);
		map.put("student",s);
		map.put("studentList",studservice.getAllStudents());
		return "student";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id){
		studservice.delete(id);
		return "redirect:/index";
	}
	
	@RequestMapping("/DeleteAddress")
	public String deleteaddress(@RequestParam("aid") int aid,@RequestParam("sid") int sid){
		studservice.deleteaddress(aid);
		return "redirect:/addAddress?id="+sid;
	}
	@RequestMapping("/verifyUser")
	public String Authenticate(@RequestParam("userName") String userName,@RequestParam("pass") String password,@RequestParam("role") String role){
		Credentials c = studservice.authenticateUser(userName,password,role); 
		return "redirect:/index";
	}
	@RequestMapping("/login")
	public ModelAndView loginShow(){
		return new ModelAndView("Login");
	}
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student){
		studservice.add(student);
		return "redirect:/index";
	}
	@RequestMapping(value="/addAddress")
	public ModelAndView doActions(@RequestParam("id") int sid){
		 List<Address> AddList=studservice.getAddress(sid);
		return new ModelAndView("AddAddress","sid",sid).addObject("addressList",AddList);
	}
	@RequestMapping(value="/insertAdd")
	public String insertadd(@RequestParam("sid") int sid,Address a){
		Student s=studservice.getStudent(sid);
		studservice.addAddress(new Address(a.getStreet(),a.getLandmark(),a.getPincode(),s));
		return "redirect:/addAddress?id="+sid;
	}
	
}
