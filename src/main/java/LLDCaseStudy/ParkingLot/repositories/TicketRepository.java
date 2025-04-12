package LLDCaseStudy.ParkingLot.repositories;

import LLDCaseStudy.ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> ticketHashMap;
    private static int counter = 0;

    public TicketRepository(){
        ticketHashMap = new HashMap<>();
    }

    public Ticket save(Ticket ticket){
        counter++;
        ticket.setId(counter);
        ticketHashMap.put(counter, ticket);
        return ticket;
    }

}
