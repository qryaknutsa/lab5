package Commands;

import Person.*;

/**
 * Command RemoveById
 */
public class RemoveById implements CommandWithArgs {
    private final String name = "remove_by_id";
    private final String description = "удалить элемент из коллекции по его id";
    Receiver receiver;

    public RemoveById(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * GetName
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * GetDesription
     *
     * @return description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * just executing of the command
     *
     * @param id
     */
    @Override
    public void execute(Object id) {
        receiver.removeById(id);
    }
}