package assignment4;

/**
 * Creating the motorsailer subclass.
 */
public class Motorsailer extends Boat {
  private int depth;
  private int hp;

  /**
   * Creating the class constructor.
   */
  public Motorsailer(String name, String type, int length, int depth, int hp) {
    super(name, type, length);
    this.depth = depth;
    this.hp = hp;
  }

  public int getDepth() {
    return depth;
  }

  public int getHp() {
    return hp;
  }

  @Override
  public String toString() {
    return ("BOAT:" + super.getName() + ":" + super.getType()
        + ":" + super.getLength() + ":"
        + this.getDepth() + ":" + this.getHp());
  }

  @Override
  public String print() {
    return ("Name: " + super.getName() + " Type: " + super.getType()
        + " Length: " + super.getLength() + " meters" + " Depth: "
        + this.getDepth() + " meters" + " Engine Power: " + this.getHp() + " horse powers");

  }
}
