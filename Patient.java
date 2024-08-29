import java.util.Objects;

public class Patient {

    private String patientName;
    private int patientID;
    private int age;
    private String gender;
    private String patientContact;
    private static int lastID = 1000;


    public Patient(String name, int age, String gender, String contactInfo){
        this.patientName = name;
        this.age = ageValidator(age);
        this.gender = genderValidator(gender);
        this.patientContact = contactInfo;
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

    public void setName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = genderValidator(gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = ageValidator(age);

    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setContactInfo(String patientContact) {

        this.patientContact = patientContact;
    }

    public int ageValidator(int age){
        if(age > 0){
            return age;
        }else{
            return 0;
        }
    }

    public String genderValidator(String gender){
        if(gender.charAt(0) == 'm' || gender.charAt(0) == 'M'){
            return "masculine";
        }

        if(gender.charAt(0) == 'f' || gender.charAt(0) == 'F'){
            return "feminine";

        }
        return "not identified";
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
    public void displayInfo(){
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


