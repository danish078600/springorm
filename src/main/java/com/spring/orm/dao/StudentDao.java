package com.spring.orm.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate temp;
	@Transactional
	public int insert(Student student)
	{
		//insert
		Integer i =(Integer) this.temp.save(student);
		return i;
	}
	public HibernateTemplate getTemp() {
		return temp;
	}
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	

}
