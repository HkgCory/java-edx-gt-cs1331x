import java.io.*;
import java.util.*;

public class Battleship {

  public static void main(String[] args) {
    System.out.println("\nWelcome to Battleship!\n");
  }

  // Use this method to print game boards to the console.
  private static void printBattleShip(char[][] player) {
    System.out.print("  ");
    for (int row = -1; row < 5; row++) {
      if (row > -1) {
        System.out.print(row + " ");
      }
      for (int column = 0; column < 5; column++) {
        if (row == -1) {
          System.out.print(column + " ");
        } else {
          System.out.print(player[row][column] + " ");
        }
      }
      System.out.println("");
    }
  }

  private static void player1(Scanner scanner) {
    System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
    char[][] player1 = new char[5][5];
    initializeBoard(player1);
    placeShips(player1, scanner);

    printBattleShip(player1);
    for (int i = 0; i < 100; i++) {
      System.out.println();
    }
  }

  private static void player2(Scanner scanner) {
    System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
    char[][] player2 = new char[5][5];
    initializeBoard(player2);
    placeShips(player2, scanner);

    printBattleShip(player2);
    for (int i = 0; i < 100; i++) {
      System.out.println();
    }
  }

  // Board initialize
  private static void initializeBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        board[row][column] = '-';
      }
    }
  }

  private static void placeShips(char[][] board, Scanner scanner) {
    for (int i = 0; i < 5; i++) {
      while (true) {
        try {
          System.out.println("Enter ship " + (i + 1) + " location:");
          int row = scanner.nextInt();
          int column = scanner.nextInt();
          if (
            row < 0 ||
            row >= board.length ||
            column < 0 ||
            column >= board[0].length
          ) {
            System.out.println(
              "Invalid coordinates. Choose different coordinates."
            );
          } else if (board[row][column] == 'S') {
            System.out.println(
              "You already have a ship there. Choose different coordinates."
            );
          } else {
            board[row][column] = 'S';
            break;
          }
        } catch (InputMismatchException e) {
          System.out.println(
            "Invalid coordinates. Choose different coordinates."
          );
          scanner.next();
        }
      }
    }
  }
}
