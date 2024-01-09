import java.util.Scanner;

public class Calculator {

  public static void invalidInput() {
    System.out.println("Invalid input entered. Terminating...");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
      "List of operations: add subtract multiply divide alphabetize"
    );
    System.out.println("Enter an operation:");
    String operation = scanner.nextLine().toLowerCase();

    try {
      switch (operation) {
        case "add":
          handleAddition(scanner);
          break;
        case "subtract":
          handleSubtraction(scanner);
          break;
        case "multiply":
          handleMultiplication(scanner);
          break;
        case "divide":
          handleDivision(scanner);
          break;
        case "alphabetize":
          handleAlphabetize(scanner);
          break;
        default:
          invalidInput();
          break;
      }
    } finally {
      scanner.close();
    }
  }

  private static void handleAddition(Scanner scanner) {
    System.out.println("Enter two integers:");
    if (scanner.hasNextInt()) {
      int num1 = scanner.nextInt();
      if (scanner.hasNextInt()) {
        int num2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Answer: " + (num1 + num2));
      } else {
        invalidInput();
      }
    } else {
      invalidInput();
    }
  }

  private static void handleSubtraction(Scanner scanner) {
    System.out.println("Enter two integers:");
    if (scanner.hasNextInt()) {
      int num1 = scanner.nextInt();
      if (scanner.hasNextInt()) {
        int num2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Answer: " + (num1 - num2));
      } else {
        invalidInput();
      }
    } else {
      invalidInput();
    }
  }

  private static void handleMultiplication(Scanner scanner) {
    System.out.println("Enter two doubles:");
    if (scanner.hasNextDouble()) {
      double num1 = scanner.nextDouble();
      if (scanner.hasNextDouble()) {
        double num2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.printf("Answer: %.2f%n", num1 * num2);
      } else {
        invalidInput();
      }
    } else {
      invalidInput();
    }
  }

  private static void handleDivision(Scanner scanner) {
    System.out.println("Enter two doubles:");
    if (scanner.hasNextDouble()) {
      double num1 = scanner.nextDouble();
      if (scanner.hasNextDouble()) {
        double num2 = scanner.nextDouble();
        scanner.nextLine();
        if (num2 != 0) {
          System.out.printf("Answer: %.2f%n", num1 / num2);
        } else {
          invalidInput();
        }
      } else {
        invalidInput();
      }
    } else {
      invalidInput();
    }
  }

  private static void handleAlphabetize(Scanner scanner) {
    System.out.println("Enter two words:");
    if (scanner.hasNext()) {
      String word1 = scanner.next();
      if (scanner.hasNext()) {
        String word2 = scanner.next();
        scanner.nextLine();
        if (word1.equalsIgnoreCase(word2)) {
          System.out.println("Answer: Chicken or Egg.");
        } else if (word1.compareToIgnoreCase(word2) < 0) {
          System.out.println(
            "Answer: " + word1 + " comes before " + word2 + " alphabetically."
          );
        } else {
          System.out.println(
            "Answer: " + word2 + " comes before " + word1 + " alphabetically."
          );
        }
      } else {
        invalidInput();
      }
    } else {
      invalidInput();
    }
  }
}
