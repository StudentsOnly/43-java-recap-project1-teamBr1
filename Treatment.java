import java.util.Objects;

public class Treatment {

    private String treatmentName;
    private static int lastID;
    private int treatmentID;
    private double treatmentPrice;

    public Treatment(){
        lastID++;
        this.treatmentID = lastID;
        this.treatmentName = "-";
    }

    public Treatment(String name, double price){
        this.treatmentName = name;
        this.treatmentPrice = price;
        lastID++;
        this.treatmentID = lastID;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getTreatmentID() {
        return treatmentID;
    }


    public double getTreatmentPrice() {
        return treatmentPrice;
    }

    public void setTreatmentPrice(double treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return treatmentID == treatment.treatmentID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(treatmentID);
    }

    /*
        public boolean equals(Treatment treatment) {
            return treatmentID == treatment.treatmentID;
        }
    */
    public void displayTreatmentInfo(){
        System.out.println("\nTreatment (ID " + treatmentID + ", '" + treatmentName + "'):");
        System.out.println("\tPrice: " + String.format("%.2f", treatmentPrice) + "$");
    }

    @Override
    public String toString() {
        return "Treatment [" +
                "ID = " + treatmentID +
                ", '" + treatmentName +
                "', " + String.format("%.2f", treatmentPrice) + "$" +"]";
    }
}

