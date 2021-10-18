package classes.Evaluation;

import classes.Human.Instructor;
import classes.Human.Person;
import classes.Human.Submission;

import java.util.ArrayList;
import java.util.Date;

public class Assignment implements Assessment {

    private String type;
    private String statement;
    private int maxMarks;
    private Instructor author;
    private Date date;
    private ArrayList<Submission> submissions;

    public Assignment(String statement, int maxMarks, Instructor author) {
        this.statement = statement;
        this.maxMarks = maxMarks;
        this.author = author;
        this.date = new Date();
        this.submissions = new ArrayList<>();
        this.type = "Assignment";
    }

    public void addSubmissions(Submission sub)
    {
        this.submissions.add(sub);
    }

    public ArrayList<Submission> getSubmissions()
    {
        return submissions;
    }

    public String getType()
    {
        return type;
    }
    @Override
    public void showData(int i) {
        System.out.println("ID: " + i + " : Assignment: " + statement + "  Max Marks : " + maxMarks + "\n");
    }
}