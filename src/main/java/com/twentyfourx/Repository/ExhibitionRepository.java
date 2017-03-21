package com.twentyfourx.Repository;

/**
 * Created by Thanawat on 3/11/2017.
 */

import com.twentyfourx.Entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ExhibitionRepository extends CrudRepository<Exhibition, Integer>, JpaRepository<Exhibition, Integer> {
    Exhibition findById(int id);
}






/*import com.twentyfourx.Entity.Exhibition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ExhibitionRepository {
    @PersistenceContext
    EntityManager entityManager;
    public Exhibition get(int exhibitionId) {
        Exhibition exhibition = entityManager.getReference(Exhibition.class, exhibitionId);
        return exhibition;
    }*/
  /*  public List<Exhibition> getAll() {
        Query query = entityManager.createQuery("select * from exhibition p",
                Exhibition.class);
        return query.getResultList();
    }*/
/*    public void remove(Exhibition patient) {
        entityManager.remove(patient);
*/