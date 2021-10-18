package classes.Human;

public class Student implements Person {

    String id;

    public Student(String id)
    {
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }

    public void showMenu() {


        System.out.println("""
                                    
                    (Student menu)
                    1. View lecture materials
                    2. View assessment
                    3. Submit assessment
                    4. View grades
                    5. View comments
                    6. Add comments
                    7. Logout
                                    
                    Enter your choice
                    """);
    }

    public void getComments() {

    }

    public void setComments() {
    }

    public void getLectures() {
    }

    public void setLectures() {
    }
}