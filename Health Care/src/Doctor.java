import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Doctor extends Person{

    private int doctorId;
    private String specialization;
    private  ArrayList<Date> availabilities = new ArrayList<>();
    private HashMap<Date,ArrayList<Appointment>> allAppointments = new HashMap<>();




    public Doctor(int doctorId, String name, String specialization, String contactNumber) {
        super(name,contactNumber);
        this.doctorId = doctorId;
        this.specialization = specialization;


    }

    public Doctor() {
        super();
    }


    public void setAppointment(Appointment appointment , Date date){
        ArrayList<Appointment>currentAppointment = this.allAppointments.get(date);
        if(currentAppointment==null){
            ArrayList<Appointment> tempArraylist = new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppointments.put(date,tempArraylist);
        }
        else{
            currentAppointment.add(appointment);
            this.allAppointments.put(date,currentAppointment);
        }
    }
    /*
    public void setAppointment(Appointment appointment, Date date) {
        ArrayList<Appointment> currentAppointments = allAppointments.getOrDefault(date, new ArrayList<>());
        currentAppointments.add(appointment);
        allAppointments.put(date, currentAppointments);
    }*/

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ArrayList<Date> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(ArrayList<Date> availabilities) {
        this.availabilities = availabilities;
    }
    public HashMap<Date,ArrayList<Appointment>>getAllAppointments(){
        return allAppointments;
    }


}
