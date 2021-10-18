package classes.Evaluation;

import classes.Human.Instructor;
import classes.Human.Submission;

import java.util.ArrayList;
import java.util.Date;

public class Quiz implements Assessment {

    private String question;
    private int maxMarks;
    private Instructor author;
    private Date date;
    private ArrayList<Submission> submissions;


    public Quiz()                                           // function overload
    {
        this.date = new Date();
    }

    public Quiz(String question, Instructor author) {
        this.question = question;
        this.author = author;
        this.maxMarks = maxMarks;
        this.date = new Date();
    }

    public void addSubmissions(Submission sub)
    {
        this.submissions.add(sub);
    }
    
    @Override
    public void showData(int i) {
        System.out.println("ID: " + i + " : Question: " + question + "  Max Marks : " + maxMarks + "\n");

    }
}