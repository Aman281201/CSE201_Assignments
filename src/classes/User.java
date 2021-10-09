package classes;

public class User {
    String name;
    int age;
    String userID;
    Status status;
    Boolean eligible;

    public User(String n, int a, String uID, Boolean elig)
    {
        name = n;
        age = a;
        userID = uID;
        eligible = elig;

        status = new Status("REGISTERED","NA",0,0);
    }
    void setStatus(String st, String vac, int dose, int nd)
    {
        status = new Status(st,vac,dose,nd);
    }
}
