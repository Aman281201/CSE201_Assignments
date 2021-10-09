package classes;

import java.util.ArrayList;

public class Vaccine {
    String name;
    int no_of_doses;
    int gap;
    ArrayList<Hospital> hospitals = new ArrayList<Hospital>();

    public Vaccine(String n, int dose, int gp)
    {
        name = n;
        no_of_doses = dose;
        gap = gp;
    }

    public void addHospital(Hospital H)
    {
        hospitals.add(H);
    }
}
