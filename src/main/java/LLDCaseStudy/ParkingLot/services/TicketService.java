package LLDCaseStudy.ParkingLot.services;

import LLDCaseStudy.ParkingLot.models.*;
import LLDCaseStudy.ParkingLot.repositories.GateRepository;
import LLDCaseStudy.ParkingLot.repositories.ParkingLotRepository;
import LLDCaseStudy.ParkingLot.repositories.TicketRepository;
import LLDCaseStudy.ParkingLot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String licensePlate,  String ownerName,
                                VehicleType vehicleType, int gateId, int parkingLotId){

        //Get the Parkinglot
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findByParkingLotId(parkingLotId);
        if(optionalParkingLot.isEmpty()){
            throw new RuntimeException("No such Parking lot exist");
        }
        ParkingLot parkingLot = optionalParkingLot.get();

        //Get the Gate object using gateId
        Optional<ParkingGate> optionalGate = gateRepository.findById(gateId);
        if(optionalGate.isEmpty()){
            throw  new RuntimeException("No Such Gate exist");
        }
        ParkingGate gate = optionalGate.get();

        //Get the Vehicle from db if present
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByLicensePlate(licensePlate);
        Vehicle vehicle = null;

        //if Vehicle is coming 1st time, setting its values & saving in db
        if(optionalVehicle.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            vehicle.setLicensePlate(licensePlate);

            //save vehicle obj to db
            vehicleRepository.save(vehicle);
        } else{
            vehicle = optionalVehicle.get();
        }

        //Get the slot to park the vehicle.
        ParkingSlot parkingSlot = parkingLot.getSlotAllocationStrategy()
                .allocateSlot(parkingLot, vehicleType);

        if(parkingSlot == null){
            throw new RuntimeException("No ParkingSlot is available");
        }

        //Ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(gate.getCurrOperator());
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(parkingSlot);

        return ticketRepository.save(ticket);

    }
}
