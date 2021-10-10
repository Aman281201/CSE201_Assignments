package classes;

public class User {
    public String name;
    int age;
    String userID;
    public Status status;
    Boolean eligible;

    public User(String n, int a, String uID, Boolean elig)
    {
        name = n;
        age = a;
        userID = uID;
        eligible = elig;

        status = new Status("REGISTERED",null,0,0);
    }
    public void setStatus(String st, Vaccine vac, int dose, int nd)
    {
        status = new Status(st,vac,dose,nd);
    }
}
