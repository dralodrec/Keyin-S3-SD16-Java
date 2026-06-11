/**
 * Test driver for CampusMap, MyRectangle, MyLine, MyCircle, and MyPoint.
 */
public class TestCampusMap {
    public static void main(String[] args) {
        CampusMap campus = new CampusMap();

        MyRectangle scienceHall = new MyRectangle(350, 650, 650, 450);
        MyRectangle library = new MyRectangle(100, 300, 350, 100);
        MyRectangle lectureRoom1 = new MyRectangle(700, 800, 780, 720);
        MyRectangle lectureRoom2 = new MyRectangle(800, 800, 880, 720);
        MyRectangle lectureRoom3 = new MyRectangle(700, 690, 780, 610);
        MyRectangle lectureRoom4 = new MyRectangle(800, 690, 880, 610);
        MyRectangle lectureRoom5 = new MyRectangle(750, 580, 830, 500);
        MyRectangle unlistedBuilding = new MyRectangle(900, 200, 970, 120);

        MyCircle centralFountain = new MyCircle(new MyPoint(500, 400), 35);

        System.out.println("Creating campus map...");
        campus.addBuilding(scienceHall);
        campus.addBuilding(library);
        campus.addBuilding(lectureRoom1);
        campus.addBuilding(lectureRoom2);
        campus.addBuilding(lectureRoom3);
        campus.addBuilding(lectureRoom4);
        campus.addBuilding(lectureRoom5);
        campus.addFountain(centralFountain);

        campus.addWalkway(scienceHall, library);
        campus.addWalkway(scienceHall, lectureRoom1);
        campus.addWalkway(scienceHall, lectureRoom2);
        campus.addWalkway(scienceHall, lectureRoom3);
        campus.addWalkway(scienceHall, lectureRoom4);
        campus.addWalkway(scienceHall, lectureRoom5);
        campus.addWalkway(library, lectureRoom5);

        System.out.println("Attempting invalid walkway:");
        campus.addWalkway(library, unlistedBuilding);
        System.out.println();

        System.out.println("Campus summary: " + campus);
        System.out.println("Buildings added: " + campus.getBuildingCount());
        System.out.println("Walkways added: " + campus.getWalkwayCount());
        System.out.println("Fountains added: " + campus.getFountainCount());
        System.out.println();

        System.out.println("Building centers:");
        System.out.println("Science Hall center: " + scienceHall.getCenter());
        System.out.println("Library center: " + library.getCenter());
        System.out.println("Lecture Room 1 center: " + lectureRoom1.getCenter());
        System.out.println("Lecture Room 2 center: " + lectureRoom2.getCenter());
        System.out.println("Lecture Room 3 center: " + lectureRoom3.getCenter());
        System.out.println("Lecture Room 4 center: " + lectureRoom4.getCenter());
        System.out.println("Lecture Room 5 center: " + lectureRoom5.getCenter());
        System.out.println("Central Fountain: " + centralFountain);
        System.out.println();

        System.out.printf("Total walkway length: %.2f meters%n", campus.calculateTotalWalkwayLength());
        System.out.printf("Total fountain area: %.2f square meters%n", campus.calculateTotalFountainArea());
        System.out.println();

        System.out.println("Walkway checks:");
        System.out.println("Science Hall to Library? " + campus.isWalkwayFromTo(scienceHall, library));
        System.out.println("Library to Science Hall? " + campus.isWalkwayFromTo(library, scienceHall));
        System.out.println("Library to Lecture Room 3? " + campus.isWalkwayFromTo(library, lectureRoom3));
        System.out.println("Library to unlisted building? " + campus.isWalkwayFromTo(library, unlistedBuilding));
        System.out.println();

        System.out.println("Walkway details:");
        int walkwayNumber = 1;
        for (MyLine walkway : campus.getWalkways()) {
            System.out.printf("Walkway %d: %s, length %.2f meters%n",
                    walkwayNumber, walkway, walkway.getLength());
            walkwayNumber++;
        }
    }
}
