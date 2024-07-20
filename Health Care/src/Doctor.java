import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Doctor {

    int doctorId;
    String name;
    String specialization;
    String contactNumber;
    public ArrayList<Date> availabilities = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(int doctorId, String name, String specialization, String contactNumber) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;

    }
    public boolean isPhysician(String specialization){
        if(specialization.endsWith("Physician")){
            return true;
        }else{
            return false;
        }
    }

}
