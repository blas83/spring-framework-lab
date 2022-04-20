package locations;

import java.util.List;
import java.util.Optional;

public class LocationService {

    private LocationDao locationDao;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public List<Location> listLocations() {
        return locationDao.findAll();
    }

    public Location createLocation(String name, double lat, double lon) {
        return locationDao.save(name, lat, lon);
    }

    public Optional<Location> getLocationById(long id) {
        return locationDao.findById(id);
    }

    public Optional<Location> updateLocation(long id, String name, double lat, double lon) {
        return locationDao.update(id, name, lat, lon);
    }

    public Optional<Location> deleteLocation(long id) {
        return locationDao.delete(id);
    }
}
