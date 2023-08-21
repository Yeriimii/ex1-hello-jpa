package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 하나만 만들어야 함

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "10000");

            Member member1 = new Member();
            member1.setUsername("hello");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address copyAddress = new Address("newCity", address.getStreet(), address.getZipcode()); // 새로 만들면됨

            Member member2 = new Member();
            member2.setUsername("hello");
            member2.setHomeAddress(copyAddress); // 임베디드 값 타입을 복사해서 사용해야 한다.
            em.persist(member2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
