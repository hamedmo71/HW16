package ir.maktab74.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {

    private static EntityManagerFactory emf;

    private HibernateUtil() {
    }

    public static synchronized EntityManagerFactory getEntityManagerFactory(){
        if(emf ==null){
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }
}
