package LLDCaseStudy.ParkingLot.models;

import java.util.Date;
import java.util.List;

public class Bill extends  BaseClass {
    private Date exitTime;
    private int totalAmount;
    private ParkingGate gate;
    private  Operator operator;
    private List<Payment> payments;
    private Ticket ticket;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ParkingGate getGate() {
        return gate;
    }

    public void setGate(ParkingGate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
