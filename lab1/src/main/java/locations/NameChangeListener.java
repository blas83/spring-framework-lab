package locations;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameChangeListener implements ApplicationListener<LocationHasChangedEvent> {

    List<String> changes = new ArrayList<>();

    @Override
    public void onApplicationEvent(LocationHasChangedEvent event) {
        if (!event.getOldLocation().getName().equals(event.getNewLocation().getName())) {
            changes.add(event.getOldLocation().getName() + " -> " + event.getNewLocation().getName());
        }
    }

    public void deleteAll() {
        changes.clear();
    }

    public List<String> getChanges() {
        return changes;
    }
}
