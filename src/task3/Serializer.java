package task3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer {
    public static void serialize(Person p) throws IllegalAccessException, IOException {
        try (FileOutputStream fos = new FileOutputStream("Person.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Class<?> cls = p.getClass();
            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    if (Modifier.isPrivate(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    oos.writeObject(field.get(p));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error during serialization");
        }
    }
}
