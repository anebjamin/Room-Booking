package resourcebooking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;



public class ResourceBooking {

    public static Scanner input = new Scanner(System.in);
    
    public static ArrayList<Catering> cateringRequests = new ArrayList<>();
    public static ArrayList<Equipment> equipmentRequests = new ArrayList<>();

    public static void main(String[] args) {
        cateringRequests = Catering.readFile();
//        view();
        currentTime();
        mainMenu();
        //do user login
        //make a 2d array to book slots, use the grid to represent times, 5 time slots per day, 5 different rooms
        //in 2d array, put an x when a time slot is booked.
        //Or a morning and afternoon slot that last 3 hours and refreshments can be delivered every hour on the hour.

    }

    public static void mainMenu() {
        while (true) {
            try {
                System.out.println("\nChoose an option:\n1: Book a room\n2: Add refreshments\n3: Add equipment\n4: View booking\n0: Quit");
                int menuChoice = input.nextInt();
                switch (menuChoice) {
                    case 1:
                        roomBook();
                        break;
                    case 2:
                        reqRefreshments();
                        break;
                    case 3:
                        reqEquipment();
                        break;
                    case 4:
                        viewBooking();
                        break;
                    case 0:
//                        Catering.writeFile(cateringRequests);
                        System.exit(menuChoice);
                }

            } catch (Exception e) {
                System.out.println("Error occured: " + e);
                input.nextLine();

            }
        }

    }

    public static void roomBook() {
        String email=emailVerif();
        System.out.println("Do you need disability access?");
        String access=input.next();
        int roomSelected;
        access=access.toLowerCase();
        if (access.equals("y")||access.equals("yes")){
            roomSelected=4;
            System.out.println("room 4 selected");
        }else{
            System.out.println("How many people are you booking for?(max 50)");
            int peopleCount=input.nextInt();
            
            if(peopleCount>2){
                roomSelected=1;
            }else{
                if(2<peopleCount&&peopleCount<5){
                    roomSelected=2;
                }else{
                    if(4<peopleCount&&peopleCount<9){
                        roomSelected=3;
                    }else{
                        if(8<peopleCount&&peopleCount<16){
                            roomSelected=4;
                        }else{
                            roomSelected=5;
                        }
                    }
                }
            }
            System.out.println("room "+roomSelected+" selected\n");
            System.out.println("what day would you like the room?\n1: Monday\n2: Tuesday\n3: Wednesday\n4: Thursday\n5: Friday");
            int daySelect=input.nextInt();
            switch(daySelect){
                case 1:
                    
            }
            
        }
    }

    public static void reqRefreshments() {
        int roomNumber = roomVerif();
        String email = emailVerif();
        
        System.out.println("Would you like tea?");
        String tea = input.next();
        System.out.println("Would you like coffee?");
        String coffee = input.next();
        System.out.println("Would you like water?");
        String water = input.next();
        System.out.println("Would you like pastries?");
        String pastry = input.next();
        System.out.println("Would you like sandwiches?");
        String sandwich = input.next();
        String requestTime = currentTime();
        
        Catering newRequest = new Catering(email,roomNumber, tea, coffee, water, pastry, sandwich, requestTime);cateringRequests.add(newRequest);
        Catering.writeFile(cateringRequests);
        
        System.out.println(cateringRequests);
        

    }

    public static void reqEquipment() {

    }

    public static void viewBooking() throws FileNotFoundException {
        String roomDirectory = System.getProperty("user.dir") + "\\Rooms.txt";
        emailVerif();
        String lineFromFile;
        BufferedReader read = new BufferedReader(new FileReader(roomDirectory));
        //while((lineFromFile = read.read()) != null){
            
        //}
        
    }


    public static String emailVerif() {
        boolean valid = true;
        String email = "";
        while (valid == true) {
            System.out.println("Please enter your email:");
            email = input.next();

            if (email.contains("@")) {
                if (email.contains(".co.uk") || email.contains(".com") || email.contains(".ac.uk")) {
                    System.out.println("Email valid.");
                }
                valid = false;
            } else {
                System.out.println("Email not valid. Please try again.");
            }

        }
        return email;
    }

    public static int roomVerif() {
        boolean valid = true;
        int room = 0;
        while (valid == true) {
            System.out.println("Enter room number:");
            room = input.nextInt();

            if (room < 6 && room > -1) {
                System.out.println("Room number: " + room);
                valid = false;
            } else {
                System.out.println("Room number not valid. Please try again.");
            }
        }
        return room;
    }

    public static String currentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String convertDate = formatter.format(date);                
        System.out.println(convertDate);
        return convertDate;
    }

    
    
    
    public static void view() {
        for (int i = 0; i < cateringRequests.size(); i++) {
            System.out.println(cateringRequests.get(i).toString());
        }
    }

    
    
}
