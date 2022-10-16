package com.spring.orm.dao;

import java.util.List;

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
	
	//get the single object
	public Student getStudent(int studentId)
	{
		Student student =this.temp.get(Student.class, studentId);
		return student;
	}
	//get all rows
	public List<Student> getAllStudent()
	{
		List<Student> students=this.temp.loadAll(Student.class);
		return students;
	}
	//delete student
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student=this.temp.get(Student.class, studentId);
		this.temp.delete(student);
		
	}
	//update student
	@Transactional
	public void updateStudent(Student student)
	{
		this.temp.update(student);
	}
	public HibernateTemplate getTemp() {
		return temp;
	}
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	

}
