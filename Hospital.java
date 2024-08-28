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
        if (getPatient(patient.getPatientId()) == null)
        {
            return patients.add(patient);
        }
        return false;
    }

    public Patient getPatient(int id) {
        for (var p : patients) {
            if (Integer.compare(p.getPatientId(), id) == 0) {
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
        if (getDoctor(doctor.getDoctorId()) == null)
        {
            return doctors.add(doctor);
        }
        return false;
    }

    public Doctor getDoctor(int id) {
        for (var d : doctors) {
            if (Integer.compare(d.getDoctorId(), id) == 0) {
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
            if (Integer.compare(a.getId(), id) == 0) {
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
            if (Integer.compare(a.getId(), id) == 0) {
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
    }

    public Appointment addAppointment(Patient patient, Doctor doctor, String date, String time) {
        return new Appointment(doctor, patient, date, time);
    }

    public void displayUpcomingAppointments() {
      // upcoming appointments after now
    }
}
