import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private ArrayList<Treatment> treatments;
    private static int lastID = 0;
    private int appointmentID;
    private LocalDate date;
    private String timeSlot;

    public Appointment(Doctor doctor, Patient patient, LocalDate date, String timeSlot){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.timeSlot = timeSlot;
        lastID++;
        this.appointmentID = lastID;
        this.treatments = new ArrayList<>();
    }
    public Appointment(Doctor doctor, Patient patient, LocalDate date, String timeSlot, ArrayList<Treatment> treatments){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.timeSlot = timeSlot;
        lastID++;
        this.appointmentID = lastID;
        this.treatments = treatments;
    }
/*
    public Appointment(){
        lastID++;
        this.appointmentID = lastID;
        this.treatments = new ArrayList<>();
        this.date = LocalDate.now();
    }
*/
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentID == that.appointmentID;
    }

    /*
        public boolean equals(Appointment app) {
            return appointmentID == app.appointmentID;
        }
    */
    public double calculateBill(){
        double sum = 0;
        for(Treatment treatment:treatments){
            sum += treatment.getTreatmentPrice();
        }
        return sum;
    }

    public void displayAppointmentInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);

        System.out.println("\nAppointment (ID " + appointmentID + "):");
        System.out.println("\tDate: " + formattedDate);
        System.out.println("\t" + doctor);
        System.out.println("\t" + patient);
        System.out.println("\tTreatments:");
        if(treatments.isEmpty()){
            System.out.println("\t\t-");
        }else{
            for(Treatment treatment:treatments){
                System.out.println("\t\t- " + treatment);
            }
        }
        System.out.println("\tTotal bill: " + String.format("%.2f", calculateBill()) + "$");

    }
}
