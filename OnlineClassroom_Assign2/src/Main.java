
import classes.Comment;
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
    public static ArrayList<Comment> comments = new ArrayList<Comment>();
    public static Scanner sc =  new Scanner(System.in).useDelimiter("\\n");
    public static Person user;
//    public static Student submitter;

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

            Lecture slides = new Slides((Instructor) user, topic, numSlides, content);


            lectures.add((Lecture) slides);

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

                if(!isCorrect)
                System.out.println("please upload videos with .mp4 extension");
            }while(!isCorrect);

            Lecture vid = new Video(topic, filename, (Instructor) user);

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

            Assessment assignment = new Assignment(statement, maxMarks, (Instructor) user);
            assessments.add(assignment);
            for(int i =0; i < students.size(); i++)
            {
                students.get(i).addPending(assignment);
            }
            System.out.println("added assignment\n");
        }

        else if (choice == 2)
        {
            String question;

            System.out.println("enter quiz question");
            question = sc.next();

            Assessment quiz = new Quiz(question , (Instructor) user);
            assessments.add(quiz);

            for(int i =0; i < students.size(); i++)
            {
                students.get(i).addPending(quiz);
            }

            System.out.println("added quiz\n");
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
        int id, studId, quizAns;
        float score;

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
            if(!ass.getSubmissions().get(i).getGraded())
                System.out.println(i + " - " + ass.getSubmissions().get(i).getAuthor().getId() + "\n");
        }
        System.out.println("Enter the id :");
        studId = sc.nextInt();

        System.out.println("Submission\n");
        Submission cur = ass.getSubmissions().get(studId);
        Student stud = (Student) cur.getAuthor();

        System.out.println(cur.getAnswer() + "\n_____________________\n");
        if(ass.getType().equals("Assignment")) {
            System.out.println("Max Marks : " + ((Assignment) ass).getMaxMarks());
            System.out.println("Enter marks Scored\n");
            score = sc.nextFloat();
            cur.setMarks(score);
        }
        else{
            System.out.println("select among the following\n1) correct answer       2) incorrect answer");
            quizAns = sc.nextInt();
            if(quizAns == 1)
                cur.setCorrect();
        }

        cur.setGraded(true);
        cur.setGradedBy(user);
    }

    public static void closeAssessment()
    {
        System.out.println("List of open assessments\n");
        int a = 0, id,c=0;
        int[] b= new int[assessments.size()];

        for(int i = 0; i < assessments.size(); i++)
        {
            if(assessments.get(i).getIsOpen())
            {
            assessments.get(i).showData(a);
            System.out.println("____________________");
            a++;
            }
            else {c++;
            b[i] = c;
            }
        }
        System.out.println("enter id of assignment to close: \n");
        id = sc.nextInt();
        assessments.get(b[id] + id).close();
    }

    public static void viewComments()
    {
        for(int i =0; i < comments.size(); i++) {
            comments.get(i).showData();
            System.out.println("\n\n");
        }

    }

    public static void addComments()
    {
        String comment;
        System.out.println("Enter comment: ");
        comment = sc.next();
        Comment com = new Comment(comment, user);
        comments.add(com);

    }

    public static void submitAssessment()
    {
        int assId, x;
        String filename, answer;

        System.out.println("Pending assessments\n");
        x = ((Student)user).showPending();
        if(x == -1)
            return;

        System.out.println("Enter the ID of assessment to submit");
        assId = sc.nextInt();
        Assessment ass = ((Student)user).getPending(assId);

        if(ass.getIsOpen()) {
            if (ass.getType().equals("Assignment")) {
                System.out.println("Enter filename of assignment");
                boolean isCorrect = false;
                do {
                    filename = sc.next();
                    String[] a = filename.split("[.]");

                    isCorrect = (a[a.length - 1].equals("zip"));

                    if (!isCorrect)
                        System.out.println("please upload videos with .mp4 extension");
                } while (!isCorrect);


                Submission sub = new Submission(ass, filename, user);
                ((Student) user).removePending(assId);
                ass.addSubmissions(sub);
                ((Student) user).addSubmitted(sub);

            } else {
                System.out.println("Enter answer to the Question");
                answer = sc.next();
                Submission sub = new Submission(answer, ass, user);
                ((Student) user).removePending(assId);
                ass.addSubmissions(sub);
                ((Student) user).addSubmitted(sub);
            }
        }
        else System.out.println("Deadline for this assignment is already over\n");
    }

    public static void viewGrades()
    {   ArrayList<Submission> sub = ((Student) user).getSubmissions();

        System.out.println("Graded Assessments");
        for(int i = 0; i < sub.size(); i++)
        {
            if(sub.get(i).getGraded())
            { Submission cur = sub.get(i);
                if(cur.getType().equals("Assignment")) {
                    System.out.println("Submission: " + cur.getFilename());
                    System.out.println("Marks Scored :" + cur.getScoredMarks());
                    System.out.println("Graded by : " + cur.getGradedBy().getId());
                }
                else {
                    if(cur.getType().equals("Quiz"))
                    {
                        System.out.println("Your answer : " + cur.getAnswer()+"\n");
                        if(cur.getCorrect())
                            System.out.println("Your answer is Correct");

                        else System.out.println("Your answer is wrong");

                        System.out.println("Graded by : " + cur.getGradedBy().getId());
                    }
                }
            }
        }

        System.out.println("\n____________________________\n");

        System.out.println("Un Graded Assessments");

        for(int i = 0; i < sub.size(); i++)
        {
            if(!sub.get(i).getGraded())
            {
                Submission cur = sub.get(i);
                if(cur.getType().equals("Assignment")) {
                    System.out.println("Submission: " + cur.getFilename());

                }
                else {
                    if(cur.getType().equals("Quiz"))
                    {
                        System.out.println("Your answer : " + cur.getAnswer());

                    }
                }
            }
        }

    }

    public static void instructorLogin() {

        int choice, res;

        for(int i =0; i < instructors.size(); i++)
            System.out.println(i + " -> " + instructors.get(i).getId());

        System.out.println("choose id\n");
        choice = sc.nextInt();

        user = (Instructor) instructors.get(choice);

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
                case 6: closeAssessment();
                    break;
                case 7: viewComments();
                    break;
                case 8: addComments();
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
        int res, choice;
        for(int i =0; i < students.size(); i++)
            System.out.println(i + " -> " + students.get(i).getId());

        System.out.println("choose id\n");
        choice = sc.nextInt();

        user = (Student) students.get(choice);

        do{
            System.out.println("Welcome " + user.getId() + "\n");
            user.showMenu();
            res = sc.nextInt();

            switch(res){
                case 1: showLectures();
                    break;
                case 2: viewAssessments();
                    break;
                case 3: submitAssessment();
                    break;
                case 4: viewGrades();
                    break;
                case 5: viewComments();
                    break;
                case 6: addComments();
                    break;
                case 7:
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("please enter the correct choice");
            }
        }while(res != 7);
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