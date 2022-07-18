package Commands;

import Person.PersonCollections;

/**
 * Command Info
 */
public class Info implements Commandable {
    private final String name = "info";
    private final String description = "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    Receiver receiver;

    public Info(Receiver receiver) {
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
     * @param o
     */
    @Override
    public void execute(Object o) {
        receiver.info(o);
    }
}
