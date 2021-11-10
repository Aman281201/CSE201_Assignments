package Classes;

import java.util.ArrayList;

public class Rectangle extends Matrix {
    private ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

    public Rectangle(int r, int c, ArrayList<ArrayList<Integer>> ar) {

        this.mat = ar;
        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = false;
        this.isSquare = false;
        this.isRect = true;
        this.isSingular = false;
        this.isDiag = false;
        this.isScalar = false;
        this.isSys = false;
        this.isSkew = false;

        this.isUpTri = false;
        this.isDownTri = false;

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
}
