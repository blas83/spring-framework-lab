package locations;

import java.util.List;
import java.util.Optional;

public interface LocationDao {
    // összes kedvenc hely listázása
    List<Location> findAll();

    // kedvenc hely létrehozása, visszaadja a teljes Locationt
    Location save(String name, double lat, double lon);

    // kedvenc hely keresése id alapján
    Optional<Location> findById(long id);

    // kedvenc hely módosítása id alapján, visszaadja az új Locationt, ha volt mit módosítani
    Optional<Location> update(long id, String name, double lat, double lon);

    // kedvenc hely törlése, visszaadja a törölt Locationt, ha az létezett
    Optional<Location> delete(long id);

    void deleteAll();
}
