package classes.Evaluation;

import classes.Human.Instructor;
import classes.Human.Person;

import java.util.Date;

public class Quiz implements Assessment {

    private String question;
    private int maxMarks;
    private Instructor author;
    private Date date;

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

    @Override
    public void showData() {
    }
}