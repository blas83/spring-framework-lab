package locations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
@Primary
public class ListLocationDao implements LocationDao {

    private List<Location> locations = Collections.synchronizedList(new ArrayList<>());

    private Long i = Long.valueOf(0);

    // összes kedvenc hely listázása
    @Override
    public List<Location> findAll() {
        return new ArrayList<>(locations);
    }

    // kedvenc hely létrehozása, visszaadja a teljes Locationt
    @Override
    public Location save(String name, double lat, double lon) {
        Location location = new Location();
        location.setId(i++);
        location.setName(name);
        location.setLat(lat);
        location.setLon(lon);

        locations.add(location);

        return location;
    }

    // kedvenc hely keresése id alapján
    @Override
    public Optional<Location> findById(long id) {

        Optional<Location> optional = locations.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();

        return optional;
    }

    // kedvenc hely módosítása id alapján, visszaadja az új Locationt, ha volt mit módosítani
    @Override
    public Optional<Location> update(long id, String name, double lat, double lon) {
        Optional<Location> optional = this.findById(id);
        if (optional.isPresent()) {
            Location location = optional.get();

            if (StringUtils.hasText(name)) {
                location.setName(name);
            }

            location.setLat(lat);
            location.setLon(lon);

        }

        return optional;
    }

    // kedvenc hely törlése, visszaadja a törölt Locationt, ha az létezett
    @Override
    public Optional<Location> delete(long id) {
        Optional<Location> optional = this.findById(id);
        if (optional.isPresent()) {
            Location location = optional.get();

            locations.remove(location);
        }

        return optional;
    }

    @Override
    public void deleteAll() {
        locations.clear();
    }



}
