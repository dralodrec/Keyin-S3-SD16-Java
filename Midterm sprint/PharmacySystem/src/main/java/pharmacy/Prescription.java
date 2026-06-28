package pharmacy;

import java.time.LocalDate;

/**
 * Represents a prescription issued by a doctor for a patient.
 * The prescription expiry defaults to one year from the issue date.
 */
public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate prescriptionExpiry;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this(id, doctor, patient, medication, LocalDate.now());
    }

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication, LocalDate issueDate) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = issueDate;
        this.prescriptionExpiry = issueDate.plusYears(1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
        this.prescriptionExpiry = issueDate.plusYears(1);
    }

    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public boolean isExpired() {
        return prescriptionExpiry.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "ID: " + id +
                ", Doctor: " + doctor.getName() +
                ", Patient: " + patient.getName() +
                ", Medication: " + medication.getName() + " " + medication.getDose() +
                ", Issue Date: " + issueDate +
                ", Prescription Expiry: " + prescriptionExpiry +
                ", Expired: " + (isExpired() ? "YES" : "NO") +
                "}";
    }
}
