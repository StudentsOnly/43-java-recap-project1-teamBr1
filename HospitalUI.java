import java.util.*;

public class HospitalUI {
    public static void interact(Hospital hospital){

        Scanner scanner = new Scanner(System.in);
        // User Interface
        while (true) {
            try {
                System.out.println("\nHospital Management System");
                System.out.println("1. Register a Patient");
                System.out.println("2. Add a Doctor to the Hospital");
                System.out.println("3. Add a Treatment to the Hospital");
                System.out.println("4. Schedule an Appointment");
                System.out.println("5. Cancel an Appointment");
                System.out.println("6. View All Patients");
                System.out.println("7. View All Doctors");
                System.out.println("8. View All Treatments");
                System.out.println("9. View All Appointments");
                System.out.println("10. Show Patient Info by ID or Name");
                System.out.println("11. Update Patient Info by ID or Name");
                System.out.println("12. Show Doctor Info by ID or Name");
                System.out.println("13. Show Treatment Info by ID or Name");
                System.out.println("14. Show Appointment Info by ID");
                System.out.println("15. Show Billing Info for Appointment");
                System.out.println("16. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        // Register a patient
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter patient age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter patient gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter patient contact information: ");
                        String contactInfo = scanner.nextLine();
                        boolean patAdded = hospital.addPatient(new Patient(name, age, gender, contactInfo));
                        if (patAdded) {
                            System.out.println("Patient added successfully");
                        }
                        else
                            System.out.println("Patient not added successfully");


                        break;

                    case 2: // Add a Doctor to the Hospital
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter doctor specialization: ");
                        String doctorSpecialization = scanner.nextLine();
                        boolean docAdded = hospital.addDoctor(new Doctor(doctorName, doctorSpecialization));
                        if (docAdded) {
                            System.out.println("Doctor added successfully");
                        }
                        else
                            System.out.println("Doctor not added successfully");
                        break;

                    case 3: // Add a Treatment to the Hospital
                        System.out.print("Enter treatment name: ");
                        String treatmentName = scanner.nextLine();
                        System.out.print("Enter treatment price:");
                        double treatmentPrice = scanner.nextDouble();
                        boolean treatAdd = hospital.addTreatment(new Treatment(treatmentName, treatmentPrice));
                        if (treatAdd)
                            System.out.println("Treatment added successfully");
                        else
                            System.out.println("Treatment not added successfully");
                        break;

                    case 4:
                        // Schedule an appointment
                        System.out.print("Enter patient ID or name: ");
                        String patientSearch = scanner.nextLine();

                        Patient patient = isInteger(patientSearch) ?
                                hospital.getPatient(Integer.parseInt(patientSearch)) :
                                hospital.getPatient(patientSearch);
                        if (patient == null) {
                            System.out.println("Patient not found.");
                            break;
                        }

                        System.out.print("Enter doctor ID or name: ");
                        String doctorSearch = scanner.nextLine();
                        Doctor doctor = isInteger(doctorSearch) ?
                                hospital.getDoctor(Integer.parseInt(doctorSearch)) :
                                hospital.getDoctor(doctorSearch);
                        if (doctor == null) {
                            System.out.println("Doctor not found.");
                            break;
                        }
                        System.out.print("Enter appointment date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Choose from available timeslots:");
                        hospital.showFreeTimeSlot(doctor, date);
                        System.out.print("Enter appointment time slot (8-16): ");
                        String timeSlot = scanner.nextLine();
                        Appointment appointment = hospital.addAppointment(patient, doctor, date, timeSlot);
                        if (appointment != null) {
                            System.out.println("Appointment added successfully");
                        System.out.print("Choose from available treatments:");
                        hospital.displayTreatments();

                        boolean stopAdding = false;
                        System.out.println("Enter Treatment ID to Add or 0 to go back to the Main menu");
                        do {
                            System.out.println("Enter the ID or 0");
                            int treatId = scanner.nextInt();
                            stopAdding = treatId == 0;
                            if (!stopAdding) {

                                Treatment treatment = hospital.getTreatment(treatId);
                                if (treatment == null) {
                                    System.out.println("Treatment not found.");
                                } else {
                                    boolean treatAdded = appointment.addTreatment(treatment);
                                    if (treatAdded) {
                                        System.out.println("Treatment added to appointment successfully");
                                    }
                                    else
                                        System.out.println("Treatment not added to appointment successfully");
                                }
                            }

                        } while (!stopAdding);}
                        else System.out.println("Appointment not added successfully");
                        break;
                    case 5:
                        System.out.print("All appointments: ");

                        // View all appointments
                        hospital.displayAppointments();

                        // Show Appointment Info by ID or Name
                        System.out.print("Enter appointment ID to cancel: ");
                        int cancelAppId = scanner.nextInt();
                        Appointment foundApp = hospital.getAppointment(cancelAppId);

                        if (foundApp != null) {
                              hospital.cancelAppointment(cancelAppId);
                              System.out.println("Appointment cancelled successfully");
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;

                    case 6:
                        // View all patients
                        System.out.print("All patients: ");
                        hospital.displayPatients();
                        break;

                    case 7:
                        System.out.print("All doctors: ");
                        hospital.displayDoctors();
                        break;

                    case 8:
                        // View all appointments
                        System.out.print("All treatments: ");
                        hospital.displayTreatments();
                        break;


                    case 9:
                        // View all appointments
                        System.out.print("All appointments: ");
                        hospital.displayAppointments();
                        break;

                    case 10:
                        //Show Patient Info by ID or name
                        System.out.print("Enter patient ID or name: ");
                        String patientIdOrName = scanner.nextLine();

                        Patient foundPatient = isInteger(patientIdOrName) ?
                                hospital.getPatient(Integer.parseInt(patientIdOrName)) :
                                hospital.getPatient(patientIdOrName);
                        if (foundPatient != null) {
                            foundPatient.displayInfo();
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;

                    case 11:
                        //Update Patient Info by ID or name
                        System.out.print("Enter patient ID or name: ");
                        String patientIdOrNameToUpdate = scanner.nextLine();

                        Patient foundPatientToUpdate = isInteger(patientIdOrNameToUpdate) ?
                                hospital.getPatient(Integer.parseInt(patientIdOrNameToUpdate)) :
                                hospital.getPatient(patientIdOrNameToUpdate);
                        if (foundPatientToUpdate != null) {
                            int UpdateField = 0;
                            while (UpdateField != 5) {
                                System.out.println("Please choose field to update:");
                                System.out.println("1. Patient name");
                                System.out.println("2. Patient age");
                                System.out.println("3. Patient gender");
                                System.out.println("4. Patient contact information");
                                System.out.println("5. Back to the Main menu");
                                System.out.print("Choose an option numbers 1-5: ");
                                UpdateField = scanner.nextInt();
                                switch (UpdateField) {
                                    case 1:
                                        System.out.print("Enter patient name: ");
                                        String updatedName = scanner.nextLine();
                                        foundPatientToUpdate.setName(updatedName);
                                        break;
                                    case 2:
                                        System.out.print("Enter patient age: ");
                                        int updatedAge = scanner.nextInt();
                                        foundPatientToUpdate.setAge(updatedAge);
                                        break;
                                    case 3:
                                        System.out.print("Enter patient gender: ");
                                        String updatedGender = scanner.nextLine();
                                        foundPatientToUpdate.setGender(updatedGender);
                                        break;
                                    case 4:
                                        System.out.print("Enter patient contact information: ");
                                        String updatedContactInfo = scanner.nextLine();
                                        foundPatientToUpdate.setContactInfo(updatedContactInfo);
                                        break;
                                    case 5:
                                        System.out.print("Patient information updated.");
                                        break;
                                    default:
                                        System.out.println("Invalid option. Please try again.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;

                    case 12:
                        //  Show Doctor Info by ID or name
                        System.out.print("Enter doctor ID or name: ");
                        String doctorIdOrName = scanner.nextLine();
                        Doctor foundDoctor = isInteger(doctorIdOrName) ?
                                hospital.getDoctor(Integer.parseInt(doctorIdOrName)) :
                                hospital.getDoctor(doctorIdOrName);
                        if (foundDoctor != null) {
                            foundDoctor.displayInfo();
                        } else {
                            System.out.println("Doctor not found.");
                        }
                        break;

                    case 13:
                        // Show Treatment Info by ID or Name
                        System.out.print("Enter treatment ID or name: ");
                        String treatmentIdOrName = scanner.nextLine();
                        Treatment foundTreatment = isInteger(treatmentIdOrName) ?
                                hospital.getTreatment(Integer.parseInt(treatmentIdOrName)) :
                                hospital.getTreatment(treatmentIdOrName);

                        if (foundTreatment != null) {
                            foundTreatment.displayInfo();
                        } else {
                            System.out.println("Treatment not found.");
                        }
                        break;
                    case 14:
                        // Show Appointment Info by ID or Name
                        System.out.print("Enter appointment ID: ");
                        int appointmentId = scanner.nextInt();
                        Appointment foundAppointment = hospital.getAppointment(appointmentId);

                        if (foundAppointment != null) {
                            foundAppointment.displayInfo();
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;
                    case 15:
                        System.out.print("All appointments: ");

                        // View all appointments
                        hospital.displayAppointments();

                        // Show Appointment Info by ID or Name
                        System.out.print("Enter appointment ID to show billing Information: ");
                        int billAppId = scanner.nextInt();
                        Appointment billApp = hospital.getAppointment(billAppId);

                        if (billApp != null) {
                            hospital.showBillingInfo(billAppId);
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;
                    case 16:
                        // Exit the program
                        System.out.println("Exiting the system...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            }
            catch(InputMismatchException exception)
            {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }

    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // null or empty strings are not integers
        }
        return str.matches("-?\\d+");  // matches optional "-" followed by digits
    }
}