import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Load the class by name
        Class<?> cls = Class.forName("Sample");

        // Print all declared methods with parameters
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("Method: " + method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Create an instance of Sample class
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Invoke the 'add' method dynamically with parameters (5, 3)
        Method addMethod = cls.getDeclaredMethod("add", int.class, int.class);
        Object result = addMethod.invoke(obj, 5, 3);

        System.out.println("Result of add(5, 3): " + result);
    }
}

// Sample class to be used with reflection
class Sample {
    public int add(int a, int b) {
        return a + b;
    }

    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}
