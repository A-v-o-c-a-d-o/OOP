package Abstract;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, String registrationNumber,
                Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        String ans = "Car:\n";
        ans += "\tBrand: " + brand + "\n";
        ans += "\tModel: " + model + "\n";
        ans += "\tRegistration Number: " + registrationNumber + "\n";
        ans += "\tNumber of Doors: " + numberOfDoors + "\n";
        ans += "\tBelongs to " + owner.getName() + " - " + owner.getAddress();
        return ans;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
