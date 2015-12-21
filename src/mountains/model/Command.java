package mountains.model;

/**
 * Created by andreazirn on 21/12/15.
 */
public interface Command {

    void undo();

    void redo();
}