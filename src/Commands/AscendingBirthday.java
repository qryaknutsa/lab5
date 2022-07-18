package Commands;

import Person.*;

import java.util.Comparator;
/**
 * Command AscendingBirthday
 */
public class AscendingBirthday implements Commandable {
    private final String name = "print_field_ascending_birthday";
    private final String description = "print_field_ascending_birthday : вывести значения поля birthday всех элементов в порядке возрастания";
    Receiver receiver;

    public AscendingBirthday(Receiver receiver) {
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
     * just executing of the command
     * @param o
     */
    @Override
    public void execute(Object o) {
        receiver.ascendingBirthday(o);
    }

}
