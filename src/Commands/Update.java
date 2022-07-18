package Commands;

import Person.Person;
import Person.PersonCollections;

/**
 * Command Update
 */
public class Update implements CommandWithArgs {
    private final String name = "update";
    private final String description = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    Receiver receiver;

    public Update(Receiver receiver) {
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
     * @param obj
     * @return String line
     */
    @Override
    public void execute(Object obj) {
        receiver.update(obj);
    }
}
