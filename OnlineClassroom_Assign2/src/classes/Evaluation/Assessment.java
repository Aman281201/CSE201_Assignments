package classes.Evaluation;

import classes.Human.Submission;

import java.util.ArrayList;

public interface Assessment {
        void showData(int i);
        void addSubmissions(Submission sub);
        String getType();
        ArrayList<Submission> getSubmissions();
        boolean getIsOpen();
        void close();
    }