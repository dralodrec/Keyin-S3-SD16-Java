
/**
 * Base class for people in the pharmacy system.
 * Patient and Doctor both inherit common identity and contact fields from Person.
 */
public abstract class Person {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a short shared description for subclasses.
     */
    protected String getPersonDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
    }
}
