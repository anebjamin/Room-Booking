package resourcebooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



public class Equipment {
    
    public static String equipmentDirectory = System.getProperty("user.dir") + "\\Equipment.txt";
    
    private String pens;
    
    public static void writeFile(ArrayList<Catering> equipmentList) {

        try {
            FileWriter writeToFile = new FileWriter(equipmentDirectory, true); //false = overwrite, true = add
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < equipmentList.size(); i++) {
                printToFile.println(equipmentList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
