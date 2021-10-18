
import classes.Evaluation.Assessment;
import classes.Evaluation.Assignment;
import classes.Evaluation.Quiz;
import classes.Human.Instructor;
import classes.Human.*;
import classes.Human.Student;
import classes.Lectures.*;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Instructor> instructors = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Lecture> lectures = new ArrayList<>();
    public static ArrayList<Assessment> assessments = new ArrayList<>();
    public static Scanner sc =  new Scanner(System.in).useDelimiter("\\n");
    public static Instructor user;
    public static Student submitter;

    public static void addLecture()
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

            System.out.println("enter the topic");
            topic = sc.next();
            System.out.println("Enter the number of slides");
            numSlides = sc.nextInt();

            content = new String[numSlides];
            for(int i = 0; i < numSlides; i++)
            {
                System.out.println("Content of slide " + (i+1) + " : ");
                content[i] = sc.next();
            }

            Lecture slides = new Slides(user, topic, numSlides, content);


            lectures.add((classes.Lectures.Lecture) slides);

        }
        else if (choice == 2)
        {
            String topic, filename;
            System.out.println("Enter the topic of the video");
            topic = sc.next();
            System.out.println("Enter the filename of video");


            boolean isCorrect = false;

            do{
                filename = sc.next();
                String[] a = filename.split("[.]");

                isCorrect = (a[a.length - 1].equals("mp4"));
                System.out.println(a[a.length - 1] + " " + isCorrect);
                System.out.println("please upload videos with .mp4 extension");
            }while(!isCorrect);

            Lecture vid = new Video(topic, filename, user);

            System.out.println("file uploaded\n");
            lectures.add((Lecture) vid);

        }
        else System.out.println("please enter correct choice");

    }

    public static void addAssessment()
    {

        int choice;

        System.out.println("""
                1. Add Assignment
                2. Add Quiz
                
                Enter your choice
                """);
        choice = sc.nextInt();

        if(choice == 1)
        {
            String statement;
            int maxMarks;

            System.out.println("enter problem statement");
            statement = sc.next();
            System.out.println("Enter maxMarks");
            maxMarks = sc.nextInt();

            Assessment assignment = new Assignment(statement, maxMarks, user);
            assessments.add(assignment);
            System.out.println("added assignment\n");
        }

        else if (choice == 2)
        {
            String question;

            System.out.println("enter quiz question");
            question = sc.next();

            Assessment quiz = new Quiz(question , user);
            assessments.add(quiz);
            System.out.println("added assignment\n");
        }
    }

    public static void showLectures()
    {
        for(int i = 0; i < lectures.size(); i++)
        {
            lectures.get(i).showData();
            System.out.println("\n\n");
        }

    }

    public static void viewAssessments()
    {
        for(int i = 0; i < assessments.size(); i++)
        {
            assessments.get(i).showData(i);
            System.out.println("____________________");
        }
    }

    public static void gradeAssessments()
    {
        int id, studId;

        System.out.println("List of assessments\n");
        viewAssessments();
        System.out.println("enter the Id to view submissions");
        id = sc.nextInt();

        Assessment ass;
        if(assessments.get(id).getType().equals("Assignment"))
            ass = (Assignment) assessments.get(id);
        else ass = (Quiz) assessments.get(id);

        for(int i = 0; i < ass.getSubmissions().size(); i++)
        {
            System.out.println(i + " - " + ass.getSubmissions().get(i).getAuthor().getId() + "\n");
        }
        System.out.println("Enter the id :");
         studId = sc.nextInt();
         
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
                case 2: addAssessment();
                    break;
                case 3: showLectures();
                    break;
                case 4: viewAssessments();
                    break;
                case 5: gradeAssessments();
                    break;
                case 6:
                    break;
                case 7:
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