package sample;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class resourceManager {

    public static void save(Serializable data, String fileName) throws Exception {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        }
    }

    public static Object load(String fileName) throws Exception {
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }

}
