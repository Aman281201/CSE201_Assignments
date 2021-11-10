package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Square extends Matrix{
    private ArrayList<Integer> matrix = new ArrayList<>();
    Square(int r, int c, ArrayList<Integer> ar, boolean triangular, boolean upper){

        this.matrix = ar;

        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = false;
        this.isSquare = true;
        this.isRect = false;
        this.isSingular = false;
        this.isDiag = false;
        this.isScalar = false;
        this.isSys = false;
        this.isSkew = false;

        if(triangular)
        {
            if(upper)
            {
                this.isUpTri = true;
                this.isDownTri = false;
            }
            else{
                this.isUpTri = false;
                this.isDownTri = true;
            }
        }
        else
        {this.isUpTri = false;
        this.isDownTri = false;}

        this.isRow = false;
        this.isCol = false;
        this.isSingleton = false;
        this.isOnes = false;



    }
}
