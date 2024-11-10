package task1;

public class RectangleAreaCalculator {

    @Rectangle(width = 4, height = 7)
    public void calculateArea(int width, int height) {
        int area = width * height;
        System.out.println("Площадь прямоугольника: " + area);
    }
}
