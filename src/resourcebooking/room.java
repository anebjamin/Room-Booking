package resourcebooking;
import java.util.ArrayList;

public class room {

    protected String email;
    protected int roomSelected;
    protected String day;

    public room(String email,int roomSelected,String day) {
        this.email=email;
        this.roomSelected=roomSelected;
        this.day=day;
    }

   

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoomSelected(int roomSelected) {
        this.roomSelected = roomSelected;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEmail() {
        return email;
    }

    public int getRoomSelected() {
        return roomSelected;
    }

    public String getDay() {
        return day;
    }
 @Override
    public String toString() {
        return email + " " + roomSelected + " " + day;
    }
    
    }

    

