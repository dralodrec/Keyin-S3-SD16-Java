/**
 * Tests the Person, Student, Teacher, and CollegeStudent classes.
 */
public class Demo {
    public static void main(String[] args) {
        // Create and display a Person object.
        Person bob = new Person("Coach Bob", 27, "M");
        System.out.println(bob);

        // Create and display a Student object.
        Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);

        // Create and display a Teacher object.
        Teacher mrJava = new Teacher(
                "Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);

        // Create and display a CollegeStudent object.
        CollegeStudent ima = new CollegeStudent(
                "Ima Frosh", 18, "F", "UCB123", 4.0,
                CollegeStudent.FROSH, "English");
        System.out.println(ima);
    }
}
