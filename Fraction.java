import java.util.Objects;

public class Fraction {
    private int num;
    private int denom;

    public Fraction(int num, int denom) {
        if(denom == 0) {
            throw new IllegalArgumentException("The Denominator cannot be Zero");
        } else if (denom <= 0) {
            this.denom = denom * -1;
            this.num = num * -1;
        } else {
            this.denom = denom;
            this.num = num;
        }
    }
    public Fraction(int num) {
        this.denom = 1;
        this.num = num;
    }
    public Fraction() {
        this.denom = 1;
        this.num = 0;
    }

    public int getNumerator() {
        return this.num;
    }
    public int getDenominator() {
        return this.denom;
    }
    public String toString() {
        return num + "/" + denom;
    }
    public double getDouble() {
        double num = this.num;
        return num/this.denom;
    }
    public Fraction add(Fraction Other) {
        int num = (this.num * Other.denom) + (Other.num * this.denom);
        int denom = this.denom * Other.denom;
        toLowestTerms(num,denom);
        Fraction temp = new Fraction(num,denom);
        return temp;
    }
    public Fraction subtract(Fraction Other) {
        int num = (this.num * Other.denom) - (Other.num * this.denom);
        int denom = this.denom * Other.denom;
        toLowestTerms(num,denom);
        Fraction temp = new Fraction(num,denom);
        return temp;
    }
    public Fraction multiply(Fraction Other) {
        int num = this.num * Other.num;
        int denom = this.denom * Other.denom;
        toLowestTerms(num,denom);
        Fraction temp = new Fraction(num,denom);
        return temp;
    }
    public Fraction divide(Fraction Other) {
        if(this.denom == 0 || Other.denom == 0 ) {
            throw new IllegalArgumentException("You cannot divide by Zero!!!!");
        } else {
            int num = this.num * Other.denom;
            int denom = this.denom * Other.num;
            toLowestTerms(num,denom);
            Fraction temp = new Fraction(num,denom);
            return temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num &&
                denom == fraction.denom;
    }
    private static int gdc(int num, int denom) {
        if( denom == 0) {
            return num;
        } else {
            return gdc(denom, num % denom);
        }
    }
    private void toLowestTerms(int num, int denom) {
        int gdc = gdc(num,denom);
        if(gdc != 0) {
            this.num /= gdc;
            this.denom /= gdc;
            if (this.denom < 0) {
                this.denom *= -1;
                this.num *= -1;
            }
        }
    }
}
