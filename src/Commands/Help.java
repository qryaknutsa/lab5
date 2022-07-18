package Commands;

/**
 * Command Help
 */
public class Help extends Command implements Commandable {
    private final String name = "help";
    private final String description = "help : вывести справку по доступным командам";
    Receiver receiver;

    public Help(Receiver receiver) {
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
        receiver.help(o);
    }
}
