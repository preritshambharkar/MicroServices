package com.user.service.dao.daoImpl;

import com.user.service.entities.User;
import com.user.service.dao.UserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    private final String FETCH_ALL_USERS = "SELECT *  FROM USERS";

    @Override
    public List findAll() {
        Query q = entityManager.createNativeQuery(FETCH_ALL_USERS, User.class);
        return q.getResultList();
    }
}
