import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Doctor {

    int doctorId;
    String name;
    String specialization;
    String contactNumber;
    public  ArrayList<Doctor> allDoctors = new ArrayList<>();
    public ArrayList<Date> availabilities = new ArrayList<>();

    public  Scanner sc = new Scanner(System.in);

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
    public void addNewDoctor(){
        System.out.println("Enter doctor name :");
        String name=sc.next();
        System.out.println("Enter doctor specialization :");
        String specialization =sc.next();
        System.out.println("Enter doctor's contact number");
        String contact =sc.next();
        Random random = new Random();

        Doctor tempDoctor = new Doctor(random.nextInt(),name,specialization,contact);
        allDoctors.add(tempDoctor);

    }
    public  void viewAllDoctors(){
        for (Doctor dc:allDoctors) {
            System.out.println("Doctor's name :"+dc.name+"  doctor id : "+dc.doctorId+" specialization of the doctor :" +dc.specialization+" and contact number : "+dc.contactNumber);
        }
    }
    public void doctorAvailability(){
        System.out.println("Enter doctor id you want to add availability :");
        int docId =sc.nextInt();
        Doctor selectedDoctor = null;
        for (Doctor dc:allDoctors) {
            if(dc.doctorId==docId){
                selectedDoctor=dc;
            }
        }
        if(selectedDoctor==null){
            System.out.println("doctor not found !");
            return;
        }
        System.out.println("Enter the date you want to add availability :");
        int date =sc.nextInt();
        System.out.println("Enter the month you want to add availability :");
        int month=sc.nextInt();
        System.out.println("Enter the year you want to add availability :");
        int year =sc.nextInt();

        Date booking = new Date(year,month,date);
        selectedDoctor.availabilities.add(booking);
    }


}
