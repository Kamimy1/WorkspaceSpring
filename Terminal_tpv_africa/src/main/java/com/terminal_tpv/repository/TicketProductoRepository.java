package com.terminal_tpv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terminal_tpv.model.TicketProducto;

@Repository
public interface TicketProductoRepository extends JpaRepository<TicketProducto, Integer>{

}