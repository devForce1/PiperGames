package wackopastorius;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Player player = new Player();
            player.setFirstName("Chen");
            player.setLastName("Ming-Yong");
            player.setNickname("Yimeng");
            player.setAddress("176 Shuidian Road, 200083 Hongkou");
            player.setCountry("China");
            player.setEmail("chen_mingyong@gmail.com");
            player.setTeamID(1);

            entityManager.persist(player);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
