package Commands;

import Person.*;

/**
 * Command Show
 */
public class Show implements Commandable {
    private final String name = "show";
    private final String description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    Receiver receiver;

    public Show(Receiver receiver) {
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
     * @param o
     * @return String line
     */
    @Override
    public void execute(Object o) {
        receiver.show(o);
    }
}
