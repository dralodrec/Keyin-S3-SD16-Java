import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a doctor who can manage patients and issue prescriptions.
 */
public class Doctor extends Person {
    private String specialization;
    private final List<Patient> patients;

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Patient management methods
    public List<Patient> getPatients() {
        return Collections.unmodifiableList(patients);
    }

    public void addPatient(Patient patient) {
        if (patient != null && !patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public String toString() {
        return "Doctor{" + getPersonDetails()
                + ", Specialization: " + specialization
                + ", Patients Managed: " + patients.size()
                + "}";
    }
}
