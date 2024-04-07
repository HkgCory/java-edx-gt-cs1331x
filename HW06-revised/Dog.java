public class Dog extends Pet {

  private double droolRate;

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate <= 0 ? .5 : droolRate;
  }

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public double getDroolRate() {
    return droolRate;
  }

  public int treat() {
    int time;
    heal();
    if (droolRate < 3.5) {
      time = (int) Math.ceil((getPainLevel() * 2) / getHealth());
    } else if (droolRate <= 7.5) {
      time = (int) Math.ceil(getPainLevel() / getHealth());
    } else {
      time = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    return time;
  }

  public void speak() {
    super.speak();
    String output = "";
    String bark = (getPainLevel() > 5) ? "BARK " : "bark ";

    for (int i = 0; i < getPainLevel(); i++) {
      output += bark;
    }
    System.out.println(output.trim());
  }

  public boolean equals(Object o) {
    return (super.equals(o) && (((Dog) o).droolRate) == droolRate);
  }
}
