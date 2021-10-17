package classes;

import java.util.ArrayList;

public class Hospital {
    public String name;
    String pincode;
    public int uniqueID;
    public ArrayList<Slots> slots = new ArrayList<Slots>();

    public Hospital(String n, String pc, int uID)
    {
        name = n;
        pincode = pc;
        uniqueID = uID;
    }
    public void addSlots(Slots s)
    {
        slots.add(s);
    }
}
