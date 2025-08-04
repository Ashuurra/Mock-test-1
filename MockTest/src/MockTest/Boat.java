package MockTest;

public class Boat extends Watercraft {
	private double fuelLeft;
	private int year;


	public Boat(String plate, double fuelLeft, int year) {
		super(plate);
		this.fuelLeft = fuelLeft;
		this.year = year;
}


	public double getFuelLeft() {
		return fuelLeft;
	}


	public void setFuelLeft(double fuelLeft) {
		this.fuelLeft = fuelLeft;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	public void displayInfo() {
        System.out.printf("Plate: %s, Fuel Left: %.2f, Year: %d%n", getPlate(), fuelLeft, year);
    }
}

