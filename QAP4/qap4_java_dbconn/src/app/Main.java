package com.qap4.app;

import com.qap4.model.Drug;
import com.qap4.model.Patient;
import com.qap4.repository.DrugFileRepository;
import com.qap4.repository.PatientRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/** Menu-driven entry point for QAP 4. */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final DrugFileRepository DRUG_FILE_REPOSITORY =
            new DrugFileRepository(Path.of("data", "drugs.txt"));
    private static final PatientRepository PATIENT_REPOSITORY = new PatientRepository();

    private Main() {
    }

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("QAP 4 - Java Persistence Application");

        while (running) {
            printMenu();
            int option = readInt("Choose an option: ");
            System.out.println();

            switch (option) {
                case 1 -> saveDrugToFile();
                case 2 -> readDrugsFromFile();
                case 3 -> savePatientToDatabase();
                case 4 -> readPatientsFromDatabase();
                case 5 -> {
                    running = false;
                    System.out.println("Application closed.");
                }
                default -> System.out.println("Invalid option. Please choose 1 to 5.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("1. Save drug data to the text file");
        System.out.println("2. Read all drug data from the text file");
        System.out.println("3. Save patient data to PostgreSQL");
        System.out.println("4. Read all patient data from PostgreSQL");
        System.out.println("5. Exit");
        System.out.println("--------------------------------------------");
    }

    private static void saveDrugToFile() {
        try {
            Drug drug = new Drug(
                    readPositiveInt("Drug ID: "),
                    readRequiredText("Drug name: "),
                    readNonNegativeDecimal("Drug cost: "),
                    readRequiredText("Dosage: ")
            );

            DRUG_FILE_REPOSITORY.save(drug);
            System.out.println("Drug saved successfully to "
                    + DRUG_FILE_REPOSITORY.getFilePath());
        } catch (IOException | IllegalArgumentException exception) {
            System.out.println("Unable to save drug: " + exception.getMessage());
        }
    }

    private static void readDrugsFromFile() {
        try {
            List<Drug> drugs = DRUG_FILE_REPOSITORY.findAll();
            if (drugs.isEmpty()) {
                System.out.println("No drug records were found in the text file.");
                return;
            }

            System.out.println("All drugs from the text file:");
            drugs.forEach(System.out::println);
        } catch (IOException exception) {
            System.out.println("Unable to read drugs: " + exception.getMessage());
        }
    }

    private static void savePatientToDatabase() {
        try {
            Patient patient = new Patient(
                    readPositiveInt("Patient ID: "),
                    readRequiredText("Patient first name: "),
                    readRequiredText("Patient last name: "),
                    readDate("Patient date of birth (yyyy-MM-dd): ")
            );

            PATIENT_REPOSITORY.save(patient);
            System.out.println("Patient saved successfully to PostgreSQL.");
        } catch (SQLException exception) {
            System.out.println("Database operation failed: " + readableSqlMessage(exception));
        } catch (IllegalArgumentException exception) {
            System.out.println("Unable to save patient: " + exception.getMessage());
        }
    }

    private static void readPatientsFromDatabase() {
        try {
            List<Patient> patients = PATIENT_REPOSITORY.findAll();
            if (patients.isEmpty()) {
                System.out.println("No patient records were found in PostgreSQL.");
                return;
            }

            System.out.println("All patients from PostgreSQL:");
            patients.forEach(System.out::println);
        } catch (SQLException exception) {
            System.out.println("Database operation failed: " + readableSqlMessage(exception));
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a number greater than zero.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static BigDecimal readNonNegativeDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                BigDecimal value = new BigDecimal(input);
                if (value.signum() >= 0) {
                    return value;
                }
                System.out.println("Please enter zero or a positive amount.");
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid decimal number, such as 12.50.");
            }
        }
    }

    private static LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                LocalDate value = LocalDate.parse(input);
                if (!value.isAfter(LocalDate.now())) {
                    return value;
                }
                System.out.println("The date of birth cannot be in the future.");
            } catch (DateTimeParseException exception) {
                System.out.println("Please use the yyyy-MM-dd format, for example 1990-06-15.");
            }
        }
    }

    private static String readRequiredText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("This field cannot be blank.");
        }
    }

    private static String readableSqlMessage(SQLException exception) {
        if ("23505".equals(exception.getSQLState())) {
            return "That patient ID already exists.";
        }
        if (exception.getMessage() == null || exception.getMessage().isBlank()) {
            return "Unknown SQL error.";
        }
        return exception.getMessage();
    }
}
