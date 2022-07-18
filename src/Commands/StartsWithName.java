package Commands;

import Person.*;

/**
 * Command StartsWithName
 */
public class StartsWithName implements CommandWithArgs {
    private final String name = "filter_starts_with_name";
    private final String description = "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки";
    Receiver receiver;

    public StartsWithName(Receiver receiver) {
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
     * @param str
     * @return String line
     */
    @Override
    public void execute(Object str) {
        receiver.startsWithName(str);
    }
}
