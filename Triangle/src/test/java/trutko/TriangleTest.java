package trutko;



import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TriangleTest {

    @Test(expected = IllegalArgumentException.class)
    public void allSidesZero(){
        Boolean result =Triangle.isTriangleExist(0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void allSidesNegative(){
        Boolean result =Triangle.isTriangleExist(-9.58, -9.58, -3.47);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideZero(){
        Boolean result =Triangle.isTriangleExist(0, 5.57, 6.48);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideNegative(){
        Boolean result =Triangle.isTriangleExist(-6.34, 6.34, 4.78);
    }

    @Test
    public void equilateralTriangle(){
        assertTrue(Triangle.isTriangleExist(5.5, 5.5, 5.5));
    }

    @Test
    public void isoscelesTriangle(){
        assertTrue(Triangle.isTriangleExist(5.5, 5.5, 4.7));
    }

    @Test
    public void versatileTriangle(){
        assertTrue(Triangle.isTriangleExist(3.56, 5.3, 7.48));
    }

    @Test
    public void oneSideMuchLargeThenSumOfOther(){
        assertFalse(Triangle.isTriangleExist(3.38, 4.56, 150.98));
    }

    @Test
    public void oneSideLightlyLargeThenSumOfOther(){
        assertFalse(Triangle.isTriangleExist(5.3, 4.7, 10.1));
    }

    @Test
    public void oneSideEqualToSumOfOther(){
        assertFalse(Triangle.isTriangleExist(5.5, 5.5, 11.0));
    }
}