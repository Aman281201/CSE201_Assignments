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
    String name;

    Instructor(String name)
    {
        this.name = name;
    }

    public void showMenu()
    {
        System.out.println("""
                
                (Instructor Menu)
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessments
                7. View comments
                8. Add comments
                9. Logout
                
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
    public void showMenu()
    {
        System.out.println("""
                
                (Student menu)
                1. View lecture materials
                2. View assessment
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout
                
                """);
    }

    public void getComments(){

    }

    public void setComments(){}

    public void getLectures(){}

    public void setLectures(){}
}