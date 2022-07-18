package Commands;

import Person.*;

/**
 * Command Add
 */
public class Add implements Commandable{

    Receiver receiver;
    private final String name = "add";
    private final String description = "add {element} : добавить новый элемент в коллекцию";

    public Add(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * GetName
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * GetDesription
     * @return description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param o
     * @throws Exception
     */
    @Override
    public void execute(Object o) throws Exception {
        receiver.add(o);
    }


}
