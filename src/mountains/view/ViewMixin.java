package mountains.view;

/**
 * Created by andreazirn on 18/12/15.
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
