package locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = AppConfig.class)

public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    @Scope("prototype")
    public Location templateLocation() {
        String name = environment.getProperty("template.location.name"); // "Choose name";
        double lat = Double.valueOf(environment.getProperty("template.location.lat")); // 47.5;
        double lon = Double.valueOf(environment.getProperty("template.location.lon")); // 19.05;
        System.out.println("name: " + name + "; lat: " + lat + "; lon: " + lon);
        return new Location(0L, name, lat, lon);
    }

//    @Bean // ComponentScan miatt kiszedve
//    public LocationDao locationDao() {
//        return new ListLocationDao();
//    }
//
//    @Bean
//    public LocationService locationService() {
//        return new LocationService(locationDao());
//    }
//
//    @Bean // LocationServiceIntegrationTemplateTest-hez kell
//    public LocationService locationService(ApplicationContext context) {
//        return new LocationService(locationDao(), context);
//    }

}
