package Person;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class PersonCollections
 */
public class PersonCollections {
    private static LinkedList<Person> personLinkedList = new LinkedList<>();
    private static LocalDate localDate = LocalDate.now();

    public static LocalTime getLocalTime() {
        return localTime;
    }

    private static LocalTime localTime = LocalTime.now();

    public static LinkedList<Person> getPersonLinkedList() {
        return personLinkedList;
    }

    public static void setPersonLinkedList(LinkedList linkedList) {
        PersonCollections.personLinkedList = linkedList;
    }

    public static LocalDate getLocalDate() {
        return localDate;
    }

    public static void setPersonLinkedList(LocalDate localDate) {
        localDate = LocalDate.now();
    }

    /**
     * GetSize
     * @return size of the list
     */
    public int getSize() {
        return personLinkedList.size();
    }

    /**
     * Get info about list
     * @return String line
     */
    public String getInfo() {
        return "Коллекция: LinkedList\nДата инициализации: " + localDate + "\nВремя инициализации: " + localTime+"\b\b\b\b\nРазмер коллекции: " + this.getSize();
    }

    /**
     * Checking is id busy
     * @param id
     * @return boolean
     */
    public boolean isIdBusy(int id) {
        for (Person person : personLinkedList)
            if (person.getId() == id) return true;
        return false;
    }

    /**
     * Getting a free id for a new person
     * @return free id
     */
    public static int getFreeId(){
        HashMap<Integer, String> busyId = new HashMap<>();
        for(Person person : personLinkedList){
            busyId.put(person.getId(),"id");
        }
        int id=1;
        while(true){
            if(busyId.get(id)==null){
                return id;
            }else id++;
        }
    }

    /**
     * adding a person to list
     * @param p
     */
    public void add(Person p){
        personLinkedList.add(p);
    }


}




