package classes;

import java.util.ArrayList;

public class Hospital {
    String name;
    String pincode;
    int uniqueID;
    ArrayList<Slots> slots = new ArrayList<Slots>();

    public Hospital(String n, String pc, int uID)
    {
        name = n;
        pincode = pc;
        uniqueID = uID;
    }
    void addSlots(Slots s)
    {
        slots.add(s);
    }
}
