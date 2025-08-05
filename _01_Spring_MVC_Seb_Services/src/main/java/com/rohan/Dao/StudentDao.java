package com.rohan.Dao;

import com.rohan.Model.Student;
import com.rohan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    public void addStudent(Student student) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
    }
    public void updateStudent(Student student) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(student);
        transaction.commit();
        session.close();
    }
    public void deleteStudent(int id) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student=session.find(Student.class, id);
        session.remove(student);
        transaction.commit();
        session.close();
    }
    public Student getStudent(int id) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Student student=session.find(Student.class, id);
        session.close();
        return student;
    }
    public List<Student> getAllStudents() {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        List<Student> students=session.createQuery("from Student").list();
        session.close();
        return students;
    }

}
