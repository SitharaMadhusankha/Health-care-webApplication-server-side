import java.util.Date;

public class ReferralAppointment extends Appointment{

    private Doctor referralDoctor;
    private String notes;
    private String referralDoctorNotes;

    public ReferralAppointment(Doctor doctor, Patient patient, String notes, Date date, String time, Doctor referralDoctor, String notes1) {
        super(doctor, patient, notes, date, time);
        this.referralDoctor = referralDoctor;
        this.notes = notes1;
    }

    public Doctor getReferralDoctor() {
        return referralDoctor;
    }

    public void setReferralDoctor(Doctor referralDoctor) {
        this.referralDoctor = referralDoctor;
    }

    @Override
    public String getNotes() {
        return notes;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReferralDoctorNotes() {
        return referralDoctorNotes;
    }

    public void setReferralDoctorNotes(String referralDoctorNotes) {
        this.referralDoctorNotes = referralDoctorNotes;
    }
}
