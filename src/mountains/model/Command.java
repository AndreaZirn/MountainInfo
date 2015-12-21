package mountains.model;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public interface Command {

    void undo();

    void redo();
}