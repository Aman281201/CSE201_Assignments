package classes;

public interface Person {
    void getComments();
    void setComments();
    void getLectures();
    void setLectures();
    void showMenu();
}


class Instructor implements Person
{
    @override
    public void showMenu()
    {
        System.out.println("""
                1.
                """);
    }

    public void getComments(){

    }

    public void setComments(){}

    public void getLectures(){}

    public void setLectures(){}

}

class Student implements Person
{
    @override
    public void showMenu()
    {
        System.out.println("""
                1.
                
                """);
    }

    public void getComments(){

    }

    public void setComments(){}

    public void getLectures(){}

    public void setLectures(){}
}