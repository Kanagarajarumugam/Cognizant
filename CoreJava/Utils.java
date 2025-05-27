public class Utils {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        String message = greet("Alice");
        System.out.println(message);
    }
}
