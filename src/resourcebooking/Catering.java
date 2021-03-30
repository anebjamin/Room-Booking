package resourcebooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Catering {
 
    public static String cateringDirectory = System.getProperty("user.dir") + "\\Catering.txt";

    protected int roomNumber;
    protected String email;
    protected String tea;
    protected String coffee;
    protected String water;
    protected String pastry;
    protected String sandwich;
    protected String requestTime;

    public Catering( String email,int roomNumber, String tea, String coffee, String water, String pastry, String sandwich, String requestTime) {
        this.roomNumber = roomNumber;
        this.email = email;
        this.tea = tea;
        this.coffee = coffee;
        this.water = water;
        this.pastry = pastry;
        this.sandwich = sandwich;
        this.requestTime = requestTime;
    }
    
    public String toString() {
        return  email+ ", " +  roomNumber+ ", "  + tea + ", " + coffee + ", " + water + ", " + pastry + ", " + sandwich + ", " + requestTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTea() {
        return tea;
    }

    public String getCoffee() {
        return coffee;
    }

    public String getWater() {
        return water;
    }

    public String getPastry() {
        return pastry;
    }

    public String getSandwich() {
        return sandwich;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public void setPastry(String pastry) {
        this.pastry = pastry;
    }

    public void setSandwich(String sandwich) {
        this.sandwich = sandwich;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
   
    
    public static void writeFile(ArrayList<Catering> cateringList) {

        try {
            FileWriter writeToFile = new FileWriter(cateringDirectory,false); 
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < cateringList.size(); i++) {
                printToFile.println(cateringList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
                    
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
   
    
    public static ArrayList<Catering> readFile() {

        ArrayList<Catering> cateringList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(cateringDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] cateringDetails = lineFromFile.split(", ");
                //String username, string password, int account number
                Catering request = new Catering( cateringDetails[0],Integer.parseInt(cateringDetails[1]), cateringDetails[2], cateringDetails[3], cateringDetails[4], cateringDetails[5], cateringDetails[6], cateringDetails[7]);
                cateringList.add(request);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return cateringList;
    }
    
  
    
    
     
}
