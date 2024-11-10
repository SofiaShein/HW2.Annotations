package task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для методов с параметрами ширины и высоты
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Rectangle {
    int width();
    int height();
}
