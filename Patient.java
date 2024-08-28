import java.util.Objects;

public class Patient {

    private String patientName;
    private int patientID;
    private int age;
    private String gender;
    private String patientContact;
    private static int lastID = 1000;


    public Patient(String name, int age, String gender, String contact){
        this.patientName = name;
        setAge(age);
        setGender(gender);
        this.patientContact = contact;
        lastID++;
        this.patientID = lastID;

    }
/*
    public Patient(){
        this.patientName = "-";
        this.age = 0;
        this.gender = "-";
        this.patientContact = "-";
        lastID++;
        this.patientID = lastID;
    }
*/
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.charAt(0) == 'm' || gender.charAt(0) == 'M'){
            this.gender = "masculine";
            return;
        }

        if(gender.charAt(0) == 'f' || gender.charAt(0) == 'F'){
            this.gender = "feminine";
            return;
        }
            this.gender = "not identified";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        }else{
            this.age = 0;
        }

    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID;
    }


 /*
    public boolean equals(Patient p) {
        return Objects.equals(patientID, p.patientID);
    }

*/

    public void displayPatientInfo(){
        System.out.println("\nPatient (ID " + patientID + "):");
        System.out.println("\tName: " + patientName);
        System.out.println("\tAge: " + age);
        System.out.println("\tGender: " + gender);
        System.out.println("\tContact Info: " + patientContact);
    }

    @Override
    public String toString() {
        return "Patient [" +
                "ID = " + patientID +
                ", '" + patientName + "']";
    }
}

