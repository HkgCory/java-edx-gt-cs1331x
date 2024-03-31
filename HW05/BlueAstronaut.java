// package HW05;

import java.util.Arrays;

// import java.util.Collections;

public class BlueAstronaut extends Player implements Crewmate {

  private int numTasks;
  private int taskSpeed;
  private boolean firstTimeComplete = true;

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public BlueAstronaut(String name) {
    this(name, 15, 6, 10);
  }

  // @Override
  // public void emergencyMeeting() {
  //   if (!this.isFrozen());
  //   Player[] players = Player.getPlayers();
  //   Arrays.sort(players, Collections.reverseOrder());

  //   Player highestSus = null;
  //   for (Player player : players) {
  //     if (!player.isFrozen() && player != this) {
  //       if (
  //         highestSus == null || player.getSusLevel() > highestSus.getSusLevel()
  //       ) {
  //         highestSus = player;
  //       } else if (player.getSusLevel() == highestSus.getSusLevel()) {
  //         highestSus = null;
  //         break;
  //       }
  //     }
  //   }
  //   if (highestSus != null) highestSus.setFrozen(true);
  //   this.gameOver();
  // }

  @Override
  public void emergencyMeeting() {
    if (!this.isFrozen()) {
      Player[] players = Player.getPlayers();
      Arrays.sort(players);
      for (int i = players.length - 1; i >= 0; i--) {
        if (
          players[i] != this &&
          players[i].getSusLevel() != players[i - 1].getSusLevel()
        ) {
          if (!players[i].isFrozen()) {
            players[i].setFrozen(true);
            break;
          }
        } else if (
          !players[i].isFrozen() &&
          !players[i - 1].isFrozen() &&
          players[i].getSusLevel() == players[i - 1].getSusLevel()
        ) {
          return;
        }

        if (i == 0 && !players[i].isFrozen() && players[i] != this) {
          players[i].setFrozen(true);
        }
      }
      this.gameOver();
    }
  }

  //   if (!players[i].isFrozen() && players[i] != this) {
  //     if (
  //       highestSus == null &&
  //       (players[i].getSusLevel() > highestSus.getSusLevel())
  //     ) {
  //       highestSus = players[i];
  //     }
  //   } else if (players[i].getSusLevel() == highestSus.getSusLevel()) {
  //     highestSus = null;
  //     break;
  //   }
  // }
  // if (highestSus != null) {
  //   highestSus.setFrozen(true);
  // }
  // super.gameOver();

  public void completeTask() {
    if (!this.isFrozen()) {
      if (this.taskSpeed > 20) {
        this.numTasks -= 2;
      } else {
        this.numTasks--;
      }

      if (this.numTasks < 0) {
        this.numTasks = 0;
      }

      if (this.firstTimeComplete == true && this.numTasks == 0) {
        this.firstTimeComplete = false;
        System.out.println("I have completed all my task");
        this.setSusLevel((int) Math.floor(this.getSusLevel() * .5));
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BlueAstronaut)) return false;
    if (!super.equals(o)) return false;
    BlueAstronaut blue = (BlueAstronaut) o;
    return numTasks == blue.numTasks;
  }

  // @Override
  // public boolean equals(Object o) {
  //   if (o instanceof BlueAstronaut) {
  //     BlueAstronaut blue = (BlueAstronaut) o;
  //     return super.equals(blue);
  //   }
  //   return false;
  // }

  @Override
  public String toString() {
    String frozencheck = this.isFrozen() ? "frozen" : "not frozen";
    String str = String.format(
      "My name is %s, and I have a suslevel of %s. I am currently %s. I have %s left over.",
      this.getName(),
      this.getSusLevel(),
      frozencheck,
      this.numTasks
    );

    if (this.getSusLevel() > 15) {
      return str.toUpperCase();
    } else {
      return str;
    }
  }

  public int getNumTasks() {
    return numTasks;
  }

  public void setNumTasks(int numTasks) {
    this.numTasks = numTasks;
  }

  public int getTaskSpeed() {
    return taskSpeed;
  }

  public void setTaskSpeed(int taskSpeed) {
    this.taskSpeed = taskSpeed;
  }
}
