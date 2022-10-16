package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//        Student s=new Student(111,"danish","muzaffarpur");
//        int r=studentDao.insert(s);
//        System.out.println(r +" line added");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press 1 for add new student");
        System.out.println("press 2 for display all student");
        System.out.println("press 3 for get detail of single student");
        System.out.println("press 4 for delete student");
        System.out.println("press 5 for update student");
        System.out.println("press 6 for exit");
        boolean go=true;
        while(go)
        {
        	try {
        		int choice=Integer.parseInt(br.readLine());
        		
        		switch (choice) {
				case 1:
					//add new student
					System.out.println("Enter student id");
					int id=Integer.parseInt(br.readLine());
					
					System.out.println("Enter Student name");
					String name=br.readLine();
					
					System.out.println("Enter student city");
					String city=br.readLine();
					
					Student s=new Student();
					s.setId(id);
					s.setName(name);
					s.setCity(city);
					
					int r=studentDao.insert(s);
					System.out.println(r+" student added");
					System.out.println("=============");
					System.out.println();
					break;
				case 2:
					//display all stuent
					List<Student> allStudents=studentDao.getAllStudent();
					System.out.println("=================");
					for (Student student : allStudents) {
						System.out.println("id "+ student.getId());
						System.out.println("Name "+ student.getName());
						System.out.println("City"+ student.getCity());
						System.out.println("---------------");
					}
					System.out.println("===================");
					break;
				case 3:
					//display one student
					System.out.println("enter student id");
					int id1=Integer.parseInt(br.readLine());
					Student student=studentDao.getStudent(id1);
					System.out.println("id "+ student.getId());
					System.out.println("Name "+ student.getName());
					System.out.println("City"+ student.getCity());
					System.out.println("---------------");
					break;
				case 4:
					//delete student
					System.out.println("enter student id");
					int id11=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id11);
					System.out.println("student deleted");
					break;
				case 5:
					//update student
					System.out.println("Enter student id");
					int idd=Integer.parseInt(br.readLine());
					
					System.out.println("Enter Student name");
					String namee=br.readLine();
					
					System.out.println("Enter student city");
					String cityy=br.readLine();
					
					Student ss=new Student();
					ss.setId(idd);
					ss.setName(namee);
					ss.setCity(cityy);
					studentDao.updateStudent(ss);
					System.out.println("student details updated");
					
					break;
				

				case 6:
					//exit
					go=false;
					break;
        		}
			} catch (Exception e) {
				System.out.println("invalid input try another input");
			}
        }
    }
}
