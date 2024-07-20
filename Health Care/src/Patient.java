import java.util.ArrayList;

public class Patient {

    String name;
    String birthday;
    String contactNumber;
    String patientId;


    public Patient(String name, String birthday, String contactNumber, String patientId) {
        this.name = name;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.patientId = patientId;
    }
    public char getPatientType(String patientId){
        return patientId.charAt(0);
    }


}
