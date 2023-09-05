package vehicleRouting;


import java.util.*;

public class SimpleRoutingService {

    private final List<Location> totalLocations = new ArrayList<>();
    private final Map<List<Location>, Double> distanceMatrix = new HashMap<>();
    public final List<Location> route = new ArrayList<>();

    public void init() {

        // adding all the locations
/*        totalLocations.add(new Location("Apollo", 28.606743, 77.233784, 122002, LocationType.PICKUP_POINT));
        totalLocations.add(new Location("BLK Super Speciality", 28.650548, 77.224105, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Guru Teg Bahadur", 28.638876, 77.209562, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Max, Saket", 28.542692, 77.232549, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Fortis, Noida", 28.622208, 77.370418, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("AIIMS, New Delhi", 28.613908, 77.207822, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Metro", 28.619623, 77.218256, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Rockland", 28.634201, 77.224874, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Aditya Birla", 28.569655, 77.214399, 122002, LocationType.DELIVERY_POINT));*/

/*        totalLocations.add(new Location("Ram Manohar Lohia Hospital", 28.620184, 77.211382, 122002, LocationType.PICKUP_POINT));
        totalLocations.add(new Location("Sir Ganga Ram Hospital", 28.621513, 77.228898, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Sushrut Trauma Centre", 28.616061, 77.225887, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Hindu Rao Hospital", 28.625392, 77.223230, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Gupta Hospital", 28.622289, 77.224450, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Indraprastha Apollo Hospital", 28.554047, 77.226318, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Metropolitan Hospital", 28.622237, 77.222730, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Holy Family Hospital", 28.621347, 77.223797, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Sanjay Gandhi Memorial Hospital", 28.616572, 77.224951, 122002, LocationType.DELIVERY_POINT));*/

/*        totalLocations.add(new Location("Yes Bank ATM, Sector 57, Gurugram", 28.561081, 77.034033, 122003, LocationType.PICKUP_POINT));
        totalLocations.add(new Location("HDFC Bank ATM, Sector 57, Gurugram", 28.560989, 77.03408, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("ICICI Bank ATM, Sector 57, Gurugram", 28.561114, 77.03402, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Axis Bank ATM, Sector 57, Gurugram", 28.561081, 77.034033, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("State Bank of India ATM, Sector 57, Gurugram", 28.560989, 77.03408, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Punjab National Bank ATM, Sector 57, Gurugram", 28.561114, 77.03402, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Bank of Baroda ATM, Sector 57, Gurugram", 28.561081, 77.034033, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Canara Bank ATM, Sector 57, Gurugram", 28.560989, 77.03408, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Union Bank of India ATM, Sector 57, Gurugram", 28.561114, 77.03402, 122003, LocationType.DELIVERY_POINT));*/


/*        totalLocations.add(new Location("Bal Bharati Public School Gurugram", 28.559123, 77.096789, 122003, LocationType.PICKUP_POINT));
        totalLocations.add(new Location("Modern School", 28.456789, 77.012345, 122001, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Government Senior Secondary School", 29.056789, 77.712345, 250001, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Government Girls Senior Secondary School", 29.067890, 77.723456, 250001, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Government Model Senior Secondary School", 29.078901, 77.734567, 250001, LocationType.DELIVERY_POINT));
        //totalLocations.add(new Location("St. Xavier's School", 28.516789, 77.052345, 122003, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("The Doon School", 29.099123, 77.756789, 250001, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Ryan International School", 29.109234, 77.767890, 250001, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Bal Bharati Public School Meerut", 29.129456, 77.789012, 250001, LocationType.DELIVERY_POINT));*/

        totalLocations.add(new Location("Apollo Hospitals", 28.606743, 77.233784, 122002, LocationType.PICKUP_POINT));
        totalLocations.add(new Location("BLK Super Speciality Hospital", 28.650548, 77.224105, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Guru Teg Bahadur Hospital", 28.638876, 77.209562, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Max Hospital, Saket", 28.542692, 77.232549, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Fortis Hospital, Noida", 28.622208, 77.370418, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("AIIMS, New Delhi", 28.613908, 77.207822, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Metro Hospital", 28.619623, 77.218256, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Rockland Hospital", 28.634201, 77.224874, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Aditya Birla Hospital", 28.569655, 77.214399, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Ram Manohar Lohia Hospital", 28.620184, 77.211382, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Sir Ganga Ram Hospital", 28.621513, 77.228898, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Sushrut Trauma Centre", 28.616061, 77.225887, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Hindu Rao Hospital", 28.625392, 77.223230, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Gupta Hospital", 28.622289, 77.224450, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Indraprastha Apollo Hospital", 28.554047, 77.226318, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Metropolitan Hospital", 28.622237, 77.222730, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Holy Family Hospital", 28.621347, 77.223797, 122002, LocationType.DELIVERY_POINT));
        totalLocations.add(new Location("Sanjay Gandhi Memorial Hospital", 28.616572, 77.224951, 122002, LocationType.DELIVERY_POINT));


        //calculateMapDistanceMatrix();
        //calculateEuclideanDistanceMatrix();

        // printing the distance matrix
/*        for (Map.Entry<List<Location>, Double> entry : distanceMatrix.entrySet()) {
            System.out.println(entry.getKey().get(0).name);
            System.out.println(entry.getKey().get(1).name);
            System.out.println("Distance:" + entry.getValue());
            System.out.println();
        }*/

        route.add(totalLocations.get(0));
        //routePlanv2();
        routeV3();

        // printing route
        System.out.println("Route: ");
        for (Location l : route) {
            System.out.print(l.name + " -> ");
        }
    }

    private void calculateEuclideanDistanceMatrix() {
        for (int i = 0; i < totalLocations.size(); i++) {
            for (int j = i + 1; j < totalLocations.size(); j++) {
                List<Location> points = new ArrayList<>();
                points.add(totalLocations.get(i));
                points.add(totalLocations.get(j));
                distanceMatrix.put(points, calculateDistance(totalLocations.get(i), totalLocations.get(j)));
            }
        }
    }

    private void calculateMapDistanceMatrix() {
        for (int i = 0; i < totalLocations.size(); i++) {
            for (int j = 0; j < totalLocations.size(); j++) {
                if (i == j) continue;
                List<Location> points = new ArrayList<>();
                points.add(totalLocations.get(i));
                points.add(totalLocations.get(j));
                //System.out.println(totalLocations.get(i).name + " , " + totalLocations.get(j).name);
                distanceMatrix.put(points, (double) GoogleMapsService.getDistance(String.format("%f,%f", totalLocations.get(i).x, totalLocations.get(i).y),
                        String.format("%f,%f", totalLocations.get(j).x, totalLocations.get(j).y)));
            }
        }
    }

    private double calculateDistance(Location a, Location b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private void routePlan() {
        double totalDist = 0.0;
        double dist;
        Location dp;

        for (int i = 0; i < route.size(); i++) {
            dp = new Location();
            dist = Double.MAX_VALUE;
            for (Map.Entry<List<Location>, Double> entry : distanceMatrix.entrySet()) {
                System.out.printf("%s -> %s , distance %f\n", entry.getKey().get(0).name, entry.getKey().get(1).name, entry.getValue());
                if (entry.getKey().get(0).name.compareTo(route.get(i).name) == 0 && !checkIfVisited(entry.getKey().get(1).name) || entry.getKey().get(1).name.compareTo(route.get(i).name) == 0 && !checkIfVisited(entry.getKey().get(0).name)) {
                    if (entry.getValue() <= dist) {
                        dist = entry.getValue();
                        dp = entry.getKey().get(0).name.compareTo(route.get(i).name) == 0 ? entry.getKey().get(1) : entry.getKey().get(0);
                    }
                }
            }
            if (dp.name == null) {
                break;
            }
            totalDist += dist;
            route.add(dp);
        }

        System.out.println("\nCost: " + totalDist);


    }

    private void routePlanv2() {
        double totalDist = 0.0;

        for (int i = 0; i < route.size(); i++) {
            Location dp = new Location();
            double dist = Double.MAX_VALUE;
            for (Map.Entry<List<Location>, Double> entry : distanceMatrix.entrySet()) {
                System.out.printf("%s -> %s , distance %f\n", entry.getKey().get(0).name, entry.getKey().get(1).name, entry.getValue());
                if (entry.getKey().get(0).name.compareTo(route.get(i).name) == 0 && !checkIfVisited(entry.getKey().get(1).name)) {
                    if (entry.getValue() <= dist) {
                        dist = entry.getValue();
                        dp = entry.getKey().get(1);
                        System.out.printf("SELECTED:: %s -> %s , distance %f\n", entry.getKey().get(0).name, entry.getKey().get(1).name, dist);
                    }
                }
            }
            if (dp.name == null) {
                break;
            }
            totalDist += dist;
            route.add(dp);
        }

        System.out.println("\nCost: " + totalDist);


    }

    private void routeV3() {
        final long[][] graphDistanceMatrix = new long[totalLocations.size()][totalLocations.size()];

        for (int i = 0; i < totalLocations.size(); i++) {
            for (int j = 0; j < totalLocations.size(); j++) {
                if (i == j) graphDistanceMatrix[i][j] = 0;
                graphDistanceMatrix[i][j] = GoogleMapsService.getDistance(String.format("%f,%f", totalLocations.get(i).x, totalLocations.get(i).y),
                        String.format("%f,%f", totalLocations.get(j).x, totalLocations.get(j).y));
                System.out.printf("%s -> %s : %d\n", totalLocations.get(i).name, totalLocations.get(j).name, graphDistanceMatrix[i][j]);
            }
        }

        // nearest neighbour greedy approach
        long totalCost = 0;

        for (int i = 0; i < route.size(); i++) {
            long minDist = Long.MAX_VALUE;
            Location nextNode = null;
            for (int j = 0; j < graphDistanceMatrix.length; j++) {
                if (checkIfVisited(totalLocations.get(j).name)) {
                    continue;
                }
                long node = graphDistanceMatrix[totalLocations.indexOf(route.get(i))][j];
                if (node > 0 && node < minDist) {
                    minDist = node;
                    nextNode = totalLocations.get(j);
                }
            }
            if (nextNode == null) break;
            //graphDistanceMatrix[totalLocations.indexOf(nextNode)][totalLocations.indexOf(route.get(i))] = 0;
            totalCost += minDist;
            route.add(nextNode);
        }


        totalCost += graphDistanceMatrix[totalLocations.indexOf(route.get(route.size() - 1))][0];
        System.out.println("Depot:" + route.get(route.size() - 1).name + "Cost:" + graphDistanceMatrix[totalLocations.indexOf(route.get(route.size() - 1))][0]);
        route.add(totalLocations.get(0));

        System.out.println("Total cost:" + totalCost);
    }

    private boolean checkIfVisited(String name) {
        for (Location location : route) {
            if (location.name.equals(name)) {
                return true;
            }
        }

        return false;
    }


}
