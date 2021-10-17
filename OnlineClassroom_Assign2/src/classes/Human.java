package classes;

public class Human {
    public interface Person {
        String getId();

        void getComments();

        void setComments();

        void getLectures();

        void setLectures();

        void showMenu();
    }


    public static class Instructor implements Person {
        String id;

        public Instructor(String id) {
            this.id = id;
        }

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

    public static class Student implements Person {

        String id;

        public Student(String id)
        {
            this.id = id;
        }

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
}