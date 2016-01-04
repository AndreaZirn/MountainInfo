package mountains.model;

import javafx.beans.property.Property;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

public class ValueChangeCommand implements Command {
    // Reference to the mountain list model
    private final MountainListModel mountainlist;
    private final Property property;
    private final Object oldValue;
    private final Object newValue;

    public ValueChangeCommand(MountainListModel mountainlist, Property property, Object oldValue, Object newValue) {
        this.mountainlist = mountainlist;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public void undo() {
        mountainlist.setPropertyValue(property, oldValue);
    }

    @Override
    public void redo() {
        mountainlist.setPropertyValue(property, newValue);
    }
}
