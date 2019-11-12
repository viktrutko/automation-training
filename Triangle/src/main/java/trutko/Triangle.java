package trutko;

public class Triangle {

    private static final String ZERO_OR_NEGATIVE_LENGTH_SIDE = "The side of the triangle can't have a length equal to or less than zero";

    public static boolean isTriangleExist(double a, double b, double c){

        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException(ZERO_OR_NEGATIVE_LENGTH_SIDE);
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}