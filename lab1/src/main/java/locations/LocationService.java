package locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private LocationDao locationDao;

    private ApplicationContext context;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

//    public LocationService(LocationDao locationDao, ApplicationContext context) {
//        this.locationDao = locationDao;
//        this.context = context;
//    }

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

    public Location createLocationTemplate() {
        return context.getBean(Location.class);
    }
}
