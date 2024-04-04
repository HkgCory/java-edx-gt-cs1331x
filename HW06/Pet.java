// package HW06;

public abstract class Pet {

  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    this.health = Math.max(0.0, Math.min(health, 1.0));
    this.painLevel = Math.max(1, Math.min(painLevel, 10));
  }

  public String getName() {
    return name;
  }

  public double getHealth() {
    return health;
  }

  public int getPainLevel() {
    return painLevel;
  }

  public abstract int treat();

  public void speak() {
    String greetings = "Hello! My name is " + this.name;
    if (painLevel > 5) {
      greetings.toUpperCase();
    }
    System.out.println(greetings);
  }

  public boolean equals(Object o) {
    return o instanceof Pet && name.equals(((Pet) o).name);
  }

  protected void heal() {
    this.health = 1.0;
    this.painLevel = 1;
  }
}
