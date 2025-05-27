import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add student entries (ID and Name). Type -1 as ID to stop.");

        while (true) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (id == -1) {
                break;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve name: ");
        int searchId = scanner.nextInt();

        String studentName = studentMap.get(searchId);
        if (studentName != null) {
            System.out.println("Student name: " + studentName);
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
