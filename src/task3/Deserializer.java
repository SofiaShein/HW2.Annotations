package task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;

public class Deserializer {
    public static Person deserialize() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Person p = new Person();
        try (FileInputStream fis = new FileInputStream("Person.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Class<?> cls = p.getClass();
            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    if (field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    Object value = ois.readObject();
                    field.set(p, value);
                }
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
            throw new IOException("Error during deserialization");
        }

        return p;
    }
}
