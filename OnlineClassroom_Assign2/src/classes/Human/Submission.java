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
//    private boolean isOpen;
    private Person gradedBy;

    Submission(String answer, Assessment assessment, Person author)
    {
        this.answer = answer;
        this.assessment = assessment;
        this.author = author;
        this.type = "Quiz";
        this.isCorrect = false;
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

    public  void setCorrect()
    {
        isCorrect = true;
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

}
