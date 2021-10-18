package classes.Lectures;

import classes.Human.Instructor;
import classes.Human.Person;
import java.util.Date;

public class Slides implements Lecture {
    private String type;
    private Date date;
    private Instructor author;
    private String topic;
    private int numSlides;
    private String[] content;

    public Slides(Instructor author, String topic, int numSlides, String[] content) {

        this.date = new Date();
        this.author = author;
        this.topic = topic;
        this.numSlides = numSlides;
        this.content = content;
        this.type = "Slides";
    }

    @Override
    public void showData() {
        System.out.println("Title : " + topic + "\n");
        for(int i = 0; i < numSlides; i++)
            System.out.println("Slide " + (i + 1) + ": " + content[i] + "\n");
        System.out.println("Date of Upload : " + date + "\n");
        System.out.println("Uploaded by : " + author.getId() + "\n");
    }
}
