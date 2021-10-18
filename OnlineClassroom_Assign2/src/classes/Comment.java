package classes;

import classes.Human.Person;

import java.util.Date;

public class Comment {
    private Date createdAt;
    private String body;
    private Person createdBy;

    Comment(String body, Person person)
    {
        createdAt = new Date();
        this.body = body;
        createdBy = person;
    }


}
