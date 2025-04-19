package LLDCaseStudy.ParkingLot.repositories;

import LLDCaseStudy.ParkingLot.models.ParkingGate;
import LLDCaseStudy.ParkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

//Not using JPA. using in memory db
public class GateRepository {
    private Map<Integer, ParkingGate> gatesHashmap;
    private static int counter = 0;

    public GateRepository(){
        gatesHashmap = new TreeMap<>();
    }

    public Optional<ParkingGate> findById(int gateId){
        if(gatesHashmap.containsKey(gateId)){
            return  Optional.of(gatesHashmap.get(gateId));
        }
        return Optional.empty();
    }

    public ParkingGate save(ParkingGate gate){
        if(gate.getId() == 0){
            gate.setId(++counter);
        }
        gatesHashmap.put(gate.getId(), gate);
        return gate;
    }
}
