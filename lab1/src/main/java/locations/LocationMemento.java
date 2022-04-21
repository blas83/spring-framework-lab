package locations;

public class LocationMemento {

    private Long id;

    private String name;

    private double lat;

    private double lon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public LocationMemento() {}

    public LocationMemento(Long id, String name, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public LocationMemento(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.lat = location.getLat();
        this.lon = location.getLon();
    }
}
