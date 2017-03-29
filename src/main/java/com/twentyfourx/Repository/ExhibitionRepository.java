package com.twentyfourx.Repository;

/**
 * Created by Thanawat on 3/11/2017.
 */

import com.twentyfourx.Entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ExhibitionRepository extends CrudRepository<Exhibition, Integer>, JpaRepository<Exhibition, Integer> {
    Exhibition findById(int id);
    List<Exhibition> findByCategory(String category);
    List<Exhibition> findByIsExpired(boolean isPassed);
}


