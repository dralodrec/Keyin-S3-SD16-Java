/**
    Added methods to “set” and “get” the instance variables in the Student class.
 */
public class Student extends Person {
    protected String myIdNum; // Student ID number
    protected double myGPA;   // Grade point average

    /**
     * Constructs a Student object.
     *
     * @param myName   the student's name
     * @param myAge    the student's age
     * @param myGender the student's gender
     * @param myIdNum  the student's identification number
     * @param myGPA    the student's grade point average
     */
    public Student(String myName, int myAge, String myGender, String myIdNum, double myGPA) {
        // Initialize the inherited Person fields.
        super(myName, myAge, myGender);

        // Initialize the Student-specific fields.
        this.myIdNum = myIdNum;
        this.myGPA = myGPA;
    }

    /** @return the student's ID number */
    public String getIdNum() {
        return myIdNum;
    }

    /** @return the student's GPA */
    public double getGPA() {
        return myGPA;
    }

    /** @param idNum the new student ID number */
    public void setIdNum(String idNum) {
        myIdNum = idNum;
    }

    /** @param gpa the new GPA */
    public void setGPA(double gpa) {
        myGPA = gpa;
    }

    /**
     * Returns the Person information followed by Student information.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", student ID: " + myIdNum
                + ", GPA: " + myGPA;
    }
}
