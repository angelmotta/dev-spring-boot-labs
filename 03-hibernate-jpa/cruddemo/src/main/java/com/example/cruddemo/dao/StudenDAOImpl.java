package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudenDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // Constructor injection
    @Autowired
    public StudenDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
        TypedQuery<Student> myQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // return results from query
        return myQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create Query
        TypedQuery<Student> myQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theParam", Student.class);

        // Set query parameters
        myQuery.setParameter("theParam", theLastName);

        // return results from query
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
