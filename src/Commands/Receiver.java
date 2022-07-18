package Commands;

import FileStuff.FileWriter;
import Person.Person;
import Person.PersonCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Receiver {

    public String add(Object o) throws Exception {
        PersonCollections personCollections = new PersonCollections();
        personCollections.add(new Creation().create("free"));
        System.out.println("Человек добавлен в список.");
        return "";
    }

    public String addIfMin(Object o) {
        Person p = new Creation().create("free");
        Person min = new Person();
        for (Person person : PersonCollections.getPersonLinkedList()) {
            if (p.getHeight() < person.getHeight()) {
                min = p;
            } else {
                min = person;
            }
        }
        if (min.equals(p)) {
            PersonCollections.getPersonLinkedList().add(p);
            System.out.println("Человек добавлен в список");
        } else {
            System.out.println("Значение роста добавляемого человека не меньше минимального значения роста человека из списка.\nЧеловек не был добавлен в список.");
        }
        return "";
    }

    public String ascendingBirthday(Object o) {
        PersonBirthdayComparator pbc = new PersonBirthdayComparator();
        PersonCollections.getPersonLinkedList().sort(pbc);
        for (Person person : PersonCollections.getPersonLinkedList()) {
            System.out.println(person.getId() + " : " + person.getBirthday().getDayOfMonth() + "." + person.getBirthday().getMonthValue() + "." + person.getBirthday().getYear());
        }
        return "";
    }

    class PersonBirthdayComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {

            return a.getBirthday().compareTo(b.getBirthday());
        }
    }

    public String clear(Object o) {
        PersonCollections.getPersonLinkedList().clear();
        System.out.println("Коллекция успешно очищена.");
        return "";
    }

    public String executeScript(Object filename) {
        try {
            String result = "";
            File file = new File((String) filename);
            Scanner in = new Scanner(file);
            Command commands = new Command();
            while (in.hasNextLine()) {
                String command = in.nextLine();
                result += ("Команда \"" + command + "\":\n");
                result += commands.executeCommand(command);
                result += "\n";
            }
            return result;
        } catch (NullPointerException | FileNotFoundException e) {
            return ("Указанный файл не найден.");
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String exit(Object o) {
        System.out.println("Происходит выход из консоли...");
        System.exit(0);
        return null;
    }

    public String help(Object o) {
        System.out.println("__________________________");
        Commandable[] c = {new Add((Receiver) o), new AddIfMin((Receiver) o), new AscendingBirthday((Receiver) o), new Clear((Receiver) o), new ExecuteScript((Receiver) o), new Exit((Receiver) o), new Help((Receiver) o), new Info((Receiver) o), new InsertAtIndex((Receiver) o), new PrintAscending((Receiver) o), new Save((Receiver) o), new Show((Receiver) o), new StartsWithName((Receiver) o), new Update((Receiver) o), new History((Receiver) o)};
        int i = 0;
        while (i < (c.length)) {
            System.out.println(c[i].getDescription());
            i++;
        }
        System.out.println("__________________________");
        return null;
    }

    public static List<String> history = new ArrayList();
    public static List<String> buffer = new ArrayList();
    public String history(Object o) throws Exception {
        for (String string : history) {
            if (!string.equals("add") & !string.equals("add_if_min") & !string.equals("print_field_ascending_birthday") &
                    !string.equals("clear") & !string.equals("execute_script") &
                    !string.equals("exit") & !string.equals("help") &
                    !string.equals("history") & !string.equals("info") &
                    !string.equals("insert_at") & !string.equals("print_ascending") &
                    !string.equals("remove_by_id") & !string.equals("save") &
                    !string.equals("show") & !string.equals("filter_starts_with_name") &
                    !string.equals("update")) {
                buffer.add(string);
            }
        }
        history.removeAll(buffer);
        int i = 0;
        while(history.size()>9){
            history.remove(i);
            i++;
        }
        for (String lines : history) {
            System.out.println(lines);
        }

        return "";
    }
    public String info(Object o) {
        PersonCollections personCollection = new PersonCollections();
        System.out.println(personCollection.getInfo());
        return "";

    }

    public String insertAtIndex(Object id) throws Exception {
        try {
            for (Person person : PersonCollections.getPersonLinkedList()) {
                if (person.getId()>=Integer.parseInt((String) id)) {
                    person.setId(person.getId()+1);
                }
            }
            PersonCollections.getPersonLinkedList().add((new Creation()).create((String) id));
            return "Человек добавлен в список.";
        } catch (Exception e) {
            return "Вы ввели некорректный аргумент" + e.getMessage();
        }
    }

    public String printAscending(Object o) {
        PersonHeightComparator phc = new PersonHeightComparator();
        PersonCollections.getPersonLinkedList().sort(phc);
        for (Person person : PersonCollections.getPersonLinkedList()) {
            person.getInfo();
        }
        return "";
    }

    static class PersonHeightComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {

            return a.getHeight().compareTo(b.getHeight());
        }
    }

    public String removeById(Object id) {
        if (!(new PersonCollections().isIdBusy(Integer.parseInt((String) id)))) {
            return "Человека с таким id нет в списке.";
        } else {
            for (Person person : PersonCollections.getPersonLinkedList()) {
                if (person.getId() == Integer.parseInt((String) id)) {
                    PersonCollections.getPersonLinkedList().remove(person);
                    return "Человек успешно удалён из списка.";
                }
            }
        }
        return null;
    }

    public String save(Object o) throws IOException {
        try {
            FileWriter.writeFile(PersonCollections.getPersonLinkedList());
            return ("");
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }

    public String show(Object o) {
        PersonCollections personCollections = new PersonCollections();
        PersonNameComparator pnc = new PersonNameComparator();
        PersonCollections.getPersonLinkedList().sort(pnc);
        if (personCollections.getSize() == 0) {
            System.out.println("Коллекция пустая.");
        } else {
            for (Person person : PersonCollections.getPersonLinkedList()) {
                person.getInfo();
            }
        }
        return "";
    }

    static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person person1, Person person2) {
            if (person1.getName() == person2.getName()) {
                return 0;
            }
            if (person1.getName().compareTo(person2.getName()) < 0) {
                return -1;
            } else {
                return -1;
            }
        }
    }

    public String startsWithName(Object str) {
        for (Person person : PersonCollections.getPersonLinkedList()) {
            if (person.getName().startsWith((String) str)) {
                person.getInfo();
            } else {
                System.out.println("Людей с таким именем нет.");
                break;
            }
        }
        return null;
    }

    public String update(Object obj) {
        PersonCollections collection = new PersonCollections();
        try {
            if (collection.isIdBusy(Integer.parseInt((String) obj))) {
                int id = Integer.parseInt((String) obj);
                Person vehicleToDelete = PersonCollections.getPersonLinkedList().stream().filter(x -> x.getId() == id).findFirst().get();
                collection.add((new Creation()).create((String) obj));
                PersonCollections.getPersonLinkedList().remove(vehicleToDelete);
                return ("Человек с id:" + obj + " обновлён.");
            } else System.out.println("Человека с таким id не существует.");
        } catch (Exception e) {
            System.out.println("Человека с таким id не существует.");
        }
        return "";
    }
}
