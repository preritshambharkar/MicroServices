package com.car.service.dao.daoImpl;

import com.car.service.dao.VehiclesDao;
import com.car.service.entities.Vehicles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VehiclesDaoImpl implements VehiclesDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Vehicles getCarDetails(String carId) {
        return null;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        List l = session.createQuery("FROM Vehicles", Vehicles.class).getResultList();
        return null;
    }
}
