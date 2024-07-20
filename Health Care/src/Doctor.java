import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Doctor {

    int doctorId;
    String name;
    String specialization;
    String contactNumber;
    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

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
    public static void addNewDoctor(){
        System.out.println("Enter doctor name :");
        String name=sc.nextLine();
        System.out.println("Enter doctor specialization :");
        String specialization =sc.nextLine();
        System.out.println("Enter doctor's contact number");
        String contact =sc.nextLine();
        Random random = new Random();

        Doctor tempDoctor = new Doctor(random.nextInt(),name,specialization,contact);
        allDoctors.add(tempDoctor);

    }
    public static void viewAllDoctors(){
        for (Doctor dc:allDoctors) {
            System.out.println("Doctor's name :"+dc.name+"  doctor id : "+dc.doctorId+" specialization of the doctor :" +dc.specialization+" and contact number : "+dc.contactNumber);
        }
    }


}
