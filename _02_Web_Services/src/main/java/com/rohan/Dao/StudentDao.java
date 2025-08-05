package com.rohan.Dao;
import com.rohan.util.hibernateUtil;

import com.rohan.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    public void addStudent(Student student){

        SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(student);

        transaction.commit();
        session.close();

    }
    public void UpdateStudent(Student student){
        SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.merge(student);

        transaction.commit();
        session.close();
    }
    public void deleteStudent(int id){
        SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.remove(id);

        transaction.commit();
        session.close();
    }
    public Student getStudent(int id){
        SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();

        Student student=session.find(Student.class,id);

        return student;
    }
    public List<Student> getStudents(){
        SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        List<Student> students=session.createQuery("from Student").list();
        return students;
    }

}
