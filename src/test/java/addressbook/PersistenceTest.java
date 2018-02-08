package addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistenceTest {

    BuddyInfo homer, sherlock;
    AddressBook addresses;

    /*
    @Test
    public void persistBuddyTest() throws Exception {
        homer = new BuddyInfo("Homer", "123 Springfield Drive", "613-888-7667");
        sherlock = new BuddyInfo("Sherlock", "221B Baker Street", "613-765-4321");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        addresses = new AddressBook();
        addresses.setId(100);
        addresses.addBuddy(homer);
        addresses.addBuddy(sherlock);

        tx.begin();

        // Persisting the AddressBook entity object
        em.persist(addresses);

        tx.commit();

        Query q = em.createQuery("SELECT p FROM AddressBook p");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("\nAddress Books:\n----------------");

        for (AddressBook p : results) {
            Assert.assertTrue(addresses.equals(p));
            System.out.println("AddressBook id = " + p.getId());
            for (int i = 0; i < p.getSize(); i++) {
                System.out.println("    " + p.getFriend(i).getBuddyName() + " (id=" + p.getFriend(i).getId() + ", address=" + p.getFriend(i).getBuddyAddress() + ", number=" + p.getFriend(i).getPhoneNumber() + ")");
            }
        }
        // Closing connection
        em.close();

        emf.close();

    }
    */
}
