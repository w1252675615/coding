package Offer.Q16_Power;

public class Power {
    public double powerOfInt(double base, int exponent) {
        if (equal(0.0,base) && exponent < 0) return Double.NaN;
        if (exponent < 0) return 1.0/powerWithUnsignedInt(base,-exponent);
        else return powerWithUnsignedInt(base,exponent);
    }
    private double powerWithUnsignedInt(double base,  int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powerWithUnsignedInt(base,exponent>>1);
        result *= result;
        if((exponent & 1)==1) result *= base;
        return result;
    }
    boolean equal(double a, double b) {
        return Math.abs(a-b) < 0.000001;
    }

    public static void main(String[] args) {
        Power power = new Power();
    }
}
