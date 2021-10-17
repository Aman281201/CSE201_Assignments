import classes.Human;
import classes.Human.*;
import classes.Lectures.*;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Instructor> instructors = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner sc =  new Scanner(System.in);
    public static Person user;

    public static <Lecture> void addLecture()
    {
        int choice;

        System.out.println("""
                
                1. Add Lecture Slide
                2. Add lecture Video
                
                Enter choice
                """);

        choice = sc.nextInt();
        if(choice == 1)
        {
            String topic;
            int numSlides;
            String[] content;

            System.out.println("enter the topic of the video");
            topic = sc.nextLine();
            System.out.println("Enter the number of slides");
            numSlides = sc.nextInt();

            content = new String[numSlides];
            for(int i = 0; i < numSlides; i++)
            {
                System.out.println("Content of slide " + (i+1) + " : ");
                content[i] = sc.nextLine();
            }

            Lecture slides = (Lecture) new Slides((Human) user, topic, numSlides, content);

        }
        else if (choice == 2)
        {
            String topic, filename;
            System.out.println("Enter the topic of the video");
            topic = sc.nextLine();
            System.out.println("Enter the filename of video");
            filename = sc.nextLine();

            boolean isCorrect = false;
            
            do{
                isCorrect = (filename.split(".")[1] == ".mp4");
                System.out.println("please upload videos with .mp4 extension");
            }while(!isCorrect);

        }
        else System.out.println("please enter correct choice");

    }
    public static void instructorLogin() {

        int choice, res;

        for(int i =0; i < instructors.size(); i++)
            System.out.println(i + " -> " + instructors.get(i).getId());

        System.out.println("choose id\n");
        choice = sc.nextInt();

        user = instructors.get(choice);

        do{
            System.out.println("Welcome " + user.getId() + "\n");
            user.showMenu();
            res = sc.nextInt();

            switch(res){
                case 1: addLecture();
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
