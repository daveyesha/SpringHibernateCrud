package com.spring.service;

import com.spring.model.Address;
import com.spring.model.Credentials;
import com.spring.model.Student;
import java.util.List;

public interface IStudentService {
	public void add(Student s);
	public void edit(Student s);
	public void delete(int id);
	public Student getStudent(int id);
	public List<Student> getAllStudents();
	
	public Credentials authenticateUser(String userName,String password,String role);
	public void addAddress(Address a);
	public List<Address> getAddress(int sid);
	public void deleteaddress(int aid);
}
