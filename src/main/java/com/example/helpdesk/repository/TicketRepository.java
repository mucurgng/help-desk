package com.example.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.model.TicketStatus;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByOrderByCreatedAtDesc();

    List<Ticket> findByStatus(TicketStatus status);

    List<Ticket> findByCustomerNameContainingIgnoreCase(String customerName);
}
