package pharmacy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main service class that manages patients, doctors, medications, and prescriptions.
 */
public class MedicationTrackingSystem {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;
    private final Random random;

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.random = new Random();
    }

    public List<Patient> getPatients() {
        return Collections.unmodifiableList(patients);
    }

    public List<Doctor> getDoctors() {
        return Collections.unmodifiableList(doctors);
    }

    public List<Medication> getMedications() {
        return Collections.unmodifiableList(medications);
    }

    public List<Prescription> getPrescriptions() {
        return Collections.unmodifiableList(prescriptions);
    }

    public void addPatient(Patient patient) {
        if (patient != null && findPatientById(patient.getId()) == null) {
            patients.add(patient);
        }
    }

    public boolean deletePatient(int patientId) {
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            return false;
        }

        prescriptions.removeIf(p -> p.getPatient().getId() == patientId);
        for (Doctor doctor : doctors) {
            doctor.removePatient(patient);
        }
        return patients.remove(patient);
    }

    public boolean editPatient(int id, String name, int age, String phoneNumber) {
        Patient patient = findPatientById(id);
        if (patient == null) {
            return false;
        }
        patient.setName(name);
        patient.setAge(age);
        patient.setPhoneNumber(phoneNumber);
        return true;
    }

    public void addDoctor(Doctor doctor) {
        if (doctor != null && findDoctorById(doctor.getId()) == null) {
            doctors.add(doctor);
        }
    }

    public boolean deleteDoctor(int doctorId) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            return false;
        }
        prescriptions.removeIf(p -> p.getDoctor().getId() == doctorId);
        return doctors.remove(doctor);
    }

    public boolean editDoctor(int id, String name, int age, String phoneNumber, String specialization) {
        Doctor doctor = findDoctorById(id);
        if (doctor == null) {
            return false;
        }
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setPhoneNumber(phoneNumber);
        doctor.setSpecialization(specialization);
        return true;
    }

    public void addMedication(Medication medication) {
        if (medication != null && findMedicationById(medication.getId()) == null) {
            medications.add(medication);
        }
    }

    public boolean deleteMedication(int medicationId) {
        Medication medication = findMedicationById(medicationId);
        if (medication == null) {
            return false;
        }

        prescriptions.removeIf(p -> p.getMedication().getId() == medicationId);
        for (Patient patient : patients) {
            patient.removeMedication(medication);
        }
        return medications.remove(medication);
    }

    public boolean editMedication(int id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        Medication medication = findMedicationById(id);
        if (medication == null) {
            return false;
        }
        medication.setName(name);
        medication.setDose(dose);
        medication.setQuantityInStock(quantityInStock);
        medication.setExpiryDate(expiryDate);
        return true;
    }

    public List<Patient> searchPatientsByName(String name) {
        return patients.stream()
                .filter(patient -> containsIgnoreCase(patient.getName(), name))
                .collect(Collectors.toList());
    }

    public List<Doctor> searchDoctorsByName(String name) {
        return doctors.stream()
                .filter(doctor -> containsIgnoreCase(doctor.getName(), name))
                .collect(Collectors.toList());
    }

    public List<Medication> searchMedicationsByName(String name) {
        return medications.stream()
                .filter(medication -> containsIgnoreCase(medication.getName(), name))
                .collect(Collectors.toList());
    }

    public Patient findPatientById(int id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Doctor findDoctorById(int id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Medication findMedicationById(int id) {
        return medications.stream()
                .filter(medication -> medication.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Prescription findPrescriptionById(int id) {
        return prescriptions.stream()
                .filter(prescription -> prescription.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Assigns a patient to a doctor's patient list.
     */
    public boolean addPatientToDoctor(int patientId, int doctorId) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);
        if (patient == null || doctor == null) {
            return false;
        }
        doctor.addPatient(patient);
        return true;
    }

    /**
     * Creates a prescription and links the doctor, patient, and medication together.
     */
    public Prescription acceptPrescription(int prescriptionId, int doctorId, int patientId, int medicationId) {
        if (findPrescriptionById(prescriptionId) != null) {
            return null;
        }
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);
        Medication medication = findMedicationById(medicationId);

        if (doctor == null || patient == null || medication == null) {
            return null;
        }

        Prescription prescription = new Prescription(prescriptionId, doctor, patient, medication);
        prescriptions.add(prescription);
        patient.addPrescription(prescription);
        doctor.addPatient(patient);
        medication.reduceStock(1);
        return prescription;
    }

    /**
     * Creates a prescription with a custom issue date. Useful for test/sample data.
     */
    public Prescription acceptPrescription(int prescriptionId, int doctorId, int patientId, int medicationId, LocalDate issueDate) {
        if (findPrescriptionById(prescriptionId) != null) {
            return null;
        }
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);
        Medication medication = findMedicationById(medicationId);

        if (doctor == null || patient == null || medication == null) {
            return null;
        }

        Prescription prescription = new Prescription(prescriptionId, doctor, patient, medication, issueDate);
        prescriptions.add(prescription);
        patient.addPrescription(prescription);
        doctor.addPatient(patient);
        medication.reduceStock(1);
        return prescription;
    }

    public String generateFullReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n========== PHARMACY SYSTEM REPORT ==========\n");

        report.append("\nPatients:\n");
        if (patients.isEmpty()) {
            report.append("No patients found.\n");
        } else {
            for (Patient patient : patients) {
                report.append(patient).append("\n");
            }
        }

        report.append("\nDoctors:\n");
        if (doctors.isEmpty()) {
            report.append("No doctors found.\n");
        } else {
            for (Doctor doctor : doctors) {
                report.append(doctor).append("\n");
            }
        }

        report.append("\nMedications:\n");
        if (medications.isEmpty()) {
            report.append("No medications found.\n");
        } else {
            for (Medication medication : medications) {
                report.append(medication).append("\n");
            }
        }

        report.append("\nPrescriptions:\n");
        if (prescriptions.isEmpty()) {
            report.append("No prescriptions found.\n");
        } else {
            for (Prescription prescription : prescriptions) {
                report.append(prescription).append("\n");
            }
        }

        report.append("===========================================\n");
        return report.toString();
    }

    public List<Medication> getExpiredMedications() {
        return medications.stream()
                .filter(Medication::isExpired)
                .collect(Collectors.toList());
    }

    public String generateExpiredMedicationReport() {
        List<Medication> expiredMedications = getExpiredMedications();
        StringBuilder report = new StringBuilder("\n========== EXPIRED MEDICATION REPORT ==========\n");
        if (expiredMedications.isEmpty()) {
            report.append("No expired medications found.\n");
        } else {
            for (Medication medication : expiredMedications) {
                report.append(medication).append("\n");
            }
        }
        report.append("==============================================\n");
        return report.toString();
    }

    public List<Prescription> getPrescriptionsByDoctor(int doctorId) {
        return prescriptions.stream()
                .filter(prescription -> prescription.getDoctor().getId() == doctorId)
                .collect(Collectors.toList());
    }

    public String generatePrescriptionsByDoctorReport(int doctorId) {
        Doctor doctor = findDoctorById(doctorId);
        StringBuilder report = new StringBuilder("\n========== PRESCRIPTIONS BY DOCTOR ==========\n");
        if (doctor == null) {
            report.append("Doctor not found.\n");
        } else {
            report.append("Doctor: ").append(doctor.getName()).append("\n");
            List<Prescription> doctorPrescriptions = getPrescriptionsByDoctor(doctorId);
            if (doctorPrescriptions.isEmpty()) {
                report.append("No prescriptions found for this doctor.\n");
            } else {
                for (Prescription prescription : doctorPrescriptions) {
                    report.append(prescription).append("\n");
                }
            }
        }
        report.append("============================================\n");
        return report.toString();
    }

    public String generatePatientPrescriptionDrugNamesForPastYear(int patientId) {
        Patient patient = findPatientById(patientId);
        StringBuilder report = new StringBuilder("\n========== PATIENT PRESCRIPTION DRUGS - PAST YEAR ==========\n");
        if (patient == null) {
            report.append("Patient not found.\n");
        } else {
            report.append("Patient: ").append(patient.getName()).append("\n");
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            List<String> medicationNames = prescriptions.stream()
                    .filter(prescription -> prescription.getPatient().getId() == patientId)
                    .filter(prescription -> !prescription.getIssueDate().isBefore(oneYearAgo))
                    .map(prescription -> prescription.getMedication().getName())
                    .distinct()
                    .collect(Collectors.toList());

            if (medicationNames.isEmpty()) {
                report.append("No prescription drug names found for the past year.\n");
            } else {
                for (String medicationName : medicationNames) {
                    report.append("- ").append(medicationName).append("\n");
                }
            }
        }
        report.append("===========================================================\n");
        return report.toString();
    }

    public void restockAllMedications(int amount) {
        for (Medication medication : medications) {
            medication.restock(amount);
        }
    }

    public void restockAllMedicationsRandomly(int minimumAmount, int maximumAmount) {
        int min = Math.min(minimumAmount, maximumAmount);
        int max = Math.max(minimumAmount, maximumAmount);
        for (Medication medication : medications) {
            int amount = random.nextInt(max - min + 1) + min;
            medication.restock(amount);
        }
    }

    public static LocalDate randomExpiryDateIncludingPast() {
        Random random = new Random();
        int daysFromToday = random.nextInt(1461) - 730; // approximately -2 years to +2 years
        return LocalDate.now().plusDays(daysFromToday);
    }

    private boolean containsIgnoreCase(String text, String searchTerm) {
        if (text == null || searchTerm == null) {
            return false;
        }
        return text.toLowerCase().contains(searchTerm.toLowerCase());
    }
}
