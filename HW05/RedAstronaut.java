// package HW05;

import java.util.Arrays;

// import java.util.Collections;

public class RedAstronaut extends Player implements Impostor {

  private String skill;

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill.toLowerCase();
  }

  public RedAstronaut(String name) {
    this(name, 15, "experienced");
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

  // @Override
  // public void emergencyMeeting() {
  //   Player highestSus = null;
  //   if (!this.isFrozen()) {
  //     Player[] players = Player.getPlayers();
  //     Arrays.sort(players);

  //     for (int i = players.length - 1; i >= 0; i--) {
  //       if (!players[i].isFrozen() && players[i] != this) {
  //         if (
  //           highestSus == null &&
  //           players[i].getSusLevel() > highestSus.getSusLevel()
  //         ) {
  //           highestSus = players[i];
  //         }
  //       } else if (players[i].getSusLevel() == highestSus.getSusLevel()) {
  //         highestSus = null;
  //         break;
  //       }
  //     }
  //     if (highestSus != null) {
  //       highestSus.setFrozen(true);
  //     }
  //     super.gameOver();
  //   }
  // }

  @Override
  public void freeze(Player p) {
    if (!this.isFrozen() && !p.isFrozen() && !(p instanceof Impostor)) {
      if (this.getSusLevel() < p.getSusLevel()) {
        p.setFrozen(true);
      } else {
        this.setSusLevel(this.getSusLevel() * 2);
      }
    }
    super.gameOver();
  }

  @Override
  public void sabotage(Player p) {
    if (!(p instanceof Impostor) && !(this.isFrozen()) && !(p.isFrozen())) {
      if (this.getSusLevel() < 20) {
        p.setSusLevel((int) (p.getSusLevel() * 1.5));
      } else {
        p.setSusLevel((int) (p.getSusLevel() * 1.25));
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RedAstronaut) {
      RedAstronaut red = (RedAstronaut) o;
      return super.equals(red) && this.skill.equals(red.skill);
    }
    return false;
  }

  @Override
  public String toString() {
    String frozencheck = this.isFrozen() ? "frozen" : "not frozen";
    String str = String.format(
      "My name is %s, and I have a suslevel of %s. I am currently %s. I am an %s player!",
      this.getName(),
      this.getSusLevel(),
      frozencheck,
      this.skill
    );

    if (this.getSusLevel() > 15) {
      return str.toUpperCase();
    } else {
      return str;
    }
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill.toLowerCase();
  }
}
