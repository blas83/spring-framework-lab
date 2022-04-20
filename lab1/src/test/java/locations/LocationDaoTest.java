package locations;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationDaoTest {

    private LocationDao locationDao = new LocationDao();

    @Test
    public void testSave() {
        locationDao.save("Budapest", 1, 2);
        locationDao.save("London", 5, 6);
        List<Location> locations = locationDao.findAll();
        assertEquals(Arrays.asList("Budapest", "London"),
                locations.stream().map(Location::getName).collect(Collectors.toList()));
    }
}
