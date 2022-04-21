package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(AppConfig.class)
public class LocationServiceIntegrationTest {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private LocationService locationService;

    @Autowired
    private NameChangeListener nameChangeListener;

    @BeforeEach
    public void setUp() {
        System.out.println("Clear location list.");
        locationDao.deleteAll();
        System.out.println(locationDao.findAll());
    }

    @Test
    public void testSaveThanList() {
        System.out.println(locationService.listLocations());
        locationService.createLocation("Budapest", 1,2);
        locationService.createLocation("Moszkva", 3,4);
        locationService.createLocation("London", 5,6);
        List<Location> locations = locationService.listLocations();

        assertEquals(Arrays.asList("Budapest", "Moszkva", "London"),
                locations.stream().map(Location::getName).collect(Collectors.toList()));
    }

    @Test
    public void testSaveThanFind() {
        System.out.println(locationService.listLocations());
        locationService.createLocation("Budapest", 1,2);
        Location moszkva = locationService.createLocation("Mexico", 3, 4);
        locationService.createLocation("Tokio", 5,6);

        Location location = locationService.getLocationById(moszkva.getId()).get();

        assertEquals(moszkva.getId(), location.getId());
    }

    @Test
    public void testUpdateThanFind() {
        System.out.println(locationService.listLocations());
        locationService.createLocation("Budapest", 1,2);
        Location moszkva = locationService.createLocation("Mexico", 3, 4);
        locationService.createLocation("Tokio", 5,6);

        Location location = locationService.updateLocation(moszkva.getId(), null, 33, 44).get();

        assertEquals(33, location.getLat());
    }

    @Test
    public void testDeleteThanFind() {
        System.out.println(locationService.listLocations());
        locationService.createLocation("Budapest", 1,2);
        Location moszkva = locationService.createLocation("Mexico", 3, 4);
        locationService.createLocation("Tokio", 5,6);

        Location location = locationService.deleteLocation(moszkva.getId()).get();
        boolean isLocation = locationService.getLocationById(moszkva.getId()).isPresent();

        assertEquals(false, isLocation);
    }

    @Test
    public void testUpdateThanFind2() {
        System.out.println(locationService.listLocations());
        locationService.createLocation("Budapest", 1,2);
        Location mexico = locationService.createLocation("Mexico", 3, 4);
        locationService.createLocation("Tokio", 5,6);

        Location location = locationService.updateLocation(mexico.getId(), "Mexico új", 33, 44).get();

        assertEquals(33, location.getLat());
        assertEquals(List.of("Mexico -> Mexico új"), nameChangeListener.getChanges());
    }
}
