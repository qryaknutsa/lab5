package Commands;

import Person.Person;
import Person.PersonCollections;

/**
 * Command AddIfMin
 */
public class AddIfMin implements Commandable {
    private final String name = "add_if_min";
    private final String description = "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    Receiver receiver;

    public AddIfMin(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * GetName
     *
     * @return name
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
        receiver.addIfMin(o);
    }
}
