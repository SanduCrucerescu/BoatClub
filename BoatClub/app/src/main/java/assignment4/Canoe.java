package assignment4;

/**
 * canoe class.
 */
public class Canoe extends Boat {
  /**
   * The class constructor.
  */
  public Canoe(String name, String type, int length) {
    super(name, type, length);
  }


  @Override
  public String toString() {
    return ("BOAT:" + super.getName() + ":" + super.getType()
        + ":" + super.getLength());
  }

  @Override
  public String print() {
    return ("Name: " + super.getName() + " Type: " + super.getType()
        + " Length: " + super.getLength() + " meters");
  }
}
