// package HW06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clinic {

  private File patientFile;
  private int day = 1;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public String nextDay(File f) throws FileNotFoundException {
    StringBuilder patientBuilder = new StringBuilder();
    Scanner fileScanner = new Scanner(f);
    Scanner inputScanner = new Scanner(System.in);

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine();
      String[] parts = line.split(",");
      String name = parts[0];
      String petType = parts[1];
      int uniqueSkill = Integer.parseInt(parts[2]);
      String timeIn = parts[3];

      System.out.printf(
        "Consultation for %s the %s at %s.\nWhat is the health of %s?\n",
        name,
        petType,
        timeIn,
        name
      );
      double health;
      while (!inputScanner.hasNextDouble()) {
        inputScanner.next();
        System.out.println("Please enter a valid number for health");
      }
      health = inputScanner.nextDouble();

      int painLevel;
      System.out.printf(
        "On a scale of 1 to 10, how much pain is %s in right now?\n",
        name
      );
      while (!inputScanner.hasNextInt()) {
        inputScanner.next();
        System.out.println("Please enter a valid whole number for pain level");
      }
      painLevel = inputScanner.nextInt();

      Pet pet;
      if ("Dog".equals(petType)) {
        pet = new Dog(name, health, painLevel, uniqueSkill);
      } else if ("Cat".equals(petType)) {
        pet = new Cat(name, health, painLevel, uniqueSkill);
      } else {
        throw new InvalidPetException("Your pet " + petType + " is invalid!");
      }

      pet.speak();
      int treatmentTime = pet.treat();
      String timeout = addTime(timeIn, treatmentTime);

      patientBuilder.append(
        String.format(
          "%s,%s,%d,Day %d,%s,%s,%.1f,%d\n",
          name,
          petType,
          uniqueSkill,
          day,
          timeIn,
          timeout,
          health,
          painLevel
        )
      );
    }

    fileScanner.close();
    day++;
    return patientBuilder.toString();
  }

  public String nextDay(String fileName) throws FileNotFoundException {
    return nextDay(new File(fileName));
  }

  // public boolean addToFile(String patientInfo) {
  //   try (FileWriter writer = new FileWriter(this.patientFile, true)) {
  //     writer.write(patientInfo);
  //     return true;
  //   } catch (IOException e) {
  //     e.printStackTrace();
  //     return false;
  //   }
  // }
  public boolean addToFile(String patientInfo) {
    try (FileWriter writer = new FileWriter(this.patientFile, true)) {
      // Ensure each new entry starts on a new line
      writer.append(patientInfo).append(System.lineSeparator());
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  private String addTime(String timeIn, int treatmentTime) {
    int hours = Integer.parseInt(timeIn.substring(0, 2));
    int minutes = Integer.parseInt(timeIn.substring(2, 4));

    int totalTime = hours * 60 + minutes;
    totalTime += treatmentTime;

    int newHours = totalTime / 60;
    int newMinutes = totalTime % 60;
    // hours += minutes / 60;
    // minutes %= 60;

    // int hours
    return String.format("%02d%02d", newHours, newMinutes);
  }
}
