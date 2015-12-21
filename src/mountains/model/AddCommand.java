package mountains.model;

/**
 * Created by andreazirn on 21/12/15.
 */
public class AddCommand implements Command {

    private final MountainListModel mountainlist;
    private final Mountain added;
    private final int position;

    public AddCommand(MountainListModel mountainlist, Mountain added, int position){
        this.mountainlist = mountainlist;
        this.added = added;
        this.position = position;
    }

    @Override
    public void undo() {
        mountainlist.removeFromList(added);
    }

    @Override
    public void redo() {
        mountainlist.addToList(position, added);

    }
}
