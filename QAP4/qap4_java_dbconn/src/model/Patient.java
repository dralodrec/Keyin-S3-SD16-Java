package com.qap4.model;

import java.time.LocalDate;
import java.util.Objects;

/** Represents a patient stored in PostgreSQL. */
public class Patient {
    private final int patientId;
    private final String patientFirstName;
    private final String patientLastName;
    private final LocalDate patientDOB;

    public Patient(
            int patientId,
            String patientFirstName,
            String patientLastName,
            LocalDate patientDOB
    ) {
        if (patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be greater than zero.");
        }
        if (patientFirstName == null || patientFirstName.isBlank()) {
            throw new IllegalArgumentException("Patient first name is required.");
        }
        if (patientLastName == null || patientLastName.isBlank()) {
            throw new IllegalArgumentException("Patient last name is required.");
        }
        if (patientDOB == null) {
            throw new IllegalArgumentException("Patient date of birth is required.");
        }
        if (patientDOB.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Patient date of birth cannot be in the future.");
        }

        this.patientId = patientId;
        this.patientFirstName = patientFirstName.trim();
        this.patientLastName = patientLastName.trim();
        this.patientDOB = patientDOB;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public LocalDate getPatientDOB() {
        return patientDOB;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient{id=%d, firstName='%s', lastName='%s', dateOfBirth=%s}",
                patientId,
                patientFirstName,
                patientLastName,
                patientDOB
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Patient patient)) return false;
        return patientId == patient.patientId
                && patientFirstName.equals(patient.patientFirstName)
                && patientLastName.equals(patient.patientLastName)
                && patientDOB.equals(patient.patientDOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, patientFirstName, patientLastName, patientDOB);
    }
}
