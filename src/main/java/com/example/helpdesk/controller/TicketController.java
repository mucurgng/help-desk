package com.example.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.helpdesk.repository.TicketRepository;

@Controller
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets", ticketRepository.findAllByOrderByCreatedAtDesc());
        model.addAttribute("filterTitle", "Все заявки");
        return "tickets";
    }

    @GetMapping("/tickets/customer")
    public String customerTickets(Model model) {
        model.addAttribute("tickets", ticketRepository.findByCustomerNameContainingIgnoreCase("Киану"));
        model.addAttribute("filterTitle", "Заявки клиента Киану");
        return "tickets";
    }
}
