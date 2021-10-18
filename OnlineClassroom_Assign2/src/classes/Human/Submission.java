package classes.Human;

import classes.Evaluation.Assessment;

public class Submission {
    private String type;
    private Assessment assessment;
    private String answer;
    private String filename;
    private Person author;
    private float marks;
    private boolean isOpen;
    private Person gradedBy;

    Submission(String answer, Assessment assessment, Person author)
    {
        this.answer = answer;
        this.assessment = assessment;
        this.author = author;
        this.type = "Quiz";
    }

    Submission(Assessment assessment, String filename, Person author)
    {
        this.assessment = assessment;
        this.filename = filename;
        this.author = author;
        this.type = "Assignment";
    }
    public void setMarks(float marks)
    {
        this.marks = marks;
    }
    public Person getAuthor()
    {
        return this.author;
    }
    public String getType()
    {
        return type;
    }

}
