import java.util.ArrayList;

public class Patient extends Person{


    private String birthday;
    private String patientId;



    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Patient(String name, String birthday, String patientId,String contactNumber) {
        super(name,contactNumber);
        this.birthday = birthday;
        this.patientId = patientId;
    }
    public char getPatientType(String patientId){
        return patientId.charAt(0);
    }


}
