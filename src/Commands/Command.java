package Commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Command, it helps understand what command was written
 */
public class Command{


    public static Map<String, Commandable> commands = new HashMap<>();

    public Commandable getCommands(String name) {
        return commands.get(name);
    }


    public static void setCommands(Map<String, Commandable> commands) {
        Command.commands = commands;
    }

    /**
     * Putting all kinds of command with their key-names to the Map
     * @param commands
     */
    public void filling(Commandable... commands) {
        for (Commandable command : commands)
            Command.commands.put(command.getName(), command);

    }

    /**
     * Executing a command, depending on kind of commands (with arg or not)
     * @param commandName
     * @return
     * @throws Exception
     */
    public String executeCommand(String commandName) throws Exception {

        String[] nameAndArg = commandName.trim().split(" ");
        if (nameAndArg.length==0) {
            System.out.println("Вы не ввели команду, попробуйте ввести команду ещё раз.\nЧтобы ознакомиться со всеми командами, введите \"help\"");

        } else {
            if (commands.get(nameAndArg[0]) == null) {
                System.out.println("Такой команды не существует, попробуйте ввести команду ещё раз.\nЧтобы ознакомиться со всеми командами, введите \"help\"");
            }else {
                try {
                    CommandWithArgs commandWithArgs = (CommandWithArgs) commands.get(nameAndArg[0]);
                    try {
                        String string = nameAndArg[2];
                        System.out.println("Вы неправильно ввели команду, попробуйте ещё раз.\nЧтобы ознакомиться со всеми командами, введите \"help\"");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commands.get(nameAndArg[0]).execute(nameAndArg[1]);
                        } catch (IndexOutOfBoundsException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        }
                    }
                } catch (Exception e) {
                    try {
                        String string = nameAndArg[1];
                        System.out.println("Вы неправильно ввели команду, попробуйте ещё раз.\nЧтобы ознакомиться со всеми командами, введите \"help\"");
                    } catch (Exception ex) {
                        (commands.get(nameAndArg[0])).execute(null);
                    }
                }
            }
        }return "";
    }
}
