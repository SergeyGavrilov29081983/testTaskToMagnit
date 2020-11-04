package ru.repository;

import org.hibernate.Session;
import ru.model.Model;
import ru.util.HibernateSessionFactory;
import ru.util.Util;

import java.util.List;

public class Repository {

    public void deleteAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from Model").executeUpdate();
        session.close();
    }

    public void saveAll(int n) {
        List<Model> list = Util.createModels(n);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        for (Model model : list) {
            session.save(model);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Model> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> result = session.createQuery("select f from Model f", Model.class).getResultList();
        session.close();
        return result;
    }
}
