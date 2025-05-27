public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 = " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+), so 5 * 2 is evaluated first (10), then 10 + 10 = 20.");

        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + result2);
        System.out.println("Explanation: Parentheses change precedence, so 10 + 5 is evaluated first (15), then multiplied by 2, resulting in 30.");

        int result3 = 20 / 4 + 3 * 2;
        System.out.println("Result of 20 / 4 + 3 * 2 = " + result3);
        System.out.println("Explanation: Division and multiplication have the same precedence and are evaluated left to right. So 20 / 4 = 5, 3 * 2 = 6, then 5 + 6 = 11.");
    }
}
