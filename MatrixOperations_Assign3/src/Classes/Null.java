package Classes;

public class Null extends Matrix {

    Null(int r, int c){
        this.rows = r;
        this.column = c;
        this.isNull = true;
        this.isId = false;
        this.isOnes = false;
        if(r==1)
            this.isRow = true;
        else this.isRow = false;

        if(c==1)
            this.isCol = true;
        else this.isCol = false;

        if(this.isCol && this.isRow)
            this.isSingleton = true;
        else this.isSingleton = false;

        if(r == c) {
            this.isSquare = true;
            this.isRect = false;
            this.isDiag = true;
            this.isSingular = true;
            this.isScalar = true;
            this.isDownTri = true;
            this.isUpTri = true;
            this.isSys = true;
            this.isSkew = true;
        }
        else {
            this.isRect = true;
            this.isSquare = false;
            this.isDiag = false;
            this.isSingular = false;
            this.isScalar = false;
            this.isSys = false;
            this.isSkew = false;
            this.isDownTri = false;
            this.isUpTri = false;
        }

    }

}
