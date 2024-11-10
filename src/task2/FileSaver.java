package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class FileSaver {

    public static void saveText(Class<?> clazz) {
        if (clazz.isAnnotationPresent(SaveTo.class)) {
            SaveTo saveToAnnotation = clazz.getAnnotation(SaveTo.class);
            String path = saveToAnnotation.path();

            try {
                Object instance = clazz.getDeclaredConstructor(String.class).newInstance("Текст для сохранения");

                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Saver.class)) {
                        method.invoke(instance);

                        File file = new File(path);
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        try (FileWriter writer = new FileWriter(path)) {
                            writer.write("Текст: " + "Текст для сохранения");
                            System.out.println("Текст успешно сохранен в файл: " + path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
