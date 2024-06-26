import Classes.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Matrix> matrices = new ArrayList<>();


    public static ArrayList<ArrayList<Integer>> retTranspose(ArrayList<ArrayList<Integer>> m)
    {
        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();

        for(int i  = 0; i < m.size(); i++) {
            trans.add(new ArrayList<>());
            for (int j = 0; j < m.get(0).size(); j++) {
                trans.get(i).add(m.get(j).get(i));
            }
        }
        return trans;
    }

    public static int IsSymSkewSym(ArrayList<ArrayList<Integer>> m )
    {
        int count=0, count0 = 0;
        ArrayList<ArrayList<Integer>> t = retTranspose(m);
        for(int i = 0 ; i < m.size(); i++)
         for (int j = 0 ; j < m.get(0).size(); j++) {
             if (t.get(i).get(j).equals(m.get(i).get(j)))
                 count++;

             if((t.get(i).get(j) + m.get(i).get(j)) == 0)
                 count0++;
         }

         if(count == m.size()*m.get(0).size())
             return 0;

         if(count0 == m.size()*m.get(0).size())
             return 1;

         return -1;
    }

    public static void printMatrix(Matrix matrix)
    {
        if(matrix.getNull())
        {
            for(int i = 0; i < matrix.getRow(); i++)
                {
                    for(int j = 0; j < matrix.getCollumn(); j++)
                        System.out.printf(0 + "\t");

                    System.out.println("\n");
                }
//            System.out.println("\n");
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
             ArrayList<Integer> d = ((DiagonalScalar)matrix).getDiagonal();
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




    public static void printTranspose(Matrix matrix)
    {
        if(matrix.getNull())
        {
            for(int i = 0; i < matrix.getCollumn(); i++)
            {
                for(int j = 0; j < matrix.getRow(); j++)
                    System.out.println(0 + "\t");

                System.out.println("\n");
            }
            System.out.println("\n");
            return;
        }
        if(matrix.getOnes())
        {
            for(int i = 0; i < matrix.getCollumn(); i++)
            {
                for(int j = 0; j < matrix.getRow(); j++)
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
            ArrayList<Integer> d = ((DiagonalScalar)matrix).getDiagonal();
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

    public static int getDet(ArrayList<ArrayList<Integer>> mat, int n)
    {

            int num1, num2, det = 1, index, total = 1,w;

            int[] temp = new int[n + 1];


            for (int i = 0; i < n; i++) {
                index = i;


                while (mat.get(index).get(i) == 0 && index < n) {
                    index++;
                }
                if (index == n)
                    continue;

                if (index != i) {
                    for (int j = 0; j < n; j++) {
                        w = mat.get(index).get(j);
                        mat.get(index).set(j,(mat.get(i).get(j)));
                        mat.get(i).set(j, w);
                    }
                    det = (int)(det * Math.pow(-1, index - i));
                }

                for (int j = 0; j < n; j++) {
                    temp[j] = mat.get(i).get(j);
                }

                for (int j = i + 1; j < n; j++) {
                    num1 = temp[i];
                    num2 = mat.get(j).get(i);

                    for (int k = 0; k < n; k++) {
                        mat.get(j).set(k , num1 * mat.get(j).get(k) - num2 * temp[k]);
                    }
                    total = total * num1;
                }
            }

            for (int i = 0; i < n; i++) {
                det = det * mat.get(i).get(i);
            }
            return (det / total);
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
        int r, c, x, count0 = 0, count1 = 0, countId = 0, countScalar = 0, temp = 0, countUp =0, countLow=0;
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
                    if(i == j)
                    {
                        if(i == 0) {
                            temp = x;
                            countScalar++;
                        }
                        else if (x == temp)
                            countScalar++;
                    }

                    if(i>j && x==0)
                        countUp++;
                    if(i<j && x ==0)
                        countLow++;
                }

            }
        }

        // assigning labels to objects
        if(count0 == r*c)
        {
            NullOnes m = new NullOnes(r,c,false);
            matrices.add(m);
        }
        else if(count1 == r*c)
        {
            NullOnes m = new NullOnes(r,c,true);
            matrices.add( m);
        }
        else if(r == c) {
            if (countId == 0 && count1 == 3) {
                Identity m = new Identity(r, c);
                matrices.add(m);
            }
            else if (r == 1) {
                Singleton m = new Singleton(mat.get(0).get(0));
                matrices.add(m);
            }
            else if (countId == r * c - r) {

                ArrayList<Integer> d = new ArrayList<>();
                for(int z = 0; z < r; z++)
                    d.add(mat.get(z).get(z));

                if (countScalar == r) {
                    DiagonalScalar m = new DiagonalScalar(r, c,d , true);
                    matrices.add(m);
                }
                else {
                    DiagonalScalar m = new DiagonalScalar(r,c,d,false);
                    matrices.add(m);
                }
            }
            else {
                int det ;
                det = getDet(mat,r);
                if(IsSymSkewSym(mat) == 0)
                {SquareSymSkewSingTri m = new SquareSymSkewSingTri(r,c,mat,false,false,true,false,det);
                    matrices.add(m);
                }
                else if(IsSymSkewSym(mat) == 1)
                {
                    SquareSymSkewSingTri m = new SquareSymSkewSingTri(r,c,mat,false,false,false,true,det);
                    matrices.add(m);
                }
                else if(countUp == (r*r - r)/2)
                {
                    SquareSymSkewSingTri m = new SquareSymSkewSingTri(r,c,mat,true,true,false,false,det);
                    matrices.add(m);
                }
                else if(countLow == (r*r - r)/2)
                {
                    SquareSymSkewSingTri m = new SquareSymSkewSingTri(r,c,mat,true,false,false,false,det);
                    matrices.add(m);
                }
                else
                {SquareSymSkewSingTri m = new SquareSymSkewSingTri(r,c,mat,false,false,false,false,det);
                    matrices.add(m);
                }


            }
        }
        else{
            if(r == 1)
            {
                RowCol m = new RowCol(r,c,mat.get(0),true);
                matrices.add( m);
            }
            else if (c == 1)
            {
                ArrayList<Integer> col = new ArrayList<>();
                for(int k = 0; k < c; k++)
                    col.add(mat.get(0).get(k));
                RowCol m = new RowCol(r,c,col,false);
                matrices.add( m);
            }
            else{
                Rectangle m = new Rectangle(r,c,mat);
                matrices.add(m);
            }
        }
    }





    public static void makeMatrix()
    {
        System.out.println("choose which of the following matrix you want to make\n");
        System.out.println("""
                1. Null
                2. Ones
                3. Identity
                4. Singular
                5. Singleton
                6. Scalar
                7. Diagonal
                8. Lower Triangular
                9. Upper Triangular
                10. Symmetric
                11. Skew-Symmetric
                12. Square
                13. Row
                14. Column
                15. Rectangular
                """);
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1 : NullOnes n = new NullOnes(2,2,false);
                        matrices.add(n);
                        break;

            case 2 : NullOnes o = new NullOnes(2,2,true);
                        matrices.add(o);
                        break;
            case 3 : Identity i = new Identity(3,3);
                matrices.add(i);
                break;

            case 4 :
                ArrayList<ArrayList<Integer>> s1 = new ArrayList<>();
                s1.add(new ArrayList<Integer>());
                s1.get(0).add(3);
                s1.get(0).add(2);
                s1.add(new ArrayList<Integer>());
                s1.get(1).add(6);
                s1.get(0).add(4);

                SquareSymSkewSingTri sg = new SquareSymSkewSingTri(2,2,s1,false,false,false,false,0);
                matrices.add(sg);
                break;

            case 5 : Singleton st = new Singleton(4);
                     matrices.add(st);
                        break;
            case 6 : ArrayList<Integer> s2 = new ArrayList<>();
                    s2.add(5);
                    s2.add(5);
                    s2.add(5);
                    DiagonalScalar sc = new DiagonalScalar(3,3,s2,true);
                    matrices.add(sc);
                    break;

            case 7 : ArrayList<Integer> s3 = new ArrayList<>();
                s3.add(4);
                s3.add(5);
                s3.add(6);
                DiagonalScalar d = new DiagonalScalar(3,3,s3,true);
                matrices.add(d);
                break;

            case 8 :
                ArrayList<ArrayList<Integer>> s4 = new ArrayList<>();
                s4.add(new ArrayList<Integer>());
                s4.get(0).add(1);
                s4.get(0).add(2);
                s4.add(new ArrayList<Integer>());
                s4.get(1).add(0);
                s4.get(0).add(3);

                SquareSymSkewSingTri lm = new SquareSymSkewSingTri(2,2,s4,true,false,false,false,getDet(s4,2));
                matrices.add(lm);
                break;

            case 9 :
                ArrayList<ArrayList<Integer>> s5 = new ArrayList<>();
                s5.add(new ArrayList<Integer>());
                s5.get(0).add(1);
                s5.get(0).add(0);
                s5.add(new ArrayList<Integer>());
                s5.get(1).add(2);
                s5.get(0).add(3);

                SquareSymSkewSingTri um = new SquareSymSkewSingTri(2,2,s5,true,true,false,false,getDet(s5,2));
                matrices.add(um);
                break;

            case 10 :
                ArrayList<ArrayList<Integer>> s6 = new ArrayList<>();
                s6.add(new ArrayList<Integer>());
                s6.get(0).add(1);
                s6.get(0).add(3);
                s6.add(new ArrayList<Integer>());
                s6.get(1).add(3);
                s6.get(0).add(1);

                SquareSymSkewSingTri sym = new SquareSymSkewSingTri(2,2,s6,false,false,true,false,getDet(s6,2));
                matrices.add(sym);
                break;

            case 11 :
                ArrayList<ArrayList<Integer>> s7 = new ArrayList<>();
                s7.add(new ArrayList<Integer>());
                s7.get(0).add(0);
                s7.get(0).add(3);
                s7.add(new ArrayList<Integer>());
                s7.get(1).add(-3);
                s7.get(0).add(0);

                SquareSymSkewSingTri skm = new SquareSymSkewSingTri(2,2,s7,false,false,false,true,getDet(s7,2));
                matrices.add(skm);
                break;

            case 12 :
                ArrayList<ArrayList<Integer>> s8 = new ArrayList<>();
                s8.add(new ArrayList<Integer>());
                s8.get(0).add(1);
                s8.get(0).add(2);
                s8.add(new ArrayList<Integer>());
                s8.get(1).add(3);
                s8.get(0).add(4);

                SquareSymSkewSingTri sqm = new SquareSymSkewSingTri(2,2,s8,false,false,false,true,getDet(s8,2));
                matrices.add(sqm);
                break;

            case 13 :
                ArrayList<Integer> s9 = new ArrayList<>();
                s9.add(1);
                s9.add(2);
                s9.add(3);
                s9.add(4);
                RowCol rm = new RowCol(1,4,s9,true);
                matrices.add(rm);
                break;

            case 14 :
                ArrayList<Integer> s10 = new ArrayList<>();
                s10.add(1);
                s10.add(2);
                s10.add(3);
                s10.add(4);
                RowCol cm = new RowCol(4,1,s10,false);
                matrices.add(cm);
                break;

            case 15 :
                ArrayList<ArrayList<Integer>> s11 = new ArrayList<>();
                s11.add(new ArrayList<Integer>());
                s11.get(0).add(1);
                s11.get(0).add(2);
                s11.get(0).add(5);
                s11.add(new ArrayList<Integer>());
                s11.get(1).add(3);
                s11.get(0).add(4);
                s11.get(0).add(6);

                Rectangle rcm = new Rectangle(2,3,s11);
                matrices.add(rcm);
                break;

        }

    }




    public static void updateElement()
    {
        System.out.println("choose the matrix\n");

        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.println(i + ")   ");
            printMatrix(matrices.get(i));
        }

        int choice = sc.nextInt();

        Matrix ch = matrices.get(choice);

        if(ch.getNull() == true) {
            System.out.println("element of null matrix can't be updated");
            return;
        }
        if(ch.getOnes() == true) {
            System.out.println("element of ones matrix can't be updated");
            return;
        }
        if(ch.getSingleton() == true) {

            System.out.println("Enter the new element");
            int input = sc.nextInt();
            ((Singleton)ch).setMat(input);
            System.out.println("element updated");
            return;
        }

        if(ch.getId() == true) {
            System.out.println("element of Identity Matrix cant be updated");
            return;
        }

        if(ch.getScalar() == true) {
            System.out.println("single element of scalar matrix can't be updated");
            return;
        }

        if(ch.getSingular() == true)
        {
            System.out.println("Singular Matrix can't be updated");
        }

        if(ch.getDiag() == true) {
            System.out.println("only Diagonal elements can be updated");
            System.out.println("enter the position of diagonal element (should be in range 0 to " + ch.getRow() + " )");
            int ind = sc.nextInt();
            System.out.println("enter the new element");
            int input = sc.nextInt();
            ArrayList<Integer> q =((DiagonalScalar)ch).getDiagonal();
            q.set(ind,input);
            ((DiagonalScalar)ch).setDiagonal(q);
            return;
        }

        if(ch.getDownTri() == true) {
            System.out.println("co-ordinated must be in the range 0 to " + ch.getRow());
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x < y) {
                System.out.println("element to be updated has to be in upper half\n");
                return;
            }
            System.out.println("Enter the new element");
            int n = sc.nextInt();
            ((SquareSymSkewSingTri) ch).update(x, y, n);
            ((SquareSymSkewSingTri) ch).setDet(getDet(((SquareSymSkewSingTri) ch).getMat(), ch.getRow()));
        }

        if(ch.getUpTri() == true) {
            System.out.println("co-ordinated must be in the range 0 to " + ch.getRow());
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > y) {
                System.out.println("element to be updated has to be in upper half\n");
                return;
            }
            System.out.println("Enter the new element");
            int n = sc.nextInt();
            ((SquareSymSkewSingTri)ch).update(x,y,n);
            ((SquareSymSkewSingTri) ch).setDet(getDet(((SquareSymSkewSingTri) ch).getMat(),ch.getRow()));
        }

        if(ch.getSquare() == true) {
            System.out.println("Enter the x co-ordinate and y co-ordinate of element to update");
            System.out.println("co-ordinated must be in the range 0 to " + ch.getRow());
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Enter the new element");
            int n = sc.nextInt();
            ((SquareSymSkewSingTri)ch).update(x,y,n);
            ((SquareSymSkewSingTri) ch).setDet(getDet(((SquareSymSkewSingTri) ch).getMat(),ch.getRow()));
        }
        if(ch.getSkew() == true) {
            System.out.println("single element can't be updated");
            return;
        }
        if(ch.getSys() == true) {
            System.out.println("only diagonal elements can be updated for Symmetric Matrix");

            return;
        }
        if(ch.getIsRow() == true) {
            {
                System.out.println("enter the position of element (should be in range 0 to " + ch.getRow() + " )");
                int ind = sc.nextInt();
                System.out.println("enter the new element");
                int input = sc.nextInt();
                ArrayList<Integer> q =((RowCol)ch).getMat();
                q.set(ind,input);
                ((RowCol)ch).setMat(q);
                return;
            }

        }
        if(ch.getIsCol() == true) {
            System.out.println("enter the position of element (should be in range 0 to " + ch.getCollumn() + " )");
            int ind = sc.nextInt();
            System.out.println("enter the new element");
            int input = sc.nextInt();
            ArrayList<Integer> q = ((RowCol) ch).getMat();
            q.set(ind, input);
            ((RowCol) ch).setMat(q);
            return;
        }
        if(ch.getRect() == true){
            System.out.println("Enter the x co-ordinate and y co-ordinate of element to update");
            System.out.println("x co-ordinated must be in the range 0 to " + ch.getRow());
            System.out.println("y co-ordinate must be in range 0 to " + ch.getCollumn());
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Enter the new element");
            int n = sc.nextInt();
            ((Rectangle)ch).update(x,y,n);
        }
    }






    public static void dispLabels()
    {
        System.out.println("choose the matrix\n");

        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.println(i + ")   ");
            printMatrix(matrices.get(i));
        }

        int choice = sc.nextInt();

        Matrix ch = matrices.get(choice);

        System.out.println("Selected matrix has following properties");

        if(ch.getNull() == true)
            System.out.println("Null Matrix");
        if(ch.getOnes() == true)
            System.out.println("Ones Matrix");
        if(ch.getSingleton() == true)
            System.out.println("Singleton Matrix");
        if(ch.getId() == true)
            System.out.println("Identity Matrix");
        if(ch.getDiag() == true)
            System.out.println("Diagonal Matrix");
        if(ch.getScalar() == true)
            System.out.println("Scalar Matrix");
        if(ch.getDownTri() == true)
            System.out.println("Lower Triangular Matrix");
        if(ch.getUpTri() == true)
            System.out.println("Upper Triangular");
        if(ch.getSquare() == true)
            System.out.println("Square Matrix");
        if(ch.getSkew() == true)
            System.out.println("Skew-Symmetric Matrix");
        if(ch.getSys() == true)
            System.out.println("Symmetric Matrix");
        if(ch.getIsRow() == true)
            System.out.println("Row Matrix");
        if(ch.getIsCol() == true)
            System.out.println("Column Matrix");
        if(ch.getRect() == true)
            System.out.println("Rectangular Matrix");
        if(ch.getSingular() == true)
            System.out.println("Singular Matrix");
        System.out.println("\n\n");
    }



    public static void addSubMul()
    {

    }



    public static void elementWiseOp()
    {

    }



    public static void getTranspose()
    {
        System.out.println("choose the matrix\n");
        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.println(i + ")   ");
            printMatrix(matrices.get(i));
        }

        int choice = sc.nextInt();

        Matrix ch = matrices.get(choice);

        printTranspose(ch);

    }

    public static void getInvert()
    {

    }

    public static void findMean()
    {

    }

    public static void singltonAsScalar()
    {

    }

    public static void findDet()
    {
        System.out.println("choose the matrix\n");

        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.println(i + ")   ");
            printMatrix(matrices.get(i));
        }

        int choice = sc.nextInt();

        Matrix ch = matrices.get(choice);

        System.out.println("Determinant of the matrix is");
        if(ch.getSquare() == true) {
            if (ch.getNull() == true) {
                System.out.println("0");
            }

            if (ch.getSingleton() == true) {
                System.out.println(((Singleton)(ch)).getMat());
            }
            if (ch.getOnes() == true) {
                System.out.println("0");
            }
            if (ch.getId() == true) {
                System.out.println("1");
            }
            if (ch.getDiag() == true) {
                System.out.println("Diagonal Matrix");
            }
            if (ch.getScalar() == true) {
                System.out.println("Scalar Matrix");
            }
            if (ch.getSingular() == true) {
                System.out.println("0");
            }
            else {
                System.out.println(((SquareSymSkewSingTri)(ch)).getDet());
            }


        }
        else {
            System.out.println("Determinant doesnt exist");
        }
        System.out.println("\n\n");
    }

    public static void getTransSum()
    {
        System.out.println("choose the matrix\n");
        for(int i = 0 ; i < matrices.size(); i++)
        {   System.out.println(i + ")   ");
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

    public static void findEigen()
    {

    }

    public static void SolveLinEq()
    {

    }
    public static void getMatFromLabel()
    {

    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to matrix hub\n");
        int res;
        do
        {
            printMenu();
            res = sc.nextInt();

            switch (res) {
                case 1 -> getInput();
                case 2 -> makeMatrix();
                case 3 -> updateElement();
                case 4 -> dispLabels();
                case 5 -> addSubMul();
                case 6 -> elementWiseOp();
                case 7 -> getTranspose();
                case 8 -> getInvert();
                case 9 -> findMean();
                case 10 -> findDet();
                case 11 -> singltonAsScalar();
                case 12 -> getTransSum();
                case 13 -> findEigen();
                case 14 -> SolveLinEq();
                case 15 -> getMatFromLabel();
                case 16 -> System.out.println("exiting matrix hub");
                default -> System.out.println("please enter the correct choice");
            }

        }while(res != 16);
    }
}
