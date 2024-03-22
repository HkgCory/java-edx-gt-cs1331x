public class Fly {

  private double mass;
  private double speed;

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public Fly(double mass) {
    this(mass, 10.0);
  }

  public Fly() {
    this(5.0, 10.0);
  }

  public double getMass() {
    return mass;
  }

  public void setMass(double mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {
    String massFormat = String.format("%.2f", mass);
    String speedFormat = String.format("%.2f", speed);
    return mass == 0
      ? "I'm dead, but I used to be a fly with a speed of " + speedFormat + "."
      : "I'm a speedy fly with " +
      speedFormat +
      " speed and " +
      massFormat +
      " mass.";
  }

  public void grow(int addedMass) {
    for (int i = 0; i < addedMass; i++) {
      if (mass < 20) {
        speed++;
      } else {
        speed -= 0.5;
      }
      mass++;
    }
  }

  public boolean isDead() {
    return mass == 0;
  }
}
