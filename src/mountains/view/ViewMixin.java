package mountains.view;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public interface ViewMixin <T> {

    T getPresentationModel();

    default void init() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    void initializeControls();

    //Anordenen aller Controler
    void layoutControls();

    default void addEventHandlers() {
    }

    default void addValueChangedListeners() {
    }

    default void addBindings() {
    }
}
