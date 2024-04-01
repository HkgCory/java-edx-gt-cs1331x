package HW06;

public class Cat extends Pet {

  private int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = miceCaught < 0 ? 0 : miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught() {
    return this.miceCaught;
  }

  @Override
  public int treat() {
    heal();
    double treatTime;

    if (this.miceCaught < 4) {
      treatTime = (this.getPainLevel() * 2) / this.getHealth();
    } else if (this.miceCaught <= 7) {
      treatTime = this.getPainLevel() / this.getHealth();
    } else {
      treatTime = this.getPainLevel() / (this.getHealth() * 2);
    }
    return (int) Math.ceil(treatTime);
  }

  @Override
  public void speak() {
    super.speak();
    String meow = "meow ".repeat(this.getMiceCaught());
    System.out.println(this.getPainLevel() > 5 ? meow.toUpperCase() : meow);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cat) {
      return (
        super.equals(o) && this.getMiceCaught() == ((Cat) o).getMiceCaught()
      );
    }
    return false;
    // if (!super.equals(o) || !(o instanceof Dog)) return false;
    // Cat cat = (Cat) o;
    // return Double.compare(cat.getMiceCaught(), this.getMiceCaught()) == 0;
  }
}
