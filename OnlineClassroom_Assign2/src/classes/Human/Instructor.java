package classes.Human;

public class Instructor implements Person {
    String id;

    public Instructor(String id) {
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }

    public void showMenu() {
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
