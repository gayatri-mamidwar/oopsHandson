package LLDCaseStudy.ParkingLot.controllers;

import LLDCaseStudy.ParkingLot.dtos.IssueTicketRequestDto;
import LLDCaseStudy.ParkingLot.dtos.IssueTicketResponseDto;
import LLDCaseStudy.ParkingLot.dtos.ResponseStatus;
import LLDCaseStudy.ParkingLot.models.Ticket;
import LLDCaseStudy.ParkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();

        try{
            Ticket ticket = ticketService.issueTicket(requestDto.getLicensePlate(),
                                                        requestDto.getOwnerName(),
                                                        requestDto.getVehicleType(),
                                                        requestDto.getGateId(),
                                                        requestDto.getParkingLotId());

            responseDto.setTicketId(ticket.getId());
            responseDto.setSlotNumber(ticket.getParkingSlot().getSlotNumber());
            responseDto.setFloorNumber(ticket.getParkingSlot().getParkingFloor().getNumber());
            responseDto.setMessage("Ticket Generated Successfully");
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            responseDto.setMessage(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return  responseDto;
    }
}
