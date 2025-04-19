package LLDCaseStudy.ParkingLot;

import LLDCaseStudy.ParkingLot.controllers.TicketController;
import LLDCaseStudy.ParkingLot.dtos.IssueTicketRequestDto;
import LLDCaseStudy.ParkingLot.dtos.IssueTicketResponseDto;
import LLDCaseStudy.ParkingLot.dtos.ResponseStatus;
import LLDCaseStudy.ParkingLot.models.*;
import LLDCaseStudy.ParkingLot.repositories.GateRepository;
import LLDCaseStudy.ParkingLot.repositories.ParkingLotRepository;
import LLDCaseStudy.ParkingLot.repositories.TicketRepository;
import LLDCaseStudy.ParkingLot.repositories.VehicleRepository;
import LLDCaseStudy.ParkingLot.services.TicketService;
import LLDCaseStudy.ParkingLot.strategies.RandomSlotAllocationStrategy;

import java.util.Arrays;

//--------------- CHECK CLIENT CODE. SOME ISSUES IN IT NOT GETTING SEQUENCE CHAIN ...

public class Client {
    public static void main(String[] args) {

        /* Final Checklist Before Issuing Tickets:-
             Floors contain slots.
             Each slot links to its floor.
             Floors added to parking lot.
             Slot strategy implemented properly.
             Vehicle type matches available slot type.
        */

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

        IssueTicketRequestDto ticketRequest1 = new IssueTicketRequestDto();
        ticketRequest1.setLicensePlate("DL01CD5678");
        ticketRequest1.setOwnerName("Jane Smith");
        ticketRequest1.setVehicleType(VehicleType.TWO_WHEELER);
        ticketRequest1.setGateId(1);
        ticketRequest1.setParkingLotId(102);

        IssueTicketRequestDto ticketRequest2 = new IssueTicketRequestDto();
        ticketRequest2.setLicensePlate("KA05EF4321");
        ticketRequest2.setOwnerName("Mike Johnson");
        ticketRequest2.setVehicleType(VehicleType.FOUR_WHEELER);
        ticketRequest2.setGateId(3);
        ticketRequest2.setParkingLotId(103);
//        System.out.println(ticketRequest1);

        //ParkingLotRepository data
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Downtown Parking Lot");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setAddress("123 Main Street, City Center");
        parkingLot.setTotalCapacity(500);
        parkingLot.setSlotAllocationStrategy(new RandomSlotAllocationStrategy());
        parkingLotRepository.save(parkingLot);

        // Dummy Gates
        ParkingGate entryGate = new ParkingGate();
        entryGate.setId(1);
        entryGate.setGateType(GateType.ENTRY);


        // Dummy Operator
        Operator operator = new Operator();
        operator.setName("Alice Johnson");

        entryGate.setCurrOperator(operator);
        entryGate.setGateNumber("GATE-01");

        gateRepository.save(entryGate);

        ParkingGate exitGate = new ParkingGate();
        exitGate.setId(2);
        exitGate.setGateType(GateType.EXIT);

        Operator exitOperator = new Operator();
        exitOperator.setName("Bob Smith");

        exitGate.setCurrOperator(exitOperator);
        exitGate.setGateNumber("GATE-02");

        gateRepository.save(exitGate);

        // Adding gates
        parkingLot.setGates(Arrays.asList(entryGate, exitGate));

        // Dummy Floors
        ParkingFloor floor1 = new ParkingFloor();
        floor1.setNumber("1");

        ParkingSlot slot1 = new ParkingSlot();
        slot1.setId(1);
        slot1.setAllowedVehicleType(VehicleType.TWO_WHEELER);
        slot1.setParkingSlotStatus(ParkingSlotStatus.FILLED);

        ParkingSlot slot2 = new ParkingSlot();
        slot2.setId(2);
        slot2.setAllowedVehicleType(VehicleType.TWO_WHEELER);
        slot2.setParkingSlotStatus(ParkingSlotStatus.EMPTY);

        floor1.setSlots(Arrays.asList(slot1, slot2));

        // Assume floor1 has slots inside if needed.

        ParkingFloor floor2 = new ParkingFloor();
        floor2.setNumber("2");

        ParkingSlot slot3 = new ParkingSlot();
        slot3.setId(3);
        slot3.setAllowedVehicleType(VehicleType.FOUR_WHEELER);
        slot3.setParkingSlotStatus(ParkingSlotStatus.FILLED);

        floor2.setSlots(Arrays.asList(slot3));
        // Adding floors
        parkingLot.setFloors(Arrays.asList(floor1, floor2));        //no need to save floors we r setting floors

        //vehiclerepo data-
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setLicensePlate("DL8CAF1234");
        vehicle1.setOwnerName("Ananya Singh");
        vehicle1.setVehicleType(VehicleType.TWO_WHEELER);
        vehicleRepository.save(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setLicensePlate("KA03MR4567");
        vehicle2.setOwnerName("Vikram Patel");
        vehicle2.setVehicleType(VehicleType.FOUR_WHEELER);
        vehicleRepository.save(vehicle2);

        for (ParkingFloor floor : parkingLot.getFloors()) {
            System.out.println("Floor: " + floor.getNumber());
            for (ParkingSlot slot : floor.getSlots()) {
                System.out.println("  Slot: " + slot.getSlotNumber() + ", Type: " + slot.getParkingSlotStatus() +
                        ", SlotStatus: " + slot.getParkingSlotStatus());    //if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.FILLED)) ? "FILLED" : "EMPTY";
            }
        }

        /* No need to set values of issueticketResponse it will return automatically
        Ticket ticket1 = ticketController.issueTicket(ticketRequest1);

        IssueTicketResponseDto issueTicketResponseDto1 = new IssueTicketResponseDto();
        issueTicketResponseDto1.setTicketId(ticket1.getId());
        issueTicketResponseDto1.setFloorNumber(ticket1.getParkingSlot().getParkingFloor().getNumber());
        issueTicketResponseDto1.setSlotNumber(ticket1.getParkingSlot().getSlotNumber());
        issueTicketResponseDto1.setMessage("Ticket Generated Successfully");
        issueTicketResponseDto1.setResponseStatus(ResponseStatus.SUCCESS);

        System.out.println(issueTicketResponseDto1); */

        IssueTicketResponseDto issueTicketResponseDto1 = ticketController.issueTicket(ticketRequest1);
        System.out.println(issueTicketResponseDto1);
        IssueTicketResponseDto issueTicketResponseDto2 = ticketController.issueTicket(ticketRequest2);
        System.out.println(issueTicketResponseDto2);
    }
}

/* Feature : Ticket Generation-
i/p -> gateId, licencePlate, ownerName, vehicleType
o/p -> all the ticket details specifically slot

TicketController -> Ticket model is most focused
 */