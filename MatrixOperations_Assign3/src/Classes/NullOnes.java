package Classes;

public class NullOnes extends Matrix {

    public NullOnes(int r, int c, boolean isOnes){
        this.rows = r;
        this.column = c;

        if(!isOnes) {
            this.isNull = true;
            this.isOnes = false;
        }
        else {
            this.isOnes = false;
            this.isNull = true;
        }

        this.isId = false;
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

            if((this.isNull && this.isSquare) || (this.isOnes && !(this.isSingleton)))
                this.isSingular = true;
            else isSingular = false;

            this.isSys = true;

            if(isNull)
            {this.isScalar = true;
            this.isDownTri = true;
            this.isUpTri = true;
            this.isSkew = true;}
            else {
                if (isSingleton && this.isOnes)
                {this.isScalar = true;
                 this.isDownTri = true;
                 this.isUpTri = true;
                 this.isSkew = false;
                }
                else{
                    this.isScalar = false;
                    this.isDownTri = false;
                    this.isUpTri = false;
                    this.isSkew = false;
                }
            }

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
