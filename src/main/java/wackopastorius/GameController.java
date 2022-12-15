package wackopastorius;

/*
*
* Authors: Lada Egolaeva & Mikael Petersson
*
* */


import javax.persistence.*;
import java.util.List;

public class GameController {

    public GameController() {
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    public boolean addGame(Game game) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;
        try {
            transaction.begin();
            entityManager.persist(game);
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

    public List<Game> getAllGames() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Game> gameList = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGamesQuery = entityManager.createQuery("from Game ", Game.class);
            gameList = allGamesQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return gameList;
    }
    //deletes a team from db
    public boolean deleteGame(int gameId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Game gameToRemove = entityManager.find(Game.class, gameId);
            entityManager.remove(gameToRemove);
            entityManager.flush();

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
