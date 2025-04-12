package LLDCaseStudy.ParkingLot.repositories;

import LLDCaseStudy.ParkingLot.models.ParkingGate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

//Not using JPA. using in memory db
public class GateRepository {
    private Map<Integer, ParkingGate> gatesHashmap;

    public GateRepository(){
        gatesHashmap = new TreeMap<>();
    }

    public Optional<ParkingGate> findById(int gateId){
        if(gatesHashmap.containsKey(gateId)){
            return  Optional.of(gatesHashmap.get(gateId));
        }
        return Optional.empty();
    }
}
