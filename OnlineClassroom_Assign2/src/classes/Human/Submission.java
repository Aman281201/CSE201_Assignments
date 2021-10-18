package classes.Human;

import classes.Evaluation.Assessment;

public class Submission {
    Assessment assessment;
    String answer;
    String filename;
    Person author;

    Submission(String answer, Assessment assessment, Person author)
    {
        this.answer = answer;
        this.assessment = assessment;
        this.author = author;
    }

    Submission(Assessment assessment, String filename, Person author)
    {
        this.assessment = assessment;
        this.filename = filename;
        this.author = author;
    }
}
