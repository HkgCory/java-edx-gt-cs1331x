import java.util.Scanner;

public class Battleship {

  private static Scanner scanner = new Scanner(System.in);

  private char empty = '-';
  private char not_hit = '@';
  private char hit = 'X';
  private char miss = 'O';
  private char[][] mapLocation = new char[5][5];
  private char[][] mapTarget = new char[5][5];

  public static void main(String[] args) {
    System.out.println("Welcome to Battleship!");
    char[][] p1location = new char[5][5];
    char[][] p2location = new char[5][5];
    char[][] p1target = new char[5][5];
    char[][] p2target = new char[5][5];
    // Create the ocean map

  }

  private void initializeBoard() {
    for (int row = 0; row < 5; row++) {
      for (int column = 0; column < 5; column++) {
        mapLocation[row][column] = empty;
        mapTarget[row][column] = empty;
      }
    }
  }

  private void player1Turn() {
    System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
    System.out.println("Enter ship 1 location:");
    String ship1 = scanner.nextLine();
  }

  private void player2Turn() {
    System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
    System.out.println("Enter ship 1 location:");
    String ship1 = scanner.nextLine();
  }

  private void invalidCoordinates() {
    if (input < 0 || input > 4) {
      System.out.println("Invalid coordinates. Choose different coordinates.");
    }
  }

  private void occupied_coordinates() {
    if (mapLocation[input][input] == 'X') {
      System.out.println(
        "You already have a ship there. Choose different coordinates."
      );
    }
  }
}
