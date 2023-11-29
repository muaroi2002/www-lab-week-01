package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;
    public Connection(){
        emf = Persistence.createEntityManagerFactory("week_02");
    }
    public static Connection getInstance(){
        if(instance == null)
            instance = new Connection();
        return instance;
    }
    public EntityManagerFactory entityManagerFactory(){
        return emf;
    }
}
