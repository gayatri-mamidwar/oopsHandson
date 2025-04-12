package LLDCaseStudy.ParkingLot.dtos;

public class IssueTicketResponseDto {
    private int ticketId;
    private String slotNumber;
    private String floorNumber;
    private ResponseStatus responseStatus;
    private String message;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IssueTicketResponseDto{" +
                "ticketId=" + ticketId +
                ", slotNumber='" + slotNumber + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                ", responseStatus=" + responseStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
