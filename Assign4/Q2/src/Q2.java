import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Q2 {


    public static class genericList <T> {
        private ArrayList<T> list;

        public genericList(){
            list = new ArrayList<>();
        }

        public void add (T obj)
        {
            list.add(obj);
        }

        public T get(int i)
        {
            return list.get(i);
        }

        public void set(int i, T obj)
        {
            list.set(i,obj);
        }
    }



    public static Scanner sc = new Scanner(System.in);
    public static genericList<Image> images = new genericList<>();

    interface Image
    {
        void showData();
        void negative();
        void update(int x, int y, genericList<Integer> up);
    }

    static class GreyscaleImage implements Image
    {
        private int r;
        private int c;
        private genericList<genericList<String>> image;

        GreyscaleImage(genericList<genericList<Integer>> matrix, int r, int c)
        {
            this.r = r;
            this.c = c;
            this.image = new genericList<>();

            for(int i = 0 ; i < r; i++) {
                this.image.add(new genericList<>());
                for (int j = 0; j < c; j++) {
                    this.image.get(i).add(String.format("%08d", Integer.parseInt(Integer.toString(matrix.get(i).get(j), 2), 10)));
                }
            }
        }

        @Override
        public void showData()
        {
            for(int i =0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    {System.out.print(image.get(i).get(j) + " ");}
                System.out.println();
            }
        }

        @Override
        public void update(int x, int y, genericList<Integer> up)
        {
            this.image.get(x).set(y, String.format("%08d", Integer.parseInt(Integer.toString(up.get(0)), 2), 10));
        }

        @Override
        public void negative()
        {

        }

    }

    static class ColouredImage implements Image
    {
        int r;
        int c;
        genericList<genericList<genericList<String>>> image;

        ColouredImage(genericList<genericList<genericList<Integer>>> matrix, int r, int c)
        {
            this.r = r;
            this.c = c;
            this.image = new genericList<>();
            for(int i = 0; i < r; i++){
                image.add(new genericList<>());
                for(int j  =0; j < c; j++){
                    image.add(new genericList<>());
                    for(int k = 0 ; k < 3; k++)
                        this.image.get(i).get(j).add(String.format("%08d", Integer.parseInt(Integer.toString(matrix.get(i).get(j).get(k), 2), 10)));
        }}}


        @Override
        public void showData()
        {
            for(int i =0; i < r; i++) {
                for (int j = 0; j < c; j++)
                {System.out.print(image.get(i).get(j) + " ");}
                System.out.println();
            }
        }


        public void update(int x, int y, genericList<Integer> up)
        {
            for(int i = 0; i < 3; i++)
            this.image.get(x).get(y).set(y, String.format("%08d", Integer.parseInt(Integer.toString(up.get(i)), 2), 10));
        }

        @Override
        public void negative()
        {

        }

    }



    // functions



    public static void getInput(boolean isColoured)
    {
        int r, c;
        Image img;
        System.out.println("Enter the height and width of image respectively in Integers");
        r = sc.nextInt();
        c = sc.nextInt();

        System.out.println("enter the next " + (r*c) + " elements of the matrix");

        if(!isColoured)
        {
            System.out.println("input the grey value");
            genericList<genericList<Integer>> mat = new genericList<>();
            for(int i = 0; i < r; i++) {
                mat.add(new genericList<>());
                for (int j = 0; j < c; j++) {
                    int input = sc.nextInt();
                    mat.get(i).add(input);
                }
            }

            img = new GreyscaleImage(mat,r,c);
        }
        else{

            genericList<genericList<genericList<Integer>>> mat = new genericList<>();
            int red, blue , green;
            for(int i = 0 ; i < r ; i++) {
                mat.add(new genericList<>());
                for (int j = 0; j < c; j++) {
                    mat.get(i).add(new genericList<>());

                    System.out.println("Enter the red value:");
                    red = sc.nextInt();
                    System.out.println("Enter the green value");
                    green = sc.nextInt();
                    System.out.println("Enter the blue value");
                    blue = sc.nextInt();

                    mat.get(i).get(j).add(red);
                    mat.get(i).get(j).add(green);
                    mat.get(i).get(j).add(blue);
                }
            }

            img = new ColouredImage(mat,r,c);
        }

        images.add((Image) img);
    }


    public static void display(boolean isColoured)
    {
        
    }

    public static void update(boolean isColoured)
    {

    }



    public static void generate(boolean isColoured)
    {

    }

    public static void makeNegative(boolean isColoured)
    {

    }

    public static void main(String[] args) {
        System.out.println("welcome to photoshop");

            System.out.println("""
                    choose image type
                    1. Greyscale
                    2. Coloured
                    """);
            int choice = sc.nextInt();

            while(true)
            {
                System.out.println("""
                        choose the operation
                        1. Make a new user generated image
                        2. Make a computer generated image
                        3. See image
                        4. Update image
                        5. Apply Negative effect on image
                        6. Exit
                        """);

                int op = sc.nextInt();

                if(op == 6)
                    break;

                switch (op) {
                    case 1->getInput(choice==2);
                    case 2->generate(choice==2);
                    case 3->display(choice==2);
                    case 4->update(choice==2);
                    case 5->makeNegative(choice==2);
                    default-> System.out.println("please enter the correct choice");
                }
            }

        System.out.println("closing photoshop");

    }
}
