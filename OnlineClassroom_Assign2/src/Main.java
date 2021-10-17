import classes.Human;
import classes.Human.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Instructor> instructors = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();

    public static void instructorLogin() {

        for(int i =0; i < instructors.size(); i++)
            System.out.println();
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



        Scanner sc =  new Scanner(System.in);

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
                case 1:instructorLogin();
                    break;
                case 2: StudentLogin();
                    break;
                case 3: break;

                default:
                    System.out.println("please enter correct choice");
            }
        }while(x != 3);
    }


}
