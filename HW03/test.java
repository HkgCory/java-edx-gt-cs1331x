import java.util.Scanner;

public class test {

  private static char[][] player1Grid = new char[5][5];
  private static char[][] player2Grid = new char[5][5];
  private static char[][] player1AttackGrid = new char[5][5];
  private static char[][] player2AttackGrid = new char[5][5];
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    createGrid(player1Grid);
    createGrid(player1AttackGrid);
    createGrid(player2Grid);
    createGrid(player2AttackGrid);
    System.out.println("Welcome to Battleship!\n");
    playerTurn(1, player1Grid);
    playerTurn(2, player2Grid);
    playerFire();
  }

  private static void playerFire() {
    boolean player1 = true, winner = false;

    do {
      int currentPlayer = player1 ? 1 : 2;

      System.out.println("Player " + currentPlayer + ", enter hit row/column:");
      int fireRow = scanner.nextInt(), fireColumn = scanner.nextInt();

      if (!validCoordinate(fireRow, fireColumn)) {
        System.out.println(
          "Invalid coordinates. Choose different coordinates."
        );
        continue;
      }

      // char[][] currentPlayerGrid = player1 ? player1Grid : player2Grid;
      char[][] currentPlayerAttackGrid = player1
        ? player1AttackGrid
        : player2AttackGrid;
      char[][] attackTarget = player1 ? player2Grid : player1Grid;

      if (
        currentPlayerAttackGrid[fireRow][fireColumn] == 'O' ||
        currentPlayerAttackGrid[fireRow][fireColumn] == 'X'
      ) {
        System.out.println(
          "You already fired on this spot. Choose different coordinates."
        );
        continue;
      } else if (attackTarget[fireRow][fireColumn] != '@') {
        System.out.println("PLAYER " + currentPlayer + " MISSED!");
        currentPlayerAttackGrid[fireRow][fireColumn] = 'O';
        attackTarget[fireRow][fireColumn] = 'O';
        printBattleShip(currentPlayerAttackGrid);
        System.out.println();
      } else {
        System.out.println(
          "PLAYER " +
          currentPlayer +
          " HIT PLAYER " +
          (3 - currentPlayer) +
          "'s SHIP!"
        );
        currentPlayerAttackGrid[fireRow][fireColumn] = 'X';
        attackTarget[fireRow][fireColumn] = 'X';
        printBattleShip(currentPlayerAttackGrid);
        System.out.println();

        if (!checkGrid(attackTarget)) {
          winnerPlayer(currentPlayer, player1Grid, player2Grid);
          winner = true;
          break;
        }
      }
      player1 = !player1;
    } while (!winner);
  }

  private static void playerTurn(int playerNumber, char[][] playerGrid) {
    System.out.println(
      "PLAYER " + playerNumber + ", ENTER YOUR SHIPS COORDINATES."
    );
    for (int i = 0; i < 5; i++) {
      System.out.println("Enter Ship " + (i + 1) + " location:");
      int playerRow = scanner.nextInt(), playerColumn = scanner.nextInt();
      if (!validCoordinate(playerRow, playerColumn)) {
        System.out.println(
          "Invalid coordinates. Choose different coordinates."
        );
        i--;
      } else {
        if (playerGrid[playerRow][playerColumn] != '-') {
          System.out.println(
            "You already have a ship there. Choose different coordinates."
          );
          i--;
        } else {
          playerGrid[playerRow][playerColumn] = '@';
        }
      }
    }
    printBattleShip(playerGrid);
    newLine100();
  }

  private static void newLine100() {
    int newLine = 0;
    do {
      System.out.println();
      newLine++;
    } while (newLine < 100);
  }

  private static boolean validCoordinate(int row, int column) {
    boolean valid = (row >= 0 && row < 5 && column >= 0 && column < 5);
    return valid;
  }

  // private static boolean invalidCoordinate(int row, int column) {
  //   boolean invalid = (row < 0 && row > 4 && column < 0 && column > 4);
  //   return invalid;
  // }

  private static char[][] createGrid(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid.length; column++) {
        grid[row][column] = '-';
      }
    }
    return grid;
  }

  private static boolean checkGrid(char[][] grid) {
    boolean result = false;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == '@') result = true;
      }
    }
    return result;
  }

  private static void winnerPlayer(
    int winner,
    char[][] player1Grid,
    char[][] player2Grid
  ) {
    System.out.println(
      "PLAYER " + winner + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!"
    );
    System.out.println("\nFinal boards:\n");
    printBattleShip(player1Grid);
    System.out.println();
    printBattleShip(player2Grid);
  }

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
}
