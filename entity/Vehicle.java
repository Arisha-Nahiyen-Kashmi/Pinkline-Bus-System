package entity;
public abstract class Vehicle {
	private String vehicleNo;
	private String vehicleName;
	private int totalSeats;
	
	public Vehicle(){
		vehicleNo = "N/A";
		vehicleName = "No Name";
		totalSeats = 0;
	}
	public Vehicle(String vehicleNo, String vehicleName, int totalSeats){
		setVehicleNo(vehicleNo);
		setVehicleName(vehicleName);
		setTotalSeats(totalSeats);
	}
	public void setVehicleNo(String vehicleNo){
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleNo(){
		return vehicleNo;
	}
	public void setVehicleName(String vehicleName){
		this.vehicleName = vehicleName;
	}
	public String getVehicleName(){
		return vehicleName;
	}
	public void setTotalSeats(int totalSeats){
		this.totalSeats = totalSeats;
	}
	public int getTotalSeats(){
		return totalSeats;
	}
	
	public abstract void displayInfo();
	public String toString(){
		return "Vehicle No: " + vehicleNo + "\n" +
		       "Vehicle Name: " + vehicleName + "\n" +
			   "Total Seats: " + totalSeats + "\n";
	}
}
