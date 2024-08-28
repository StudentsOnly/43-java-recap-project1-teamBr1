import java.util.ArrayList;
import java.util.List;

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
        return appointments.add(appointment);
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
        return treatments.add(treatment);
    }

    public Treatment getTreatment(int id) {
        for (var a : treatments) {
            if (Integer.compare(a.getId(), id) == 0) {
                return a;
            }
        }
        return null;
    }

    public void displayPatient(int id) {
        System.out.println(getPatient(id));
    }

    public void displayDoctor(int id) {
        System.out.println(getDoctor(id));
    }

    public void displayAppointment(int id) {
        System.out.println(getAppointment(id));
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
}
