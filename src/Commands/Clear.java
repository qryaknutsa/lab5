package Commands;

import Person.PersonCollections;

/**
 * Command Clear
 */
public class Clear implements Commandable {
    private final String name = "clear";
    private final String description = "clear : очистить коллекцию";
Receiver receiver;

    public Clear(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * GetName
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * GetDesription
     * @return description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * just executing of the command
     * @param o
     */
    @Override
    public void execute(Object o) {
        receiver.clear(o);
    }
}
