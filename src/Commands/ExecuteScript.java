package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Command ExecuteScript
 */
public class ExecuteScript implements CommandWithArgs {
    private final String name = "execute_script";
    private final String description = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    Receiver receiver;

    public ExecuteScript(Receiver receiver) {
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
     * @param filename
     * @return String line
     */
    @Override
    public void execute(Object filename) {
        receiver.executeScript(filename);
    }
}
