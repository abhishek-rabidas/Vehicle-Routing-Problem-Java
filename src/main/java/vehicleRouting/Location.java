package vehicleRouting;

public class Location {
    public long id;
    public String name;
    public double x;
    public double y;
    public int zipCode;
    public LocationType locationType;

    public Location(String name, double x, double y, int zipCode, LocationType locationType) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.zipCode = zipCode;
        this.locationType = locationType;
    }

    public Location() {

    }
}
