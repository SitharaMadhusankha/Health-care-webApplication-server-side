import java.util.Scanner;

public class HealthCareWebApplication {
    Controller controller = new Controller();
    public void mainMenu(){
        boolean loop1=true;
        while(loop1){
            Scanner sc = new Scanner(System.in);
            System.out.println("if you are a hospital administrator please press 1,if you are a patient please press 2, press 3 to exit ");
            int main =sc.nextInt();
            if(main==1){
                hospitalAdministratorMenu();
            }else if(main==2){
                patientMenu();
            }else if(main==3){
                System.out.println("exit");
                loop1=false;
            }else{
                System.out.println("invalid input!");
            }
        }

    }

    public void hospitalAdministratorMenu(){
        boolean loop2 =true;
        while(loop2){
            Scanner sc =new Scanner(System.in);
            System.out.println("press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
            int admin =sc.nextInt();
            if(admin==1){
                controller.addNewDoctor();
            }else if(admin==2){
                controller.doctorAvailability();
            }else if(admin==3){
                System.out.println("exit");
                loop2=false;
            }else{
                System.out.println("invalid input!");
            }
        }

    }
    public void patientMenu(){
        boolean loop3 =true;
        while(loop3){
            Scanner sc = new Scanner(System.in);
            System.out.println("press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor's bookings , press 4 to register patient and press 5 to exit");
            int patient=sc.nextInt();
            if(patient==1){
                controller.viewAllDoctors();
            }else if(patient==2){
                System.out.println("book an appointment");
            }else if(patient==3){
                System.out.println("view a selected doctor bookings");
            }else if(patient==4){
                System.out.println("register patient");
            }else if(patient==5){
                System.out.println("exit");
                loop3=false;
            }else{
                System.out.println("invalid input!");
            }
        }

    }

    public static void main(String[] args) {
        HealthCareWebApplication h1 = new HealthCareWebApplication();
        h1.mainMenu();

    }
}
