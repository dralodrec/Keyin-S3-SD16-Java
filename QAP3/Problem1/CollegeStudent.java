/**
    CollegeStudent subclass that extends the Student class.
 */
public class CollegeStudent extends Student {
    // Constants representing common college-year levels.
    public static final int FROSH = 1;
    public static final int SOPH = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    private int year;    // Current college year
    private String major; // College major

    /**
     * Constructs a CollegeStudent object.
     *
     * @param myName   the student's name
     * @param myAge    the student's age
     * @param myGender the student's gender
     * @param myIdNum  the student's identification number
     * @param myGPA    the student's GPA
     * @param myYear   the student's current college year
     * @param myMajor  the student's major
     */
    public CollegeStudent(
            String myName,
            int myAge,
            String myGender,
            String myIdNum,
            double myGPA,
            int myYear,
            String myMajor) {

        // Initialize the inherited Person and Student fields.
        super(myName, myAge, myGender, myIdNum, myGPA);

        // Initialize the CollegeStudent-specific fields.
        this.year = myYear;
        this.major = myMajor;
    }

    /** @return the student's current college year */
    public int getYear() {
        return year;
    }

    /** @return the student's major */
    public String getMajor() {
        return major;
    }

    /** @param year the new college year */
    public void setYear(int year) {
        this.year = year;
    }

    /** @param major the new college major */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Returns Person and Student information followed by CollegeStudent
     * information.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", year: " + year
                + ", major: " + major;
    }
}
