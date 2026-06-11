import java.util.ArrayList;
import java.util.List;

/**
 * Models a university campus using aggregated geometric objects.
 * Buildings are rectangles, walkways are lines, and fountains are circles.
 */
public class CampusMap {
    private ArrayList<MyLine> walkways;
    private ArrayList<MyRectangle> buildings;
    private ArrayList<MyCircle> fountains;

    /**
     * Creates an empty campus map.
     */
    public CampusMap() {
        walkways = new ArrayList<>();
        buildings = new ArrayList<>();
        fountains = new ArrayList<>();
    }

    
    public void addBuilding(MyRectangle building) {
        if (building == null) {
            System.out.println("Error: building cannot be null.");
            return;
        }
        buildings.add(building);
    }

    
    public void addWalkway(MyRectangle from, MyRectangle to) {
        if (!buildings.contains(from) || !buildings.contains(to)) {
            System.out.println("Error: both buildings must be added before creating a walkway.");
            return;
        }

        MyLine walkway = new MyLine(from.getCenter(), to.getCenter());
        walkways.add(walkway);
    }

    
    public void addFountain(MyCircle fountain) {
        if (fountain == null) {
            System.out.println("Error: fountain cannot be null.");
            return;
        }
        fountains.add(fountain);
    }

    
    public double calculateTotalWalkwayLength() {
        double total = 0;
        for (MyLine walkway : walkways) {
            total += walkway.getLength();
        }
        return total;
    }

    
    public double calculateTotalFountainArea() {
        double total = 0;
        for (MyCircle fountain : fountains) {
            total += fountain.getArea();
        }
        return total;
    }

  
    public boolean isWalkwayFromTo(MyRectangle fromBuilding, MyRectangle toBuilding) {
        if (!buildings.contains(fromBuilding) || !buildings.contains(toBuilding)) {
            return false;
        }

        MyPoint fromCenter = fromBuilding.getCenter();
        MyPoint toCenter = toBuilding.getCenter();

        for (MyLine walkway : walkways) {
            MyPoint begin = walkway.getBegin();
            MyPoint end = walkway.getEnd();

            boolean sameDirection = begin.equals(fromCenter) && end.equals(toCenter);
            boolean reverseDirection = begin.equals(toCenter) && end.equals(fromCenter);

            if (sameDirection || reverseDirection) {
                return true;
            }
        }
        return false;
    }

    public int getBuildingCount() {
        return buildings.size();
    }

    public int getWalkwayCount() {
        return walkways.size();
    }

    public int getFountainCount() {
        return fountains.size();
    }

    /**
     * Returns a copy of the walkway list for safe reading.
     */
    public List<MyLine> getWalkways() {
        return new ArrayList<>(walkways);
    }

    /**
     * Returns a copy of the building list for safe reading.
     */
    public List<MyRectangle> getBuildings() {
        return new ArrayList<>(buildings);
    }

    /**
     * Returns a copy of the fountain list for safe reading.
     */
    public List<MyCircle> getFountains() {
        return new ArrayList<>(fountains);
    }

    /**
     * Returns a short summary of the campus map.
     */
    @Override
    public String toString() {
        return "CampusMap[buildings=" + buildings.size()
                + ",walkways=" + walkways.size()
                + ",fountains=" + fountains.size() + "]";
    }
}
