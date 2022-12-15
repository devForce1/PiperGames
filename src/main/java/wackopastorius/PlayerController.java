package wackopastorius;

/*
*
* Authors: Lada Egolaeva & Mikael Petersson
*
* */

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class PlayerController {

    public PlayerController() {
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    //adds a player to db
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

    //shows all players in db
    public List<Player> getAllPlayers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Player> playerList = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayersQuery = entityManager.createQuery("from Player", Player.class);
            playerList = allPlayersQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return playerList;
    }

    //deletes a player
    public boolean deletePlayer(int playerID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Player thePlayerToRemove = entityManager.find(Player.class, playerID);
            entityManager.remove(thePlayerToRemove);
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

    //updates a player's info
    public boolean updatePlayer(Player player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Player playerToUpdate = entityManager.find(Player.class, player.getPlayerID());
            playerToUpdate.setFirstName(player.getFirstName());
            playerToUpdate.setLastName(player.getLastName());
            playerToUpdate.setNickname(player.getNickname());
            playerToUpdate.setAddress(player.getAddress());
            playerToUpdate.setCountry(player.getCountry());
            playerToUpdate.setEmail(player.getEmail());
            playerToUpdate.setTeamID(player.getTeamID());
            entityManager.merge(playerToUpdate);

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

    //retrieves a player by id
    public Player getPlayerByID(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Player player;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            player = entityManager.find(Player.class, id);
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            entityManager.close();
            return null;
        }
        entityManager.close();
        return player;
    }
}
