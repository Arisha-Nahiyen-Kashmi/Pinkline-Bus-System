package file;

import java.io.*;
import java.util.Scanner;
import entity.*;

public class FileIO {

    public static void loadFromFile(Route routes[]) {
        try {
            File routeFile = new File("./file/Routes.txt");
            Scanner routeSc = new Scanner(routeFile);
            while(routeSc.hasNextLine()) {
                String line = routeSc.nextLine();
                String data[] = line.split(";");
                int routeNo = Integer.parseInt(data[0]);
                String routeName = data[1];
                routes[routeNo] = new Route(routeName, 20);
            }
            routeSc.close();

            File busFile = new File("./file/Buses.txt");
            Scanner busSc = new Scanner(busFile);
            while(busSc.hasNextLine()) {
                String line = busSc.nextLine();
                String data[] = line.split(";");
                int routeNo = Integer.parseInt(data[0]);
                int posNo = Integer.parseInt(data[1]);
                String vehicleNo = data[2];
                String vehicleName = data[3];
                int totalSeats = Integer.parseInt(data[4]);
                double ticketPrice = Double.parseDouble(data[5]);
                String busType = data[6];
                Bus b = new Bus(vehicleNo, vehicleName,
                                totalSeats, ticketPrice, busType);
                routes[routeNo].insertBus(posNo, b);
            }
            busSc.close();

        } catch(FileNotFoundException ex) {
            System.out.println("Cannot Read The File.");
        }
    }

    public static void writeInFile(int routeNo, int posNo, Bus b) {
        try {
            File busFile = new File("./file/Buses.txt");
            FileWriter writer = new FileWriter(busFile, true);
            String line = routeNo + ";" + posNo + ";" +
                          b.getVehicleNo() + ";" +
                          b.getVehicleName() + ";" +
                          b.getTotalSeats() + ";" +
                          b.getTicketPrice() + ";" +
                          b.getBusType() + "\n";
            writer.write(line);
            writer.flush();
            writer.close();
        } catch(IOException ex) {
            System.out.println("Cannot Write in File.");
        }
    }

    public static void writeRouteInFile(int routeNo, Route r) {
        try {
            File routeFile = new File("./file/Routes.txt");
            FileWriter writer = new FileWriter(routeFile, true);
            String line = routeNo + ";" + r.getRouteName() + "\n";
            writer.write(line);
            writer.flush();
            writer.close();
        } catch(IOException ex) {
            System.out.println("Cannot Write in File.");
        }
    }
}
