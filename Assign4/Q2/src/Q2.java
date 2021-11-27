import java.util.Scanner;

public class Q2 {

    public static Scanner sc = new Scanner(System.in);

    interface Image
    {
        void showData();
        void update();
        //int[][] generate();
        void negative();
    }

    class GreyscaleImage implements Image
    {
        int r;
        int c;
        String[][] image;

        GreyscaleImage(int[][] matrix, int r, int c)
        {
            this.r = r;
            this.c = c;
            this.image = new String[r][c];

            for(int i = 0 ; i < r; i++)
                for(int j = 0; j < c; j++)
                {this.image[i][j] = String.format("%08d", Integer.parseInt(Integer.toString(matrix[i][j], 2), 10));}

        }

        @Override
        public void showData()
        {
            for(int i =0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    System.out.println();
            }
        }

        @Override
        public void update()
        {}

        @Override
        public void negative()
        {

        }

        public int[][] generate()
        {
        }
    }

    class ColouredImage implements Image
    {
        int r;
        int c;
        String[][][] image;

        ColouredImage(int[][][] matrix, int r, int c)
        {
            this.r = r;
            this.c = c;
            this.image = new String[r][c][3];
            for(int i = 0; i < r; i++)
                for(int j  =0; j < c; j++)
                    for(int k = 0 ; k < 3; k++)
                        this.image[i][j][k] = String.format("%08d", Integer.parseInt(Integer.toString(matrix[i][j][k], 2), 10));
        }


        @Override
        public void showData()
        {}

        @Override
        public void update()
        {}

        @Override
        public void negative()
        {

        }

        public int[][][] generate()
        {
        }
    }

    // functions

    public static void getInput(boolean isColoured)
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

                switch (op) {
                    case 1->getInput(choice==2);
                    case 2->generate(choice==2);
                    case 3->display(choice==2);
                    case 4->update(choice==2);
                    case 5->makeNegative(choice==2);
                    case 6->break;
                }
            }

        System.out.println("closing photoshop");



    }
}
