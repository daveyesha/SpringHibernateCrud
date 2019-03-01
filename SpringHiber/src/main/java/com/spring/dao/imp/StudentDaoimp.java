package com.spring.dao.imp;

import org.hibernate.Session;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.IStudentDao;
import com.spring.model.Address;
import com.spring.model.Credentials;
import com.spring.model.Student;


@Repository
public class StudentDaoimp implements IStudentDao {

SessionFactory sFactory;
	
	public SessionFactory getsFactory() {
		return sFactory;
	}
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}	
	@Transactional
	public void add(Student s){
		Session session=(Session) this.sFactory.getCurrentSession();
		session.save(s);
	}
	@Transactional
	public Credentials authenticateUser(String userName,String password,String role){
		Session session=this.sFactory.getCurrentSession();
		Query<Credentials> query = sFactory.getCurrentSession().createQuery("from Credentials where userName = :userName and password = :password and role= :role ");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		query.setParameter("role", role);
		Credentials credentials = query.uniqueResult();
		if(credentials!=null){
			return credentials;
		}
		return null;
	}
	
/*	@Transactional*/
	/*public void edit(Student s){
		Session session=this.sFactory.getCurrentSession().update(s);;
	}*/
	@Transactional
	public void delete(int id){
		Session session=this.sFactory.getCurrentSession();
		session.delete(getStudent(id));
	}
	public void deleteaddress(int aid){
		Session session=this.sFactory.getCurrentSession();
		session.delete(getAddressbyAID(aid));
	}
	
	@Transactional
	public Student getStudent(int id){
		Session session= sFactory.getCurrentSession();
		return (Student)session.get(Student.class, id);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> getAllStudents(){
		 Session session=this.sFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		List<Student> data=session.createQuery("from Student").list();
		return data;
	}
	@Transactional
	public List<Address> getAddress(int sid){
		 Session session=this.sFactory.getCurrentSession();
		 Query query = sFactory.getCurrentSession().createQuery("from Address where userid = :sid ");
			query.setParameter("sid", sid);
			
		 @SuppressWarnings("deprecation")
		List<Address> data=query.list();

		return data;
	}
	@Transactional
	public Address getAddressbyAID(int aid){
		Session session= sFactory.getCurrentSession();
		return (Address)session.get(Address.class, aid);
		}
	@Transactional
	public void addAddress(Address a){
		Session session=(Session) this.sFactory.getCurrentSession();
		session.save(a);
	}
	public void edit(Student s) {
		// TODO Auto-generated method stub
		
	}



}
