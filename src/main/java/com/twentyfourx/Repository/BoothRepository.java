package com.twentyfourx.Repository;

/**
 * Created by Thanawat on 3/20/2017.
 */

import com.twentyfourx.Entity.Booth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BoothRepository extends CrudRepository<Booth, Integer>, JpaRepository<Booth, Integer>,Repository<Booth, Integer> {
    List<Booth> findBoothByExhibitionId(int id);
}