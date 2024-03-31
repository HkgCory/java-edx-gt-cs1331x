package HW05;

import java.util.Arrays;
import javax.sound.midi.SysexMessage;

public class Gameplay {

  public static void main(String[] args) {
    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

    RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut suspiciousperson = new RedAstronaut(
      "Suspicious Person",
      100,
      "expert"
    );

    Player[] player = { bob, heath, albert, angel, liam, suspiciousperson };
    for (Player p : player) System.out.println(p);

    System.out.println("1.Liam sabotages Bob");
    liam.sabotage(bob);
    for (Player p : player) System.out.println(p);

    System.out.println("2.Liam freezes Suspicious Person");
    liam.freeze(suspiciousperson);
    for (Player p : player) System.out.println(p);

    System.out.println("3.Liam freezes Albert");
    liam.freeze(albert);
    for (Player p : player) System.out.println(p);

    System.out.println("4.Albert call an emergency meeting");
    albert.emergencyMeeting();
    for (Player p : player) System.out.println(p);

    System.out.println("5.Suspicious person call an emergency meeting");
    suspiciousperson.emergencyMeeting();
    for (Player p : player) System.out.println(p);

    System.out.println("6.Bob calls an emergency meeting");
    bob.emergencyMeeting();
    for (Player p : player) System.out.println(p);

    System.out.println("7.Heath completes task");
    heath.completeTask();
    for (Player p : player) System.out.println(p);

    System.out.println("8.Heath completes task");
    heath.completeTask();
    for (Player p : player) System.out.println(p);

    System.out.println("9.Heath completes task");
    heath.completeTask();
    for (Player p : player) System.out.println(p);

    System.out.println("10.Liam freezes Angel");
    liam.freeze(angel);
    for (Player p : player) System.out.println(p);

    System.out.println("11.liam sabotage Bob first");
    liam.sabotage(bob);
    for (Player p : player) System.out.println(p);
    System.out.println("11.liam sabotage Bob twice");
    liam.sabotage(bob);
    for (Player p : player) System.out.println(p);

    System.out.println("12.Liam freezes bob");
    liam.freeze(bob);
    for (Player p : player) System.out.println(p);

    // System.out.println("13.Angel calls emergency meeting");
    // angel.emergencyMeeting();
    // for (Player p : player) System.out.println(p);

    System.out.println("14.Liam sabotages Heath");
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    for (Player p : player) System.out.println(p);

    System.out.println("15.Liam freezes Heath");
    liam.freeze(heath);
    for (Player p : player) System.out.println(p);
  }
}
