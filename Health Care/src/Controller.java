
import java.util.*;

public class Controller {
    public ArrayList<Doctor> allDoctors = new ArrayList<>();
    public ArrayList<Patient> allPatients = new ArrayList<>();
    public static int NUMBER_OF_SLOTS=5;

    public void addNewDoctor() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor name :");
        String name = sc.nextLine();
        System.out.println("Enter doctor specialization :");
        String specialization = sc.nextLine();
        System.out.println("Enter doctor's contact number");
        String contact = sc.nextLine();
        Random random = new Random();

        Doctor tempDoctor = new Doctor(random.nextInt(), name, specialization, contact);
        allDoctors.add(tempDoctor);

    }

    public void viewAllDoctors() {
        for (Doctor dc : allDoctors) {
            System.out.println("Doctor's name :" + dc.getName() + "  doctor id : " + dc.getDoctorId() + " specialization of the doctor :" + dc.getSpecialization() + " and contact number : " + dc.getContactNumber());
        }
    }

    public void doctorAvailability() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor id you want to add availability :");
        int docId = sc.nextInt();
        Doctor selectedDoctor = null;
        for (Doctor dc : allDoctors) {
            if (dc.getDoctorId() == docId) {
                selectedDoctor = dc;
            }
        }
        if (selectedDoctor == null) {
            System.out.println("doctor not found !");
            return;
        }
        System.out.println("Enter the date you want to add availability :");
        int date = sc.nextInt();
        System.out.println("Enter the month you want to add availability :");
        int month = sc.nextInt();
        System.out.println("Enter the year you want to add availability :");
        int year = sc.nextInt();

        Date dateOfBooking = new Date(year, month, date);
        selectedDoctor.getAvailabilities().add(dateOfBooking);

    }

    public void addPatient(){
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient name :");
        String name =sc.next();
        System.out.println("Enter the patient id :");
        String patientId =sc.next();
        System.out.println("Enter patient contact number :");
        String contact = sc.next();
        System.out.println("Enter  the patient birthday :");
        String birthday =sc.next();

        Patient temp = new Patient(name,birthday,patientId,contact);
        allPatients.add(temp);
        System.out.println("patient is added ");
        System.out.println(allPatients.toString());

    }
    public void bookAppointment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor's id you want to make an appointment :");
        int docId =sc.nextInt();
        sc.nextLine();//character left after nextInt();
        System.out.println("Is this a General or Refferel Appointment ?(Press G for General, R for Referral) ");
        String appointmentType =sc.nextLine();

        System.out.println("Enter your patient Id :");
        String patientId = sc.nextLine();

        System.out.println("Enter the notes :");
        String notes = sc.nextLine();

        Doctor selectedDoctor = getDoctorById(docId);
        Patient selectedPatient =getPatientById(patientId);
        Doctor getDoctor =getDoctor(selectedDoctor);

        if(selectedDoctor == null || selectedPatient == null){
            System.out.println("invalid doctor or patient id");
            return;
        }

        System.out.println("Enter the day you want to add appointment :");
        int day =sc.nextInt();
        System.out.println("Enter the month you want to add appointment :");
        int month =sc.nextInt();
        System.out.println("Enter the year you want to add appointment :");
        int year =sc.nextInt();

        Date appointmentDate = new Date(year,month,day);

         String slotTime = null;
        Date getDate=getDate(appointmentDate);
        boolean isAvailable=checkavailability(selectedDoctor,appointmentDate);
        if(isAvailable){
            slotTime = getTimeForBooking(selectedDoctor,appointmentDate);
            if(slotTime != null){
                Appointment appointment = new Appointment(selectedDoctor,selectedPatient,notes,appointmentDate,"");
                selectedDoctor.setAppointment(appointment,appointmentDate);
                System.out.println(selectedDoctor.getAllAppointments().toString());
            }
            else{
                System.out.println("All the slots are filled ");
            }
        }
        else{
            System.out.println("doctor is not available on the selected Date");
        }

        if(appointmentType.charAt(0)=='G'){
            System.out.println("Enter the patient notes :");
            String patientNotes=sc.nextLine();
            GeneralAppointment appointment= new GeneralAppointment(selectedDoctor,selectedPatient,notes,appointmentDate,slotTime,patientNotes);
            selectedDoctor.setAppointment(appointment,appointmentDate);
        }else if(appointmentType.charAt(0)=='R'){
            System.out.println("Enter the referral doctor's ID :");
            int referralDocId = sc.nextInt();
            sc.nextLine();
            Doctor referralDoctor =getDoctorById(referralDocId);
            if(referralDoctor==null){
                System.out.println("Invalid referral doctor ID");
                return;
            }
            System.out.println("Enter the referral notes :");
            String refnotes=sc.nextLine();

            ReferralAppointment refAppointment = new ReferralAppointment(selectedDoctor,selectedPatient,notes,appointmentDate,slotTime,referralDoctor,refnotes);
            System.out.println("Enter the referral doctor notes :");
            String referralDoctorNotes=sc.nextLine();
            refAppointment.setReferralDoctorNotes(referralDoctorNotes);

            selectDoctor.setAppointment(refAppointment,appointmentDate);
        }else{
            System.out.println("Invalid Appointment type .");
        }
    }
    private String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking){
        for (Map.Entry<Date,ArrayList<Appointment>> appointment :selectedDoctor.getAllAppointments().entrySet()) {
            if(appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size();
                if(numberOfSlots > NUMBER_OF_SLOTS-1){
                    return null;
                }
                System.out.println("we can make a booking");
                int time = 17+appointment.getValue().size();
                String strTime =time+" :00";
                return strTime;
            }
        }
        return "17:00";
    }

    private boolean checkavailability(Doctor selectedDoctor, Date dateOfBooking){
        for (Date date:selectedDoctor.getAvailabilities()) {
            if(date.equals(dateOfBooking)){
                return true;
            }
        }
        return false;
    }


   public Patient getPatientById(String id){
       for (Patient p: allPatients) {
           if(p.getPatientId().equals(id)){
               return p;
           }
       }
       return null;
   }

    public Doctor getDoctorById(int id){
        for (Doctor dc :allDoctors) {
            if(dc.getDoctorId()==id){
                return dc;
            }
        }
        return null;
    }
    public Doctor selectDoctor;
    public Date selectDate;

    public Doctor getDoctor(Doctor doc){
       this.selectDoctor=doc;
       return selectDoctor;
    }
    public Date getDate(Date date){
        this.selectDate=date;
        return selectDate;
    }


    public void printAllAppointment(){
        Doctor select = selectDoctor;
            if(select==null){
                System.out.println("No Appointment Found !");
                return;
                //without selectDoctor we can't add appointment
            }
        for (Map.Entry<Date,ArrayList<Appointment>> appointment :selectDoctor.getAllAppointments().entrySet()) {

            System.out.println(String.format(String.format("Appointments for Dr : " + select.getName() + "  Doctor Id : ("+ select.getDoctorId() +"),  Appointment Date : " +appointment.getKey()+", Appointment "+appointment.getValue())));
        }
    }

}









