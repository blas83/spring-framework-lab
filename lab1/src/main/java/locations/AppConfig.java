package locations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Location templateLocation() {
        String name = "Choose name";
        double lat = 47.5;
        double lon = 19.05;

        return new Location(0L, name, lat, lon);
    }

//    @Bean // ComponentScan miatt kiszedve
//    public LocationDao locationDao() {
//        return new LocationDao();
//    }
//
//    @Bean
//    public LocationService locationService() {
//        return new LocationService(locationDao());
//    }

//    @Bean // LocationServiceIntegrationTemplateTest-hez kell
//    public LocationService locationService(ApplicationContext context) {
//        return new LocationService(locationDao(), context);
//    }

}
