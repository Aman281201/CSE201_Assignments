package classes.Lectures;

import classes.Human.Human;

import java.util.Date;

public class Video implements Lecture {

    private Date date;
    private String topic;
    private String filename;
    private Human.Instructor author;
    private String type;

    public Video(String topic, String filename, Human.Instructor author) {
        this.date = new Date();
        this.topic = topic;
        this.filename = filename;
        this.author = author;
        this.type = "Video";
    }

    @Override
    public void showData() {
        System.out.println("Title of Video : " + topic + "\n");
        System.out.println("Video file : " + filename + "\n");
        System.out.println("Date of Upload : " + date + "\n");
        System.out.println("Uploaded by : " + author.getId() + "\n");
    }
}