package MockTest;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.lang.System.*;
public class BoatApp {
    Scanner input = new Scanner(System.in);
    List<Boat> boats = new LinkedList<>();
    public BoatApp(String boat_data) throws IOException { 
        readData(boat_data);
        displayMenu();
		int opt = 0;
		String str = null;
		while (true) {
			out.print("\nSelect an option: ");
			str = input.nextLine().trim();
			if(str.isEmpty()) continue;
			if(str.chars().allMatch(Character::isDigit) == false) {
				out.println("Please enter a number.");
				continue;
			}
			opt = Integer.parseInt(str);
			if (opt < 1 || opt > 4) {
				out.println("Invalid option.");
				continue;
			}
			switch (opt){
				case 1: 
					searchByPlate(); 
					break;
				case 2: 
					displayBoatWithMostFuel(); 
					break;
				case 3: 
					out.printf("Total fuel: %.2f", getTotalFuelLeft(boats, 0));
					break;
				case 4: 
					out.println("Bye");
					break;
			}			
		}//end of while
    }
    public void displayMenu(){
        out.println("\n\n*************************************");
        out.println("* Menu                              *");
        out.println("*************************************\n");
        out.println("1. Search boat by plate");
        out.println("2. Display boat with most fuel in tank");
        out.println("3. Display total fuel left in all boats");
        out.println("4. Exit");
    }

    public void readData(String boat_data) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(boat_data));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
            	String plate = parts[0].trim();
            	double fuelLeft = Double.parseDouble(parts[1].trim());
            	int year = Integer.parseInt(parts[2].trim());
            	boats.add(new Boat(plate, fuelLeft, year));
            }
        }
        reader.close();     	
    }    	    	    	        
    public void displayBoatWithMostFuel(){
    	if (boats == null || boats.isEmpty()) {
            System.out.println("No boats in the list.");
            return;
        }

        Boat MostFuel = boats.get(0);

        for (Boat b : boats) {
            if (b.getFuelLeft() > MostFuel.getFuelLeft()) {
                MostFuel = b;
            }
        }

        System.out.println("Boat with the most fuel:");
        MostFuel.displayInfo();  // Ensure Boat class has displayInfo()    
    }
    public void searchByPlate() {
    	out.print("Enter a plate number: ");
    	String searchPlate = input.nextLine().trim().toUpperCase();
    	
    	boolean found = false;
    	for(Boat b : boats) {
    		if (b.getPlate().equalsIgnoreCase(searchPlate)) {
    			b.displayInfo();
    			found = true;
    			break;
    		}
    	}
    	if (!found) {
    		out.print("No boat found with that plate.");
    	}
    }
    public double getTotalFuelLeft(List<Boat> list, int index) {
    	if (index >= list.size()) return 0;
        return list.get(index).getFuelLeft() + getTotalFuelLeft(list, index + 1);

    }
}