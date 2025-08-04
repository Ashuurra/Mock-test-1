package MockTest;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.lang.System.*;

public class main {
    public static void main(String[] args) {

        String filename = "data/boat_data.txt";
        try{     
        	BoatApp bapp = new BoatApp(filename);         
        }catch(IOException ioe){                     
        	out.printf("Please double check the file name: %s, and try again.", filename);                 
        }
    }
}
