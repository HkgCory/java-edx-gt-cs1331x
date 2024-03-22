public class Pond {

  public static void main(String[] args) {
    Frog Peepo = new Frog("Peepo");
    Frog Pepe = new Frog("Pepe", 10, 15);
    Frog Peepaw = new Frog("Peepaw", 4.6, 5);
    Frog Peepee = new Frog("Peepee", 6, 6);

    Fly fly1 = new Fly(1, 3);
    Fly fly2 = new Fly(6);
    Fly fly3 = new Fly(8);

    Peepee.setSpecies("1331 Frogs");
    System.out.println(Peepo.toString());
    Peepo.eat(fly2);
    System.out.println(fly2.toString());
    Peepo.grow(8);
    Peepo.eat(fly2);
    System.out.println(fly2.toString());
    System.out.println(Peepo.toString());
    System.out.println(Peepee.toString());
    Peepaw.grow(4);
    System.out.println(Peepaw.toString());
    System.out.println(Pepe.toString());
  }
}
