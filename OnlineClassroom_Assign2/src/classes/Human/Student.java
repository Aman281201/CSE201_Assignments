package classes.Human;

import classes.Evaluation.Assessment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Person {

    private String id;
//    private HashMap<Assessment,Submission> submissions = new HashMap<>();
    private ArrayList<Submission> submitted;
    private ArrayList<Assessment> pending = new ArrayList<>();

    public Student(String id)
    {
        this.id = id;
        this.submitted = new ArrayList<>();
    }

    public void addPending(Assessment assessment)
    {
        pending.add(assessment);
    }

    public void removePending(int id)
    {
        pending.remove(id);
    }

    public void showPending()
    {
        for(int i = 0 ; i < pending.size(); i++)
        {
            pending.get(i).showData(i);
            System.out.println("________________\n");
        }
    }

    public Assessment getPending(int id)
    {
        return pending.get(id);
    }

    @Override
    public String getId()
    {
        return id;
    }

    public ArrayList<Submission> getSubmissions()
    {
        return submitted;
    }

    @Override
    public void showMenu() {
        System.out.println("""
                                    
                    (Student menu)
                    1. View lecture materials
                    2. View assessment
                    3. Submit assessment
                    4. View grades
                    5. View comments
                    6. Add comments
                    7. Logout
                                    
                    Enter your choice
                    """);
    }


    public void getComments() {

    }

    public void setComments() {
    }

    public void getLectures() {
    }

    public void setLectures() {
    }
}