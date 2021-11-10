package Classes;

import java.util.ArrayList;

public class SquareSymSkewSingTri extends Matrix{
    private ArrayList<ArrayList<Integer>> mat;
    private int det;

    public SquareSymSkewSingTri(int r, int c, ArrayList<ArrayList<Integer>> ar, boolean triangular, boolean upper, boolean Sym, boolean Skew, int det){

        this.mat = ar;
        this.det = det;
        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = false;
        this.isSquare = true;
        this.isRect = false;

        if(det == 0)
            this.isSingular = true;
        else this.isSingular = false;

        this.isDiag = false;
        this.isScalar = false;
        this.isSys = Sym;
        this.isSkew = Skew;

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

    public ArrayList<ArrayList<Integer>> getMat()
    {
        return this.mat;
    }

    public void update(int x, int y, int update)
    {
        this.mat.get(x).set(y, update);
    }

    public int getDet()
    {
        return det;
    }
    public void setDet(int det)
    {
        this.det = det;
    }
}
