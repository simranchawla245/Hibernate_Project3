package com.lti.Hib_ex3.Hibernate_Project3.Hibernate_Proj3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.util.EntityPrinter;

public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("persistence");
       EntityManager entityManager=entityManagerFactory.createEntityManager();
       System.out.println("starting transaction");
       entityManager.getTransaction().begin();
       Employe employee=new Employe();
       employee.setName("ashika");
       employee.setBranch("Delhi");
       System.out.println("saving employee to database");
       
       entityManager.persist(employee);
       entityManager.getTransaction().commit();
       System.out.println("Generated employee ID="+employee.getEmployeeId());
       
       Employe emp=entityManager.find(Employe.class, employee.getEmployeeId());
       System.out.println("got object"+emp.getName()+ " "+emp.getEmployeeId());
       @SuppressWarnings("unchecked")
       List<Employe> listEmployee=entityManager.createQuery("select e from Employe e").getResultList();
       
       if(listEmployee==null){
    	   System.out.println("No employee found");
       }else{
    	   for(Employe emp1:listEmployee){
    		   System.out.println("Employee name="+emp1.getName()+", Employee id=" +emp1.getEmployeeId());
   
    	   }
       }
       entityManager.close();
       entityManagerFactory.close();
    }
    
}
