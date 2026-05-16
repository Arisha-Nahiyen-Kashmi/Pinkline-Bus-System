package entity;

public class Route {
    private String routeName;
    private Bus[] buses;

    public Route() {
        routeName = "No Name";
        buses = new Bus[20];
    }

    public Route(String routeName, int size) {
        this.routeName = routeName;
        buses = new Bus[size];
    }
	public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    public String getRouteName() {
        return routeName;
    }
	
	public void insertBus(int posNo, Bus b) {
        if(posNo >= 0 && posNo < buses.length) {
            buses[posNo] = b;
        }
    }

    public void removeBus(int posNo) {
        if(posNo >= 0 && posNo < buses.length) {
            buses[posNo] = null;
        }
    }

    public Bus getBus(int posNo) {
        if(posNo >= 0 && posNo < buses.length) {
            return buses[posNo];
        }
        return null;
    }

    public String getRouteAsString() {
        String data = "";
        data += "=========== " + routeName + " ==============\n";
        double totalPrice = 0;
        int busCount = 0;
        for(int i = 0; i < buses.length; i++) {
            if(buses[i] != null) {
                totalPrice += buses[i].getTicketPrice();
                busCount++;
                data += "~~~~~~~ " + i + " ~~~~~~~\n";
                data += buses[i].toString();
                data += "---------------------\n";
            }
        }
        data += "---------------------\n";
        data += "Total Buses: " + busCount + "\n";
        data += "---------------------\n\n";
        return data;
    }
}
