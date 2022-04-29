package assignment4;

/**
 * The motorboat subclass.
 */
public class Motorboat extends Boat {
  private int hp;

  public Motorboat(String name, String type, int length, int hp) {
    super(name, type, length);
    this.hp = hp;
  }

  public int getHp() {
    return hp;
  }

  @Override
  public String toString() {
    return ("BOAT:" + super.getName() + ":" + super.getType()
        + ":" + super.getLength() + ":" + this.getHp());
  }

  @Override
  public String print() {
    return ("Name: " + super.getName() + " Type: " + super.getType()
        + " Length: "  + super.getLength() + " meters" + " Engine Power: " + this.getHp() + " horse powers");
  }
}
