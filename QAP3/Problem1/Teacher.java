/**
    Teacher class that extends the parent class Person
 */
public class Teacher extends Person {
    private String subject; // Subject taught by the teacher
    private double salary;  // Teacher's annual salary

    /**
     * Constructs a Teacher object.
     *
     * @param myName    the teacher's name
     * @param myAge     the teacher's age
     * @param myGender  the teacher's gender
     * @param mySubject the subject taught
     * @param mySalary  the annual salary
     */
    public Teacher(String myName, int myAge, String myGender, String mySubject, double mySalary) {
        // Initialize the inherited Person fields.
        super(myName, myAge, myGender);

        // Initialize the Teacher-specific fields.
        this.subject = mySubject;
        this.salary = mySalary;
    }

    /** @return the subject taught */
    public String getSubject() {
        return subject;
    }

    /** @return the teacher's annual salary */
    public double getSalary() {
        return salary;
    }

    /** @param subject the new subject */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /** @param salary the new annual salary */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the Person information followed by Teacher information.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", subject: " + subject
                + ", salary: $" + String.format("%.2f", salary);
    }
}
