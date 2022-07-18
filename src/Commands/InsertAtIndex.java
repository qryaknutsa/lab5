package Commands;

import Person.*;
import Person.PersonCollections;

import java.util.Comparator;

/**
 * Command InsertAtIndex
 */
public class InsertAtIndex implements CommandWithArgs {
    private final String name = "insert_at";
    public final String description = "insert_at index {element} : добавить новый элемент в заданную позицию";
    Receiver receiver;

    public InsertAtIndex(Receiver receiver) {
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
     * @param id
     * @throws Exception
     */
    @Override
    public void execute(Object id) throws Exception {
        receiver.insertAtIndex(id);
    }
}
