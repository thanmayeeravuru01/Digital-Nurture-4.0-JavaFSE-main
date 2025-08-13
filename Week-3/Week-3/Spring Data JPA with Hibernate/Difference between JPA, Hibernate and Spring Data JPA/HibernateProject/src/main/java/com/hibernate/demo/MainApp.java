package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.demo.model.Employee;
import com.hibernate.demo.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Bhavya");
        emp.setRole("Developer");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp);

        tx.commit();
        session.close();

       
        System.out.println("Employee inserted successfully!");
    }
}
