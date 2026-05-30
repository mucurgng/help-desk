package com.example.helpdesk.service;

import java.util.List;

import com.example.helpdesk.dto.TicketCreateDto;
import com.example.helpdesk.model.Ticket;

public interface TicketService {

    Ticket createTicket(TicketCreateDto ticketCreateDto);

    List<Ticket> getAllTickets();

    List<Ticket> getTicketsByCustomerName(String customerName);

    Ticket getTicketById(Long id);
}
