package classes.Evaluation;

import classes.Human.Human;

import java.util.Date;

public class Assignment implements Assessment {

    private String statement;
    private int maxMarks;
    private Human.Instructor author;
    private Date date;

    public Assignment(String statement, int maxMarks, Human.Instructor author) {
        this.statement = statement;
        this.maxMarks = maxMarks;
        this.author = author;
        this.date = new Date();
    }

    @Override
    public void showData() {
    }
}