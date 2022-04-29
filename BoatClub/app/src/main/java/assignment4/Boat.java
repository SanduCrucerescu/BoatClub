package assignment4;

/**
 * The main class of boats.
 */
public abstract class Boat {
  private String name;
  private String type;
  private int length;

  /**
   * The class constructor.
   */
  public Boat(String name, String type, int length) {
    this.name = name;
    this.type = type;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public int getLength() {
    return length;
  }

  public abstract String toString();

  public abstract String print();

}
