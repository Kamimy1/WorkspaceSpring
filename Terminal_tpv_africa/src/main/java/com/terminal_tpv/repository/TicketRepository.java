package com.terminal_tpv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terminal_tpv.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	

}