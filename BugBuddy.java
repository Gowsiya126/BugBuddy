import java.util.Scanner;
import java.util.ArrayList;

public class BugBuddy {

    static String[] errors = {
        "NullPointerException",
        "ArrayIndexOutOfBoundsException",
        "ArithmeticException",
        "NumberFormatException",
        "ClassNotFoundException"
    };

    static String[] meanings = {
        "You are using an object that is null.",
        "You are accessing an invalid array position.",
        "An illegal arithmetic operation occurred.",
        "A string could not be converted into a number.",
        "Java could not find the required class."
    };

    static String[] fixes = {
        "Check whether the object is null before using it.",
        "Check the array index before accessing an element.",
        "Avoid dividing an integer by zero.",
        "Check the input before converting it to a number.",
        "Check the class name and classpath."
    };

    static String[] keywords = {
        "null object empty",
        "array index position bounds",
        "zero divide division",
        "number input convert string",
        "class missing not found"
    };

    static String[] examples = {
        "String name = null;\nSystem.out.println(name.length());",
        "int[] a = {10, 20};\nSystem.out.println(a[5]);",
        "int a = 10 / 0;",
        "int n = Integer.parseInt(\"hello\");",
        "Class.forName(\"MissingClass\");"
    };

    static ArrayList<String> history = new ArrayList<>();

    static void showError(int i) {
        System.out.println("\nError: " + errors[i]);
        System.out.println("Meaning: " + meanings[i]);
        System.out.println("How to fix: " + fixes[i]);
        System.out.println("Example that causes it:");
        System.out.println(examples[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("       Welcome to BugBuddy 2.0");
        System.out.println(" Beginner-Friendly Java Error Tool");
        System.out.println("==================================");

        while (true) {
            System.out.println("\n1. View all errors");
            System.out.println("2. Smart keyword search");
            System.out.println("3. View search history");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {

                for (int i = 0; i < errors.length; i++) {
                    showError(i);
                }

            } else if (choice.equals("2")) {

                System.out.print("Enter error name or keyword: ");
                String query = sc.nextLine().trim().toLowerCase();

                if (query.isEmpty()) {
                    System.out.println("Please enter a keyword.");
                    continue;
                }

                boolean found = false;

                for (int i = 0; i < errors.length; i++) {
                    if (errors[i].toLowerCase().contains(query)
                            || keywords[i].contains(query)) {

                        showError(i);
                        history.add(errors[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println(
                        "No match found. Try: null, array, zero, number, class.");
                }

            } else if (choice.equals("3")) {

                System.out.println("\n--- Search History ---");

                if (history.isEmpty()) {
                    System.out.println("No searches yet.");
                } else {
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + ". " + history.get(i));
                    }
                }

            } else if (choice.equals("4")) {

                System.out.println("Thanks for using BugBuddy 2.0!");
                break;

            } else {
                System.out.println("Invalid choice. Enter 1, 2, 3 or 4.");
            }
        }

        sc.close();
    }
}