package com.employee.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.daoimpl.EmployeeDAOImpl;
import com.employee.entity.Employee;

public class App 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("beans.xml");

		SessionFactory bean = (SessionFactory) cx.getBean("sessionfactory");

		Session session = bean.openSession();

		Transaction t = (Transaction) session.beginTransaction();

		EmployeeDAOImpl empdao = (EmployeeDAOImpl) cx.getBean("employeeDAOImpl");
		
		
		//Insertion
//		Employee e = new Employee(5, "Manu", "Sales", 455555);
//		empdaoimpl.insert(e);
		
//		Fetch All
		List<Employee> list = empdao.getAll();
		for(Employee l : list)
		{
			System.out.println(l.getId()+" "+l.getName()+" "+l.getDesg()+" "+l.getSalary());
		}
//		
//		Employee e1 = empdao.fetchOne(2);
//		System.out.println(e1);
		
		//Updating
//		Employee e = new Employee(5,"Venky", "Dev", 40000);
//		empdao.update(e);
		
		//Deleting
//		empdao.delete(3);
		

	}
}
