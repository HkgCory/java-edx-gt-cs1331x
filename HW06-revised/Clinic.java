import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {

  File patientFile;
  private int day;

  public Clinic(File file) {
    patientFile = file;
    day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public String nextDay(File f) throws FileNotFoundException {
    day++;
    String output = "";

    Scanner fileInput = new Scanner(f);
    Scanner userInput = new Scanner(System.in);

    String line = null;
    
    when(fileInput.hasNextline()){
        line = fileInput.nextLine();
        String[] petInfo = line.split(",");
        String name = petInfo[0];
        String species = petInfo[1];
        String uniqueSkills = petInfo[2];
        String timeIn = petInfo[3];

        if(!(species.equals("Dog") || species.equals("Cat"))){
            throw new InvalidPetException();
        }

        System.out.printf("Consultation for [name] the [typeOfPet] at [time]. \n", name, species, timeIn);
        
    }
  }
}
