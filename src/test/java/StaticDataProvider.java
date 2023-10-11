import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "dataForFunction")
    public static Object[][] dataForFunction() {
        return new Object[][] {
                {1, 6.4},
                {1.4, 1.325},
                {2, 3.586}
        };
    }

    @DataProvider(name = "dataForFillX")
    public static Object[][] dataForFillX() {
       return new Object[][]{
               {2, 0.004},
               {6, 0.012},
               {12, 0.024}
       };
    }

    @DataProvider(name = "dataForFillY")
    public static Object[][] dataForFillY() {
        return new Object[][] {
                {0, 4},
                {700, 1.325},
                {1000, 3.586}
        };
    }
}
