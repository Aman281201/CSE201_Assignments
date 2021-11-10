import Classes.Diagonal;
import Classes.Matrix;
import Classes.Singleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Matrix> matrices = new ArrayList<>();
    public static ArrayList<Matrix> SqMat = new ArrayList<>();
    public static ArrayList<Matrix> RectMat = new ArrayList<>();
    public static ArrayList<Matrix> SymMat = new ArrayList<>();
    public static ArrayList<Matrix> SkewMat = new ArrayList<>();

    public static void printMatrix(Matrix matrix)
    {
        if(matrix.getNull())
        {
            for(int i = 0; i < matrix.getRow(); i++)
                {
                    for(int j = 0; j < matrix.getCollumn(); j++)
                        System.out.println(0 + "\t");

                    System.out.println("\n");
                }
            System.out.println("\n");
            return;
        }
         if(matrix.getOnes())
         {
             for(int i = 0; i < matrix.getRow(); i++)
             {
                 for(int j = 0; j < matrix.getCollumn(); j++)
                     System.out.println(1 + "\t");

                 System.out.println("\n");
             }
             System.out.println("\n");
             return;
         }

         if(matrix.getSingleton())
         {
             System.out.println(((Singleton)matrix).getMat() + "\n");
             return;
         }

         if(matrix.getId())
         {
             for(int i = 0; i < matrix.getRow(); i++)
             {
                 for(int j = 0; j < matrix.getCollumn(); j++)
                     if(i == j)
                         System.out.println(1 + "\t");
                     else System.out.println(0 + "\t");

                 System.out.println("\n");
             }
             System.out.println("\n");
             return;
         }
         if(matrix.getDiag())
         {
             ArrayList<Integer> d = ((Diagonal)matrix).getDiagonal();
             for(int i = 0; i < matrix.getRow(); i++)
             {
                 for(int j = 0; j < matrix.getCollumn(); j++)
                     if(i == j)
                         System.out.println( d.get(i) + "\t");
                     else System.out.println(0 + "\t");

                 System.out.println("\n");
             }
             System.out.println("\n");
             return;
         }

    }
    public static void printMenu()
    {
        System.out.println("""
                1.  Take Matrix as input
                2.  Create matrices of requested types
                3.  Change matrix element
                4.  Display all the labels of matrix
                5.  Perform addition subtraction or multiplication
                6.  Perform element wise operations
                7.  Transpose matrix
                8.  Invert matrix
                9.  Compute mean
                10. Compute determinant
                11. Use singleton as scalars
                12. Compute the sum of matrix and its transpose
                13. Compute eigen vectors and values (only 2x2 matrix)
                14. Solve sets of linear equations
                15. Retrieve all matrix having requested label
                16. Exit
                """);
    }

    public static void getInput()
    {
        int r, c, x, count0 = 0, count1 = 0, countId = 0;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        System.out.println("enter the total number of rows in the matrix");
        r = sc.nextInt();
        System.out.println("enter the total number of columns in the matrix");
        c = sc.nextInt();
        System.out.println("enter the next " + (r*c) + " entries of the matrix");
        for(int i  = 0; i < r; i++) {
            mat.add(new ArrayList<>());
            for (int j = 0; j < c; j++) {
                x = sc.nextInt();
                mat.get(i).add(x);

                if (x == 0)           // for null matrix
                    count0++;
                else if (x == 1)
                    count1++;

                if(r == c)
                {
                    // identity scalar triangular
                    if (i != j && x != 0)
                        countId++;
                }

            }
        }

        // assigning labels to objects
        //if()

    }


    public static void getTransSum()
    {
        System.out.println("choose the matrix\n");
        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.printf(i + ")   ");
            printMatrix(matrices.get(i));
        }

        int choice = sc.nextInt();

        Matrix ch = matrices.get(choice);

        if(ch.getRect())
        {
            System.out.println("Rectangular matrices cannot be transposed and added to self please choose square matrix");
            return;
        }




    }
    public static void main(String[] args)
    {
        System.out.println("Welcome to matrix hub\n");
        int res;
        do
        {
            printMenu();
            res = sc.nextInt();

            switch (res)
            {
                case 1: getInput();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12: getTransSum();
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                default:
                    System.out.println("please enter the correct choice");
            }

        }while(res != 16);
    }
}
