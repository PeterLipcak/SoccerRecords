package cz.muni.fi.pa165.soccerrecords;

import cz.muni.fi.pa165.soccerrecords.entities.Goal;
import cz.muni.fi.pa165.soccerrecords.entities.Match;
import cz.muni.fi.pa165.soccerrecords.entities.Player;
import cz.muni.fi.pa165.soccerrecords.entities.Team;
import cz.muni.fi.pa165.soccerrecords.enums.Position;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Jaromir Sys
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws SQLException {
        // The following line is here just to start up a in-memory database
        new AnnotationConfigApplicationContext(InMemoryDatabaseSpring.class);

        emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Team t1 = new Team();
        t1.setCity("asd");
        t1.setCountry("asd");
        t1.setName("sadsad");
        em.persist(t1);

        Player p1 = new Player();
        p1.setCountry("");
        p1.setDateOfBirth(new Date());
        p1.setDressNumber(1);
        p1.setName("");
        p1.setPosition(Position.GOAL_KEEPER);
        p1.setTeam(t1);
        em.persist(p1);
        t1.addPlayer(p1);
        em.merge(t1);

        Team t2 = new Team();
        t2.setCity("asd");
        t2.setCountry("asd");
        t2.setName("sadsad");
        em.persist(t2);
        Player p2 = new Player();
        p2.setCountry("");
        p2.setDateOfBirth(new Date());
        p2.setDressNumber(1);
        p2.setName("");
        p2.setPosition(Position.GOAL_KEEPER);
        p2.setTeam(t1);
        em.persist(p2);
        t2.addPlayer(p2);
        em.merge(t2);

        Match m = new Match();
        m.setGuestTeam(t1);
        m.setGuestScore(1);
        m.setHomeTeam(t2);
        m.setHomeScore(0);
        em.persist(m);

        Goal g = new Goal();
        g.setTime(new Date());
        g.setMatch(m);
        g.setPlayer(p1);
        g.setDescription("wtf");
        em.persist(g);

        em.getTransaction().commit();

        // The code below is just testing code do not modify it
        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();
        Goal g2 = em1.find(Goal.class, g.getId());
        System.out.println(g2.getDescription());
        emf.close();
    }

}
