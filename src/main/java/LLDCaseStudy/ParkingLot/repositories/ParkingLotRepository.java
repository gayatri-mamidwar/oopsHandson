package LLDCaseStudy.ParkingLot.repositories;

import LLDCaseStudy.ParkingLot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository(){
        parkingLotMap = new TreeMap<>();
    }

    public Optional<ParkingLot> findByParkingLotId(int id){
        return Optional.ofNullable(parkingLotMap.get(id));
    }
}
