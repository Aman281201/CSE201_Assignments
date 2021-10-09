package classes;

public class Status  {
    String curStatus;
    String vaccine;
    int doses;
    int nextDose;

    Status(String st, String vac, int dose, int nd)
    {
        curStatus = st;
        vaccine = vac;
        doses = dose;
        nextDose = nd;
    }
}
