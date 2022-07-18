package Commands;

import FileStuff.FileWriter;
import Person.PersonCollections;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Command Save
 */
public class Save implements Commandable {
    private final String name = "save";
    private final String description = "save : сохранить коллекцию в файл";
    Receiver receiver;

    public Save(Receiver receiver) {
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
     * @throws IOException
     */
    @Override
    public void execute(Object o) throws IOException {
        receiver.save(o);
    }
}
