package pharmacy;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Console menu class used to run and test the Pharmacy Management System.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MedicationTrackingSystem system = new MedicationTrackingSystem();

    public static void main(String[] args) {
        // loadSampleData();
        boolean running = true;

        System.out.println("Welcome to the Pharmacy Management System");
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    addMedication();
                    break;
                case 4:
                    editPatient();
                    break;
                case 5:
                    editDoctor();
                    break;
                case 6:
                    editMedication();
                    break;
                case 7:
                    deletePatient();
                    break;
                case 8:
                    deleteDoctor();
                    break;
                case 9:
                    deleteMedication();
                    break;
                case 10:
                    searchPatient();
                    break;
                case 11:
                    searchDoctor();
                    break;
                case 12:
                    searchMedication();
                    break;
                case 13:
                    addPatientToDoctor();
                    break;
                case 14:
                    acceptPrescription();
                    break;
                case 15:
                    System.out.println(system.generateFullReport());
                    break;
                case 16:
                    System.out.println(system.generateExpiredMedicationReport());
                    break;
                case 17:
                    prescriptionsByDoctorReport();
                    break;
                case 18:
                    patientPrescriptionDrugsPastYearReport();
                    break;
                case 19:
                    restockAllMedications();
                    break;
                case 20:
                    listAllData();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose from the menu.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n================ MAIN MENU ================");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Add Medication");
        System.out.println("4. Edit Patient");
        System.out.println("5. Edit Doctor");
        System.out.println("6. Edit Medication");
        System.out.println("7. Delete Patient");
        System.out.println("8. Delete Doctor");
        System.out.println("9. Delete Medication");
        System.out.println("10. Search Patient by Name");
        System.out.println("11. Search Doctor by Name");
        System.out.println("12. Search Medication by Name");
        System.out.println("13. Add Patient to Doctor");
        System.out.println("14. Accept Prescription");
        System.out.println("15. Generate Full Report");
        System.out.println("16. Generate Expired Medication Report");
        System.out.println("17. Print Prescriptions by Doctor");
        System.out.println("18. Print Patient Prescription Drug Names for Past Year");
        System.out.println("19. Restock All Medications");
        System.out.println("20. List All Current Data");
        System.out.println("0. Exit");
        System.out.println("===========================================");
    }

    private static void addPatient() {
        int id = readInt("Patient ID: ");
        String name = readString("Patient name: ");
        int age = readInt("Patient age: ");
        String phone = readString("Phone number: ");
        system.addPatient(new Patient(id, name, age, phone));
        System.out.println("Patient added if the ID was unique.");
    }

    private static void addDoctor() {
        int id = readInt("Doctor ID: ");
        String name = readString("Doctor name: ");
        int age = readInt("Doctor age: ");
        String phone = readString("Phone number: ");
        String specialization = readString("Specialization: ");
        system.addDoctor(new Doctor(id, name, age, phone, specialization));
        System.out.println("Doctor added if the ID was unique.");
    }

    private static void addMedication() {
        int id = readInt("Medication ID: ");
        String name = readString("Medication name: ");
        String dose = readString("Dose: ");
        int stock = readInt("Quantity in stock: ");
        LocalDate expiryDate = readDate("Expiry date (YYYY-MM-DD): ");
        system.addMedication(new Medication(id, name, dose, stock, expiryDate));
        System.out.println("Medication added if the ID was unique.");
    }

    private static void editPatient() {
        int id = readInt("Patient ID to edit: ");
        String name = readString("New patient name: ");
        int age = readInt("New patient age: ");
        String phone = readString("New phone number: ");
        boolean edited = system.editPatient(id, name, age, phone);
        System.out.println(edited ? "Patient updated." : "Patient not found.");
    }

    private static void editDoctor() {
        int id = readInt("Doctor ID to edit: ");
        String name = readString("New doctor name: ");
        int age = readInt("New doctor age: ");
        String phone = readString("New phone number: ");
        String specialization = readString("New specialization: ");
        boolean edited = system.editDoctor(id, name, age, phone, specialization);
        System.out.println(edited ? "Doctor updated." : "Doctor not found.");
    }

    private static void editMedication() {
        int id = readInt("Medication ID to edit: ");
        String name = readString("New medication name: ");
        String dose = readString("New dose: ");
        int stock = readInt("New quantity in stock: ");
        LocalDate expiryDate = readDate("New expiry date (YYYY-MM-DD): ");
        boolean edited = system.editMedication(id, name, dose, stock, expiryDate);
        System.out.println(edited ? "Medication updated." : "Medication not found.");
    }

    private static void deletePatient() {
        int id = readInt("Patient ID to delete: ");
        boolean deleted = system.deletePatient(id);
        System.out.println(deleted ? "Patient deleted." : "Patient not found.");
    }

    private static void deleteDoctor() {
        int id = readInt("Doctor ID to delete: ");
        boolean deleted = system.deleteDoctor(id);
        System.out.println(deleted ? "Doctor deleted." : "Doctor not found.");
    }

    private static void deleteMedication() {
        int id = readInt("Medication ID to delete: ");
        boolean deleted = system.deleteMedication(id);
        System.out.println(deleted ? "Medication deleted." : "Medication not found.");
    }

    private static void searchPatient() {
        String name = readString("Patient name to search: ");
        printList(system.searchPatientsByName(name));
    }

    private static void searchDoctor() {
        String name = readString("Doctor name to search: ");
        printList(system.searchDoctorsByName(name));
    }

    private static void searchMedication() {
        String name = readString("Medication name to search: ");
        printList(system.searchMedicationsByName(name));
    }

    private static void addPatientToDoctor() {
        int patientId = readInt("Patient ID: ");
        int doctorId = readInt("Doctor ID: ");
        boolean added = system.addPatientToDoctor(patientId, doctorId);
        System.out.println(added ? "Patient assigned to doctor." : "Patient or doctor not found.");
    }

    private static void acceptPrescription() {
        int prescriptionId = readInt("Prescription ID: ");
        int doctorId = readInt("Doctor ID: ");
        int patientId = readInt("Patient ID: ");
        int medicationId = readInt("Medication ID: ");
        Prescription prescription = system.acceptPrescription(prescriptionId, doctorId, patientId, medicationId);
        System.out.println(prescription != null ? "Prescription accepted: " + prescription : "Could not create prescription. Check IDs and duplicate prescription ID.");
    }

    private static void prescriptionsByDoctorReport() {
        int doctorId = readInt("Doctor ID: ");
        System.out.println(system.generatePrescriptionsByDoctorReport(doctorId));
    }

    private static void patientPrescriptionDrugsPastYearReport() {
        int patientId = readInt("Patient ID: ");
        System.out.println(system.generatePatientPrescriptionDrugNamesForPastYear(patientId));
    }

    private static void restockAllMedications() {
        int amount = readInt("Amount to add to every medication: ");
        system.restockAllMedications(amount);
        System.out.println("All medications restocked by " + amount + ".");
    }

    private static void listAllData() {
        System.out.println("\nPatients:");
        printList(system.getPatients());
        System.out.println("\nDoctors:");
        printList(system.getDoctors());
        System.out.println("\nMedications:");
        printList(system.getMedications());
        System.out.println("\nPrescriptions:");
        printList(system.getPrescriptions());
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException exception) {
                System.out.println("Please enter the date in YYYY-MM-DD format.");
            }
        }
    }

    private static void printList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Object item : list) {
            System.out.println(item);
        }
    }

}
