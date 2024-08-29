import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Hospital {

    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Treatment> treatments;

    public Hospital() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public boolean addPatient(Patient patient) {
        if (getPatient(patient.getPatientID()) == null)
        {
            return patients.add(patient);
        }
        return false;
    }

    public Patient getPatient(int id) {
        for (var p : patients) {
            if (Integer.compare(p.getPatientID(), id) == 0) {
                return p;
            }
        }
        return null;
    }

    public Patient getPatient(String name) {
        for (var p : patients) {
            if (p.getPatientName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public boolean addDoctor(Doctor doctor) {
        if (getDoctor(doctor.getDoctorID()) == null)
        {
            return doctors.add(doctor);
        }
        return false;
    }

    public Doctor getDoctor(int id) {
        for (var d : doctors) {
            if (Integer.compare(d.getDoctorID(), id) == 0) {
                return d;
            }
        }
        return null;
    }

    public Doctor getDoctor(String name) {
        for (var d : doctors) {
            if (d.getDoctorName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public boolean addAppointment(Appointment appointment) {
        if (getAppointment(appointment.getAppointmentID()) == null) {
            return appointments.add(appointment);
        }
        return false;
    }

    public Appointment getAppointment(int id) {
        for (var a : appointments) {
            if (Integer.compare(a.getAppointmentID(), id) == 0) {
                return a;
            }
        }
        return null;
    }

    public boolean addTreatment(Treatment treatment) {
        if (getTreatment(treatment.getTreatmentID()) == null) {
            return treatments.add(treatment);
        }
        return false;
    }
  
    public Treatment getTreatment(int id) {
        for (var a : treatments) {
            if (Integer.compare(a.getTreatmentID(), id) == 0) {
                return a;
            }
        }
        return null;
    }
  
    public Treatment getTreatment(String name) {
       for (var d : treatments) {
           if (d.getTreatmentName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public void displayPatients() {
        System.out.println();
        System.out.println("Patients");
        System.out.println("------------");
        patients.forEach(System.out::println);
        System.out.println();
    }

    public void displayDoctors() {
        System.out.println();
        System.out.println("Doctors");
        System.out.println("------------");
        doctors.forEach(System.out::println);
        System.out.println();
    }

    public void displayAppointments() {
        System.out.println();
        System.out.println("Appointments");
        System.out.println("------------");
        appointments.forEach(System.out::println);
        System.out.println();
    }
  
      public void displayTreatments() {
        System.out.println();
        System.out.println("Treatments");
        System.out.println("------------");
        treatments.forEach(System.out::println);
        System.out.println();
    }

    public void showFreeTimeSlot(Doctor doctor, String date) {
        try {
            System.out.println();
            System.out.println("Free Time Slots");
            System.out.println("------------");
            String[] timeSlots = new String[9];
            for (var a : appointments) {
                if (a.getDoctor() == doctor) {
                    int timeSlot = Integer.parseInt(a.getTimeSlot());
                    timeSlots[timeSlot - 8] = a.getTimeSlot();
                }
            }
            for (int i = 0; i < timeSlots.length; i++) {
                if (timeSlots[i] == null) {
                    System.out.println(i + 8);
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error in showFreeTimeSlot: " + e.getMessage());
        }
    }

    public Appointment addAppointment(Patient patient, Doctor doctor, String dateString, String time) {

        try {
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return new Appointment(doctor, patient, date, time);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + dateString);
            return null;
        }
    }

    public void displayUpcomingAppointments() {
        System.out.println();
        System.out.println("Upcoming Appointments");
        System.out.println("------------");
        appointments.forEach(s -> {if(s.getDate().isAfter(LocalDate.now())) {
            System.out.println(s);
        }});
        System.out.println();
    }

    public void cancelAppointment(int cancelAppId) {
        Appointment appointment = getAppointment(cancelAppId);
        if (appointment != null) {
            appointments.remove(appointment);
        }
    }

    public void showBillingInfo(int appointmentID) {

        Appointment appointment = getAppointment(appointmentID);
        if (appointment != null) {
            System.out.println("Appointment ID: " + appointmentID
                    + "Price: $" + appointment.calculateBill());
        }
    }

}
