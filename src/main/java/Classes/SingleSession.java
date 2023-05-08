/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marcr
 */
public class SingleSession {

    private static SingleSession instancia;
    private SessionFactory factory, f2;
    private Session s;

    private SingleSession() {
        InitSessionFactory();
    }

    public static SingleSession getInstance() {
        if (instancia == null) {
            instancia = new SingleSession();
        }

        return instancia;
    }

    /**
     * *
     * Punt on es configura hibernate
     */
    private void InitSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // Just en aquest punt, podem modificar els valors per defecte i assignar-ne d'altres
        // Aquesta és la llista de propietats disponibles: https://docs.jboss.org/hibernate/orm/4.3/javadocs/
        configuration.setProperty("hibernate.connection.username", "Marc");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/recuperacio?createDatabaseIfNotExist=true");

        try {
            this.factory = configuration.buildSessionFactory();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        // en aquest punt una sessió
        s = f2.openSession();

    }

    /**
     * *
     * Retorna la mateixa sessió
     *
     * @return
     */
    public Session getSessio() {

        return s;
    }

    public void closeFactory() {
        factory.close();
    }
}
