package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Functionality to print the game state and player messages to the console,
 * also some console input helpers.
 */
public class ConsoleUI {
  Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);

  /**
   * Prompt to insert new members.
   */
  public String promptForNewCustomer() {

    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,
          Charset.defaultCharset().name()));

      System.out.print("Input the name of the customer: ");
      String name = reader.readLine();
      System.out.print("Input the email address(optional): ");
      String email = reader.readLine();


      StringJoiner output = new StringJoiner(":");
      output.add(email)
            .add(name);
      return output.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Prompt for selecting a member id.
   */
  public String promptForSelectMemeber() {
    System.out.print("Player ID: ");

    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,
          Charset.defaultCharset().name()));
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Prompt to display the member menu.
   */
  public int promptForUserOptions() {
    System.out.println("""
        1. Delete Member
        2. Add Boat
        3. View Boats
        4. Exit""");
    System.out.print("\nSelect an option to continue:");

    int choise = in.nextInt();

    while (choise < 0 || choise > 4) {
      System.out.print("Input a integer between 1-3: ");
      while (!in.hasNextInt()) {
        System.out.print("Please input a valid integer: ");
      }
      choise = in.nextInt();
    }

    return choise;
  }

  /**
   * Prompt for inserting a boat.
   */
  public String promptForBoatInsert() {
    StringJoiner joiner = new StringJoiner(":");


    System.out.println("""
        1. Sailboat
        2. Motorboat
        3. Motorsailer
        4. Canoe""");
    System.out.print("\nSelect boat type: ");
    String length;
    String depth;
    String hp;
    int type;

    do {
      System.out.print("Input a integer between 1-4: ");
      while (!in.hasNextInt()) {
        System.out.print("Please input a valid integer: ");
      }
      type = in.nextInt();
    } while (type < 0 || type > 4);


    System.out.print("Boat name: ");
    String name = in.next();

    switch (type) {
      case 1 -> {
        System.out.print("Boat length (Meters): ");
        length = in.next();
        while (Integer.parseInt(length) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(length)) {
            System.out.print("Please input a integer: ");
          }
          length = in.next();
        }

        System.out.print("Boat depth (Meters): ");
        depth = in.next();
        while (Integer.parseInt(depth) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(depth)) {
            System.out.print("Please input a integer: ");
          }
          depth = in.next();
        }
        joiner.add(String.valueOf(type))
            .add(name)
            .add(length)
            .add(depth);
        return joiner.toString();
      }
      case 2 -> {
        System.out.print("Boat length (Meters): ");
        length = in.next();
        while (Integer.parseInt(length) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(length)) {
            System.out.print("Please input a integer: ");
          }
          length = in.next();
        }

        System.out.print("Boat's engine power (Horse Powers): ");
        hp = in.next();
        while (Integer.parseInt(hp) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(hp)) {
            System.out.print("Please input a integer: ");
          }
          hp = in.next();
        }

        joiner.add(String.valueOf(type))
            .add(name)
            .add(length)
            .add(hp);
        return joiner.toString();
      }
      case 3 -> {
        System.out.print("Boat length (Meters): ");
        length = in.next();
        while (Integer.parseInt(length) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(length)) {
            System.out.print("Please input a integer: ");
          }
          length = in.next();
        }

        System.out.print("Boat depth (Meters): ");
        depth = in.next();
        while (Integer.parseInt(depth) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(depth)) {
            System.out.print("Please input a integer: ");
          }
          depth = in.next();
        }

        System.out.print("Boat's engine power (Horse power): ");
        hp = in.next();
        while (Integer.parseInt(hp) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(hp)) {
            System.out.print("Please input a integer: ");
          }
          hp = in.next();
        }

        joiner.add(String.valueOf(type))
            .add(name)
            .add(length)
            .add(depth)
            .add(hp);
        return joiner.toString();
      }
      case 4 -> {
        System.out.print("Boat length (Meters): ");
        length = in.next();
        while (Integer.parseInt(length) < 0) {
          System.out.print("Please input a positive integer: ");
          while (!checkInt(length)) {
            System.out.print("Please input a integer: ");
          }
          length = in.next();
        }
        joiner.add(String.valueOf(type))
            .add(name)
            .add(length);
        return joiner.toString();
      }
      default -> {
      }
    }
    return "";
  }

  /**
   * Checks if the String is a integer.
   */
  public boolean checkInt(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
