package Classes;

public class Singleton extends Matrix{
    private int mat;

    Singleton(int mat){

        this.mat = mat;
        this.rows = 1;
        this.column = 1;
        this.isNull = false;
        this.isId = false;
        this.isSquare = true;
        this.isRect = false;
        this.isSingular = (mat == 0);
        this.isDiag = true;
        this.isScalar = true;
        this.isSys = true;
        this.isSkew = false;
        this.isUpTri = false;
        this.isDownTri = false;
        this.isRow = true;
        this.isCol = true;
        this.isSingleton = true;
        this.isOnes = (mat == 1);

    }

    public int getMat()
    {
        return mat;
    }

    public void setMat(int mat)
    {
        this.mat = mat;
    }

}
