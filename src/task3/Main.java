package task3;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Ann", 30,"Kharkov");
            Serializer.serialize(person);
            System.out.println("Serialized.");

            Person deserialized = Deserializer.deserialize();
            System.out.println("Deserialized: " + deserialized);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
