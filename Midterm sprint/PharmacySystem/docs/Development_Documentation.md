# Development Documentation - Pharmacy Management System

## Developer: Feras Zen Alabdeen and Darrell Declaro 2026

## 1. Project Purpose

This project implements a pharmacy management system in Java. It uses object-oriented programming to model people, patients, doctors, medications, prescriptions, and a system manager class.

## 2. Directory Structure

```text
src/main/java/pharmacy/
├── Person.java
├── Patient.java
├── Doctor.java
├── Medication.java
├── Prescription.java
├── MedicationTrackingSystem.java
└── Main.java
```

## 3. File Responsibilities

| File | Responsibility |
|---|---|
| `Person.java` | Abstract superclass for shared person fields. |
| `Patient.java` | Stores patient information, medications, and prescriptions. |
| `Doctor.java` | Stores doctor information, specialization, and managed patients. |
| `Medication.java` | Stores medication details, stock quantity, and expiry status. |
| `Prescription.java` | Links doctor, patient, and medication. Defaults expiry to one year after issue date. |
| `MedicationTrackingSystem.java` | Service/controller class that manages all system operations. |
| `Main.java` | Console menu and sample data loader. |

## 4. Compiler-Time Dependencies

This project uses only Java standard library classes:

- `java.util.ArrayList`
- `java.util.Collections`
- `java.util.List`
- `java.util.Random`
- `java.util.Scanner`
- `java.util.stream.Collectors`
- `java.time.LocalDate`
- `java.time.format.DateTimeParseException`

## 5. Main System Methods

| Method | Purpose |
|---|---|
| `addPatient(Patient patient)` | Adds a patient if the ID is unique. |
| `addDoctor(Doctor doctor)` | Adds a doctor if the ID is unique. |
| `addMedication(Medication medication)` | Adds a medication if the ID is unique. |
| `editPatient(...)` | Updates patient fields. |
| `editDoctor(...)` | Updates doctor fields. |
| `editMedication(...)` | Updates medication fields. |
| `deletePatient(int patientId)` | Deletes a patient and related prescriptions. |
| `deleteDoctor(int doctorId)` | Deletes a doctor and related prescriptions. |
| `deleteMedication(int medicationId)` | Deletes medication and related prescriptions. |
| `searchPatientsByName(String name)` | Finds patients by partial name. |
| `searchDoctorsByName(String name)` | Finds doctors by partial name. |
| `searchMedicationsByName(String name)` | Finds medications by partial name. |
| `addPatientToDoctor(int patientId, int doctorId)` | Assigns a patient to a doctor. |
| `acceptPrescription(...)` | Creates and links a prescription. |
| `generateFullReport()` | Prints all system data. |
| `generateExpiredMedicationReport()` | Prints expired medication records. |
| `generatePrescriptionsByDoctorReport(int doctorId)` | Prints prescriptions from a doctor. |
| `generatePatientPrescriptionDrugNamesForPastYear(int patientId)` | Prints patient drug names for the past year. |
| `restockAllMedications(int amount)` | Adds stock to all medications. |