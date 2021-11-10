package Classes;

public class Identity extends Matrix{

    Identity(int r, int c){
        this.rows = r;
        this.column = c;
        this.isNull = false;
        this.isId = true;
        this.isSquare = true;
        this.isRect = false;
        this.isSingular = false;
        this.isDiag = true;
        this.isScalar = true;
        this.isSys = true;
        this.isSkew = false;
        this.isUpTri = true;
        this.isDownTri = true;

        //this.isOnes = false;
        if(r==1) {
            this.isRow = true;
            this.isCol = true;
            this.isSingleton = true;
            this.isOnes = true;
        }

        else {
            this.isRow = false;
            this.isCol = false;
            this.isSingleton = false;
            this.isOnes = false;
        }


        }
}
