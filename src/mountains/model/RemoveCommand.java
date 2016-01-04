package mountains.model;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

public class RemoveCommand implements Command {
    // Reference to the mountain list model
    private final MountainListModel mountainlist;
    private final Mountain removed;
    private final int position;

    public RemoveCommand(MountainListModel mountainlist, Mountain removed, int position) {
        this.mountainlist = mountainlist;
        this.removed = removed;
        this.position = position;
    }

    @Override
    public void undo() {
        //insert the mountains and selection
        mountainlist.getMountains().add(position, removed);
        mountainlist.setSelectedMountainId(removed.getId());
    }

    @Override
    public void redo() {
        // has to be deleted
        mountainlist.removeFromList(removed);
    }
}