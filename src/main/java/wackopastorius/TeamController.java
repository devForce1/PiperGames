package wackopastorius;

/*
* Authors: Mikael Petersson & Lada Egolaeva
*
* */

import javax.persistence.*;
import java.util.List;

public class TeamController {
    //properties
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    //constructors
    public TeamController() {
    }

    //shows all teams in db
    public List<Team> getAllTeams() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Team> teamList = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamsQuery = entityManager.createQuery("from Team", Team.class);
            teamList = allTeamsQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return teamList;
    }

    //gets team by ID
    public Team getTeamByID(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Team team;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            team = entityManager.find(Team.class, id);
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
        return team;
    }

    //adds a team to db
    public boolean addTeam(Team team) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;
        try {
            transaction.begin();
            entityManager.persist(team);
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

    //deletes a team from db
    public boolean deleteTeam(int teamID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Team teamToRemove = entityManager.find(Team.class, teamID);
            entityManager.remove(teamToRemove);
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

    //updates a team
    public boolean updateTeam(Team team) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Team teamToUpdate = entityManager.find(Team.class, team.getTeamID());
            teamToUpdate.setTeamName(team.getTeamName());

            entityManager.merge(teamToUpdate);
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
