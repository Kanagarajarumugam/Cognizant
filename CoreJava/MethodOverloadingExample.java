public class MethodOverloadingExample {

    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        int sum1 = add(5, 10);              // Calls int, int
        double sum2 = add(3.5, 4.5);        // Calls double, double
        int sum3 = add(1, 2, 3);            // Calls int, int, int

        System.out.println("Sum of 5 and 10: " + sum1);
        System.out.println("Sum of 3.5 and 4.5: " + sum2);
        System.out.println("Sum of 1, 2 and 3: " + sum3);
    }
}