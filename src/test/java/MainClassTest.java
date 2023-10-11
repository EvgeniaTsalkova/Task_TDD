import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MainClassTest {
    private static final double EPS = 1e-3;
    MainClass mainClass;

    @BeforeMethod
    public void setUp(){
        mainClass = new MainClass();
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFunction")
    public void testCalcFunction(double x, double expected) {
        double actual = mainClass.calcFunction(x);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcSteps() {
        double expected = 1001;
        double actual = mainClass.calcSteps(0.0, 2.0, 0.002);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillX")
    public void testFillX(int index, double expected) {
        double[] array = mainClass.fillX(0.0, 2.0, 0.002);
        double actual = array[index];
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillY")
    public void testFillY(int index, double expected) {
        double[] arrayX = mainClass.fillX(0.0, 2.0, 0.002);
        double[] arrayY = mainClass.fillY(arrayX);
        assertThat(arrayY[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test
    public void testFindMax() {
        double[] testArray = {1.0, 2.0, 3.0, 9.0};
        double expected = 9.0;
        double actual = mainClass.findMax(testArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMin() {
        double[] testArray = {1.0, 2.0, 3.0, 9.0};
        double expected = 1.0;
        double actual = mainClass.findMin(testArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalcSum() {
        double[] testArray = {1.0, 2.0, 3.0, 9.0};
        double expected = 15.0;
        double actual = mainClass.calcSum(testArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalcAvg() {
        double[] testArray = {1.0, 2.0, 3.0, 9.0};
        double expected = 3.75;
        double actual = mainClass.calcAvg(testArray);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test
    public void testFindIndex() {
        double[] testArray = {1.0, 2.0, 3.0, 9.0};
        double value = 3.0;
        int expected = 2;
        int actual = mainClass.findIndex(testArray, value);
        assertEquals(actual, expected);
    }
}