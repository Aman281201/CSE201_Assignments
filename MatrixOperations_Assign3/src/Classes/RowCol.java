package Classes;

import java.util.ArrayList;

public class RowCol extends Matrix{

    private ArrayList<Integer> mat;


    public RowCol(int r, int c, ArrayList<Integer> mat, boolean isRow){

        this.mat = mat;
        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = false;
        this.isSquare = false;
        this.isRect = true;
        this.isSingular = false;
        this.isDiag = false;
        this.isSys = false;
        this.isSkew = false;
        this.isUpTri = false;
        this.isDownTri = false;
        this.isScalar = false;
        this.isSingleton = false;
        this.isOnes = false;

        if(isRow)
        {
            this.isRow = true;
            this.isCol = false;
        }

        else {
            this.isRow = false;
            this.isCol = true;
        }



    }
    public ArrayList<Integer> getMat()
    {
        return this.mat;
    }
    public void set(ArrayList<Integer> m)
    {
        this.mat = m;
    }

}
