package task1;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем объект RectangleAreaCalculator
            RectangleAreaCalculator calculator = new RectangleAreaCalculator();

            // Получаем класс RectangleAreaCalculator
            Class<?> clazz = calculator.getClass();

            // Перебираем методы класса
            for (Method method : clazz.getDeclaredMethods()) {
                // Проверяем, помечен ли метод аннотацией Rectangle
                if (method.isAnnotationPresent(Rectangle.class)) {
                    // Получаем аннотацию
                    Rectangle annotation = method.getAnnotation(Rectangle.class);

                    // Получаем параметры из аннотации
                    int width = annotation.width();
                    int height = annotation.height();

                    // Вызываем метод с параметрами
                    method.invoke(calculator, width, height);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
