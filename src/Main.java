import classes.Hospital;
import classes.User;
import classes.Vaccine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
    public static int hospitalID = 100000;
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, Integer> citizenID = new HashMap<>();




    public static void addVaccine()
    {
        System.out.println("Enter vaccine name : ");
        String name = sc.next();
        System.out.println("Number of doses : ");
        int no_of_doses = sc.nextInt();
        System.out.println("Gap between doses : ");
        int gap = sc.nextInt();

        Vaccine v = new Vaccine(name, no_of_doses, gap);
        vaccines.add(v);

        System.out.println("\nVaccine Name: "+ name + ", Number of Doses: " + no_of_doses + ", Gap between Doses: " + gap);
        System.out.println("\n___________________________________");

    }

    public static void regHospital()
    {
        String name, pin;
        System.out.println("Enter Hospital name : ");
        name = sc.next();
        System.out.println("PinCode : ");
        pin = sc.next();

        Hospital h = new Hospital(name, pin, ++hospitalID);

        System.out.println("\nHospital Name: "+ name + ", PinCode: " + pin + ", Unique ID: " + hospitalID);
        System.out.println("\n___________________________________");

    }

    public static void regCitizen()
    {
        String name, uniqueID;
        int age;
        boolean isEligible = true, isUnique = false;
        System.out.println("Enter Citizen name : ");
        name = sc.next();
        System.out.println("Age : ");
        age = sc.nextInt();

        do {
            System.out.println("Enter Unique ID (12 digits): ");
            uniqueID = sc.next();
            if(citizenID.get(uniqueID) == null)
                isUnique = true;
            else
                System.out.println("User already exists with this ID\n");
        }while (!isUnique);

        citizenID.put(uniqueID,1);

        if(age < 18)
            isEligible = false;

        User u = new User(name,age,uniqueID,isEligible);

        System.out.println("\nCitizen Name: "+ name + ", age: " + age + ", Unique ID: " + uniqueID);
        if(!isEligible)
            System.out.println("\nOnly 18 above are allowed for vaccination");
        System.out.println("\n___________________________________");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("CoWin portal started\n__________________________");

        do{
            System.out.println("""
                     
                     1) Add Vaccine
                     2) Register Hospital
                     3) Register Citizen
                     4) Add slot for Vaccination
                     5) Book slot for vaccination
                     6) List all slots for Vaccination
                     7) Check Vaccination status
                     8) Exit
                     """);

            choice = sc.nextInt();

            switch(choice)
            {
                case 1: addVaccine();
                    break;
                case 2: regHospital();
                    break;
                case 3: regCitizen();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("exiting CoWin portal");
                    break;
                default:
                    System.out.println("please enter a valid choice (1 to 8)\n");
            }
        }while(choice != 8);
    }
}
