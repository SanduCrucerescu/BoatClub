package assignment4;

import java.util.ArrayList;

/**
 * Member class.
 */
public class Member {
  private String memberName;
  private String memberEmail;
  private String memberID;
  protected ArrayList<Boat> boats = new ArrayList<>();
  //protected ConsoleUI ui;

  /**
   * Constructing the new member.
   */
  public Member(String memberName, String memberEmail, String memberID) {
    this.memberName = memberName;
    this.memberEmail = memberEmail;
    this.memberID = memberID;
  }

  public String getName() {
    return memberName;
  }

  public String getEmail() {
    return memberEmail;
  }

  public String getID() {
    return memberID;
  }

  public void addBoat(Boat i) {
    boats.add(i);
  }

  public void deleteBoat(String boatName) {
    boats.removeIf(obj -> obj.getName().equals(boatName));
  }


  @Override
  public String toString() {
    return ("MEMBER:" + getName() + ":" + getEmail() + ":" + getID());
  }

  public ArrayList<Boat> getBoats() {
    ArrayList copy = (ArrayList) boats.clone();
    return (copy);
  }
}
