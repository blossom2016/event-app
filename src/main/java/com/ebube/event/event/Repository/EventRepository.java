package com.ebube.event.event.Repository;

import com.ebube.event.event.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer> {
}
