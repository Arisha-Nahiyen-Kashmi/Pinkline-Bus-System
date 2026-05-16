package entity;

public class Bus extends Vehicle{
	private double ticketPrice;
	private String busType;
	
	public Bus(){
		super();
		ticketPrice = 0;
		busType = "Non-AC";
	}
	public Bus(String vehicleNo, String vehicleName, int totalSeats, double ticketPrice, String busType){
		super(vehicleNo, vehicleName, totalSeats);
		setTicketPrice(ticketPrice);
		setBusType(busType);
	}
	public void setTicketPrice(double ticketPrice){
		this.ticketPrice = ticketPrice;
	}
	public double getTicketPrice(){
		return ticketPrice;
	}
	public void setBusType(String busType){
		this.busType = busType;
	}
	public String getBusType(){
		return busType;
	}
	public void displayInfo(){
		System.out.println("Vehicle No: " + getVehicleNo());
		System.out.println("Bus Name: " + getVehicleName());
		System.out.println("Total Seats: " + getTotalSeats());
	    System.out.println("Bus Type: " + busType);
	}
	public String toString(){
		return "Bus No: " + getVehicleNo() + "\n" +
		       "Bus Name: " + getVehicleName() + "\n" +
			   "Total Seats: " + getTotalSeats() + "\n" +
			   "Ticket Price: " + ticketPrice + "BDT\n" +
			   "Bus Type: " + busType + "\n";
	}
}

	