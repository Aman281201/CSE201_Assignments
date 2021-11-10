package Classes;

public class Matrix {

    protected int rows;
    protected int column;
    protected boolean isNull;
    protected boolean isOnes;
    protected boolean isId;
    protected boolean isSingleton;
    protected boolean isScalar;
    protected boolean isDiag;
    protected boolean isSys;
    protected boolean isSkew;
    protected boolean isUpTri;
    protected boolean isDownTri;
    protected boolean isSingular;
    protected boolean isSquare;
    protected boolean isRect;
    protected boolean isRow;
    protected boolean isCol;

    public int getRows()
    {return rows;}

    public void setRows(int r)
    {this.rows = r;}

    public int getCollumn()
    {return column;}

    public void setCollumn(int c)
    {this.column = c;}

    public boolean getNull()
    {return isNull;}

    public boolean getOnes()
    { return isOnes;}

    public boolean getScalar()
    {return isScalar;}

    public boolean getId()
    { return isId;}

    public boolean getSingleton()
    {return isSingleton;}

    public boolean getDiag()
    {return isDiag;}

    public boolean getSys()
    {return isSys;}

    public boolean getSkew()
    {return isSkew;}

    public boolean getUpTri()
    {return isUpTri;}

    public boolean getDownTri()
    {return isDownTri;}

    public boolean getSingular()
    {return isSingular;}

    public boolean getSquare()
    {return isSquare;}

    public boolean getRect()
    {return isCol;}

    public int getRow()
    {return rows;}

    public boolean getIsRow()
    {return isRow;}

    public boolean getIsCol()
    {return isCol;}

}
