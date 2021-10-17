import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        Scanner sc =  new Scanner(System.in);

        int x;

        do {
            System.out.println("""
                    Welcome to Backpack
                    1. Enter as instructor
                    2. Enter as a student
                    3. Exit
                                    
                    Enter choice
                    """);

            x = sc.nextInt();


            switch(x)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;

                default:
                    System.out.println("please enter correct choice");
            }
        }while(x != 3);
    }
}
