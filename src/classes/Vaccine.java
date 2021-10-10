package classes;

import java.util.ArrayList;

public class Vaccine {
    public String name;
    public int no_of_doses;
    public int gap;
    public ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
    ArrayList<Slots> slots = new ArrayList<Slots>();

    public Vaccine(String n, int dose, int gp)
    {
        name = n;
        no_of_doses = dose;
        gap = gp;
    }

    public void addHospitalSlots(Hospital H, Slots s)
    {
        hospitals.add(H);
        slots.add(s);
    }

}
