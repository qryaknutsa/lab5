package Commands;

/**
 * Command Exit
 */
public class Exit implements Commandable {
    private final String name = "exit";
    private final String description = "exit : завершить программу (без сохранения в файл)";
    Receiver receiver;

    public Exit(Receiver receiver) {
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
        receiver.exit(o);
    }
}
