public class Doctor {

    int doctorId;
    String name;
    String specialization;
    String contactNumber;

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
