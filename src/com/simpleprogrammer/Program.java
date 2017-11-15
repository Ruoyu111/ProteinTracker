package com.simpleprogrammer;

import org.hibernate.Session;

public class Program {
    
    public static void main(String[] args) {
        System.out.println("Hello world.");
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        UsersEntity user = new UsersEntity();
        user.setName("Joe");
        user.setGoal(250);
        session.save(user);

        session.getTransaction().commit();

        session.beginTransaction();

        UsersEntity loadedUser = (UsersEntity) session.get(UsersEntity.class, 1);
//        UsersEntity loadedUser = (UsersEntity) session.load(UsersEntity.class, 1);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getGoal());

        loadedUser.setTotal(loadedUser.getTotal() + 50);

        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}
