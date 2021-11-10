package Classes;

import java.util.ArrayList;

public class DiagonalScalar extends Matrix{
    private ArrayList<Integer> mat ;
    private int scalarFactor;

    public DiagonalScalar(int r, int c, ArrayList<Integer> mat, boolean scalar){

        this.mat = mat;
        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = false;
        this.isSquare = true;
        this.isRect = false;
        this.isSingular = false;
        this.isDiag = true;
        this.isSys = true;
        this.isSkew = false;
        this.isUpTri = true;
        this.isDownTri = true;

        if(scalar)
        {
            isScalar = true;
            scalarFactor = mat.get(0);
        }
        else isScalar = false;


        this.isRow = false;
        this.isCol = false;
        this.isSingleton = false;
        this.isOnes = false;

    }
    public ArrayList<Integer> getDiagonal()
    {
        return this.mat;
    }

    public void setDiagonal(ArrayList<Integer> d)
    {
         this.mat = d;
    }


}
