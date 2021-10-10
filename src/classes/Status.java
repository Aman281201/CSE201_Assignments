package classes;

public class Status  {
    public String curStatus;
    public Vaccine vaccine;
    public int doses;
    int nextDose;

    public Status(String st, Vaccine vac, int dose, int nd)
    {
        curStatus = st;
        vaccine = vac;
        doses = dose;
        nextDose = nd;
    }
}
