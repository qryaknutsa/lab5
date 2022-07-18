package Commands;

import Person.*;

import java.util.Comparator;

/**
 * Command PrintAscending
 */
public class PrintAscending implements Commandable {
    private final String name = "print_ascending";
    private final String description = "print_ascending : вывести элементы коллекции в порядке возрастания";
    Receiver receiver;

    public PrintAscending(Receiver receiver) {
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
        receiver.printAscending(o);
    }
}
