public class Cat extends Pet {

  private int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel));
    this.miceCaught = (miceCaught < 0) ? 0: miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name,health,painLevel,0);
  }

  public int getMiceCaught(){
    return miceCaught;
  }

  public int treat() {
    int time;
    heal();

    if(miceCaught < 4){
        time = (int) Math.ceil((getPainLevel() * 2) / getHealth());
    } else if (miceCaught < 7) {
        time = (int) Math.ceil(getPainLevel() / getHealth());
    }   else {
        time = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    return time;
  }

  public void speak() {
    super.speak();
    String meow = (getPainLevel() > 5) ? "MEOW" : "meow";
    String output ="";
    for (int i = 0; i<getPainLevel();i++){
        output += meow;
    }
    System.out.println(output.trim());
  }

  public boolean equals(Object o){
    return (super.equals(o) && ((Cat) o).miceCaught == miceCaught);
  }
}
