package assignment4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for running the actual application.
 */
public class Application {
  Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
  BufferedWriter out;
  Random random = new Random();
  final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  final String numbers = "0123456789";

  private ConsoleUI ui;
  private ArrayList<Member> members;

  Application() {
    ui = new ConsoleUI();
    members = new ArrayList<>();
  }

  /**
   * Generating a unique id for each new member.
   */
  public String customerID() {
    String alphaNumeric = alphabet + numbers;

    StringBuilder id = new StringBuilder();

    int length = 6;

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(alphaNumeric.length());
      char randomChar = alphaNumeric.charAt(index);
      id.append(randomChar);
    }

    String memberID = id.toString();

    return memberID;
  }


  private void startApplication() {
    String menu = """
        \n1. View all members
        2. Add new member
        3. View member
        4. Exit""";
    System.out.println(menu);

    System.out.print("\nSelect an option to continue:");
    int choice;
    choice = in.nextInt();
    while (choice < 0 || choice > 4) {
      System.out.print("Input a integer between 1-4: ");
      while (!in.hasNextInt()) {
        System.out.print("Please input a valid integer: ");
      }
      choice = in.nextInt();
    }

    switch (choice) {
      case 1 -> viewMembers();
      case 2 -> addMember();
      case 3 -> viewUser();
      case 4 -> endApplication();
      default -> {
      }
    }
  }

  /**
   * Viewing the members.
   */
  public void viewMembers() {
    System.out.printf("%-18s %-20s %-15s%n", "Name", "Email", "ID");
    for (int i = 0; i < members.size(); i++) {
      System.out.printf("%-15s  %-20s %-15s%n", members.get(i).getName(),
          members.get(i).getEmail(), members.get(i).getID());
    }
    System.out.print("\nPress Enter to continue...");
    try {
      System.in.read();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Adding a new member.
   */
  public void addMember() {
    String[] generalData = ui.promptForNewCustomer().split(":");
    String email = generalData[0];
    String name = generalData[1];
    String id = customerID();

    while (true) {
      /*
      checks if the email field is empty if not it is not it will check
      if the email exists in the system
     */
      if (!email.isEmpty()) {
        if (checkEmail(email)) {
          System.out.print("This email exists. Please add a new email: ");
          email = in.next();
        } else {
          break;
        }
      }
      // checks if the id already exists
      if (checkID(id)) {
        id = customerID();
      } else {
        break;
      }
    }

    Member added = new Member(name, email, id);
    members.add(added);
    System.out.println("Member added successfully");
    System.out.print("Press Enter to continue...");
    try {
      System.in.read();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks if the email exists in the ArrayList.
   */
  public Boolean checkEmail(String email) {
    return members.stream().anyMatch(o -> o.getEmail().equals(email));
  }

  /**
   * Checks if the ID exists in the ArrayList.
   */
  public Boolean checkID(String id) {
    return members.stream().anyMatch(o -> o.getID().equals(id));
  }

  /**
   * Method to view member options.
   */
  public void viewUser() {
    String memberID = ui.promptForSelectMemeber();

    if (!checkID(memberID)) {
      System.out.println("Member not found \nTry again.");
      startApplication();
    } else {

      Member m = members.stream().filter(o -> memberID.equals(o.getID())).findFirst().orElse(null);


      assert m != null;
      System.out.println("Name: " + m.getName() + " Email: " + m.getEmail() + " ID: " + m.getID());

      int choise = ui.promptForUserOptions();

      switch (choise) {
        case 1 -> deleteUser(memberID);
        case 2 -> addBoat(memberID);
        case 3 -> deleteBoat(memberID);
        case 4 -> endApplication();
        default -> {
        }
      }
    }
  }

  /**
   * Add a new boat.
   */
  public void addBoat(String memberID) {
    String[] boatDetails = ui.promptForBoatInsert().split(":");
    int boatType = Integer.parseInt(boatDetails[0]);
    String[] typeArray = new String[] {"", "SailBoat", "Motorboat", "Motorsailer", "Canoe"};
    // return the member with the matching memberID
    Member member = Objects.requireNonNull(
        members.stream().filter(o -> memberID.equals(o.getID())).findFirst().orElse(null));

    switch (boatType) {
      case 1 -> {
        member.addBoat(new Sailboat(boatDetails[1], typeArray[boatType],
              Integer.parseInt(boatDetails[2]), Integer.parseInt(boatDetails[3])));
      }
      case 2 -> {
        member.addBoat(new Motorboat(boatDetails[1], typeArray[boatType],
                Integer.parseInt(boatDetails[2]), Integer.parseInt(boatDetails[3])));
      }
      case 3 -> {
        member.addBoat(new Motorsailer(boatDetails[1], typeArray[boatType],
                Integer.parseInt(boatDetails[2]), Integer.parseInt(boatDetails[3]),
                Integer.parseInt(boatDetails[4])));
      }
      case 4 -> {
        member.addBoat(new Canoe(boatDetails[1], typeArray[boatType],
                Integer.parseInt(boatDetails[2])));
      }
      default -> {
      }
    }
    System.out.print("Press Enter to continue...");
    try {
      System.in.read();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Method to delete the member.
   */
  public void deleteUser(String memberID) {
    members.removeIf(obj -> obj.getID().equals(memberID));
    System.out.println("Member deleted successfully");
    System.out.print("Press Enter to continue...");
    try {
      in.nextLine();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Deleting a specific boat.
   */
  public void deleteBoat(String memberID) {
    Member m = members.stream().filter(o -> memberID.equals(o.getID())).findFirst().orElse(null);

    for (int i = 0; i < m.getBoats().size(); i++) {
      System.out.println(m.getBoats().get(i).print());
    }
    System.out.print("Input the name of the boat you with to delete:");
    String boatName = in.next();
    m.deleteBoat(boatName);
    System.out.print("Boat deleted successfully\n");
    System.out.print("\nPress Enter to continue...");
    try {
      System.in.read();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to load a boats to the selected member.
   */
  public void loadBoat(String memberID, String name, String type, int lenght, int depth, int hp) {
    // return the member with the matching memberID
    Member member = Objects.requireNonNull(members.stream().filter(o ->
        memberID.equals(o.getID())).findFirst().orElse(null));
    switch (type) {
      case "SailBoat" ->
              member.addBoat(new Sailboat(name, type, lenght, depth));
      case "Motorboat" ->
              member.addBoat(new Motorboat(name, type, lenght, hp));
      case "Motorsailer" ->
              member.addBoat(new Motorsailer(name, type, lenght, depth, hp));
      case "Canoe" ->
          member.addBoat(new Canoe(name, type, lenght));
      default -> {
      }
    }
  }

  /**
   * Method to view member boats.
   */
  public void viewBoats(String memberID) {
    Member m = members.stream().filter(o -> memberID.equals(o.getID())).findFirst().orElse(null);

    for (int i = 0; i < m.getBoats().size(); i++) {
      System.out.println(m.getBoats().get(i).toString());
    }
    System.out.print("\nPress Enter to continue...");

    try {
      System.in.read();
      startApplication();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Loading data into the application.
   */
  public void loadData() {
    String id = null;
    try {
      Scanner sc = new Scanner(new File("registry.data"), Charset.defaultCharset());

      do {
        String line = sc.nextLine();
        String[] p = line.split(":");

        if (p[0].equals("MEMBER")) {
          members.add(new Member(p[1], p[2], p[3]));
          id = p[3];
        } else if (p[0].equals("BOAT")) {
          switch (p[2]) {
            case "SailBoat", "Motorboat" -> loadBoat(id, p[1], p[2],
                Integer.parseInt(p[3]), Integer.parseInt(p[4]), 0);
            case "Motorsailer" -> loadBoat(id, p[1], p[2],
                Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5]));
            case "Canoe" -> loadBoat(id, p[1], p[2], Integer.parseInt(p[3]), 0, 0);
            default -> {
            }
          }
        }
      } while (sc.hasNext());
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Saving the data to a txt.
   */
  private void endApplication() {
    System.out.println("Goodbye!!");
    try {
      out = new BufferedWriter(new FileWriter("registry.data", StandardCharsets.UTF_8, false));
      for (Member member : members) {
        out.write(member.toString());
        out.newLine();

        for (Boat boat : member.boats) {
          out.write(boat.toString());
          out.newLine();
        }
      }
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Runing the app.
   */
  public static void main(String[] args) {
    Application a = new Application();
    a.loadData();
    a.startApplication();
  }
}
