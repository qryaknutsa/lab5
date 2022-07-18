package Commands;

import java.util.ArrayList;
import java.util.List;

public class History extends Command implements Commandable {
    private final String name = "history";
    private final String description = "history : вывести последние 9 команд (без их аргументов)";
    Receiver receiver;

    public History(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Object o) throws Exception {
        receiver.history(o);
    }

}
