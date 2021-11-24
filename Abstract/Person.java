package Abstract;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /** add. */
    public void addVehicle(Vehicle vehicle) {
        if (vehicleList.contains(vehicle)) {
            return;
        }
        vehicleList.add(vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        vehicleList.removeIf(i -> i.registrationNumber == registrationNumber);
    }

    /** toString. */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return name + " has no vehicle!";
        }
        String ans = name + " has:\n\n";
        for (Vehicle i: vehicleList) {
            ans += i.getInfo() + "\n";
        }
        return ans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}