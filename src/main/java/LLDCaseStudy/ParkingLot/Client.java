package LLDCaseStudy.ParkingLot;

import LLDCaseStudy.ParkingLot.controllers.TicketController;
import LLDCaseStudy.ParkingLot.dtos.IssueTicketRequestDto;
import LLDCaseStudy.ParkingLot.dtos.IssueTicketResponseDto;
import LLDCaseStudy.ParkingLot.models.VehicleType;
import LLDCaseStudy.ParkingLot.repositories.GateRepository;
import LLDCaseStudy.ParkingLot.repositories.ParkingLotRepository;
import LLDCaseStudy.ParkingLot.repositories.TicketRepository;
import LLDCaseStudy.ParkingLot.repositories.VehicleRepository;
import LLDCaseStudy.ParkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) {

        //1st create all repositories obj
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        //pass all repos in service constructor
        TicketService ticketService = new TicketService(gateRepository,
                                                         vehicleRepository,
                                                        parkingLotRepository,
                                                        ticketRepository);

        //create controller obj & pass service obj
        TicketController ticketController = new TicketController(ticketService);

//        IssueTicketRequestDto ticketRequest1 = new IssueTicketRequestDto();
//        ticketRequest1.setLicensePlate("DL01CD5678");
//        ticketRequest1.setOwnerName("Jane Smith");
//        ticketRequest1.setVehicleType(VehicleType.TWO_WHEELER);
//        ticketRequest1.setGateId(1);
//        ticketRequest1.setParkingLotId(102);
//
//        IssueTicketRequestDto ticketRequest2 = new IssueTicketRequestDto();
//        ticketRequest2.setLicensePlate("KA05EF4321");
//        ticketRequest2.setOwnerName("Mike Johnson");
//        ticketRequest2.setVehicleType(VehicleType.FOUR_WHEELER);
//        ticketRequest2.setGateId(3);
//        ticketRequest2.setParkingLotId(103);
//
//        IssueTicketResponseDto ticket1 = ticketController.issueTicket(ticketRequest1);
//        System.out.println(ticket1);
//        IssueTicketResponseDto ticket2 = ticketController.issueTicket(ticketRequest2);
//        System.out.println(ticket2);

    }
}

/* Feature : Ticket Generation-
i/p -> gateId, licencePlate, ownerName, vehicleType
o/p -> all the ticket details specifically slot

TicketController -> Ticket model is most focused
 */