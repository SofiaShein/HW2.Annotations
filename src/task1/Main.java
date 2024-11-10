package task1;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            RectangleAreaCalculator calculator = new RectangleAreaCalculator();

            Class<?> clazz = calculator.getClass();

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Rectangle.class)) {
                    Rectangle annotation = method.getAnnotation(Rectangle.class);

                    int width = annotation.width();
                    int height = annotation.height();

                    method.invoke(calculator, width, height);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
