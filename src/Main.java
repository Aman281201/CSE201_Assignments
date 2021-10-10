import classes.Hospital;
import classes.Slots;
import classes.User;
import classes.Vaccine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
    public static int hospitalID = 100000;
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, User> citizenID = new HashMap<>();
    public static HashMap<Integer, Hospital> hospitals = new HashMap<>();
    public static HashMap<String, ArrayList<Hospital>> areaHospitals = new HashMap<>();



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
        hospitals.put(hospitalID, h);

        if(areaHospitals.get(pin) == null)
            areaHospitals.put(pin,new ArrayList<Hospital>());

        areaHospitals.get(pin).add(h);
        
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

        if(age < 18)
            isEligible = false;

        User u = new User(name,age,uniqueID,isEligible);
        citizenID.put(uniqueID,u);


        System.out.println("\nCitizen Name: "+ name + ", age: " + age + ", Unique ID: " + uniqueID);
        if(!isEligible)
            System.out.println("\nOnly 18 above are allowed for vaccination");
        System.out.println("\n___________________________________");
    }


    public static void addSlot()
    {
        int hosID, num_slots, day_num, qty, vac;
        boolean isCorrect = false;

        Hospital h;
        do {
            System.out.println("Enter Hospital ID (6 digits): ");
            hosID = sc.nextInt();

            if(hosID == 0)
                return;
            h = hospitals.get(hosID);

            if(h == null)
                System.out.println("Hospital with this ID DoesNot exist (enter 0 to exit)");
            else {
                isCorrect = true;
            }
        }while (!isCorrect);

        System.out.println("Enter number of slots to be added : ");
        num_slots = sc.nextInt();
        for(int x = 0 ; x < num_slots ;x++) {
            System.out.println("Enter Day number : ");
            day_num = sc.nextInt();
            System.out.println("Enter Quantity : ");
            qty = sc.nextInt();
            System.out.println("Select Vaccine\n");
            for (int i = 0; i < vaccines.size(); i++) {
                System.out.println(i + ") " + vaccines.get(i).name + "\n");
            }
            vac = sc.nextInt();
            Vaccine v = vaccines.get(vac);
            Slots s = new Slots(day_num, qty, v);
            v.addHospitalSlots(h, s);
            System.out.println("\nSlot added by Hospital " + hosID + " for Day " + day_num + ", Available Quantity: " + qty + " of vaccine " + v.name+"\n");
        }
            System.out.println("\n___________________________________");

    }

    public static void bookSlot()
    {
        String patientID;
        boolean isCorrect = true;
        
        do {
            System.out.println("Enter unique Patient ID (12 digits)");
            patientID = sc.next();

            if(patientID.equals("0"))
                return;

            if (citizenID.get(patientID) == null) {
                isCorrect = false;
                System.out.println("This citizen does not exist (enter 0 to exit)\n");
            }
        }while(!isCorrect);

        int res;
        do {
            System.out.println("""
                    1.Search by area
                    2.Search by vaccine
                    3.Exit
                    """);
            res = sc.nextInt();

                    int hosID, slot_num;
                    
                    String v, pin;
                    
                    
                    if( res < 1 || res > 3)
                        System.out.println("please enter correct choice");
                    
                    else {
                        
                        if (res == 3)
                            return;
                        
                        else if (res == 1) {
                            System.out.println("Enter PinCode");
                            pin = sc.next();
                            ArrayList<Hospital> ah = areaHospitals.get(pin);
                            
                            for(int i = 0; i< ah.size(); i++)
                                System.out.println(ah.get(i).uniqueID + " " + ah.get(i).name + "\n");
                            
                        } else if (res == 2) {
                            System.out.println("Enter name of vaccine");
                            v = sc.next();
                            Vaccine vac = null;
                            for(int i = 0; i< vaccines.size(); i++)
                                if(vaccines.get(i).name == v)
                                    vac = vaccines.get(i);
                            
                            for(int i = 0; i < vac.hospitals.size(); i++)
                                    System.out.println(vac.hospitals.get(i).uniqueID + " " + vac.hospitals.get(i).name + "\n");
                        }
                        System.out.println("Enter hospital ID");
                        hosID = sc.nextInt();
                        Hospital h = hospitals.get(hosID);
                        if (h.slots == null) {
                            System.out.println("No slots available\n___________________");
                            return;
                        }
                        for (int i = 0; i < h.slots.size(); i++) {
                            Slots s = h.slots.get(i);
                            if (s.quantity > 0)
                                System.out.println(i + ") Day " + s.day + " Available Qty : " + s.quantity + " Vaccine : " + s.vaccine + "\n");
                            else
                                System.out.println(i + ") Day " + s.day + " Unavailable Qty : " + s.quantity + " Vaccine : " + s.vaccine + "\n");
                        }
                        System.out.println("choose slot : ");
                        slot_num = sc.nextInt();

                        Slots slot = h.slots.get(slot_num);

                        if (slot.quantity > 0) {
                            slot.quantity = slot.quantity - 1;
                            User patient = citizenID.get(patientID);
                            System.out.println(patient.name + " vaccinated with " + slot.vaccine.name + "\n");
                            System.out.println("_____________________\n");

                            if (patient.status.doses < slot.vaccine.no_of_doses - 1)
                                patient.setStatus("PARTIALLY VACCINATED", slot.vaccine, ++patient.status.doses, slot.day + slot.vaccine.gap);
                            else
                                patient.setStatus("FULLY VACCINATED", slot.vaccine, ++patient.status.doses, 0);

                        } else {
                            System.out.println("This slot is unavailable, slot booking failed, please select other slot");
                            return;
                        }

                    }
        }while(res != 3);

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
                case 4: addSlot();
                    break;
                case 5: bookSlot();
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
