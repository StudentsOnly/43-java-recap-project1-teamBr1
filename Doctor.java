import java.util.Objects;

public class Doctor {

    private int doctorID;
    private String doctorName;
    private String specialization;
    private static int lastID = 2000;

    public Doctor(String name, String specialization){
        this.doctorName = name;
        this.specialization = specialization;
        lastID++;
        this.doctorID = lastID;
    }
/*
    public Doctor(){
        this.doctorName = "-";
        this.specialization = "-";
        lastID++;
        this.doctorID = lastID;
    }
*/
    public int getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorID == doctor.doctorID;
    }


    /*
    public boolean equals(Doctor doctor) {
        return doctorID == doctor.doctorID;
    }
*/

    public void displayDoctorInfo(){
        System.out.println("\nDoctor (ID " + doctorID + "):");
        System.out.println("\tName: " + doctorName);
        System.out.println("\tSpecialization: " + specialization);

    }

    @Override
    public String toString() {
        return "Doctor [" +
                "ID = " + doctorID +
                ", '" + doctorName +
                "', '" + specialization +"']";
    }
}

