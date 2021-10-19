package classes.Evaluation;

import classes.Human.Instructor;
import classes.Human.Submission;

import java.util.ArrayList;
import java.util.Date;

public class Quiz implements Assessment {

    private String question;
    private String type;
    private Instructor author;
    private Date date;
    private ArrayList<Submission> submissions;
    private boolean isOpen;


    public Quiz()                                           // function overload
    {
        this.date = new Date();
        this.type = "Quiz";
    }

    public Quiz(String question, Instructor author) {
        this.question = question;
        this.author = author;
        this.date = new Date();
        this.type = "Quiz";
        this.isOpen = true;
    }

    @Override
    public void addSubmissions(Submission sub)
    {
        this.submissions.add(sub);
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public boolean getIsOpen()
    {
        return isOpen;
    }

    @Override
    public void close()
    {
        isOpen = false;
    }

    @Override
    public ArrayList<Submission> getSubmissions()
    {
        return submissions;
    }

    @Override
    public void showData(int i) {
        System.out.println("ID: " + i + " : Question: " + question + "\n");

    }

}