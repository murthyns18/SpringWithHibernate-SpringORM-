package com.employee.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO
{
	private SessionFactory sessionFactory;


	@Autowired
	public EmployeeDAOImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Employee e) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(e);
		session.getTransaction().commit();
	}

	@Override
	public List<Employee> getAll() 
	{
		Session session = sessionFactory.openSession();
		return session.createQuery("from Employee").list();

	}

	@Override
	public void update(Employee e)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, e.getId());
		if(emp != null)
		{
			emp.setName(e.getName());
			emp.setDesg(e.getDesg());
			emp.setSalary(e.getSalary());
		}
		session.update(emp);
		session.getTransaction().commit();
	}

	@Override
	public void delete(int id) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		if(e != null)
		{
			session.delete(e);
		}
		session.getTransaction().commit();
	}

	public Employee fetchOne(int id) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee e1 = session.get(Employee.class, id);
		session.getTransaction().commit();
		return e1;
	}

}
