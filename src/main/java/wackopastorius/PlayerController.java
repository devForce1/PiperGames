package wackopastorius;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class PlayerController {

    public PlayerController() {
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    public boolean addPlayer(Player player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;
        try {
            transaction.begin();
            entityManager.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccess = false;

        } finally {
            entityManager.close();
        }
        return isSuccess;
    }

}
