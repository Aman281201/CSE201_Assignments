package classes.Human;

import classes.Evaluation.Assessment;

public class Submission {
    private String type;
    private Assessment assessment;
    private String answer;
    private String filename;
    private Person author;
    private float marks;
    private boolean isCorrect;
    private boolean isGraded;
    private Person gradedBy;

    public Submission(String answer, Assessment assessment, Person author)
    {
        this.answer = answer;
        this.assessment = assessment;
        this.author = author;
        this.type = "Quiz";
        this.isCorrect = false;
        this.isGraded = false;
    }

    public Submission(Assessment assessment, String filename, Person author)
    {
        this.assessment = assessment;
        this.filename = filename;
        this.author = author;
        this.type = "Assignment";
        this.isGraded = false;
    }

    public String getFilename()
    {
        return this.filename;
    }

    public float getScoredMarks()
    {
        return this.marks;
    }

    public void setMarks(float marks)
    {
        this.marks = marks;
    }

    public void setCorrect()
    {
        isCorrect = true;
    }

    public boolean getCorrect()
    {
        return isCorrect;
    }

        public Person getAuthor()
    {
        return this.author;
    }

    public String getType()
    {
        return type;
    }
    public String getAnswer()
    {
        if(this.type.equals("Assignment"))
            return filename;
        else return answer;
    }

    public void setGraded(boolean graded)
    {
        this.isGraded = graded;
    }

    public boolean getGraded()
    {
        return isGraded;
    }

    public void setGradedBy(Person person)
    {
        this.gradedBy = person;
    }

    public Person getGradedBy()
    {
        return this.gradedBy;
    }


}
