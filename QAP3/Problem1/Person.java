/**
 * Added methods to “set” and “get” the instance variables in the Person class.
 */
public class Person {
    protected String myName;   // Name of the person
    protected int myAge;       // Person's age
    protected String myGender; // "M" for male, "F" for female

    /**
     * Constructs a Person object.
     *
     * @param myName   the person's name
     * @param myAge    the person's age
     * @param myGender the person's gender
     */
    public Person(String myName, int myAge, String myGender) {
        this.myName = myName;
        this.myAge = myAge;
        this.myGender = myGender;
    }

    /** @return the person's name */
    public String getName() {
        return myName;
    }

    /** @return the person's age */
    public int getAge() {
        return myAge;
    }

    /** @return the person's gender */
    public String getGender() {
        return myGender;
    }

    /** @param name the new name */
    public void setName(String name) {
        myName = name;
    }

    /** @param age the new age */
    public void setAge(int age) {
        myAge = age;
    }

    /** @param gender the new gender */
    public void setGender(String gender) {
        myGender = gender;
    }

    /**
     * Returns the person's information as text.
     */
    @Override
    public String toString() {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}
