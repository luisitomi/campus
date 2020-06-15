package com.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.model.Events;

public interface EventsRepository extends JpaRepository<Events, Long>{

}
