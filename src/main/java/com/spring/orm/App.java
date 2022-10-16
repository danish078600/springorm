package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
					break;
				case 2:
					//display all stuent
					break;
				case 3:
					//display one student
					break;
				case 4:
					//delete student
					break;
				case 5:
					//update student
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
