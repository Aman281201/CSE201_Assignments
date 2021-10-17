package classes;

import java.util.Date;

interface Assessment {
    void showData();
}

class Assignment implements Assessment{

    private String statement;
    private int maxMarks;
    private Human author;
    private Date date;

    Assignment(String statement, int maxMarks, Human author)
    {
        this.statement = statement;
        this.maxMarks = maxMarks;
        this.author = author;
        this.date = date;
    }

    @Override
    public void showData()
    {}
}

class Quiz implements Assessment{

    private String question;
    private int maxMarks;
    private Human author;
    private Date date;

    Quiz(String question, int maxMarks, Human author)
    {
        this.question = question;
        this.author = author;
        this.maxMarks = maxMarks;
        this.date = new Date();
    }

    @Override
    public void showData()
    {}
}