package HW06;

public class Dog extends Pet {

  private double droolRate;

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
  }

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public double getDroolRate() {
    return this.droolRate;
  }

  @Override
  public int treat() {
    heal();
    double treatTime;

    if (this.getDroolRate() < 3.5) {
      treatTime = (this.getPainLevel() * 2) / this.getHealth();
    } else if (this.getDroolRate() <= 7.5) {
      treatTime = this.getPainLevel() / this.getHealth();
    } else {
      treatTime = this.getPainLevel() / (this.getHealth() * 2);
    }
    return (int) Math.ceil(treatTime);
  }

  @Override
  public void speak() {
    super.speak();
    String bark = "bark ".repeat(this.getPainLevel());
    System.out.println(this.getPainLevel() > 5 ? bark.toUpperCase() : bark);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Dog) {
      return super.equals(o) && this.getDroolRate() == ((Dog) o).getDroolRate();
    }
    return false;
    //     if (!super.equals(o) || !(o instanceof Dog)) return false;
    //     Dog dog = (Dog) o;
    //     return Double.compare(dog.getDroolRate(), this.getDroolRate()) == 0;
    //     //can't use o because o is an object
  }
}
