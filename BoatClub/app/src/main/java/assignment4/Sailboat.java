package assignment4;

/**
 * Creating the sailboat subclass.
 */
public class Sailboat extends Boat {
  private int depth;


  public Sailboat(String name, String type, int length, int depth) {
    super(name, type, length);
    this.depth = depth;
  }

  public int getDepth() {
    return depth;
  }

  @Override
  public String toString() {
    return ("BOAT:" + super.getName() + ":" + super.getType()
        + ":" + super.getLength() + ":" + this.getDepth());
  }

  @Override
  public String print() {
    return ("Name: " + super.getName() + " Type: " + super.getType()
        + " Length: " + super.getLength() + " meters" + " Depth: " + this.getDepth() + " meters");
  }
}
