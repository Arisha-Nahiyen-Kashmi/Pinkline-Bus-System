package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import file.*;

public class BusManager extends JFrame implements ActionListener {

    Font font15 = new Font("Cambria", Font.BOLD, 15);
    Font font20 = new Font("Cambria", Font.BOLD, 20);

    JLabel title, routeSubTitle, busSubTitle;
    JLabel routeNoLabel, routeNameLabel;
    JTextField routeNoField, routeNameField;
    JButton routeAddBtn, routeRemoveBtn, routeUpdateBtn;

    JLabel busRouteNoLabel, busPosNoLabel;
    JLabel busVehicleNoLabel, busNameLabel;
    JLabel busSeatsLabel, busPriceLabel, busTypeLabel;
    JTextField busRouteNoField, busPosNoField;
    JTextField busVehicleNoField, busNameField;
    JTextField busSeatsField, busPriceField, busTypeField;
    JButton busAddBtn, busRemoveBtn, busUpdateBtn;

    JTextArea screen;

    Route routes[] = new Route[50];

    public BusManager() {
        super("Pinkline Bus Management System");
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
		this.setIconImage(new ImageIcon("./images/icon.png").getImage());
		
        FileIO.loadFromFile(routes);

        int x=10, y=10, w=150, h=30, vGap=h+10;

        title = createLabel("Pinkline Bus System", x, y, 2*w, h);

        routeSubTitle = createLabel("Create New Route", x, y+=vGap, 2*w, h);
        routeNoLabel = createLabel("Route No", x, y+=vGap, w, h);
        routeNoField = createTextField("", x+w, y, w, h);
        routeNameLabel = createLabel("Route Name", x, y+=vGap, w, h);
        routeNameField = createTextField("", x+w, y, w, h);
        routeAddBtn = createButton("Create Route", x, y+=vGap, 2*w, h);
        routeAddBtn.setBackground(new Color(219, 112, 147));
        routeUpdateBtn = createButton("Update", x, y+=vGap, w-5, h);
        routeUpdateBtn.setBackground(new Color(245, 245, 220));
        routeUpdateBtn.setForeground(Color.BLACK);
        routeRemoveBtn = createButton("Remove", x+w+5, y, w-5, h);
        routeRemoveBtn.setBackground(Color.RED);

        busSubTitle = createLabel("Create Bus", x, y+=vGap, w, h);
        busRouteNoLabel = createLabel("Route No", x, y+=vGap, w, h);
        busRouteNoField = createTextField("", x+w, y, w, h);
        busPosNoLabel = createLabel("Position No", x, y+=vGap, w, h);
        busPosNoField = createTextField("", x+w, y, w, h);
        busVehicleNoLabel = createLabel("Vehicle No", x, y+=vGap, w, h);
        busVehicleNoField = createTextField("", x+w, y, w, h);
        busNameLabel = createLabel("Bus Name", x, y+=vGap, w, h);
        busNameField = createTextField("", x+w, y, w, h);
        busSeatsLabel = createLabel("Total Seats", x, y+=vGap, w, h);
        busSeatsField = createTextField("", x+w, y, w, h);
        busPriceLabel = createLabel("Ticket Price", x, y+=vGap, w, h);
        busPriceField = createTextField("", x+w, y, w, h);
        busTypeLabel = createLabel("Type(AC/Non-AC)", x, y+=vGap, w, h);
        busTypeField = createTextField("", x+w, y, w, h);
        busAddBtn = createButton("Create And Assign Bus", x, y+=vGap, 2*w, h);
        busAddBtn.setBackground(new Color(219, 112, 147));
        busUpdateBtn = createButton("Update", x, y+=vGap, w-5, h);
        busUpdateBtn.setBackground(new Color(245, 245, 220));
        busUpdateBtn.setForeground(Color.BLACK);
        busRemoveBtn = createButton("Remove", x+w+5, y, w-5, h);
        busRemoveBtn.setBackground(Color.RED);

        screen = new JTextArea();
        screen.setFont(font15);
        screen.setEditable(false);
        updateScreen();
        JScrollPane jsp = new JScrollPane(screen);
        jsp.setBounds(350, 50, 400, 550);
        this.add(jsp);
		JLabel background = new JLabel(new ImageIcon("./images/bg.jpg"));
        background.setBounds(0, 0, 800, 700);
        background.setIcon(new ImageIcon(new ImageIcon("./images/bg.jpg").getImage().getScaledInstance(800, 700, java.awt.Image.SCALE_SMOOTH)));
        this.add(background);
        this.setVisible(true);
    }

    public JLabel createLabel(String text, int x, int y, int w, int h) {
        JLabel c = new JLabel(text);
        c.setBounds(x, y, w, h);
        c.setFont(font20);
        c.setOpaque(true);
        c.setBackground(new Color(219, 112, 147));
        c.setForeground(Color.WHITE);
        this.add(c);
        return c;
    }

    public JTextField createTextField(String text, int x, int y, int w, int h) {
        JTextField c = new JTextField(text);
        c.setBounds(x, y, w, h);
        c.setFont(font15);
        this.add(c);
        return c;
    }

    public JButton createButton(String text, int x, int y, int w, int h) {
        JButton c = new JButton(text);
        c.setBounds(x, y, w, h);
        c.setFont(font15);
        c.setForeground(Color.WHITE);
        c.addActionListener(this);
        this.add(c);
        return c;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == routeAddBtn) {
            int routeNo = Integer.parseInt(routeNoField.getText());
            String routeName = routeNameField.getText();
            if(routes[routeNo] == null) {
                routes[routeNo] = new Route(routeName, 20);
                FileIO.writeRouteInFile(routeNo, routes[routeNo]);
                updateScreen();
                JOptionPane.showMessageDialog(this, "Route Created!");
            } else {
                JOptionPane.showMessageDialog(this, "Route No Already Occupied!");
            }

        } else if(e.getSource() == routeUpdateBtn) {

        } else if(e.getSource() == routeRemoveBtn) {
            int routeNo = Integer.parseInt(routeNoField.getText());
            if(routes[routeNo] != null) {
                routes[routeNo] = null;
                updateScreen();
                JOptionPane.showMessageDialog(this, "Route Removed!");
            } else {
                JOptionPane.showMessageDialog(this, "Route Not Found!");
            }

        } else if(e.getSource() == busAddBtn) {
            int routeNo = Integer.parseInt(busRouteNoField.getText());
            int posNo = Integer.parseInt(busPosNoField.getText());
            String vehicleNo = busVehicleNoField.getText();
            String name = busNameField.getText();
            int seats = Integer.parseInt(busSeatsField.getText());
            double price = Double.parseDouble(busPriceField.getText());
            String type = busTypeField.getText();

            if(routes[routeNo] != null) {
                Bus b = new Bus(vehicleNo, name, seats, price, type);
                routes[routeNo].insertBus(posNo, b);
                FileIO.writeInFile(routeNo, posNo, b);
                updateScreen();
                JOptionPane.showMessageDialog(this, "Bus Added!");
            } else {
                JOptionPane.showMessageDialog(this, "Route Not Found!");
            }

        } else if(e.getSource() == busUpdateBtn) {

        } else if(e.getSource() == busRemoveBtn) {
            int routeNo = Integer.parseInt(busRouteNoField.getText());
            int posNo = Integer.parseInt(busPosNoField.getText());
            if(routes[routeNo] != null) {
                routes[routeNo].removeBus(posNo);
                updateScreen();
                JOptionPane.showMessageDialog(this, "Bus Removed!");
            } else {
                JOptionPane.showMessageDialog(this, "Route Not Found!");
            }
        }
    }

    public void updateScreen() {
        String allData = "";
        for(int i = 0; i < routes.length; i++) {
            if(routes[i] != null) {
                allData += i + "." + routes[i].getRouteAsString();
            }
        }
        screen.setText(allData);
    }
}
