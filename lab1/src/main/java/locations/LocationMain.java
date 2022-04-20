package locations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class LocationMain {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            LocationService locationService = context.getBean(LocationService.class);

            locationService.createLocation("Budapest", 1, 2);
            locationService.createLocation("Párizs", 3, 4);
            locationService.createLocation("London", 5, 6);

            List<Location> locations = locationService.listLocations();
            System.out.println(locations);

            locationService.updateLocation(1, null, 6, 7);

            Location location = locationService.getLocationById(1).get();
            System.out.println(location);

            location = locationService.deleteLocation(0).get();
            System.out.println("Törölt location: " + location);
            locations = locationService.listLocations();
            System.out.println("Lista: " + locations);
        }
    }
}
