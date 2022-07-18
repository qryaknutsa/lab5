package FileStuff;

import Person.Person;
import com.google.gson.Gson;

import java.io.*;
import java.util.LinkedList;

/**
 * File writer
 */
public class FileWriter {
    static String filename;
    private BufferedOutputStream writer;

    /**
     * Set filename
     * @param filename
     */
    public static void setFilename(String filename) {
        FileWriter.filename = filename;
    }

    /**
     * Write data to file
     * @param persons
     * @throws FileNotFoundException
     */
    public static void writeFile(LinkedList<Person> persons) throws FileNotFoundException {
        Gson gson = new Gson();
        try {
            File file = new File(filename);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(gson.toJson(persons));
            printWriter.close();
            System.out.println("Коллекция сохранена.");
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
