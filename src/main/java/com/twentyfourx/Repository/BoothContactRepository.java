package com.twentyfourx.Repository;

import com.twentyfourx.Entity.BoothContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by Thanawat on 3/21/2017.
 */

public interface BoothContactRepository extends CrudRepository<BoothContact, Integer>, JpaRepository<BoothContact, Integer>,Repository<BoothContact, Integer> {


}