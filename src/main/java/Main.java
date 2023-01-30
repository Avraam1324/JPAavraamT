import entity.TryTable;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try
        {
            transaction.begin();

            Query query = entityManager.createNamedQuery("SELECT");
            List<TryTable> list = query.getResultList();
            for( TryTable user: list ){
                System.out.println(user.toString());
            }


            entityManager.persist(insert("sangoko"));

            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public static TryTable insert(String name){
        TryTable tryTable = new TryTable();
        tryTable.setTryColoms(name);
    return tryTable;
    }

}
