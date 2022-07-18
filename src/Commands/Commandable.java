package Commands;

/**
 * interface for commands
 */
public interface Commandable {
    void execute(Object o) throws Exception;
    String getName();
    String getDescription();
}
