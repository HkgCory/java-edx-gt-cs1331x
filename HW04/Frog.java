public class Frog {

  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears * 12), tongueSpeed);
  }

  public Frog(String name) {
    this(name, 5, 5);
  }

  private void frogletCheck() {
    isFroglet = age > 1 && age < 7;
  }

  public void grow(int month) {
    for (int i = 0; i < month; i++) {
      if (age < 12) {
        tongueSpeed++;
      } else if (age >= 30) {
        tongueSpeed = Math.max(tongueSpeed - 1, 5);
      }
      age++;
      frogletCheck();
    }
  }

  public void grow() {
    grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }
    if (tongueSpeed > fly.getSpeed()) {
      if (fly.getMass() > 0.5 * age) {
        grow();
      }
      fly.setMass(0);
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    frogletCheck();
    String frogCheck = isFroglet ? "froglet" : "frog";

    if (frogCheck == "froglet") {
      return String.format(
        "My name is %s and I\'m a rare %s! I\'m %d months old and my tongue has a speed of %.2f.",
        name,
        frogCheck,
        age,
        tongueSpeed
      );
    } else {
      return String.format(
        "My name is %s and I\'m a rare %s. I\'m %d months old and my tongue has a speed of %.2f.",
        name,
        frogCheck,
        age,
        tongueSpeed
      );
    }
  }

  public static String getSpecies() {
    return species;
  }

  public static void setSpecies(String newSpecies) {
    Frog.species = newSpecies;
  }
}
