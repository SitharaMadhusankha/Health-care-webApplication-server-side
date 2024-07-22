import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Doctor {

    int doctorId;
    String name;
    String specialization;
    String contactNumber;
    public ArrayList<Date> availabilities = new ArrayList<>();
    public HashMap<Date,ArrayList<Appointment>> allAppointments = new HashMap<>();

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

    public void setAppointment(Appointment appointment , Date date){
        ArrayList<Appointment>currentAppointment=this.allAppointments.get(date);
        if(currentAppointment==null){
            ArrayList<Appointment> tempArraylist = new ArrayList();
            tempArraylist.add(appointment);
            this.allAppointments.put(date,tempArraylist);
        }
        else{
            currentAppointment.add(appointment);
            this.allAppointments.put(date,currentAppointment);
        }
    }
}
