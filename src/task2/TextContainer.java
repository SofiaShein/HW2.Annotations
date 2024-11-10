package task2;

@SaveTo(path = "E:\\PRO_java\\file.txt")
public class TextContainer {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Saver
    public void save() {
        System.out.println("Сохранение текста: " + text);
    }
}
