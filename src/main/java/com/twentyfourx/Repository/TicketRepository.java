package com.twentyfourx.Repository;

import com.twentyfourx.Entity.Exhibition;
import com.twentyfourx.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Thanawat on 3/23/2017.
 */
public interface TicketRepository extends CrudRepository<Exhibition, Integer>, JpaRepository<Exhibition, Integer> {
    void save(Ticket ticket);
    Ticket findById(int id);
}
