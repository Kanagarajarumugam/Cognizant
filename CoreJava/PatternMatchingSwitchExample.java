public class PatternMatchingSwitchExample {

    public static void identifyObject(Object obj) {
        String result = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String with value: " + s;
            case Double d -> "It's a Double with value: " + d;
            case null -> "Object is null";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };

        System.out.println(result);
    }

    public static void main(String[] args) {
        identifyObject(42);
        identifyObject("Hello");
        identifyObject(3.14);
        identifyObject(true);
        identifyObject(null);
    }
}
