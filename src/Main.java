
import Commands.*;
import FileStuff.Parser;
import FileStuff.FileReader;

import java.util.*;

/**
 * Main class
 */
public class Main {
//    final static String file = "collection.txt";

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Parser.fillcollection(FileReader.readFile(FileReader.getFilePath()));
//        String filename = "json.json";
//        Parser.fillcollection(FileReader.readFile(filename));
//        Parser.fillcollection(FileReader.readFile("/home/s336385/lab5/json.json"));
        Receiver receiver = new Receiver();
        Command command = new Command();
        command.filling(new Add(receiver), new AddIfMin(receiver), new AscendingBirthday(receiver), new Clear(receiver), new ExecuteScript(receiver),
                new Exit(receiver), new Help(receiver), new Info(receiver), new InsertAtIndex(receiver), new PrintAscending(receiver),
                new Save(receiver), new Show(receiver), new StartsWithName(receiver), new Update(receiver), new RemoveById(receiver), new History(receiver));
        Scanner in = new Scanner(System.in);


        System.out.println("Приложение готово к работе,введите команду,для справки введите \"help\".");
        while (true) {
            System.out.print("~ ");
            try {
                String commandName = in.nextLine();
                Receiver.history.add(commandName);
                if (commandName.trim().length() != 0)
                    command.executeCommand(commandName);
                System.out.println("Введите команду:");
            }catch (NoSuchElementException e){
                System.out.println("Чтаааааааа!!!");
                break;
            }
        }
    }
}
