package FileStuff;

import java.io.*;

/**
 * File Reader
 */
public class FileReader {

    private static final String envPath = System.getenv("DATA_JSON");

    /**
     * Get an environment variable
     * @return
     */
    public static String getFilePath(){return envPath;}

    /**
     * Read from file
     * @param filename
     * @return
     * @throws IOException
     */
    public static String readFile(String filename) throws IOException {
        try {
            String data = "";
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                data += (char) i;
            }
            FileWriter.setFilename(filename);
            return data;
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Вы не ввели имя файла.");
            return null;
        }
    }
}
