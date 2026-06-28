package pharmacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a patient in the pharmacy system.
 * A patient can have medications and active prescriptions.
 */
public class Patient extends Person {
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public List<Medication> getMedications() {
        return Collections.unmodifiableList(medications);
    }

    public List<Prescription> getPrescriptions() {
        return Collections.unmodifiableList(prescriptions);
    }

    public void addMedication(Medication medication) {
        if (medication != null && !medications.contains(medication)) {
            medications.add(medication);
        }
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void addPrescription(Prescription prescription) {
        if (prescription != null && !prescriptions.contains(prescription)) {
            prescriptions.add(prescription);
            addMedication(prescription.getMedication());
        }
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    @Override
    public String toString() {
        return "Patient{" + getPersonDetails()
                + ", Medications: " + medications.size()
                + ", Prescriptions: " + prescriptions.size()
                + "}";
    }
}
