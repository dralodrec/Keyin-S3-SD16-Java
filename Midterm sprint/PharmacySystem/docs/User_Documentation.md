# User Documentation - Pharmacy Management System

## 1. Application Description

The Pharmacy Management System is a Java console application for managing pharmacy data. The program stores information about patients, doctors, medications, and prescriptions. It is designed with object-oriented programming concepts such as inheritance, encapsulation, associations, and service classes.

The main user is a pharmacy staff member who needs to:

- Register patients.
- Register doctors.
- Add pharmacy medications.
- Search for records.
- Link patients to doctors.
- Accept prescriptions from doctors.
- Track medication stock.
- Check expired medications.
- Generate reports.

## 2. How to Start the Application

Open a terminal in the project root folder and compile the Java files:

```bash
javac -d out src/main/java/pharmacy/*.java
```

Run the program:

```bash
java -cp out pharmacy.Main
```

After running the command, the main menu appears in the console.

## 3. Main Menu Options

```text
1. Add Patient
2. Add Doctor
3. Add Medication
4. Edit Patient
5. Edit Doctor
6. Edit Medication
7. Delete Patient
8. Delete Doctor
9. Delete Medication
10. Search Patient by Name
11. Search Doctor by Name
12. Search Medication by Name
13. Add Patient to Doctor
14. Accept Prescription
15. Generate Full Report
16. Generate Expired Medication Report
17. Print Prescriptions by Doctor
18. Print Patient Prescription Drug Names for Past Year
19. Restock All Medications
20. List All Current Data
0. Exit
```

## 4. How to Use the Application

### Add a Patient

Choose option `1`. Enter the patient ID, name, age, and phone number. The system stores the patient if the ID is unique.

### Add a Doctor

Choose option `2`. Enter the doctor ID, name, age, phone number, and specialization. The system stores the doctor if the ID is unique.

### Add a Medication

Choose option `3`. Enter the medication ID, name, dose, quantity in stock, and expiry date. The expiry date must use this format:

```text
YYYY-MM-DD
```

Example:

```text
2027-05-10
```

### Edit Records

Use options `4`, `5`, or `6` to edit patients, doctors, or medications. The system searches by ID and updates the record if it exists.

### Delete Records

Use options `7`, `8`, or `9` to delete patients, doctors, or medications. Related prescription records are also removed to keep the system consistent.

### Search Records

Use options `10`, `11`, or `12`. The search is case-insensitive and allows partial names.

Example: searching `met` can find `Metformin`.

### Add Patient to Doctor

Choose option `13`. Enter the patient ID and doctor ID. The patient is added to the doctor's managed patient list.

### Accept Prescription

Choose option `14`. Enter the prescription ID, doctor ID, patient ID, and medication ID. The system creates a prescription, links it to the doctor and patient, adds the medication to the patient's medication list, and reduces medication stock by one.

### Generate Reports

Option `15` prints all patients, doctors, medications, and prescriptions.

Option `16` prints expired medications.

Option `17` prints prescriptions issued by a specific doctor.

Option `18` prints only the drug names prescribed to a patient within the past year.

### Restock Medications

Choose option `19`. Enter the amount to add to every medication's stock.

## 5. Class Explanations

### Person

`Person` is the superclass for common person data. It contains:

- ID
- Name
- Age
- Phone number

### Patient

`Patient` extends `Person`. It represents a pharmacy patient and contains:

- A list of medications.
- A list of prescriptions.

### Doctor

`Doctor` extends `Person`. It represents a doctor and contains:

- Specialization.
- A list of managed patients.

### Medication

`Medication` represents a drug in the pharmacy. It contains:

- ID
- Name
- Dose
- Quantity in stock
- Expiry date

It also checks whether a medication is expired and allows stock to be increased or reduced.

### Prescription

`Prescription` represents a prescription issued by a doctor for a patient. It links:

- Doctor
- Patient
- Medication

The prescription expiry date automatically defaults to one year after the issue date.

### MedicationTrackingSystem

`MedicationTrackingSystem` is the main service class. It stores all lists and contains the application's main operations, including add, edit, delete, search, prescription creation, restocking, and report generation.

### Main

`Main` runs the application. It loads sample data, displays the menu, reads user input with `Scanner`, and calls methods from `MedicationTrackingSystem`.
