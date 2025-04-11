package LLDCaseStudy.ParkingLot.models;

public class ParkingGate extends BaseClass {
    private GateType gateType;
    private Operator currOperator;
    private String gateNumber;

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getCurrOperator() {
        return currOperator;
    }

    public void setCurrOperator(Operator currOperator) {
        this.currOperator = currOperator;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}
