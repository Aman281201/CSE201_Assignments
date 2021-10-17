import classes.Human;
import classes.Human.*;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Instructor> instructors = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner sc =  new Scanner(System.in);


    public static void instructorLogin() {

        int choice, res;

        for(int i =0; i < instructors.size(); i++)
            System.out.println(i + " -> " + instructors.get(i).getId());

        System.out.println("choose id\n");
        choice = sc.nextInt();

        Person user = instructors.get(choice);

        do{
            System.out.println("Welcome " + user.getId() + "\n");
            user.showMenu();
            res = sc.nextInt();

            switch(res){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case  7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("please enter the correct choice");
            }
        }while(res != 9);
    }


    public static void studentLogin()
    {
        for(int i =0; i < students.size(); i++)
            System.out.println(i + " -> " + students.get(i).getId());
    }

    public static void main(String[] args)
    {

        Person I0 = new Instructor("I0");
        Person I1 = new Instructor("I1");

        Person S0 = new Student("S0");
        Person S1 = new Student("S1");
        Person S2 = new Student("S2");

        instructors.add((Instructor) I0);
        instructors.add((Instructor) I1);

        students.add((Student) S0);
        students.add((Student) S1);
        students.add((Student) S2);


        int x;

        do {
            System.out.println("""
                    Welcome to Backpack
                    1. Enter as instructor
                    2. Enter as a student
                    3. Exit
                                    
                    Enter choice
                    """);

            x = sc.nextInt();


            switch(x)
            {
                case 1: instructorLogin();
                    break;
                case 2: studentLogin();
                    break;
                case 3:
                    System.out.println("Exiting BackPack");
                    break;

                default:
                    System.out.println("please enter correct choice");
            }
        }while(x != 3);
    }


}
