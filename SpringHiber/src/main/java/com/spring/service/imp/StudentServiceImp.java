package com.spring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.IStudentDao;
import com.spring.dao.imp.StudentDaoimp;
import com.spring.model.Address;
import com.spring.model.Credentials;
import com.spring.model.Student;
import com.spring.service.IStudentService;
import java.util.List;

@Service
public class StudentServiceImp implements IStudentService{

	IStudentDao dao;
	
	public IStudentDao getDao() {
		return dao;
	}

	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void add(Student s){
		dao.add(s);
	}
	@Transactional
	public void edit(Student s){
		dao.edit(s);
	}
	@Transactional
	public void delete(int id){
		dao.delete(id);
	}
	@Transactional
	public void deleteaddress(int aid){
		dao.deleteaddress(aid);;
	}
	@Transactional
	public Student getStudent(int id){
		return dao.getStudent(id);
	}
	@Transactional
	public List<Student> getAllStudents(){
		return dao.getAllStudents();
	}
	/*@Autowired(required=true)
	public void setStudentDao(IStudentDao Studentdao){
		this.Studentdao=Studentdao;
	}*/

	public Credentials authenticateUser(String userName, String password,String role) {
		return dao.authenticateUser(userName, password,role);
	}
	
	public void addAddress(Address a){
		dao.addAddress(a);
	}
	public List<Address> getAddress(int sid){
		return dao.getAddress(sid);
	}
	
}
