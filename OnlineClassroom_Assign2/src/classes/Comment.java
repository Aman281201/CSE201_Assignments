package classes;

import classes.Human.Human;

import java.util.Date;

public class Comment {
    private Date createdAt;
    private String body;
    private Human createdBy;

    Comment(String body, Human person)
    {
        createdAt = new Date();
        this.body = body;
        createdBy = person;
    }


}
